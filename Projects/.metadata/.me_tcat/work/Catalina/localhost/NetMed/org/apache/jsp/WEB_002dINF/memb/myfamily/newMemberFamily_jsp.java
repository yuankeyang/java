package org.apache.jsp.WEB_002dINF.memb.myfamily;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class newMemberFamily_jsp extends org.apache.jasper.runtime.HttpJspBase
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

String templateUrl = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath();
request.setAttribute("url", templateUrl);

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\r\n");
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
      out.write("<script src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/schedule/jquery-ui-1.11.4/jquery-ui.min.js'></script>\r\n");
      out.write("<script src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/schedule/jQuery-Timepicker-Addon-master/datepicker-zh.js'></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("window.onload = function(){\r\n");
      out.write("\r\n");
      out.write("    $('#birthday').datepicker({\r\n");
      out.write("            changeMonth: true ,\r\n");
      out.write("            changeYear: true ,\r\n");
      out.write("            yearRange: '1900:2099', //取值范围.\r\n");
      out.write("            dateFormat: 'yy-mm-dd',\r\n");
      out.write("            showOn: 'both', //输入框和图片按钮都可以使用日历控件。\r\n");
      out.write("            buttonImage: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/image/calendar.gif', //日历控件的按钮\r\n");
      out.write("            buttonImageOnly: true,\r\n");
      out.write("            showButtonPanel: true\r\n");
      out.write("    });  \r\n");
      out.write("};\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"page\">\r\n");
      out.write("<form id=\"AddMemberFamily\" name=\"AddMemberFamily\"  method=\"post\" action=\"AddMemberFamily\">\r\n");
      out.write("<div>\r\n");
      out.write("\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/left.png\" />&nbsp;&nbsp;<font\r\n");
      out.write("\t\t\t\tsize=\"6\"><b>新建家属信息</b>\r\n");
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
      out.write("\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t<input type=\"submit\" class=\"submit\" value=\"确认\"/>\r\n");
      out.write("\t\t\t</fieldset>\r\n");
      out.write("\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
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
