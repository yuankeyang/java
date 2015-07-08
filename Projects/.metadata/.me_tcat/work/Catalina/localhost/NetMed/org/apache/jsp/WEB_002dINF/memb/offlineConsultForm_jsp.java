package org.apache.jsp.WEB_002dINF.memb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;

public final class offlineConsultForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/core_head.jsp", out, false);
      out.write('\r');
      out.write('\n');

	String memb_id = (String) session.getAttribute("username");
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();

	if (memb_id == null) {
		response.sendRedirect(templateUrl);
	}
	String expe_id = (String)session.getAttribute("expe_id");
	String expe_name=(String)session.getAttribute("expe_name");
	if(expe_id==null||expe_name==null){
		 expe_id = (String)request.getParameter("expe_id");
		 expe_name=new String(request.getParameter("expe_name").getBytes("iso8859-1"),"utf-8");
		 
	}
	

      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/topbar.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/topbarhead.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/article.css\" />\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".consultInput{\r\n");
      out.write("   border-radius:10px;\r\n");
      out.write("   box-shadow:2px;\r\n");
      out.write("   border-color:#BFA789;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<title>离线咨询</title>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function check() {\r\n");
      out.write("\t\tif ($('#illn_desc').val() == \"\") {\r\n");
      out.write("\t\t\t$(\"#illn_desc\").select();\r\n");
      out.write("\t\t\t$(\"#illn_desc\").focus();\r\n");
      out.write("\t\t} else if ($('#fami_hist').val() == \"\") {\r\n");
      out.write("\t\t\t$(\"#fami_hist\").select();\r\n");
      out.write("\t\t\t$(\"#fami_hist\").focus();\r\n");
      out.write("\t\t}else if ($('#PeopleName').val() == \"\") {\r\n");
      out.write("\t\t\t$(\"#PeopleName\").select();\r\n");
      out.write("\t\t\t$(\"#PeopleName\").focus();\r\n");
      out.write("\t\t} else if ($('#pers_hist').val() == \"\") {\r\n");
      out.write("\t\t\t$(\"#pers_hist\").select();\r\n");
      out.write("\t\t\t$(\"#pers_hist\").focus();\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$(\"#offlineConsult\").submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("$(function() {\r\n");
      out.write("\tgetPeopleName('");
      out.print(memb_id);
      out.write("');\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("function getPeopleName(memb_id){\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("        url : \"");
      out.print(templateUrl);
      out.write("/user/PeopleNameAction?memb_id=");
      out.print(memb_id);
      out.write("\",\r\n");
      out.write("\t\ttype : 'POST',\r\n");
      out.write("\t\tcontentType : \"application/x-www-form-urlencoded; charset=utf-8\",\r\n");
      out.write("\t\tdataType : 'json',\r\n");
      out.write("\t\ttimeout : 18000,\r\n");
      out.write("\t\tcache : true,\r\n");
      out.write("\t\terror : erryFunction, //错误执行方法  \r\n");
      out.write("\t\tsuccess : succFunction\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\tfunction erryFunction() {\r\n");
      out.write("\t\t\talert(\"获取会员及家属姓名出错，请重试!!\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t//alert(\"ssssss\");\r\n");
      out.write("\t\t\t//alert(data.PeopleNameArray[0].value);\r\n");
      out.write("\t\t\t$(\"#relationship\").find(\"option\").remove();\r\n");
      out.write("\t\t\t$.each(data.PeopleNameArray, function(index) {\r\n");
      out.write("\t\t\t\t$(\"#relationship\").append(\r\n");
      out.write("\t\t\t\t\t\t\"<option value=\"+data.PeopleNameArray[index].name+\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ data.PeopleNameArray[index].name\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"</option>\");\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\tvar consultName = $(\"#relationship\").val(); \r\n");
      out.write("\t\t\tgetHistory(memb_id,consultName);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("  $(\"#relationship\").change(function () {\r\n");
      out.write("       var consultName=$('#relationship').val(); \r\n");
      out.write("  \t   getHistory(memb_id,consultName);\r\n");
      out.write("});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function getHistory(memb_id,consultName){\r\n");
      out.write("\t//alert(memb_id);\r\n");
      out.write("\t//alert(consultName);\r\n");
      out.write("\t\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("        url : '");
      out.print(templateUrl);
      out.write("/user/HistoryAction?memb_id=");
      out.print(memb_id);
      out.write("'+'&consultName='+consultName,\r\n");
      out.write("\t\t\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\t\t\tcontentType : \"application/x-www-form-urlencoded; charset=utf-8\",\r\n");
      out.write("\t\t\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\t\t\ttimeout : 18000,\r\n");
      out.write("\t\t\t\t\tcache : true,\r\n");
      out.write("\t\t\t\t\terror : erryFunction, //错误执行方法  \r\n");
      out.write("\t\t\t\t\tsuccess : succFunction\r\n");
      out.write("\t\t\t\t//成功执行方法  \r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\tfunction erryFunction() {\r\n");
      out.write("\t\t\talert(\"获取会员及家属姓名出错，请重试!!\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t$(\"#pers_hist\").text(data.personHistory);\r\n");
      out.write("\t\t\t$(\"#fami_hist\").text(data.familyHistory);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div style=\"margin-left:300px;margin-top:10px\">\r\n");
      out.write("\t\t<p\r\n");
      out.write("\t\t\tstyle=\"background:url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/image/suggestionbg.png) no-repeat;font-size:18px;font-weight:400;width:600px\">&nbsp;&nbsp;\r\n");
      out.write("\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;专家信息：</p>\r\n");
      out.write("\t\t<div class=\"docIn\"\r\n");
      out.write("\t\t\tstyle=\"border:2px solid #BFA789;border-radius:10px;width:730px;height:170px;margin-left:20px\">\r\n");
      out.write("\t\t\t<img id=\"expertPhoto\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/image/offlineDoctor.png\" style=\"border:2px solid #BFA789;border-radius:8px\" />\r\n");
      out.write("\t\t\t<div style=\"float:left\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li id=\"name\">");
      out.print(expe_id);
      out.write("</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t<form action=\"user/OfflineConsultAction\" method=\"post\"\r\n");
      out.write("\t\t\tenctype=\"multipart/form-data\" id=\"offlineConsult\">\r\n");
      out.write("\t\t\t<div style=\"margin-left:25px\">\r\n");
      out.write("\t\t\t\t请选择具体咨询人：\r\n");
      out.write("\t\t\t\t<select id=\"relationship\" style=\"width:100px\" name=\"relationship\"></select>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<br/>\r\n");
      out.write("\t\t\t<p\r\n");
      out.write("\t\t\t\tstyle=\"background:url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/image/suggestionbg.png) no-repeat;font-size:18px;font-weight:400;width:600px\">&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;我的信息：</p>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"memb_id\" id=\"memb_id\" value=\"");
      out.print(memb_id);
      out.write("\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"expe_id\" id=\"expe_id\" value=\"");
      out.print(expe_id);
      out.write("\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div style=\"margin-top:30px\">\r\n");
      out.write("\t\t\t\t<div style=\"margin-left:30px;\">\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/image/angle_blue.png\" />&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t<label style=\"font-size:18px\">病情描述</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<textarea id=\"illn_desc\" name=\"illn_desc\" placeholder=\"请描述下你的病情\" class=\"consultInput\"\r\n");
      out.write("\t\t\t\t\tstyle=\"width:720px;height:100px;overflow-y:scroll;resize:none;margin-left:30px;border:solid 2px #BFA789\"></textarea>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"margin-top:15px;\">\r\n");
      out.write("\t\t\t\t<div style=\"margin-left:30px;float:left\">\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/image/angle_blue.png\" />&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t<label style=\"font-size:18px\">个人病史</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t<div style=\"float:none;margin-top:20px\">\r\n");
      out.write("\t\t\t\t\t<textarea id=\"pers_hist\" name=\"pers_hist\" class=\"consultInput\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"width:720px;height:100px;overflow-y:scroll;resize:none;margin-left:30px;border:solid 2px #BFA789\"></textarea>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"margin-top:15px\">\r\n");
      out.write("\t\t\t\t<div style=\"margin-left:30px;float:left\">\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/image/angle_blue.png\" />&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t<label style=\"font-size:18px\">家族病史</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<br /> <br />\r\n");
      out.write("\t\t\t\t<div style=\"float:none\">\r\n");
      out.write("\t\t\t\t\t<textarea id=\"fami_hist\" name=\"fami_hist\" class=\"consultInput\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"width:720px;height:100px;overflow-y:scroll;resize:none;margin-left:30px;border:solid 2px #BFA789\"></textarea>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div style=\"margin-top:30px;height:150px;width:800px;\">\r\n");
      out.write("\t\t\t\t<div style=\"float:left;width:820px;height:100px;margin-left:30px\">\r\n");
      out.write("\t\t\t\t\t<table style=\"border:solid 1px #BFA789;\" rules=rows>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td style=\"width:200px\"><h3>上传附件</h3>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td style=\"width:200px\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><span id=\"fileName\">病历资料</span></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td style=\"width:510px\"><input type=\"file\" id=\"attachment\"\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"attachment\">\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>体检资料</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"file\" id=\"attachment\" name=\"attachment\">\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>语音资料</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"file\" id=\"attachment\" name=\"attachment\">\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div id=\"mysubmit\"\r\n");
      out.write("\t\t\t\t\tstyle=\"margin-top:30px;width:600px;float:right;margin-top:80px;margin-right:100px;\">\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/image/largebutton_subsave.png\" onclick=\"check();\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"float:right;\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<!--版权信息等-->\r\n");
      out.write("\t<div id=\"footer\" style=\"margin-top:100px;text-align:center\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/bottom/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
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
