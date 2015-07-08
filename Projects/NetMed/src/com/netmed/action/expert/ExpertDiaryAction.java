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
import org.hibernate.exception.DataException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.ExpertDiaryDAO;
import com.netmed.pojo.ExpeRegi;
import com.netmed.pojo.ExpertDiary;
/**
 * 专家日记action，进行日记的增删查改
 * @author Administrator
 *
 */
public class ExpertDiaryAction {
	/**定义时间显示格式！！！！**/
	SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy/M/d  HH:mm");
	
	/**
	 * 专家增加新的日记
	 * @return 是否处理成功
	 */
	public String AddDiary() throws Exception {

		System.out.println("运行到了专家日记action-----AddDiary");
		String FORWARD = "error";
		try {
			// 取得reqeust对象
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("gb2312");
			// ---------------------------------------------------------------------------------------
			/**调用方法，从jsp页面获取表单参数**/
			ExpertDiary diary = getParaFromJsp(request);
			
			/**Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			ExpertDiaryDAO dao = (ExpertDiaryDAO) otx
					.getBean("ExpertDiaryDAO");
			
			/**新建一篇日记**/
			int save = dao.NewDiary(diary);
			if (save != 0) {
				System.out.println("专家新增一篇日记-----成功");
				FORWARD = "success";
			} else {
				System.out.println("专家新增一篇日记-----失败");
			}

		} catch (DataException e) { 
			FORWARD = "error";
			System.out.println("hibernate数据异常处理！！！！！");
			e.printStackTrace();

		}
		return FORWARD;

	}

