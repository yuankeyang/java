package com.netmed.action.wenyao;

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

import com.netmed.dao.MedicineDAO;
import com.netmed.pojo.*;
/**
 * @author Administrator
 *  问药action，根据输入关键词的类别，如果为药，则显示相应药的详细信息
 *  如果是疾病，则显示药的列表
 *  05-16
 */
public class SearchMedicineAction {
	
		public String execute() {
			System.out.println("运行到了问药action！---显示药物列表");
			
			/**获取request对象和response对象**/
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			
			//判断浏览器版本，并存入session，方便做不同的编码方式
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
				System.out.println("输入的药物或者疾病为："+search_str+"<----->分页编号:pageIndex="+pageIndex);
			
			} catch (UnsupportedEncodingException e1) {
				System.out.println("不能获取搜索关键词");
				e1.printStackTrace();
			} catch (IOException e) {
				System.out.println("不能获取搜索关键词");
				e.printStackTrace();
			}
			
			

			JSONObject json = new JSONObject();
			/**4中药材分别显示！！！*/
			JSONObject westMedi = new JSONObject();
			JSONObject prescrip = new JSONObject();
			JSONObject mediMate = new JSONObject();
			JSONObject pateMedi = new JSONObject();
			
			/**先不考虑分类别显示各种药，直接判断字符前缀 */
			JSONArray array = new JSONArray();
			
			JSONObject number=new JSONObject();
			JSONArray array1 = new JSONArray();
			JSONArray array2 = new JSONArray();
			JSONArray array3 = new JSONArray();
			JSONArray array4 = new JSONArray();

			/**Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			MedicineDAO dao = (MedicineDAO)otx.getBean("MedicineDAO");
			
			/**字符串拆分，将长度大于2的搜索词拆分为长度为2的词，只考虑相邻的长度为2的词**/
			int next = 0;
			String [] search=new String[100];
		    for (int i = 0; i <search_str.length()-1; i++) {
		        next = i+2;
		        search[i] = search_str.substring(i, next);
		    }
		    
		    /**定义List对象，用以存储通过关键词找到的西药，方剂，中药材和中成药，其中每种药第二个List作为中间变量**/
			List<WestMedi> westMediList=new ArrayList<WestMedi>();
			List<WestMedi> westMediList1=new ArrayList<WestMedi>();
			List<Prescription> presList=new ArrayList<Prescription>();
			List<Prescription> presList1=new ArrayList<Prescription>();
			List<ChinMediMate> mediMateList=new ArrayList<ChinMediMate>();
			List<ChinMediMate> mediMateList1=new ArrayList<ChinMediMate>();
			List<ChinPateMedi> pateMediList=new ArrayList<ChinPateMedi>();
			List<ChinPateMedi> pateMediList1=new ArrayList<ChinPateMedi>();
			
			 /**搜索词长度大于2的情况**/
			if(search_str.length()>2){
				System.out.println("搜索词分解");
				 for(int i=0;i<search.length;i++){
					 
					 /**对于每一个拆分后的长度为2的词，进行一次搜索，结果都存入相应List中**/
					 westMediList1 = dao.queryWestMedi(search[i]);
					 presList1 = dao.queryPrescription(search[i]);
					 mediMateList1 = dao.queryChinMediMate(search[i]);
					 pateMediList1 = dao.queryChinPateMedi(search[i]);
					 for(int j=0;j<westMediList1.size();j++){
						 westMediList.add(westMediList1.get(j));
					 }
					 for(int j=0;j<presList1.size();j++){
						 presList.add(presList1.get(j));
					 }
					 for(int j=0;j<mediMateList1.size();j++){
						 mediMateList.add(mediMateList1.get(j));
					 }
					 for(int j=0;j<pateMediList1.size();j++){
						 pateMediList.add(pateMediList1.get(j));
					 }
				 }
			}else{
				 /**搜索词长度小于等于2的情况**/
				 westMediList = dao.queryWestMedi(search_str);
				 presList = dao.queryPrescription(search_str);
				 mediMateList = dao.queryChinMediMate(search_str);
				 pateMediList = dao.queryChinPateMedi(search_str);
			}
			
			int totalNum = westMediList.size() + presList.size()
					+ mediMateList.size()+pateMediList.size();
			
			/**每种药物的个数！！！！*/
			number.put("NwestMedi",westMediList.size());
			number.put("Nprescrip",presList.size());
			number.put("NmediMate",mediMateList.size());
			number.put("NpateMedi",pateMediList.size());
			
