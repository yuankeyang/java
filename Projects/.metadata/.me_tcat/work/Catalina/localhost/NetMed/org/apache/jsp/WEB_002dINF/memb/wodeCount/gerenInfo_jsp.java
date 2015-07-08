package org.apache.jsp.WEB_002dINF.memb.wodeCount;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.sql.*;

public final class gerenInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");

	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	String userId = (String) session.getAttribute("username");

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction change() {\r\n");
      out.write("\t\t$(\"#origin\").hide();\r\n");
      out.write("\t\t$(\"#xiugai\").show();\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction saveChange() {\r\n");
      out.write("\t\t//var nameReg = /^[a-zA-Z][a-zA-Z0-9_]{5}$/;\r\n");
      out.write("\t\tvar mobileReg = /^1[3|4|5|8][0-9]\\d{4,8}$/;\r\n");
      out.write("\t\tvar mailReg = /^(\\w-*\\.*)+@(\\w-?)+(\\.\\w{2,})+$/;\r\n");
      out.write("\t\tvar name = $(\"#username1\").val();\r\n");
      out.write("\t\tvar mobile = $(\"#phone1\").val();\r\n");
      out.write("\t\tvar mail = $(\"#mail1\").val();\r\n");
      out.write("\t\t//if (!nameReg.test(name)) {\r\n");
      out.write("\t\t//\talert(name);\r\n");
      out.write("\t\t//\talert(\"用户名由英文字母和数字组成，英文开头开头，输入6位\");\r\n");
      out.write("\t\t//} else\r\n");
      out.write("\t\tif (!mobileReg.test(mobile)) {\r\n");
      out.write("\t\t\talert(\"手机号码填写不正确\");\r\n");
      out.write("\t\t} else if (!mailReg.test(mail)) {\r\n");
      out.write("\t\t\talert(\"邮箱填写不正确\");\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t///$(\"#change\").submit();\r\n");
      out.write("\t\t\tsubmit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction submit(){\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t        url : '");
      out.print(templateUrl);
      out.write("/user/UpdatePersonInfoAction',\r\n");
      out.write("\t\t\ttype : 'get',\r\n");
      out.write("\t\t\tdata:\"memb_name=\"+$('#username1').val()+\"&memb_mobile=\"+$('#phone1').val()+\"&memb_mail=\"+$('#mail1').val(),\r\n");
      out.write("\t\t\tcontentType: \"application/x-www-form-urlencoded; charset=utf-8\", \r\n");
      out.write("\t\t\tdataType : 'text',\r\n");
      out.write("\t\t\ttimeout : 8000,\r\n");
      out.write("\t\t\tcache : true,\r\n");
      out.write("\t\t\terrot:erryFunction,\r\n");
      out.write("\t\t\tsuccess : succFunction\r\n");
      out.write("\t\t//成功执行方法  \r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction erryFunction() {\r\n");
      out.write("\t\t\talert(\"有错误，请刷新页面\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\tvar  data= String($.trim(data)); \r\n");
      out.write("\t\t\tif(data==\"yes\"){\r\n");
      out.write("\t\t\t\talert(\"修改成功\");\r\n");
      out.write("\t\t\t\twindow.location=\"gerenInfo\";\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\talert(\"信息填写有误!请重试\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\twindow.onload = function(){\r\n");
      out.write("\t\t//获取个人信息\r\n");
      out.write("\t\tgetGeRenInfo();\r\n");
      out.write("\t};\r\n");
      out.write("\tfunction getGeRenInfo(){\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t        url : '");
      out.print(templateUrl);
      out.write("/user/GetPersonInfoAction',\r\n");
      out.write("\t        type : 'POST',\r\n");
      out.write("\t        contentType: \"application/x-www-form-urlencoded; charset=utf-8\", \r\n");
      out.write("\t\t\t dataType : 'json',\r\n");
      out.write("\t\t\t timeout : 8000,\r\n");
      out.write("\t\t\t cache : true,\r\n");
      out.write("\t\t\t error : erryFunction, //错误执行方法  \r\n");
      out.write("\t\t\t success : succFunction\t//成功执行方法  \r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\tfunction erryFunction() {alert(\"获取个人信息出错，请重试!!\");}\r\n");
      out.write("\t\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t\t$('#username').text(data.username);\r\n");
      out.write("\t\t\t\t$('#phone').text(data.phone);\r\n");
      out.write("\t\t\t\t$('#mail').text(data.mail);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t//$('#username1').val(data.username);\r\n");
      out.write("\t\t\t\t//$('#phone1').val(data.phone);\r\n");
      out.write("\t\t\t\t//$('#mail1').val(data.mail);\r\n");
      out.write("\t\t};\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div align=\"center\" style=\"margin-top: 10px;\">\r\n");
      out.write("<div><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/left.png\"/>&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-family:'宋体';font-size:30px;color:#c9b28b;\">修改个人信息</span>&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/right.png\"/></div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t<div id=\"origin\" style=\"height: 60px;margin-top: 30px;\" align=\"center\">\r\n");
      out.write("\t<table style=\"font-family:'宋体';font-size: 15pt; text-align: left;\">   <!-- 宋体 -->\r\n");
      out.write("\t\t<tr>\t\r\n");
      out.write("\t\t   <td><label>姓名:</label></td>\r\n");
      out.write("\t\t   <td><label id=\"username\"></label></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr> \r\n");
      out.write("\t\t\t<td><label>手机号码:</label></td>\r\n");
      out.write("\t\t\t<td><label id=\"phone\"></label></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr> \r\n");
      out.write("\t\t\t<td><label>邮箱:</label></td>\r\n");
      out.write("\t\t\t<td><label id=\"mail\"></label></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t  <td colspan=\"2\">\r\n");
      out.write("\t\t\t<input type=\"button\" onclick=\"change();\" value=\"修   改\" style=\"font-family:'宋体';font-size: 15pt;text-align:center\">\r\n");
      out.write("\t\t  <td>\r\n");
      out.write("\t\t</tr>\t\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"xiugai\" style=\"display:none;margin-top: 30px;\">\r\n");
      out.write("\t\t<form id=\"change\" method=\"get\" action=\"UpdateExpePersonInfoAction\">\r\n");
      out.write("\t\t\t<table style=\"font-family:'宋体';font-size: 15pt; text-align: center;\">\r\n");
      out.write("\t\t\t\t<tr>\t\r\n");
      out.write("\t\t\t\t   <td><label>姓名:</label></td>\r\n");
      out.write("\t\t\t\t   <td><input id=\"username1\" name=\"expe_name\" type=\"text\" ></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr> \r\n");
      out.write("\t\t\t\t\t<td><label>手机号码:</label></td>\r\n");
      out.write("\t\t\t\t\t<td><input id=\"phone1\" name=\"expe_mobile\" type=\"text\"\t></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr> \r\n");
      out.write("\t\t\t\t\t<td><label>邮箱:</label></td>\r\n");
      out.write("\t\t\t\t\t<td><input id=\"mail1\" name=\"expe_mail\" type=\"text\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t  <td>\r\n");
      out.write("\t\t\t\t\t<input type=\"reset\" value=\"重置\" style=\"font-family: '宋体';font-size: 15pt;\"/>\r\n");
      out.write("\t\t\t\t  <td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t  <input onclick=\"saveChange()\" type=\"button\" value=\"保存\" style=\"font-family:'宋体';font-size: 15pt;\">\r\n");
      out.write("\t\t\t\t  </td>\r\n");
      out.write("\t\t\t\t</tr>\t\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
