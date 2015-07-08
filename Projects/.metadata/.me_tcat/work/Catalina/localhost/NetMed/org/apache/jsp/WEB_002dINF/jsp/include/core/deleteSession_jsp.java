package org.apache.jsp.WEB_002dINF.jsp.include.core;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class deleteSession_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    \r\n");
      out.write("   ");
      com.Bean.db_manager dbmanager = null;
      synchronized (_jspx_page_context) {
        dbmanager = (com.Bean.db_manager) _jspx_page_context.getAttribute("dbmanager", PageContext.PAGE_SCOPE);
        if (dbmanager == null){
          dbmanager = new com.Bean.db_manager();
          _jspx_page_context.setAttribute("dbmanager", dbmanager, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');

String expename=(String)session.getAttribute("expename");
String sql2=null;
if(expename!=null){
	sql2="update expe_regi set state=0 where expe_id='"+expename+"'";
}else {
	sql2="update memb_regi set state=0 where memb_id='"+session.getAttribute("username")+"'";
}
if(dbmanager.update(sql2)==0){
	System.out.println("database update state=0 ERROR!!!");
}
session.invalidate();
String index= request.getScheme() + "://" + request.getHeader("host") +request.getContextPath()+"/welcome";
response.sendRedirect(index);




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
