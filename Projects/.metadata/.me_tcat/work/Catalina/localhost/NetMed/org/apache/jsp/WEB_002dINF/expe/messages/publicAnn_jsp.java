package org.apache.jsp.WEB_002dINF.expe.messages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.sql.*;

public final class publicAnn_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	String name = (String) session.getAttribute("expename");

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/article.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("         function check(){\r\n");
      out.write("\t\t\t\t//alert($('#title').val());\r\n");
      out.write("\t\t\t\tif($('#content').val()==\"\"){\r\n");
      out.write("\t\t\t\t\t$(\"#content\").select();\r\n");
      out.write("\t\t\t\t\t$(\"#content\").focus();\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\tsubmit();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//<form action=\"AddGongGao\" id=\"AddGongGao\" method=\"post\">\r\n");
      out.write("\t\t\tfunction submit(){\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t        url : '");
      out.print(templateUrl);
      out.write("/expe/AddGongGao',\r\n");
      out.write("\t\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\t\tdata:\"content=\"+$('#content').val(),\r\n");
      out.write("\t\t\t\tcontentType: \"application/x-www-form-urlencoded; charset=utf-8\", \r\n");
      out.write("\t\t\t\tdataType : 'text',\r\n");
      out.write("\t\t\t\ttimeout : 8000,\r\n");
      out.write("\t\t\t\tcache : true,\r\n");
      out.write("\t\t\t\terrot:erryFunction,\r\n");
      out.write("\t\t\t\tsuccess : succFunction\r\n");
      out.write("\t\t\t//成功执行方法  \r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\tfunction erryFunction() {\r\n");
      out.write("\t\t\t\talert(\"有错误，请刷新页面\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t\tvar  data= String($.trim(data)); \r\n");
      out.write("\t\t\t\tif(data==\"yes\"){\r\n");
      out.write("\t\t\t\t\talert(\"发送新公告成功\");\r\n");
      out.write("\t\t\t\t\twindow.location=\"publicAnn\";\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\talert(\"新公告发布失败！请重试\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h3>公告栏</h3>\r\n");
      out.write("<hr></hr>\r\n");
      out.write("\r\n");
      out.write("\t\t   <div style=\"margin-top:10px;margin-left:15px\">\r\n");
      out.write("\t\t\t<textarea id=\"content\" name=\"content\" style=\"width:50%;height:100px;\"></textarea>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"mysubmit\" style=\"margin-top:15px;width:500px;margin-left:150px;font-family: KaiTi_GB2312;font-size: 25pt; text-align: center;\">\r\n");
      out.write("\t\t\t\t<input type=\"button\" value=\"发公告\" onclick=\"check();\" style=\"font-family: KaiTi_GB2312;font-size: 20pt;\">\r\n");
      out.write("\t\t\t</div>\r\n");
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
