package org.apache.jsp.WEB_002dINF.memb.qiuyi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class intelligent_005fquery1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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

	String path = request.getContextPath();
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	String search_str = new String(request.getParameter("search_str")
			.getBytes("iso8859-1"), "utf-8");
	String searchSelect = new String(request.getParameter(
			"searchSelect").getBytes("iso8859-1"), "utf-8");
	String username = (String) session.getAttribute("username");

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css0623/recommendation.css\"/>\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css0623/pagination.css\" rel=\"stylesheet\">\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/include/head.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script charset=\"utf-8\" type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t$(\"#turnBg li[id=choose1]\").attr(\"class\",\"addBg\");\r\n");
      out.write("\t$(\"#searchSelect\").val(\"");
      out.print(searchSelect);
      out.write("\");\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#turnBg li\").each(function(){\r\n");
      out.write("\t\t$(this).click(function(){\r\n");
      out.write("\t\t$(this).siblings(\".addBg\").removeClass(\"addBg\");\r\n");
      out.write("\t\t$(this).attr(\"class\",\"addBg\");\r\n");
      out.write("\t\t$(\"#searchSelect\").val($(this).attr(\"value\"));\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#expert_recommendBtn\").click(function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t$(\"#expert_recommend\").attr(\"href\",\"expert_recommendation?search_str=\" + $('#search_str').val()+\"&searchSelect=\"+$('#searchSelect').val());\r\n");
      out.write("\t\t\tdocument.getElementById(\"expert_recommend\").click();\r\n");
      out.write("\t\t  \r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function myreset() {\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"#sleepQuestion\")[0].reset();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".input_text {\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\twidth: 80px;\r\n");
      out.write("\tborder-color: #000000;\r\n");
      out.write("\tborder-style: solid;\r\n");
      out.write("\tborder-top-width: 0px;\r\n");
      out.write("\tborder-right-width: 0px;\r\n");
      out.write("\tborder-bottom-width: 1px;\r\n");
      out.write("\tborder-left-width: 0px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<title>智能咨询</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!--顶部背景-->\r\n");
      out.write("\t<div class=\"topCon\">\r\n");
      out.write("\t\t<img class=\"bg-01\" src=\"imgs/bg-01.jpg\"/>\r\n");
      out.write("\t\t<span class=\"headerBg\"></span>\r\n");
      out.write("\t\t<!--内容-->\r\n");
      out.write("\t\t<div class=\"indexCon\">\r\n");
      out.write("\t\t<a href=\"welcome\"><img class=\"logo\" src=\"imgs/logo.png\"/></a>\r\n");
      out.write("\t\t\t<p class=\"callCen\">\r\n");
      out.write("\t\t\t\t<a href=\"welcome\">颐健通</a>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<ul>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/include/topbar.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!--切换-->\r\n");
      out.write("\t\t<div class=\"indexFind\">\r\n");
      out.write("\t\t\t<ul id=\"turnBg\">\r\n");
      out.write("\t\t\t\t<li id=\"choose1\" value=\"qiuyi\">\r\n");
      out.write("\t\t\t\t\t<div id=\"choose1\" class=\"con\">\r\n");
      out.write("\t\t\t\t\t\t<img id=\"choose1\" class=\"top\" src=\"imgs/nav_braceTop.png\"/>\r\n");
      out.write("\t\t\t\t\t\t<span id=\"choose1\">求医</span>\r\n");
      out.write("\t\t\t\t\t\t<img  id=\"choose1\" class=\"bottom\" src=\"imgs/nav_bracebottom.png\"/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li id=\"choose2\" value=\"wenyao\">\r\n");
      out.write("\t\t\t\t\t<div class=\"con\" id=\"choose2\">\r\n");
      out.write("\t\t\t\t\t\t<img id=\"choose2\" class=\"top\" src=\"imgs/nav_braceTop.png\"/>\r\n");
      out.write("\t\t\t\t\t\t<span id=\"choose2\">问药</span>\r\n");
      out.write("\t\t\t\t\t\t<img id=\"choose2\" class=\"bottom\" src=\"imgs/nav_bracebottom.png\"/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li id=\"choose3\" value=\"yangsheng\">\r\n");
      out.write("\t\t\t\t\t<div id=\"choose3\" class=\"con\" >\r\n");
      out.write("\t\t\t\t\t\t<img id=\"choose3\" class=\"top\" src=\"imgs/nav_braceTop.png\"/>\r\n");
      out.write("\t\t\t\t\t\t<span id=\"choose3\">养生</span>\r\n");
      out.write("\t\t\t\t\t\t<img id=\"choose3\" class=\"bottom\" src=\"imgs/nav_bracebottom.png\"/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!--搜索-->\r\n");
      out.write("\t\t<form  method=\"get\" id=\"searchIn\">\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"search_str\" id=\"search_str\" value=\"");
      out.print(search_str);
      out.write("\"/>\r\n");
      out.write("\t\t\t<input type=\"hidden\" name =\"searchSelect\" value=\"qiuyi\" id=\"searchSelect\"/>\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"搜索\"/>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!--选药-->\r\n");
      out.write("\t<div class=\"chooseMidi\">\r\n");
      out.write("\t\t<ul class=\"midiTab\">\r\n");
      out.write("\t\t\t<li id=\"intelligenBtn\" class=\"addBg\">\r\n");
      out.write("\t\t\t\t<div class=\"con\">\r\n");
      out.write("\t\t\t\t\t<span class=\"left\">智能</span>\r\n");
      out.write("\t\t\t\t\t<span class=\"right\">咨询</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<a  id=\"expert_recommend\" style=\"display: none\"></a>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li id=\"expert_recommendBtn\" >\r\n");
      out.write("\t\t\t\t<div class=\"con\">\r\n");
      out.write("\t\t\t\t  <span class=\"left\">专家</span>\r\n");
      out.write("\t\t\t\t  <span class=\"right\">推荐</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<br/><br/>\r\n");
      out.write("\t<div class=\"one\">\r\n");
      out.write("\t\t<div id=\"contleft\" align=\"center\">\r\n");
      out.write("\t\t\t<img src=\"imgs/midiTopPic.png\" style=\"margin:-60px 0 0 40px\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div style=\"margin-left:450px; \" >\r\n");
      out.write("\t\t\t<div id=\"tab_mo_1\" style=\"width:600px;\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<form method=\"get\" id=sleepQuestion>\r\n");
      out.write("\t\t\t\t\t<br /><br />\r\n");
      out.write("\t\t\t\t\t\t<p>下面一些问题是关于您最近1个月的睡眠情况，请您按实际情况选择或填写最符合您近1个月实际情况的答案：</p><br />\r\n");
      out.write("\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t⒈近1个月，晚上上床睡觉通常<input type=\"text\" class=\"input_text\" />&nbsp;点钟。<br /><br />\r\n");
      out.write("\t\t\t\t\t\t\t⒉近1个月，从上床到入睡通常需要<input type=\"text\" class=\"input_text\" />&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t分钟。<br /> <br />\r\n");
      out.write("\t\t\t\t\t\t\t⒊近1个月，通常早上<input type=\"text\" class=\"input_text\" />&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t点起床。<br /> <br />\r\n");
      out.write("\t\t\t\t\t\t\t⒋近1个月，每夜通常实际睡眠<input type=\"text\" class=\"input_text\" />&nbsp;小时（不等于卧床时间）。<br /><br />\r\n");
      out.write("\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t<div style=\"margin-left:60px\">\r\n");
      out.write("\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:void(0)\"><img\r\n");
      out.write("\t\t\t\t\t\tsrc=\"image/largebutton_clear.png\" onclick=\"myreset();\" /> </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a\r\n");
      out.write("\t\t\t\t\t\thref=\"intelligent_query2?search_str=");
      out.print(search_str);
      out.write("&searchSelect=");
      out.print(searchSelect);
      out.write("\"><img\r\n");
      out.write("\t\t\t\t\t\tsrc=\"image/largebutton_next.png\" /> </a>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<br /><br /><br /><br />\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"margin-right: 70px;\">\r\n");
      out.write("\t\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/bottom/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"tab_mo_2\" style=\"display:none;\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/include/login.jsp", out, false);
      out.write("\r\n");
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