	/**从jsp页面获取日记参数 ，有日记标题，内容，以及记录时间**/
	public ExpertDiary getParaFromJsp(HttpServletRequest request) {
		ExpertDiary diary = new ExpertDiary();
		/**获取session**/
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		
		/**获取专家Id**/
		String expename=null;
		try {
			expename = new String(session.get("expename").toString()
					.getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		/**设置专家日记表中的专家字段**/
		ExpeRegi expert = new ExpeRegi();
		expert.setExpeId(expename);
		diary.setExpeRegi(expert);

		/**设置专家日记表中的标题字段**/
		String title = request.getParameter("title").toString();
		diary.setTitle(title);

		/**设置专家日记表中的内容字段**/
		String content = request.getParameter("content").toString();
		diary.setContent(content);

		/**设置专家日记表中的时间字段**/
		Timestamp time = new Timestamp(System.currentTimeMillis());
		diary.setDate(time);

		/**返回日记对象**/
		return diary;
	}
	
	/**
	 * 更新专家日记
	 * @return 是否处理成功
	 * @throws Exception
	 */
	public String UpdateDiary() throws Exception {

		System.out.println("运行到了专家日记处理action！-----UpdateDiary");
		String FORWARD = "error";
		try {
			// 取得reqeust对象
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf-8");
			HttpServletResponse response = ServletActionContext.getResponse();

			/**Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			ExpertDiaryDAO dao = (ExpertDiaryDAO) otx
					.getBean("ExpertDiaryDAO");
			PrintWriter out = response.getWriter();
			
			/**获取相关日记Id**/
			String diaryId = new String(request.getParameter("Diary_Id"));
			ExpertDiary diary = dao.SelectDiary(Integer
					.parseInt(diaryId));

			/**修改日记标题**/
			diary.setTitle(request.getParameter("title").toString());
			/**修改日记内容**/
			diary.setContent(request.getParameter("content").toString());
			/**修改日记时间**/
			Timestamp time = new Timestamp(System.currentTimeMillis());
			diary.setDate(time);

			/**调用DAO，保存日记修改**/
			if (dao.UpdateDiary(diary)) {
				/**System.out.println("专家修改日记成功"); **/
				/**修改成功，返回success**/
				FORWARD = "success";
				out.println("yes");
			} else {
				/**System.out.println("专家修改日记失败"); **/
				/**修改失败，返回error**/
				FORWARD = "error";
				out.println("no");
			}
			out.flush();
			out.close();
		} catch (DataException e) {
			FORWARD = "error";
			e.printStackTrace();
		}
		return FORWARD;

	}

	/**
	 * 删除专家日记
	 * @return 是否处理成功
	 * @throws Exception
	 */
	public String DeleteDiary() throws Exception {

		System.out.println("运行到了专家日记处理action！-----DeleteDiary");
		String FORWARD = "error";
		try {
			// 取得reqeust对象
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf-8");
			HttpServletResponse response = ServletActionContext.getResponse();
			
			/**Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			ExpertDiaryDAO dao = (ExpertDiaryDAO) otx
					.getBean("ExpertDiaryDAO");

			PrintWriter out = response.getWriter();
			
			/**获取要删除日记的Id**/
			String diaryId = new String(request.getParameter("Diary_Id"));
			/**先通过日记id找到日记，再删除**/
			ExpertDiary diary = dao.SelectDiary(Integer
					.parseInt(diaryId));
			
			/**判断是否删除日记成功，返回值是boolean型，为真删除成功，否则删除失败**/
			if (dao.DeleteDiary(diary)) {
				System.out.println("删除专家日记-----成功");
				FORWARD = "success";
				out.println("yes");
			} else {
				System.out.println("删除专家日记----失败");
				FORWARD = "error";
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
	
	/**
	 * 根据专家Id获取专家日记列表
	 * 
	 * @return 是否成功
	 */
	public String getBriefListForRead() {
		System.out.println("运行到了专家日记处理action！-----getBriefListForRead");
		String forward = "success";
		
		/**获取request和response对象**/
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		
		/**获取session对象，通过session获得专家id**/
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");

			/**获取专家id**/
			String expename = new String(session.get("expename").toString()
					.getBytes("iso8859-1"), "utf-8");
			/**使用Spring获取日记表的操作DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			ExpertDiaryDAO dao = (ExpertDiaryDAO) otx
					.getBean("ExpertDiaryDAO");
			/**通过专家id找到专家的日记列表**/
			List<ExpertDiary> diaryList = dao.FindDiaryByExpeId(expename);

			/**定义json对象和json数组，用以返回数据到jsp页面**/
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			JSONObject diary = null;
			for (int i = 0; i < diaryList.size(); i++) {

				diary = new JSONObject();
				/**获得日记id，放入json数据的Diary_Id字段**/
				diary.put("Diary_Id", diaryList.get(i).getId());
				/**获得日记题目，放入json数据的title字段**/
				diary.put("title", diaryList.get(i).getTitle().toString());
				/**获得日记时间，放入json数据的time字段，显示格式在类最前面定义**/
				String showTime=timeFormat.format(diaryList.get(i).getDate());
				diary.put("time", showTime);
				/**将一篇日记内容存入数组**/
				array.add(diary);
			}
			
			json.put("acount", diaryList.size());/**日记的数量**/
			json.put("DiaryArray", array);       /**将日记数组放入json对象**/
			out = response.getWriter();
			out.println(json.toString());        /**将json数组输出到jsp页面**/
			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
		}
		return forward;
	}

	/**
	 * 根据日记Id 读取详细的日记信息
	 * @author larch
	 */
	public String getDiaryForRead() {
		System.out.println("运行到了专家日记处理action！-----getDiaryForRead");
		// 取得reqeust对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String forward = "success";
		PrintWriter out = null;
		JSONObject json = new JSONObject();   /**定义json对象**/
		try {
			
			/**设置编码格式为utf-8**/
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			/**通过Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			ExpertDiaryDAO dao = (ExpertDiaryDAO) otx
					.getBean("ExpertDiaryDAO");
		
			String diaryId = request.getParameter("Diary_Id");	/**从页面获取日记id**/
			int id = Integer.parseInt(diaryId);                 /**将String类型转化为整型**/
			ExpertDiary diaryDetail = dao.SelectDiary(id);      /**通过SelectDiary方法查询日记对象**/
			json.put("title", diaryDetail.getTitle().toString());  /**获取日记标题放入json的title字段**/
			String showTime=timeFormat.format(diaryDetail.getDate());
			json.put("time", showTime);
			// 日记内容
			json.put("content", diaryDetail.getContent().toString());/**将日记内容放入json的content字段**/
			
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
