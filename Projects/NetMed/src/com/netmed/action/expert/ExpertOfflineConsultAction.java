package com.netmed.action.expert;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.ChinDiseSynoDAO;
import com.netmed.dao.DiagResultDAO;
import com.netmed.dao.SyndSynoDAO;
import com.netmed.dao.MembArchInfoDAO;
import com.netmed.dao.MembConsInfoDAO;
import com.netmed.pojo.ChinDiagDise;
import com.netmed.pojo.ChinDiagSynd;
import com.netmed.pojo.ChinDiseSyno;
import com.netmed.pojo.MembArchInfo;
import com.netmed.pojo.MembConsInfo;
import com.netmed.pojo.SyndSyno;
import com.opensymphony.xwork2.ActionSupport;

public class ExpertOfflineConsultAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 专家处理患者的离线表单
	 * 成功则返回专家中心页面
	 * 错误则返回当前页面
	 * @author larch
	 * 
	 */
	/**定义时间显示格式！！！！**/
	SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy/M/d");
		public String execute() {
			System.out.println("运行到了ExpertOfflineConsultAction---execute");
			String forward = "success";
			// 取得reqeust对象
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = null;
			System.out.println("专家给出诊断结果和建议");
			try {
				request.setCharacterEncoding("gb2312");			
				response.setContentType("text/html;charset=utf-8");	
				out = response.getWriter();
				
				/**从jsp页面获取表单数据，封装成对象consult**/
				MembConsInfo consult = getMembConsInfoFromJsp(request);
				
				/**Spring调用DAO**/
				ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
				MembConsInfoDAO dao = (MembConsInfoDAO)otx.getBean("MembConsInfoDAO");
				DiagResultDAO rDao=(DiagResultDAO)otx.getBean("DiagResultDAO");
				
				/**定义辩证和辨病对象，用以存储辩证和辨病结果**/
				ChinDiagSynd syndrome=new ChinDiagSynd();
				ChinDiagDise disease=new ChinDiagDise();
				
				syndrome.setMembConsInfo(consult);
				disease.setMembConsInfo(consult);
				
				/**从jsp页面获得辨病和辩证结果，需要按照逗号将其拆分某一个具体的病证，并存入辨病表和辩证表中**/
				String suggest1=request.getParameter("suggest1");
				String suggest2=request.getParameter("suggest2");
				
				/**辩证结果拆分**/
				if(suggest1!=null&&!suggest1.equals("")){
					String[] s1=suggest1.split(",");
					for(int i=0;i<s1.length;i++){
						syndrome.setSyndrome(s1[i]);
						rDao.NewSyndrome(syndrome);
					}
				}
				else{
					syndrome.setSyndrome("暂无辩证结果");
					rDao.NewSyndrome(syndrome);
				}
				
				/**辨病结果拆分，按逗号**/
				if(suggest2!=null&&!suggest2.equals("")){
					String[] s2=suggest2.split(",");
					for(int i=0;i<s2.length;i++){
						disease.setDisease(s2[i]);
						rDao.NewDisease(disease);
					}
				}
				else{
					disease.setDisease("暂无辨病结果");
					rDao.NewDisease(disease);
				}
				dao.UpdateConsult(consult);  	/**更新离线咨询表单**/
				out.println("yes");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				forward = "error";	//出错返回当前页面
			} catch (Exception e) {
				e.printStackTrace();
				 forward = "error";
			}finally{
				if(out!=null){
					out.flush();
					out.close();
				}
			}
			return forward;
		}
		
		
		/**
		 * 根据电子病历ID获取患者的电子病历
		 * 修改离线咨询表单
		 * @author larch
		 */
		public String ElectronicRecordForAppend() {
			System.out.println("运行到了服务器----修改---ElectronicRecordForAppend()");
			String forward = "success";
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = null;
			try {
				request.setCharacterEncoding("gb2312");			
				response.setContentType("text/html;charset=utf-8");		
				out = response.getWriter();
				
				/**从jsp页面获取表单数据，封装成对象consult**/
				MembConsInfo consult = getMembConsInfoFromJsp(request);
			
				/**Spring调用DAO**/
				ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
				MembConsInfoDAO dao = (MembConsInfoDAO)otx.getBean("MembConsInfoDAO");
				DiagResultDAO rDao=(DiagResultDAO)otx.getBean("DiagResultDAO");
				
				int consultId=consult.getConsId();
				
				/**得到咨询id，再存入辩证和辨病结果！！**/
				ChinDiagSynd syndrome=new ChinDiagSynd();
				ChinDiagDise disease=new ChinDiagDise();
				syndrome.setMembConsInfo(consult);
				disease.setMembConsInfo(consult);
				
				/**根据离线咨询id得到相应的辨病和辩证结果**/
				List<ChinDiagSynd> syndromeList=rDao.getSyndbyConsultId(consultId);
				List<ChinDiagDise> diseaseList=rDao.getDisebyConsultId(consultId);
				
				/**从jsp页面获取修改过的辨病和辩证结果**/
				String suggest1=request.getParameter("suggest1");
				String suggest2=request.getParameter("suggest2");
				String[] s1=suggest1.split(",");
				String[] s2=suggest2.split(",");
				
				/**辩证结果修改,考虑辩证数目的变化，如果比之前更多，则需要新增对象，如更少，则将多余的置空**/
				for(int k=0;k<syndromeList.size();k++){
					if(suggest1!=null&&!suggest1.equals("")){
						
						if(k<s1.length){
							syndromeList.get(k).setSyndrome(s1[k]);
							syndromeList.get(k).setMembConsInfo(consult);
							rDao.UpdateSyndrome(syndromeList.get(k));
						}
					    else{
					    	syndromeList.get(k).setSyndrome("");
					    	syndromeList.get(k).setMembConsInfo(consult);
						    rDao.UpdateSyndrome(syndromeList.get(k));
					    }
				    }
			    }
				for(int i=0;i<(s1.length-syndromeList.size());i++){
					int index=syndromeList.size()+i;
					syndrome.setSyndrome(s1[index]);
					rDao.NewSyndrome(syndrome);
				}
				
				
				/**辨病结果修改,考虑辨病数目的变化，如果比之前更多，则需要新增对象，如更少，则将多余的置空**/
				for(int k=0;k<diseaseList.size();k++){
					if(suggest2!=null&&!suggest2.equals("")){
						
						if(k<s2.length){
							diseaseList.get(k).setDisease(s2[k]);
							diseaseList.get(k).setMembConsInfo(consult);
							rDao.UpdateDisease(diseaseList.get(k));
						}
					    else{
					    	diseaseList.get(k).setDisease("");
					    	diseaseList.get(k).setMembConsInfo(consult);
						    rDao.UpdateDisease(diseaseList.get(k));
					    }
				    }
			    }
				for(int i=0;i<(s2.length-diseaseList.size());i++){
					int index=diseaseList.size()+i;
					disease.setDisease(s2[index]);
					rDao.NewDisease(disease);
				}
				
				/**保存修改的离线咨询表单**/
				dao.UpdateConsult(consult);
				out.println("yes");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			    forward = "error";	//出错返回当前页面
				out.println("no");
			} catch (Exception e) {
				e.printStackTrace();
				forward = "error";
				out.println("no");
			}finally{
				if(out!=null){
					out.flush();
					out.close();	
				}
			}
			return forward;
		}
		
		//获取jsp页面数据，封装成对象！！！
		public MembConsInfo getMembConsInfoFromJsp(HttpServletRequest request){
			/**Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			MembConsInfoDAO dao = (MembConsInfoDAO)otx.getBean("MembConsInfoDAO");
			
			/**离线咨询id**/
			String electronic_record = request.getParameter("electronic_record");
			int id=Integer.parseInt(electronic_record);
			
			/**通过离线咨询id查询离线咨询表单**/
			MembConsInfo consult=dao.FindInfoById(id);
			
			/**回复时间**/
			Timestamp replyTime = new Timestamp(System.currentTimeMillis());
			consult.setReplTime(replyTime);
			
			/**专家意见**/
			String medical_advice = request.getParameter("medical_advice");
			consult.setDiagReco(medical_advice);
			
			/**设置表单已处理**/
			consult.setState(true);
			return consult;
			
		}
		
	/**
	 * 根据专家Id获取未读的离线表单信息
	 * 电子病历号，患者Id，咨询时间
	 * @return 是否成功
	 */
	public String getBriefList() {
		System.out.println("运行到了服务器-----getBriefList()");
		String forward = "success";
		
		// 取得reqeust对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			/**通过session获取专家id**/
			String expename = new String(session.get("expename").toString().getBytes("iso8859-1"), "utf-8");
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			MembConsInfoDAO dao = (MembConsInfoDAO)otx.getBean("MembConsInfoDAO");
			List<MembConsInfo> membConsList=dao.FindInfoByExpertIdWeiDu(expename);
			
			/**定义json对象和数组，用以将数据返回jsp页面**/
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			JSONObject member=null;
			for(int i=0;i<membConsList.size();i++){
				member=new JSONObject();
				
				/**离线咨询id**/
				member.put("electronic_record", membConsList.get(i).getConsId());
				/**患者id**/
				String userId=membConsList.get(i).getMembRegi().getMembId();
				member.put("userId", userId);
				/**咨询人姓名**/
				member.put("consultName", membConsList.get(i).getRelationship());
				
				/**病情简介，控制显示长度，当长度大于15，只返回前15个描述词**/
				if(membConsList.get(i).getIllnDesc().length()>15){
					member.put("brief", membConsList.get(i).getIllnDesc().substring(0, 15));
				}else				{
					member.put("brief", membConsList.get(i).getIllnDesc());
				}
				//咨询时间
				String showTime=timeFormat.format(membConsList.get(i).getConsTime());
				member.put("time",showTime);
				array.add(member);
			}
			json.put("acount", membConsList.size());   /**未处理离线咨询数目**/
			json.put("OfflineConsultArray", array);
			out = response.getWriter();
			out.println(json.toString());

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			forward = "error";	     // 出错返回当前页面
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";  	// 出错返回当前页面
		}
		out.flush();
		out.close();
		return forward;
	}
	
	
		/**
		 * 根据专家Id获取已读的离线表单信息
		 * 电子病历号，患者Id，咨询时间
		 * @return 是否成功
		 */
		public String getBriefListForRead() {
			System.out.println("运行到了getBriefListForRead()----myservice.jsp");
			String forward = "success";
			// 取得reqeust对象
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = null;
			Map<String, Object> session = ServletActionContext.getContext()
					.getSession();
			try {
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				
				/**通过session获取专家id**/
				String expename = new String(session.get("expename").toString().getBytes("iso8859-1"), "utf-8");
				
				/**Spring调用DAO**/
				ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
				MembConsInfoDAO dao = (MembConsInfoDAO)otx.getBean("MembConsInfoDAO");
				List<MembConsInfo> membConsList=dao.FindInfoByExpertIdYiDu(expename);
				
				JSONObject json = new JSONObject();
				JSONArray array = new JSONArray();
				JSONObject member=null;
				for(int i=0;i<membConsList.size();i++){
					member=new JSONObject();
					/**离线咨询id**/
					member.put("electronic_record", membConsList.get(i).getConsId());

					/**会员id和咨询人姓名**/
					member.put("userId", membConsList.get(i).getMembRegi().getMembId());
					member.put("consultName", membConsList.get(i).getRelationship());
					
					/**病情简介，控制显示长度，当长度大于15，只返回前15个描述词**/
					if(membConsList.get(i).getIllnDesc().length()>15){
						member.put("brief", membConsList.get(i).getIllnDesc().substring(0, 15));
					}else				{
						member.put("brief", membConsList.get(i).getIllnDesc());
					}
					//咨询时间
					String showTime=timeFormat.format(membConsList.get(i).getConsTime());
					member.put("time",showTime);
					array.add(member);
				}
				json.put("acount", membConsList.size());
				json.put("OfflineConsultArray", array);
				out = response.getWriter();
				out.println(json.toString());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				forward = "error";// 出错返回当前页面
			} catch (Exception e) {
				e.printStackTrace();
				forward = "error";
			}
			out.flush();
			out.close();
			return forward;
		}
		
		
	/**
	 *  根据离线咨询ID读取详情
	 * @author larch
	 */
	public String getElectronicRecordForRead() {
		System.out.println("运行到了getElectronicRecordForRead--专家读取电子病历详情");
		// 取得reqeust对象
		String forward = "error";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		JSONObject fileName=new JSONObject();
		JSONArray fileArray=new JSONArray();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			//电子病历号
			String electronic_record = request.getParameter("electronic_record");
			int id=Integer.parseInt(electronic_record);
		
			/**Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			MembConsInfoDAO dao = (MembConsInfoDAO)otx.getBean("MembConsInfoDAO");
			DiagResultDAO diagDAO=(DiagResultDAO)otx.getBean("DiagResultDAO");
			
			// 根据电子病历号，获取电子病历信息相关信息
			MembConsInfo membConsInfo=dao.FindInfoById(id);
			//患者姓名
			json.put("userId", membConsInfo.getMembRegi().getMembId());
			//病情描述
			json.put("illn_desc", membConsInfo.getIllnDesc());
			//家族病史
			json.put("fami_hist", membConsInfo.getFamiHist());
			//个人病史
			json.put("pers_hist", membConsInfo.getPersHist());
			
			
			//辩证结果和辨病结果
			List<ChinDiagSynd> syndList=diagDAO.getSyndbyConsultId(id);
			List<ChinDiagDise> diseList=diagDAO.getDisebyConsultId(id);
			StringBuffer syndBuf=new StringBuffer();
			StringBuffer diseBuf=new StringBuffer();
			
			/**对辩证结果和辨病结果的输出做一个约束，如果结果大于1个，中间加空格**/
			for(int i=0;i<syndList.size();i++){
				if(i==0){
					syndBuf.append(syndList.get(i).getSyndrome()+" ");
				}else{
					syndBuf.append(" "+syndList.get(i).getSyndrome()+" ");
				}
			}
			for(int i=0;i<diseList.size();i++){
				if(i==0){
					diseBuf.append(diseList.get(i).getDisease()+" ");
				}else{
					diseBuf.append(" "+diseList.get(i).getDisease()+" ");
				}
			}
			json.put("medeical_zheng", syndBuf.toString());   /**辩证结果**/
			json.put("medeical_disease", diseBuf.toString()); /**辨病结果**/
			
			//诊疗建议
			json.put("medical_advice", membConsInfo.getDiagReco());
			
			//得到文件的个数和文件的名字
			if(dao.isHaveFile(id)){
				
				/**通过离线咨询id找到附件名，通过/进行划分，最多3个附件**/
				String []files=dao.FindInfoById(id).getFilenames().split("/");
				json.put("fileAccount",files.length);
				for(int i=0;i<files.length;i++){
					String tempFile=files[i];
					fileName.put("fileName",tempFile);
					fileArray.add(fileName);
				}
			}
			else{
				fileName.put("fileName", "用户没有上传附件");
				fileArray.add(fileName);
				json.put("fileAccount", 0);
			}
			
			json.put("file", fileArray);
			out = response.getWriter();
			out.println(json.toString());
			forward = "success";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
		}
		
		out.flush();
		out.close();
		return forward;
	}
	
	
	/**
	 *  根据电子病历ID获取患者的电子病历
	 * @author larch
	 */
	public String getElectronicRecord() {
		System.out.println("运行到了getElectronicRecord,专家读取离线表单");
		// 取得reqeust对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		JSONObject fileName=new JSONObject();
		JSONArray fileArray=new JSONArray();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//电子病历号
			String electronic_record = request.getParameter("electronic_record");
			int id=Integer.parseInt(electronic_record);
			// 根据电子病历号，获取电子病历信息相关信息
			//MembConsInfo membConsInfo=new MembConsInfo();
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			MembConsInfoDAO dao = (MembConsInfoDAO)otx.getBean("MembConsInfoDAO");
			MembConsInfo membConsInfo=dao.FindInfoById(id);
			//
			json.put("userId", membConsInfo.getMembRegi().getMembId());
			//病情描述
			json.put("illn_desc", membConsInfo.getIllnDesc());
			//家族病史
			json.put("fami_hist", membConsInfo.getFamiHist());
			//个人病史
			json.put("pers_hist", membConsInfo.getPersHist());
			//得到文件的个数和文件的名字
			if(dao.isHaveFile(id)){
				String []files=dao.FindInfoById(id).getFilenames().split("/");
				json.put("fileAccount",files.length);
				for(int i=0;i<files.length;i++){
					String tempFile=files[i];
					fileName.put("fileName",tempFile);
					fileArray.add(fileName);
				}
			}
			else{
				fileName.put("fileName", "用户没有上传附件");
				fileArray.add(fileName);
				json.put("fileAccount", 0);
			}
			
			json.put("file", fileArray);
			out = response.getWriter();
			out.println(json.toString());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.flush();
		out.close();

		String forward = "success";
		return forward;
	}
	/**
	 * 二级联动 中医症状
	 * 
	 * @author larch
	 * 
	 */
	
	
	/**** 获得辩证结果 ***/
	public String getMidecalZheng() {
		System.out.println("获得辩证结果---getMidecalZheng");
		// 取得reqeust对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String midecalZheng = request.getParameter("midecalZheng");
			//这里需要修改，我需要的是编号和名称  ,这里应该是一个MAP
			Map<String,String> map=new HashMap<String,String>(); //获取二级列表列表
			map=secondInitSynd(midecalZheng);
			
			JSONArray array = new JSONArray();
			JSONObject member = new JSONObject();
			//对应的第二大类的个数
			
			Set set=map.entrySet();
			Iterator iter=set.iterator();
			while(iter.hasNext()){
				Map.Entry<String, String> entry=(Map.Entry<String, String>)iter.next();
				member.put("value", entry.getKey());
				member.put("name", entry.getValue());
				array.add(member);
			}
			json.put("MidecalZhengArray", array);
			out = response.getWriter();

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println(json.toString());
		out.flush();
		out.close();
		
		String forward = "success";
		return forward;
	}
	
	
	/**** 获得辨病结果 ***/
	public String getMidecalDisease() {
		System.out.println("获得辩证结果---getMidecalDisease");
		// 取得reqeust对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String midecalDisease = request.getParameter("midecalDisease");
			//这里需要修改，我需要的是编号和名称  ,这里应该是一个MAP
			Map<String,String> map=new HashMap<String,String>(); //获取二级列表列表
			map=secondInitDisease(midecalDisease);
			
			JSONArray array = new JSONArray();
			JSONObject disease = new JSONObject();
			//对应的第二大类的个数
			
			Set set=map.entrySet();
			Iterator iter=set.iterator();
			while(iter.hasNext()){
				Map.Entry<String, String> entry=(Map.Entry<String, String>)iter.next();
				disease.put("value", entry.getKey());
				disease.put("name", entry.getValue());
				array.add(disease);
			}
			json.put("MidecalDiseaseArray", array);
			out = response.getWriter();

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println(json.toString());
		out.flush();
		out.close();
		
		String forward = "success";
		return forward;
	}

	/**
	 * 从数据库获取证的二级列表
	 */
	public Map<String,String> secondInitSynd(String midecalZheng) {
		HashMap<String, String> map=new HashMap<String,String>(); 
		
		// 添加证候二级列表
		ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
		SyndSynoDAO dao = (SyndSynoDAO)otx.getBean("SyndSynoDAO");
		List<SyndSyno> list = dao.querySecondType(midecalZheng);
		System.out.println("证候第二大类的数目：" + list.size());
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i).getSyndId(),list.get(i).getSyndName());
		}
		return map;
	}
	
	/**
	 * 从数据库获取中医疾病的二级列表
	 */
	public Map<String,String> secondInitDisease(String midecalDisease) {
		HashMap<String, String> map=new HashMap<String,String>(); 
		
		// 添加中医疾病二级列表
		ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ChinDiseSynoDAO dao= (ChinDiseSynoDAO)otx.getBean("ChinDiseSynoDAO"); 
		List<ChinDiseSyno> list = dao.querySecondType(midecalDisease);
		System.out.println("中医疾病第二大类的数目：" + list.size());
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i).getChinDiseId(),list.get(i).getChinDiseName());
		}
		return map;
	}
	
	/**获取咨询患者的详细电子病历信息**/
    public String getArchInfoForDoctorRead() {
		System.out.println("运行到了ExpertOfflineConsultAction-----getArchInfoForRead");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String forward = "success";
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");

			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			MembArchInfoDAO dao = (MembArchInfoDAO) otx.getBean("MembArchInfoDAO");
			MembConsInfoDAO dao1 = (MembConsInfoDAO) otx.getBean("MembConsInfoDAO");
			// 就医经验文章信息表id
			String electronic_record = request.getParameter("electronic_record");
			System.out.println("离线咨询表单号："+electronic_record);
			int electronic_record_id=Integer.parseInt(electronic_record);
			MembConsInfo consult=dao1.FindInfoById(electronic_record_id);
			
			String memb_id = consult.getMembRegi().getMembId();
			String relationship = consult.getRelationship().toString();
			
			// ---------------------------------------------------------------------------------------
			List<MembArchInfo> archInfo=dao.findDetail(memb_id, relationship);
			JSONObject info = null;
			// --------------------------------------------------------------------------------------
			// id
			JSONArray array = new JSONArray();
			for (int i = 0; i < archInfo.size(); i++) {
				info = new JSONObject();
		
			info.put("ArchInfo_Id", archInfo.get(i).getArchId());
			
			// 名字,此处的名字是血压记录的名字，而不是会员的名字
			info.put("name", archInfo.get(i).getName().toString());
			
			String strSex="";
			if(archInfo.get(i).getSex()){
				strSex="female";
			}else{
				strSex="male";
			}
			String marriage="";
			if(archInfo.get(i).getMariStat()){
				marriage="married";  /**已婚为true**/
			}else{
				marriage="Nmarried";
			}
			/**医保类型！！*/
			
			String type = archInfo.get(i).getInsuranceType().toString(); 
			String meditype  = "";
			if("湖南省职工医保".equals(type)){      
				meditype  = "1";
			}else if("大学生医保".equals(type)){
				meditype  = "2";
			}
			else if("城镇医疗保险".equals(type)){
				meditype  = "3";
			}else{
				meditype  = "4";
			}
			
			/**证件类型*/
			String licence = "";
			String licence1 = archInfo.get(i).getLicenceType().toString();
			if("身份证".equals(licence1)){      
				licence = "idCardNumber1";
			}else if("老年证".equals(licence1)){      
				licence = "idCardNumber2";
			}else{
				licence = "idCardNumber3";
			}
			info.put("licence", licence);
			info.put("meditype", meditype);
			info.put("mariStat", marriage);
			info.put("province", archInfo.get(i).getProvince().toString());
			info.put("city",archInfo.get(i).getCity().toString());
			info.put("county", archInfo.get(i).getCounty().toString());
			info.put("sex", strSex);
			String strAge=archInfo.get(i).getAge().toString();
			info.put("age", strAge);
			info.put("idCardNumber", archInfo.get(i).getIdCardNumb().toString());
			info.put("address",archInfo.get(i).getAddress().toString());
			info.put("occupation", archInfo.get(i).getOccupation().toString());
			info.put("telephone", archInfo.get(i).getMobiPhonNumb().toString());
			info.put("guomin",archInfo.get(i).getDrugFoodAlle().toString());
			info.put("fami_hist", archInfo.get(i).getFamiHist().toString());
			info.put("pers_hist", archInfo.get(i).getPersHist().toString());
			
			array.add(info);
			}
			json.put("ArchArray", array);
			out = response.getWriter();
			out.println(json.toString());

			forward = "success";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
		}

		out.flush();
		out.close();
		return forward;
	}
    
    public String getPatientInfo()
    {
    	System.out.println("运行到了ExpertOfflineConsultAction-----getPatientInfo");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String forward = "success";
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");

			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			MembArchInfoDAO dao = (MembArchInfoDAO) otx.getBean("MembArchInfoDAO");
			MembConsInfoDAO dao1 = (MembConsInfoDAO) otx.getBean("MembConsInfoDAO");
			// 就医经验文章信息表id
			String electronic_record = request.getParameter("electronic_record");
			int electronic_record_id=Integer.parseInt(electronic_record);
			MembConsInfo consult=dao1.FindInfoById(electronic_record_id);
			
			String memb_id = consult.getMembRegi().getMembId();
			String relationship = consult.getRelationship().toString();
			
			// ---------------------------------------------------------------------------------------
			List<MembArchInfo> archInfo=dao.findDetail(memb_id, relationship);
			JSONObject info = null;
			// --------------------------------------------------------------------------------------
			// id
			JSONArray array = new JSONArray();
			for (int i = 0; i < archInfo.size(); i++) {
				info = new JSONObject();
		
			info.put("name", archInfo.get(i).getName().toString());
			String strSex="";
			if("true".equals(archInfo.get(i).getSex().toString())){
				strSex="女";
			}else{
				strSex="男";
			}
			info.put("sex", strSex);
			info.put("age", archInfo.get(i).getAge().toString()+"岁");
			array.add(info);
			}
			json.put("ArchArray", array);
			out = response.getWriter();
			out.println(json.toString());

			forward = "success";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
		}
		out.flush();
		out.close();
		return forward;
    }

}
