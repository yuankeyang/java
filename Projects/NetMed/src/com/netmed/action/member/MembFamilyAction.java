package com.netmed.action.member;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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

import com.netmed.dao.MembFamiDAO;
import com.netmed.pojo.MembRegi;
import com.netmed.pojo.MembFami;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author larch 我的家属action， 05-15
 */
public class MembFamilyAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * 增加新的家属信息
	 * 
	 * @return 是否处理成功
	 * @throws Exception
	 */
	/** 定义时间显示格式！！！！ **/
	SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy/M/d  HH:mm");

	public String AddMembFamily() throws Exception {

		String FORWARD = "error";
		try {
			// 取得request对象
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("gb2312");//设置字符编码格式为gb2312
			
			//调用getParaFromJsp方法，获取当前页面的对象，参数为request对象
			MembFami membFami = getParaFromJsp(request);
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			MembFamiDAO dao = (MembFamiDAO) otx.getBean("MembFamiDAO");
			//调用NewFamily方法，参数为要新增的家属对象，返回为非0的新增成功
			int save = dao.NewFamily(membFami);
			if (save != 0) {
				System.out.println("会员新增一个家属-----成功");
				FORWARD = "success";
			} else {
				System.out.println("会员新增一篇家属-----失败");
			}
		} catch (DataException e) { 
			FORWARD = "error";
			System.out.println("hibernate数据异常处理！！！！！");
			e.printStackTrace();
		}
		return FORWARD;

	}

	/** 从jsp页面获取文章参数 */
	public MembFami getParaFromJsp(HttpServletRequest request) {
		MembFami membFami = new MembFami();
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		String username;//会员id
		try {
			//通过session得到会员id
			username = new String(session.get("username").toString()
					.getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			username = "bugToDeal";
			e.printStackTrace();
		}
		MembRegi member = new MembRegi();
		//设置家属表中专家id字段
		member.setMembId(username);
		membFami.setMembRegi(member);
		//家属姓名
        String name = request.getParameter("FamilyName");
        membFami.setFamiName(name);
       
        //家属性别
        String sexStr = request.getParameter("sex");
        if("male".equals(sexStr)){
           membFami.setSex(Boolean.FALSE);
           System.out.println("男---0表示男");
        }else{
          membFami.setSex(Boolean.TRUE);
          System.out.println("女---1表示女");
        }
        //年龄
        String ageStr = request.getParameter("age");
        int age = Integer.parseInt(ageStr);
        membFami.setAge(age);
		//与本人关系
		String relation = request.getParameter("relation");
		membFami.setRelationship(relation);
		//手机号
		String mobile = request.getParameter("mobile");
		membFami.setMobiPhon(mobile);
		//固话
		String telephone = request.getParameter("telephone");
		membFami.setLinePhon(telephone);
		//地址
		String address = request.getParameter("address");
        membFami.setAddress(address);

		return membFami;
	}
	/**
	 * 更新家属信息
	 * 
	 * @return 是否处理成功
	 * @throws Exception
	 */
	public String UpdateMembFamily() throws Exception {

		String FORWARD = "error";
		try {
			// 取得request对象
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("gb2312");
			//调用getParaFromJsp方法，获取当前页面的对象，参数为request对象
			MembFami membFami = getParaFromJsp(request);
		    // 家属id
			String MembFamily_Id = new String(request.getParameter("MembFamily_Id"));
			membFami.setFamiId(Integer.parseInt(MembFamily_Id));
			
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			//Spring调用相应DAO
			MembFamiDAO dao = (MembFamiDAO) otx.getBean("MembFamiDAO");
			//调用updateFamily方法，对已有的家属表进行更新操作
			boolean update = dao.updateFamily(membFami);
			if (update) {
				System.out.println("会员更新家属信息-----成功");
				FORWARD = "success";
				//out.println("yes");
			} else {
				System.out.println("会员更新家属信息-----失败");
			}
		} catch (DataException e) { 
			FORWARD = "error";
			System.out.println("hibernate数据异常处理！！！！！");
			e.printStackTrace();
		}
		return FORWARD;
	}

	/**
	 * 删除家属信息
	 * 
	 * @return 是否处理成功
	 * @throws Exception
	 */
	public String DeleteMembFamily() throws Exception {

		String FORWARD = "error";
		try {
			//取得request对象和response对象
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("gb2312");//设置字符编码格式为gb2312
		    // 家属id
			String MembFamily_Id = new String(request.getParameter("MembFamily_Id"));
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			MembFamiDAO dao = (MembFamiDAO) otx.getBean("MembFamiDAO");
			//调用findDetailById方法，通过家属表id，查找想要删除的家属表单
			MembFami membFami = dao.findDetailById(Integer.parseInt(MembFamily_Id));
			//调用deleteFamily方法，删除特定的家属表单
			boolean update = dao.deleteFamily(membFami);
			if (update) {
				System.out.println("会员删除家属信息-----成功");
				FORWARD = "success";
				out.println("yes");
			} else {
				System.out.println("会员删除家属信息-----失败");
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
	/**
	 * 根据会员Id获取家属信息
	 * 
	 * @return 是否成功
	 */
	public String getBriefListForRead() {
		System.out.println("运行到了会员文章处理action！-----getBriefListForRead");
		String forward = "success";
		//获取request和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
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
			MembFamiDAO dao = (MembFamiDAO) otx.getBean("MembFamiDAO");
			//调用findDetailByMembId方法，通过家属表单id查找特定的家属信息
			List<MembFami> membFamiList = dao.findDetailByMembId(username);

			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			JSONObject memberFami = null;
			for (int i = 0; i < membFamiList.size(); i++) {

				memberFami = new JSONObject();
				// id
				memberFami.put("MembFamily_Id", membFamiList.get(i).getFamiId());
				// 名字
				memberFami.put("username", membFamiList.get(i).getFamiName().toString());
				// 性别
				if(membFamiList.get(i).getSex()){
				     memberFami.put("sex", "女");
				}else{
					 memberFami.put("sex", "男");
				}
				// 年龄
				memberFami.put("age", membFamiList.get(i).getAge().toString());
				// 与本人关系
				memberFami.put("relation", membFamiList.get(i).getRelationship().toString());
				// 手机号
				memberFami.put("mobile", membFamiList.get(i).getMobiPhon().toString());
				//固话
				memberFami.put("telephone", membFamiList.get(i).getLinePhon().toString());
				//地址
				memberFami.put("address", membFamiList.get(i).getAddress().toString());

				array.add(memberFami);
			}
			json.put("acount", membFamiList.size());
			json.put("MembFamilyArray", array);
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

	/**
	 * 根据家属表单Id 读取详细的家属信息
	 * @author larch
	 * 
	 */
	public String getMembFamilyForRead() {
		System.out.println("运行到了-----getMembFamilyForRead");
		// 取得request对象和response对象
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
			MembFamiDAO dao = (MembFamiDAO) otx.getBean("MembFamiDAO");
			// 从jsp页面获取家属表单id，再将其转为整型
			String MembFamily_Id = request.getParameter("MembFamily_Id");
			int id = Integer.parseInt(MembFamily_Id);
			//通过家属表单id找到家属对象
			MembFami membFami = dao.findDetailById(id);
			// ---------------------------------------------------------------------------------------
			// id
			json.put("MembFamily_Id", membFami.getFamiId());
			// 名字
			String FamilyName=membFami.getFamiName().toString();
			json.put("FamilyName", FamilyName);
			// 性别
			if(membFami.getSex()){
				json.put("sex", "1");
			}else{
				json.put("sex", "0");
			}
			// 年龄
			json.put("age", membFami.getAge().toString());
			// 与本人关系
			json.put("relation", membFami.getRelationship().toString());
			// 手机号
			json.put("mobile",membFami.getMobiPhon().toString());
			//固话
			json.put("telephone", membFami.getLinePhon().toString());
			//地址
			json.put("address", membFami.getAddress().toString());
			
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
}
