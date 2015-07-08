package com.netmed.action.wenyao;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.MedicineDetailDAO;
import com.netmed.pojo.ChinMediMate;
import com.netmed.pojo.ChinPateMedi;
import com.netmed.pojo.Prescription;
import com.netmed.pojo.WestMedi;

/**
 * @author Administrator 药物详情页面，通过得到药物Id，输出该药的详细信息 05-17
 */
public class MedicineDetailAction {

	public String execute() {

		System.out.println("运行到了问药action！---显示药物详细信息");
		/**获取request对象和response对象**/
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		PrintWriter out = null;
		String mediId = "";     /**药物编号**/
		try {
			 /**设置request对象和response对象编码格式为utf-8**/
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			out = response.getWriter();
			
			/**从jsp页面获取药物编号**/
			mediId = new String(request.getParameter("mediId").getBytes(
					"iso8859-1"), "utf-8"); 
			System.out.println("输入的药物ID：" + mediId);
			
		} catch (UnsupportedEncodingException e1) {
			System.out.println("不能获取搜索关键词");
			e1.printStackTrace();
		} catch (IOException e) {
			System.out.println("不能获取搜索关键词");
			e.printStackTrace();
		}

		 /**定义json对象，用以存储药物信息并返回到jsp页面**/
		JSONObject json = new JSONObject();
		JSONObject medicine = new JSONObject();

		 /**Spring调用DAO**/
		ApplicationContext otx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		MedicineDetailDAO dao = (MedicineDetailDAO) otx
				.getBean("MedicineDetailDAO");

		// 根据ID判断为何种药物，进行详细输出！！！
		// 统一加一个类型字段，方便判断！！！
		 /**西药前缀：xy----中药材前缀：zyc----中成药：zcy-----方剂:fj----**/
		System.out.println("药物编号前缀prefix:--"+mediId.substring(0,2));
		
		if (mediId.substring(0, 2).equals("xy")) { /* 西药 */
			WestMedi westMedi = dao.FindWestMediById(mediId);             /**通过药物id查询药物对象**/
			medicine.put("type", "westMedi");                    /**药物类型字段，方便显示**/
			medicine.put("mediId", westMedi.getWestMediId());    /**药物id**/
			medicine.put("name", westMedi.getWestMediName());    /**药物名称**/
			medicine.put("ingredient", westMedi.getIngredient());/**药物组成**/
			medicine.put("Yfunction", westMedi.getSymptom());    /**药物功效**/
			medicine.put("usage", westMedi.getUsagDosa());       /**药物使用方法**/
			medicine.put("adverseAction", westMedi.getAdveReac());/**药物不良反应**/
			medicine.put("precaution", westMedi.getPrecaution()); /**药物注意事项**/
			medicine.put("storage", westMedi.getStorage());       /**药物储存方法**/
			medicine.put("enterprise", westMedi.getEnterprise());  /**药物生产企业**/

		} else if (mediId.substring(0, 2).equals("fj")) { /* 方剂 */
			Prescription pres = dao.FindPrescripById(mediId);
			medicine.put("type", "prescrip");
			medicine.put("mediId", pres.getPresId());
			medicine.put("name", pres.getPresName());
			medicine.put("ingredient", pres.getComposition());
			medicine.put("Yfunction", pres.getFunction());
			medicine.put("usage", pres.getUsagDosa());
			medicine.put("diagnoseSynd", pres.getDiagSyndPoin());
			medicine.put("precaution", pres.getPrecaution());
			medicine.put("presSong", pres.getPresSong());
			medicine.put("institution", pres.getInstitution());  /**服务机构**/
			
			
		} else if (mediId.substring(0, 3).equals("zyc")) { /* 中药材 */
			ChinMediMate mediMate = dao.FindMediMateById(mediId);
			medicine.put("type", "mediMate");
			medicine.put("mediId", mediMate.getMediMateId());
			medicine.put("name", mediMate.getMediMateName());
			medicine.put("ingredient", mediMate.getChemIngr());
			medicine.put("Yfunction", mediMate.getFunction());
			medicine.put("ancientBook", mediMate.getAnciBookSumm());  /**古籍摘要**/
			medicine.put("usage", mediMate.getUsagDosa());
			medicine.put("precaution", mediMate.getPrecaution());
			medicine.put("institution", mediMate.getInstitution());  /**服务机构**/
			
		} else if (mediId.substring(0, 3).equals("zcy")) { /* 中成药 */
			ChinPateMedi pateMedi = dao.FindPateMediById(mediId);
			medicine.put("type", "pateMedi");
			medicine.put("mediId", pateMedi.getPateMediId());
			medicine.put("name", pateMedi.getPateMediName());
			medicine.put("ingredient", pateMedi.getIngredient());
			medicine.put("Yfunction", pateMedi.getFunction());
			medicine.put("usage", pateMedi.getUsagDosa());
			medicine.put("specification", pateMedi.getSpecification());
			medicine.put("precaution", pateMedi.getPrecaution());
			medicine.put("enterprise", pateMedi.getEnterprise());  /**药物生产企业**/
			
		} else {
			medicine.put("type", "0");
			medicine.put("mediId", "对不起，输入有误");
			medicine.put("name", "对不起，输入有误");
			medicine.put("ingredient", "对不起，输入有误");
			medicine.put("function", "对不起，输入有误");
			medicine.put("usage", "对不起，输入有误");
			medicine.put("precaution", "对不起，输入有误");
		}
		
		json.put("medicine", medicine);
		out.println(json.toString()); // 将查询到的药物送到端页面！！
		out.flush();
		out.close();
		
		return "success";

	}

}
