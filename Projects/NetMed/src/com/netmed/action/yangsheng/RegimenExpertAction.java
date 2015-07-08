package com.netmed.action.yangsheng;

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
import com.netmed.pojo.ExpeType;

/**
 * @author Administrator
 *  根据养生品，查找相关养生专家
 *  05-18
 */
public class RegimenExpertAction {

	public static String inputStr;

	public String execute() {

		System.out.println("运行到了RegimenExpertAction,查找相关养生专家!");

		/**通过session获取会员id**/
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		String userId = (String) session.get("username");

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
			System.out.println("养生从regimenExpert_recommend.jsp获取参数：" + acceptjson);
			if (acceptjson != "") {

				data = JSONObject.fromObject(acceptjson);

				/** 从页面Pharmacist_recommend.jsp页面获得几个参数 **/
				inputStr = data.get("search_str").toString();
				pageIndex = data.getInt("pageIndex");

				System.out.println("search_str:" + inputStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			
			/**Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			ExpeTypeDAO mDao = (ExpeTypeDAO) otx.getBean("ExpeTypeDAO");
			DoctorDAO dao = (DoctorDAO) otx.getBean("DoctorDAO");

			/**定义json对象和数组用以存储数据库数据并返回到jsp页面**/		
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			JSONObject regimen = new JSONObject();

			/**查找养生专家，返回专家列表**/		
			List<ExpeType> expertList = mDao.FindRegimenExpert();
			int regimenExpertNumber = expertList.size();
			
			/**筛选条件**/	
			String province=(String)data.get("currProvince");   //获取页面省份信息
			String title=(String)data.get("currZhicheng");      //获取页面职称信息
			
			/**分页处理的功能，每页显示3个专家信息，可更改**/
			for (int i = pageIndex * 3 - 3; i < pageIndex * 3; i++) {

				if (i < regimenExpertNumber) {
					
					/**无任何筛选条件**/
					if(province.equals("")&&("").equals(title)){
						regimen.put("pharmacistId", expertList.get(i).getExpeRegi()
								.getExpeId());
						regimen.put("pharmacistName", expertList.get(i)
								.getExpeRegi().getExpeName());
						regimen.put("isCollect", dao.isCollect(userId,expertList.get(i).getExpeRegi().getExpeId()));
						
						regimen.put("zhicheng", expertList.get(i).getExpeRegi()
								.getTitle());
						regimen.put("keshi", expertList.get(i).getExpeRegi().getDepartment());
						regimen.put("yiyuan", expertList.get(i).getExpeRegi()
								.getUnit());
						regimen.put("good", expertList.get(i).getExpeRegi()
								.getIndiResu());
						array.add(regimen);
					}else{
						regimen.put("pharmacistId", expertList.get(i).getExpeRegi()
								.getExpeId());
						regimen.put("pharmacistName", expertList.get(i)
								.getExpeRegi().getExpeName());
						regimen.put("zhicheng", expertList.get(i).getExpeRegi()
								.getTitle());
						regimen.put("isCollect", dao.isCollect(userId,expertList.get(i).getExpeRegi().getExpeId()));
						regimen.put("keshi", expertList.get(i).getExpeRegi().getDepartment());
						regimen.put("yiyuan", expertList.get(i).getExpeRegi()
								.getUnit());
						regimen.put("good", expertList.get(i).getExpeRegi()
								.getIndiResu());
						/**仅作省份筛选**/
						if(expertList.get(i).getExpeRegi()
								.getUnit().indexOf(province)!=-1&&("").equals(title)){
							array.add(regimen);                  //如果是选择省份，则加入array
						}
						/**仅作职称筛选**/
						if(title.equals(expertList.get(i).getExpeRegi().getTitle())&&("").equals(province)){
							array.add(regimen);
						}
						/**既做省份筛选，又做职称筛选**/
						if(!province.equals("")&&!title.equals("")&&expertList.get(i).getExpeRegi()
									.getUnit().indexOf(province)!=-1&&expertList.get(i).getExpeRegi().getTitle().equals(title)){
							array.add(regimen);
						}
					}
				}
			}

			System.out.println("符合条件的专家："+array.size());
			/**搜索结果为空**/
			if (array.size() == 0) {
				json.put("nullInfo", "对不起，无此类养生专家信息,请重新输入");
			}
			json.put("account", array.size());   /**养生专家数**/
			json.put("pharmacistArray", array);
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";

	}
}
