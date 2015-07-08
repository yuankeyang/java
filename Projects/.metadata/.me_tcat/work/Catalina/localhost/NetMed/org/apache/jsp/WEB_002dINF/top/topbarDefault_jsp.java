package org.apache.jsp.WEB_002dINF.top;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class topbarDefault_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fa_005fonclick_005fnamespace_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fa_005fonclick_005fnamespace_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fa_005fonclick_005fnamespace_005faction.release();
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
      out.write("    \r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/core_header.jsp", out, false);
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/topbarhead.jsp", out, false);
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>颐健通</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<script>\r\n");
      out.write("function exitFunc(){\r\n");
      out.write("hobj=$.ajax({\r\n");
      out.write("\t\t\turl:'exit',\r\n");
      out.write("\t\t\tsuccess:function(){\r\n");
      out.write("\t\t\t\twindow.parent.location.href=\"welcome\";\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror:function(){alert(\"加载信息错误\");},\r\n");
      out.write("\t\t\tasync:false\r\n");
      out.write("\t\t\t});\r\n");
      out.write("}\r\n");
      out.write("function yijiantong(){\r\n");
      out.write("\twindow.parent.location.href=\"welcome\";\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");

String username=(String)session.getAttribute("username");

if(username==null )//&& cookies==null)
{
	String expename=(String)session.getAttribute("expename");
	if(expename==null){
		String instname=(String)session.getAttribute("instname");
		if(instname==null){

      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(window).load(function(){\r\n");
      out.write("window.parent.location.href=\"welcome\";\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("<!--顶端信息-->\r\n");
      out.write("<div id=\"top\">\r\n");
      out.write("   <div id=\"leftTop\"> ");
      if (_jspx_meth_s_005fa_005f0(_jspx_page_context))
        return;
      out.write("&nbsp;&nbsp;&nbsp;&nbsp; <a href=\"#\" id=\"loginbtn\">登录</a> </div>\r\n");
      out.write("  <div id=\"rightTop\">\r\n");
      out.write("  <ul id=\"navul\">\r\n");
      out.write("  <li>\r\n");
      out.write("   \t<a href=\"#\">注册</a>\r\n");
      out.write("   \t<ul>\r\n");
      out.write("  \t<li>");
      if (_jspx_meth_s_005fa_005f1(_jspx_page_context))
        return;
      out.write("</li>\r\n");
      out.write("  \t<li>");
      if (_jspx_meth_s_005fa_005f2(_jspx_page_context))
        return;
      out.write("</li>\r\n");
      out.write("  \t<li>");
      if (_jspx_meth_s_005fa_005f3(_jspx_page_context))
        return;
      out.write("</li>\r\n");
      out.write("  \t</ul>\r\n");
      out.write("  </li>\r\n");
      out.write("  </ul>\r\n");
      out.write("   </div>\r\n");
      out.write("</div>");
}else{
      out.write("\r\n");
      out.write("<div id=\"top\">\r\n");
      out.write("    <div id=\"leftTop\"><label>你好！ ");
      out.print(instname );
      out.write("</label>&nbsp;&nbsp;<span><a href=\"javascript:void(0)\" onclick=\"exitFunc()\">退出</a></span></div>\r\n");
      out.write("     <div id=\"rightTop\">\r\n");
      out.write("     \r\n");
      out.write(" \t\t");
      if (_jspx_meth_s_005fa_005f4(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\t");
}
}else{
      out.write("\r\n");
      out.write("\t<div id=\"top\">\r\n");
      out.write("    <div id=\"leftTop\"><label>你好！ ");
      out.print(expename );
      out.write("</label>&nbsp;&nbsp;<span><a href=\"javascript:void(0)\" onclick=\"exitFunc()\">退出</a></span></div>\r\n");
      out.write("     <div id=\"rightTop\">\r\n");
      out.write(" \t\t");
      if (_jspx_meth_s_005fa_005f5(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("\t");
} 
      out.write('\r');
      out.write('\n');
}else{
      out.write("\r\n");
      out.write("<div id=\"top\">\r\n");
      out.write("    <div id=\"leftTop\"><label>你好！ ");
      out.print(username );
      out.write("</label>&nbsp;&nbsp;<span><a href=\"javascript:void(0)\" onclick=\"exitFunc()\">退出</a></span></div>\r\n");
      out.write("     <div id=\"rightTop\">\r\n");
      out.write(" \t\t");
      if (_jspx_meth_s_005fa_005f6(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
}
      out.write("\r\n");
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

  private boolean _jspx_meth_s_005fa_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_005fa_005f0 = (org.apache.struts2.views.jsp.ui.AnchorTag) _005fjspx_005ftagPool_005fs_005fa_005fonclick_005fnamespace_005faction.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_005fa_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fa_005f0.setParent(null);
    // /WEB-INF/top/topbarDefault.jsp(45,22) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f0.setNamespace("/");
    // /WEB-INF/top/topbarDefault.jsp(45,22) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f0.setAction("welcome");
    // /WEB-INF/top/topbarDefault.jsp(45,22) name = onclick type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f0.setOnclick("yijiantong()");
    int _jspx_eval_s_005fa_005f0 = _jspx_th_s_005fa_005f0.doStartTag();
    if (_jspx_eval_s_005fa_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fa_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fa_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fa_005f0.doInitBody();
      }
      do {
        out.write('颐');
        out.write('健');
        out.write('通');
        int evalDoAfterBody = _jspx_th_s_005fa_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fa_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fa_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fa_005fonclick_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fa_005fonclick_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fa_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_005fa_005f1 = (org.apache.struts2.views.jsp.ui.AnchorTag) _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_005fa_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fa_005f1.setParent(null);
    // /WEB-INF/top/topbarDefault.jsp(51,7) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f1.setNamespace("/user");
    // /WEB-INF/top/topbarDefault.jsp(51,7) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f1.setAction("user-regi");
    int _jspx_eval_s_005fa_005f1 = _jspx_th_s_005fa_005f1.doStartTag();
    if (_jspx_eval_s_005fa_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fa_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fa_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fa_005f1.doInitBody();
      }
      do {
        out.write("会员注册");
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

  private boolean _jspx_meth_s_005fa_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_005fa_005f2 = (org.apache.struts2.views.jsp.ui.AnchorTag) _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_005fa_005f2.setPageContext(_jspx_page_context);
    _jspx_th_s_005fa_005f2.setParent(null);
    // /WEB-INF/top/topbarDefault.jsp(52,7) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f2.setNamespace("/expe");
    // /WEB-INF/top/topbarDefault.jsp(52,7) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f2.setAction("expe-regi");
    int _jspx_eval_s_005fa_005f2 = _jspx_th_s_005fa_005f2.doStartTag();
    if (_jspx_eval_s_005fa_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fa_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fa_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fa_005f2.doInitBody();
      }
      do {
        out.write("专家注册");
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
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f2);
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
    // /WEB-INF/top/topbarDefault.jsp(53,7) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f3.setNamespace("/inst");
    // /WEB-INF/top/topbarDefault.jsp(53,7) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f3.setAction("inst-regi");
    int _jspx_eval_s_005fa_005f3 = _jspx_th_s_005fa_005f3.doStartTag();
    if (_jspx_eval_s_005fa_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fa_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fa_005f3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fa_005f3.doInitBody();
      }
      do {
        out.write("医疗注册");
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

  private boolean _jspx_meth_s_005fa_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_005fa_005f4 = (org.apache.struts2.views.jsp.ui.AnchorTag) _005fjspx_005ftagPool_005fs_005fa_005fonclick_005fnamespace_005faction.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_005fa_005f4.setPageContext(_jspx_page_context);
    _jspx_th_s_005fa_005f4.setParent(null);
    // /WEB-INF/top/topbarDefault.jsp(63,3) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f4.setNamespace("/");
    // /WEB-INF/top/topbarDefault.jsp(63,3) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f4.setAction("welcome");
    // /WEB-INF/top/topbarDefault.jsp(63,3) name = onclick type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f4.setOnclick("yijiantong()");
    int _jspx_eval_s_005fa_005f4 = _jspx_th_s_005fa_005f4.doStartTag();
    if (_jspx_eval_s_005fa_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fa_005f4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fa_005f4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fa_005f4.doInitBody();
      }
      do {
        out.write('颐');
        out.write('健');
        out.write('通');
        int evalDoAfterBody = _jspx_th_s_005fa_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fa_005f4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fa_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fa_005fonclick_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fa_005fonclick_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f4);
    return false;
  }

  private boolean _jspx_meth_s_005fa_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_005fa_005f5 = (org.apache.struts2.views.jsp.ui.AnchorTag) _005fjspx_005ftagPool_005fs_005fa_005fonclick_005fnamespace_005faction.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_005fa_005f5.setPageContext(_jspx_page_context);
    _jspx_th_s_005fa_005f5.setParent(null);
    // /WEB-INF/top/topbarDefault.jsp(73,3) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f5.setNamespace("/");
    // /WEB-INF/top/topbarDefault.jsp(73,3) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f5.setAction("welcome");
    // /WEB-INF/top/topbarDefault.jsp(73,3) name = onclick type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f5.setOnclick("yijiantong()");
    int _jspx_eval_s_005fa_005f5 = _jspx_th_s_005fa_005f5.doStartTag();
    if (_jspx_eval_s_005fa_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fa_005f5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fa_005f5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fa_005f5.doInitBody();
      }
      do {
        out.write('颐');
        out.write('健');
        out.write('通');
        int evalDoAfterBody = _jspx_th_s_005fa_005f5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fa_005f5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fa_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fa_005fonclick_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fa_005fonclick_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f5);
    return false;
  }

  private boolean _jspx_meth_s_005fa_005f6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_005fa_005f6 = (org.apache.struts2.views.jsp.ui.AnchorTag) _005fjspx_005ftagPool_005fs_005fa_005fonclick_005fnamespace_005faction.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_005fa_005f6.setPageContext(_jspx_page_context);
    _jspx_th_s_005fa_005f6.setParent(null);
    // /WEB-INF/top/topbarDefault.jsp(83,3) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f6.setNamespace("/");
    // /WEB-INF/top/topbarDefault.jsp(83,3) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f6.setAction("welcome");
    // /WEB-INF/top/topbarDefault.jsp(83,3) name = onclick type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f6.setOnclick("yijiantong()");
    int _jspx_eval_s_005fa_005f6 = _jspx_th_s_005fa_005f6.doStartTag();
    if (_jspx_eval_s_005fa_005f6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fa_005f6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fa_005f6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fa_005f6.doInitBody();
      }
      do {
        out.write('颐');
        out.write('健');
        out.write('通');
        int evalDoAfterBody = _jspx_th_s_005fa_005f6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fa_005f6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fa_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fa_005fonclick_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fa_005fonclick_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f6);
    return false;
  }
}
