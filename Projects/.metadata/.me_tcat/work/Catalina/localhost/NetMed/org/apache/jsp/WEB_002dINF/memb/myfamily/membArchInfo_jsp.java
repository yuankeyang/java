package org.apache.jsp.WEB_002dINF.memb.myfamily;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class membArchInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    function getmembArchInfoList(){\r\n");
      out.write("\t    $.ajax({\r\n");
      out.write("\t        url : '");
      out.print(templateUrl);
      out.write("/user/getArchInfoBriefListForRead',\r\n");
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
      out.write("\t\t\t\tvar th=$(\"<thead><tr align='center'height='40px' bgcolor='#BFA789' style='color: #FFF;'> <th>编号</th><th>名字</th><th>性别</th><th>年龄</th><th>职业</th><th>手机号码</th><th>地址</th><th colSpan='3'>相 关 操 作</th></tr></thead>\");\r\n");
      out.write("\t\t\t\tth.appendTo(\"#membArchInfoList\");\r\n");
      out.write("\t\t\t\t//alert(data.archInfoArray[0].title);\r\n");
      out.write("\t\t\t\t$.each(data.archInfoArray,function(index) {\r\n");
      out.write("\t\t\t\t\t//alert(data.OfflineConsultArray[index].electronic_record);\r\n");
      out.write("\t\t\t\t\tvar s1 = \"<tr align='center' height='40px' bgcolor='#FFFFFF' style='font-size: 16px;color: #000;'><td>\"+(index+1)+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s2 = \"<td>\"+data.archInfoArray[index].username+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s3 = \"<td>\"+data.archInfoArray[index].sex+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s4 = \"<td>\"+data.archInfoArray[index].age+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s5 = \"<td>\"+data.archInfoArray[index].occupation+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s7 = \"<td>\"+data.archInfoArray[index].telephone+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s8 = \"<td>\"+data.archInfoArray[index].address+\"</td>\";\r\n");
      out.write("\t\t\t\t\t//var s9= \"<td><a  href='UpdateMemberFamilyAction?MembFamily_Id=\"+data.archInfoArray[index].MembFamily_Id+\"'>更新</a></td>\";\r\n");
      out.write("\t\t\t\t\tvar s10=\"<td><a href='javascript:void(0)' id=\"+data.archInfoArray[index].archId+\" class='delete'>删除</a></td>\";\r\n");
      out.write("\t\t\t\t\tvar s11= \"<td><a title=\\\"修改一下\\\" href='UpdateArchInfoAction?ArchInfo_Id=\"+data.archInfoArray[index].archId+\"'>更新</a></td>\";\r\n");
      out.write("\t\t\t\t\tvar s12= \"<td><a target=\\\"_blank\\\" title=\\\"查看一下\\\" href='ArchInfoDetailForUserRead?ArchInfo_Id=\"+data.archInfoArray[index].archId+\"'>查看</a></td></tr>\";\r\n");
      out.write("\t\t\t\t\tvar tr=$(s1+s2+s3+s4+s5+s7+s8+s10+s11+s12);\r\n");
      out.write("\t\t\t\t    tr.appendTo(\"#membArchInfoList\");\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$('#membArchInfoList').show();\r\n");
      out.write("\t\t\t\t $(\".delete\").click(function (){\r\n");
      out.write("\t\t\t\t\t //alert(\"sd\");\r\n");
      out.write("\t\t\t\t\t //$(this)获取的是点击的对象，点击的对象是a标签，a标签的上一级的上一级是tr\r\n");
      out.write("\t\t\t\t\t //  \r\n");
      out.write("\t\t\t\t\t var statu=confirm(\"确定删除该电子病历?\");\r\n");
      out.write("\t\t\t\t\t\tif(!statu){\r\n");
      out.write("\t\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t var archId = $(this).attr(\"id\");\r\n");
      out.write("\t\t\t\t\t $.ajax({\r\n");
      out.write("\t\t\t\t\t        url : '");
      out.print(templateUrl);
      out.write("/user/DeleteArchInfoAction?archId='+archId,\r\n");
      out.write("\t\t\t\t\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\t\t\t\t\tcontentType: \"application/x-www-form-urlencoded; charset=utf-8\", \r\n");
      out.write("\t\t\t\t\t\t\tdataType : 'text',\r\n");
      out.write("\t\t\t\t\t\t\ttimeout : 8000,\r\n");
      out.write("\t\t\t\t\t\t\tcache : true,\r\n");
      out.write("\t\t\t\t\t\t\terror : erryFunction, //错误执行方法  \r\n");
      out.write("\t\t\t\t\t\t\tsuccess : succFunction\r\n");
      out.write("\t\t\t\t\t\t//成功执行方法  \r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t function erryFunction() {\r\n");
      out.write("\t\t\t\t\t\t\talert(\"删除失败\");\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t function succFunction(data) {\r\n");
      out.write("\t\t\t\t\t\t\talert(\"删除成功\");\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#\"+archId).parent().parent().remove();\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#recAID\").html($(\"#membArchInfoList tr\").length-1);\r\n");
      out.write("\t\t\t\t\t\t\tif($(\"#membArchInfoList tr\").length==1){\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#membArchInfoList thead\").remove();\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#membArchInfoList\").hide();\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t   });\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\twindow.onload = function() {\r\n");
      out.write("\t\tgetmembArchInfoList();\r\n");
      out.write("\t\t$('#membArchInfoList').hide();\r\n");
      out.write("\t\t$(\"#recAID\").click(function(){\r\n");
      out.write("\t\t\t$('#membArchInfoList').toggle();\r\n");
      out.write("\t\t });\r\n");
      out.write("\t};\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/left.png\"/>&nbsp;&nbsp;<span style=\"font-family:'仿宋';font-size:30pt\">电子档案</span>\r\n");
      out.write("\t\t&nbsp;&nbsp;<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/right.png\"/></div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"my_dis_diray\">\r\n");
      out.write("\t\t<div class=\"my_dis_diray_con\">\r\n");
      out.write("\t\t\t<div class=\"mg_info\" style=\"font-family:'宋体';font-size: 18px;\">\r\n");
      out.write("\t\t\t\t<h3>\r\n");
      out.write("\t\t\t\t\t总共有（<a id=\"recAID\" href=\"javascript:void(0)\"></a>）个电子健康病历\r\n");
      out.write("\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t<table id=\"membArchInfoList\" width=\"780px\" border=\"0\" id=\"table\" bordercolor=\"#FFFFFF\" align=\"center\" style=\"text-align: center;font-weight:bold\">\r\n");
      out.write("                </table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br/><br/>\r\n");
      out.write("\t\t <form action=\"NewMembArchInfo\" method=\"post\">\r\n");
      out.write("\t\t  <div align=\"right\">\r\n");
      out.write("\t\t    <input type=\"submit\" id=\"newMember\" value=\"新建电子健康档案\" style=\"font-family:'宋体';font-size: 18px;\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
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