			if (totalNum == 0) {
				json.put("nullInfo","无此药物数据，请重新输入");
			} else {
				
				/**定义西药，方剂，中药材和中成药对象*/
				WestMedi westmedi;
				Prescription pres;
				ChinMediMate medimate;
				ChinPateMedi chinpate;
				
				/**预定义要显示字段信息，做非空处理**/
				String MediId="";
				String Picture="";
				String Name="";
				String Function="";
				String Usage="";
				String Precaution="";
				//   从西药表中查询
				for (int i = 0; i < westMediList.size(); i++) {
					westmedi = westMediList.get(i);
					
					MediId=westmedi.getWestMediId();
					Picture=westmedi.getPicture();
					Name=westmedi.getWestMediName();
					Function=westmedi.getSymptom();
					Usage=westmedi.getUsagDosa();
					Precaution=westmedi.getPrecaution();
					
					if(Picture!=null){
						westMedi.put("Picture", westmedi.getPicture());    /**药物图片*/
					}else{
						westMedi.put("Picture", "");
					}
					westMedi.put("MediId", MediId);  /**药物编号**/
					westMedi.put("Name", westmedi.getWestMediName());  /**药名*/
					
					westMedi.put("Function", westmedi.getSymptom());   /**功效*/
					westMedi.put("Usage", westmedi.getUsagDosa());      /**使用方法*/
					westMedi.put("Precaution", westmedi.getPrecaution());  /**注意事项*/
					westMedi.put("Contraindication", westmedi.getContraindication());  /**注意事项*/
					
					array1.add(westMedi);   /**将药物信息存入json数组中，用以返回至JSP页面*/
					array.add(westMedi);

				}
				// ******查询方剂*******
				for (int i = 0; i < presList.size(); i++) {
					pres = presList.get(i);
					prescrip.put("MediId", pres.getPresId());  /**药物编号**/
					prescrip.put("Picture", pres.getPicture());   /**药物图片*/
					prescrip.put("Name", pres.getPresName());    /**药名*/
					prescrip.put("Function", pres.getFunction());  /**功效*/
					prescrip.put("MajorFunction", pres.getMajorFunction());  /**主治**/
					prescrip.put("Usage", pres.getUsagDosa());     /**使用方法*/
					prescrip.put("Precaution", pres.getPrecaution());  /**注意事项*/
					
					array2.add(prescrip);  /**将药物信息存入json数组中，用以返回至JSP页面*/
					array.add(prescrip);
				}

				// ******查询中药材，参数处理流程同西药、方剂*******
				for (int i = 0; i < mediMateList.size(); i++) {
					medimate = mediMateList.get(i);
					mediMate.put("MediId", medimate.getMediMateId());
					mediMate.put("Picture", medimate.getPicture());
					mediMate.put("Name", medimate.getMediMateName());
					Function=medimate.getFunction();
					if(Function!=null){
						mediMate.put("Function", medimate.getFunction());
					}else{
						mediMate.put("Function", "尚不明确");
					}
					mediMate.put("MajorFunction", medimate.getMajorFunction());  /**主治**/
					Precaution=medimate.getPrecaution();
					if(Precaution!=null){
						mediMate.put("Precaution",Precaution);
					}else{
						mediMate.put("Precaution", "尚不明确");
					}
					mediMate.put("Usage", medimate.getUsagDosa());
					
					array3.add(mediMate);
					array.add(mediMate);
				}
				
				// ******查询中成药，处理方法同上*******
				for (int i = 0; i < pateMediList.size(); i++) {
					chinpate = pateMediList.get(i);
					pateMedi.put("MediId", chinpate.getPateMediId());
					pateMedi.put("Picture", chinpate.getPicture());
					pateMedi.put("Name", chinpate.getPateMediName());
					pateMedi.put("Function", chinpate.getFunction());
					pateMedi.put("Usage", chinpate.getUsagDosa());
					pateMedi.put("Precaution", chinpate.getAdveActi());
					
					array4.add(pateMedi);
					array.add(pateMedi);
				}
				
			}
			
			/**定义json数组，用以分页返回药物信息**/
			JSONArray arrayWestMedi = new JSONArray();
			JSONArray arrayPrescrip = new JSONArray();
			JSONArray arrayMediMate = new JSONArray();
			JSONArray arrayPateMedi = new JSONArray();
			
			/**分页显示，每页显示4条记录，最终每种药物都存入json数组，JSP显示*/
			for(int i=NpageIndex * 4 - 4;i < NpageIndex * 4; i++){
				
				/**当查询结果数大于分页值，就将药物记录加入到json数组中*/
				if(i<array1.size()){
					arrayWestMedi.add(array1.get(i));
				}
				/**同上*/
				if(i<array2.size()){       
					arrayPrescrip.add(array2.get(i));  
				}
				if(i<array3.size()){       
					arrayMediMate.add(array3.get(i));   
				}
				if(i<array4.size()){       
					arrayPateMedi.add(array4.get(i));   
				}
				
			}
			
			System.out.println("搜寻的相关药物个数："+array.size());
			
			json.put("account", array.size());
			json.put("medicineArray", array);
			
			json.put("number",number);        //每种药物的数目！！！！
			json.put("westMediArray", arrayWestMedi);   /**西药**/
			json.put("prescripArray", arrayPrescrip);     /**方剂**/
			json.put("MediMateArray", arrayMediMate);      /**中药材**/
			json.put("pateMediArray", arrayPateMedi);       /**中成药**/
			
			out.println(json.toString());   // 将查询到的药物送到端页面！！
			out.flush();
			out.close();
			return "success";
		}


}
