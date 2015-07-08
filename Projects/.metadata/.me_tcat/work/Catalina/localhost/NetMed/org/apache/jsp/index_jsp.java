package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.release();
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
      out.write(" \r\n");
      out.write(" \r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/include/core_head.jsp", out, false);
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css0623/index.css\"/>\r\n");
      out.write("<title>主页</title>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/include/head.jsp", out, false);
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");

String info=request.getParameter("reginfo");
if(info!=null) {

      out.write("\r\n");
      out.write("alert(\"注册成功！\");\r\n");

}

      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!--背景图-->\r\n");
      out.write("\t<img class=\"bg-01\" src=\"imgs/bg-01.jpg\"/>\r\n");
      out.write("\t<span class=\"headerBg\"></span>\r\n");
      out.write("\t<span class=\"footerBg\"></span>\r\n");
      out.write("\t<span class=\"indexBgLeft\"></span>\r\n");
      out.write("\t<span class=\"indexBgRight\"></span>\r\n");
      out.write("\t<span class=\"logo\"></span>\r\n");
      out.write("\t<!--首页内容-->\r\n");
      out.write("\t<div class=\"indexCon\">\r\n");
      out.write("\t\t<img class=\"logo\" src=\"imgs/logo.png\"/>\r\n");
      out.write("\t\t<p class=\"callCen\">\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_s_005fa_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/include/topbar.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!--切换-->\r\n");
      out.write("\t<div class=\"indexFind\">\r\n");
      out.write("\t\t<ul id=\"turnBg\">\r\n");
      out.write("\t\t\t<li id=\"choose1\" value=\"qiuyi\">\r\n");
      out.write("\t\t\t\t<div id=\"choose1\" class=\"con\">\r\n");
      out.write("\t\t\t\t\t<img id=\"choose1\" class=\"top\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/nav_braceTop.png\"/>\r\n");
      out.write("\t\t\t\t\t<span id=\"choose1\">求医</span>\r\n");
      out.write("\t\t\t\t\t<img  id=\"choose1\" class=\"bottom\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/nav_bracebottom.png\"/>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li id=\"choose2\" value=\"wenyao\">\r\n");
      out.write("\t\t\t\t<div class=\"con\" id=\"choose2\">\r\n");
      out.write("\t\t\t\t\t<img id=\"choose2\" class=\"top\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/nav_braceTop.png\"/>\r\n");
      out.write("\t\t\t\t\t<span id=\"choose2\">问药</span>\r\n");
      out.write("\t\t\t\t\t<img id=\"choose2\" class=\"bottom\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/nav_bracebottom.png\"/>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li id=\"choose3\" value=\"yangsheng\">\r\n");
      out.write("\t\t\t\t<div id=\"choose3\" class=\"con\">\r\n");
      out.write("\t\t\t\t\t<img id=\"choose3\" class=\"top\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/nav_braceTop.png\"/>\r\n");
      out.write("\t\t\t\t\t<span id=\"choose3\">养生</span>\r\n");
      out.write("\t\t\t\t\t<img id=\"choose3\" class=\"bottom\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/nav_bracebottom.png\"/>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!--搜索-->\r\n");
      out.write("\t<form id=\"searchIn\"  method=\"get\">\r\n");
      out.write("\t\t<input type=\"text\" name=\"search_str\" id=\"search_str\" maxlength=200 />\r\n");
      out.write("\t\t<input type=\"button\" value=\"搜索\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<div class=\"footer\">\r\n");
      out.write("\t<p>颐健通研发小组</p>\r\n");
      out.write("\t<p>&#169;版权所有 2015-2016</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/include/login.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_s_005fa_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_005fa_005f0 = (org.apache.struts2.views.jsp.ui.AnchorTag) _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_005fa_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fa_005f0.setParent(null);
    // /index.jsp(36,3) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f0.setNamespace("/");
    // /index.jsp(36,3) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f0.setAction("welcome");
    int _jspx_eval_s_005fa_005f0 = _jspx_th_s_005fa_005f0.doStartTag();
    if (_jspx_eval_s_005fa_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fa_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fa_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fa_005f0.doInitBody();
      }
      do {
        out.write("健康咨询平台");
        int evalDoAfterBody = _jspx_th_s_005fa_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fa_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fa_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f0);
    return false;
  }
}
