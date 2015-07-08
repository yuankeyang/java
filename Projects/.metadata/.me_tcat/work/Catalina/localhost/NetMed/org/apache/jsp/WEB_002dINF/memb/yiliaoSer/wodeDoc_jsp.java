package org.apache.jsp.WEB_002dINF.memb.yiliaoSer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;

public final class wodeDoc_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../include/core_head.jsp", out, false);
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/article.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/membcss/wodeDoc.css\" />\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("    $(document).ready(function () {\r\n");
      out.write("        $(\"#tabs li\").bind(\"click\", function () {\r\n");
      out.write("            var index = $(this).index();\r\n");
      out.write("            var divs = $(\"#tabs-body > div\");\r\n");
      out.write("            $(this).parent().children(\"li\").attr(\"class\", \"tab-nav\");//将所有选项置为未选中\r\n");
      out.write("            $(this).attr(\"class\", \"tab-nav-action\"); //设置当前选中项为选中样式\r\n");
      out.write("            divs.hide();//隐藏所有选中项内容\r\n");
      out.write("            divs.eq(index).show(); //显示选中项对应内容\r\n");
      out.write("        });\r\n");
      out.write("        getMyDoc();\r\n");
      out.write("        $(\".hudong\").each(function(index){\r\n");
      out.write("        \t  $(this).find(\"a\").click(function(){\r\n");
      out.write("        \t      $(this).next(\"ul\").toggle();\r\n");
      out.write("\t\t   });\r\n");
      out.write("        });\r\n");
      out.write("        \r\n");
      out.write("    });\r\n");
      out.write("    function getMyDoc(){\r\n");
      out.write("  \t    $.ajax({\r\n");
      out.write("  \t        url : '");
      out.print(templateUrl);
      out.write("/user/allDoctor',\r\n");
      out.write("  \t\t\ttype : 'POST',\r\n");
      out.write("  \t\t\tcontentType: \"application/x-www-form-urlencoded; charset=utf-8\", \r\n");
      out.write("  \t\t\tdataType : 'json',\r\n");
      out.write("  \t\t\ttimeout : 20000,\r\n");
      out.write("  \t\t\tcache : true,\r\n");
      out.write("  \t\t\terror : erryFunction, //错误执行方法  \r\n");
      out.write("  \t\t\tsuccess : succFunction\r\n");
      out.write("  \t\t//成功执行方法  \r\n");
      out.write("  \t\t});\r\n");
      out.write("  \t\tfunction erryFunction() {\r\n");
      out.write("  \t\t\talert(\"正在获取互动专家，请耐心等待\");\r\n");
      out.write("  \t\t}\r\n");
      out.write("  \t\tfunction succFunction(data) {\r\n");
      out.write("  \t\t\tvar dataNum = [data.yishiNum, data.yaoshiNum, data.anmoNum,data.xinliNum,data.jiankangNum,data.yingyangNum]; \r\n");
      out.write("  \t\t\tvar dataDetail = [data.yishi, data.yaoshi, data.anmo,data.xinli,data.jiankang,data.yingyang];\r\n");
      out.write("  \t\t\t$(\".hudong\").each(function(i){\r\n");
      out.write("  \t\t\t\t//alert(i);\r\n");
      out.write("  \t\t\t\t$(this).find(\"a\").html($(this).find(\"a\").html()+\"(\"+dataNum[i]+\")\");\r\n");
      out.write("  \t\t\t\tvar list = $(this).find(\"ul\");\r\n");
      out.write("  \t\t\t\tif(parseInt(dataNum[i])!=0){\r\n");
      out.write("  \t\t\t\t\tvar dataI = dataDetail[i];\r\n");
      out.write("  \t\t\t\t\t//alert(dataI[0].expertName);\r\n");
      out.write("\t  \t\t\t\t $.each(dataI,function(index) {\r\n");
      out.write("\t  \t\t\t\t\tlist.append(\"<li><a  href='getExpeDetail?expe_id=\"+dataI[index].expe_id+\"'>\"+ dataI[index].expertName+ \"</a>,擅长：\"+ dataI[index].instroduction+ \"</li>\");\r\n");
      out.write("\t  \t\t\t\t });\r\n");
      out.write("\t  \t\t\t\t list.show();\r\n");
      out.write("  \t\t\t\t}else{\r\n");
      out.write("  \t\t\t\t\tlist.append(\"<li>暂时还没有和相关专家互动！！</li>\");\r\n");
      out.write("  \t\t\t\t}\r\n");
      out.write("  \t\t\t});\r\n");
      out.write("  \t\t\t\r\n");
      out.write("  \t\t\t //收藏\r\n");
      out.write("  \t\t\tif(parseInt(data.colectNum)!=0){\r\n");
      out.write("\t  \t\t    $.each(data.colectArray,function(index) {//target=\\\"_blank\\\"\r\n");
      out.write("\t\t  \t\t\t$(\"#colect\").append(\"<li><a  href='getExpeDetail?expe_id=\"+data.colectArray[index].expe_id+\"'>\"+ data.colectArray[index].expertName+ \"</a>,擅长：\"+ data.colectArray[index].introduction+ \"</li>\");\r\n");
      out.write("\t\t  \t\t});\r\n");
      out.write("  \t\t\t}else{\r\n");
      out.write("  \t\t\t\t$(\"#colect\").append(\"<li>你还没有收藏任何专家！！！赶快去收藏吧</li>\");\r\n");
      out.write("  \t\t\t}\r\n");
      out.write("  \t\t}\r\n");
      out.write("  \t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"font-family:Times New Roman;font-size: 14pt\">\r\n");
      out.write("\t<div class=\"tabs\">\r\n");
      out.write("\t\t<ul id=\"tabs\">\r\n");
      out.write("\t\t\t<li class=\"tab-nav-action\">收藏的专家</li>\r\n");
      out.write("\t\t\t<li class=\"tab-nav\">互动的专家</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"tabs-body\" class=\"tabs-body\" >\r\n");
      out.write("\t\t<div id=\"tab1\" style=\"display:block\">\r\n");
      out.write("\t\t     <ul id=\"colect\"></ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div style=\"display:none;\" id=\"tab2\">\r\n");
      out.write("\t\t <div class=\"hudong\">\r\n");
      out.write("\t\t   <a id=\"recAIDYD\" href=\"javascript:void(0)\">医师</a>\r\n");
      out.write("\t\t   <ul id=\"yishi\" style=\"display: none;margin-bottom: 0px\"></ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"hudong\" >\r\n");
      out.write("\t\t   <a id=\"recAIDYD\" href=\"javascript:void(0)\">药师</a>\r\n");
      out.write("\t\t   <ul id=\"yaoshi\" style=\"display: none;margin-bottom: 0px\"></ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"hudong\">\r\n");
      out.write("\t\t   <a id=\"recAIDYD\" href=\"javascript:void(0)\">按摩理疗师</a>\r\n");
      out.write("\t\t   <ul id=\"anmo\" style=\"display: none;margin-bottom: 0px\"></ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"hudong\">\r\n");
      out.write("\t\t   <a id=\"recAIDYD\" href=\"javascript:void(0)\">心理咨询师</a>\r\n");
      out.write("\t\t   <ul id=\"xinli\" style=\"display: none;margin-bottom: 0px\"></ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"hudong\">\r\n");
      out.write("\t\t   <a id=\"recAIDYD\" href=\"javascript:void(0)\">健康管理师</a>\r\n");
      out.write("\t\t   <ul id=\"jiankang\" style=\"display: none;margin-bottom: 0px\"></ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"hudong\">\r\n");
      out.write("\t\t   <a id=\"recAIDYD\" href=\"javascript:void(0)\">营养师</a>\r\n");
      out.write("\t\t   <ul id=\"yingyang\" style=\"display: none;margin-bottom: 0px\"></ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>");
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
