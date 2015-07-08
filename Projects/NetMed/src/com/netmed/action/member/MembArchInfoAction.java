package com.netmed.action.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.hibernate.exception.DataException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.MembArchInfoDAO;
import com.netmed.pojo.MembArchInfo;
import com.netmed.pojo.MembRegi;


/**
 * @author Administrator
 * 会员电子健康病历action
 */
public class MembArchInfoAction {
	//新建电子病历档案
	public String NewMembArchInfo(){
		String FORWARD = "error";
		try{
		System.out.println("运行到了--MembArchInfoAction--------NewMembArchInfo");
		//获取request对象
		HttpServletRequest request = ServletActionContext.getRequest();
		//调用getParaFromJsp方法，获取当前页面的对象，参数为request对象
		MembArchInfo archInfo = getParaFromJsp(request);
		ApplicationContext otx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		//Spring调用相应DAO
		MembArchInfoDAO dao = (MembArchInfoDAO) otx
				.getBean("MembArchInfoDAO");
		//调用NewMembArchInfo方法，参数为要新增的电子病历档案对象，返回为非0的新增成功
		if(dao.NewMembArchInfo(archInfo)!=0){
			FORWARD="success";
			System.out.println("会员电子健康病历添加成功");
		}
		else{
			System.out.println("会员电子健康病历添加失败");
		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return FORWARD;
	}
	
	/**
	 * 
	 * @param request
	 * @return  //从jsp页面获取获取电子健康病历对象！！！
	 */
	public MembArchInfo getParaFromJsp(HttpServletRequest request){
		//新建一个电子健康病历对象
		MembArchInfo archInfo=new MembArchInfo();
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		try {
			//通过session得到会员id
			String username = new String(session.get("username").toString()
					.getBytes("iso8859-1"), "utf-8");
			MembRegi memb=new MembRegi();
			//设置电子健康病历表中专家id字段
			memb.setMembId(username);
			archInfo.setMembRegi(memb);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		archInfo.setName(request.getParameter("name"));
		
		if(("male").equals(request.getParameter("sex"))){
			archInfo.setSex(false);    /**男为0，女为1*/
		}
		else{
			archInfo.setSex(true);
		}
		archInfo.setAge(Integer.parseInt(request.getParameter("age")));
		
		/**医保类型！！*/
		if(request.getParameter("meditype").equals("1")){      
			archInfo.setInsuranceType("湖南省职工医保");
		}else if(request.getParameter("meditype").equals("2")){
			archInfo.setInsuranceType("大学生医保");
		}
		else if(request.getParameter("meditype").equals("3")){
			archInfo.setInsuranceType("城镇医疗保险");
		}else{
			archInfo.setInsuranceType("农村医疗保险");
		}
		
		/**证件类型*/
		if(request.getParameter("licence").equals("idCardNumber1")){      
			archInfo.setLicenceType("身份证");
		}else if(request.getParameter("licence").equals("idCardNumber2")){      
			archInfo.setLicenceType("老年证");
		}else{
			archInfo.setLicenceType("残疾证");
		}
		archInfo.setIdCardNumb(request.getParameter("idCardNumber"));
		archInfo.setAddress(request.getParameter("address"));
		archInfo.setProvince(request.getParameter("province"));
		archInfo.setCity(request.getParameter("city"));
		archInfo.setCounty(request.getParameter("county"));
		archInfo.setOccupation(request.getParameter("occupation"));
		archInfo.setMobiPhonNumb(request.getParameter("telephone"));
		
		if(request.getParameter("marriage").equals("married")){
			archInfo.setMariStat(true);    /**已婚为true**/
		}else{
			archInfo.setMariStat(false); 
		}
		archInfo.setDrugFoodAlle(request.getParameter("guomin"));
		archInfo.setFamiHist(request.getParameter("fami_hist"));
		archInfo.setPersHist(request.getParameter("pers_hist"));
		
		return archInfo;
		
	}
	
	//删除电子病历档案
	public String DeleteMembArchInfo() throws IOException{
		String FORWARD = "error";
		try {
			// 取得request对象和response对象
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("gb2312");
		    
			// 电子病历Id
			String archId = new String(request.getParameter("archId"));
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			MembArchInfoDAO dao = (MembArchInfoDAO) otx.getBean("MembArchInfoDAO");
			//调用findDetailById方法，通过电子病历表单id获取表单信息
			MembArchInfo info = dao.findDetailById(Integer.parseInt(archId));
			//调用deleteMembArchInfo方法，在数据库中删除
			boolean delete = dao.deleteMembArchInfo(info);
			if (delete) {
				System.out.println("会员删除电子档案-----成功");
				FORWARD = "success";
				out.println("yes");
			} else {
				System.out.println("会员删除电子档案-----失败");
				out.println("no");
			}
			out.flush();
			out.close();

		} catch (DataException e) { // hibernate数据异常处理！！！！！
			FORWARD = "error";
			System.out.println("hibernate数据异常处理！！！！！");
			e.printStackTrace();

		}
		return FORWARD;

	}
	
	//根据会员Id获取电子病历档案列表
	public String getBriefListForRead() {
		System.out.println("运行到了MembArchInfoAction-----getBriefListForRead");
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

			//通过session获得用户Id
			String username = new String(session.get("username").toString()
					.getBytes("iso8859-1"), "utf-8");
			System.out.println(username);
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			MembArchInfoDAO dao = (MembArchInfoDAO) otx.getBean("MembArchInfoDAO");
			//调用findDetailByMembId方法，通过文章id查找特定的电子病历档案
			List<MembArchInfo> infoList = dao.findDetailByMembId(username);

			// ---------------------------------------------------------------------------------------
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			JSONObject archInfo = null;
			for (int i = 0; i < infoList.size(); i++) {

				archInfo = new JSONObject();
				
				archInfo.put("archId", infoList.get(i).getArchId().toString());
				// 名字,此处的名字是血压记录的名字，而不是会员的名字
				archInfo.put("username", infoList.get(i).getName());
				System.out.println("患者姓名----"+infoList.get(i).getName());
				//性别
				String strSex="";
				if(infoList.get(i).getSex()){
					strSex="女";
				}else{
					strSex="男";
				}

				archInfo.put("sex", strSex);
				
				String strAge=infoList.get(i).getAge().toString();
				archInfo.put("age", strAge);
				// 舒张压
				archInfo.put("idCardNumber", infoList.get(i).getIdCardNumb().toString());
				// 收缩压
				archInfo.put("address",infoList.get(i).getAddress().toString());
				// 血氧
				archInfo.put("occupation", infoList.get(i).getOccupation().toString());
				// 体温
				archInfo.put("telephone", infoList.get(i).getMobiPhonNumb().toString());
				
				array.add(archInfo);
			}
			json.put("acount", infoList.size());
			json.put("archInfoArray", array);
			out = response.getWriter();
			
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 出错返回当前页面
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
		}
		return forward;
	}
	
	/**
	 * 根据档案Id 读取详细的档案信息
	 * @author larch
	 * 
	 */
public String getArchInfoForRead() {
		
		System.out.println("运行到了MembArchInfoAction-----getArchInfoForRead");
		// 取得request对象和response对象
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
			//Spring调用相应DAO
			MembArchInfoDAO dao = (MembArchInfoDAO) otx.getBean("MembArchInfoDAO");
			//从jsp页面获取文章id，再将其转为整型
			String ArchInfo_Id = request.getParameter("ArchInfo_Id");
			System.out.println("ArchInfo_Id="+ArchInfo_Id);
			int id = Integer.parseInt(ArchInfo_Id);
			System.out.println("id="+id);
			// ---------------------------------------------------------------------------------------
			MembArchInfo archInfo = dao.findDetailById(id);
			// id
			json.put("ArchInfo_Id", archInfo.getArchId());
			
			// 名字,此处的名字是血压记录的名字，而不是会员的名字
			json.put("name", archInfo.getName().toString());
			
			String strSex="";
			if(archInfo.getSex()){
				strSex="female";
			}else{
				strSex="male";
			}
			
			String marriage="";
			if(archInfo.getMariStat()){
				marriage="married";  /**已婚为true**/
			}else{
				marriage="Nmarried";
			}
			/**医保类型！！*/
			
			String type = archInfo.getInsuranceType().toString(); 
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
			String licence1 = archInfo.getLicenceType().toString();
			if("身份证".equals(licence1)){      
				licence = "idCardNumber1";
			}else if("老年证".equals(licence1)){      
				licence = "idCardNumber2";
			}else{
				licence = "idCardNumber3";
			}
			json.put("licence", licence);
			json.put("meditype", meditype);
			json.put("mariStat", marriage);
			json.put("province", archInfo.getProvince().toString());
			json.put("city",archInfo.getCity().toString());
			json.put("county", archInfo.getCounty().toString());
			json.put("sex", strSex);
			String strAge=archInfo.getAge().toString();
			json.put("age", strAge);
			json.put("idCardNumber", archInfo.getIdCardNumb().toString());
			json.put("address",archInfo.getAddress().toString());
			json.put("occupation", archInfo.getOccupation().toString());
			json.put("telephone", archInfo.getMobiPhonNumb().toString());
			json.put("guomin",archInfo.getDrugFoodAlle().toString());
			json.put("fami_hist", archInfo.getFamiHist().toString());
			json.put("pers_hist", archInfo.getPersHist().toString());
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

	//对电子病历档案进行更新操作
	public String UpdateArchInfo() throws Exception {

	System.out.println("运行到了会员档案处理action！-----update");
	String FORWARD = "error";
	try {
		// 取得request对象
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		
		ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Spring调用相应DAO
		MembArchInfoDAO dao = (MembArchInfoDAO) otx.getBean("MembArchInfoDAO");
		
		//获取相关档案Id
		String ArchInfo_Id = new String(request.getParameter("ArchInfo_Id"));
		//调用findDetailById方法，通过电子病历档案表单id，查找特定的电子病历档案信息
		MembArchInfo info=dao.findDetailById(Integer.parseInt(ArchInfo_Id));
						
		//姓名
		info.setName(request.getParameter("name").toString());
		//性别
		if("male".equals(request.getParameter("sex"))){
			info.setSex(false);    /**男为0，女为1*/
		}
		else{
			info.setSex(true);
		}
		info.setAge(Integer.parseInt(request.getParameter("age")));
		
		String meditype=request.getParameter("meditype");
		/**医保类型！！*/
		if (meditype!=null) {
			if(meditype.equals("1")){      
				info.setInsuranceType("湖南省职工医保");
			}else if(meditype.equals("2")){
				info.setInsuranceType("大学生医保");
			}
			else if(meditype.equals("3")){
				info.setInsuranceType("城镇医疗保险");
			}else{
				info.setInsuranceType("农村医疗保险");
			}
		}
		
		/**证件类型*/
		String license=request.getParameter("licence");
		if (license!=null) {
			if(license.equals("idCardNumber1")){      
				info.setLicenceType("身份证");
			}else if(license.equals("idCardNumber2")){      
				info.setLicenceType("老年证");
			}else{
				info.setLicenceType("残疾证");
			}
		}
	    info.setIdCardNumb(request.getParameter("idCardNumber"));
		info.setAddress(request.getParameter("address"));
		info.setProvince(request.getParameter("province"));
		info.setCity(request.getParameter("city"));
	    info.setCounty(request.getParameter("county"));
		info.setOccupation(request.getParameter("occupation"));
		info.setMobiPhonNumb(request.getParameter("telephone"));
		
		if("married".equals(request.getParameter("marriage"))){
			info.setMariStat(true);    /**已婚为true**/
		}else{
			info.setMariStat(false); 
		}
		info.setDrugFoodAlle(request.getParameter("guomin").toString());
		info.setFamiHist(request.getParameter("fami_hist").toString());
		info.setPersHist(request.getParameter("pers_hist").toString());
		
		if(dao.updateMembArchInfo(info)){
			System.out.println("会员修改档案成功");
			FORWARD = "success";
		}
		else{
			System.out.println("会员修改档案失败");
			FORWARD = "error";
		}		

	} catch (DataException e) { // hibernate数据异常处理！！！！！
		FORWARD = "error";
		System.out.println("hibernate数据异常处理！！！！！");
		e.printStackTrace();
	}
	return FORWARD;
}
}
