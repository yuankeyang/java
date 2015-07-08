package com.netmed.action.member;

import java.io.File;
import java.io.IOException;
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
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.exception.DataException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.DiagResultDAO;
import com.netmed.dao.MembArchInfoDAO;
import com.netmed.dao.MembConsInfoDAO;
import com.netmed.dao.MembFamiDAO;
import com.netmed.dao.MembRegiDAO;
import com.netmed.pojo.ChinDiagDise;
import com.netmed.pojo.ChinDiagSynd;
import com.netmed.pojo.ExpeRegi;
import com.netmed.pojo.ExpeTypeComp;
import com.netmed.pojo.MembArchInfo;
import com.netmed.pojo.MembConsInfo;
import com.netmed.pojo.MembFami;
import com.netmed.pojo.MembRegi;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 离线咨询action，接收离线咨寻表单参数，写入数据库
 * @author Administrator 
 * 05-13
 */
public class OfflineConsultAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	/** 代表上传的文件内容的对象 ,注意一定要和jsp页面的name属性值相同 */
	private File[] attachment;

	/** Struts2约定的代表上传的文件的名 ，前缀一定要和jsp页面的name属性值相同 */
	private String[] attachmentFileName;

	/** Struts2约定的代表上传文件的内容类型(MIME) */
	private String[] attachmentContentType;

	/** 保存文件的目录路径， 通过在action中添加参数param动态设置保存路径！！ */
	private String savePath;
	/**定义时间显示格式！！！！**/
	SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy/M/d");
	public File[] getAttachment() {
		return attachment;
	}

	public void setAttachment(File[] attachment) {
		this.attachment = attachment;
	}

	public String[] getAttachmentFileName() {
		return attachmentFileName;
	}

	public void setAttachmentFileName(String[] attachmentFileName) {
		this.attachmentFileName = attachmentFileName;
	}

	public String[] getAttachmentContentType() {
		return attachmentContentType;
	}

	public void setAttachmentContentType(String[] attachmentContentType) {
		this.attachmentContentType = attachmentContentType;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String DealFormAndFile() throws Exception {

		System.out.println("运行到了离线咨询表单处理action！");
		String FORWARD = "error";
		try {
			// 取得reqeust对象
			HttpServletRequest request = ServletActionContext.getRequest();
			String membId = request.getParameter("memb_id");
			String expeId = request.getParameter("expe_id");
			
			// 下面的这段代码进行文件上传处理,，处理多个附件上传！！！,同一个member的保存地址相同
			// 如果要存放到web服务器中本项目的某个目录下
			// 根据服务器的文件保存地址和原文件名创建目录文件全路径,这里加上了会员的id，便于对会员附件分类！！
			String destPath = ServletActionContext.getServletContext()
					.getRealPath(this.getSavePath())
					+ "\\"+membId+"\\"
					+ membId
					+ "To"
					+ expeId;
			System.out.println("保存文件的路径：" + destPath);
			StringBuffer fileNames = new StringBuffer(""); // 保存文件的名字，多个文件名放在一个String里，用"#"隔开
			try {

				if (attachment != null && attachment.length > 0) {
					for (int i = 0; i < attachment.length; i++) {
						System.out.println("附件个数：" + attachment.length);
						System.out.println("文件的名：" + attachmentFileName[i]);
						if (i == 0) {
							fileNames.append(attachmentFileName[i]);
						} else {
							fileNames.append("/");
							fileNames.append(attachmentFileName[i]);
						}

						System.out.println("文件的内容类型："
								+ attachmentContentType[i]);
						File destFile = new File(destPath,
								attachmentFileName[i]);
						System.out.println("new 一个File成功");
						// 特别奇怪，加上下面两句话，就出差，系统找不到指定路径！！！
						// if (!destFile.exists()) {
						// destFile.createNewFile();
						// }
						FileUtils.copyFile(attachment[i], destFile);
					}
					System.out.println("文件上传成功----存放地址---" + destPath);
				}
			} catch (IOException e) {
				System.out.println("上传多个附件失败！！");
				FORWARD = "error";
				e.printStackTrace();
			}

			// 取得从jsp传递过来的参数
			MembConsInfo consult = getParaFromJsp(request, destPath,
					fileNames.toString());
			// 调用spring中的DAO
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			MembConsInfoDAO dao = (MembConsInfoDAO) otx
					.getBean("MembConsInfoDAO");
			dao.AddConsult(consult); // 添加一次咨询
			System.out.println("离线表单已写入数据库成功！！");
			FORWARD = "success";
		} catch (DataException e) { 
			FORWARD = "error";
			System.out.println("hibernate数据异常处理！！！！！");
			e.printStackTrace();

		}

		return FORWARD;

	}


	// 取得从jsp传递过来的参数
	public MembConsInfo getParaFromJsp(HttpServletRequest request,
			String destPath, String fileNames) {
		MembConsInfo consult = new MembConsInfo();

		// 获取参数如下：咨询时间、会员id，专家id，疾病描述，家族病史，个人病史；主键为自动增长，不用传参

		Timestamp consultTime = new Timestamp(System.currentTimeMillis());
		consult.setConsTime(consultTime);
		consult.setIllnDesc(request.getParameter("illn_desc"));
		consult.setState(false);

		/**存会员信息**/
		MembRegi member = new MembRegi();
		member.setMembId(request.getParameter("memb_id"));
		consult.setMembRegi(member);

		/**存专家信息**/
		ExpeRegi expert = new ExpeRegi();
		String expe_id=request.getParameter("expe_id");
		expert.setExpeId(expe_id);
		consult.setExpeRegi(expert);
		
		/**存专家类型信息,根据专家ID获取类型？？？**/
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		String searchSelect=(String)session.get("searchSelect");
		System.out.println("咨询类型searchSelect:"+searchSelect);
		ExpeTypeComp type=new ExpeTypeComp();
		if(("qiuyi").equals(searchSelect)){
			type.setExpeTypeId(1);
		}else if(("wenyao").equals(searchSelect)){
			type.setExpeTypeId(2);
		}else if(("yangsheng").equals(searchSelect)){
			type.setExpeTypeId(3);   /**??**/
		}else{
			type.setExpeTypeId(1); 
		}
		consult.setExpeTypeComp(type);

		// 保存附件上传地址,和文件名
		consult.setFolder(destPath);
		consult.setFilenames(fileNames);
		
		/***读取咨询患者的姓名**/
		consult.setRelationship(request.getParameter("relationship"));
		
		// 个人病史和家族病史
		consult.setPersHist(request.getParameter("pers_hist"));
		consult.setFamiHist(request.getParameter("fami_hist"));

		return consult;
	}

	// 获取离线信息列表
	/**
	 * 根据专家Id获取未读的离线表单信息 电子病历号，患者Id，咨询时间
	 * 
	 * @return 是否成功
	 */
	public String getBriefListForRead() {
		System.out.println("运行到了OfflineConsultAction----getBriefListForRead");
		String forward = "success";
		//获取request和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		//获取session，以便获得专家id
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");

			// 获取专家id
			String username = new String(session.get("username").toString()
					.getBytes("iso8859-1"), "utf-8");
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			MembConsInfoDAO dao = (MembConsInfoDAO) otx
					.getBean("MembConsInfoDAO");
			DiagResultDAO diagDAO=(DiagResultDAO)otx.getBean("DiagResultDAO");
			//调用FindInfoByMemberIdYiDu方法，获取已读的离线表单信息
			List<MembConsInfo> membConsList = dao
					.FindInfoByMemberIdYiDu(username);
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			JSONObject member = null;
			for (int i = 0; i < membConsList.size(); i++) {

				member = new JSONObject();
				// 电子病历号
				int electronic_record=membConsList.get(i).getConsId();
				member.put("electronic_record", electronic_record);
				//专家id
				member.put("expeId", membConsList.get(i).getExpeRegi().getExpeName());
				//简单介绍
				if(membConsList.get(i).getIllnDesc().length()>10){
					member.put("brief", membConsList.get(i).getIllnDesc().substring(0, 10));
				}else{
					member.put("brief", membConsList.get(i).getIllnDesc());
				}
				
				/**
				 *   这里的证需要到另外一张中医辩证表中读取
				 */
				//辩证结果和辨病结果
				System.out.println("electronic_record="+electronic_record);
				//Spring调用相应DAO
				List<ChinDiagSynd> syndList=diagDAO.getSyndbyConsultId(electronic_record);
				List<ChinDiagDise> diseList=diagDAO.getDisebyConsultId(electronic_record);
				//定义两个字符数组，用来存放辩证结果和辨病结果
				StringBuffer syndBuf=new StringBuffer();
				StringBuffer diseBuf=new StringBuffer();
				for(int j=0;j<syndList.size();j++){
					if(j==0){
						syndBuf.append(syndList.get(j).getSyndrome()+" ");
					}else{
						syndBuf.append(" "+syndList.get(j).getSyndrome()+" ");
					}
				}
				for(int j=0;j<diseList.size();j++){
					if(j==0){
						diseBuf.append(diseList.get(j).getDisease()+" ");
					}else{
						diseBuf.append(" "+diseList.get(j).getDisease()+" ");
					}
				}
				member.put("medeical_zheng", syndBuf.toString());//辨证结果
				member.put("medeical_disease", diseBuf.toString());//辨病结果
				
				// 咨询时间
				String showTime=timeFormat.format(membConsList.get(i).getReplTime());
				member.put("time", showTime);
				array.add(member);
			}
			json.put("acountYD", membConsList.size());
			json.put("OfflineConsultArrayYD", array);

			//调用FindInfoByMemberIdWeiDu方法，获取未读的离线表单信息
			List<MembConsInfo> membConsListWd = dao
					.FindInfoByMemberIdWeiDu(username);
			JSONArray arrayWd = new JSONArray();
			JSONObject memberWd = null;
			for (int i = 0; i < membConsListWd.size(); i++) {
				memberWd = new JSONObject();
				// 电子病历号
				memberWd.put("electronic_record", membConsListWd.get(i).getConsId());
				//专家id
				memberWd.put("expeId", membConsListWd.get(i).getExpeRegi().getExpeName());
				//简单介绍
				if(membConsListWd.get(i).getIllnDesc().length()>10){
					memberWd.put("brief", membConsListWd.get(i).getIllnDesc().substring(0, 10));
				}else{
					memberWd.put("brief", membConsListWd.get(i).getIllnDesc());
				}
				// 咨询时间
				String showTime=timeFormat.format(membConsListWd.get(i).getConsTime());
				memberWd.put("time", showTime);
				arrayWd.add(memberWd);
			}
			json.put("acountWD", membConsListWd.size());
			json.put("OfflineConsultArrayWD", arrayWd);
			out = response.getWriter();
			out.println(json.toString());
			// --------------------------------------------------------------------------
			// 根据电子病历号将相关数据保存到电子病历表中
			//
			// 并设定电子病历表为已处理
			// --------------------------------------------------------------------------

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			// 出错返回当前页面
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
	 * 根据电子病历ID获取患者的电子病历
	 * 
	 * @author larch
	 * 
	 */
	// 数据处理,把注册表单上传的数据存到数据库中
	public String getElectronicRecordForRead() {
		System.out.println("运行到了OfflineConsultAction----getElectronicRecordForRead");
		//取得request对象和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		JSONObject fileName = new JSONObject();
		JSONArray fileArray = new JSONArray();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			// 电子病历号
			String electronic_record = request
					.getParameter("electronic_record");
			int id = Integer.parseInt(electronic_record);
			// 根据电子病历号，获取电子病历信息相关信息
			MembConsInfo membConsInfo = new MembConsInfo();
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			MembConsInfoDAO dao = (MembConsInfoDAO) otx
					.getBean("MembConsInfoDAO");
			DiagResultDAO diagDAO=(DiagResultDAO)otx.getBean("DiagResultDAO");
			//调用FindInfoById方法，利用用户id获取离线表单信息
			membConsInfo = dao.FindInfoById(id);
			// 患者姓名
			json.put("userId", membConsInfo.getExpeRegi().getExpeName());
			json.put("consultName", membConsInfo.getRelationship());
			// 病情描述
			json.put("illn_desc", membConsInfo.getIllnDesc());
			// 家族病史
			json.put("fami_hist", membConsInfo.getFamiHist());
			// 个人病史
			json.put("pers_hist", membConsInfo.getPersHist());
			
			// 认证结果
			/**
			 *   这里的证需要到另外一张中医辩证表中读取
			 */
			
			//定义两个list数组，用来存放辩证结果和辨病结果
			List<ChinDiagSynd> syndList=diagDAO.getSyndbyConsultId(id);
			List<ChinDiagDise> diseList=diagDAO.getDisebyConsultId(id);
			StringBuffer syndBuf=new StringBuffer();
			StringBuffer diseBuf=new StringBuffer();
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
			json.put("medeical_zheng", syndBuf.toString());//辨证结果
			json.put("medeical_disease", diseBuf.toString());//辨病结果
			
			// 诊疗建议
			json.put("medical_advice", membConsInfo.getDiagReco());

			// 得到文件的个数和文件的名字
			if (dao.isHaveFile(id)) {
				String[] files = dao.FindInfoById(id).getFilenames().split("/");
				json.put("fileAccount", files.length);
				for (int i = 0; i < files.length; i++) {
					String tempFile = files[i];
					fileName.put("fileName", tempFile);
					fileArray.add(fileName);
				}
			} else {
				fileName.put("fileName", "用户没有上传附件");
				fileArray.add(fileName);
				json.put("fileAccount", 0);
			}

			json.put("file", fileArray);
			
			out = response.getWriter();
			out.println(json.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		out.flush();
		out.close();

		String forward = "success";
		return forward;
	}
	
	public String getPeopleName() {
		System.out.println("获取咨询患者的姓名-----getPeopleName！");
		String forward = "success";
		//获取request和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject member = new JSONObject();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			out = response.getWriter();
			String memb_id = request.getParameter("memb_id");
			System.out.println("memb_id="+memb_id);
			//定义一个MAP，存放证候二级列表
			Map<String,String> map=new HashMap<String,String>(); 
			map=secondInit(memb_id);
			
			@SuppressWarnings("rawtypes")
			Set set=map.entrySet();
			@SuppressWarnings("rawtypes")
			Iterator iter=set.iterator();
			while(iter.hasNext()){
				@SuppressWarnings("unchecked")
				Map.Entry<String, String> entry=(Map.Entry<String, String>)iter.next();
				member.put("value", entry.getKey());
				member.put("name", entry.getValue());
				array.add(member);
			}
			json.put("PeopleNameArray", array);
			System.out.println(array.get(0));
			forward = "success";
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
		}
		
		out.println(json.toString());
		out.flush();
		out.close();
		
		//return forward;
		return null;
	}
	
	//获取证候二级列表
	public Map<String,String> secondInit(String memb_id) {
		HashMap<String, String> map=new HashMap<String,String>(); 
		
		// 添加证候二级列表
		ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Spring调用相应DAO
		MembFamiDAO dao = (MembFamiDAO)otx.getBean("MembFamiDAO");
		//Spring调用相应DAO
		MembRegiDAO dao1 = (MembRegiDAO)otx.getBean("MembRegiDAO");
		//调用findDetailByMembId方法，利用用户id获取该用户的家属信息
		List<MembFami> list = dao.findDetailByMembId(memb_id);
		//System.out.println("该会员家属的数目：" + list.size());
		
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i).getFamiId().toString(),list.get(i).getFamiName());
		}
		
		//调用getMembinfoById方法，利用用户id获取该用户信息
		MembRegi memb = dao1.getMembinfoById(memb_id);
		String name = memb.getRealName().toString();
		int i = map.size();
		map.put("(i+1)",name );
		return map;
	}
	
	/**获取当前指定咨询患者的病史信息**/
	public String getHistory(){
		System.out.println("进入getHistory---通过会员ID和咨询姓名获取咨询者的病史信息");
		//获取request和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//获取咨询者ID
			String memb_id = request.getParameter("memb_id");
			//获取咨询者姓名
			
			HttpSession session = request.getSession();
			boolean IEorNot = request.getHeader("User-Agent").contains("Trident");
			if(IEorNot){
				session.setAttribute("IEorNot", "1");
			}else{
				session.setAttribute("IEorNot", "0");
			}
			String consultName="";
			if(IEorNot){
				consultName =new String(request.getParameter("consultName").getBytes("iso8859-1"),"gb2312");
			}else{
				consultName =new String(request.getParameter("consultName").getBytes("iso8859-1"),"utf-8");
			}
			
			System.out.println("咨询者ID:"+memb_id);
			System.out.println("咨询者姓名:"+consultName);
			
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			//Spring调用相应DAO
			MembArchInfoDAO dao = (MembArchInfoDAO)otx.getBean("MembArchInfoDAO");
			//调用findDetail方法， 通过会员ID和家属姓名查询电子健康病历详情
			List<MembArchInfo> archInfo=dao.findDetail(memb_id, consultName);
			System.out.println("病史："+archInfo.size());
			if(archInfo.size()>0){
				for(int i=0;i<archInfo.size();i++){
					json.put("personHistory", archInfo.get(i).getPersHist());
					json.put("familyHistory", archInfo.get(i).getFamiHist());
				}
			}else{
				json.put("personHistory", "如有请填写");
				json.put("familyHistory", "如有请填写");
			}
			out = response.getWriter();
		} catch (UnsupportedEncodingException e) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
