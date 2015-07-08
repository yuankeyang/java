package org.apache.jsp.WEB_002dINF.memb.yiliaoSer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.sql.*;

public final class huanyouSoc_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"hy_title clearfix pr\">\r\n");
      out.write("\t\t<h2 class=\"fl\">我的患友会</h2>\r\n");
      out.write("\t\t<span class=\"fr\"><strong>！</strong>发表话题请先进入相应的小组</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"hy_wel\">\r\n");
      out.write("\t\t<p>\r\n");
      out.write("\t\t\t尊敬的<span class=\"orange\">hdfrwn54</span>用户：\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\t\t<p>欢迎您来到患友会！</p>\r\n");
      out.write("\t\t<p>患友会是每个大夫个人网站下的一个分组讨论区，如跟医生交流过，您就有机会加入他的患友会.</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"hy_method\">\r\n");
      out.write("\t\t<h2 class=\"orange\">入会方式：</h2>\r\n");
      out.write("\t\t<h3>1.医生的患友会小组</h3>\r\n");
      out.write("\t\t<p>当您向医生咨询并且得到医生2次回复时，即可自动入会。</p>\r\n");
      out.write("\t\t<h3>2.医生的专业组</h3>\r\n");
      out.write("\t\t<p>医生根据您的疾病、地区、病情、治疗等方面，邀请您加入患友会。</p>\r\n");
      out.write("\t\t<p>\r\n");
      out.write("\t\t\t如您还没有入会，欢迎您随时加入。 (<a href=\"#\" class=\"orange\">如何使用患友会？</a>)\r\n");
      out.write("\t\t</p>\r\n");
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
