package com.netmed.action.member;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.ExpeRegiDAO;
import com.netmed.dao.MembRegiDAO;
import com.netmed.pojo.ExpeRegi;
import com.netmed.pojo.MembRegi;
/**
 * 实现退出当前帐号的功能
 * @author larch
 *
 */
public class LogoutAction {
	//实现退出当前帐号
	public String Logout(){
		System.out.println("LogoutAction---Logout()");
		//获取request对象和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		ApplicationContext otx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		//Spring调用相应DAO
		MembRegiDAO mDao = (MembRegiDAO) otx
				.getBean("MembRegiDAO");
		//Spring调用相应DAO
		ExpeRegiDAO eDao = (ExpeRegiDAO) otx
				.getBean("ExpeRegiDAO");
		//获取session对象
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		String forward="error";
		System.out.println("forward---");
		String name="";
		try {
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");	
				name=request.getParameter("name");
				System.out.println("会员编号："+name);
		} catch (UnsupportedEncodingException e) {
			    System.out.println("会员编号："+4444);
				e.printStackTrace();
		  }	
		
			System.out.println("专家编号："+name);
			ExpeRegi expert=eDao.getExpeinfoById(name);
			//调用getMembinfoById方法，通过id查看用户注册信息
			MembRegi member=mDao.getMembinfoById(name);
			
			if(expert!=null){
				System.out.println("专家--"+expert.getExpeId()+"退出");
				expert.setState(false);
				eDao.UpdateExpeRegi(expert);
				session.clear();
				forward="success";
				
			}else if(member!=null){
				System.out.println("会员--"+member.getMembId()+"退出");
				member.setState(false);
				mDao.UpdateMembRegi(member);
				session.clear();
				forward="success";
			}else{
				forward="error";
			}
		return forward;
   }
	
}
