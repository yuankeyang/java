package org.apache.jsp.WEB_002dINF.memb.myfamily;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class myfamily_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", -10);

      out.write('\r');
      out.write('\n');

	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	String userId = (String) session.getAttribute("username");

      out.write("\r\n");
      out.write("<!DOCTYPE>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/include/head.jsp", out, false);
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css0623/style.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    function getMembFamilyList(){\r\n");
      out.write("\t  \r\n");
      out.write("\t    $.ajax({\r\n");
      out.write("\t        url : '");
      out.print(templateUrl);
      out.write("/user/MemberFamilyListAction',\r\n");
      out.write("\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\tcontentType: \"application/x-www-form-urlencoded; charset=utf-8\",\r\n");
      out.write("\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\ttimeout : 8000,\r\n");
      out.write("\t\t\tcache : true,\r\n");
      out.write("\t\t\terror : erryFunction, //错误执行方法  \r\n");
      out.write("\t\t\tsuccess : succFunction\r\n");
      out.write("\t\t//成功执行方法  \r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction erryFunction() {\r\n");
      out.write("\t\t\talert(\"有错误，请刷新页面\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t//未读消息条数\r\n");
      out.write("\t\t\tvar num = data.acount;\r\n");
      out.write("\t\t\t//alert(num);\r\n");
      out.write("\t\t\t$(\"#recAID\").html(num);\r\n");
      out.write("\t\t\t//姓名\t性别\t生日\t地区\t本人关系\r\n");
      out.write("\t\t\tif(parseInt(data.acount)!=0){\r\n");
      out.write("\t\t\t\tvar th=$(\"<thead><tr align='center'height='40px' bgcolor='#BFA789' class='xu' style='color: #FFF;'><th>[编号]</th><th>[名字]</th><th>[性别]</th><th>[年龄]</th><th>[与本人关系]</th><th>[手机]</th><th>[固话]</th><th>[地址]</th><th colSpan='2'>[相 关 操 作]</th></tr></thead>\");\r\n");
      out.write("\t\t\t\tth.appendTo(\"#membFamilyList\");\r\n");
      out.write("\t\t\t\t//alert(data.MembFamilyArray[0].title);\r\n");
      out.write("\t\t\t\t$.each(data.MembFamilyArray,function(index) {\r\n");
      out.write("\t\t\t\t\t//alert(data.OfflineConsultArray[index].electronic_record);\r\n");
      out.write("\t\t\t\t\tvar s1 = \"<tr align='center' height='40px' bgcolor='#FFFFFF' style='font-size: 16px;color: #000;'><td>\"+(index+1)+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s2 = \"<td><b>\"+data.MembFamilyArray[index].username+\"</b></td>\";\r\n");
      out.write("\t\t\t\t\tvar s3 = \"<td><b>\"+data.MembFamilyArray[index].sex+\"</b></td>\";\r\n");
      out.write("\t\t\t\t\tvar s4 = \"<td><b>\"+data.MembFamilyArray[index].age+\"</b></td>\";\r\n");
      out.write("\t\t\t\t\tvar s5 = \"<td><b>\"+data.MembFamilyArray[index].relation+\"</b></td>\";\r\n");
      out.write("\t\t\t\t\tvar s6 = \"<td><b>\"+data.MembFamilyArray[index].mobile+\"</b></td>\";\r\n");
      out.write("\t\t\t\t\tvar s7 = \"<td><b>\"+data.MembFamilyArray[index].telephone+\"</b></td>\";\r\n");
      out.write("\t\t\t\t\tvar s8 = \"<td><b>\"+data.MembFamilyArray[index].address+\"</b></td>\";\r\n");
      out.write("\t\t\t\t\tvar s9= \"<td><b><a href='UpdateMemberFamilyAction?MembFamily_Id=\"+data.MembFamilyArray[index].MembFamily_Id+\"'>更新</a></b></td>\";\r\n");
      out.write("\t\t\t\t\tvar s10=\"<td><b><a href='javascript:void(0)' id=\"+data.MembFamilyArray[index].MembFamily_Id+\" class='delete'>删除</a></b></td></tr>\";\r\n");
      out.write("\t\t\t\t\tvar tr=$(s1+s2+s3+s4+s5+s6+s7+s8+s9+s10);\r\n");
      out.write("\t\t\t\t    tr.appendTo(\"#membFamilyList\");\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$('#membFamilyList').show();\r\n");
      out.write("\t\t\t\t $(\".delete\").click(function (){\r\n");
      out.write("\t\t\t\t\t //alert(\"sd\");\r\n");
      out.write("\t\t\t\t\t //$(this)获取的是点击的对象，点击的对象是a标签，a标签的上一级的上一级是tr\r\n");
      out.write("\t\t\t\t\t var statu=confirm(\"确定删除该家属信息?\");\r\n");
      out.write("\t\t\t\t\t\tif(!statu){\r\n");
      out.write("\t\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t\t}//  \r\n");
      out.write("\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t var MembFamily_Id = $(this).attr(\"id\");\r\n");
      out.write("\t\t\t\t\t $.ajax({\r\n");
      out.write("\t\t\t\t\t        url : '");
      out.print(templateUrl);
      out.write("/user/DeleteMemberFamily?MembFamily_Id='\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ MembFamily_Id,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tcontentType : \"application/x-www-form-urlencoded; charset=utf-8\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tdataType : 'text',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\ttimeout : 8000,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tcache : true,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\terror : erryFunction, //错误执行方法  \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tsuccess : succFunction\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t//成功执行方法  \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t\tfunction erryFunction() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\talert(\"删除失败\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\talert(\"删除成功\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//alert($(\"#\"+JiuyiExp_Id).attr(\"id\"));\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$(\"#\" + MembFamily_Id).parent()\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t.parent().remove();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$(\"#recAID\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t.html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"#membFamilyList tr\").length - 1);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tif ($(\"#membFamilyList tr\").length == 1) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(\"#membFamilyList thead\").remove();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(\"#membFamilyList\").hide();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\twindow.onload = function() {\r\n");
      out.write("\t\tgetMembFamilyList();\r\n");
      out.write("\t\t$('#membFamilyList').hide();\r\n");
      out.write("\t\t$(\"#recAID\").click(function() {\r\n");
      out.write("\t\t\t$('#membFamilyList').toggle();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t};\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"right\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/left.png\" />&nbsp;&nbsp;<font\r\n");
      out.write("\t\t\t\tsize=\"6\"><b>我的家属</b>\r\n");
      out.write("\t\t\t</font>&nbsp;&nbsp;<img\r\n");
      out.write("\t\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/right.png\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"my_dis_diray\">\r\n");
      out.write("\t\t\t<div class=\"my_dis_diray_con\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"mg_info\" style=\"font-family: '宋体';font-size: 18px;\">\r\n");
      out.write("\t\t\t\t\t<h3>\r\n");
      out.write("\t\t\t\t\t\t<h3 >\r\n");
      out.write("\t\t\t\t\t\t\t总共有<a id=\"recAID\" href=\"javascript:void(0)\"></a>个家属信息\r\n");
      out.write("\t\t\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t\t<table id=\"membFamilyList\" width=\"800\" border=\"1\" id=\"table\"\r\n");
      out.write("\t\t\t\t\t\tbordercolor=\"000\" align=\"center\" style=\"text-align: center;\">\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<br/><br/>\r\n");
      out.write("\t\t\t\t<form action=\"NewMemberFamilyAction\" method=\"post\" >\r\n");
      out.write("\t\t\t\t\t<div class=\"\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" id=\"newMember\" value=\"新建家属信息\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"font-family: '宋体';font-size: 18px;\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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
