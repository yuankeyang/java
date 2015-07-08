package org.apache.jsp.WEB_002dINF.memb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class center_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005fcssClass_005faction;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005fcssClass_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.release();
    _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005fcssClass_005faction.release();
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/include/core_head.jsp", out, false);
      out.write('\r');
      out.write('\n');

String templateUrl = request.getScheme() + "://"
		+ request.getHeader("host") + request.getContextPath();
String basepath = request.getScheme() + "://"
		+ request.getHeader("host") + request.getContextPath();
String name = (String) session.getAttribute("username"); 
if(name==null){
response.sendRedirect(templateUrl);
return;
}
String times = System.currentTimeMillis() + "";

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>个人中心</title>\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css0623/style.css\" rel=\"stylesheet\">\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/include/head.jsp", out, false);
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t\r\n");
      out.write("var dd='");
      out.print(name);
      out.write("';\r\n");
      out.write("if(dd==null){\r\n");
      out.write("\talert(\"您已不在线，请重新登录！\");\r\n");
      out.write("\twindow.location.reload();\r\n");
      out.write("}else{\r\n");
      out.write("\tgetGeRenInfo();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("$('#menu ul li a').each(function(){\r\n");
      out.write("$(this).click(function(){\r\n");
      out.write("var item=$(this).attr('id');\r\n");
      out.write("$('#secondry iframe').attr('src','");
      out.print(templateUrl);
      out.write("/user/'+item);\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("\t\r\n");
      out.write("function getGeRenInfo(){\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("        url : '");
      out.print(templateUrl);
      out.write("/user/getMembCenData',\r\n");
      out.write("        type : 'POST',\r\n");
      out.write("        contentType: \"application/x-www-form-urlencoded; charset=utf-8\", \r\n");
      out.write("\t\tdataType : 'json',\r\n");
      out.write("\t    timeout : 15000,\r\n");
      out.write("\t\tcache : true,\r\n");
      out.write("\t\terror : erryFunction, //错误执行方法  \r\n");
      out.write("\t\tsuccess : succFunction\t//成功执行方法  \r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction erryFunction() {alert(\"正获取会员信息，请等待3秒后刷新页面!!\");}\r\n");
      out.write("\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t$('#rank').html(data.rank);\r\n");
      out.write("\t\t\t$('#credit').html(data.credit);\r\n");
      out.write("\t\t\t$('#money').html(data.money);\r\n");
      out.write("\t\t\t$('#headImg').attr(\"src\",'");
      out.print(basepath);
      out.write("'+data.head_img+\"?_t");
      out.print(times);
      out.write("\");\r\n");
      out.write("\t\t\t$(\"#records\").append(\"<li>暂无任何通知!</li>\");\r\n");
      out.write("\t};\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"bodycnt\">\r\n");
      out.write("\t\t<div id=\"head\">\r\n");
      out.write("\t\t\t<div class=\"nav\">\r\n");
      out.write("\t\t\t\t<div class=\"logo\">\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/logo.png\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"nav-1\">");
      if (_jspx_meth_s_005fa_005f0(_jspx_page_context))
        return;
      out.write("</div>\r\n");
      out.write("\t\t\t\t<div class=\"nav-2\">\r\n");
      out.write("\t\t\t\t\t<a class=\"name\" href=\"javascript:void(0);\">");
      out.print(name );
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_s_005fa_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"menu\">\r\n");
      out.write("\t\t\t\t<div class=\"cw\">个人中心</div>\r\n");
      out.write("\t\t\t\t<ul class=\"ul-1\">\r\n");
      out.write("\t\t\t\t\t<li class=\"item-1\">\r\n");
      out.write("\t\t\t\t\t\t<h2><span>医疗服务</span></h2>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" id=\"wodeDoc\"><span>我的专家</span></a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" id=\"huanyouSoc\"><span>患友会</span></a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" id=\"jiuyiExp\"><span>就医经验</span></a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"item-2\">\r\n");
      out.write("\t\t\t\t\t\t<h2><span>可穿戴设备</span></h2>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" id=\"myBloodPressure\"><span>我的血压</span></a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" id=\"mySleepRecord\"><span>睡眠记录</span></a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"item-3\">\r\n");
      out.write("\t\t\t\t\t\t<h2><span>疾病管理</span></h2>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" id=\"jibingMan\"><span>离线咨询</span></a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" id=\"myAppointment\"><span>我的预约</span></a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"item-4\">\r\n");
      out.write("\t\t\t\t\t\t<h2><span>我的家属</span></h2>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" id=\"myfamily\"><span>我的家属</span></a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" id=\"membArchInfo\"><span>电子档案</span></a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"item-5\">\r\n");
      out.write("\t\t\t\t\t\t<h2><span>我的账户</span></h2>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" id=\"caiwuMan\"><span>财务管理</span></a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" id=\"jifenMan\"><span>积分管理</span></a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" id=\"gerenInfo\"><span>个人信息</span></a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" id=\"passChange\"><span>修改密码</span></a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"item-5\">\r\n");
      out.write("\t\t\t\t\t\t<h2><span>意见反馈</span></h2>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"content\">\r\n");
      out.write("\t\t\t<div id=\"primary\">\r\n");
      out.write("\t\t\t\t<div class=\"personal-data\">\r\n");
      out.write("\t\t\t\t\t<div id=\"icon\"><img id=\"headImg\" class=\"icon\"/></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"welcome\"><b>");
      out.print(name );
      out.write("</b>,欢迎</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"edit\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" class=\"edit-bnt\">编辑资料</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"acount-detail\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"ul-2\">\r\n");
      out.write("\t\t\t\t\t\t<li class=\"point\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/point.png\">\r\n");
      out.write("\t\t\t\t\t\t\t<div><a href=\"\">积分</a><span id=\"credit\"></span></div>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"balance\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/balance.png\">\r\n");
      out.write("\t\t\t\t\t\t\t<div><a href=\"\">余额</a><span id=\"money\"></span></div>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<li class=\"rate\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/rate.png\">\r\n");
      out.write("\t\t\t\t\t\t\t<div><a href=\"\">等级</a><span id=\"rank\"></span></div>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div id=\"secondry\">\r\n");
      out.write("\t\t\t\t<iframe name=\"rightContent\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/user/wodeCen\"></iframe>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"footer\">\r\n");
      out.write("\t\t\t<p>颐健通研发小组</p>\r\n");
      out.write("\t        <p>&#169;版权所有&nbsp;2015-2016</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
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

  private boolean _jspx_meth_s_005fa_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_005fa_005f0 = (org.apache.struts2.views.jsp.ui.AnchorTag) _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_005fa_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fa_005f0.setParent(null);
    // /WEB-INF/memb/center.jsp(75,23) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f0.setNamespace("/");
    // /WEB-INF/memb/center.jsp(75,23) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f0.setAction("welcome");
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
      _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005faction.reuse(_jspx_th_s_005fa_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fa_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_005fa_005f1 = (org.apache.struts2.views.jsp.ui.AnchorTag) _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005fcssClass_005faction.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_005fa_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fa_005f1.setParent(null);
    // /WEB-INF/memb/center.jsp(78,5) name = cssClass type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f1.setCssClass("logout");
    // /WEB-INF/memb/center.jsp(78,5) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fa_005f1.setNamespace("/");
    // /WEB-INF/memb/center.jsp(78,5) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
      _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005fcssClass_005faction.reuse(_jspx_th_s_005fa_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fa_005fnamespace_005fcssClass_005faction.reuse(_jspx_th_s_005fa_005f1);
    return false;
  }
}
