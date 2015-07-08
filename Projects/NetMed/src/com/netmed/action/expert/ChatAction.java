package com.netmed.action.expert;

import java.io.PrintWriter;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.ChatDao;
import com.netmed.pojo.Chat;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 在线咨询action，判断专家是否有未处理的的在线咨询
 */

public class ChatAction extends ActionSupport{

	
	private static final long serialVersionUID = 4785208146902186608L;
	
	public String getChatDataByExpertId(){

		String forward = "success";
		
		/**获取request和response对象**/
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		
		/**获取session**/
		Map<String, Object> session = ServletActionContext.getContext().getSession();
		try {
			
			/**设置编码方式为utf-8**/
			request.setCharacterEncoding("utf-8");			
			response.setContentType("text/html;charset=utf-8");			
			
			//获取专家Id
			//-----------------------------------------------------------------------------------
			String expename = new String(session.get("expename").toString().getBytes("iso8859-1"), "utf-8");
			out = response.getWriter();
			/**Spring获取DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			ChatDao dao = (ChatDao)otx.getBean("ChatDao");
			/**通过专家ID找到未处理的在线咨询**/
			List<Chat> chats = dao.FindInfoByExpertId(expename);
			//System.out.println("轮询：专家 "+expename+"未处理的在线咨询有 "+chats.size());
            JSONObject json = new JSONObject();
            JSONArray array = new JSONArray();
            for(int i=0;i<chats.size();i++){
                JSONObject mem = new JSONObject();
                Chat chat = chats.get(i);
                mem.put("mem_id", chat.getMembRegi().getMembId());
                array.add(mem);
                chat.setState(Boolean.TRUE);  /**设置为已处理状态**/
                dao.UpdateChat(chat);          /**数据库更新**/
            }
            
            /**json数据格式返回到jsp页面**/
            json.put("account", chats.size());
            json.put("chatArray", array);
            out.println(json.toString());
            
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			 forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			 forward = "error";
		}finally{
			if(out!=null){
				out.flush();
				out.close();
			}
		}
		
		return forward;
	}
}
