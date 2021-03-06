package com.netmed.action.expert;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.netmed.dao.ExpeRegiDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ExpeLoginAction extends ActionSupport{

	/**
	 * 专家登录action
	 */
	private static final long serialVersionUID = 4785208146902186608L;

	@Override
	public String execute() throws Exception {
		/**Spring调用DAO**/
		ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ExpeRegiDAO dao = (ExpeRegiDAO)otx.getBean("ExpeRegiDAO");
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		/**获取页面的用户名和密码**/
		String username=(String)request.getParameter("username");
		String password=(String)request.getParameter("password");
		
		/**调用方法，登录检查，返回值0正确,1用户名为空,2其他错误**/
		int t=dao.checkLogin(username, password);
		if(t==0){
			HttpSession session=request.getSession();
			session.setAttribute("expename", username);
			PrintWriter out = null;
			out = response.getWriter();
			String js="<script type='text/javaScript'>"+
			"history.go(-1);self.location=document.referrer;</script>";
			out.println(js);
			out.flush();
			out.close();
		return null;
		}
		else{
			request.setAttribute("error", t);
			return ERROR;
			}
	}
}
