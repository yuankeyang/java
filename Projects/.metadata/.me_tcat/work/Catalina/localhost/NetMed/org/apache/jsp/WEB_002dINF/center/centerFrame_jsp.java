package org.apache.jsp.WEB_002dINF.center;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class centerFrame_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<frameset framespacing=\"0\" rows=\"40,*,60\">\r\n");
      out.write("\r\n");
      out.write("\t<frame frameborder=\"0\" name=\"topFrame\" noresize=\"noresize\"\r\n");
      out.write("\t\tscrolling=\"no\" src=\"");
      out.print(basePath);
      out.write("topbarDefault\">\r\n");
      out.write("\t<frameset framespacing=\"0\" cols=\"250px,*\">\r\n");
      out.write("\t\t<frame frameborder=\"0\" name=\"leftFrame\" noresize=\"noresize\"\r\n");
      out.write("\t\t\tsrc=\"");
      out.print(basePath);
      out.write("user/center-left\">\r\n");
      out.write("\t\t<frame frameborder=\"0\" name=\"rightFrame\" noresize=\"noresize\"\r\n");
      out.write("\t\t\tsrc=\"");
      out.print(basePath);
      out.write("user/wodeCen\">\r\n");
      out.write("\t</frameset>\r\n");
      out.write("\t<frame frameborder=\"0\" noresize=\"noresize\" scrolling=\"no\"\r\n");
      out.write("\t\tsrc=\"");
      out.print(basePath);
      out.write("footer\">\r\n");
      out.write("</frameset>\r\n");
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
