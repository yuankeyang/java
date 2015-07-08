package org.apache.jsp.WEB_002dINF.left;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class expeLeft_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
	String templateUrl = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath();
	request.setAttribute("url", templateUrl);
	String host=request.getScheme() + "://" + request.getHeader("host");
	request.setAttribute("host", host);
	String expename =  new String(session.getAttribute("expename").toString().getBytes("iso8859-1"), "utf-8");
	if (expename == null||expename=="") {
		response.sendRedirect(templateUrl);
	}

      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/core_head.jsp", out, false);
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/jquery.autocomplete.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.autocomplete.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/localdata.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/first.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/cssold/bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/cssold/register.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/cssold/usercenter.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/cssold/scenter.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/cssold/base.css\" rel=\"stylesheet\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/jsold/jquery.validate.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/jsold/register.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/jsold/usercenter.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/ajax-pushlet-client.js\"></script>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("<script>\r\n");
      out.write("function geChatInfo(){\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("        url : '");
      out.print(templateUrl);
      out.write("/expe/GetChatDataByExpertId',\r\n");
      out.write("        type : 'POST',\r\n");
      out.write("        contentType: \"application/x-www-form-urlencoded; charset=utf-8\", \r\n");
      out.write("\t\t dataType : 'json',\r\n");
      out.write("\t\t timeout : 15000,\r\n");
      out.write("\t\t cache : true,\r\n");
      out.write("\t\t error : erryFunction, //错误执行方法  \r\n");
      out.write("\t\t success : succFunction\t//成功执行方法  \r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction erryFunction() {alert(\"获取个人信息出错，请重试!!\");}\r\n");
      out.write("\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(parseInt(data.account)!=0){\r\n");
      out.write("\t\t\t\t$.each(data.chatArray,function(index) {\r\n");
      out.write("\t\t\t\t  alert(\"您有新的在线咨询！\");\r\n");
      out.write("\t\t\t\t  $('#chat').attr(\"href\",\"chat?mem_id=\"+data.chatArray[index].mem_id);\r\n");
      out.write("\t\t\t      document.getElementById(\"chat\").click();\r\n");
      out.write("\t\t\t  });\r\n");
      out.write("\t\t\t} \r\n");
      out.write("\t\t}\t\r\n");
      out.write("}\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\tsetInterval(\"geChatInfo()\",10000);\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("\t<script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<title>专家个人中心</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body{overflow-x:hidden !important;}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"usercenter_box\">\r\n");
      out.write("\t\t\t<div class=\"usercenter clearfix\">\r\n");
      out.write("\t\t\t\t<div class=\"usercenter_bg\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"usercenter_nav\">\r\n");
      out.write("\t\t\t\t\t<div class=\"bigtitle\">\r\n");
      out.write("\t\t\t\t\t\t<a id=\"wodeCen\" href=\"wodeCen\" target=\"rightFrame\">专家中心</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"item\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"listtitle\">\r\n");
      out.write("\t\t\t\t\t\t\t<i></i>个人管理\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"item_list\" style=\"display:block;\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a id=\"diaryMan\" href=\"diaryMan\" target=\"rightFrame\">日记管理</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a id=\"articleMan\" href=\"articleMan\" target=\"rightFrame\">文章管理</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a id=\"scheduleArr\" href=\"scheduleArr\" target=\"rightFrame\">日程安排</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a id=\"myservice\" href=\"myservice\" target=\"rightFrame\">离线服务</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a id=\"myappoint\" href=\"myappoint\" target=\"rightFrame\">我的预约</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"item\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"listtitle\" style=\"display:block;\">\r\n");
      out.write("\t\t\t\t\t\t\t<i></i>工具箱\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"item_list\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a id=\"myRepository\" href=\"myRepository\" target=\"rightFrame\">我的知识库</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a id=\"SpecialRepository\" href=\"SpecialRepository\" target=\"rightFrame\">专业知识库</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a id=\"resourceLibrary\" href=\"resourceLibrary\" target=\"rightFrame\">资料库</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"item\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"listtitle\" style=\"display:block;\">\r\n");
      out.write("\t\t\t\t\t\t\t<i></i>通知中心\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"item_list\" style=\"display:none;\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li><a id=\"noreadBox\" href=\"noreadBox\" target=\"rightFrame\">离线申请</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a id=\"appointMan\" href=\"appointMan\" target=\"rightFrame\">预约申请</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a id=\"publicAnn\" href=\"publicAnn\" target=\"rightFrame\">公告</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"item\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"listtitle\">\r\n");
      out.write("\t\t\t\t\t\t\t<i></i>我的账户\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"item_list\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a id=\"caiwuMan\" href=\"caiwuMan\" target=\"rightFrame\">财务管理</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a id=\"jifenMan\" href=\"jifenMan\" target=\"rightFrame\">积分管理</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a id=\"gerenInfo\" href=\"gerenInfo\" target=\"rightFrame\">个人信息管理</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a id=\"passChange\" href=\"passChange\" target=\"rightFrame\">修改密码</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"item\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"listtitle\">\r\n");
      out.write("\t\t\t\t\t\t\t<i></i>通讯录\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"item_list\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${host}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/BBS\" target=\"rightFrame\">患友会</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"lastadvice\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" class=\"blue\" target=\"_blank\">意见反馈</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("            <a target=\"_blank\"  id=\"chat\" style=\"display: none\"></a>\r\n");
      out.write("\t\t\t\t<script>\r\n");
      out.write("\t\t\t\t\t$(window).load(\r\n");
      out.write("\t\t\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\t\t\thobj = $.ajax({\r\n");
      out.write("\t\t\t\t\t\t\t\t\turl : 'wodeCen',\r\n");
      out.write("\t\t\t\t\t\t\t\t\tsuccess : function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\terror : function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\talert(\"加载信息错误\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\tasync : false\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t$(window.frames[\"rightFrame\"].document).html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\thobj.responseText);\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t</script>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
