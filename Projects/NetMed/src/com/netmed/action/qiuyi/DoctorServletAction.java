package com.netmed.action.qiuyi;

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

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.netmed.dao.DoctorDAO;
import com.netmed.pojo.ExpeRegi;
import com.netmed.pojo.ExpeServCont;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *   求医，查找相关专家
 */
public class DoctorServletAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	public static String inputStr;

	public String execute() {
		
		System.out.println("运行到了专家推荐action！--DoctorServletAction");
		/**获取session**/
		Map<String, Object> session = ServletActionContext.getContext().getSession();
		String userId=(String) session.get("username");
		
		/**获取request对象和response对象**/
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
		
		/**从jsp页面获取的json数据**/
		String acceptjson = "";
		int pageIndex = 0;        /**分页的页码**/
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
			System.out.println("求医从页面获取参数："+acceptjson);
			if (acceptjson != "") {
				data = JSONObject.fromObject(acceptjson);
				inputStr = data.get("search_str").toString();
				pageIndex = data.getInt("pageIndex");
				System.out.println("求医输入的关键词："+inputStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		/**Spring调用DAO**/
		ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DoctorDAO dao = (DoctorDAO)otx.getBean("DoctorDAO");
		
		/**通过关键词查找相应的专家**/
		List<ExpeServCont> expertList = dao.queryExpertId(inputStr);

		/**定义json数组和对象，用以保存数据库查询数据并返回到jsp页面**/
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject doctor =new JSONObject();

		int expertNumber = expertList.size();		
		System.out.println("根据关键词搜索的医生数目：" + expertNumber);

		/**分页处理的功能，每页显示3个专家信息，可更改**/
		for (int i = pageIndex * 3 - 3; i < pageIndex * 3; i++) {

			if (i<expertNumber) {
				
				String expertId=expertList.get(i).getExpeRegi().getExpeId();
				
				ExpeRegi expert = dao.getExpeRegi(expertId);       // 通过专家Id获得了一个专家信息
				
				String title=(String)data.get("currZhicheng");  //获取页面职称信息
				String unit=(String)data.get("currProvince");   //获取页面省份信息
				
				if(title.equals("")&&unit.equals("")){             // 条件为空， 没有做筛选
					
					doctor.put("userId", expert.getExpeId());     /**专家编号**/
					doctor.put("username", expert.getExpeName());  /**专家姓名**/
					//判断用户是否已收藏该专家
					if(userId==null||userId==""){
						doctor.put("isCollect", "收藏");            /**是否收藏**/
					}else{					
					   doctor.put("isCollect", dao.isCollect(userId, expert.getExpeId()));
					}			
					doctor.put("keshi", expert.getDepartment());    /**专家科室**/
					doctor.put("zhicheng", expert.getTitle());     /**专家职称**/ 
					doctor.put("yiyuan", expert.getUnit());        /**专家单位**/
					doctor.put("good", expert.getIndiResu());     /**专家擅长**/
					array.add(doctor);
				}
				else{
					 // 如果有个条件任意一个符合，就输出专家信息，均不符合就不输出
					doctor.put("userId", expert.getExpeId());      
					doctor.put("username", expert.getExpeName());
					//判断用户是否已收藏该专家	
					if(userId==null||userId==""){
						doctor.put("isCollect", "收藏");
					}else{					
					   doctor.put("isCollect", dao.isCollect(userId, expert.getExpeId()));
					}		
					doctor.put("keshi", expert.getDepartment());
					doctor.put("zhicheng", expert.getTitle());
					doctor.put("yiyuan", expert.getUnit());
					doctor.put("good", expert.getIndiResu());
					
					/**职称做限制，省份无限制**/
					if (expert.getTitle().equals(title)&&unit.equals("")){  
						array.add(doctor);
					}
					/**职称无限制，省份做限制**/
					if(expert.getUnit().indexOf(unit)!=-1&&title.equals("")){
						array.add(doctor);
					}
					/**职称省份都做限制**/
					if(!unit.equals("")&&!title.equals("")&&expert.getTitle().equals(title)&&expert.getUnit().indexOf(unit)!=-1){
						array.add(doctor);
					}
				
					
				}
			}

		}
		
		System.out.println("返回jsp页面的专家个数：" + array.size());
		json.put("account", expertNumber);
		json.put("doctorArray", array);
		
		out.println(json.toString());            /**专家信息存在json对象，返回jsp页面**/
		out.flush();
		out.close();
		return "success";
	}

}
