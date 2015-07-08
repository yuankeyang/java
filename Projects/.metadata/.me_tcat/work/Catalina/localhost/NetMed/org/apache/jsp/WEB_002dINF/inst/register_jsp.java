package org.apache.jsp.WEB_002dINF.inst;

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
      out.write("\t\t<h1>服务机构注册</h1>\r\n");
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
    // /WEB-INF/inst/register.jsp(20,2) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fform_005f0.setAction("inst-regi-chec");
    // /WEB-INF/inst/register.jsp(20,2) name = method type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fform_005f0.setMethod("get");
    // /WEB-INF/inst/register.jsp(20,2) name = id type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fform_005f0.setId("inst-reg");
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
        out.write("\t\t\t\t<legend>机构信息</legend>\r\n");
        out.write("\t\t\t\t<ul>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"inst_id\">\r\n");
        out.write("\t\t\t\t\t\t\t<span class=\"required\">机构id</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input id=\"inst_id\" name=\"inst_id\" type=\"text\">\r\n");
        out.write("\t\t\t\t\t\t<label for=\"inst_id\" class=\"error\">请输入9位数的组织机构代码</label>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("                \t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"inst_name\">\r\n");
        out.write("\t\t\t\t\t\t\t<span class=\"required\">机构名称</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input id=\"inst_name\" name=\"inst_name\" type=\"text\">\r\n");
        out.write("\t\t\t\t\t\t<label for=\"inst_name\" class=\"error\">请输入机构名称的全称</label>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"inst_clas\">\r\n");
        out.write("\t\t\t\t\t\t\t<span class=\"required\">机构类别</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input id=\"inst_clas\" name=\"inst_clas\" type=\"text\">\r\n");
        out.write("\t\t\t\t\t\t<label for=\"inst_clas\" class=\"error\">类别指药企、药房、保健机构、餐饮机构等</label>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"busi_scop\">\r\n");
        out.write("\t\t\t\t\t\t\t<span class=\"required\">经营范围</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<textarea id=\"busi_scop\" name=\"busi_scop\" clos=\"30\" rows=\"3\" warp=\"virtual\"></textarea>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"busi_scop\" class=\"error\">请用20以内字加以描述</label>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"lega_repr_name\">\r\n");
        out.write("\t\t\t\t\t\t\t<span class=\"required\">法定代表人姓名</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input id=\"lega_repr_name\" name=\"lega_repr_name\" type=\"text\">\r\n");
        out.write("\t\t\t\t\t\t<label for=\"lega_repr_name\" class=\"error\">请输入真实姓名</label>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"lega_repr_id\">\r\n");
        out.write("\t\t\t\t\t\t\t<span class=\"required\">法定代表人身份证号</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input id=\"lega_repr_id\" name=\"lega_repr_id\" type=\"text\">\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"busi_lice\">\r\n");
        out.write("\t\t\t\t\t\t<span class=\"required\">营业执照扫描件</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t <input id=\"busi_lice\" type=\"file\" name=\"uploadFile\" />\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"orga_code\">\r\n");
        out.write("\t\t\t\t\t\t<span class=\"required\">组织机构代码证扫描件</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t <input id=\"orga_code\" type=\"file\" name=\"uploadFile\" />\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"inst_prov\">\r\n");
        out.write("\t\t\t\t\t\t\t<span class=\"required\">所在省</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input id=\"inst_prov\" name=\"inst_prov\" type=\"text\">\r\n");
        out.write("\t\t\t\t\t\t<label for=\"inst_prov\" class=\"error\">为方便顾客查找，请认真填写</label>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"inst_city\">\r\n");
        out.write("\t\t\t\t\t\t\t<span class=\"required\">所在市</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input id=\"inst_city\" name=\"inst_city\" type=\"text\">\r\n");
        out.write("\t\t\t\t\t\t<label for=\"inst_city\" class=\"error\">为方便顾客查找，请认真填写</label>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"inst_coun\">\r\n");
        out.write("\t\t\t\t\t\t\t<span class=\"required\">所在县（区）</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input id=\"inst_coun\" name=\"inst_coun\" type=\"text\">\r\n");
        out.write("\t\t\t\t\t\t<label for=\"inst_coun\" class=\"error\">为方便顾客查找，请认真填写</label>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"inst_over\">\r\n");
        out.write("\t\t\t\t\t\t\t<span class=\"required\">机构概况</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<textarea name=\"inst_over\" clos=\"100\" rows=\"5\" warp=\"virtual\" style=\"overflow:auto\"></textarea>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"inst_over\" class=\"error\">请输入100以内的汉字进行简要描述</label>\r\n");
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
        out.write("\t\t\t\t\t\t\t<span class=\"required\">认证邮箱</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input id=\"email\" name=\"email\" type=\"text\">\r\n");
        out.write("\t\t\t\t\t\t<label for=\"email\" class=\"error\">必须是一个有效的邮箱地址</label>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"password\">\r\n");
        out.write("\t\t\t\t\t\t\t<span class=\"required\">密码</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input name=\"password\" type=\"password\" id=\"password\">\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("                    <li>\r\n");
        out.write("\t\t\t\t\t\t<label for=\"confirm_password\">\r\n");
        out.write("\t\t\t\t\t\t\t<span class=\"required\">重新输入密码</span>\r\n");
        out.write("\t\t\t\t\t\t</label>\r\n");
        out.write("\t\t\t\t\t\t<input type=\"password\" id=\"confirm_password\" name=\"confirm_password\">\r\n");
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
