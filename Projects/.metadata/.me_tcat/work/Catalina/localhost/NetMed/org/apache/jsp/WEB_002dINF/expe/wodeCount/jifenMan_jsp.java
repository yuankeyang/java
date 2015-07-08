package org.apache.jsp.WEB_002dINF.expe.wodeCount;

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
      out.write("\r\n");
      out.write(".table_green td {\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("\tborder-bottom: 1px #e6e6e6 dashed;\r\n");
      out.write("}\r\n");
      out.write("table.dataintable {\r\n");
      out.write("    border: 1px solid #888888;\r\n");
      out.write("    border-collapse: collapse;\r\n");
      out.write("    margin: 5px 40px;\r\n");
      out.write("    width: 60%;\r\n");
      out.write("}\r\n");
      out.write("table.dataintable th {\r\n");
      out.write("    background-color: #CCCCCC;\r\n");
      out.write("    padding: 2px 2px 2px 2px;\r\n");
      out.write("    vertical-align: baseline;\r\n");
      out.write("}\r\n");
      out.write("div.h3{\r\n");
      out.write("\tpadding: 2px 2px 2px 10px;\r\n");
      out.write("\tfont-weight:bold;\r\n");
      out.write("}\r\n");
      out.write("div.datadiv{\r\n");
      out.write("\tpadding: 2px 2px 2px 20px;\r\n");
      out.write("}\r\n");
      out.write("div.grouplistdiv{\r\n");
      out.write("\tpadding: 2px 2px 2px 20px;\r\n");
      out.write("\tmargin: 5px 20px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<div class=\"scenterMain\" style=\"min-height: 0px;\"> \r\n");
      out.write("<link href=\"http://i1.hdfimg.com/400/css/n_business.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<div class=\"funds-query f14\">\r\n");
      out.write("        <div class=\"funds-query-title\"><h3>积分账户管理</h3></div>\r\n");
      out.write("    <div class=\"p10\">\r\n");
      out.write("    <p><span>积分账户余额：<span class=\"orange fb\">0</span> 积分</span>\r\n");
      out.write("   <span style=\"position:relative;left:150px;\"> 咨询点余额: <span class=\"orange fb\" style=\"left: 20px;\">0</span> 点\r\n");
      out.write("    <a href=\"#\" target=\"_blank\" class=\"unl gray2\">什么是咨询点？</a>  </span>\r\n");
      out.write("    </p> \r\n");
      out.write(" </div>\r\n");
      out.write("    <div class=\"myAdvisory-box mt10 pr\">\r\n");
      out.write("        <ul class=\"myAdvisory-menu clearfix f14\">\r\n");
      out.write("        <li class=\"myAdvisory-menu-active\"><a style=\"cursor:pointer\">兑换中心</a></li>\r\n");
      out.write("        <li><a href=\"#\">积分明细</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"p15\">\r\n");
      out.write("        <div>\r\n");
      out.write("                <h3>现金账户兑换到积分账户:</h3>\r\n");
      out.write("            <ul>\r\n");
      out.write("               <form id=\"submit\" method=\"post\" action=\"#\">\r\n");
      out.write("                    <li class=\"mt5\">您的现金账户余额为&nbsp;<span id=\"overage\" class=\"orange fb\">0.00</span>&nbsp;元（现金与积分的兑换比例为：1元=100积分）</li>\r\n");
      out.write("<li class=\"mt5\">请填写您要兑换的金额：<input type=\"text\" id=\"from\" name=\"money\" class=\"recharge-input\" onkeyup=\"changeNotice()\" onchange=\"changeNotice()\">元 = &nbsp;<span class=\"orange\" id=\"to\">0</span>&nbsp;积分</li><li id=\"message\" style=\"color:red; width:99%\">&nbsp;</li>\r\n");
      out.write("                </form>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <div class=\"ml169\">\r\n");
      out.write("            <p class=\"mt10 mb10\"><input id=\"content\" type=\"checkbox\" checked=\"\"> <a href=\"#\">同意颐健通在线积分服务条款</a></p>\r\n");
      out.write("                <a href=\"#\" onclick=\"return doSubmit()\" class=\"recharge-submit\">确认兑换</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"mt20\">\r\n");
      out.write("    <h3 class=\"mb5\">积分的获取以及常见问题：</h3>\r\n");
      out.write("    <ul>\r\n");
      out.write("        <li class=\"clearfix mb5\">\r\n");
      out.write("        <span class=\"fl\">1.充值到现金账户，在下面的兑换中心，进行兑换；</span>\r\n");
      out.write("        <a href=\"#\" class=\"phonePop-btn fb fr\">\r\n");
      out.write("            <span class=\"phonePop-btn-l\"><span class=\"phonePop-btn-r phonePop-blue\">去充值</span></span>\r\n");
      out.write("        </a>\r\n");
      out.write("        </li><li class=\"clearfix mb5\">\r\n");
      out.write("        <span class=\"fl\">2.了解更多积分规则。</span>\r\n");
      out.write("        <a href=\"#\" class=\"phonePop-btn fb fr\">\r\n");
      out.write("            <span class=\"phonePop-btn-l\"><span class=\"phonePop-btn-r phonePop-blue\">去查看</span></span>\r\n");
      out.write("        </a>\r\n");
      out.write("        </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<div style=\"display:none;\" id=\"footer\"></div>\r\n");
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
