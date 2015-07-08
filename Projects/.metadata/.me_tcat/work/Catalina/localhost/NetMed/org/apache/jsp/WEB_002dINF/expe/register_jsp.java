package org.apache.jsp.WEB_002dINF.expe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fform_005fmethod_005fid_005faction;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fform_005fmethod_005fid_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fform_005fmethod_005fid_005faction.release();
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
      out.write("     \r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/topReg.jsp", out, false);
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("<!--\r\n");
      out.write("body {\r\n");
      out.write("\tbackground-color:#FFF;\r\n");
      out.write("\tbackground-image:url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/image/asidepic05.png);\r\n");
      out.write("\tbackground-repeat: repeat;\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("<div id=\"page\">\r\n");
      out.write("\t<div id=\"header\">\r\n");
      out.write("\t\t<h1>专家注册</h1>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"content\">\r\n");
      out.write("\t\t<p id=\"status\"></p>\r\n");
      out.write("\t\t");
      if (_jspx_meth_s_005fform_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</div>\r\n");
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

  private boolean _jspx_meth_s_005fform_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:form
    org.apache.struts2.views.jsp.ui.FormTag _jspx_th_s_005fform_005f0 = (org.apache.struts2.views.jsp.ui.FormTag) _005fjspx_005ftagPool_005fs_005fform_005fmethod_005fid_005faction.get(org.apache.struts2.views.jsp.ui.FormTag.class);
    _jspx_th_s_005fform_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fform_005f0.setParent(null);
    // /WEB-INF/expe/register.jsp(20,2) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fform_005f0.setAction("expe-regi-chec");
    // /WEB-INF/expe/register.jsp(20,2) name = method type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fform_005f0.setMethod("get");
    // /WEB-INF/expe/register.jsp(20,2) name = id type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fform_005f0.setId("expe-reg");
    int _jspx_eval_s_005fform_005f0 = _jspx_th_s_005fform_005f0.doStartTag();
    if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fform_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fform_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t<fieldset>\r\n");
        out.write("\t\t\t\t<legend>专家信息</legend>\r\n");
        out.write("\t\t\t\t<ul>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"username\">\r\n");
        out.write("\t\t\t\t\t\t<span class=\"required\">昵称</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input id=\"username\" name=\"username\" type=\"text\">\r\n");
        out.write("\t\t\t\t\t\t<label for=\"username\" class=\"error\">必须由字母数字下划线组成</label>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"realname\">\r\n");
        out.write("\t\t\t\t\t\t<span class=\"required\">姓名</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input id=\"realname\" name=\"realname\" type=\"text\">\r\n");
        out.write("\t\t\t\t\t\t<label for=\"realname\" class=\"error\">请输入您的真实姓名</label>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"sex\">\r\n");
        out.write("\t\t\t\t\t\t<span class=\"required\">性别</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input name=\"sex\" type=\"radio\" value=\"male\" checked=\"checked\">男&nbsp;&nbsp;\r\n");
        out.write("\t\t\t\t\t\t<input name=\"sex\" type=\"radio\" value=\"female\">女\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"id_card_numb\">\r\n");
        out.write("\t\t\t\t\t\t<span class=\"required\">身份证号码</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input id=\"id_card_numb\" name=\"id_card_numb\" type=\"text\">\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"id_pict\">\r\n");
        out.write("\t\t\t\t\t\t<span class=\"required\">身份证照片</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t <input type=\"file\" id=\"id_pict\" name=\"uploadFile\" />\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t<ul id=\"typeUl\">\r\n");
        out.write("\t\t\t\t\t</ul>\r\n");
        out.write("\t\t\t\t\t<label>专家类别</label>\r\n");
        out.write("\t\t\t\t\t<select id=\"selectType\">\r\n");
        out.write("\t\t\t\t\t<option value=\"1\" selected=\"selected\">医师</option>\r\n");
        out.write("\t\t\t\t\t<option value=\"2\">药师</option>\r\n");
        out.write("\t\t\t\t\t<option value=\"3\">按摩理疗师</option>\r\n");
        out.write("\t\t\t\t\t<option value=\"4\">心理咨询师</option>\r\n");
        out.write("\t\t\t\t\t<option value=\"5\">健康管理师</option>\r\n");
        out.write("\t\t\t\t\t<option value=\"6\">营养师</option>\r\n");
        out.write("\t\t\t\t\t</select>\r\n");
        out.write("\t\t\t\t\t<button id=\"addType\">添加</button>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"phone\">\r\n");
        out.write("\t\t\t\t\t\t<span class=\"required\">固定电话</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input id=\"phone\" name=\"phone\" type=\"text\">\r\n");
        out.write("\t\t\t\t\t\t<label for=\"phone\" class=\"error\">为能及时联系到您，请输入您的电话号码</label>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"telephone\">\r\n");
        out.write("\t\t\t\t\t\t<span class=\"required\">移动电话</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input id=\"telephone\" name=\"telephone\" type=\"text\">\r\n");
        out.write("\t\t\t\t\t\t<label for=\"telephone\" class=\"error\">为能及时联系到您，请输入您的电话号码</label>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"email\">\r\n");
        out.write("\t\t\t\t\t\t<span class=\"required\">认证邮箱</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input id=\"email\" name=\"email\" type=\"text\">\r\n");
        out.write("\t\t\t\t\t\t<label for=\"email\" class=\"error\">必须是一个有效的邮箱地址</label>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"referrer\">\r\n");
        out.write("\t\t\t\t\t\t<span class=\"required\">推荐人</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input id=\"referrer\" name=\"referrer\" type=\"text\">\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"password\">\r\n");
        out.write("\t\t\t\t\t\t<span class=\"required\">密码</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input name=\"password\" type=\"password\" id=\"password\">\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"confirm_password\">\r\n");
        out.write("\t\t\t\t\t\t<span class=\"required\">重新输入密码</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input type=\"password\" id=\"confirm_password\" name=\"confirm_password\" >\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label class=\"centered info\"><a id=\"forgotpassword\" href=\"#\">找回密码</a>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t</ul>\r\n");
        out.write("\t\t\t</fieldset>\r\n");
        out.write("\t\t\t<fieldset class=\"submit\">\r\n");
        out.write("\t\t\t\t<input type=\"submit\" class=\"submit\" value=\"注册\">\r\n");
        out.write("\t\t\t</fieldset>\r\n");
        out.write("\t\t\t<div class=\"clear\"></div>\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_s_005fform_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fform_005fmethod_005fid_005faction.reuse(_jspx_th_s_005fform_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fform_005fmethod_005fid_005faction.reuse(_jspx_th_s_005fform_005f0);
    return false;
  }
}
