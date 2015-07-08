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

import com.netmed.dao.ExpertArticleDAO;
import com.netmed.pojo.ExpeRegi;
import com.netmed.pojo.ExpertArticle;

/**
 * 专家文章action，对专家文章进行增删改查
 * @author Administrator
 *
 */

public class ExpertArticleAction {
	/**定义时间显示格式！！！！**/
	SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy/M/d  HH:mm");
	/**
	 * 专家增加新的文章
	 * @return 是否处理成功
	 * @throws Exception
	 */
	public String AddArticle() throws Exception {

		System.out.println("运行到了专家文章action-----AddArticle");
		String FORWARD = "error";
		try {
			// 取得reqeust对象
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("gb2312");    /**设置字符编码格式为gb2312**/
			
			/**调用getParaFromJsp方法，获取文章对象，参数为request对象**/
			ExpertArticle article = getParaFromJsp(request);
			
			 /**Spring调用相应DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			ExpertArticleDAO dao = (ExpertArticleDAO) otx
					.getBean("ExpertArticleDAO");
			
			/**调用NewArticle方法，参数要新增的文章对象，返回为非0的新增成功**/
			int save = dao.NewArticle(article);
			if (save != 0) {
				//System.out.println("专家新增一篇文章-----成功");
				FORWARD = "success";
			} else {
				//System.out.println("专家新增一篇文章-----失败");
			}

		} catch (DataException e) { 
			FORWARD = "error";
			//System.out.println("hibernate数据异常处理！！！！！");
			e.printStackTrace();

		}
		return FORWARD;

	}

	/**从jsp页面获取文章参数,包括文章标题，内容 ，返回一个文章对象*/
	public ExpertArticle getParaFromJsp(HttpServletRequest request) {
		ExpertArticle article = new ExpertArticle();   /**新建一个文章对象 */
		/**获取session，方便得到专家id */
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		
		String expename=null;
		try {
			/**通过session得到专家id**/
			expename = new String(session.get("expename").toString()
					.getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		/**设置文章表中专家id字段**/
		ExpeRegi expert = new ExpeRegi();
		expert.setExpeId(expename);
		article.setExpeRegi(expert);

		// 文章标题
		String title = request.getParameter("title").toString();
		article.setTitle(title);

		// 文章内容
		String content = request.getParameter("content").toString();
		article.setContent(content);

		// 创建时间
		Timestamp time = new Timestamp(System.currentTimeMillis());
		article.setTime(time);

		return article;  /**返回文章对象**/
	}

	/**
	 * 更新专家文章
	 * @return 是否处理成功
	 * @throws Exception
	 */
	public String UpdateArticle() throws Exception {

		System.out.println("运行到了专家文章处理action！-----update");
		String FORWARD = "error";
		try {
			// 取得reqeust对象
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf-8");
			HttpServletResponse response = ServletActionContext.getResponse();
			 /**Spring调用相应DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			ExpertArticleDAO dao = (ExpertArticleDAO) otx
					.getBean("ExpertArticleDAO");
			PrintWriter out = response.getWriter();
			 /**从jsp页面获取文章id**/
			String Article_Id = new String(request.getParameter("Article_Id"));
			 /**通过文章id获取文章对象**/
			ExpertArticle article = dao.SelectArticle(Integer
					.parseInt(Article_Id));

			/**修改文章标题**/
			article.setTitle(request.getParameter("title").toString());
			//System.out.println(request.getParameter("title").toString());
			/**修改文章内容**/
			article.setContent(request.getParameter("content").toString());
			/**修改文章时间**/
			Timestamp time = new Timestamp(System.currentTimeMillis());
			article.setTime(time);

			/**更新文章对象，返回值为boolean型,修改失败返回error，否则success**/
			if (dao.UpdateArticle(article)) {
				System.out.println("专家修改文章成功");
				FORWARD = "success";
				out.println("yes");
			}else {
				//System.out.println("专家修改文章失败");
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
	 * 删除专家文章
	 * @return 是否处理成功
	 * @throws Exception
	 */
	public String DeleteArticle() throws Exception {

		System.out.println("运行到了专家文章处理action！-----DeleteArticle");
		String FORWARD = "error";
		try {
			// 取得reqeust对象
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf-8");
			HttpServletResponse response = ServletActionContext.getResponse();
			
			 /**Spring调用相应DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			ExpertArticleDAO dao = (ExpertArticleDAO) otx
					.getBean("ExpertArticleDAO");

			PrintWriter out = response.getWriter();
			
			 /**从jsp页面获取文章id**/
			String Article_Id = new String(request.getParameter("Article_Id"));
			 /**先通过文章id找到文章对象，再删除该文章记录**/
			ExpertArticle article = dao.SelectArticle(Integer
					.parseInt(Article_Id));
			
			if (dao.DeleteArticle(article)) {
				//System.out.println("删除专家文章成功");
				FORWARD = "success";
				out.println("yes");
			} else {
				//System.out.println("删除专家文章失败");
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
	 * 根据专家Id获取专家文章列表
	 * 
	 * @return 是否成功
	 */
	public String getBriefListForRead() {
		System.out.println("运行到了专家文章处理action！-----getBriefListForRead");
		String forward = "success";
		
		 /**获取request和response对象**/
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		 /**获取session，以便获得专家id**/
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");

			 /**通过session获得专家id**/
			String expename = new String(session.get("expename").toString()
					.getBytes("iso8859-1"), "utf-8");
			
			 /**Spring调用相应DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			ExpertArticleDAO dao = (ExpertArticleDAO) otx
					.getBean("ExpertArticleDAO");
			 
			/**通过专家id获取专家文章列表**/
			List<ExpertArticle> articleList = dao.FindArticleByExpeId(expename);

			 /**定义json对象和数组，目的是把从数据库获取内容返回到jsp页面**/
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			JSONObject article = null;
			for (int i = 0; i < articleList.size(); i++) {

				article = new JSONObject();
				// 文章id
				article.put("Article_Id", articleList.get(i).getId());
				// 题目
				article.put("title", articleList.get(i).getTitle().toString());
				// 时间
				String showTime=timeFormat.format(articleList.get(i).getTime());
				article.put("time", showTime);
				
				array.add(article); /**将一个文章对象添加到json数组中去**/
			}
			json.put("acount", articleList.size());  /**通过专家id找到文章数目**/
			json.put("ArticleArray", array);
			out = response.getWriter();
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			forward = "error";  /**出错返回当前页面**/
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";  /**出错返回当前页面**/
		}
		return forward;
	}

	
	/**
	 * 根据文章Id 读取详细的文章信息
	 * @author larch
	 */
	public String getArticleForRead() {
		System.out.println("运行到了专家文章处理action！-----getArticleForRead");
		// 取得reqeust对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String forward = "success";
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		try {
			/**设置request和response的编码格式为utf-8**/
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");

			 /**Spring调用相应DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			ExpertArticleDAO dao = (ExpertArticleDAO) otx
					.getBean("ExpertArticleDAO");
			
			 /**从jsp页面获取文章id，再将其转为整型**/
			String aticleId = request.getParameter("Article_Id");
			int id = Integer.parseInt(aticleId);
			ExpertArticle articeDetail = dao.SelectArticle(id); /**通过文章id找到文章对象**/
			// 题目
			json.put("title", articeDetail.getTitle().toString());
			// 创建时间
			String showTime=timeFormat.format(articeDetail.getTime());
			json.put("time", showTime);
			// 文章内容
			json.put("content", articeDetail.getContent().toString());
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
