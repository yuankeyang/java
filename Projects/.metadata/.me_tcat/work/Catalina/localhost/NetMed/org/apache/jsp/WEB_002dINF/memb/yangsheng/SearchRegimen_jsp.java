package org.apache.jsp.WEB_002dINF.memb.yangsheng;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class SearchRegimen_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");

String templateUrl = request.getScheme() + "://"
		+ request.getHeader("host") + request.getContextPath();
request.setAttribute("url", templateUrl);

String search_str = new String(request.getParameter("search_str")
		.getBytes("iso8859-1"), "utf-8");
String searchSelect="yangsheng";

      out.write("\r\n");
      out.write("<!DOCTYPE>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\r\n");
      out.write("<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->\r\n");
      out.write("<title>养生品列表</title>\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css0623/pagination.css\" rel=\"stylesheet\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css0623/recommendation.css\"/>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/include/head.jsp", out, false);
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js0623/jquery.pagination.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script charset=\"utf-8\" type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("document.onkeyup = function (e) { \r\n");
      out.write("\t\r\n");
      out.write("\tvar theEvent = window.event || e; \r\n");
      out.write("\tvar code = theEvent.keyCode || theEvent.which; \r\n");
      out.write("\tif (code == 13) { \r\n");
      out.write("\t\tif($('#search_str').val()==\"\")//  输入为空不能用null，只能用空字符串！！\r\n");
      out.write("\t\t     alert(\"输入不能为空！！！\");\r\n");
      out.write("\t\telse\r\n");
      out.write("\t\t   $('#btn-search').trigger(\"click\");\r\n");
      out.write("\t} \r\n");
      out.write("\t\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t\r\n");
      out.write("\tif(\"");
      out.print(search_str);
      out.write("\"!=\"\"&&\"");
      out.print(searchSelect);
      out.write("\"==\"yangsheng\"){\r\n");
      out.write("\t$(\"#turnBg li\").removeClass(\"addBg\");\r\n");
      out.write("\t\t$(\"#turnBg li[id=choose3]\").attr(\"class\",\"addBg\");\r\n");
      out.write("\t\t$(\"#searchSelect\").val(\"");
      out.print(searchSelect);
      out.write("\");\r\n");
      out.write("\t}\r\n");
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
      out.write("\t$(\".midiTab li\").eq(0).addClass(\"addBg\");\r\n");
      out.write("\t$(\"#healFood_list\").show();\r\n");
      out.write("\t$(\".midiTab li\").each(function(){\r\n");
      out.write("\t\t$(this).click(function(){\r\n");
      out.write("\t\t\t$(this).siblings(\".addBg\").removeClass(\"addBg\");\r\n");
      out.write("\t\t\t$(this).attr(\"class\",\"addBg\");\r\n");
      out.write("\t\t\t$(\"#content .midiCon\").hide();\r\n");
      out.write("\t\t\t$(\"#content .midiCon\").eq($(this).index()).show();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tif(\"");
      out.print(search_str);
      out.write("\"!=\"\"){\r\n");
      out.write("\t\tbind(0);\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write(" \r\n");
      out.write("function pageselectCallback(page_id,jq){\r\n");
      out.write("   bind(page_id);\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("function bind(pageIndex){\r\n");
      out.write("  var total = 0;\r\n");
      out.write("  \r\n");
      out.write("  $.ajax({\r\n");
      out.write("    url : '");
      out.print(templateUrl);
      out.write("/SearchRegimenAction?pageIndex='+(pageIndex+1),\r\n");
      out.write("    type : 'POST',\r\n");
      out.write("    data:\"search_str=\"+$('#search_str').val(),\r\n");
      out.write("\tcontentType: \"application/x-www-form-urlencoded; charset=utf-8\", \r\n");
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
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction erryFunction() {\r\n");
      out.write("\t     alert(\"error\");\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction conFunction() {\r\n");
      out.write("\t\t// $(\".pager\").show();\r\n");
      out.write("\t}\r\n");
      out.write("function succFunction(data) {\r\n");
      out.write("foodtotal = data.typeNumb.Nfood;\r\n");
      out.write("$(\"#healFood_list\").html(\"\");\r\n");
      out.write("$.each(data.healFoodArray, function(index) {\r\n");
      out.write("var picture=data.healFoodArray[index].Picture;\r\n");
      out.write("var s1=\"<li><img src=\\\"");
      out.print(templateUrl);
      out.write("/\"+ picture\r\n");
      out.write("\t\t\t\t+ \"\\\" /><div class=\\\"midiMess\\\"><p class=\\\"midiName\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ data.healFoodArray[index].Name\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"</p>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvar s2 = \"<p class=\\\"midiText\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ data.healFoodArray[index].Function\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"</p></div>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvar st1 =\"<span class=\\\"midiInter\\\"></span>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvar s3 = \"<div class=\\\"midiUse\\\"><p class=\\\"midiUseName\\\">[ 用法用量 ]</p>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+\"<p class=\\\"midiUseText\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ data.healFoodArray[index].Usage\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"</p></div>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvar s4 = \"<div class=\\\"midiUse\\\"><p class=\\\"midiUseName\\\">[ 注意事项 ]</p>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+\"<p class=\\\"midiUseText\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ data.healFoodArray[index].Precaution\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"</p></div>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvar s5 = \"<div class=\\\"midiMore\\\"><div class=\\\"midiMoreText\\\"><a href='RegimenDetail?regiId=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ data.healFoodArray[index].regiId\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"&search_strD=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ $('#search_str').val()\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"'><span class=\\\"left\\\">查看</span><span class=\\\"right\\\">详情</span></a></div></div></li>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$(\"#healFood_list\").html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$(\"#healFood_list\").html()+ s1+s2+st1+s3+st1+s4+st1+s5);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("$(\".megas512\").hide();\r\n");
      out.write("\t\t\t\t\t$(\"#Pagination1\").pagination(foodtotal, { //recordCount在后台定义的一个公有变量，通过从数据库查询记录进行赋值，返回记录的总数\r\n");
      out.write("\t\t\t\t\t\trecordCount : 30,\r\n");
      out.write("\t\t\t\t\t\tcallback : pageselectCallback, //点击分页时，调用的回调函数  \r\n");
      out.write("\t\t\t\t\t\tprev_text : '« 上一页', //显示上一页按钮的文本  \r\n");
      out.write("\t\t\t\t\t\tnext_text : '下一页 »', //显示下一页按钮的文本  \r\n");
      out.write("\t\t\t\t\t\titems_per_page : 4, //每页显示的项数  \r\n");
      out.write("\t\t\t\t\t\tnum_display_entries : 10, //分页插件中间显示的按钮数目  \r\n");
      out.write("\t\t\t\t\t\tcurrent_page : pageIndex, //当前页索引  \r\n");
      out.write("\t\t\t\t\t\tnum_edge_entries : 2\r\n");
      out.write("\t\t\t\t\t//分页插件左右两边显示的按钮数目  \r\n");
      out.write("\t\t\t\t\t}); //分页功能结束\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("comptotal = data.typeNumb.Ncomp;\r\n");
      out.write("$(\"#regiComp_list\").html(\"\");\r\n");
      out.write("$.each(data.regiCompArray, function(index) {\r\n");
      out.write("    var picture=data.regiCompArray[index].Picture;\r\n");
      out.write("    var s1=\"<li><img src=\\\"");
      out.print(templateUrl);
      out.write("/\"+ picture\r\n");
      out.write("\t+ \"\\\" /><div class=\\\"midiMess\\\"><p class=\\\"midiName\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ data.regiCompArray[index].Name\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"</p>\";\r\n");
      out.write("\t\t\t\t\t\t\tvar s2 = \"<p class=\\\"midiText\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ data.regiCompArray[index].Function\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"</p></div>\";\r\n");
      out.write("\t\t\t\t\t\t\tvar st1 =\"<span class=\\\"midiInter\\\"></span>\";\r\n");
      out.write("\t\t\t\t\t\t\tvar s3 = \"<div class=\\\"midiUse\\\"><p class=\\\"midiUseName\\\">[ 用法用量 ]</p>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+\"<p class=\\\"midiUseText\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ data.regiCompArray[index].Usage\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"</p></div>\";\r\n");
      out.write("\t\t\t\t\t\t\tvar s4 = \"<div class=\\\"midiUse\\\"><p class=\\\"midiUseName\\\">[ 注意事项 ]</p>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+\"<p class=\\\"midiUseText\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ data.regiCompArray[index].Precaution\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"</p></div>\";\r\n");
      out.write("\t\t\t\t\t\t\tvar s5 = \"<div class=\\\"midiMore\\\"><div class=\\\"midiMoreText\\\"><a href='RegimenDetail?regiId=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ data.regiCompArray[index].regiId\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"&search_strD=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ $('#search_str').val()\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"'><span class=\\\"left\\\">查看</span><span class=\\\"right\\\">详情</span></a></div></div></li>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$(\"#regiComp_list\").html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$(\"#regiComp_list\").html()+ s1+s2+st1+s3+st1+s4+st1+s5);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("$(\".megas512\").hide();\r\n");
      out.write("\t\t\t\t\t$(\"#Pagination2\").pagination(comptotal, { //recordCount在后台定义的一个公有变量，通过从数据库查询记录进行赋值，返回记录的总数\r\n");
      out.write("\t\t\t\t\t\trecordCount : 30,\r\n");
      out.write("\t\t\t\t\t\tcallback : pageselectCallback, //点击分页时，调用的回调函数  \r\n");
      out.write("\t\t\t\t\t\tprev_text : '« 上一页', //显示上一页按钮的文本  \r\n");
      out.write("\t\t\t\t\t\tnext_text : '下一页 »', //显示下一页按钮的文本  \r\n");
      out.write("\t\t\t\t\t\titems_per_page : 4, //每页显示的项数  \r\n");
      out.write("\t\t\t\t\t\tnum_display_entries : 14, //分页插件中间显示的按钮数目  \r\n");
      out.write("\t\t\t\t\t\tcurrent_page : pageIndex, //当前页索引  \r\n");
      out.write("\t\t\t\t\t\tnum_edge_entries : 2\r\n");
      out.write("\t\t\t\t\t//分页插件左右两边显示的按钮数目  \r\n");
      out.write("\t\t\t\t\t}); //分页功能结束\r\n");
      out.write("bathtotal = data.typeNumb.Nbath;\r\n");
      out.write("$(\"#mediBath_list\").html(\"\");\r\n");
      out.write("$.each(data.mediBathArray, function(index) {\r\n");
      out.write("var picture=data.mediBathArray[index].Picture;\r\n");
      out.write("var s1=\"<li><img src=\\\"");
      out.print(templateUrl);
      out.write("/\"+ picture\r\n");
      out.write("+ \"\\\" /><div class=\\\"midiMess\\\"><p class=\\\"midiName\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ data.mediBathArray[index].Name\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"</p>\";\r\n");
      out.write("\t\t\t\t\t\tvar s2 = \"<p class=\\\"midiText\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ data.mediBathArray[index].Function\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"</p></div>\";\r\n");
      out.write("\t\t\t\t\t\tvar st1 =\"<span class=\\\"midiInter\\\"></span>\";\r\n");
      out.write("\t\t\t\t\t\tvar s3 = \"<div class=\\\"midiUse\\\"><p class=\\\"midiUseName\\\">[ 用法用量 ]</p>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"<p class=\\\"midiUseText\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ data.mediBathArray[index].Usage\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"</p></div>\";\r\n");
      out.write("\t\t\t\t\t\tvar s4 = \"<div class=\\\"midiUse\\\"><p class=\\\"midiUseName\\\">[ 注意事项 ]</p>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"<p class=\\\"midiUseText\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ data.mediBathArray[index].Precaution\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"</p></div>\";\r\n");
      out.write("\t\t\t\t\t\tvar s5 = \"<div class=\\\"midiMore\\\"><div class=\\\"midiMoreText\\\"><a href='RegimenDetail?regiId=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ data.mediBathArray[index].regiId\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"&search_strD=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ $('#search_str').val()\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"'><span class=\\\"left\\\">查看</span><span class=\\\"right\\\">详情</span></a></div></div></li>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\"#mediBath_list\").html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\"#mediBath_list\").html()+ s1+s2+st1+s3+st1+s4+st1+s5);\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("$(\".megas512\").hide();\r\n");
      out.write("\t\t\t\t$(\"#Pagination3\").pagination(bathtotal, { //recordCount在后台定义的一个公有变量，通过从数据库查询记录进行赋值，返回记录的总数\r\n");
      out.write("\t\t\t\t\trecordCount : 30,\r\n");
      out.write("\t\t\t\t\tcallback : pageselectCallback, //点击分页时，调用的回调函数  \r\n");
      out.write("\t\t\t\t\tprev_text : '« 上一页', //显示上一页按钮的文本  \r\n");
      out.write("\t\t\t\t\tnext_text : '下一页 »', //显示下一页按钮的文本  \r\n");
      out.write("\t\t\t\t\titems_per_page : 4, //每页显示的项数  \r\n");
      out.write("\t\t\t\t\tnum_display_entries : 14, //分页插件中间显示的按钮数目  \r\n");
      out.write("\t\t\t\t\tcurrent_page : pageIndex, //当前页索引  \r\n");
      out.write("\t\t\t\t\tnum_edge_entries : 2\r\n");
      out.write("\t\t\t\t//分页插件左右两边显示的按钮数目  \r\n");
      out.write("\t\t\t\t}); //分页功能结束\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\tprestotal = data.typeNumb.Npres;\r\n");
      out.write("\t\t $(\"#massPres_list\").html(\"\");\r\n");
      out.write("\t\t $.each(data.massPresArray, function(index) {\r\n");
      out.write("\t\t\t     var picture=data.massPresArray[index].Picture;\r\n");
      out.write("\t\t\t     var s1=\"<li><img src=\\\"");
      out.print(templateUrl);
      out.write("/\"+ picture\r\n");
      out.write("\t\t\t\t\t+ \"\\\" /><div class=\\\"midiMess\\\"><p class=\\\"midiName\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ data.massPresArray[index].Name\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"</p>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tvar s2 = \"<p class=\\\"midiText\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ data.massPresArray[index].Function\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"</p></div>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tvar st1 =\"<span class=\\\"midiInter\\\"></span>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tvar s3 = \"<div class=\\\"midiUse\\\"><p class=\\\"midiUseName\\\">[ 操作方法 ]</p>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+\"<p class=\\\"midiUseText\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ data.massPresArray[index].Usage\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"</p></div>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tvar s4 = \"<div class=\\\"midiUse\\\"><p class=\\\"midiUseName\\\">[ 注意事项 ]</p>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+\"<p class=\\\"midiUseText\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ data.massPresArray[index].Precaution\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"</p></div>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tvar s5 = \"<div class=\\\"midiMore\\\"><div class=\\\"midiMoreText\\\"><a href='RegimenDetail?regiId=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ data.massPresArray[index].regiId\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"&search_strD=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ $('#search_str').val()\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"'><span class=\\\"left\\\">查看</span><span class=\\\"right\\\">详情</span></a></div></div></li>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"#massPres_list\").html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"#massPres_list\").html()+s1+s2+st1+s3+st1+s4+st1+s5);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t  $(\".megas512\").hide();\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#Pagination4\").pagination(prestotal, { //recordCount在后台定义的一个公有变量，通过从数据库查询记录进行赋值，返回记录的总数\r\n");
      out.write("\t\t\t\t\t\t\t\t\trecordCount : 30,\r\n");
      out.write("\t\t\t\t\t\t\t\t\tcallback : pageselectCallback, //点击分页时，调用的回调函数  \r\n");
      out.write("\t\t\t\t\t\t\t\t\tprev_text : '« 上一页', //显示上一页按钮的文本  \r\n");
      out.write("\t\t\t\t\t\t\t\t\tnext_text : '下一页 »', //显示下一页按钮的文本  \r\n");
      out.write("\t\t\t\t\t\t\t\t\titems_per_page : 4, //每页显示的项数  \r\n");
      out.write("\t\t\t\t\t\t\t\t\tnum_display_entries : 14, //分页插件中间显示的按钮数目  \r\n");
      out.write("\t\t\t\t\t\t\t\t\tcurrent_page : pageIndex, //当前页索引  \r\n");
      out.write("\t\t\t\t\t\t\t\t\tnum_edge_entries : 2\r\n");
      out.write("\t\t\t\t\t\t\t\t//分页插件左右两边显示的按钮数目  \r\n");
      out.write("\t\t\t\t\t\t\t\t}); //分页功能结束\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("equitotal = data.typeNumb.Nequi;\r\n");
      out.write(" $(\"#mediEqui_list\").html(\"\");\r\n");
      out.write(" $.each(data.mediEquiArray, function(index) {\r\n");
      out.write("\t     var picture=data.mediEquiArray[index].Picture;\r\n");
      out.write("\t     var s1=\"<li><img src=\\\"");
      out.print(templateUrl);
      out.write("/\"+ picture\r\n");
      out.write("\t+ \"\\\" /><div class=\\\"midiMess\\\"><p class=\\\"midiName\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ data.mediEquiArray[index].Name\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"</p>\";\r\n");
      out.write("\t\t\t\t\t\t\tvar s2 = \"<p class=\\\"midiText\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ data.mediEquiArray[index].Apply\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"</p></div>\";\r\n");
      out.write("\t\t\t\t\t\t\tvar st1 =\"<span class=\\\"midiInter\\\"></span>\";\r\n");
      out.write("\t\t\t\t\t\t\tvar s3 = \"<div class=\\\"midiUse\\\"><p class=\\\"midiUseName\\\">[ 适用于 ]</p>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+\"<p class=\\\"midiUseText\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ data.mediEquiArray[index].Apply\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"</p></div>\";\r\n");
      out.write("\t\t\t\t\t\t\tvar s4 = \"<div class=\\\"midiUse\\\"><p class=\\\"midiUseName\\\">[ 注意事项 ]</p>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+\"<p class=\\\"midiUseText\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ data.mediEquiArray[index].Precaution\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"</p></div>\";\r\n");
      out.write("\t\t\t\t\t\t\tvar s5 = \"<div class=\\\"midiMore\\\"><div class=\\\"midiMoreText\\\"><a href='RegimenDetail?regiId=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ data.mediEquiArray[index].regiId\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"&search_strD=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ $('#search_str').val()\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"'><span class=\\\"left\\\">查看</span><span class=\\\"right\\\">详情</span></a></div></div></li>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\"#mediEqui_list\").html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\"#mediEqui_list\").html()+s1+s2+st1+s3+st1+s4+st1+s5);\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t$(\"#Pagination5\").pagination(equitotal, { //recordCount在后台定义的一个公有变量，通过从数据库查询记录进行赋值，返回记录的总数\r\n");
      out.write("\t\t\t\t\trecordCount : 30,\r\n");
      out.write("\t\t\t\t\tcallback : pageselectCallback, //点击分页时，调用的回调函数  \r\n");
      out.write("\t\t\t\t\tprev_text : '« 上一页', //显示上一页按钮的文本  \r\n");
      out.write("\t\t\t\t\tnext_text : '下一页 »', //显示下一页按钮的文本  \r\n");
      out.write("\t\t\t\t\titems_per_page : 3, //每页显示的项数  \r\n");
      out.write("\t\t\t\t\tnum_display_entries : 14, //分页插件中间显示的按钮数目  \r\n");
      out.write("\t\t\t\t\tcurrent_page : pageIndex, //当前页索引  \r\n");
      out.write("\t\t\t\t\tnum_edge_entries : 2\r\n");
      out.write("\t\t\t\t//分页插件左右两边显示的按钮数目  \r\n");
      out.write("\t\t\t\t}); //分页功能结束\r\n");
      out.write("\t\t\t\t$(\"#Pagination5\").show();\r\n");
      out.write("\t\t\t\t\t\t\t} //  function succFunction(data)  结束\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t} //  function bind(pageIndex)  结束\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#logintab {\r\n");
      out.write("\tmargin-top: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#logintab li a {\r\n");
      out.write("\toutline: none;\r\n");
      out.write("\ttext-decoration: none\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
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
      out.write("\t<!--选药-->\r\n");
      out.write("\t<div class=\"chooseMidi\">\r\n");
      out.write("\t\t<ul class=\"midiTab\">\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<div class=\"con\">\r\n");
      out.write("\t\t\t\t\t<span class=\"left\">保健</span>\r\n");
      out.write("\t\t\t\t\t<span class=\"right\">食品</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<div class=\"con\">\r\n");
      out.write("\t\t\t\t\t<span class=\"left\">养生</span>\r\n");
      out.write("\t\t\t\t\t<span class=\"right\">复方</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<div class=\"con\">\r\n");
      out.write("\t\t\t\t\t<span class=\"left\">中药</span>\r\n");
      out.write("\t\t\t\t\t<span class=\"right\">浴方</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<div class=\"con\">\r\n");
      out.write("\t\t\t\t\t<span class=\"left\">按摩</span>\r\n");
      out.write("\t\t\t\t\t<span class=\"right\">方</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<div class=\"con\">\r\n");
      out.write("\t\t\t\t\t<span class=\"left\">医疗</span>\r\n");
      out.write("\t\t\t\t\t<span class=\"right\">器械</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<span class=\"midiTopPic\"></span>\r\n");
      out.write("\t\t<div id=\"content\">\r\n");
      out.write("\t\t<ul id=\"healFood_list\" class=\"midiCon\">\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<div id=\"Pagination1\" class=\"megas512\"></div>\r\n");
      out.write("\t\t<ul id=\"regiComp_list\" class=\"midiCon\">\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<div id=\"Pagination2\" class=\"megas512\"></div>\r\n");
      out.write("\t\t<ul id=\"mediBath_list\" class=\"midiCon\">\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<div id=\"Pagination3\" class=\"megas512\"></div>\r\n");
      out.write("\t\t<ul id=\"massPres_list\" class=\"midiCon\">\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<div id=\"Pagination4\" class=\"megas512\"></div>\r\n");
      out.write("\t\t<ul id=\"mediEqui_list\" class=\"midiCon\">\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<div id=\"Pagination5\" class=\"megas512\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/include/login.jsp", out, false);
      out.write("\r\n");
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
