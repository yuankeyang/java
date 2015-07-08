package com.netmed.action.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.ExpeRegiDAO;
import com.netmed.dao.MembRegiDAO;
import com.netmed.pojo.ExpeRegi;
import com.netmed.pojo.MembRegi;
import com.opensymphony.xwork2.ActionSupport;

/**类<code>MembRegiAction</code>
 * 完成会员注册的action类
 *@author 远客
 *@version 1.0
 *
 */
public class MembRegiAction extends ActionSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 550127190947974011L;

	@Override
	public String execute() throws Exception {
		//获取request对象
		HttpServletRequest request=ServletActionContext.getRequest();
		//使用request对象获取用户的基本信息
		String username=request.getParameter("username");
		String mail=request.getParameter("email");
		String sex=request.getParameter("sex");
		String password=request.getParameter("password");
		System.out.println(sex);
		Boolean s=Boolean.TRUE;
		if(sex.equals("female")) s=Boolean.FALSE;
		ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Spring调用相应DAO
		MembRegiDAO dao=(MembRegiDAO)otx.getBean("MembRegiDAO");
		//调用regiMemb方法，保存对象到数据库，返回true，表示注册成功，否则失败
		if(dao.regiMemb(username, mail, s, password)){
       //dao.setState(username, Boolean.TRUE);
			return SUCCESS;
			}
		else
			return ERROR;
	}
	
	//获取会员积分credit
	public String getMemberCredit(){
		//获取request对象和response对象
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String forward="success";
		//获取会员id
		String userId=request.getParameter("userId");
		System.out.println("运行到了getMemberCredit---会员："+userId);
		
		ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Spring调用相应DAO
		MembRegiDAO dao=(MembRegiDAO)otx.getBean("MembRegiDAO");
		//调用getMemberCredit方法，通过用户ID获取用户积分
		int credit=dao.getMemberCredit(userId);
		System.out.println("会员积分为："+credit);
		String str = String.valueOf(credit);
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		json.put("credit", str);
		try {
			out = response.getWriter();
			
		} catch (IOException e) {
			e.printStackTrace();
			forward="error";
		}
		out.println(json.toString());
		out.flush();
		out.close();
		return forward;
	}
	
	//实现对会员进行收费操作
	public String payAction(){
		System.out.println("运行到了payAction----同时更新会员和专家积分");
		//获取request对象
		HttpServletRequest request=ServletActionContext.getRequest();
		String forward="success";
		try {
			//利用request对象获取会员id，会员希望向其获取服务的专家id，专家姓名，还有用户输入的搜索词
			String userId=new String(request.getParameter("userId").getBytes("iso8859-1"),"utf-8");
			String expe_id= new String(request.getParameter("expe_id").getBytes("iso8859-1"),"utf-8");
			String expe_name = new String(request.getParameter("expe_name").getBytes("iso8859-1"),"utf-8");
			String searchSelect = new String(request.getParameter("searchSelect").getBytes("iso8859-1"),"utf-8");
			//将获取的值存入session中
			HttpSession session = request.getSession();
			session.setAttribute("expe_id", expe_id);
			session.setAttribute("expe_name", expe_name);
			session.setAttribute("searchSelect", searchSelect);

			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			//Spring调用相应DAO
			MembRegiDAO dao=(MembRegiDAO)otx.getBean("MembRegiDAO");
			ExpeRegiDAO expertDao=(ExpeRegiDAO)otx.getBean("ExpeRegiDAO");
			//调用getMembinfoById方法，通过用户id获取用户信息
			MembRegi member=dao.getMembinfoById(userId);
			//调用getExpeinfoById方法，通过专家id获取专家信息
			ExpeRegi expert=expertDao.getExpeinfoById(expe_id);
			
			//分别获取用户和专家的积分
			int membCredit=member.getCredit();
			int expeCredit=expert.getCredit();
			System.out.println(userId+"当前积分为:"+membCredit);
			System.out.println(expe_id+"当前积分为:"+expeCredit);
			//对用户和专家的积分进行加减操作
			membCredit=membCredit-10;
			expeCredit=expeCredit+10;
			member.setCredit(membCredit);
			expert.setCredit(expeCredit);
			//调用calculateCredit方法，根据用户ID，减掉用户相应积分，返回true，代表操作成功
			if(dao.UpdateMembRegi(member)){
				System.out.println("更新会员积分成功！");
				forward="success";
			}else{
				System.out.println("更新会员积分失败！");
				forward="error";
			}
			//调用calculateCredit方法，根据专家ID，加上专家相应积分，返回true，代表操作成功
			if(expertDao.UpdateExpeRegi(expert)){
				System.out.println("更新专家积分成功！");
				forward="success";
			}else{
				System.out.println("更新专家积分失败！");
				forward="error";
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			forward="error";
		}
		return forward;
		
	}
	
	//实现对会员进行收费操作
	public String payAction2(){
		System.out.println("运行到了payAction----同时更新会员和专家积分");
		//获取request对象
		HttpServletRequest request=ServletActionContext.getRequest();
		String forward="success";
		
		try {
			//利用request对象获取会员id，会员希望向其获取服务的专家id
			String userId=new String(request.getParameter("userId").getBytes("iso8859-1"),"utf-8");
			String expe_id= new String(request.getParameter("expe_id").getBytes("iso8859-1"),"utf-8");
			System.out.println("运行到了payAction---会员："+userId);
			System.out.println("运行到了payAction---专家ID："+expe_id);
			//将获取的值存入session中
			HttpSession session = request.getSession();
			session.setAttribute("expe_id", expe_id);

			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			//Spring调用相应DAO
			MembRegiDAO dao=(MembRegiDAO)otx.getBean("MembRegiDAO");
			ExpeRegiDAO expertDao=(ExpeRegiDAO)otx.getBean("ExpeRegiDAO");
			//调用getMembinfoById方法，通过用户id获取用户信息
			MembRegi member=dao.getMembinfoById(userId);
			//调用getExpeinfoById方法，通过专家id获取专家信息
			ExpeRegi expert=expertDao.getExpeinfoById(expe_id);
			//分别获取用户和专家的积分
			int membCredit=member.getCredit();
			int expeCredit=expert.getCredit();
			System.out.println(userId+"当前积分为:"+membCredit);
			System.out.println(expe_id+"当前积分为:"+expeCredit);
			
			membCredit=membCredit-10;
			expeCredit=expeCredit+10;
			member.setCredit(membCredit);
			expert.setCredit(expeCredit);
			//调用calculateCredit方法，根据用户ID，减掉用户相应积分，返回true，代表操作成功
			if(dao.UpdateMembRegi(member)){
				System.out.println("更新会员积分成功！");
				forward="success";
			}else{
				System.out.println("更新会员积分失败！");
				forward="error";
			}
			//调用calculateCredit方法，根据专家ID，加上专家相应积分，返回true，代表操作成功
			if(expertDao.UpdateExpeRegi(expert)){
				System.out.println("更新专家积分成功！");
				forward="success";
			}else{
				System.out.println("更新专家积分失败！");
				forward="error";
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			forward="error";
		}
		return forward;
	}
}
