package org.apache.jsp.WEB_002dINF.memb.yiliaoSer.jiuyiExp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.sql.*;

public final class jiuyiExp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");

	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	String userId = (String) session.getAttribute("username");
	userId="xianggen";

      out.write("\r\n");
      out.write("<!DOCTYPE>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css0623/style.css\"/>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    function getJiuyiJinYanList(){\r\n");
      out.write("\t    $.ajax({\r\n");
      out.write("\t        url : '");
      out.print(templateUrl);
      out.write("/user/JiuyiExpListAction',\r\n");
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
      out.write("\t\t\talert(\"有错误，请刷新页面\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t//未读消息条数\r\n");
      out.write("\t\t\tvar num = data.acount;\r\n");
      out.write("\t\t\t//alert(num);\r\n");
      out.write("\t\t\t$(\"#recAID\").html(num);\r\n");
      out.write("\t\t\tif(parseInt(data.acount)!=0){\r\n");
      out.write("\t\t\t\tvar th=$(\"<thead><tr align='center'height='40px' bgcolor='#BFA789' class='xu' style='color: #FFF;'><th width='5%'>[编号]</th> <th width='20%'>[发表时间]</th><th width='20%'>[题目]</th> <th width='10%' colSpan='2'>[相关操作]</th></tr></thead>\");\r\n");
      out.write("\t\t\t\tth.appendTo(\"#articleList\");\r\n");
      out.write("\t\t\t\t$.each(data.JiuyiExpArray,function(index) {\r\n");
      out.write("\t\t\t\t\t//alert(data.OfflineConsultArray[index].electronic_record);\r\n");
      out.write("\t\t\t\t\tvar s1 = \"<tr align='center' height='40px' bgcolor='#FFFFFF' style='font-size: 16px;color: #000;'><td>\"+(index+1)+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s2 = \"<td><a target=\\\"_blank\\\" title=\\\"查看详情\\\" href='OpenJiuyiExp?JiuyiExp_Id=\"+data.JiuyiExpArray[index].JiuyiExp_Id+\"'>\"+data.JiuyiExpArray[index].title+\"</a></td>\";\r\n");
      out.write("\t\t\t\t\tvar s3 = \"<td>\"+data.JiuyiExpArray[index].time+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s4= \"<td><a title=\\\"修改一下\\\" href='UpdateJiuyiExpAction?JiuyiExp_Id=\"+data.JiuyiExpArray[index].JiuyiExp_Id+\"'>更新</a></td>\";\r\n");
      out.write("\t\t\t\t\tvar s5=\"<td><a href='javascript:void(0)' title=\\\"删除它\\\" id=\"+data.JiuyiExpArray[index].JiuyiExp_Id+\" class='delete'>删除</a></td></tr>\";\r\n");
      out.write("\t\t\t\t\tvar tr=$(s1+s2+s3+s4+s5);\r\n");
      out.write("\t\t\t\t    tr.appendTo(\"#articleList\");\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t $('#articleList').show();\r\n");
      out.write("\t\t\t\t $(\".delete\").click(function (){\r\n");
      out.write("\t\t\t\t\t var statu=confirm(\"确定删除该就医经验?\");\r\n");
      out.write("\t\t\t\t\t\tif(!statu){\r\n");
      out.write("\t\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t var JiuyiExp_Id = $(this).attr(\"id\");\r\n");
      out.write("\t\t\t\t\t $.ajax({\r\n");
      out.write("\t\t\t\t\t        url : '");
      out.print(templateUrl);
      out.write("/user/DeleteJiuyiExp?JiuyiExp_Id='+JiuyiExp_Id,\r\n");
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
      out.write("\t\t\t\t\t\t\t$(\"#\"+JiuyiExp_Id).parent().parent().remove();\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#recAID\").html($(\"#articleList tr\").length-1);\r\n");
      out.write("\t\t\t\t\t\t\tif($(\"#articleList tr\").length==1){\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#articleList thead\").remove();\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#articleList\").hide();\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t   });\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\twindow.onload = function() {\r\n");
      out.write("\t\tgetJiuyiJinYanList();\r\n");
      out.write("\t\t$('#articleList').hide();\r\n");
      out.write("\t\t$(\"#recAID\").click(function(){\r\n");
      out.write("\t\t\t$('#articleList').toggle();\r\n");
      out.write("\t\t });\r\n");
      out.write("\t};\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"right\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/left.png\" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font\r\n");
      out.write("\t\t\t\tsize=\"6\"><b>就医经验</b>\r\n");
      out.write("\t\t\t</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img\r\n");
      out.write("\t\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/right.png\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"my_dis_diray\">\r\n");
      out.write("\t\t<div class=\"my_dis_diray_con\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div class=\"mg_info\" style=\"font-family: '宋体';font-size: 18px;\">\r\n");
      out.write("\t\t\t\t<h3>\r\n");
      out.write("\t\t\t\t\t<h3>总共有<a id=\"recAID\" href=\"javascript:void(0)\"></a>篇就医经验</h3>\r\n");
      out.write("\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t<table id=\"articleList\" cellspacing=\"1\" cellpadding=\"0\" width=\"800\" border=\"1\" id=\"table\"  align=\"center\" style=\"text-align: center;\">\r\n");
      out.write("                </table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<br/><br/>\r\n");
      out.write("\t\t\t<form action=\"NewJiuyiExpAction\" method=\"post\">\r\n");
      out.write("\t\t<div class=\"\" align=\"right\">\r\n");
      out.write("\t\t <input type=\"submit\" id=\"newjiuyiExp\" value=\"新建就医经验\" style=\"font-family: '宋体';font-size: 18px;\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
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
