package org.apache.jsp.WEB_002dINF.expe.messages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.sql.*;

public final class noreadBox_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	String name = (String) session.getAttribute("expename");

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/article.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    function getDoctorOfflineConsult(){\r\n");
      out.write("\t  // var data=encodeURIComponent(JSON.stringify($('#input_doctor').val()),\"utf-8\");\r\n");
      out.write("\t  // alert(encodeURI(encodeURI($('#input_doctor').val())));//验证是否在线\r\n");
      out.write("\t    $.ajax({\r\n");
      out.write("\t        url : '");
      out.print(templateUrl);
      out.write("/expe/OfflineConsultFormBrief',\r\n");
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
      out.write("\t\t\t//未读消息条数\r\n");
      out.write("\t\t\tvar num = data.acount;\r\n");
      out.write("\t\t\t//alert(num);\r\n");
      out.write("\t\t\t$(\"#recAID\").html(num);\r\n");
      out.write("\t\t\tif(parseInt(data.acount)!=0){\r\n");
      out.write("\t\t\tvar th=$(\"<thead style=\\\"border:0\\\"><tr><th>序号 </th><th>患者 </th><th>姓名</th><th>病情简介 </th><th>咨询时间</th><th>去处理</th></tr></thead>\");\r\n");
      out.write("\t\t\tth.appendTo(\"#records\");\r\n");
      out.write("\t\t\t$.each(data.OfflineConsultArray,function(index) {\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar s1 = \"<tr><td><a title=\\\"查看详情\\\" target=\\\"_blank\\\" href='OfflineConsultFormDetail?electronic_record=\"+ data.OfflineConsultArray[index].electronic_record+ \"'>\"\t+ (index + 1)+ \"</a></td>\";\r\n");
      out.write("\t\t\t\tvar s2 =\"<td>\"+data.OfflineConsultArray[index].userId+\"</td>\";\r\n");
      out.write("\t\t\t\tvar s5=\"<td>\"+data.OfflineConsultArray[index].consultName+\"</td>\";\r\n");
      out.write("\t\t\t\tvar s3 =\"<td>\"+data.OfflineConsultArray[index].brief+\"</td>\";\r\n");
      out.write("\t\t\t\tvar s4 = \"<td>\"+data.OfflineConsultArray[index].time+\"</td>\";\r\n");
      out.write("\t\t\t\tvar s6 = \"<td class=\\\"offAccount\\\"><a title=\\\"处理\\\" class=\\\"deal\\\" target=\\\"_blank\\\" href='OfflineConsultFormDetail?electronic_record=\"+ data.OfflineConsultArray[index].electronic_record+ \"'>\"\t+ \"处理\"+ \"</a></td></tr>\";\r\n");
      out.write("\t\t\t\tvar tr=$(s1+s2+s5+s3+s4+s6);\r\n");
      out.write("\t\t\t    tr.appendTo(\"#records\");\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 如何将已处理的离线表单删除！！！\r\n");
      out.write("\t\t\t //$(\".deal\").click(function (){\r\n");
      out.write("\t\t\t\t //var consultId = $(this).attr(\"electronic_record\");\r\n");
      out.write("\t\t\t\t// if($(\"#records tr\").length==1){\r\n");
      out.write("\t\t\t\t\t//\t$(\"#records thead\").remove();\r\n");
      out.write("\t\t\t\t\t\t//$(\"#records\").hide();\r\n");
      out.write("\t\t\t\t\t//}\r\n");
      out.write("\t\t\t// });\r\n");
      out.write("\t\t}\r\n");
      out.write("\t  }\r\n");
      out.write("\t}\r\n");
      out.write("    \r\n");
      out.write("\twindow.onload = function() {\r\n");
      out.write("\t\tgetDoctorOfflineConsult();\r\n");
      out.write("\t\t$(\"#recAID\").click(function(){\r\n");
      out.write("\t\t\t $(\"#records\").toggle();\r\n");
      out.write("\t\t });\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
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
      out.write("\t<div class=\"user_center_bigtitle\">\r\n");
      out.write("\t\t<h3><span>离线申请</span></h3>\r\n");
      out.write("\t\t<hr></hr> \r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"my_dis_diray\">\r\n");
      out.write("\t\t<div class=\"my_dis_diray_con\">\r\n");
      out.write("\t\t\t<div class=\"mg_info\">\r\n");
      out.write("\t\t\t\t<h3>\r\n");
      out.write("\t\t\t\t\t<h3>总共有（<a id=\"recAID\" href=\"javascript:void(0)\"></a>）条记录</h3>\r\n");
      out.write("\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t<table id=\"records\" width=\"900\" border=\"1\" id=\"table\" bordercolor=\"#FFFFFF\" align=\"center\" style=\"text-align: center;\">\r\n");
      out.write("                </table>\r\n");
      out.write("\t\t\t</div>\r\n");
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
