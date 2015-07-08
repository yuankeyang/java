package com.netmed.action.expert;

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
import com.netmed.pojo.MemberAppointment;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 专家预约action
 * @author Administrator
 *
 */
public class ExpertAppointMentAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * 医生处理患者的预约
	 * @author larch
	 */
	
	/** 定义时间显示格式！！！！ **/
	SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy/M/d  HH:mm");

	public String execute() {
		String forward = "success";
		// 取得reqeust对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		try {
			
			/**设置字符集编码格式为utf-8**/
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			out = response.getWriter();
			
			/**从getMemberAppointmentFromJsp方法中获取页面预约对象**/
			MemberAppointment appointment = getMemberAppointmentFromJsp(request);
			
			/**Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			MembAppointmentDAO dao = (MembAppointmentDAO) otx
					.getBean("MembAppointmentDAO");
			
			dao.UpdateAppoint(appointment); /**修改预约**/
			out.println("yes");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			forward = "error"; // 出错返回当前页面
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";  // 出错返回当前页面
		} finally {
			if (out!= null) {
				out.flush();
				out.close();
			}
		}
		return forward;
	}

	/**
	 * 根据预约id完成预约追加，即医生改变预约状态
	 * @author larch
	 */
	public String ExpertAppointmentForAppend() {
		
		System.out.println("运行到了ExpertAppointmentForAppend！");
		String forward = "success";
		// 取得reqeust对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		try {
			/**设置字符集编码格式为utf-8**/
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			out = response.getWriter();
			
			/**从getMemberAppointmentFromJsp方法中获取页面预约对象**/
			MemberAppointment appointment = getMemberAppointmentFromJsp(request);
			/**Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			MembAppointmentDAO dao = (MembAppointmentDAO) otx
					.getBean("MembAppointmentDAO");
			
			dao.AddAppoint(appointment);/**新增预约**/
			out.println("yes");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			out.println("no");
			forward = "error";	// 出错返回当前页面
			
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
			out.println("no");
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
		return forward;
	}

	// 获取jsp页面数据，封装成对象！！！
	public MemberAppointment getMemberAppointmentFromJsp(
			HttpServletRequest request) {
		
		/**Spring调用DAO**/
		ApplicationContext otx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		MembAppointmentDAO dao = (MembAppointmentDAO) otx
				.getBean("MembAppointmentDAO");
		
		/**使用request对象从页面获取预约号**/
		String appointment_id = request.getParameter("appointment_id");
		int id = Integer.parseInt(appointment_id);
		MemberAppointment appointment = dao.FindInfoById(id);   /**通过预约号找到预约对象**/
		
		// 专家回复时间！！
		Timestamp replyTime = new Timestamp(System.currentTimeMillis());
		appointment.setReplyTime(replyTime);
		
		// 标定是否接受预约
		int isAccept = Integer.parseInt(request.getParameter("isAccept"));
		if (isAccept == 1) {
			appointment.setIfaccept(Boolean.TRUE);
		} else {
			appointment.setIfaccept(Boolean.FALSE);
		}
		// 设置预约已处理
		appointment.setState(true);
		return appointment;
	}

	/**
	 * 根据专家Id获取未读的预约信息 电子病历号，患者Id，预约时间,相关内容
	 * 
	 * @return 是否成功
	 */
	public String getBriefList() {
		
		String forward = "success";
		// 取得reqeust对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");

			// 获取专家Id
			String expename = new String(session.get("expename").toString()
					.getBytes("iso8859-1"), "utf-8");
			
			/**Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			MembAppointmentDAO dao = (MembAppointmentDAO) otx
					.getBean("MembAppointmentDAO");
			/**通过专家id获取预约列表**/
			List<MemberAppointment> appointments = dao
					.FindInfoByExpertIdWeiDu(expename);

			/**定义json对象和数组，用以返回数据到jsp页面**/
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			JSONObject member = null;
			for (int i = 0; i < appointments.size(); i++) {
				member = new JSONObject();
				// 预约号
				member.put("appointment_id", appointments.get(i).getId());
				// 患者id
				member.put("userId", appointments.get(i).getMembRegi()
						.getMembId());
				// 简单介绍
				member.put("brief", appointments.get(i).getTitle());
				// 预约时间
				String showTime = timeFormat.format(appointments.get(i)
						.getAppoTime());
				member.put("time", showTime);
				array.add(member);
			}
			json.put("acount", appointments.size());  /**预约数**/
			json.put("AppointmentArray", array);
			out = response.getWriter();
			out.println(json.toString());

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			forward = "error";// 出错返回当前页面
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";// 出错返回当前页面
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
		return forward;
	}

	/**
	 * 根据专家Id获取已处理的预约信息 
	 * @return 是否成功
	 */
	public String getBriefListForRead() {
		System.out.println("运行到了getBriefListForRead！");
		
		String forward = "success";
		// 取得reqeust对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");

			// 获取专家Id
			String expename = new String(session.get("expename").toString()
					.getBytes("iso8859-1"), "utf-8");
			
			/**Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			MembAppointmentDAO dao = (MembAppointmentDAO) otx
					.getBean("MembAppointmentDAO");
			
			/**查询所有未读预约**/
			List<MemberAppointment> appointments = dao
					.FindInfoByExpertIdYiDu(expename);

			/**定义json对象和数组，用以返回数据到jsp页面**/
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			JSONObject member = null;
			//接受预约的次数
			int acceptAccount =0;
			//拒绝预约的次数
			int rejectAccount =0;
			for (int i = 0; i < appointments.size(); i++) {
				member = new JSONObject();
				// 预约号
				member.put("appointment_id", appointments.get(i).getId());
				// 患者id
				member.put("userId", appointments.get(i).getMembRegi()
						.getMembId());
				// 简单介绍
				member.put("brief", appointments.get(i).getTitle());
				// 处理状态
				if (appointments.get(i).getIfaccept()) {
					member.put("state", "已接受");
					member.put("change", "拒绝");
					member.put("isAccept", "0");
					acceptAccount++;
				} else {
					member.put("state", "已拒绝");
					member.put("change", "接受");
					member.put("isAccept", "1");
					rejectAccount++;
				}
				//对方是否违约
				if(appointments.get(i).getDefaultMemb()){
					member.put("defaultMemb", "是");
					member.put("defaultMembChange", "否");
					member.put("isdefaultMemb", "0");
				}else{
					member.put("defaultMemb", "否");
					member.put("defaultMembChange", "是");
					member.put("isdefaultMemb", "1");
				}
				// 咨询时间
				String showTime = timeFormat.format(appointments.get(i)
						.getAppoTime());
				member.put("time", showTime);
				array.add(member);
			}
			json.put("acceptAccount", acceptAccount);
			json.put("rejectAccount", rejectAccount);
			json.put("acount", appointments.size());
			json.put("AppointmentArray", array);
			out = response.getWriter();
			out.println(json.toString());

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			forward = "error";   // 出错返回当前页面
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";  // 出错返回当前页面
		}
		out.flush();
		out.close();
		return forward;
	}

	
	/**
	 * 根据预约号获取详细的预约信息
	 * @author larch
	 */
	public String getExpertAppointmentForRead() {
		System.out.println("运行到了getExpertAppointmentForRead！");
		// 取得reqeust对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			/**从页面获取预约号**/
			String appointment_id = request.getParameter("appointment_id");
			int id = Integer.parseInt(appointment_id);
			
			/**Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			MembAppointmentDAO dao = (MembAppointmentDAO) otx
					.getBean("MembAppointmentDAO");
			
			/**通过预约号获取预约对象**/
			MemberAppointment appointment = dao.FindInfoById(id);
			// 获取预约详细信息，用户id，主题，内容，时间
			json.put("userId", appointment.getMembRegi().getMembId());
			json.put("title", appointment.getTitle());
			json.put("content", appointment.getContent());
			json.put("time", appointment.getAppoTime());
			out = response.getWriter();
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
		String forward = "success";
		return forward;
	}

	/**
	 * 根据预约ID获取详细的预约信息
	 * @author larch
	 */
	public String getExpertAppointment() {
		System.out.println("运行到了getExpertAppointment！");
		// 取得reqeust对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			// 电子病历号
			String appointment_id = request.getParameter("appointment_id");
			int id = Integer.parseInt(appointment_id);
			
			/**Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			MembAppointmentDAO dao = (MembAppointmentDAO) otx
					.getBean("MembAppointmentDAO");
			/**通过预约号获取预约对象**/
			MemberAppointment appointment = dao.FindInfoById(id);
			// 获取预约信息
			json.put("userId", appointment.getMembRegi().getMembId());
			json.put("title", appointment.getTitle());
			json.put("content", appointment.getContent());
			json.put("time", appointment.getAppoTime());

			out = response.getWriter();
			out.println(json.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		out.flush();
		out.close();

		String forward = "success";
		return forward;
	}
	
    /**
     * 修改预约信息
     * @return
     */
	public String updateDefaultMemb() {
				String forward = "success";
				// 取得reqeust对象
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpServletResponse response = ServletActionContext.getResponse();
				PrintWriter out = null;
				try {
					request.setCharacterEncoding("utf-8");
					response.setContentType("text/html;charset=utf-8");
					out = response.getWriter();
					/**Spring调用DAO**/
					ApplicationContext otx = new ClassPathXmlApplicationContext(
							"applicationContext.xml");
					MembAppointmentDAO dao = (MembAppointmentDAO) otx
							.getBean("MembAppointmentDAO");
					// 预约号
					String appointment_id = request.getParameter("appointment_id");
					int id = Integer.parseInt(appointment_id);
					
					/**通过预约号获取预约对象**/
					MemberAppointment appointment = dao.FindInfoById(id);
					// 标定对方是否违约
					int isdefaultMemb = Integer.parseInt(request.getParameter("isdefaultMemb"));
					/**值为1违约**/
					if (isdefaultMemb == 1) {
						appointment.setDefaultMemb(Boolean.TRUE);
					} else {
						appointment.setDefaultMemb(Boolean.FALSE);
					}
					
					/**数据库更新预约信息**/
					dao.UpdateAppoint(appointment);
					out.println("yes");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					forward = "error";	// 出错返回当前页面
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
