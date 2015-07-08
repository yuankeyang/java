package org.apache.jsp.WEB_002dINF.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class topbar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("     \r\n");
 String templateUrl = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath(); 
      out.write('\r');
      out.write('\n');
 
 String membId = (String) session.getAttribute("username");
 String expeId = (String) session.getAttribute("expename");
 String inst=(String) session.getAttribute("instname");
  
      out.write('\r');
      out.write('\n');
 if(membId!=null){ 
      out.write("\r\n");
      out.write("\t\t<li>");
      //  s:a
      org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_005fa_005f0 = (org.apache.struts2.views.jsp.ui.AnchorTag) _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
      _jspx_th_s_005fa_005f0.setPageContext(_jspx_page_context);
      _jspx_th_s_005fa_005f0.setParent(null);
      // /WEB-INF/include/topbar.jsp(11,6) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fa_005f0.setNamespace("/user");
      // /WEB-INF/include/topbar.jsp(11,6) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fa_005f0.setAction("user-center");
      int _jspx_eval_s_005fa_005f0 = _jspx_th_s_005fa_005f0.doStartTag();
      if (_jspx_eval_s_005fa_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_s_005fa_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_s_005fa_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_s_005fa_005f0.doInitBody();
        }
        do {
          out.print(membId );
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
        return;
      }
      _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f0);
      out.write("</li>\r\n");
      out.write("\t\t<li>");
      if (_jspx_meth_s_005fa_005f1(_jspx_page_context))
        return;
      out.write("</li>\r\n");
      out.write("\t\t");
 }else if(expeId!=null){
      out.write("\r\n");
      out.write("\t\t<li>");
      //  s:a
      org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_005fa_005f2 = (org.apache.struts2.views.jsp.ui.AnchorTag) _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
      _jspx_th_s_005fa_005f2.setPageContext(_jspx_page_context);
      _jspx_th_s_005fa_005f2.setParent(null);
      // /WEB-INF/include/topbar.jsp(14,6) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fa_005f2.setNamespace("/expe");
      // /WEB-INF/include/topbar.jsp(14,6) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fa_005f2.setAction("expe-center");
      int _jspx_eval_s_005fa_005f2 = _jspx_th_s_005fa_005f2.doStartTag();
      if (_jspx_eval_s_005fa_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_s_005fa_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_s_005fa_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_s_005fa_005f2.doInitBody();
        }
        do {
          out.print(expeId );
          int evalDoAfterBody = _jspx_th_s_005fa_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_s_005fa_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_s_005fa_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f2);
        return;
      }
      _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f2);
      out.write("</li>\r\n");
      out.write("\t\t<li>");
      if (_jspx_meth_s_005fa_005f3(_jspx_page_context))
        return;
      out.write("</li>\r\n");
      out.write("\t\t");
} else if(inst!=null){
      out.write("\r\n");
      out.write("\t\t<li>");
      //  s:a
      org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_005fa_005f4 = (org.apache.struts2.views.jsp.ui.AnchorTag) _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
      _jspx_th_s_005fa_005f4.setPageContext(_jspx_page_context);
      _jspx_th_s_005fa_005f4.setParent(null);
      // /WEB-INF/include/topbar.jsp(17,6) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fa_005f4.setNamespace("/inst");
      // /WEB-INF/include/topbar.jsp(17,6) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fa_005f4.setAction("inst-center");
      int _jspx_eval_s_005fa_005f4 = _jspx_th_s_005fa_005f4.doStartTag();
      if (_jspx_eval_s_005fa_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_s_005fa_005f4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_s_005fa_005f4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_s_005fa_005f4.doInitBody();
        }
        do {
          out.print(inst );
          int evalDoAfterBody = _jspx_th_s_005fa_005f4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_s_005fa_005f4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_s_005fa_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f4);
        return;
      }
      _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f4);
      out.write("</li>\r\n");
      out.write("\t\t<li>");
      if (_jspx_meth_s_005fa_005f5(_jspx_page_context))
        return;
      out.write("</li>\r\n");
      out.write("\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t<li><a id=\"login-btn\" href=\"javascript:void(0)\">登录</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\">注册</a>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li>");
      if (_jspx_meth_s_005fa_005f6(_jspx_page_context))
        return;
      out.write("</li>\r\n");
      out.write("\t\t\t\t\t<li>");
      if (_jspx_meth_s_005fa_005f7(_jspx_page_context))
        return;
      out.write("</li>\r\n");
      out.write("\t\t\t\t\t<li>");
      if (_jspx_meth_s_005fa_005f8(_jspx_page_context))
        return;
      out.write("</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t");
}
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

  private boolean _jspx_meth_s_005fa_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_005fa_005f1 = (org.apache.struts2.views.jsp.ui.AnchorTag) _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_005fa_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fa_005f1.setParent(null);
    // /WEB-INF/include/topbar.jsp(12,6) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f1.setNamespace("/");
    // /WEB-INF/include/topbar.jsp(12,6) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f1.setAction("exit");
    int _jspx_eval_s_005fa_005f1 = _jspx_th_s_005fa_005f1.doStartTag();
    if (_jspx_eval_s_005fa_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fa_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fa_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fa_005f1.doInitBody();
      }
      do {
        out.write('退');
        out.write('出');
        int evalDoAfterBody = _jspx_th_s_005fa_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fa_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fa_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f1);
    return false;
  }

  private boolean _jspx_meth_s_005fa_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_005fa_005f3 = (org.apache.struts2.views.jsp.ui.AnchorTag) _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_005fa_005f3.setPageContext(_jspx_page_context);
    _jspx_th_s_005fa_005f3.setParent(null);
    // /WEB-INF/include/topbar.jsp(15,6) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f3.setNamespace("/");
    // /WEB-INF/include/topbar.jsp(15,6) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f3.setAction("exit");
    int _jspx_eval_s_005fa_005f3 = _jspx_th_s_005fa_005f3.doStartTag();
    if (_jspx_eval_s_005fa_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fa_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fa_005f3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fa_005f3.doInitBody();
      }
      do {
        out.write('退');
        out.write('出');
        int evalDoAfterBody = _jspx_th_s_005fa_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fa_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fa_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f3);
    return false;
  }

  private boolean _jspx_meth_s_005fa_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_005fa_005f5 = (org.apache.struts2.views.jsp.ui.AnchorTag) _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_005fa_005f5.setPageContext(_jspx_page_context);
    _jspx_th_s_005fa_005f5.setParent(null);
    // /WEB-INF/include/topbar.jsp(18,6) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f5.setNamespace("/");
    // /WEB-INF/include/topbar.jsp(18,6) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f5.setAction("exit");
    int _jspx_eval_s_005fa_005f5 = _jspx_th_s_005fa_005f5.doStartTag();
    if (_jspx_eval_s_005fa_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fa_005f5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fa_005f5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fa_005f5.doInitBody();
      }
      do {
        out.write('退');
        out.write('出');
        int evalDoAfterBody = _jspx_th_s_005fa_005f5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fa_005f5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fa_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f5);
    return false;
  }

  private boolean _jspx_meth_s_005fa_005f6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_005fa_005f6 = (org.apache.struts2.views.jsp.ui.AnchorTag) _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_005fa_005f6.setPageContext(_jspx_page_context);
    _jspx_th_s_005fa_005f6.setParent(null);
    // /WEB-INF/include/topbar.jsp(23,9) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f6.setNamespace("/user");
    // /WEB-INF/include/topbar.jsp(23,9) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f6.setAction("user-regi");
    int _jspx_eval_s_005fa_005f6 = _jspx_th_s_005fa_005f6.doStartTag();
    if (_jspx_eval_s_005fa_005f6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fa_005f6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fa_005f6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fa_005f6.doInitBody();
      }
      do {
        out.write("会员注册");
        int evalDoAfterBody = _jspx_th_s_005fa_005f6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fa_005f6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fa_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f6);
    return false;
  }

  private boolean _jspx_meth_s_005fa_005f7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_005fa_005f7 = (org.apache.struts2.views.jsp.ui.AnchorTag) _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_005fa_005f7.setPageContext(_jspx_page_context);
    _jspx_th_s_005fa_005f7.setParent(null);
    // /WEB-INF/include/topbar.jsp(24,9) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f7.setNamespace("/expe");
    // /WEB-INF/include/topbar.jsp(24,9) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f7.setAction("expe-regi");
    int _jspx_eval_s_005fa_005f7 = _jspx_th_s_005fa_005f7.doStartTag();
    if (_jspx_eval_s_005fa_005f7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fa_005f7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fa_005f7.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fa_005f7.doInitBody();
      }
      do {
        out.write("专家注册");
        int evalDoAfterBody = _jspx_th_s_005fa_005f7.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fa_005f7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fa_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f7);
    return false;
  }

  private boolean _jspx_meth_s_005fa_005f8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_005fa_005f8 = (org.apache.struts2.views.jsp.ui.AnchorTag) _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_005fa_005f8.setPageContext(_jspx_page_context);
    _jspx_th_s_005fa_005f8.setParent(null);
    // /WEB-INF/include/topbar.jsp(25,9) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f8.setNamespace("/inst");
    // /WEB-INF/include/topbar.jsp(25,9) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f8.setAction("inst-regi");
    int _jspx_eval_s_005fa_005f8 = _jspx_th_s_005fa_005f8.doStartTag();
    if (_jspx_eval_s_005fa_005f8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fa_005f8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fa_005f8.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fa_005f8.doInitBody();
      }
      do {
        out.write("机构注册");
        int evalDoAfterBody = _jspx_th_s_005fa_005f8.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fa_005f8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fa_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f8);
    return false;
  }
}
