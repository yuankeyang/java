package com.netmed.action.qiuyi;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.netmed.dao.*;
import com.netmed.pojo.*;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *    根据输入搜索关键词，查找相应的疾病和症状表，得到相应的医学解释！！！！
 */
public class MediKnowServletAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public String execute() {
		
		System.out.println("运行到了医学解释action---MediKnowServletAction");

		 /**获取request对象和response对象**/
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean IEorNot = request.getHeader("User-Agent").contains("Trident");
		HttpSession session = request.getSession();
		if(IEorNot){
			session.setAttribute("IEorNot", "1");
		}else{
			session.setAttribute("IEorNot", "0");
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		String search_str = "";
		try {
			out = response.getWriter();
			search_str = request.getParameter("search_str");  /**从jsp页面获取关键词**/
			System.out.println("输入的关键词为："+search_str);

		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 /**定义json对象和数组，用以存储数据库数据并返回到jsp页面**/
		JSONObject json = new JSONObject();
		JSONObject mediKnow = new JSONObject();	
		JSONArray knowidArray = new JSONArray();

		 /**Spring调用DAO**/
		ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
		MediKnowDAO dao = (MediKnowDAO)otx.getBean("MediKnowDAO");
		
		/**字符串拆分，将长度大于2的搜索词拆分为长度为2的词，只考虑相邻的长度为2的词**/
		int next = 0;
		String [] search=new String[100];
	    for (int i = 0; i <search_str.length()-1; i++) {
	        next = i+2;
	        search[i] = search_str.substring(i, next);
	    }
	    
	    /**定义List对象，用以存储通过关键词找到的症状，中医病名，西医病名**/
		List<SympSyno> sympidList=new ArrayList<SympSyno>();
		List<SympSyno> sympidList1=new ArrayList<SympSyno>();
		List<ChinDiseSyno> chindiseList=new ArrayList<ChinDiseSyno>();
		List<ChinDiseSyno> chindiseList1=new ArrayList<ChinDiseSyno>();
		List<WestDiseSyno> westdiseList=new ArrayList<WestDiseSyno>();
		List<WestDiseSyno> westdiseList1=new ArrayList<WestDiseSyno>();

		 /**搜索词长度大于2的情况**/
		if(search_str.length()>2){
			System.out.println("词条分解");
			for(int i=0;i<search.length;i++){
				
				 /**对于每一个拆分后的长度为2的词，进行一次搜索，结果都存入相应List中**/
		    	sympidList1 = dao.querySympSyno(search[i]);
		    	chindiseList1=dao.queryChinDiseSyno(search[i]);
		    	westdiseList1=dao.queryWestDiseSyno(search[i]);
		    	
		    	for(int j=0;j<sympidList1.size();j++){
		    		sympidList.add(sympidList1.get(j));
		    	}
		    	for(int j=0;j<chindiseList1.size();j++){
		    		chindiseList.add(chindiseList1.get(j));
		    	}
		    	for(int j=0;j<westdiseList1.size();j++){
		    		westdiseList.add(westdiseList1.get(j));
		    	}
		    }
		}else{
			 /**搜索词长度小于等于2的情况**/
			sympidList= dao.querySympSyno(search_str);
			chindiseList= dao.queryChinDiseSyno(search_str);
			westdiseList= dao.queryWestDiseSyno(search_str);
		}
	    
		
		 /**找到相应症状或者疾病的个数**/
		int totalNum = sympidList.size() + chindiseList.size()
				+ westdiseList.size();

		
		if (totalNum == 0) {
			mediKnow.put("knowName", search_str);
			mediKnow.put("knowCont", "无此名词和相应信息，请重新输入正确词条，谢谢");
			mediKnow.put("knowSour", "无");
			//knowidArray.add(mediKnow);
		} else {
			 
			/**根据症状id在医学解释表中查询相应医学解释**/
			for (int i = 0; i < sympidList.size(); i++) {
				SympSyno symptom = sympidList.get(i);       /**定义症状对象**/
				List<MediKnow> mediId = dao
						.queryMediKnowBySympId(symptom.getSympId());  /**通过症状id找到医学解释**/
				
				for (int j = 0; j < mediId.size(); j++) {
					String name=mediId.get(j).getSympSyno().getChinSympName();
					mediKnow.put("knowName",name);                        /**医学词条名称**/
					mediKnow.put("knowCont", mediId.get(j).getKnowCont());/**医学词条内容**/
					mediKnow.put("knowSour", mediId.get(j).getSource());  /**医学词条来源**/
					knowidArray.add(mediKnow);

				}

			}
			/**根据中医病名id在医学解释表中查询相应医学解释**/
			for (int i = 0; i < chindiseList.size(); i++) {
				ChinDiseSyno chindise = chindiseList.get(i);
				List<MediKnow> mediId = dao.queryMediKnowByChinDiseId(chindise
						.getChinDiseId());
				for (int j = 0; j < mediId.size(); j++) {
					mediKnow.put("knowName", mediId.get(j).getChinDiseSyno()
							.getChinDiseName());
					mediKnow.put("knowCont", mediId.get(j).getKnowCont());
					mediKnow.put("knowSour", mediId.get(j).getSource());
					knowidArray.add(mediKnow);

				}
			}

			/**根据西医病名id在医学解释表中查询相应医学解释**/
			for (int i = 0; i < westdiseList.size(); i++) {
				WestDiseSyno westdise = westdiseList.get(i);
				List<MediKnow> mediId = dao.queryMediKnowByWestDiseId(westdise
						.getWestDiseId());
				for (int j = 0; j < mediId.size(); j++) {
					mediKnow.put("knowName", mediId.get(j).getWestDiseSyno()
							.getWestDiseName());
					mediKnow.put("knowCont", mediId.get(j).getKnowCont());
					mediKnow.put("knowSour", mediId.get(j).getSource());
					knowidArray.add(mediKnow);

				}
			}

		}
		System.out.println("搜寻的医学解释个数："+knowidArray.size());
		json.put("mediknow", knowidArray);
		json.put("mediSize",knowidArray.size());
		out.println(json.toString());           // 将查询到的医学解释发送到JSP页面！！
		out.flush();
		out.close();
		return "success";
	}

}
