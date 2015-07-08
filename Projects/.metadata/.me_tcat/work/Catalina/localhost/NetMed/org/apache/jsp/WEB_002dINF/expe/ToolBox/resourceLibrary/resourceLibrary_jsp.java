package org.apache.jsp.WEB_002dINF.expe.ToolBox.resourceLibrary;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.sql.*;

public final class resourceLibrary_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction check() {\r\n");
      out.write("\t\tif ($('#search_ToolBox').val() == \"\") {\r\n");
      out.write("\t\t\talert(\"输入框不能为空!\");\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$('#SerachToolBox').submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<div><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/left.png\"/>&nbsp;&nbsp;<span style=\"font-family:'仿宋';font-size:30pt\">资料库</span>\r\n");
      out.write("\t\t&nbsp;&nbsp;<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/right.png\"/></div>\r\n");
      out.write("\t<div style=\"width: 90%;\">\r\n");
      out.write("\t\t<div style=\"margin-left: 70px\">\r\n");
      out.write("\t\t\t<form method=\"get\" id=\"ResourceLibrary\" action=\"ResourceLibrary\">\r\n");
      out.write("\t\t\t\t<h1>\r\n");
      out.write("\t\t\t\t\t<label style=\"font-family:'宋体';margin-left:200px\">资料库搜索</label>\r\n");
      out.write("\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t<div align=\"center\">\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/image/normalbutton_a.png\" onclick=\"check();\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"height: 36px;margin-left:10px;float: right;margin-right: 150px\" />\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"search_ToolBox\" value=\"\" id=\"search_ToolBox\" maxlength=200\r\n");
      out.write("\t\t\t\t\t\tplaceholder=\"请输入资料名...\" style=\"width: 60%;height: 40px;float: right;font-family:'宋体';font-size:18px;border-radius:8px\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\r\n");
      out.write("\t\t<div style=\"margin-top:50px;margin-left:130px;width: 80%;\">\r\n");
      out.write("\t\t\t<div style=\"\" class=\"container\" id=\"toolBox_list\">\r\n");
      out.write("\t\t\t\t<div style=\"height: 140px;width:600px;margin-top: 10px\">\r\n");
      out.write("\t\t\t\t\t<a href=\"http://drugs.medlive.cn/index.jsp\"><img\r\n");
      out.write("\t\t\t\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/r1.png\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</a> &nbsp;&nbsp;&nbsp; <a href=\"http://meddic.medlive.cn/index.do\"\r\n");
      out.write("\t\t\t\t\t\t><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/r2.png\">\r\n");
      out.write("\t\t\t\t\t</a> &nbsp;&nbsp;&nbsp; <a href=\"http://cals.medlive.cn/\"\r\n");
      out.write("\t\t\t\t\t\t><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/r3.png\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div style=\"height: 140px;width:600px;margin-top: 20px\">\r\n");
      out.write("\t\t\t\t\t<a href=\"http://inspects.medlive.cn/\"><img\r\n");
      out.write("\t\t\t\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/r4.png\">\r\n");
      out.write("\t\t\t\t\t</a> &nbsp;&nbsp;&nbsp; <a href=\"http://jour.medlive.cn/\"\r\n");
      out.write("\t\t\t\t\t\t> <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/r5.png\">\r\n");
      out.write("\t\t\t\t\t</a> &nbsp;&nbsp;&nbsp; <a href=\"http://mesh.medlive.cn/\"\r\n");
      out.write("\t\t\t\t\t\t><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/r6.png\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
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
