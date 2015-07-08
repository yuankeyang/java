package org.apache.jsp.WEB_002dINF.expe.ToolBox.serachToolBox;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.sql.*;

public final class SpecialRepository_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fa_005fhref;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fa_005fhref = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fa_005fhref.release();
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
      out.write(" \r\n");

	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	String expeId = (String) session.getAttribute("expename");

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.pagination.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\tfunction check() {\r\n");
      out.write("\t\tif ($('#search_ToolBox').val() == \"\") {\r\n");
      out.write("\t\t\talert(\"输入框不能为空!\");\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$('#SerachToolBox').submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".mainContext {\r\n");
      out.write("\twidth: 700px;\r\n");
      out.write("\tmargin-left:80px;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".leftContext {\r\n");
      out.write("    margin-left:10px;\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\twidth: 300px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".rightContext {\r\n");
      out.write("    margin-right:100px;\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("\twidth: 300px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<div><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/left.png\"/>&nbsp;&nbsp;<span style=\"font-family:'仿宋';font-size:30pt\">专业知识库</span>\r\n");
      out.write("\t\t&nbsp;&nbsp;<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/right.png\"/></div>\r\n");
      out.write("\t<div style=\"margin-top:10px\">\r\n");
      out.write("\t\t<a style=\"text-algin:left\" href=\"#\"><font size=\"5\" color=\"#3878DB\">我的专科：</font>&nbsp;<font size=\"4\" color=\"#3878DB\">中医内科>>中医脑病</font></a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"mainContext\"\r\n");
      out.write("\t\tstyle=\"margin-top:80px;width: 80%;font-family:'宋体';font-size:8pt\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"leftContext\">\r\n");
      out.write("\t\t   <h2>中医</h2>\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t   <li class=\"specialRepositoy\"><a  href=\"http://www.zygjw.net/Item/list.asp?id=1227\">中医脑病古籍经典原文</a></li>\r\n");
      out.write("\t\t   <br/>\r\n");
      out.write("\t\t   <li class=\"specialRepositoy\">");
      if (_jspx_meth_s_005fa_005f0(_jspx_page_context))
        return;
      out.write("</li>\r\n");
      out.write("\t\t   <br/>\r\n");
      out.write("\t\t   <li class=\"specialRepositoy\"><a href=\"javascript:void(0)\" onclick=\"alert('正在实现中')\">颐健通脑病数据挖掘资源库</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"rightContext\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t   <h2>西医 </h2>\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t   <li class=\"specialRepositoy\"><a href=\"http://guide.medlive.cn/\">神经科临床指南</a></li>\r\n");
      out.write("\t\t    <br/>\r\n");
      out.write("\t\t   <li class=\"specialRepositoy\"><a  href=\"http://guide.medlive.cn/guideline/list?branch=2\">神经科常用量表</a></li>\r\n");
      out.write("\t\t    <br/>\r\n");
      out.write("\t\t   <li class=\"specialRepositoy\"><a  href=\"http://paper.medlive.cn/\">神经科医学期刊</a></li>\r\n");
      out.write("\t\t   <br/>\r\n");
      out.write("\t\t   <li class=\"specialRepositoy\"><a  href=\"http://disease.medlive.cn/wiki/\">神经科影响图谱</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"Pagination\" class=\"pager\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_s_005fa_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_005fa_005f0 = (org.apache.struts2.views.jsp.ui.AnchorTag) _005fjspx_005ftagPool_005fs_005fa_005fhref.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_005fa_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fa_005f0.setParent(null);
    // /WEB-INF/expe/ToolBox/serachToolBox/SpecialRepository.jsp(67,34) name = href type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f0.setHref("FamousPrescrip");
    int _jspx_eval_s_005fa_005f0 = _jspx_th_s_005fa_005f0.doStartTag();
    if (_jspx_eval_s_005fa_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fa_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fa_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fa_005f0.doInitBody();
      }
      do {
        out.write("名医名家脑病名方验案");
        int evalDoAfterBody = _jspx_th_s_005fa_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fa_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fa_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fa_005fhref.reuse(_jspx_th_s_005fa_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fa_005fhref.reuse(_jspx_th_s_005fa_005f0);
    return false;
  }
}
