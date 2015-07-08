package com.netmed.action.member;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.MembAppointmentDAO;
import com.netmed.pojo.ExpeRegi;
import com.netmed.pojo.MembRegi;
import com.netmed.pojo.MemberAppointment;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author larch 预约表单
 */
public class MemberAppointmentAction extends ActionSupport {

	/** 定义时间显示格式！！！！ **/
	SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy/M/d  HH:mm");
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("运行到了MemberAppointmentAction");
		String forward = "success";
		// 取得request对象和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		//获取session对象
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		System.out.println("我进来了");
		try {
			request.setCharacterEncoding("gb2312");
			response.setContentType("text/html;charset=utf-8");

			// 通过session获取会员Id
			String username = new String(session.get("username").toString()
					.getBytes("iso8859-1"), "utf-8");
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			MembAppointmentDAO dao = (MembAppointmentDAO) otx
					.getBean("MembAppointmentDAO");
			//2015-05-28 22:26
			
			//String now = new SimpleDateFormat("yyyy年MM月dd日").format(date);
			MemberAppointment appointment = new MemberAppointment();
			//标题
			String title = request.getParameter("title");
			
			String appoTime = request.getParameter("appoTime");
			System.out.println(appoTime);
		
            String expe_id = request.getParameter("expe_id");
			ExpeRegi expeRegi = new ExpeRegi(expe_id);
			MembRegi membRegi = new MembRegi(username);
			appointment.setTitle(title);
			appointment.setMembRegi(membRegi);
			appointment.setExpeRegi(expeRegi);
			appointment.setAppoTime(Timestamp.valueOf(appoTime+":00"));
			
			//调用AddAppoint方法，插入预约信息
			dao.AddAppoint(appointment);
			out = response.getWriter();
			out.println("yes");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 出错返回当前页面
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
		}
		out.flush();
		out.close();
		return forward;
	}
	/**
	 * 根据专家Id获取未读的离线表单信息 电子病历号，患者Id，咨询时间
	 * 
	 * @return 是否成功
	 */
	public String getBriefListForRead() {
		System.out.println("运行到了服务器！");
		String forward = "success";
		// 取得request对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		//获取session，以便获得专家id
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		System.out.println("我进来了");
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");

			//通过session获得专家Id
			String username = new String(session.get("username").toString()
					.getBytes("iso8859-1"), "utf-8");
			System.out.println(username);
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			MembAppointmentDAO dao = (MembAppointmentDAO) otx
					.getBean("MembAppointmentDAO");
			
			//调用FindInfoByMemberIdYiDu方法，通过文章id查找特定的已读预约
			List<MemberAppointment> appointments = dao
					.FindInfoByMemberIdYiDu(username);
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			JSONObject member = null;
			for (int i = 0; i < appointments.size(); i++) {

				member = new JSONObject();
				// 电子病历号
				member.put("appointment_id", appointments.get(i).getId());
				// 专家id
				member.put("expeId", appointments.get(i).getExpeRegi().getExpeName());
				// 简单介绍
				member.put("brief", appointments.get(i).getTitle());

				// 处理状态
				if (appointments.get(i).getIfaccept()) {
					member.put("state", "已接受");
				} else {
					member.put("state", "已拒绝");
				}
				// 预约时间
				String showTime = timeFormat.format(appointments.get(i)
						.getAppoTime());
				member.put("time", showTime);
				array.add(member);
			}
			json.put("acountYD", appointments.size());
			json.put("AppointmentArrayYD", array);

			//调用FindInfoByMemberIdWeiDu方法，通过文章id查找特定的未读预约
			List<MemberAppointment> appointmentsWD = dao
					.FindInfoByMemberIdWeiDu(username);
			JSONArray arrayWD = new JSONArray();
			JSONObject memberWD = null;
			for (int i = 0; i < appointmentsWD.size(); i++) {

				memberWD = new JSONObject();
				// 电子病历号
				memberWD.put("appointment_id", appointmentsWD.get(i).getId());
				// 专家id
				memberWD.put("expeId", appointmentsWD.get(i).getExpeRegi().getExpeName());
				// 简单介绍
				memberWD.put("brief", appointmentsWD.get(i).getTitle());
				// 预约时间
				String showTime = timeFormat.format(appointmentsWD.get(i)
						.getAppoTime());
				memberWD.put("time", showTime);
				arrayWD.add(memberWD);
			}
			json.put("acountWD", appointmentsWD.size());
			json.put("AppointmentArrayWD", arrayWD);
			
			out = response.getWriter();
			out.println(json.toString());

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 出错返回当前页面
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
		}
		out.flush();
		out.close();
		return forward;
	}
}
