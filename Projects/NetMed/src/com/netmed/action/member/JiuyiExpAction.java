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
import org.hibernate.exception.DataException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.MemberArticleDAO;
import com.netmed.pojo.MembRegi;
import com.netmed.pojo.MemberArticle;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author larch 会员就医经验文章action，接收会员就医经验文章信息
 * 05-15
 */
public class JiuyiExpAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 增加新的就医经验文章
	 * @return 是否处理成功
	 * @throws Exception
	 */
	/**定义时间显示格式！！！！**/
	SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy/M/d  HH:mm");
	public String AddJiuyiExp() throws Exception {

		System.out.println("运行到了就医经验文章处理action！---AddJiuyiExp");
		String FORWARD = "error";
		try {
			//获取request对象
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("gb2312");//设置字符编码格式为gb2312
			
			//调用getParaFromJsp方法，获取当前页面的对象，参数为request对象
			MemberArticle article=getParaFromJsp(request);
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			//Spring调用相应DAO
			MemberArticleDAO dao = (MemberArticleDAO) otx.getBean("MemberArticleDAO");
			//调用NewArticle方法，参数为要新增的文章对象，返回为非0的新增成功
			int save=dao.NewArticle(article);
			if(save!=0){
				System.out.println("会员新增一篇文章-----成功");
				FORWARD = "success";				
			}else{
				System.out.println("会员新增一篇文章-----失败");
			}

			
		} catch (DataException e) { 
			FORWARD = "error";
			System.out.println("hibernate数据异常处理！！！！！");
			e.printStackTrace();

		}
		return FORWARD;

	}
	
	//从jsp页面获取就医经验参数
	public MemberArticle getParaFromJsp(HttpServletRequest request){
		//新建一个就医经验对象
		MemberArticle article=new MemberArticle();
		
		Map<String, Object> session = ServletActionContext.getContext().getSession();
		//获取用户Id
		String username;
		try {
			//通过session得到会员id
			username = new String(session.get("username").toString().getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			username="bugToDeal";
			e.printStackTrace();
		}
		
		System.out.println("用户名："+username);
		MembRegi member = new MembRegi();
		//设置就医经验表中会员id字段
		member.setMembId(username);
		article.setMembRegi(member);
		
		//就医经验标题
		String title = request.getParameter("title").toString();
		article.setTitle(title);
		
		//就医经验内容
		String content = request.getParameter("content").toString();
		article.setContent(content);
		
		//创建时间
		Timestamp time = new Timestamp(System.currentTimeMillis());
		article.setTime(time);
		
		return article;
	}
	
	/**
	 * 更新就医经验文章
	 * @return 是否处理成功
	 * @throws Exception
	 */
	public String UpdateJiuyiExp() throws Exception {

		System.out.println("运行到了会员文章处理action！-----update");
		String FORWARD = "error";
		try {
			// 取得request对象
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf-8");
			HttpServletResponse response = ServletActionContext.getResponse();
			
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			//Spring调用相应DAO
			MemberArticleDAO dao = (MemberArticleDAO) otx.getBean("MemberArticleDAO");
			PrintWriter out = response.getWriter();
			//获取相关就医文章Id
			String JiuyiExp_Id = new String(request.getParameter("JiuyiExp_Id"));
			//根据就医经验表单id，查询一篇文章，就医经验
			MemberArticle article=dao.SelectArticle(Integer.parseInt(JiuyiExp_Id));
							
			//修改文章标题
			article.setTitle(request.getParameter("title").toString());
			//修改文章内容
			article.setContent(request.getParameter("content").toString());
			//修改时间
			Timestamp time = new Timestamp(System.currentTimeMillis());
			article.setTime(time);
	           
			//---------------------------------------------------------------------------------------
			//根据以上信息保存更新就医经验文章
			//---------------------------------------------------------------------------------------
			if(dao.UpdateArticle(article)){
				System.out.println("会员修改文章成功");
				FORWARD = "success";
				out.println("yes");
			}
			else{
				System.out.println("会员修改文章失败");
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
	 * 删除就医经验文章
	 * @return 是否处理成功
	 * @throws Exception
	 */
	public String DeleteJiuyiExp() throws Exception {

		System.out.println("运行到了会员文章处理action！-----DeleteJiuyiExp");
		String FORWARD = "error";
		try {
			//取得request对象
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf-8");
			HttpServletResponse response = ServletActionContext.getResponse();
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			//Spring调用相应DAO
			MemberArticleDAO dao = (MemberArticleDAO) otx.getBean("MemberArticleDAO");
			
			PrintWriter out = response.getWriter();
			//获取相关就医文章Id
			String JiuyiExp_Id = new String(request.getParameter("JiuyiExp_Id"));
			//调用SelectArticle方法，通过文章id找到文章，再删除
			MemberArticle article=dao.SelectArticle(Integer.parseInt(JiuyiExp_Id));
			
			if(dao.DeleteArticle(article)){
				System.out.println("删除就医经验文章成功");
				FORWARD = "success";
				out.println("yes");
			}
			else{
				System.out.println("删除就医经验文章失败");
				FORWARD = "error";
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
	 * 根据会员Id获取就医就医经验列表
	 * @return 是否成功
	 */
	public String getBriefListForRead() {
		System.out.println("运行到了会员文章处理action！-----getBriefListForRead");
		String forward = "success";
		//获取request和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		//获取session，以便获得会员id
		Map<String, Object> session = ServletActionContext.getContext().getSession();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			//通过session获得会员id
			String username = new String(session.get("username").toString().getBytes("iso8859-1"), "utf-8");
			System.out.println("用户名为："+username);
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			//Spring调用相应DAO
			MemberArticleDAO dao = (MemberArticleDAO) otx.getBean("MemberArticleDAO");
			//调用FindArticleByMembId方法，通过文章id查找特定的文章
			List<MemberArticle> articleList=dao.FindArticleByMembId(username);
			
			//---------------------------------------------------------------------------------------
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			JSONObject article=null;
			for(int i=0;i<articleList.size();i++){
				
				article=new JSONObject();
				//文章id
				article.put("JiuyiExp_Id", articleList.get(i).getId());
				//题目
				article.put("title", articleList.get(i).getTitle().toString());
				
				String showTime = timeFormat.format(articleList.get(i).getTime());
				article.put("time", showTime);
				
				array.add(article);
			}
			json.put("acount", articleList.size());
			json.put("JiuyiExpArray", array);
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
		return null;
	}
	
		/**
		 * 根据文章Id 读取详细的文章信息
		 * @author larch
		 * 
		 */
	public String getJiuyiExpForRead() {
		System.out.println("运行到了会员文章处理action！-----getJiuyiExpForRead");
		// 取得request对象和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String forward = "success";
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			//Spring调用相应DAO
			MemberArticleDAO dao = (MemberArticleDAO) otx.getBean("MemberArticleDAO");
			//从jsp页面获取文章id，再将其转为整型
			String JiuyiExp_Id = request.getParameter("JiuyiExp_Id");
			int id=Integer.parseInt(JiuyiExp_Id);
			//通过文章id找到文章对象
			MemberArticle articeDetail=dao.SelectArticle(id);
			//---------------------------------------------------------------------------------------
			//题目
			json.put("title", articeDetail.getTitle().toString());
			//创建时间
			String showTime = timeFormat.format(articeDetail.getTime());
			json.put("time", showTime);
			//文章内容
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
