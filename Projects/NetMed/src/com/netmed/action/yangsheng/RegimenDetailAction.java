package com.netmed.action.yangsheng;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.RegimenDetailDAO;
import com.netmed.pojo.*;

/**
 *  @author Administrator
 *  养生品详情展示
 *  05-19
 */
public class RegimenDetailAction {

	public String execute() {
		System.out.println("运行到了RegimenDetailAction---显示养生品详细信息");

		/**获取request对象和response对象**/
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		PrintWriter out = null;
		String regiId = "";    /**养生品编号**/
		try {
			
			/**设置编码格式**/
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			out = response.getWriter();
			
			/**从jsp页面获取养生品编号**/
			regiId = new String(request.getParameter("regiId").getBytes(
					"iso8859-1"), "utf-8"); 
			System.out.println("输入的养生ID：" + regiId);
		
	     /**定义json对象，用以存储养生品信息并返回到jsp页面**/
		JSONObject regimen = new JSONObject();

		 /**Spring调用DAO**/
		ApplicationContext otx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		RegimenDetailDAO dao = (RegimenDetailDAO) otx
				.getBean("RegimenDetailDAO");

		// 根据ID判断为何种药物，进行详细输出！！！
		// 统一加一个类型字段，方便判断！！！
		 /**保健食品：bj----养生复方：ff----浴方：yf-----按摩法:amf----医疗器械:qx**/
		System.out.println("prefix:--" + regiId.substring(0, 2));

		if (regiId.length()>1&&regiId.substring(0, 2).equals("bj")) { /* 保健食品 */
			HealFood food = dao.FindHealFoodById(regiId);             /**通过养生品id查询对象**/
			regimen.put("type", "healFood");                          /**养生品类型字段，方便显示**/
			regimen.put("regiId", food.getHealFoodId());              /**养生品编号**/
			regimen.put("name", food.getHealFoodName());              /**养生品名**/
			regimen.put("ingredient", food.getFuncIngrCont());        /**养生品组成**/
			regimen.put("Yfunction", food.getFunction());             /**养生品功效**/
			regimen.put("usage", food.getEdibMeth());                 /**养生品使用方法**/
			regimen.put("precaution", food.getPrecaution());          /**养生品注意事项**/
			regimen.put("storage", food.getStorMeth());               /**养生品储存**/
			regimen.put("enterprise", food.getEnterprise());          /**养生品生产企业**/

		} else if (regiId.length()>1&&regiId.substring(0, 2).equals("ff")) { /* 复方*/
			ChinRegiComp comp = dao.FindChinRegiCompById(regiId);
			regimen.put("type", "regiComp");
			regimen.put("regiId", comp.getCompId());
			regimen.put("name", comp.getCompName());
			regimen.put("ingredient", comp.getFoodMate());
			regimen.put("Yfunction", comp.getFunction());
			regimen.put("usage", comp.getUsagDosa());
			regimen.put("precaution", comp.getPrecaution());
			regimen.put("makeMethod", comp.getMakeMeth());
			regimen.put("institution", comp.getInstitution());     /**养生品服务机构**/
			
		} else if (regiId.length()>1&&regiId.substring(0, 2).equals("yf")) { /* 浴方*/
			ChinMediBath bath = dao.FindMediBathById(regiId);
			regimen.put("type", "mediBath");
			regimen.put("regiId", bath.getBathId());
			regimen.put("name", bath.getBathName());
			regimen.put("ingredient", bath.getIngredient());
			regimen.put("Yfunction", bath.getFunction());
			regimen.put("usage", bath.getUsagDosa());
			regimen.put("precaution", bath.getPrecaution());
			regimen.put("institution", bath.getInstitution());     /**养生品服务机构**/
			
		} else if (regiId.length()>2&&regiId.substring(0, 3).equals("amf")) { /* 按摩方 */
			MassPres mass = dao.FindMassPresById(regiId);
			regimen.put("type", "massPres");
			regimen.put("regiId", mass.getMassId());
			regimen.put("name", mass.getMassName());
			regimen.put("Yfunction", mass.getFunction());
			regimen.put("usage", mass.getOperMeth());
			regimen.put("precaution", "无");
			regimen.put("institution", mass.getInstitution());     /**养生品服务机构**/
			
		}else if(regiId.length()>1&&regiId.substring(0, 2).equals("qx")){    /* 医疗器械 */
			HomeMediEqui equi=dao.FindMediEquiById(regiId);
			regimen.put("type", "mediEqui");
			regimen.put("regiId", equi.getProdId());
			regimen.put("name", equi.getProdName());
			regimen.put("apply", equi.getApply());         /**适用人群**/
			regimen.put("typeSpec", equi.getTypeSpec());         /**型号**/
			regimen.put("usage", equi.getUsage());   //  使用说明！！
			regimen.put("description", equi.getDescription());
			regimen.put("precaution", equi.getContraindication());
			regimen.put("enterprise", equi.getEnterprise());          /**养生品生产企业**/
			regimen.put("institution", equi.getInstitution());     /**养生品服务机构**/
		}
		else {
			regimen.put("type", "0");
			regimen.put("regiId", "对不起，输入有误");
			regimen.put("name", "对不起，输入有误");
			regimen.put("ingredient", "对不起，输入有误");
			regimen.put("function", "对不起，输入有误");
			regimen.put("usage", "对不起，输入有误");
			regimen.put("precaution", "对不起，输入有误");

		}

		out.println(regimen.toString()); // 将查询到的药物送到端页面！！
		out.flush();
		out.close();
		} catch (UnsupportedEncodingException e1) {
			System.out.println("不能获取搜索关键词");
			e1.printStackTrace();
		} catch (IOException e) {
			System.out.println("不能获取搜索关键词");
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "success";

	}

}
