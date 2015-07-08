package org.apache.jsp.WEB_002dINF.expe.ToolBox.myToolBox;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.sql.*;

public final class myRepository_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	String expeId = (String) session.getAttribute("expename");

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("    function getrepositoryList(){\r\n");
      out.write("\t    $.ajax({\r\n");
      out.write("\t        url : '");
      out.print(templateUrl);
      out.write("/expe/RepositoryListAction',\r\n");
      out.write("\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\tcontentType : \"application/json; charset=utf-8\",\r\n");
      out.write("\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\ttimeout : 10000,\r\n");
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
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(parseInt(data.acount)!=0){\r\n");
      out.write("\t\t\t\tvar th=$(\"<thead><tr align='center'height='40px' bgcolor='#BFA789' style='color: #FFF;'><th>方名</th><th>证候</th><th>中医病名</th><th>西医病名</th><th>记录时间</th> <th colSpan='2'>相 关 操 作</th></tr></thead>\");\r\n");
      out.write("\t\t\t\tth.appendTo(\"#repositoryList\");\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$.each(data.repoArray,function(index) {\r\n");
      out.write("\t\t\t\t\t//alert(data.repoArray[index].syndrome);\r\n");
      out.write("\t\t\t\t\tvar s1 = \"<tr align='center' height='40px' bgcolor='#FFFFFF' style='font-size: 16px;color: #000;'><td>\"+(index+1)+\"</td>\"  ;\r\n");
      out.write("\t\t\t\t\tvar s2 = \"<tr><td class=\\\"offAccount\\\"><a title=\\\"查看\\\" target=\\\"_blank\\\" href='OpenRepository?repoId=\"+data.repoArray[index].repoId+\"'>\"+data.repoArray[index].presName+\"</a></td>\";\r\n");
      out.write("\t\t\t\t\tvar s3= \"<td>\"+data.repoArray[index].syndrome+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s4= \"<td>\"+data.repoArray[index].chinDise+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s5= \"<td>\"+data.repoArray[index].westDise+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s6 = \"<td>\"+data.repoArray[index].time+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s7= \"<td class=\\\"offAccount\\\"><a title=\\\"修改一下\\\" href='UpdateRepositoryAction?repoId=\"+data.repoArray[index].repoId+\"'>修改</a></td>\";\r\n");
      out.write("\t\t\t\t\tvar s8=\"<td class=\\\"offAccount\\\"><a title=\\\"删除\\\" href='javascript:void(0)' id=\"+data.repoArray[index].repoId+\" class='delete'>删除</a></td></tr>\";\r\n");
      out.write("\t\t\t\t\tvar tr=$(s2+s3+s4+s5+s6+s7+s8);\r\n");
      out.write("\t\t\t\t    tr.appendTo(\"#repositoryList\");\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$('#repositoryList').show();\r\n");
      out.write("\t\t\t\t $(\".delete\").click(function (){\r\n");
      out.write("\t\t\t\t\t var statu=confirm(\"确定删除该处方记录?\");\r\n");
      out.write("\t\t\t\t\t\tif(!statu){\r\n");
      out.write("\t\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t var repoId = $(this).attr(\"id\");\r\n");
      out.write("\t\t\t\t\t $.ajax({\r\n");
      out.write("\t\t\t\t\t        url : '");
      out.print(templateUrl);
      out.write("/expe/DeleteRepository?repoId='+repoId,\r\n");
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
      out.write("\t\t\t\t\t\t\t//alert($(\"#\"+repoId).attr(\"id\"));\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#\"+repoId).parent().parent().remove();\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#recAID\").html($(\"#repositoryList tr\").length-1);\r\n");
      out.write("\t\t\t\t\t\t\tif($(\"#repositoryList tr\").length==1){\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#repositoryList thead\").remove();\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#repositoryList\").hide();\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t   });\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\twindow.onload = function() {\r\n");
      out.write("\t\tgetrepositoryList();\r\n");
      out.write("\t\t$('#repositoryList').hide();\r\n");
      out.write("\t\t$(\"#recAID\").click(function(){\r\n");
      out.write("\t\t\t$('#repositoryList').toggle();\r\n");
      out.write("\t\t });\r\n");
      out.write("\t};\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("   \r\n");
      out.write("   .offAccount a{ color:#0000ff;text-decoration:none;font-weight:bold}\r\n");
      out.write("   .offAccount a:hover{color:#ff0000}\r\n");
      out.write("   .offAccount a:active{color:#ff0000}   \r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/left.png\"/>&nbsp;&nbsp;<span style=\"font-family:'仿宋';font-size:30pt\">我的知识库</span>\r\n");
      out.write("\t\t&nbsp;&nbsp;<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/right.png\"/></div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"my_dis_diray\">\r\n");
      out.write("\t\t<div class=\"my_dis_diray_con\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div class=\"mg_info\" style=\"font-family:'宋体';font-size: 18px;\">\r\n");
      out.write("\t\t\t\t<h3>\r\n");
      out.write("\t\t\t\t\t总共有（<a id=\"recAID\" href=\"javascript:void(0)\">0</a>）篇开方记录\r\n");
      out.write("\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t<table id=\"repositoryList\" width=\"780\" border=\"0\" style=\"font-weight:bold\">\r\n");
      out.write("                   </table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<br/>\r\n");
      out.write("\t\t\t<form action=\"NewRepositoryAction\" method=\"post\">\r\n");
      out.write("\t\t<div align=\"right\">\r\n");
      out.write("\t\t <input type=\"submit\" id=\"NewRepository\" value=\"记录新的处方\" style=\"font-family:'宋体';font-size: 18px;\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t\t\r\n");
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
