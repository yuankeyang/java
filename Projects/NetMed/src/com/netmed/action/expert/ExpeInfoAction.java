package com.netmed.action.expert;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.ExpeRegiDAO;
import com.netmed.dao.MembAppointmentDAO;
import com.netmed.dao.MembConsInfoDAO;
import com.netmed.pojo.ExpeRegi;
import com.netmed.pojo.MembConsInfo;
import com.netmed.pojo.MemberAppointment;
import com.opensymphony.xwork2.ActionSupport;

public class ExpeInfoAction extends ActionSupport{

	private static final long serialVersionUID = 4785208146902186608L;
/**
 * 获取消息返回到专家个人中心	
 * @return
 */
	public String getExpeCenData(){

		System.out.println("运行到了getExpeCenData---获取专家个人信息");
		String forward = "success";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		Map<String, Object> session = ServletActionContext.getContext().getSession();
		try {
			request.setCharacterEncoding("utf-8");			
			response.setContentType("text/html;charset=utf-8");			
			//获取专家Id
			//-----------------------------------------------------------------------------------
			String expename = new String(session.get("expename").toString().getBytes("iso8859-1"), "utf-8");
			out = response.getWriter();
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			ExpeRegiDAO dao = (ExpeRegiDAO)otx.getBean("ExpeRegiDAO");
			ExpeRegi expe = dao.getExpeinfoById(expename);
            JSONObject json = new JSONObject();
            
            /**获取专家中心首页需要的等级，积分，余额，照片信息**/
            json.put("rank", expe.getRank());
            json.put("credit", expe.getCredit());
            json.put("money", expe.getMoney());
            json.put("photo", expe.getPhoto());
            //----------------------------------------------------------------------------------
			MembConsInfoDAO membConsInfoDAO = (MembConsInfoDAO)otx.getBean("MembConsInfoDAO");
			List<MembConsInfo> membConsList=membConsInfoDAO.FindInfoByExpertIdWeiDu(expename);
			//未处理的离线订单 
			json.put("membConsAccount", membConsList.size());
			//
			MembAppointmentDAO appointmentDAO = (MembAppointmentDAO) otx.getBean("MembAppointmentDAO");
			List<MemberAppointment> appointmentList= appointmentDAO.FindInfoByExpertIdWeiDu(expename);
			//未处理的预约
			json.put("appointmentAccount", appointmentList.size());
            out.println(json.toString());
            
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			 forward = "error";  //出错返回当前页面
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
	
	/**
	 * 获取专家个人信息
	 * @return
	 */
	public String getExpePersonInfo(){
		String forward = "success";
		// 取得reqeust对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		
		/**获取session**/
		Map<String, Object> session = ServletActionContext.getContext().getSession();
		try {
			request.setCharacterEncoding("utf-8");			
			response.setContentType("text/html;charset=utf-8");			
			//获取专家Id
			String expename = new String(session.get("expename").toString().getBytes("iso8859-1"), "utf-8");
			out = response.getWriter();
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			ExpeRegiDAO dao = (ExpeRegiDAO)otx.getBean("ExpeRegiDAO");
			ExpeRegi expe = dao.getExpeinfoById(expename);  /**通过专家id找到专家信息**/
            JSONObject json = new JSONObject();
            
            /**获取专家个人信息:专家姓名，专辑电话，专家邮箱**/
            json.put("username", expe.getExpeName());
            json.put("phone", expe.getExpeMobiPhon());
            json.put("mail", expe.getExpeEmai());
            out.println(json.toString());
            
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			 forward = "error";  //出错返回当前页面
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
	
	/**
	 * 更新专家个人信息
	 * @return
	 */
	public String updateExpePersonInfo(){
		String forward = "success";
		// 取得reqeust对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		Map<String, Object> session = ServletActionContext.getContext().getSession();
		try {
			request.setCharacterEncoding("utf-8");			
			response.setContentType("text/html;charset=utf-8");			
			//获取专家Id
			String expename = new String(session.get("expename").toString().getBytes("iso8859-1"), "utf-8");
			out = response.getWriter();
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			ExpeRegiDAO dao = (ExpeRegiDAO)otx.getBean("ExpeRegiDAO");
			ExpeRegi expe = dao.getExpeinfoById(expename);
			
			/**request对象从jsp页面获取要求改的姓名、电话、邮箱字段**/
			String name = new String(request.getParameter("expe_name").getBytes("iso8859-1"), "utf-8");
			String expe_mobile = new String(request.getParameter("expe_mobile").getBytes("iso8859-1"), "utf-8");
			String expe_mail = new String(request.getParameter("expe_mail").getBytes("iso8859-1"), "utf-8");
			
			/**修改姓名，电话，邮箱，并存入数据库**/
			expe.setExpeName(name);
			expe.setExpeMobiPhon(expe_mobile);
			expe.setExpeEmai(expe_mail);
			dao.UpdateExpeRegi(expe);
			
			out.println("yes");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			forward = "error";	//出错返回当前页面
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
	
	
	public String ensurePass(){
		String forward = "success";
		// 取得reqeust对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		Map<String, Object> session = ServletActionContext.getContext().getSession();
		try {
			request.setCharacterEncoding("utf-8");			
			response.setContentType("text/html;charset=utf-8");			
			//获取专家Id
			String expename = new String(session.get("expename").toString().getBytes("iso8859-1"), "utf-8");
			out = response.getWriter();
			
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			ExpeRegiDAO dao = (ExpeRegiDAO)otx.getBean("ExpeRegiDAO");
			ExpeRegi expe = dao.getExpeinfoById(expename);
			
            /**确认密码**/
            String passConInput = request.getParameter("passConInput");
            if(expe.getExpePass().equals(passConInput)){
            	out.println("yes");
            }else{
            	out.println("no");
            }
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			forward = "error";     //出错返回当前页面
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
	
	/**
	 * 更新密码
	 * @return
	 */
	public String updatePass(){

		String forward = "success";
		// 取得reqeust对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		
		Map<String, Object> session = ServletActionContext.getContext().getSession();
		try {
			request.setCharacterEncoding("utf-8");			
			response.setContentType("text/html;charset=utf-8");			
			//获取专家Id
			String expename = new String(session.get("expename").toString().getBytes("iso8859-1"), "utf-8");
			out = response.getWriter();
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			ExpeRegiDAO dao = (ExpeRegiDAO)otx.getBean("ExpeRegiDAO");
			ExpeRegi expe = dao.getExpeinfoById(expename);
			
			String newpassConInput = request.getParameter("newpassConInput");
			
            /**设置修改密码并存入数据库**/
			expe.setExpePass(newpassConInput);
			dao.UpdateExpeRegi(expe);
			out.println("yes");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			forward = "error";	//出错返回当前页面
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
