package com.netmed.action.member;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.MembRegiDAO;
import com.opensymphony.xwork2.ActionSupport;

/**类<code>MembLoginAction</code>
 * 会员登录的action
 * @author yang
 * @version 1.0
 *
 */
public class MembLoginAction extends ActionSupport {
	
	private static final long serialVersionUID = -7714303460118401449L;
	/** 方法<code>execute</code>
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Spring调用相应DAO
		MembRegiDAO dao=(MembRegiDAO)otx.getBean("MembRegiDAO");
		//获取request对象
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		//使用request获取用户id和密码
		String username=(String)request.getParameter("username");
		String password=(String)request.getParameter("password");
		System.out.println("用户名："+username);
		System.out.println("密    码："+password);
		//调用checkLogin方法，进行用户登录检查，合法返回true，否则返回false
		int t=dao.checkLogin(username, password);
		System.out.println("error类型 t="+t);
		if(t==0){
			//获取session对象
			HttpSession session=request.getSession();
			//将会员id存入session中，以供页面使用
			session.setAttribute("username", username);
			dao.setState(username, Boolean.TRUE);
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
