package org.apache.jsp.WEB_002dINF.memb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class MediKnowDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

String templateUrl = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath();
request.setAttribute("url", templateUrl);
//String search_str=request.getParameter("search_str");
String search_str=new String(request.getParameter("search_str").getBytes("iso8859-1"),"utf-8");
String searchSelect = request.getParameter("searchSelect");

      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/core_head.jsp", out, false);
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/topbarhead.jsp", out, false);
      out.write("\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/bootstrap.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/view/css/doctor.css\" rel=\"stylesheet\" />\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/pagination.css\" rel=\"stylesheet\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/main.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/js.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.pagination.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script charset=\"utf-8\" type=\"text/javascript\">\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("    //搜索类型为医生时\r\n");
      out.write("\tif(\"");
      out.print(search_str);
      out.write("\"!=\"\"&&\"");
      out.print(searchSelect);
      out.write("\"==\"qiuyi\"){\r\n");
      out.write("\t\tsearch_doctor();\r\n");
      out.write("\t}\r\n");
      out.write("});\r\n");
      out.write("function search_doctor(){\r\n");
      out.write("  $.ajax({\r\n");
      out.write("\t  url : '");
      out.print(templateUrl);
      out.write("/MediKnowServletAction?search_str=");
      out.print(search_str);
      out.write("',\r\n");
      out.write("\t  type : 'POST',\r\n");
      out.write("    // data:\"search_str=\"+encodeURI(\"<//%=search_str%>\"),//传参编码问题\r\n");
      out.write("//     contentType: \"application/x-www-form-urlencoded; charset=utf-8\", \r\n");
      out.write("\tdataType : 'json',\r\n");
      out.write("\ttimeout : 20000,\r\n");
      out.write("\tcache : true,\r\n");
      out.write("\tbeforeSend : LoadFunction, //加载执行方法  \r\n");
      out.write("\terror : erryFunction, //错误执行方法  \r\n");
      out.write("\tcomplete : conFunction,\r\n");
      out.write("\tsuccess : succFunction\r\n");
      out.write("\t\t\t//成功执行方法  \r\n");
      out.write("\t});\r\n");
      out.write("\tfunction LoadFunction() {\r\n");
      out.write("\t   // alert(\"dfdfd\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// $(\".pager\").hide();\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction erryFunction() {\r\n");
      out.write("\t    alert(\"error\");\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction conFunction() {\r\n");
      out.write("\t\t// $(\".pager\").show();\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction succFunction(data) {\r\n");
      out.write("\t   // alert(data);\r\n");
      out.write("\t   //$(\"#mediknowcont\").html(\"sdsds\");\r\n");
      out.write("\t\t\t  //alert(data.nullInfo);\r\n");
      out.write("\t   $(\"#mediknowcont\").html(\"<p>   \"+data.mediknow[0].knowCont+\"</p>\");\r\n");
      out.write("    }    \r\n");
      out.write("// \t\t\t  $.each(data.knowidArray, function(index) {\t\t\r\n");
      out.write("// \t\t\t\t $(\"#mediknowcont\").html($(\"#mediknowcont\").html()+\"<p>\"+data.knowidArray[index].knowCont+\"</p><br>\");\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("// \t\t\t\t});\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<title>医学解释</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/topbar.jsp", out, false);
      out.write("\r\n");
      out.write("\t<div class=\"clear\"></div>\r\n");
      out.write("\t<!--中上部分-->\r\n");
      out.write("\t<div id=\"middle\">\r\n");
      out.write("\t\t<!--左端logo-->\r\n");
      out.write("\t\t<div id=\"leftMid\">\r\n");
      out.write("\t\t\t<img src=\"image/logo.png\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!--左端logo-->\r\n");
      out.write("\t\t<!--右端输入框-->\r\n");
      out.write("\t\t<div id=\"rightMid\">\r\n");
      out.write("\t\t\t<form method=\"get\" id=\"searchForm\">\r\n");
      out.write("\t\t\t\t<br /> <input type=\"radio\" checked=\"checked\" name=\"searchSelect\"\r\n");
      out.write("\t\t\t\t\tvalue=\"qiuyi\" /> <label>求医</label> <input type=\"radio\"\r\n");
      out.write("\t\t\t\t\tname=\"searchSelect\" value=\"wenyao\" /> <label>问药</label> <input\r\n");
      out.write("\t\t\t\t\ttype=\"radio\" name=\"searchSelect\" value=\"yangsheng\" /> <label>养生</label>\r\n");
      out.write("\t\t\t\t<!--搜索-->\r\n");
      out.write("\t\t\t\t<br /> <br />\r\n");
      out.write("\t\t\t\t<div id=\"searchIn\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"search_str\" id=\"search_str\" maxlength=200\r\n");
      out.write("\t\t\t\t\t\tvalue=\"");
      out.print(search_str);
      out.write("\" /> <a href=\"javascript:void(0)\"> <img\r\n");
      out.write("\t\t\t\t\t\tsrc=\"image/normalbutton_a.png\" /> </a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<input style=\"display:none\" />\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!--右端输入框-->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!--中上部分-->\r\n");
      out.write("\r\n");
      out.write("\t<!--询问框-->\r\n");
      out.write("\t<div id=\"checkInfo\">\r\n");
      out.write("\t\t<h2>\r\n");
      out.write("\t\t\t您是不是要找&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\">");
      out.print(search_str);
      out.write("</a>\r\n");
      out.write("\t\t</h2>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!--询问框-->\r\n");
      out.write("\r\n");
      out.write("\t<!--查询信息-->\r\n");
      out.write("\t<div id=\"searchInfo\">\r\n");
      out.write("\t\t<!--left-->\r\n");
      out.write("\t\t<div id=\"leftSearchInfo\">\r\n");
      out.write("\t\t\t<h1>");
      out.print(search_str);
      out.write("</h1>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"container\"  >\r\n");
      out.write("\t\t\t <div id=\"mediknowcont\" style=\"width:80%;padding-right: 30px\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!--     <p id=\"mediknowcont\"></p>        搜索结果的详细内容，医学解释  -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div id=\"buttongrp\">\r\n");
      out.write("\t\t\t<div style=\"float: left;\">\r\n");
      out.write("\t\t\t\t<!--智能查询-->\r\n");
      out.write("\t\t\t\t<form action=\"intelligent_query\" id=\"intelligent_query_form\" method=\"get\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"search_str\" id=\"search_str\" value=\"");
      out.print(search_str);
      out.write("\" />\r\n");
      out.write("                    <input type=\"hidden\" name=\"searchSelect\" id=\"searchSelect\" value=\"");
      out.print(searchSelect);
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t<input type=\"image\" src=\"image/largebutton_a.png\" />\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"float: right;\">\r\n");
      out.write("\t\t\t\t<form action=\"expert_recommendation\" id=\"expert_recommendation_form\"\r\n");
      out.write("\t\t\t\t\tmethod=\"get\">\r\n");
      out.write("\t\t\t\t\t<!--专家推荐-->\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" style=\"display: none\" name=\"search_str\"\tvalue=\"");
      out.print(search_str);
      out.write("\" />\r\n");
      out.write("\t\t\t\t    <input type=\"hidden\" name=\"searchSelect\" id=\"searchSelect\" value=\"");
      out.print(searchSelect);
      out.write("\" /> \r\n");
      out.write("\t\t\t\t\t\t<input type=\"image\"\r\n");
      out.write("\t\t\t\t\t\tsrc=\"image/largebutton_b.png\" />\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("            </div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<!--right-->\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!--查询信息-->\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/bottom/footer.jsp", out, false);
      out.write("\r\n");
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
