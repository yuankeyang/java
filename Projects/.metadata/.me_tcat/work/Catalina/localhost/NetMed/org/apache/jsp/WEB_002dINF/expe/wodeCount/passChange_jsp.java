package org.apache.jsp.WEB_002dINF.expe.wodeCount;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.sql.*;

public final class passChange_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	String expeId = (String) session.getAttribute("expename");

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/article.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\tvar passReg = /^[a-zA-Z0-9]{6,15}$/;\r\n");
      out.write("\t\t\t$(\"#submit1\").click(function() {\r\n");
      out.write("\t\t\t\tvar pass = $(\"#passConInput\").val();\r\n");
      out.write("\t\t\t\tif (!passReg.test(pass)) {\r\n");
      out.write("\t\t\t\t\talert(\"密码由英文字母及数字组成，6到15位！\");\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t        url : '");
      out.print(templateUrl);
      out.write("/expe/EnsurePassAction',\r\n");
      out.write("\t\t\t\t\t\ttype : 'get',\r\n");
      out.write("\t\t\t\t\t\tdata:\"passConInput=\"+$('#passConInput').val(),\r\n");
      out.write("\t\t\t\t\t\tcontentType: \"application/x-www-form-urlencoded; charset=utf-8\", \r\n");
      out.write("\t\t\t\t\t\tdataType : 'text',\r\n");
      out.write("\t\t\t\t\t\ttimeout : 8000,\r\n");
      out.write("\t\t\t\t\t\tcache : true,\r\n");
      out.write("\t\t\t\t\t\terrot:erryFunction,\r\n");
      out.write("\t\t\t\t\t\tsuccess : succFunction\r\n");
      out.write("\t\t\t\t\t//成功执行方法  \r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\tfunction erryFunction() {\r\n");
      out.write("\t\t\t\t\t\talert(\"有错误，请刷新页面\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t\t\t\tvar  data= String($.trim(data)); \r\n");
      out.write("\t\t\t\t\t\tif(data==\"yes\"){\r\n");
      out.write("\t\t\t\t\t\t\t$('#passConDiv').hide();\r\n");
      out.write("\t\t\t\t\t\t\t$('#newpassConDiv').show();\r\n");
      out.write("\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\talert(\"密码错误!请重试\");\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t//window.location=\"gerenInfo\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t$(\"#submit2\").click(function() {\r\n");
      out.write("\t\t\t\tvar newpass = $(\"#newpassConInput\").val();\r\n");
      out.write("\t\t\t\talert(newpass);\r\n");
      out.write("\t\t\t\tif (!passReg.test(newpass)) {\r\n");
      out.write("\t\t\t\t\talert(\"密码由英文字母及数字组成，6到15位！\");\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t        url : '");
      out.print(templateUrl);
      out.write("/expe/UpdatePassAction',\r\n");
      out.write("\t\t\t\t\t\ttype : 'get',\r\n");
      out.write("\t\t\t\t\t\tdata:\"newpassConInput=\"+$('#newpassConInput').val(),\r\n");
      out.write("\t\t\t\t\t\tcontentType: \"application/x-www-form-urlencoded; charset=utf-8\", \r\n");
      out.write("\t\t\t\t\t\tdataType : 'text',\r\n");
      out.write("\t\t\t\t\t\ttimeout : 8000,\r\n");
      out.write("\t\t\t\t\t\tcache : true,\r\n");
      out.write("\t\t\t\t\t\terrot:erryFunction,\r\n");
      out.write("\t\t\t\t\t\tsuccess : succFunction\r\n");
      out.write("\t\t\t\t\t//成功执行方法  \r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\tfunction erryFunction() {\r\n");
      out.write("\t\t\t\t\t\talert(\"有错误，请刷新页面\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t\t\t\tvar  data= String($.trim(data)); \r\n");
      out.write("\t\t\t\t\t\tif(data==\"yes\"){\r\n");
      out.write("\t\t\t\t\t\t\talert(\"修改成功\");\r\n");
      out.write("\t\t\t\t\t\t\twindow.location=\"passChange\";\r\n");
      out.write("\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\talert(\"密码修改错误!请重试\");\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"passConDiv\" style=\"display: block;\">\r\n");
      out.write("\t\t<span>请输入原密码:</span>\r\n");
      out.write("\t\t\t<input id=\"passConInput\" type=\"text\"> \r\n");
      out.write("\t\t\t<input id=\"submit1\"\ttype=\"button\" value=\"提交\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"newpassConDiv\" style=\"display: none;\">\r\n");
      out.write("\t\t<span>请输入新密码:</span>\r\n");
      out.write("\t\t\t<input id=\"newpassConInput\" type=\"text\"><br/>\r\n");
      out.write("\t\t\t<span> 新密码确认:</span>\r\n");
      out.write("\t\t\t <input\r\n");
      out.write("\t\t\t\tid=\"renewpass\" type=\"text\"> <br/><input id=\"submit2\"\r\n");
      out.write("\t\t\t\ttype=\"button\" value=\"提交\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
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
