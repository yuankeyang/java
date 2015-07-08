package org.apache.jsp.WEB_002dINF.memb.wearableDevices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mySleepRecord_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css0623/style.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    function getSleepRecord(){\r\n");
      out.write("    \t\r\n");
      out.write("\t    $.ajax({\r\n");
      out.write("\t        url : '");
      out.print(templateUrl);
      out.write("/user/SleepRecordAction',\r\n");
      out.write("\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\tcontentType : \"application/json; charset=utf-8\",\r\n");
      out.write("\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\ttimeout : 8000,\r\n");
      out.write("\t\t\tcache : true,\r\n");
      out.write("\t\t\terror : erryFunction, //错误执行方法  \r\n");
      out.write("\t\t\tsuccess : succFunction\r\n");
      out.write("\t\t//成功执行方法  \r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction erryFunction() {\r\n");
      out.write("\t\t\talert(\"请刷新页面!!\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//未读消息条数\r\n");
      out.write("\t\t\tvar num = data.acount;\r\n");
      out.write("\t\t\t//alert(num);\r\n");
      out.write("\t\t\t$(\"#recAID\").html(num);\r\n");
      out.write("\t\t\t//初入睡时间\t睡眠时间长度\t  熟睡总时间    浅睡总时间    醒/做梦总时间   呼吸中止指数  记录时间    \r\n");
      out.write("\t\t\tif(parseInt(data.acount)!=0){\r\n");
      out.write("\t\t\t\tvar th=$(\"<thead><tr align='center'height='40px' bgcolor='#BFA789' class='xu' style='color: #FFF;'> <th>[编号]</th><th>[初入睡时间]</th><th>[睡眠时间长度]</th><th>[熟睡总时间]</th><th>[浅睡总时间]</th><th>[醒/做梦总时间]</th><th>[呼吸中止指数]</th><th>[记录时间]</th><th colSpan='2'>[相 关 操 作]</th></tr></thead>\");\r\n");
      out.write("\t\t\t\tth.appendTo(\"#sleepRecord\");\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$.each(data.sleepRecordArray,function(index) {\r\n");
      out.write("\t\t\t\t\t//alert(data.sleepRecordArray[index].sleepRecordId);\r\n");
      out.write("\t\t\t\t\tvar s1 = \"<tr align='center' height='40px' bgcolor='#FFFFFF' style='font-size: 16px;color: #000;'><td>\"+(index+1)+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s2 = \"<td>\"+data.sleepRecordArray[index].fallSleep+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s3 = \"<td>\"+data.sleepRecordArray[index].sleepDuration+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s4 = \"<td>\"+data.sleepRecordArray[index].deepDuration+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s5 = \"<td>\"+data.sleepRecordArray[index].simpleDuration+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s6 = \"<td>\"+data.sleepRecordArray[index].dreamDuration+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s7 = \"<td>\"+data.sleepRecordArray[index].breathIndex+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s8 = \"<td>\"+data.sleepRecordArray[index].measureTime+\"</td>\";\r\n");
      out.write("\t\t\t\t\t//var s8 = \"<td>\"+data.bloodPressureArray[index].address+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s9= \"<td><a  href='updateSleepRecordAction?sleepRecordId=\"+data.sleepRecordArray[index].sleepRecordId+\"'>修改</a></td>\";\r\n");
      out.write("\t\t\t\t\tvar s10=\"<td><a href='javascript:void(0)' id=\"+data.sleepRecordArray[index].sleepRecordId+\" class='delete'>删除</a></td></tr>\";\r\n");
      out.write("\t\t\t\t\tvar tr=$(s1+s2+s3+s4+s5+s6+s7+s8+s9+s10);\r\n");
      out.write("\t\t\t\t    tr.appendTo(\"#sleepRecord\");\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$('#sleepRecord').show();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\".delete\").click(function (){\r\n");
      out.write("\t\t\t\t\tvar statu=confirm(\"确定删除该睡眠记录?\");\r\n");
      out.write("\t\t\t\t\tif(!statu){\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t //$(this)获取的是点击的对象，点击的对象是a标签，a标签的上一级的上一级是tr\r\n");
      out.write("\t\t\t\t\t var sleepRecordId = $(this).attr(\"id\");\r\n");
      out.write("\t\t\t\t\t $.ajax({\r\n");
      out.write("\t\t\t\t\t        url : '");
      out.print(templateUrl);
      out.write("/user/DeleteSleepRecord?sleepRecordId='\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ sleepRecordId,\r\n");
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
      out.write("\t\t\t\t\t\t\t\t\t\t$(\"#\" + sleepRecordId).parent()\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t.parent().remove();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$(\"#recAID\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t.html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"#sleepRecord tr\").length - 1);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tif ($(\"#sleepRecord tr\").length == 1) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(\"#sleepRecord thead\").remove();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(\"#sleepRecord\").hide();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\twindow.onload = function() {\r\n");
      out.write("\t\tgetSleepRecord();\r\n");
      out.write("\t\t$('#sleepRecord').hide();\r\n");
      out.write("\t\t$(\"#recAID\").click(function() {\r\n");
      out.write("\t\t\t$('#sleepRecord').toggle();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t};\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/left.png\" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font\r\n");
      out.write("\t\t\tsize=\"6\"><b>我的睡眠</b> </font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img\r\n");
      out.write("\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/right.png\" />\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"my_dis_diray\">\r\n");
      out.write("\t\t<div class=\"my_dis_diray_con\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"mg_info\"\r\n");
      out.write("\t\t\t\tstyle=\"font-family: '宋体' ;font-size: 18px;\">\r\n");
      out.write("\t\t\t\t<h3>\r\n");
      out.write("\t\t\t\t\t总共有<a id=\"recAID\" href=\"javascript:void(0)\"></a>条睡眠记录\r\n");
      out.write("\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t<table id=\"sleepRecord\" width=\"800\" border=\"1\" id=\"table\"\r\n");
      out.write("\t\t\t\t\tbordercolor=\"#FFFFFF\" align=\"center\" style=\"text-align: center;\">\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<br/><br/>\r\n");
      out.write("\t\t\t<form action=\"NewSleepRecord\" method=\"post\">\r\n");
      out.write("\t\t\t\t<div align=\"right\">\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" id=\"newMember\" value=\"新增睡眠记录\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"font-family: '宋体';font-size: 18px;\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
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
