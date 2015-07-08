package com.netmed.action.yangsheng;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.RegimenDAO;
import com.netmed.pojo.*;
/**
 * @author Administrator
 *  养生action，根据输入关键词,显示养生类别的信息
 *  
 *  05-19
 */
public class SearchRegimenAction {
	
		public String execute() {
			
			/**获取request对象和response对象**/
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			
			//判断浏览器版本，并存入session，方便做不同的编码方式
			//System.out.println("浏览器版本： "+request.getHeader("User-Agent"));
			boolean IEorNot = request.getHeader("User-Agent").contains("Trident");
			HttpSession session = request.getSession();
			if(IEorNot){
				session.setAttribute("IEorNot", "1");
			}else{
				session.setAttribute("IEorNot", "0");
			}
			
			PrintWriter out = null;
			String search_str = "";
			String pageIndex="1";
			int NpageIndex=Integer.parseInt(pageIndex);
			try {
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
			    out = response.getWriter();
			    
			    search_str = request.getParameter("search_str");
				pageIndex=request.getParameter("pageIndex");
				NpageIndex=Integer.parseInt(pageIndex);
				System.out.println("输入的养生名词为："+search_str+"<----->分页编号:pageIndex="+pageIndex);
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			JSONObject json = new JSONObject();
			/**5养生品分别显示，分别为保健食品、养生复方、浴方、按摩方和医疗器械！！！*/
			JSONObject healFood = new JSONObject();
			JSONObject regiComp = new JSONObject();
			JSONObject mediBath = new JSONObject();
			JSONObject massPres = new JSONObject();
			JSONObject mediEqui = new JSONObject();
			
			/**array数组用以存储所有养生品搜索结果 */
			JSONArray array = new JSONArray();
			
			/**array1-array5数组用以分类存储养生品搜索结果 */
			JSONArray array1 = new JSONArray();  /**存储保健食品**/
			JSONArray array2 = new JSONArray();  /**存储养生浴方**/
			JSONArray array3 = new JSONArray();  /**存储浴方**/
			JSONArray array4 = new JSONArray();  /**存储按摩方**/
			JSONArray array5 = new JSONArray();  /**存储医疗器械**/

			/**Spring调用DAO，主要是对养生品的DAO操作**/
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			RegimenDAO dao = (RegimenDAO)otx.getBean("RegimenDAO");
			
			/**字符串拆分，将长度大于2的搜索词拆分为长度为2的词，只考虑相邻的长度为2的词**/
			int next = 0;
			String [] search=new String[100];
		    for (int i = 0; i <search_str.length()-1; i++) {
		        next = i+2;
		        search[i] = search_str.substring(i, next);
		    }
		    
		    /**定义List对象，用以存储通过关键词找到的保健食品，养生复方，浴方，按摩方和医疗器械，其中每种养生品第二个List作为中间变量**/
			List<HealFood> healFoodList=new ArrayList<HealFood>();
			List<HealFood> healFoodList1=new ArrayList<HealFood>();
			List<ChinRegiComp> regiCompList=new ArrayList<ChinRegiComp>();
			List<ChinRegiComp> regiCompList1=new ArrayList<ChinRegiComp>();
			List<ChinMediBath> mediBathList=new ArrayList<ChinMediBath>();
			List<ChinMediBath> mediBathList1=new ArrayList<ChinMediBath>();
			List<MassPres> massPresList=new ArrayList<MassPres>();
			List<MassPres> massPresList1=new ArrayList<MassPres>();
			List<HomeMediEqui> mediEquiList=new ArrayList<HomeMediEqui>();
			List<HomeMediEqui> mediEquiList1=new ArrayList<HomeMediEqui>();
			
			 /**搜索词长度大于2的情况**/
			if(search_str.length()>2){
				
				 /**对于每一个拆分后的长度为2的词，进行一次搜索，结果都存入相应List中**/
				 for(int i=0;i<search.length;i++){
					 healFoodList1 = dao.queryHealFood(search[i]);
					 regiCompList1 = dao.queryChinRegiComp(search[i]);
					 mediBathList1 = dao.queryChinMediBath(search[i]);
					 massPresList1 = dao.queryMassPres(search[i]);
					 mediEquiList1 = dao.queryHomeMediEqui(search[i]);
					 for(int j=0;j<healFoodList1.size();j++){
						 healFoodList.add(healFoodList1.get(j));
					 }
					 for(int j=0;j<regiCompList1.size();j++){
						 regiCompList.add(regiCompList1.get(j));
					 }
					 for(int j=0;j<mediBathList1.size();j++){
						 mediBathList.add(mediBathList1.get(j));
					 }
					 for(int j=0;j<massPresList1.size();j++){
						 massPresList.add(massPresList1.get(j));
					 }
					 for(int j=0;j<mediEquiList1.size();j++){
						 mediEquiList.add(mediEquiList1.get(j));
					 }
				 }
			}else{
				 /**搜索词长度小于等于2的情况**/
				healFoodList = dao.queryHealFood(search_str);
				regiCompList = dao.queryChinRegiComp(search_str);
				mediBathList = dao.queryChinMediBath(search_str);
				massPresList = dao.queryMassPres(search_str);
				mediEquiList = dao.queryHomeMediEqui(search_str);
			}
			

			int totalNum = healFoodList.size() + regiCompList.size()
					+ mediBathList.size()+massPresList.size()+mediEquiList.size();
			
			/**将每种养生品的个数存入json对象number，用以在JSP页面分类显示*/
			JSONObject number = new JSONObject();
			number.put("Nfood",healFoodList.size());
			number.put("Ncomp",regiCompList.size());
			number.put("Nbath",mediBathList.size());
			number.put("Npres",massPresList.size());
			number.put("Nequi",mediEquiList.size());
			
			
			System.out.println("搜寻的相关养生品个数："+totalNum);
			
			if (totalNum == 0) {
				json.put("nullInfo","无此养生品数据，请重新输入");
			} else {
				
				/**定义5种养生品对象*/
				HealFood food;
				ChinRegiComp comp;
				ChinMediBath bath;
				MassPres mass;
				HomeMediEqui equi;
				
			    //   从保健食品表中查询
				for (int i = 0; i < healFoodList.size(); i++) {
				    food = healFoodList.get(i);
					healFood.put("regiId", food.getHealFoodId());  /**养生品编号**/
					healFood.put("Picture", food.getPicture());    /**养生品图片**/
					healFood.put("Name", food.getHealFoodName());  /**养生品名称**/
					healFood.put("Function", food.getFunction());  /**养生品功效**/
					healFood.put("Usage", food.getEdibMeth());      /**养生品使用方法**/
					healFood.put("Precaution", food.getPrecaution()); /**养生品注意事项**/
					
					array1.add(healFood);  /**将药物信息存入json数组中，用以返回至JSP页面*/
					array.add(healFood);

				}
				// ******查询养生复方*******
				for (int i = 0; i < regiCompList.size(); i++) {
					comp = regiCompList.get(i);
					regiComp.put("regiId", comp.getCompId());
					regiComp.put("Picture", comp.getPicture());
					regiComp.put("Name", comp.getCompName());
					regiComp.put("Function", comp.getFunction());
					regiComp.put("MakeMethod", comp.getMakeMeth());
					regiComp.put("Usage", comp.getUsagDosa());
					regiComp.put("Precaution", comp.getPrecaution());
					
					array2.add(regiComp);
					array.add(regiComp);
				}

				// ******查询浴方*******
				for (int i = 0; i < mediBathList.size(); i++) {

					bath = mediBathList.get(i);
					mediBath.put("regiId", bath.getBathId());
					mediBath.put("Picture", bath.getPicture());
					mediBath.put("Name", bath.getBathName());
					mediBath.put("Function", bath.getFunction());
					mediBath.put("Usage", bath.getUsagDosa());
					mediBath.put("Precaution", bath.getPrecaution());
					
					array3.add(mediBath);
					array.add(mediBath);
				}
				
				// ******查询按摩方*******
				for (int i = 0; i < massPresList.size(); i++) {
					mass = massPresList.get(i);
					massPres.put("regiId", mass.getMassId());
					massPres.put("Picture", mass.getPicture());
					massPres.put("Name", mass.getMassName());
					massPres.put("Function", mass.getFunction());
					massPres.put("Usage", mass.getOperMeth());
					massPres.put("Precaution", "无");
					
					array4.add(massPres);
					array.add(massPres);
				}
				
				/**查询医疗器械**/
				for (int i = 0; i < mediEquiList.size(); i++) {
					equi = mediEquiList.get(i);
					mediEqui.put("regiId", equi.getProdId());
					mediEqui.put("Picture", equi.getPicture());
					mediEqui.put("Name", equi.getProdName());
					mediEqui.put("Function", equi.getFunction());
					mediEqui.put("Usage", equi.getUsage());
					mediEqui.put("Apply", equi.getApply());
					mediEqui.put("Description", equi.getDescription());
					mediEqui.put("Precaution", equi.getContraindication());
					
					array5.add(mediEqui);
					array.add(mediEqui);
				}

			}
			
			/**定义json数组，用以分页返回养生品信息**/
			JSONArray arrayFood = new JSONArray();
			JSONArray arrayComp = new JSONArray();
			JSONArray arrayBath = new JSONArray();
			JSONArray arrayMass = new JSONArray();
			JSONArray arrayEqui = new JSONArray();
			
			/**分页显示，每页显示4条记录，最终每种养生品都存入json数组，JSP显示*/
			for(int i=NpageIndex * 4 - 4;i < NpageIndex * 4; i++){
				
				/**当查询结果数大于分页值，就将养生品记录加入到json数组中*/
				if(i<array1.size()){
					arrayFood.add(array1.get(i));
				}
				if(i<array2.size()){       
					arrayComp.add(array2.get(i));   
				}
				if(i<array3.size()){       
					arrayBath.add(array3.get(i));   
				}
				if(i<array4.size()){       
					arrayMass.add(array4.get(i));   
				}
				if(i<array5.size()){       
					arrayEqui.add(array5.get(i));   
				}
				
			}
			
			json.put("account", totalNum);
			json.put("healFoodArray", arrayFood);  /**保健食品**/
			json.put("regiCompArray", arrayComp);  /**养生复方**/
			json.put("mediBathArray", arrayBath);  /**中药浴方**/
			json.put("massPresArray", arrayMass);  /**按摩方**/
			json.put("mediEquiArray", arrayEqui);  /**医疗器械**/
			
			json.put("regimenArray", array);
			json.put("typeNumb",number);        /**每种养生品的数目**/
			
			out.println(json.toString());      // 将查询到的药物送到端页面！！
			out.flush();
			out.close();
			return "success";
		}


}
