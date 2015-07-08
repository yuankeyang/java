package com.netmed.action.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.hibernate.exception.DataException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.SleepRecordDAO;
import com.netmed.pojo.MembRegi;
import com.netmed.pojo.SleepRecords;

public class SleepRecordAction {
	/** 定义时间显示格式！！！！ **/
	SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMddHHmm");
	
	//新增一条睡眠记录
	public String NewSleepRecord(){
		System.out.println("运行到了SleepRecordAction-----NewSleepRecord");
		String FORWARD = "error";
		try{
			//获取request对象
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("gb2312");
			//调用getParaFromJsp方法，从页面获取睡眠数据
			SleepRecords sleepRecord = getParaFromJsp(request);
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			SleepRecordDAO dao = (SleepRecordDAO) otx.getBean("SleepRecordDAO");
			//调用NewSleepRecord方法，新建一个睡眠记录
			int save = dao.NewSleepRecord(sleepRecord);
			if (save != 0) {
				System.out.println("会员新增一个睡眠记录-----成功");
				FORWARD = "success";
			} else {
				System.out.println("会员新增一个睡眠记录-----失败");
			}
			
		} catch (DataException e) { // hibernate数据异常处理！！！！！
			FORWARD = "error";
			System.out.println("hibernate数据异常处理！！！！！");
			e.printStackTrace();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return FORWARD;
	}
	
	/**
	 * 从页面获取睡眠数据
	 * @param request
	 * @return
	 */
	public SleepRecords getParaFromJsp(HttpServletRequest request){
		SleepRecords sleepRecord =new SleepRecords();//新建一个睡眠记录对象
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		        //定义用户Id
				String username;
				try {
					username = new String(session.get("username").toString()
							.getBytes("iso8859-1"), "utf-8");
				} catch (UnsupportedEncodingException e) {
					username = "bugToDeal";
					e.printStackTrace();
				}
				MembRegi member = new MembRegi();//新建一个用户对象
				//设置会员id
				member.setMembId(username);
				sleepRecord.setMembRegi(member);
        //初入睡时间
        String fallSleep = request.getParameter("fallSleep");
        sleepRecord.setFirstSleepTime(fallSleep);
        
        //睡眠时间长度
        String sleepDuration = request.getParameter("sleepDuration");
        sleepRecord.setSleepDuration(sleepDuration);
        
        //熟睡总时间
        String deepDuration = request.getParameter("deepDuration");
        sleepRecord.setDeepDuration(deepDuration);
		
        //浅睡总时间
        String simpleDuration = request.getParameter("simpleDuration");
        sleepRecord.setSimpleDuration(simpleDuration);
        
        //醒/做梦总时间
        String dreamDuration = request.getParameter("dreamDuration");
        sleepRecord.setDreamDuration(dreamDuration);
        
        //呼吸中止指数
        String breathIndex = request.getParameter("breathIndex");
        float breathInd = Float.parseFloat(breathIndex);
        sleepRecord.setBreathIndex(breathInd);

		return sleepRecord;
	}
	
	//获取睡眠记录的详细信息
	public String getBriefListForRead() {
		System.out.println("运行到了SleepRecordAction-----getBriefListForRead");
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
			System.out.println(username);
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			SleepRecordDAO dao = (SleepRecordDAO) otx.getBean("SleepRecordDAO");
			//调用FindInfoByMembId方法，通过用户id查找睡眠记录信息
			List<SleepRecords> sleepRecordList = dao.FindInfoByMembId(username);

			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			JSONObject sleepRecord = null;
			for (int i = 0; i < sleepRecordList.size(); i++) {

				sleepRecord = new JSONObject();
				
				sleepRecord.put("sleepRecordId", sleepRecordList.get(i).getSleepRecordId());
				
				// 记录时间timeFormat
				Timestamp time=sleepRecordList.get(i).getTime();
				String showTime=timeFormat.format(time);
				sleepRecord.put("measureTime",showTime);
				
				// 初入睡时间
				sleepRecord.put("fallSleep", sleepRecordList.get(i).getFirstSleepTime().toString());
				// 睡眠时间长度
				sleepRecord.put("sleepDuration",sleepRecordList.get(i).getSleepDuration().toString());
				// 熟睡总时间
				sleepRecord.put("deepDuration", sleepRecordList.get(i).getDeepDuration().toString());
				// 浅睡总时间
				sleepRecord.put("simpleDuration", sleepRecordList.get(i).getSimpleDuration().toString());
				//醒/做梦总时间
				sleepRecord.put("dreamDuration", sleepRecordList.get(i).getDreamDuration().toString());
				
				
				//呼吸中止指数,格式为带1位小数
				float breathIndex=sleepRecordList.get(i).getBreathIndex();
				DecimalFormat decimalFormat=new DecimalFormat(".0");
				String breath=decimalFormat.format(breathIndex);
				sleepRecord.put("breathIndex",breath);
				
				array.add(sleepRecord);
			}
			json.put("acount", sleepRecordList.size());
			json.put("sleepRecordArray", array);
			out = response.getWriter();
			
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 出错返回当前页面
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
		}
		return forward;
	}
	
