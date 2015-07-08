package com.netmed.action.member;

import java.io.IOException;
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
import org.hibernate.exception.DataException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.BloodPressureDAO;
import com.netmed.pojo.BlooPres;
import com.netmed.pojo.MembRegi;


/**
 *  @author Administrator
 *  05-21
 *  新增血压记录和显示
 */
public class BloodPressureAction {
	
	
	//定义时间显示格式！！！！
	SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy/M/d  HH:mm");
	//新增一条血压记录
	public String NewBloodPressureRecord(){
		System.out.println("运行到了BloodPressureAction-----NewBloodPressureRecord");
		String FORWARD = "error";
		try{
			// 取得reqeust对象
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("gb2312");//设置字符编码格式为gb2312
			
			//调用getParaFromJsp方法，获取血压测量记录对象，参数为request对象
			BlooPres bloodPressure = getParaFromJsp(request);
			
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			BloodPressureDAO dao = (BloodPressureDAO) otx.getBean("BloodPressureDAO");
			//调用NewBloodPressureRecord方法，参数是要新要增的血压测量记录对象，返回为非0的新增成功
			int save = dao.NewBloodPressureRecord(bloodPressure);
			if (save != 0) {
				System.out.println("会员新增一个血压记录-----成功");
				FORWARD = "success";
			} else {
				System.out.println("会员新增一血压记录-----失败");
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
	
	//从jsp页面获取血压册量记录参数,返回一个血压测量记录对象
	public BlooPres getParaFromJsp(HttpServletRequest request){
		BlooPres bloodPressure =new BlooPres();
		//获取session，方便得到用户id 
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		String username;
		try {
			// 通过session获取用户Id
			username = new String(session.get("username").toString()
					.getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			username = "bugToDeal";
			e.printStackTrace();
		}
		MembRegi member = new MembRegi();
		//设置该血压测量记录的用户id
		member.setMembId(username);
		bloodPressure.setMembRegi(member);
		//家属姓名
        String name = request.getParameter("consultName");
        bloodPressure.setName(name);
       
        //收缩压
        String shouSuoYa = request.getParameter("shouSuoYa");
        int NshouSuoYa = Integer.parseInt(shouSuoYa);
        bloodPressure.setSystPres(NshouSuoYa);
        
        //舒张压
        String shuZhangYa = request.getParameter("shuZhangYa");
        int NshuZhangYa = Integer.parseInt(shuZhangYa);
        bloodPressure.setDiasPres(NshuZhangYa);
        
        //血氧
        String bloodOxygen = request.getParameter("bloodOxygen");
        int  oxygen = Integer.parseInt(bloodOxygen);
        bloodPressure.setBlooOxyg(oxygen);
		
        //体温
        String temperature = request.getParameter("temperature");
        double  temperat = Double.parseDouble(temperature);
        bloodPressure.setTemperature(temperat);

        //返回一个血压测量记录对象
		return bloodPressure;
	}
	
    //进行删除一条血压测量记录操作
	public String DeleteBloodPressureRecord() throws IOException{
		String FORWARD = "error";
		try {
			// 取得reqeust对象
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("gb2312");//设置字符编码格式为gb2312
		    // 使用reqeust对象获取血压测量记录表单id
			String bloodPressureId = new String(request.getParameter("bloodPressureId"));
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			BloodPressureDAO dao = (BloodPressureDAO) otx.getBean("BloodPressureDAO");
			
			//调用FindInfoById方法，根据表单ID查询血压相应信息，返回结果为一个血压测量记录对象
			BlooPres bloodPrescription = dao.FindInfoById(Integer.parseInt(bloodPressureId));
			//调用deleteBloodPressureRecord，在数据库中删除特定的血压测量记录对象
			boolean delete = dao.deleteBloodPressureRecord(bloodPrescription);
			if (delete) {
				System.out.println("会员删除血压记录-----成功");
				FORWARD = "success";
				out.println("yes");
			} else {
				System.out.println("会员删除血压记录-----失败");
				out.println("no");
			}
			out.flush();
			out.close();

		} catch (DataException e) { 
			FORWARD = "error";
			System.out.println("hibernate数据异常处理！！！！！");
			e.printStackTrace();

		}
		return FORWARD;

	}
	
	//对已有血压测量记录进行更新操作
	public String UpdateBloodPressureMethod() throws Exception {

		System.out.println("运行到了BloodPressureAction------UpdateBloodPressureMethod");
		String FORWARD = "error";
		try {
			// 取得reqeust对象
			HttpServletRequest request = ServletActionContext.getRequest();
			//设置字符编码格式为gb2312
			request.setCharacterEncoding("gb2312");
			//使用reqeust对象获取血压测量记录表单id
			String bloodPressureId = new String(request.getParameter("bloodPressureId"));
			int id=Integer.parseInt(bloodPressureId);//id类型转换
			
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			BloodPressureDAO dao = (BloodPressureDAO) otx.getBean("BloodPressureDAO");
			//调用FindInfoById方法，根据表单ID查询血压相应信息，返回结果为一个血压测量记录对象
			BlooPres bloodPressure=dao.FindInfoById(id);
			
			/***
			 * 获取需要修改的表单的信息
			 **/
			String name=request.getParameter("consultName");
			String shouSuoYa = request.getParameter("shouSuoYa");
			String shuZhangYa = request.getParameter("shuZhangYa");
			String bloodOxygen = request.getParameter("bloodOxygen");
			String temperature = request.getParameter("temperature");
			
			System.out.println(name+" "+shouSuoYa+" "+shuZhangYa+" "+bloodOxygen+" "+temperature);
			//对需要修改的表单设置新的值，对其原值进行修改，更新
			bloodPressure.setName(name);
			int ss=Integer.parseInt(shouSuoYa);
			bloodPressure.setSystPres(ss);
			int sz=Integer.parseInt(shuZhangYa);
			bloodPressure.setDiasPres(sz);
			int  oxygen = Integer.parseInt(bloodOxygen);
			bloodPressure.setBlooOxyg(oxygen);
			double  temperat = Double.parseDouble(temperature);
			bloodPressure.setTemperature(temperat);
			
			//调用UpdateBloodPressureRecord方法，对数据库数据进行修改
			boolean update = dao.UpdateBloodPressureRecord(bloodPressure);
			if (update) {
				System.out.println("会员更新血压记录-----成功");
				FORWARD = "success";
				//out.println("yes");
			} else {
				System.out.println("会员更新血压记录-----失败");
				//out.println("no");
				FORWARD = "error";
			}

		} catch (DataException e) { // hibernate数据异常处理！！！！！
			FORWARD = "error";
			System.out.println("hibernate数据异常处理！！！！！");
			e.printStackTrace();

		}
		return FORWARD;

	}

	//对血压测量记录进行查看读取
	public String getBloodPressureForRead() {
		
		System.out.println("运行到了BloodPressureAction-----getBloodPressureForRead");
		//获取request对象
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
			BloodPressureDAO dao = (BloodPressureDAO) otx.getBean("BloodPressureDAO");
			// 使用request获取血压测量记录表单id
			String bloodPressureId = request.getParameter("bloodPressureId");
			System.out.println("bloodPressureId="+bloodPressureId);
			int id = Integer.parseInt(bloodPressureId);//进行类型转换
			System.out.println("id="+id);
			//调用FindInfoById方法，利用血压测量记录表单id获取表单信息，返回一个血压测量记录对象
			BlooPres bloodPressure = dao.FindInfoById(id);
			// id
			json.put("bloodPressureId", bloodPressure.getBlooPresId());
			
			// 名字,此处的名字是血压记录的名字，而不是会员的名字
			json.put("consultName", bloodPressure.getName().toString());
			
			Timestamp time=bloodPressure.getMeasTime();
			String showTime=timeFormat.format(time);
			json.put("measureTime",showTime);
			
			// 舒张压
			json.put("shuZhangYa", bloodPressure.getDiasPres().toString());
			// 收缩压
			json.put("shouSuoYa",bloodPressure.getSystPres().toString());
			//血氧
			json.put("bloodOxygen", bloodPressure.getBlooOxyg().toString());
			//体温
			json.put("temperature", bloodPressure.getTemperature().toString());
			
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
	
	public String getBriefListForRead() {
		System.out.println("运行到了BloodPressureAction-----getBriefListForRead");
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

			// 获取用户Id
			String username = new String(session.get("username").toString()
					.getBytes("iso8859-1"), "utf-8");
			System.out.println(username);
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			BloodPressureDAO dao = (BloodPressureDAO) otx.getBean("BloodPressureDAO");
			//调用FindInfoByMembId方法，根据用户ID查找血压表记录信息
			List<BlooPres> blooPresList = dao.FindInfoByMembId(username);

			// ---------------------------------------------------------------------------------------
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			JSONObject bloodPressure = null;
			for (int i = 0; i < blooPresList.size(); i++) {

				bloodPressure = new JSONObject();
				
				bloodPressure.put("bloodPressureId", blooPresList.get(i).getBlooPresId());
				// 名字,此处的名字是血压记录的名字，而不是会员的名字
				bloodPressure.put("consultName", blooPresList.get(i).getName().toString());
				System.out.println("患者姓名----"+blooPresList.get(i).getName().toString());
				
				// 记录时间timeFormat
				Timestamp time=blooPresList.get(i).getMeasTime();
				String showTime=timeFormat.format(time);
				bloodPressure.put("measureTime",showTime);
				
				// 舒张压
				bloodPressure.put("shuZhangYa", blooPresList.get(i).getDiasPres().toString());
				// 收缩压
				bloodPressure.put("shouSuoYa",blooPresList.get(i).getSystPres().toString());
				// 血氧
				bloodPressure.put("bloodOxygen", blooPresList.get(i).getBlooOxyg().toString());
				// 体温
				bloodPressure.put("temperature", blooPresList.get(i).getTemperature().toString());
				
				array.add(bloodPressure);
			}
			json.put("acount", blooPresList.size());
			json.put("bloodPressureArray", array);
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
}
