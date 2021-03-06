package org.apache.jsp.WEB_002dINF.memb.yangsheng;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class RegimenDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  String regiId=new String(request.getParameter("regiId").getBytes("iso8859-1"),"utf-8");
  
  String IEorNot=(String)session.getAttribute("IEorNot");
  String search_str="";
  if(("1").equals(IEorNot)){   //IE浏览器情况，转码方式不同
	   search_str=new String(request.getParameter("search_strD").getBytes("iso8859-1"),"gb2312");
  }else{
	   search_str=new String(request.getParameter("search_strD").getBytes("iso8859-1"),"utf-8");
  }
  String searchSelect = "yangsheng";

      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../include/core_head.jsp", out, false);
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css0623/MedicineDetail.css\" />\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/include/head.jsp", out, false);
      out.write("\r\n");
      out.write("<script charset=\"utf-8\" type=\"text/javascript\">\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("$(\"#turnBg li\").removeClass(\"addBg\");\r\n");
      out.write("$(\"#turnBg li[id=choose3]\").attr(\"class\",\"addBg\");\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#turnBg li\").each(function(){\r\n");
      out.write("\t$(this).click(function(){\r\n");
      out.write("\t$(this).siblings(\".addBg\").removeClass(\"addBg\");\r\n");
      out.write("\t$(this).attr(\"class\",\"addBg\");\r\n");
      out.write("\t$(\"#searchSelect\").val($(this).attr(\"value\"));\r\n");
      out.write("\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("    //搜索类型为医生时\r\n");
      out.write("\tif(\"");
      out.print(regiId);
      out.write("\"!=\"\"){\r\n");
      out.write("\t\tsearch_regimen();\r\n");
      out.write("\t}\r\n");
      out.write("    \r\n");
      out.write("\t$(\".experts a\").click(function () {\r\n");
      out.write("\t\tif($(this).attr(\"id\")==\"expert_recommendBtn\"){\r\n");
      out.write("\t\t\t$(this).attr(\"href\",\"regimenExpert_recommend?search_str=\" + $('#search_str').val()+\"&searchSelect=\"+$('#searchSelect').val());\r\n");
      out.write("\t\t\tdocument.getElementById($(this).attr(\"expert_recommendBtn\")).click();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("function search_regimen(){\r\n");
      out.write("  $.ajax({\r\n");
      out.write("\turl : '");
      out.print(templateUrl);
      out.write("/RegimenDetailAction?regiId=");
      out.print(regiId);
      out.write("',\r\n");
      out.write("\ttype : 'get',\r\n");
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
      out.write("\t    alert(\"请刷新页面\");\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction conFunction() {\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction succFunction(data) {\r\n");
      out.write("\t\t\r\n");
      out.write("\t    //alert(data.type);     //养生品类型！！！！\r\n");
      out.write("\t    if(data.type==\"healFood\"){\r\n");
      out.write("\t    \t var name=data.name;\r\n");
      out.write("\t\t     var Yfunction=data.Yfunction;\r\n");
      out.write("\t\t     $('#objectName').html(name);\r\n");
      out.write("\t\t     $('#name1').html(\"[保健食品名]\");\r\n");
      out.write("\t\t     $('#content1').html(name);\r\n");
      out.write("\t\t     $('#name2').html(\"[保健食品原料]\");\r\n");
      out.write("\t\t     $('#content2').html(data.ingredient);\r\n");
      out.write("\t\t     $('#name3').html(\"[主治功效]\");\r\n");
      out.write("\t\t     $('#content3').html(Yfunction);\r\n");
      out.write("\t\t     $('#name4').html(\"[食用方法]\");\r\n");
      out.write("\t\t     $('#content4').html(data.usage);\r\n");
      out.write("\t\t     $('#name4').html(\"[注意事项]\");\r\n");
      out.write("\t\t     $('#content4').html(data.precaution);\r\n");
      out.write("\t     }\r\n");
      out.write("\t    if(data.type==\"regiComp\"){\r\n");
      out.write("\t    \t var name=data.name;\r\n");
      out.write("\t\t     var Yfunction=data.Yfunction;\r\n");
      out.write("\t\t     $('#objectName').html(name);\r\n");
      out.write("\t\t     $('#name1').html(\"[保健食品名]\");\r\n");
      out.write("\t\t     $('#content1').html(name);\r\n");
      out.write("\t\t     $('#name2').html(\"[养生复方原料]\");\r\n");
      out.write("\t\t     $('#content2').html(data.ingredient);\r\n");
      out.write("\t\t     $('#name3').html(\"[主治功效]\");\r\n");
      out.write("\t\t     $('#content3').html(Yfunction);\r\n");
      out.write("\t\t     $('#name4').html(\"[食用方法]\");\r\n");
      out.write("\t\t     $('#content4').html(data.usage);\r\n");
      out.write("\t\t     $('#name4').html(\"[注意事项]\");\r\n");
      out.write("\t\t     $('#content4').html(data.precaution);\r\n");
      out.write("\t\t    \r\n");
      out.write("\t     } if(data.type==\"mediBath\"){\r\n");
      out.write("\t    \t var name=data.name;\r\n");
      out.write("\t\t     var Yfunction=data.Yfunction;\r\n");
      out.write("\t\t     $('#objectName').html(name);\r\n");
      out.write("\t\t     $('#name1').html(\"[保健食品名]\");\r\n");
      out.write("\t\t     $('#content1').html(name);\r\n");
      out.write("\t\t     $('#name2').html(\"[中药浴方成份]\");\r\n");
      out.write("\t\t     $('#content2').html(data.ingredient);\r\n");
      out.write("\t\t     $('#name3').html(\"[主治功效]\");\r\n");
      out.write("\t\t     $('#content3').html(Yfunction);\r\n");
      out.write("\t\t     $('#name4').html(\"[操作方法]\");\r\n");
      out.write("\t\t     $('#content4').html(data.usage);\r\n");
      out.write("\t\t     $('#name4').html(\"[注意事项]\");\r\n");
      out.write("\t\t     $('#content4').html(data.precaution);\r\n");
      out.write("\t\t     \r\n");
      out.write("\t     } if(data.type==\"massPres\"){\r\n");
      out.write("\t    \t var name=data.name;\r\n");
      out.write("\t\t     var Yfunction=data.Yfunction;\r\n");
      out.write("\t\t     $('#objectName').html(name);\r\n");
      out.write("\t\t     $('#name1').html(\"[保健食品名]\");\r\n");
      out.write("\t\t     $('#content1').html(name);\r\n");
      out.write("\t\t     $('#name2').html(\"\");\r\n");
      out.write("\t\t     $('#content2').html('');\r\n");
      out.write("\t\t     $('#name3').html(\"[功效]\");\r\n");
      out.write("\t\t     $('#content3').html(Yfunction);\r\n");
      out.write("\t\t     $('#name4').html(\"[操作方法]\");\r\n");
      out.write("\t\t     $('#content4').html(data.usage);\r\n");
      out.write("\t\t     $('#name4').html(\"[注意事项]\");\r\n");
      out.write("\t\t     $('#content4').html(data.precaution);\r\n");
      out.write("\t\t     \r\n");
      out.write("\t     } if(data.type==\"mediEqui\"){\r\n");
      out.write("\t    \t var name=data.name;\r\n");
      out.write("\t\t     var Yfunction=data.Yfunction;\r\n");
      out.write("\t\t     $('#objectName').html(name);\r\n");
      out.write("\t\t     $('#name1').html(\"[保健食品名]\");\r\n");
      out.write("\t\t     $('#content1').html(name);\r\n");
      out.write("\t\t     $('#name2').html(\"\");\r\n");
      out.write("\t\t     $('#content2').html('');\r\n");
      out.write("\t\t     $('#name3').html(\"[功效]\");\r\n");
      out.write("\t\t     $('#content3').html(Yfunction);\r\n");
      out.write("\t\t     $('#name4').html(\"[使用说明]\");\r\n");
      out.write("\t\t     $('#content4').html(data.usage);\r\n");
      out.write("\t\t     $('#name4').html(\"[产品描述]\");\r\n");
      out.write("\t\t     $('#content4').html(data.description);\r\n");
      out.write("\t\t    \r\n");
      out.write("\t     }if(data.type==\"0\"){\r\n");
      out.write("\t    \t $(\"#regimen\").html('<h3>暂无此类保健品</h3>'); \r\n");
      out.write("\t     }\r\n");
      out.write("\t    \r\n");
      out.write("    }    \r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<title>养生品详细信息</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<!--顶部背景-->\r\n");
      out.write("\t<div class=\"topCon\">\r\n");
      out.write("\t\t<img class=\"bg-01\" src=\"imgs/bg-01.jpg\"/>\r\n");
      out.write("\t\t<span class=\"headerBg\"></span>\r\n");
      out.write("\t\t<!--内容-->\r\n");
      out.write("\t\t<div class=\"indexCon\">\r\n");
      out.write("\t\t\t<a href=\"welcome\"><img class=\"logo\" src=\"imgs/logo.png\"/></a>\r\n");
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
      out.write("\t\t\t\t\t<div id=\"choose3\" class=\"con\">\r\n");
      out.write("\t\t\t\t\t\t<img id=\"choose3\" class=\"top\" src=\"imgs/nav_braceTop.png\"/>\r\n");
      out.write("\t\t\t\t\t\t<span id=\"choose3\">养生</span>\r\n");
      out.write("\t\t\t\t\t\t<img id=\"choose3\" class=\"bottom\" src=\"imgs/nav_bracebottom.png\"/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!--搜索-->\r\n");
      out.write("\t\t<form  method=\"get\" id=\"searchIn\">\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"search_str\" id=\"search_str\" value=\"");
      out.print(search_str);
      out.write("\"/>\r\n");
      out.write("\t\t\t<input type=\"hidden\" name = \"searchSelect\" value=\"yangsheng\" id=\"searchSelect\"/>\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"搜索\"/>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!--病症-->\r\n");
      out.write("\t<div class=\"pain\">\r\n");
      out.write("\t\t<div class=\"painCon5\">\r\n");
      out.write("\t\t\t<p class=\"painName\" id=\"objectName\"></p>\r\n");
      out.write("\t\t\t<p class=\"painShort\" id=\"name1\"></p>\r\n");
      out.write("\t\t\t<div class=\"painShortCon_5\">\r\n");
      out.write("\t\t\t<p  id=\"content1\"></p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<p class=\"painNormal\" id=\"name2\"></p>\r\n");
      out.write("\t\t\t<div class=\"painShortCon_5\" >\r\n");
      out.write("\t\t\t<p id=\"content2\"></p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<p class=\"painNormal\" id=\"name3\"></p>\r\n");
      out.write("\t\t\t<div class=\"painNormalCon_5\" >\r\n");
      out.write("\t\t\t<p id=\"content3\"></p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<p class=\"painLong\" id=\"name4\"></p>\r\n");
      out.write("\t\t\t<div class=\"painLongCon_5\">\r\n");
      out.write("\t\t\t<p  id=\"content4\"></p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!--专家栏-->\r\n");
      out.write("\t\t\t<div class=\"experts\">\r\n");
      out.write("\t\t\t\t<a href=\"javascript:void(0)\" onclick=\"alert('暂不提供智能咨询')\">智能咨询</a>\r\n");
      out.write("\t\t\t\t<a id=\"expert_recommendBtn\" style=\"margin-right:0px;\">专家推荐</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"text-align:center\">\r\n");
      out.write("\t\t<div>颐健通项目研发小组</div>\r\n");
      out.write("\t\t<div>&#169;版权所有 &nbsp;2015-2016</div>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!--查询信息-->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/include/login.jsp", out, false);
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
