package com.netmed.action.member;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.MembRegiDAO;
import com.netmed.pojo.MembRegi;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 类<code>MembLoginAction</code> 会员登录的action
 * @author yang
 * @version 1.0
 * 
 */
public class MembInfoAction extends ActionSupport {
	
	private static final long serialVersionUID = -7714303460118401449L;

	/**
	 * 获取用户中心个人信息
	 * 
	 * @return
	 */
	public String getMembCenData() {
		System.out.println("运行到了获取会员getMembCenData----积分，等级，余额，头像");
		// 取得request对象和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		//获取session对象，以便获取用户id
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			/**获取会员Id**/
		    String username = new String(session.get("username").toString()
					.getBytes("iso8859-1"), "utf-8");
			out = response.getWriter();
			JSONObject json = new JSONObject();
			
			/**Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			MembRegiDAO dao = (MembRegiDAO) otx.getBean("MembRegiDAO");
			int rank,credit;
			float money;
			String head_img="";
			if(username!=null){
				//调用getMembinfoById方法，通过用户id查找个人中心信息
				MembRegi memb = dao.getMembinfoById(username);
				rank=memb.getRank();
				credit=memb.getCredit();
				money=memb.getMoney();
				head_img=memb.getHeadImg();
			}else{
				rank=0;
				credit=0;
				money=0;
				head_img="";
			}
			json.put("rank",rank );
			json.put("credit",credit);
			json.put("money", money);
			json.put("head_img",head_img);
			
			out.println(json.toString());

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
		return null;
	}

	/**
	 * 获取会员个人信息
	 * 
	 * @return
	 */
	public String getPersonInfo() {
		System.out.println("运行到了获取会员个人信息----用户名，手机，邮箱");
		String forward = "success";
		// 取得request对象和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		//通过session得到会员id
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			// 获取会员id
			String username = new String(session.get("username").toString()
					.getBytes("iso8859-1"), "utf-8");
			out = response.getWriter();
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			MembRegiDAO dao = (MembRegiDAO) otx.getBean("MembRegiDAO");
			//调用getMembinfoById方法，通过用户id查找个人中心信息
			MembRegi memb = dao.getMembinfoById(username);
			JSONObject json = new JSONObject();

			/**会员的真实姓名,电话和邮箱**/
			String realName=memb.getRealName();
			String phone=memb.getPhonNumb();
			String mail=memb.getMembEmai();
			
			/**做非空判断，如果为空，推荐用户及时填写**/
			if("".equals(realName)||null==realName){
				json.put("username", "您还没填写,请尽快完善");
			}else{
				json.put("username", realName);
			}
			if("".equals(phone)||null==phone){
				json.put("phone", "您还没填写,请尽快完善");
			}else{
				json.put("phone", phone);
			}
			if("".equals(mail)||null==mail){
				json.put("mail", "您还没填写,请尽快完善");
			}else{
				json.put("mail", mail);
			}
			
			/**将json数据返回JSP页面**/
			out.println(json.toString());

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			forward = "error";// 出错返回当前页面
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}

		return forward;
	}

	/**
	 * 更新用户个人信息
	 * 
	 * @return
	 */
	public String updatePersonInfo() {
		System.out.println("更新用户个人信息！");
		String forward = "success";
		// 取得request对象和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		//获取session，以便获得会员id
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			// 获取会员id
			String username = new String(session.get("username").toString()
					.getBytes("iso8859-1"), "utf-8");
			out = response.getWriter();
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			MembRegiDAO dao = (MembRegiDAO) otx.getBean("MembRegiDAO");
			//调用getMembinfoById方法，通过用户id查找个人中心信息
			MembRegi memb = dao.getMembinfoById(username);
			String name = new String(request.getParameter("memb_name")
					.getBytes("iso8859-1"), "utf-8");
			String memb_mobile = new String(request.getParameter("memb_mobile")
					.getBytes("iso8859-1"), "utf-8");
			String memb_mail = new String(request.getParameter("memb_mail")
					.getBytes("iso8859-1"), "utf-8");
			memb.setRealName(name);
			memb.setPhonNumb(memb_mobile);
			memb.setMembEmai(memb_mail);
			dao.UpdateMembRegi(memb);
			
			out.println("yes");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 出错返回当前页面
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}

		return forward;
	}

	public String ensurePass() {
		System.out.println("运行到了---ensurePass！");
		String forward = "success";
		//获取request和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		//获取session，以便获得会员id
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//通过session获得会员id
			String username = new String(session.get("username").toString()
					.getBytes("iso8859-1"), "utf-8");
			out = response.getWriter();
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			MembRegiDAO dao = (MembRegiDAO) otx.getBean("MembRegiDAO");
			//调用getMembinfoById方法，通过用户id查找个人中心信息
			MembRegi memb = dao.getMembinfoById(username);
			String passConInput = request.getParameter("passConInput");
			if (memb.getMembPass().equals(passConInput)) {
				out.println("yes");
			} else {
				out.println("no");
			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 出错返回当前页面
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}

		return forward;
	}

	/**
	 * 更新密码
	 * 
	 * @return
	 */
	public String updatePass() {
		System.out.println("运行到了----updatePass");
		String forward = "success";
		//获取request和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		//获取session，以便获得会员id
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//通过session获得会员id
			String username = new String(session.get("username").toString()
					.getBytes("iso8859-1"), "utf-8");
			out = response.getWriter();
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			MembRegiDAO dao = (MembRegiDAO) otx.getBean("MembRegiDAO");
			//调用getMembinfoById方法，通过用户id查找个人中心信息
			MembRegi memb = dao.getMembinfoById(username);
			String newpassConInput = request.getParameter("newpassConInput");
			memb.setMembPass(newpassConInput);
			//调用UpdateMembRegi方法，对数据库数据进行更新操作
			dao.UpdateMembRegi(memb);
			out.println("yes");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 出错返回当前页面
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}

		return forward;
	}
	
	//根据会员id获取该会员的财务信息，积分credit和账户余额money
	public String getPayInfoById() {

		System.out.println("运行到了获取会员个人信息----getPayInfoById");
		String forward = "success";
		//获取request和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		//获取session，以便获得会员id
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//通过session获得会员id
			String username = new String(session.get("username").toString()
					.getBytes("iso8859-1"), "utf-8");
			out = response.getWriter();
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			MembRegiDAO dao = (MembRegiDAO) otx.getBean("MembRegiDAO");
			//调用getMembinfoById方法，通过用户id查找个人中心信息
			MembRegi memb = dao.getMembinfoById(username);
			JSONObject json = new JSONObject();
			//获取积分credit和账户余额money信息
			json.put("credit", memb.getCredit());
			json.put("money", memb.getMoney());
			out.println(json.toString());

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 出错返回当前页面
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
		return forward;
	}
}
