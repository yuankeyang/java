package com.netmed.action.expert;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.exception.DataException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmed.dao.ExpertNoticeDAO;
import com.netmed.pojo.ExpeRegi;
import com.netmed.pojo.ExpertNotice;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 专家公告action
 * @author Administrator
 * 添加新的公告
 */
public class GongGaoAction extends ActionSupport
{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 增加新的公告
	 * @return 是否处理成功
	 * @throws Exception
	 */
	/**定义时间显示格式！！！！**/
	SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy年M月d日   HH时mm分");
	
	public String AddGongGao() throws Exception
	{
		System.out.println("运行到了建立新公告处理action！");
		String FORWARD = "error";
		// 取得reqeust对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		try {
			
			/**设置request对象的编码格式为gb2312**/
			request.setCharacterEncoding("gb2312");
			response.setContentType("text/html;charset=utf-8");	
			out = response.getWriter();
			ExpertNotice gonggao=getParaFromJsp(request);
			
			/**Spring调用DAO**/
			ApplicationContext otx = new ClassPathXmlApplicationContext("applicationContext.xml");
			ExpertNoticeDAO dao = (ExpertNoticeDAO) otx.getBean("ExpertNoticeDAO");
			
			int save=dao.NewGongGao(gonggao); /**调用DAO新建一个公告，返回值不为0则创建成功**/
			if(save!=0){
				System.out.println("专家新增一个公告-----成功");
				FORWARD = "success";	
				out.println("yes");
			}else{
				System.out.println("专家新增一个公告-----失败");
				out.println("no");
			}
		} catch (DataException e) { 
			FORWARD = "error";
			System.out.println("hibernate数据异常处理！！！！！");
			e.printStackTrace();

		}finally{
			if(out!=null){
				out.flush();
				out.close();
			}
		}
		return FORWARD;
	}
	
	/**从jsp页面获取公告参数*/
	public ExpertNotice getParaFromJsp(HttpServletRequest request)
	{
		ExpertNotice gonggao=new ExpertNotice();
		Map<String, Object> session = ServletActionContext.getContext().getSession();
		
		//获取专家Id
		String expename;
		try {
			expename = new String(session.get("expename").toString().getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			expename="bugToDeal";
			e.printStackTrace();
		}
		
		System.out.println(expename);
		ExpeRegi expert= new ExpeRegi();
		expert.setExpeId(expename);
		gonggao.setExpeRegi(expert);
		
		//公告内容
		String content = request.getParameter("content").toString();
		gonggao.setContent(content);
		
		return gonggao;
	}
}
