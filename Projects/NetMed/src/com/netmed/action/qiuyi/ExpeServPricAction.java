package com.netmed.action.qiuyi;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.netmed.dao.ExpeServPricDAO;
import com.netmed.pojo.ExpeServPric;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 专家服务价格action，读取相应专家的服务价格
 * @author Administrator
 */

public class ExpeServPricAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		JSONObject result=new JSONObject();
		try {
			
			 /**Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			ExpeServPricDAO dao=(ExpeServPricDAO)otx.getBean("ExpeServPricDAO");
			
			/**查询等级为3，专家类型为1的服务价格**/
			List<ExpeServPric> list=dao.getPriceByTypeAndRank(1, 3);
			
			/**存入json数据的price字段**/
			result.put("price",list.get(0).getPrice());
			out = response.getWriter();
			out.println(result.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		out.flush();
		out.close();
		return super.execute();
	}

}
