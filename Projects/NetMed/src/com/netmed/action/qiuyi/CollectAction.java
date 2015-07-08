package com.netmed.action.qiuyi;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.netmed.dao.CollectionDAO;
import com.netmed.pojo.Collection;
import com.netmed.pojo.ExpeRegi;
import com.netmed.pojo.MembRegi;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 专家收藏与取消收藏
 * 
 * @author larch
 * 
 */
public class CollectAction extends ActionSupport {
	

	private static final long serialVersionUID = 1L;

	public String execute() {
		// 取得reqeust对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		PrintWriter out = null;
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			System.out.println(new String(request.getParameter("collect").getBytes("iso8859-1"), "utf-8"));
			String userId = new String(request.getParameter("userId").getBytes("iso8859-1"), "utf-8");
			out = response.getWriter();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String forward = "";
		
		//根据获得字段值：用户ID，专家ID和是否收藏，进行选择，收藏or取消收藏
		ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
		CollectionDAO dao = (CollectionDAO)otx.getBean("CollectionDAO");
		
		String collect;
		try {
			
			/**从页面获取是否收藏参数**/
			collect = new String(request.getParameter("collect").getBytes("iso8859-1"), "utf-8");
			
			/**还未收藏，则收藏**/
			if(collect.equals("收藏")){
				MembRegi membRegi=new MembRegi((String) session.get("username"));
				ExpeRegi expeRegi=new ExpeRegi(new String(request.getParameter("userId").getBytes("iso8859-1"), "utf-8"));
				Collection co=new Collection(expeRegi,membRegi,true);
				dao.SaveCollection(co);
				System.out.println("收藏"+expeRegi.getExpeId()+"成功！！！");
				out.println("yes");
			}
			/**已收藏则取消收藏**/
			else{    
				dao.CancelCollection(new String(request.getParameter("userId").getBytes("iso8859-1"), "utf-8"), (String) session.get("username"));
				out.println("yes");
			}
			out.flush();
			out.close();
			
			forward = "success";
					
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			out.println("no");
			forward = "error";
		}
		return forward;
	}

}
