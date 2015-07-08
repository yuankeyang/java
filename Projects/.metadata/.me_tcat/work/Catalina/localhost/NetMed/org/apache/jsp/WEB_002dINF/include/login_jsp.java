package org.apache.jsp.WEB_002dINF.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<div class=\"mask\"></div>\r\n");
      out.write("<div class=\"login-div\">\r\n");
      out.write("<div class=\"close-div\"><a href=\"javascript:void(0)\"><span class=\"close-btn\"></span></a></div>\r\n");
      out.write("<div class=\"login-title\"></div>\r\n");
      out.write("<div class=\"loginForm-div\">\r\n");
      out.write("\t<form id=\"loginForm\" method=\"post\">\r\n");
      out.write("\t<table class=\"login-table\">\r\n");
      out.write("\t<tr><td>[用户类型]</td><td><select id=\"usertype\">\r\n");
      out.write("\t\t<option value=\"user\" selected=\"selected\">普通用户</option>\r\n");
      out.write("        <option value=\"expe\">服务专家</option>\r\n");
      out.write("        <option value=\"medical-institutions\">服务机构</option>\r\n");
      out.write("\t</select></td></tr>\r\n");
      out.write("\t<tr><td>[用 户 名]</td><td><input name=\"username\" type=\"text\" /></td></tr>\r\n");
      out.write("\t<tr><td>[密   码]</td><td><input name=\"password\" type=\"password\" /></td></tr>\r\n");
      out.write("\t<tr><td colspan=\"2\"><button id=\"login-button\">登录</button></td></tr>\r\n");
      out.write("\t<tr><td colspan=\"2\"><a href=\"javascript:void(0)\">忘记密码？</a></td></tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("</div>");
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