	//进行睡眠记录删除操作
	public String DeleteSleepRecord() throws IOException{
		String FORWARD = "error";
		try {
			//获取request和response对象
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("gb2312");
		    //睡眠记录id
			String sleepRecordId = new String(request.getParameter("sleepRecordId"));
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			SleepRecordDAO dao = (SleepRecordDAO) otx.getBean("SleepRecordDAO");
			//调用FindInfoById方法，通过睡眠记录id获取相应的睡眠记录信息
			SleepRecords sleepPrescription = dao.FindInfoById(Integer.parseInt(sleepRecordId));
			//在数据库进行删除操作
			boolean delete = dao.deleteSleepRecord(sleepPrescription);
			if (delete) {
				System.out.println("会员删除睡眠记录-----成功");
				FORWARD = "success";
				out.println("yes");
			} else {
				System.out.println("会员删除睡眠记录-----失败");
				out.println("no");
			}
			out.flush();
			out.close();
		} catch (DataException e) { // hibernate数据异常处理！！！！！
			FORWARD = "error";
			System.out.println("hibernate数据异常处理！！！！！");
			e.printStackTrace();
		}
		return FORWARD;
	}
	
	//获取睡眠记录信息
	public String getSleepRecordForRead() {
		
		System.out.println("运行到了SleepRecordAction-----getSleepRecordForRead");
		//获取request和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String forward = "success";
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");

			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			SleepRecordDAO dao = (SleepRecordDAO) otx.getBean("SleepRecordDAO");
			//睡眠记录表单id
			String sleepRecordId = request.getParameter("sleepRecordId");
			System.out.println("sleepRecordId="+sleepRecordId);
			int id = Integer.parseInt(sleepRecordId);//类型转换
			System.out.println("id="+id);
			//调用FindInfoById方法，通过睡眠记录id查找相应的睡眠记录
			SleepRecords sleepRecord = dao.FindInfoById(id);
			// id
			json.put("sleepRecordId", sleepRecord.getSleepRecordId());
			
			Timestamp time=sleepRecord.getTime();
			String showTime=timeFormat.format(time);
			json.put("measureTime",showTime);
			
			// 初入睡时间
			json.put("fallSleep", sleepRecord.getFirstSleepTime().toString());
			// 睡眠时间长度
			json.put("sleepDuration",sleepRecord.getSleepDuration().toString());
			// 熟睡总时间
			json.put("deepDuration", sleepRecord.getDeepDuration().toString());
			// 浅睡总时间
			json.put("simpleDuration", sleepRecord.getSimpleDuration().toString());
			//醒/做梦总时间
			json.put("dreamDuration",sleepRecord.getDreamDuration().toString());
			
			
			//呼吸中止指数
			float breathIndex=sleepRecord.getBreathIndex();
			DecimalFormat decimalFormat=new DecimalFormat(".0");
			String breath=decimalFormat.format(breathIndex);
			json.put("breathIndex", breath);
			
			out = response.getWriter();
			out.println(json.toString());

			forward = "success";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
		}

		out.flush();
		out.close();
		return forward;
	}

//更新睡眠记录
public String UpdateSleepRecordMethod() throws Exception {

	System.out.println("运行到了SleepRecordAction------UpdateSleepRecordMethod");
	String FORWARD = "error";
	try {
		//获取request和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("gb2312");
		//获取睡眠记录id
		String sleepRecordId = new String(request.getParameter("sleepRecordId"));
		int id=Integer.parseInt(sleepRecordId);
		
		ApplicationContext otx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		//Spring调用相应DAO
		SleepRecordDAO dao = (SleepRecordDAO) otx.getBean("SleepRecordDAO");
		SleepRecords sleepRecord=dao.FindInfoById(id);
		
		/***
		 * 获取表单修改的信息
		 **/
		String fallSleep=request.getParameter("fallSleep");
		String sleepDuration = request.getParameter("sleepDuration");
		String deepDuration = request.getParameter("deepDuration");
		String simpleDuration = request.getParameter("simpleDuration");
		String dreamDuration = request.getParameter("dreamDuration");
		String breathIndex = request.getParameter("breathIndex");
		
		System.out.println(fallSleep+" "+sleepDuration+" "+deepDuration+" "+simpleDuration+" "+dreamDuration+" "+breathIndex);
		//进行表单信息修改
		sleepRecord.setFirstSleepTime(fallSleep);
		sleepRecord.setSleepDuration(sleepDuration);
		sleepRecord.setDeepDuration(deepDuration);
		sleepRecord.setSimpleDuration(simpleDuration);
		sleepRecord.setDreamDuration(dreamDuration);
		float breathInd = Float.parseFloat(breathIndex);
		sleepRecord.setBreathIndex(breathInd);
		
		boolean update = dao.UpdateSleepRecord(sleepRecord);
		if (update) {
			System.out.println("会员更新睡眠记录-----成功");
			FORWARD = "success";
			//out.println("yes");
		} else {
			System.out.println("会员更新睡眠记录-----失败");
			//out.println("no");
			FORWARD = "error";
		}
		//out.flush();
		//out.close();

	} catch (DataException e) { // hibernate数据异常处理！！！！！
		FORWARD = "error";
		System.out.println("hibernate数据异常处理！！！！！");
		e.printStackTrace();
	}
	return FORWARD;
}
}
