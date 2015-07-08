package org.apache.jsp.WEB_002dINF.memb.myfamily;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class updateMemberFamily_jsp extends org.apache.jasper.runtime.HttpJspBase
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

String templateUrl = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath();
request.setAttribute("url", templateUrl);
String MembFamily_Id = request.getParameter("MembFamily_Id");

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css0623/style.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.validate.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/register.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    function getMembFamilyById(){\r\n");
      out.write("    \t$.ajax({\r\n");
      out.write("\t        url : '");
      out.print(templateUrl);
      out.write("/user/MembFamilyForReadAction?MembFamily_Id=");
      out.print(MembFamily_Id);
      out.write("',\r\n");
      out.write("\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\tcontentType: \"application/x-www-form-urlencoded; charset=utf-8\",\r\n");
      out.write("\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\ttimeout : 8000,\r\n");
      out.write("\t\t\tcache : true,\r\n");
      out.write("\t\t\terror : erryFunction, //错误执行方法  \r\n");
      out.write("\t\t\tsuccess : succFunction\r\n");
      out.write("\t\t//成功执行方法  \r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction erryFunction(data) {\r\n");
      out.write("\t\t\talert(\"等待3秒后请刷新页面\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t$(\"#FamilyName\").val(data.FamilyName);\r\n");
      out.write("\t\t\t$(\"input:radio[name='sex']\").eq(parseInt(data.sex)).attr(\"checked\",true);\r\n");
      out.write("\t\t\t$(\"#age\").val(data.age);\r\n");
      out.write("\t\t\t$(\"#relation\").val(data.relation);\r\n");
      out.write("\t\t\t$(\"#mobile\").val(data.mobile);\r\n");
      out.write("\t\t\t$(\"#telephone\").val(data.telephone);\r\n");
      out.write("\t\t\t$(\"#address\").val(data.address);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\twindow.onload = function() {\r\n");
      out.write("\t\tgetMembFamilyById();\r\n");
      out.write("\t};\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"page\">\r\n");
      out.write("\t\r\n");
      out.write("<form id=\"newFamilyMember\" name=\"newFamilyMember\"  method=\"post\" action=\"UpdateMemberFamily\">\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/left.png\" />&nbsp;&nbsp;<font\r\n");
      out.write("\t\t\t\tsize=\"6\"><b>更新家属信息</b>\r\n");
      out.write("\t\t</font>&nbsp;&nbsp;<img\r\n");
      out.write("\t\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/right.png\" />\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br/>\r\n");
      out.write("\t<table class=\"wwFormTable\" style=\"font-family: '宋体';font-size: 18px;\">\r\n");
      out.write("\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("                \t<li>\r\n");
      out.write("\t\t\t\t\t\t<label for=\"FamilyName\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"required\" style=\"font-family: '宋体';font-size: 18px;\"><b>[患者姓名]</b></span>\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t<input id=\"FamilyName\" name=\"FamilyName\" type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"FamilyName\" class=\"error\">患者姓名不可为空</label>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<label for=\"sex\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"required\" style=\"font-family: '宋体';font-size: 18px;\"><b>[性别]</b></span>\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t<input name=\"sex\" type=\"radio\" value=\"male\" checked=\"checked\" >男&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t<input name=\"sex\" type=\"radio\" value=\"female\" >女\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<label for=\"age\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"required\" style=\"font-family: '宋体';font-size: 18px;\"><b>[年龄]</b></span>\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t<input id=\"age\" name=\"age\"  type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"age\" class=\"error\">请填写正确的年龄</label>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<label for=\"relation\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"relation\" style=\"font-family: '宋体';font-size: 18px;\"><b>[与患者关系]</b></span>\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t<select id=\"relation\" name=\"relation\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"本人\" selected=\"selected\">本人</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"家庭成员\">家庭成员</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"亲戚\">亲戚</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"朋友\">朋友</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"其他\">其他</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<label for=\"mobile\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"mobile\" style=\"font-family: '宋体';font-size: 18px;\"><b>[手机号]</b></span>\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t<input id=\"mobile\" name=\"mobile\"  type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"mobile\" class=\"error\">请填写正确的手机号</label>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<label for=\"telephone\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"telephone\" style=\"font-family: '宋体';font-size: 18px;\"><b>[固定电话]</b></span>\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t<input id=\"telephone\" name=\"telephone\"  type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"telephone\" class=\"error\">请填写正确的固定电话</label>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<label for=\"address\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"address\" style=\"font-family: '宋体';font-size: 18px;\"><b>[家庭地址]</b></span>\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t<input id=\"address\" name=\"address\"  type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"address\" class=\"error\">家庭地址不可为空</label>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</fieldset>\r\n");
      out.write("\t\t\t<fieldset class=\"submit\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"MembFamily_Id\" value=\"");
      out.print(MembFamily_Id);
      out.write("\" >\r\n");
      out.write("\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t<input type=\"submit\" class=\"submit\" value=\"确认\" />\r\n");
      out.write("\t\t\t</fieldset>\r\n");
      out.write("\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
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
