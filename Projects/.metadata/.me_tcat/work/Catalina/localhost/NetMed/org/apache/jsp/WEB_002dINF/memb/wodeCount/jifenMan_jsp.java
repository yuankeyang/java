package org.apache.jsp.WEB_002dINF.memb.wodeCount;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class jifenMan_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".table_green {\r\n");
      out.write("\tborder-collapse: collapse;\r\n");
      out.write("}\r\n");

   String templateUrl = request.getScheme() + "://"
		+ request.getHeader("host") + request.getContextPath();
    request.setAttribute("url", templateUrl);

      out.write("\r\n");
      out.write(".table_green td {\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("\tborder-bottom: 1px #e6e6e6 dashed;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".table.dataintable {\r\n");
      out.write("\tborder: 1px solid #888888;\r\n");
      out.write("\tborder-collapse: collapse;\r\n");
      out.write("\tmargin: 5px 40px;\r\n");
      out.write("\twidth: 60%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".table.dataintable th {\r\n");
      out.write("\tbackground-color: #CCCCCC;\r\n");
      out.write("\tpadding: 2px 2px 2px 2px;\r\n");
      out.write("\tvertical-align: baseline;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".div.h3 {\r\n");
      out.write("\tpadding: 2px 2px 2px 10px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("div.datadiv {\r\n");
      out.write("\tpadding: 2px 2px 2px 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("div.grouplistdiv {\r\n");
      out.write("\tpadding: 2px 2px 2px 20px;\r\n");
      out.write("\tmargin: 5px 20px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\tgetPayInfo();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function getPayInfo(){\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("        url : '");
      out.print(templateUrl);
      out.write("/user/getPayInfo',\r\n");
      out.write("        type : 'POST',\r\n");
      out.write("        contentType: \"application/x-www-form-urlencoded; charset=utf-8\", \r\n");
      out.write("\t\tdataType : 'json',\r\n");
      out.write("\t\ttimeout : 8000,\r\n");
      out.write("\t\tcache : true,\r\n");
      out.write("\t\terror : erryFunction, //错误执行方法  \r\n");
      out.write("\t\tsuccess : succFunction\t//成功执行方法  \r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction erryFunction() {alert(\"请刷新页面!!\");}\r\n");
      out.write("\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t$('#credit').html(data.credit);\r\n");
      out.write("\t\t\t$('#money').html(data.money);\r\n");
      out.write("\t};\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function doExchange(){\r\n");
      out.write("    $.ajax({\r\n");
      out.write("        url : '");
      out.print(templateUrl);
      out.write("/jiFenExchange',\r\n");
      out.write("\t\ttype : 'POST',\r\n");
      out.write("\t\tcontentType : \"application/json; charset=utf-8\",\r\n");
      out.write("\t\tdataType : 'json',\r\n");
      out.write("\t\ttimeout : 10000,\r\n");
      out.write("\t\tcache : true,\r\n");
      out.write("\t\terror : erryFunction, //错误执行方法  \r\n");
      out.write("\t\tsuccess : succFunction\r\n");
      out.write("\t//成功执行方法  \r\n");
      out.write("\t});\r\n");
      out.write("\tfunction erryFunction() {\r\n");
      out.write("\t\talert(\"有错误，请刷新页面\");\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction succFunction(data) {\r\n");
      out.write("\t\t//未读消息条数\r\n");
      out.write("\t\t  // 为什么用命名空间不可以 user/user-center\r\n");
      out.write("\t\t  window.location.href=\"");
      out.print(templateUrl);
      out.write("/user/user-center\";\r\n");
      out.write("\t\t  }\r\n");
      out.write("}\t\r\n");
      out.write("</script>\r\n");
      out.write("<div class=\"scenterMain\" style=\"min-height: 0px;\">\r\n");
      out.write("\t<link href=\"http://i1.hdfimg.com/400/css/n_business.css\"\r\n");
      out.write("\t\trel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<div class=\"funds-query f14\">\r\n");
      out.write("\t\t<div class=\"funds-query-title\">\r\n");
      out.write("\t\t\t<h3>积分账户管理</h3>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"p10\">\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t<span>积分账户余额：&nbsp;<a href=\"javascript:void(0)\" id=\"credit\"></a>&nbsp;积分</span> <span\r\n");
      out.write("\t\t\t\t\tstyle=\"position:relative;left:150px;\"> 咨询点余额: <span\r\n");
      out.write("\t\t\t\t\tclass=\"orange fb\" style=\"left: 20px;\">0</span>点 <a href=\"#\"\r\n");
      out.write("\t\t\t\t\ttarget=\"_blank\" class=\"unl gray2\">什么是咨询点？</a> </span>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"myAdvisory-box mt10 pr\">\r\n");
      out.write("\t\t\t<ul class=\"myAdvisory-menu clearfix f14\">\r\n");
      out.write("\t\t\t\t<li class=\"myAdvisory-menu-active\"><a style=\"cursor:pointer\">兑换中心</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">积分明细</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"p15\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<h3>现金账户兑换到积分账户:</h3>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<form id=\"submit\" method=\"post\" action=\"#\">\r\n");
      out.write("\t\t\t\t\t\t<li class=\"mt5\">您的现金账户余额为:&nbsp;<a href=\"javascript:void(0)\" id=\"money\"></a>&nbsp;元（现金与积分的兑换比例为：5元=10积分）</li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"mt5\">请填写您要兑换的金额：<input type=\"text\" id=\"money\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"money\" class=\"recharge-input\" onkeyup=\"changeNotice()\"\r\n");
      out.write("\t\t\t\t\t\t\tonchange=\"changeNotice()\">元</li>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<div class=\"ml169\">\r\n");
      out.write("\t\t\t\t\t<p class=\"mt10 mb10\">\r\n");
      out.write("\t\t\t\t\t\t<input id=\"content\" type=\"checkbox\" checked=\"\"> <a\r\n");
      out.write("\t\t\t\t\t\t\thref=\"#\">同意颐健通在线积分服务条款</a>\r\n");
      out.write("\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t<!--  \r\n");
      out.write("\t\t\t\t\t<form action=\"jiFenChange\" id=\"jiFenChange\" name=\"jiFenChange\"  method=\"post\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"确定\"> \r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t-->\r\n");
      out.write("\t\t\t\t\t<a href=\"#\" onclick=\"doExchange()\" class=\"recharge-submit\">确认兑换</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"mt20\">\r\n");
      out.write("\t\t\t\t<h3 class=\"mb5\">积分的获取以及常见问题：</h3>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li class=\"clearfix mb5\"><span class=\"fl\">1.充值到现金账户，在下面的兑换中心，进行兑换；</span>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" class=\"phonePop-btn fb fr\"> <span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"phonePop-btn-l\"><span\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"phonePop-btn-r phonePop-blue\">去充值</span>\r\n");
      out.write("\t\t\t\t\t\t</span> </a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"clearfix mb5\"><span class=\"fl\">2.了解更多积分规则。</span> <a\r\n");
      out.write("\t\t\t\t\t\thref=\"#\" class=\"phonePop-btn fb fr\"> <span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"phonePop-btn-l\"><span\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"phonePop-btn-r phonePop-blue\">去查看</span>\r\n");
      out.write("\t\t\t\t\t\t</span> </a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"display:none;\" id=\"footer\"></div>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var isSubmitting = false;\r\n");
      out.write("function doSubmit()\r\n");
      out.write("{\r\n");
      out.write("    if(!isSubmitting)\r\n");
      out.write("    {\r\n");
      out.write("        if(changeNotice()) {\r\n");
      out.write("            if($('#content').attr('checked')) {\r\n");
      out.write("                isSubmitting = true;\r\n");
      out.write("                $('#submit').submit();\r\n");
      out.write("                return false;\r\n");
      out.write("            }\r\n");
      out.write("            else {\r\n");
      out.write("                $('#message').html('请参看颐健通在线积分服务条款，勾选同意后才能提交');\r\n");
      out.write("                isSubmitting = false;\r\n");
      out.write("                return false;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("function changeNotice()\r\n");
      out.write("{\r\n");
      out.write("    var m = $('#from').val();\r\n");
      out.write("    var o = $('#overage').html();\r\n");
      out.write("    var i = 0;\r\n");
      out.write("    var io = $('#to');\r\n");
      out.write("    var ms = $('#message');\r\n");
      out.write("    if(/^[0-9]*[1-9][0-9]*$/.test(m)) {\r\n");
      out.write("        if(o-m >= 0) {\r\n");
      out.write("            i = m*100;\r\n");
      out.write("            io.html(i);\r\n");
      out.write("            ms.html('&nbsp;');\r\n");
      out.write("            return true;\r\n");
      out.write("        }\r\n");
      out.write("        else {\r\n");
      out.write("            io.html(i);\r\n");
      out.write("            ms.html('填写的金额超过了现金余额能兑换的最大额度，请重新填写');\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    else if( m !== '' ) {\r\n");
      out.write("        io.html(i);\r\n");
      out.write("        ms.html('填写的内容不是数字 请填写正整数');\r\n");
      out.write("        return false;\r\n");
      out.write("    }\r\n");
      out.write("    else {\r\n");
      out.write("        io.html(i);\r\n");
      out.write("        ms.html('请您填写要兑换的金额');\r\n");
      out.write("        return false;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("</script>");
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
