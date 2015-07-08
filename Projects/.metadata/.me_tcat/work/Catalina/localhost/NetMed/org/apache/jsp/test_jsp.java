package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class test_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/include/core_head.jsp", out, false);
      out.write('\r');
      out.write('\n');

request.getSession().setAttribute("username", "xianggen");
String name = (String) session.getAttribute("username"); 
//name="xianggen";
String templateUrl = request.getScheme() + "://"
		+ request.getHeader("host") + request.getContextPath();
String basepath = request.getScheme() + "://"
		+ request.getHeader("host") + request.getContextPath();
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
      out.write("\t\t\t\t<div class=\"nav-1\">病·医·药咨询养生平台</div>\r\n");
      out.write("\t\t\t\t<div class=\"nav-2\">\r\n");
      out.write("\t\t\t\t\t<a class=\"name\" href=\"javascript:void(0);\">");
      out.print(name );
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t<a class=\"logout\" href=\"\">退出</a>\r\n");
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
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" id=\"jibingMan\"><span>疾病管理</span></a>\r\n");
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
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"balance\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/balance.png\">\r\n");
      out.write("\t\t\t\t\t\t\t<div><a href=\"\">余额</a><span id=\"money\"></span></div>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"rate\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/rate.png\">\r\n");
      out.write("\t\t\t\t\t\t\t<div><a href=\"\">等级</a><span id=\"rank\"></span></div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div id=\"secondry\">\r\n");
      out.write("\t\t\t\t<iframe name=\"rightContent\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/user/wodeCen\">\r\n");
      out.write("\t\t\t\t</iframe>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"footer\">\r\n");
      out.write("\t\t\t<p>版权所有@385794858940</p>\r\n");
      out.write("\t\t\t<p>CopyRight@2015 NiPic.com All Rights Reserved 版权所有·邱健通</p>\r\n");
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
}
