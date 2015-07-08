package org.apache.jsp.WEB_002dINF.memb.qiuyi;

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
String search_str=new String(request.getParameter("search_str").getBytes("iso8859-1"),"utf-8");
String searchSelect ="qiuyi";

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/include/head.jsp", out, false);
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css0623/mediKnowDetail.css\"/>\r\n");
      out.write("<script charset=\"utf-8\" type=\"text/javascript\">\r\n");
      out.write("var mediName;\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("    //搜索类型为医生时\r\n");
      out.write("\tif(\"");
      out.print(search_str);
      out.write("\"!=\"\"&&\"");
      out.print(searchSelect);
      out.write("\"==\"qiuyi\"){\r\n");
      out.write("\t\tsearch_doctor();\r\n");
      out.write("\t\t$(\"#turnBg li[id=choose1]\").attr(\"class\",\"addBg\");\r\n");
      out.write("\t\t$(\"#searchSelect\").val(\"");
      out.print(searchSelect);
      out.write("\");\r\n");
      out.write("\t}\r\n");
      out.write("    \r\n");
      out.write("\t$(\"#turnBg li\").each(function(){\r\n");
      out.write("\t\t$(this).click(function(){\r\n");
      out.write("\t\t$(this).siblings(\".addBg\").removeClass(\"addBg\");\r\n");
      out.write("\t\t$(this).attr(\"class\",\"addBg\");\r\n");
      out.write("\t\t$(\"#searchSelect\").val($(this).attr(\"value\"));\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t$(\"#searchIn\").find(\"input[type=button]\").click(function(){\r\n");
      out.write("\t\tvar item=$(\"#turnBg .addBg\").attr(\"value\");\r\n");
      out.write("\t\tif(item==\"qiuyi\"){\r\n");
      out.write("\t\t\t$('#searchIn').attr('action','MediKnow');\r\n");
      out.write("\t\t}else if(item==\"wenyao\"){\r\n");
      out.write("\t\t\t$('#searchIn').attr('action','SearchMedicine');\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t$('#searchIn').attr('action','SearchRegimen');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif($('#search_str').val()=='')\r\n");
      out.write("\t\t\talert('请输入搜索词条！');\r\n");
      out.write("\t\telse{\r\n");
      out.write("\t\t$('#searchIn').submit();}\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\".experts a\").click(function () {\r\n");
      out.write("\t\t//alert($(this).attr(\"id\"));\r\n");
      out.write("\t\tif($(this).attr(\"id\")==\"intelligenBtn\"){\r\n");
      out.write("\t\t\tif($('#system_hit1').val()==\"失眠\")\r\n");
      out.write("\t\t\t  $(this).attr(\"href\",\"intelligent_query?search_str=\" + $('#system_hit1').val()+\"&searchSelect=\"+$('#searchSelect').val());\r\n");
      out.write("\t\t\telse{\r\n");
      out.write("\t\t\t  alert('目前只能咨询失眠');\r\n");
      out.write("\t\t\t  return;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}else {\r\n");
      out.write("\t\t\t$(this).attr(\"href\",\"expert_recommendation?search_str=\" + $('#system_hit1').val()+\"&searchSelect=\"+$('#searchSelect').val());\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdocument.getElementById($(this).attr(\"id\")).click();\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function search_doctor(){\r\n");
      out.write("  $.ajax({\r\n");
      out.write("     url : '");
      out.print(templateUrl);
      out.write("/MediKnowServletAction',\r\n");
      out.write("\t type : 'POST',\r\n");
      out.write("\t data:\"search_str=\"+$('#search_str').val(),\r\n");
      out.write("\t contentType: \"application/x-www-form-urlencoded; charset=utf-8\", \r\n");
      out.write("\t dataType : 'json',\r\n");
      out.write("\t timeout : 25000,\r\n");
      out.write("\t cache : true,\r\n");
      out.write("\t beforeSend : LoadFunction, //加载执行方法  \r\n");
      out.write("\t error : erryFunction, //错误执行方法  \r\n");
      out.write("\t complete : conFunction,\r\n");
      out.write("\t success : succFunction\r\n");
      out.write("\t\t\t//成功执行方法  \r\n");
      out.write("\t});\r\n");
      out.write("\tfunction LoadFunction() {\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction erryFunction() {\r\n");
      out.write("\t    //alert(\"请等待3秒后刷新页面\");\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction conFunction() {\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction succFunction(data) {\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t if(data.mediSize==0){\r\n");
      out.write("\t\t\t $(\"#nothing\").hide();\r\n");
      out.write("\t\t\t $(\"#system_hit1\").val('");
      out.print(search_str);
      out.write("');\r\n");
      out.write("\t\t\t document.getElementById(\"system_hit2\").innerHTML=document.getElementById(\"search_str\").value;\r\n");
      out.write("\t\t\t $(\"#mediknowcont\").html(\"<p>\"+\"无此名词和相应信息，请重新输入正确词条，谢谢\"+\"</p>\");\r\n");
      out.write("\t\t }else{\r\n");
      out.write("\t\t\t mediName=data.mediknow[0].knowName;\r\n");
      out.write("\t\t\t //$(\"#search_str\").val(mediName);\r\n");
      out.write("\t\t\t document.getElementById(\"system_hit1\").innerHTML=mediName;\r\n");
      out.write("\t\t\t $(\"#system_hit1\").val(mediName);\r\n");
      out.write("\t\t\t document.getElementById(\"system_hit2\").innerHTML=mediName;\r\n");
      out.write("\t\t\t $(\"#mediknowcont\").html(\"<p>\"+data.mediknow[0].knowCont+\"</p>\");\r\n");
      out.write("\t\t }\r\n");
      out.write("    }    \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<title>医学解释</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!--顶部背景-->\r\n");
      out.write("\t<div class=\"topCon\">\r\n");
      out.write("\t\t<img class=\"bg-01\" src=\"imgs/bg-01.jpg\"/>\r\n");
      out.write("\t\t<span class=\"headerBg\"></span>\r\n");
      out.write("\t\t<!--内容-->\r\n");
      out.write("\t\t<div class=\"indexCon\">\r\n");
      out.write("\t\t\t<a href=\"welcome\"><img class=\"logo\" src=\"imgs/logo.png\"/></a>\r\n");
      out.write("\t\t\t<p class=\"callCen\">\r\n");
      out.write("\t\t\t\t健康咨询平台\r\n");
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
      out.write("\t\t\t\t\t<div id=\"choose1\" class=\"con\" >\r\n");
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
      out.write("\t\t\t\t<li id=\"choose3\"  value=\"yangsheng\">\r\n");
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
      out.write("\t\t\t<input type=\"hidden\" name = \"searchSelect\" value=\"qiuyi\" id=\"searchSelect\"/>\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"搜索\"/>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!--病症-->\r\n");
      out.write("\t<div class=\"pain\">\r\n");
      out.write("\t\t<p class=\"isFind\" id=\"nothing\">您是不是要找:[<label id=\"system_hit1\"></label>]</p>\r\n");
      out.write("\t\t<div class=\"painCon\">\r\n");
      out.write("\t\t\t<p class=\"painName\">[<label id=\"system_hit2\"></label>]</p>\r\n");
      out.write("\t\t\t<p class=\"painEx\">[医学词条解释]</p>\r\n");
      out.write("\t\t\t<div class=\"painExCon\" id=\"mediknowcont\"></div>\r\n");
      out.write("\t\t\t<!-- <div class=\"painExCon\">\r\n");
      out.write("\t\t\t\t<p>失眠按原因可划分为原发性和继承性两类</p>\r\n");
      out.write("\t\t\t\t<p class=\"painExConTitle\">1.原发性失眠</p>\r\n");
      out.write("\t\t\t\t<p>通常缺少明确病因，或在排除可能引起失眠的病因后仍遗留失眠症状，主要包括心理生理性失眠、特发性失眠和主观性失眠3种类型。原发性失眠的诊断缺乏特异性指标，主要是一种排除性诊断。当可能引起失眠的病因被排除或治愈以后，仍遗留失眠症状时即可考虑为原发性失眠。心理生理性失眠在临床上发现其病因都可以溯源为某一个或长期事件对患者大脑边缘系统功能稳定性的影响，边缘系统功能的稳定性失衡最终导致了大脑睡眠功能的紊乱，失眠发生。</p>\r\n");
      out.write("\t\t\t\t<p class=\"painExConTitle\">2.继发性失眠</p>\r\n");
      out.write("\t\t\t\t<p>包括由于躯体疾病、精神障碍、药物滥用等引起的失眠，以及与睡眠呼吸紊乱、睡眠运动障碍等相关的失眠。失眠常与其他疾病同时发生，有时很难确定这些疾病与失眠之间的因果关系，故近年来提出共病性失眠的概念，用以描述那些同时伴随其他疾病的失眠。</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<p class=\"painAction\">[临床表现]</p>\r\n");
      out.write("\t\t\t<div class=\"painExCon\">\r\n");
      out.write("\t\t\t\t<p>失眠患者的临床表现主要有以下方面：</p>\r\n");
      out.write("\t\t\t\t<p class=\"painExConTitle\">1.睡眠过程的障碍</p>\r\n");
      out.write("\t\t\t\t<p>入睡困难、睡眠质量下降和睡眠时间减少。</p>\r\n");
      out.write("\t\t\t\t<p class=\"painExConTitle\">2.日间认知功能障碍</p>\r\n");
      out.write("\t\t\t\t<p>记忆功能下降、注意功能下降、计划功能下降从而导致白天困倦，工作能力下降，在停止工作时容易出现日间嗜睡现象。</p>\r\n");
      out.write("\t\t\t\t<p class=\"painExConTitle\">3.大脑边缘系统及其周围的植物神经功能紊乱</p>\r\n");
      out.write("\t\t\t\t<p>心血管系统表现为胸闷、心悸、血压不稳定，周围血管收缩扩展障碍；消化系统表现为便秘或腹泻、胃部闷胀；运动系统表现为颈肩部肌肉紧张、头痛和腰痛。情绪控制能力减低，容易生气或者不开心；男性容易出现阳萎，女性常出现性功能减低等表现。</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<p class=\"painOther\">[就诊科室]<span>精神科</span></p>\r\n");
      out.write("\t\t\t<p class=\"painOther\">[常见病因]<span>大脑睡眠功能紊乱，躯体疾病，精神障碍</span></p>\r\n");
      out.write("\t\t\t<p class=\"painOther\">[常见症状]<span>入睡困难，睡眠质量下降和睡眠时间减少</span></p>\r\n");
      out.write("\t\t\t -->\r\n");
      out.write("\t\t\t<!--专家栏-->\r\n");
      out.write("\t\t\t<div class=\"experts\">\r\n");
      out.write("\t\t\t\t<a id=\"intelligenBtn\" >智能咨询</a>\r\n");
      out.write("\t\t\t\t<a id=\"expert_recommendBtn\" style=\"margin-right:0px;\">专家推荐</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
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
