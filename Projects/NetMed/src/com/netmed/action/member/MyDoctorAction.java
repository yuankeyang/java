package com.netmed.action.member;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.CollectionDAO;
import com.netmed.dao.DoctorDAO;
import com.netmed.pojo.Collection;
import com.netmed.pojo.ExpeRegi;
import com.netmed.pojo.MembConsInfo;
import com.opensymphony.xwork2.ActionSupport;

public class MyDoctorAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() {
		//获取request和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String FOWARD = "success";
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//获取session，以便获得会员id
			Map<String, Object> session = ServletActionContext.getContext()
					.getSession();
			PrintWriter out = response.getWriter();
			//获取用户Id
			String userId = new String(session.get("username").toString()
					.getBytes("iso8859-1"), "utf-8");

			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			DoctorDAO dao = (DoctorDAO) otx.getBean("DoctorDAO");
			CollectionDAO daoCollect = (CollectionDAO) otx
					.getBean("CollectionDAO");
			//定义一个数组，存放专家类型
			String expertTypes[] = { "医师", "药师", "按摩理疗师", "心理咨询师", "健康管理师",
					"营养师" };
			//定义一个数组，存放对应专家类型编号
			int expertTypeId[] = { 1, 2, 3, 4, 5, 6 };
			//定义一个数组，存放相应的专家类型代称
			String expertTypesP[] = { "yishi", "yaoshi", "anmo", "xinli",
					"jiankang", "yingyang" };
			JSONObject json = new JSONObject();
			for (int j = 0; j < expertTypes.length; j++) {

				//调用MyExpert方法，查找userId的互动专家
				List<MembConsInfo> consult = dao.MyExpert(userId,
						expertTypeId[j]);

				JSONArray array = new JSONArray();
				JSONObject expert;

				ArrayList<String> names = new ArrayList<String>();
				for (int i = 0; i < consult.size(); i++) {
					expert = new JSONObject();
					//获取互动医生的相关信息，姓名和擅长
					String expertName = consult.get(i).getExpeRegi()
							.getExpeName();
					String instroduction = consult.get(i).getExpeRegi()
							.getIndiResu();
					Iterator<String> it = names.iterator();
					boolean b = true;
					while (it.hasNext()) {
						if (expertName.equals(it.next())) {
							b = false;
							break;
						}
					}
					names.add(expertName);
					if (b) {
						expert.put("expe_id", consult.get(i).getExpeRegi()
								.getExpeId());
						expert.put("expertName", expertName);
						expert.put("instroduction", instroduction);
						array.add(expert);
					}
				}
				json.put(expertTypesP[j], array);
				json.put(expertTypesP[j] + "Num", array.size());
			}

			
			/** userId 收藏的专家 */
			List<Collection> collect = daoCollect.getCollections(userId);
			JSONObject collectExpert = new JSONObject();
			JSONArray CollectArray = new JSONArray();
			for (int i = 0; i < collect.size(); i++) {
				collectExpert.put("expe_id", collect.get(i).getExpeRegi()
						.getExpeId());
				//专家姓名
				collectExpert.put("expertName", collect.get(i).getExpeRegi()
						.getExpeName());
				//专家擅长
				collectExpert.put("introduction", collect.get(i).getExpeRegi()
						.getIndiResu());
				CollectArray.add(collectExpert);
			}
			json.put("colectNum", collect.size());
			json.put("colectArray", CollectArray);
			// -----------------------------------------------------------------
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			FOWARD = "error";
		}
		return FOWARD;
	}

	//根据专家Id获取相关信息
	public String getExpeDetail() {
		//获取request和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String FOWARD = "success";
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//通过session获得会员id
			Map<String, Object> session = ServletActionContext.getContext()
					.getSession();
			PrintWriter out = response.getWriter();
			//获取用户id
			String userId = new String(session.get("username").toString()
					.getBytes("iso8859-1"), "utf-8");
			//获取专家id
			String expe_id = request.getParameter("expe_id");

			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			DoctorDAO dao = (DoctorDAO) otx.getBean("DoctorDAO");
			// 获取到专家信息
			ExpeRegi expeRegi = dao.getExpeRegi(expe_id);
			JSONObject json = new JSONObject();
			// 专家姓名
			json.put("username", expeRegi.getExpeName());
			// 是否收藏
			json.put("isCollect", dao.isCollect(userId, expe_id));
			// 科室
			json.put("keshi", expeRegi.getDepartment());
			// 职称
			json.put("zhicheng", expeRegi.getTitle());
			// 医院
			json.put("yiyuan", expeRegi.getUnit());
			// 擅长
			json.put("good", expeRegi.getIndiResu());

			// -----------------------------------------------------------------
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			FOWARD = "error";
		}
		return FOWARD;
	}
}
