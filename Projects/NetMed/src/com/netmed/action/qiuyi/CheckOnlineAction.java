package com.netmed.action.qiuyi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.ChatDao;
import com.netmed.dao.DoctorDAO;
import com.netmed.pojo.Chat;
import com.netmed.pojo.ExpeRegi;
import com.netmed.pojo.MembRegi;
import com.opensymphony.xwork2.ActionSupport;


/***
 * 判断专家是否在线action，为在线咨询提供参考
 * @author Administrator
 *
 */
public class CheckOnlineAction extends ActionSupport {

	private static final long serialVersionUID = 1L;


	public String execute() {
		System.out.println("运行到了CheckOnlineAction！---判断专家是否在线");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		
		/**在线咨询需要的数据，发送信息者，接受请求者**/
		String sender = "";
		String reciver = "";
		String acceptjson = "";
		
		JSONObject data = null;
		PrintWriter out = null;
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			out = response.getWriter();
			
			/**读取页面传来的json数据**/
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(ServletInputStream) request.getInputStream(), "utf-8"));
			StringBuffer sb = new StringBuffer("");
			String temp;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
			br.close();
			acceptjson = sb.toString();
			System.out.println(acceptjson);
			if (acceptjson != "") {
				data = JSONObject.fromObject(acceptjson);
				sender = data.get("sender").toString();    /**会员id：发送在线咨询请求**/
				reciver = data.get("reciver").toString();  /**专家id：接受在线咨询请求**/
				
				System.out.println(sender + "----->" + reciver);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		String forward = "";
		ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DoctorDAO dao = (DoctorDAO)otx.getBean("DoctorDAO");
		
		//判断专家receive 是否在线！！！
		//dao.isOnline(reciver)
		
		/**如在线，则返回yes，并调用setChat方法创建一条在线咨询记录**/
		if(dao.isOnline(reciver)){
		   out.println("yes");
		   forward = "success";
		   setChat(sender, reciver);
		}
		else{
			out.println("no");
			forward = "error";
		}
		out.flush();
		out.close();
	
		return forward;
	}
	
	/**专家在线，调用该方法创建一条在线咨询记录**/
    private void setChat(String sender,String reciver){
    	 ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
    	 ExpeRegi expeRegi =new ExpeRegi(reciver);
		 MembRegi membRegi = new MembRegi(sender);
		 ChatDao chatDao = (ChatDao)otx.getBean("ChatDao");
		 
		 /**创建一条在线咨询chat对象，设置专家id，会员id，以及状态设置为false，见数据库表chat**/
		 Chat chat = new Chat();
		 chat.setExpeRegi(expeRegi);
		 chat.setMembRegi(membRegi);
		 chat.setState(Boolean.FALSE);
		 chatDao.AddChat(chat);
    }

}
