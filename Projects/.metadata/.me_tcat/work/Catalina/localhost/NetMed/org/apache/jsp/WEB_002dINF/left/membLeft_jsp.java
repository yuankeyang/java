package org.apache.jsp.WEB_002dINF.left;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class membLeft_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	String host = request.getScheme() + "://"
			+ request.getHeader("host");
	request.setAttribute("host", host);

      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/core_header.jsp", out, false);
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/centerLeft.css\" rel=\"stylesheet\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/centerLeft.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/ajax-pushlet-client.js\"></script>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("\r\n");
      out.write("<title>会员个人中心</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body {\r\n");
      out.write("\toverflow-x: hidden;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"content\">\r\n");
      out.write("\t\t<div class=\"mainContent\">\r\n");
      out.write("\t\t\t<div class=\"leftMain\">\r\n");
      out.write("\t\t\t\t<div class=\"orange\"></div>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li class=\"focusColor\"><a id=\"wodeCen\" href=\"wodeCen\"\r\n");
      out.write("\t\t\t\t\t\ttarget=\"rightFrame\">我的中心</a></li>\r\n");
      out.write("\t\t\t\t\t<li id=\"sel1\">医疗服务</li>\r\n");
      out.write("\t\t\t\t\t<div id=\"selD1\" class=\"vanish\">\r\n");
      out.write("\t\t\t\t\t\t<a id=\"wodeDoc\" href=\"wodeDoc\" target=\"rightFrame\">我的专家</a>\r\n");
      out.write("\t\t\t\t\t\t <a id=\"huanyouSoc\" href=\"javascript:void(0)\" onclick=\"alert('功能正在实现')\" target=\"rightFrame\">患友会</a>\r\n");
      out.write("\t\t\t\t\t\t <a id=\"jiuyiExp\" href=\"jiuyiExp\" target=\"rightFrame\">就医经验</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<li id=\"sel2\">我的可穿戴设备</li>\r\n");
      out.write("\t\t\t\t\t<div id=\"selD2\" class=\"vanish\">\r\n");
      out.write("\t\t\t\t\t\t<a id=\"myBloodPressure\" href=\"myBloodPressure\" target=\"rightFrame\">我的血压</a>\r\n");
      out.write("\t\t\t\t\t\t<a id=\"mySleepRecord\" href=\"mySleepRecord\" target=\"rightFrame\">我的睡眠</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<li id=\"sel3\">疾病管理</li>\r\n");
      out.write("\t\t\t\t\t<div id=\"selD3\" class=\"vanish\">\r\n");
      out.write("\t\t\t\t\t\t<a id=\"jibingMan\" href=\"jibingMan\" target=\"rightFrame\">离线咨询</a>\r\n");
      out.write("\t\t\t\t\t\t<a id=\"myAppointment\" href=\"myAppointment\" target=\"rightFrame\">我的预约</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<li id=\"sel4\">我的家属</li>\r\n");
      out.write("\t\t\t\t\t<div id=\"selD4\" class=\"vanish\">\r\n");
      out.write("\t\t\t\t\t\t<a id=\"myfamily\" href=\"myfamily\" target=\"rightFrame\">我的家属</a>\r\n");
      out.write("\t\t\t\t\t\t<a id=\"membArchInfo\" href=\"membArchInfo\" target=\"rightFrame\">电子健康档案</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<li id=\"sel5\">我的账户</li>\r\n");
      out.write("\t\t\t\t\t<div id=\"selD5\" class=\"vanish\">\r\n");
      out.write("\t\t\t\t\t\t<a id=\"caiwuMan\" href=\"caiwuMan\" target=\"rightFrame\">财务管理</a>\r\n");
      out.write("\t\t\t\t\t\t<a id=\"jifenMan\" href=\"jifenMan\" target=\"rightFrame\">积分管理</a>\r\n");
      out.write("\t\t\t\t\t\t<a id=\"gerenInfo\" href=\"gerenInfo\" target=\"rightFrame\">个人信息管理</a>\r\n");
      out.write("\t\t\t\t\t\t<a id=\"passChange\" href=\"passChange\" target=\"rightFrame\">修改密码</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<script>\r\n");
      out.write("\t\t\t\t$(window).load(\r\n");
      out.write("\t\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\t\thobj = $.ajax({\r\n");
      out.write("\t\t\t\t\t\t\t\turl : 'wodeCen',\r\n");
      out.write("\t\t\t\t\t\t\t\tsuccess : function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\terror : function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\talert(\"加载信息错误\");\r\n");
      out.write("\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\tasync : false\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t$(window.frames[\"rightFrame\"].document).html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\thobj.responseText);\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t</script>\r\n");
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
