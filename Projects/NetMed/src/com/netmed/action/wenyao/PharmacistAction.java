package com.netmed.action.wenyao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.DoctorDAO;
import com.netmed.dao.ExpeTypeDAO;
import com.netmed.pojo.*;

/**
 * @author Administrator
 *  根据药物，查找相关药师或者药店
 *  05-18
 */
public class PharmacistAction {
	
	public static String inputStr;

	public String execute() {
		
		System.out.println("运行到了药师列表action！------PharmacistAction");
		/**获取session**/
		Map<String, Object> session = ServletActionContext.getContext().getSession();
		String userId=(String) session.get("username");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			out = response.getWriter();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		String acceptjson = "";
		int pageIndex = 0;
		JSONObject data = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(ServletInputStream) request.getInputStream(), "utf-8"));
			StringBuffer sb = new StringBuffer("");
			String temp;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
			br.close();
			acceptjson = sb.toString();
			System.out.println("从页面获取参数："+acceptjson);
			if (acceptjson != "") {
				
				data = JSONObject.fromObject(acceptjson);
				
				/** 从页面Pharmacist_recommend.jsp页面获得几个参数：搜索词，页码和药物编号**/
				inputStr = data.get("search_str").toString();
				pageIndex = data.getInt("pageIndex");
				
				System.out.println("search_str:"+inputStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/**直接找药师，根据输入词**/
		ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ExpeTypeDAO dao=(ExpeTypeDAO)otx.getBean("ExpeTypeDAO");
		List<ExpeType> expertList=dao.FindExpertByTypeId(2);    /**专家类型为2，即药师**/
		
		/**定义json对象和数组用以存储数据库数据并返回到jsp页面**/		
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject pharmacist =new JSONObject();
		
		/**处理是否已经收藏的DAO**/
		DoctorDAO dao2 = (DoctorDAO)otx.getBean("DoctorDAO");
		/***查找相应的专家，药师**/
		int pharmacistNumber = expertList.size();
		
		String province=(String)data.get("currProvince");   /**获取页面省份信息**/
		String title=(String)data.get("currZhicheng");      /**获取页面职称信息**/
		
		/**分页处理的功能，每页显示3个专家信息，可更改**/
		for (int i = pageIndex * 3 - 3; i < pageIndex * 3; i++) {
		   if(i<pharmacistNumber){
			   
			 /**无任何筛选条件**/
			 if(("").equals(province)&&("").equals(title)){
				pharmacist.put("pharmacistId", expertList.get(i).getExpeRegi().getExpeId());
			    pharmacist.put("pharmacistName", expertList.get(i).getExpeRegi().getExpeName());
				pharmacist.put("isCollect", dao2.isCollect(userId, expertList.get(i).getExpeRegi().getExpeId()));
				pharmacist.put("zhicheng", expertList.get(i).getExpeRegi().getTitle());
				pharmacist.put("keshi",expertList.get(i).getExpeRegi().getDepartment());
				pharmacist.put("yiyuan", expertList.get(i).getExpeRegi().getUnit());
				pharmacist.put("good", expertList.get(i).getExpeRegi().getIndiResu());
				array.add(pharmacist);
			   }else{
				pharmacist.put("pharmacistId", expertList.get(i).getExpeRegi().getExpeId());
			    pharmacist.put("pharmacistName", expertList.get(i).getExpeRegi().getExpeName());
				pharmacist.put("isCollect", dao2.isCollect(userId, expertList.get(i).getExpeRegi().getExpeId()));
				pharmacist.put("zhicheng", expertList.get(i).getExpeRegi().getTitle());
				pharmacist.put("keshi",expertList.get(i).getExpeRegi().getDepartment());
				pharmacist.put("yiyuan", expertList.get(i).getExpeRegi().getUnit());
				pharmacist.put("good", expertList.get(i).getExpeRegi().getIndiResu());
				
				/**仅作省份筛选**/
				if(expertList.get(i).getExpeRegi()
							.getUnit().indexOf(province)!=-1&&("").equals(title)){
						array.add(pharmacist);                  //如果是选择省份，则加入array
					}
				
				/**仅作职称筛选**/
				if(title.equals(expertList.get(i).getExpeRegi().getTitle())&&("").equals(province)){
					array.add(pharmacist);
				}
				
				/**既做省份筛选，又做职称筛选**/
				if(!province.equals("")&&!title.equals("")&&expertList.get(i).getExpeRegi()
							.getUnit().indexOf(province)!=-1&&expertList.get(i).getExpeRegi().getTitle().equals(title)){
					array.add(pharmacist);
				}
			   }
			
		   }
	    }
		
		System.out.println("搜索的药师数目：" + array.size());
		if(array.size()==0){
			json.put("nullInfo", "对不起，无此类药师信息，请重新输入");
		}
		json.put("account", array.size());
		json.put("pharmacistArray", array);
		
		String forward="success";
		
		out.println(json.toString());
		out.flush();
		out.close();
		
		return forward; 
		
	}
}
