package org.apache.jsp.WEB_002dINF.memb.jibingMan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.sql.*;

public final class JiBMan_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css0623/wodeCen.css\" rel=\"stylesheet\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    function getDoctorOfflineConsult(){\r\n");
      out.write("\t    $.ajax({\r\n");
      out.write("\t        url : '");
      out.print(templateUrl);
      out.write("/user/OfflineConsultFormBriefForUserRead',\r\n");
      out.write("\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\tcontentType : \"application/json; charset=utf-8\",\r\n");
      out.write("\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\ttimeout : 20000,\r\n");
      out.write("\t\t\tcache : true,\r\n");
      out.write("\t\t\terror : erryFunction, //错误执行方法  \r\n");
      out.write("\t\t\tsuccess : succFunction\r\n");
      out.write("\t\t//成功执行方法  \r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction erryFunction() {\r\n");
      out.write("\t\t\talert(\"请刷新页面\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t//未读消息条数\r\n");
      out.write("\t\t\tvar numYD = data.acountYD;\r\n");
      out.write("\t\t\tvar numWD = data.acountWD;\r\n");
      out.write("\t\t\t//alert(num);\r\n");
      out.write("\t\t\t$(\"#recAIDYD\").html(numYD);\r\n");
      out.write("\t\t\t$(\"#recAIDWD\").html(numWD);\r\n");
      out.write("\t\t\tif(parseInt(data.acountYD)!=0){\r\n");
      out.write("\t\t\t\t//var th=$(\"<thead><tr> <th>序号</th><th>专家</th><th>病情简介 </th><th>辩证结果</th><th>辨病结果</th><th>回复时间</th></tr></thead>\");\r\n");
      out.write("\t\t\t\t//th.appendTo(\"#recordsYD\");\r\n");
      out.write("     \t\t\t$.each(data.OfflineConsultArrayYD,function(index) {\r\n");
      out.write("     \t\t\t\t\r\n");
      out.write("     \t\t\t\t//alert(data.OfflineConsultArray[index].electronic_record);\r\n");
      out.write("\t\t\t\t\tvar s1 = \"<tr><td><a target=\\\"_blank\\\" title=\\\"查看详情\\\" href='OfflineConsultFormDetailForUserRead?electronic_record=\"+ data.OfflineConsultArrayYD[index].electronic_record+ \"'>\"\t+ (index + 1)+ \"</a></td>\";\r\n");
      out.write("\t\t\t\t\tvar s2 =\"<td>\"+data.OfflineConsultArrayYD[index].expeId+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s3 =\"<td>\"+data.OfflineConsultArrayYD[index].brief+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s4 =\"<td>\"+data.OfflineConsultArrayYD[index].medeical_zheng+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s6 =\"<td>\"+data.OfflineConsultArrayYD[index].medeical_disease+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s5 = \"<td>\"+data.OfflineConsultArrayYD[index].time+\"</td></tr>\";\r\n");
      out.write("\t\t\t\t\t//var s5 = \"<td><a target=\\\"_blank\\\" href='OfflineConsultFormDetailForAppend?electronic_record=\"+ data.OfflineConsultArrayYD[index].electronic_record+ \"'>追加</a></td></tr>\";\r\n");
      out.write("\t\t\t\t\tvar tr=$(s1+s2+s3+s4+s6+s5);\r\n");
      out.write("\t\t\t\t    tr.appendTo(\"#recordsYD\");\r\n");
      out.write("     \t\t\t\t\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(parseInt(data.acountWD)!=0){\r\n");
      out.write("\t\t\t\t//var th=$(\"<thead><tr> <th>序号</th><th>专家</th><th>病情简介 </th><th>咨询时间</th></tr></thead>\");\r\n");
      out.write("\t\t\t\t//th.appendTo(\"#recordsWD\");\r\n");
      out.write("\t\t\t\t$.each(data.OfflineConsultArrayWD,function(index) {\r\n");
      out.write("\t\t\t\t\tvar s1 = \"<tr><td><a target=\\\"_blank\\\" title=\\\"查看详情\\\" href='OfflineConsultFormDetailForUserRead?electronic_record=\"+ data.OfflineConsultArrayWD[index].electronic_record+ \"'>\"\t+ (index + 1)+ \"</a></td>\";\r\n");
      out.write("\t\t\t\t\tvar s2 =\"<td>\"+data.OfflineConsultArrayWD[index].expeId+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s3 =\"<td>\"+data.OfflineConsultArrayWD[index].brief+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s4 = \"<td>\"+data.OfflineConsultArrayWD[index].time+\"</td></tr>\";\r\n");
      out.write("\t\t\t\t\tvar tr=$(s1+s2+s3+s4);\r\n");
      out.write("\t\t\t\t    tr.appendTo(\"#recordsWD\");\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\twindow.onload = function() {\r\n");
      out.write("\t\tgetDoctorOfflineConsult();\r\n");
      out.write("\t\t$(\"#recAIDYD\").click(function(){\r\n");
      out.write("\t\t\t $(\"#recordsYD\").toggle();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#recAIDWD\").click(function(){\r\n");
      out.write("\t\t\t $(\"#recordsWD\").toggle();\r\n");
      out.write("\t\t });\r\n");
      out.write("\t};\r\n");
      out.write("\t \r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"right\">\r\n");
      out.write("\t\t<div><img id=\"left-img\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/left.png\"/><span>疾病管理</span>\r\n");
      out.write("\t\t<img id=\"right-img\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/right.png\"/></div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div style=\"font-family:'宋体';font-weight:bold;font-size:24pt;margin:13px 0 0 290px;\">[我的专家咨询信息]</div>\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t<table width=800px align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t<tr><td align=\"center\" colspan=\"5\" bgcolor=\"#F5ECE2\" style=\"font-family:'宋体';font-size:18pt;color:#000;\">总共有<a id=\"recAIDYD\" href=\"javascript:void(0)\"><span style=\"font-family:'宋体';font-size:30px;color:#c9b28b;\">0</span></a>条已处理记录</td></tr>\r\n");
      out.write("\t\t<tr><td>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<table id=\"recordsYD\" border=\"1 solid #DACEBD\" width=800px align=\"center\" height=\"80px\" cellpadding=\"0\" cellspacing=\"0\" style=\"text-align:center\">\r\n");
      out.write("\t\t\t<tr align=\"center\" bgcolor=\"#BFA789\" style=\"color:#fff;font-size:16pt;font-weight:bold;height:40px;line-height:40px;\">\r\n");
      out.write("\t\t\t<td>[序号]</td><td>[专家]</td><td>[病情简历]</td><td>[辩证结果]</td><td>[辨病结果]</td><td>[回复时间]</td></tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr> \r\n");
      out.write("\t\t<tr><td colspan=\"5\" height=\"40px\"></td></tr>  <!-- 两个表格之间空格 -->\r\n");
      out.write("\t\t<tr><td align=\"center\" colspan=\"5\" bgcolor=\"#F5ECE2\" style=\"font-family:'宋体';font-size:18pt;color:#000;\">总共有<a id=\"recAIDWD\" href=\"javascript:void(0)\">0<span style=\"font-family:'宋体';font-size:30px;color:#c9b28b;\">0</span></a>条未处理记录</td></tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t<table id=\"recordsWD\" border=\"1 solid #DACEBD\" width=800px align=\"center\" height=\"80px\" cellpadding=\"0\" cellspacing=\"0\" style=\"text-align:center\">\r\n");
      out.write("\t\t\t<tr align=\"center\" height=\"40px\" bgcolor=\"#BFA789\" style=\"color:#fff;font-size:16pt;font-weight:bold;height:40px;line-height:40px;\">\r\n");
      out.write("\t\t\t<td>[序号]</td><td>[专家]</td><td>[病情简介]</td><td>[咨询时间]</td></tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
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
