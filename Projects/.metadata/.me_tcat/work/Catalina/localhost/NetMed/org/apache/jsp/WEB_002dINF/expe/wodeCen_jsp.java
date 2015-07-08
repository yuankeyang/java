package org.apache.jsp.WEB_002dINF.expe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class wodeCen_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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

	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", -10);

      out.write('\r');
      out.write('\n');

String basepath = request.getScheme() + "://"
		+ request.getHeader("host") + request.getContextPath();
String templateUrl = request.getScheme() + "://"
	+ request.getHeader("host") + request.getContextPath();
request.setAttribute("url", templateUrl);
	String name = (String) session.getAttribute("expename");
	String times = System.currentTimeMillis() + "";

      out.write("\r\n");
      out.write("<!DOCTYPE>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/centerLeft.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/ajax-pushlet-client.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("   .offAccount a{ color:#000;text-decoration:none }\r\n");
      out.write("   .offAccount a:hover{color:#ff0000}\r\n");
      out.write("   .offAccount a:active{color:#ff0000}   \r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\r\n");
      out.write("\tvar dd='");
      out.print(name);
      out.write("';\r\n");
      out.write("\tif(dd==null){\r\n");
      out.write("\t\talert(\"您已不在线，请重新登录！\");\r\n");
      out.write("\t\twindow.location.reload();\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\t//setInterval(\"geChatInfo()\", 10000);\r\n");
      out.write("\t\tgetGeRenInfo();\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function getGeRenInfo(){\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("        url : '");
      out.print(templateUrl);
      out.write("/expe/getExpeCenData',\r\n");
      out.write("        type : 'POST',\r\n");
      out.write("        contentType: \"application/x-www-form-urlencoded; charset=utf-8\", \r\n");
      out.write("\t\t dataType : 'json',\r\n");
      out.write("\t\t timeout : 20000,\r\n");
      out.write("\t\t cache : true,\r\n");
      out.write("\t\t error : erryFunction, //错误执行方法  \r\n");
      out.write("\t\t success : succFunction\t//成功执行方法  \r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction erryFunction() {alert(\"正获取个人信息，请耐心等待\");}\r\n");
      out.write("\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$('#rank').html(data.rank);\r\n");
      out.write("\t\t\t$('#credit').html(data.credit);\r\n");
      out.write("\t\t\t$('#money').html(data.money);\r\n");
      out.write("\t\t\t//alert(data.photo);\r\n");
      out.write("\t\t\t$('#photo').attr(\"src\",'");
      out.print(basepath);
      out.write("'+data.photo+\"?_t");
      out.print(times);
      out.write("\");\r\n");
      out.write("\t\t\tif(parseInt(data.membConsAccount)!=0){\r\n");
      out.write("\t\t\t\t$(\"#records\").append(\"<li class=\\\"offAccount\\\">您有<font size=\\\"7\\\"><b><a href='noreadBox'>\"+data.membConsAccount+\"</a></b></font>条未处理的离线咨询，请到通知中心尽快处理呦!</li>\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(parseInt(data.appointmentAccount)!=0){\r\n");
      out.write("\t\t\t\t$(\"#records\").append(\"<li class=\\\"offAccount\\\">您有<font size=\\\"7\\\"><b><a href='appointMan'>\"+data.appointmentAccount+\"</a></b></font>条未处理的预约，请到通知中心尽快处理呦!</li>\");\r\n");
      out.write("\t\t\t}//\r\n");
      out.write("\t};\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body >\r\n");
      out.write("<div><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/left.png\"/>&nbsp;&nbsp;<span style=\"font-family:'仿宋';font-size:30px;color:#c9b28b\">个人中心</span>\r\n");
      out.write("\t\t&nbsp;&nbsp;<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/right.png\"/></div>\r\n");
      out.write("  <div>\r\n");
      out.write("\t<div>");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div  style=\"margin-left: 100px; margin-top:10px;width:70%;\" >\r\n");
      out.write("\t\t   <div style=\"height: 0px;margin-left: 160px;\" >\r\n");
      out.write("\t\t      <h1 style=\"font-family:'宋体'\"> ");
      out.print(name);
      out.write("&nbsp;您好！</h1>\r\n");
      out.write("\t\t   </div>\r\n");
      out.write("\t\t\t<div style=\"margin-right: 20px;margin-top: 20px;\" align=\"right\">\r\n");
      out.write("\t\t\t\t<a target=\"_blank\"  href=\"javascript:void(0)\"><img width=\"110\" height=\"35\"\r\n");
      out.write("\t\t\t\t\tsrc=\"");
      out.print(basepath);
      out.write("/images/nousedphone.png\" title=\"下载手机客户端，随时随地联系颐健通\">\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"margin-left: 100px;margin-top: 30px;font-size: 14pt;font-family: '宋体';\" align=\"left\"  >\r\n");
      out.write("\t\t\t      积分: <a href=\"javascript:void(0)\" id=\"credit\"></a>分&nbsp;&nbsp;\r\n");
      out.write("\t\t\t    账户余额: <a href=\"javascript:void(0)\" id=\"money\"></a>元&nbsp;&nbsp;\r\n");
      out.write("\t\t\t    等级: <a href=\"javascript:void(0)\" id=\"rank\"></a>\r\n");
      out.write("\t\t\t    <label id=\"test\"></label>\r\n");
      out.write("\t     \t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br/>\r\n");
      out.write("    <hr>\r\n");
      out.write("\t<div style=\"margin-top: 20px;font-size: 14pt;font-family:'宋体';\">\r\n");
      out.write("\t\t<h3>最近的通知:</h3>\r\n");
      out.write("\t\t<ul id=\"records\"></ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\t\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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
