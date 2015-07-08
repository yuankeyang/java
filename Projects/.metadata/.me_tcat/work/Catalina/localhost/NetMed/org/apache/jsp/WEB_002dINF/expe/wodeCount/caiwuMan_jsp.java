package org.apache.jsp.WEB_002dINF.expe.wodeCount;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class caiwuMan_jsp extends org.apache.jasper.runtime.HttpJspBase
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

String basepath = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath();
 
      out.write("\r\n");
      out.write("<div class=\"funds-query f14\">\r\n");
      out.write("    <div class=\"funds-query-title\"><h3>账户资金查询</h3></div>\r\n");
      out.write("    <div class=\"clearfix p10\">\r\n");
      out.write("        <span class=\"fl\">现金账户可用余额：<span class=\"orange fb\">0.00</span>元</span>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<div class=\"myAdvisory-box mt10\">\r\n");
      out.write("    <ul class=\"myAdvisory-menu clearfix f14\">\r\n");
      out.write("        <li class=\"myAdvisory-menu-active\"><a href=\"#\">充值中心</a></li>\r\n");
      out.write("<li><a href=\"#\">账户明细</a></li>\r\n");
      out.write("<li><a href=\"#\">账户信息</a></li>\r\n");
      out.write("<li><a href=\"#\">充值帮助</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</div>\r\n");
      out.write("    \r\n");
      out.write("    <div class=\"presentRecharge-present mt10\">\r\n");
      out.write("<div class=\"banks_bar mt10\">\r\n");
      out.write("    <ul class=\"clearfix f14\" style=\"width:700px\">\r\n");
      out.write("        <li style=\"margin-bottom:10px\" class=\"button_active\"><a href=\"#\">网银/信用卡</a></li>\r\n");
      out.write("        <li style=\"margin-bottom:10px\"><a href=\"#\">支付宝</a></li>\r\n");
      out.write("        <li style=\"margin-bottom:10px\"><a href=\"#\">微信支付</a></li>\r\n");
      out.write("        <li style=\"margin-bottom:10px\"><a href=\"#\">线下汇款</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</div>\r\n");
      out.write("    <div class=\"clearfix mt10\">\r\n");
      out.write("        <link href=\"http://i1.hdfimg.com/userspace/css/payment.5e1c7347.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("<div class=\"fl f12\">\r\n");
      out.write("    <div style=\"margin-left:-10px;\"><img width=\"220px;\" src=\"");
      out.print(basepath );
      out.write("/images/unionpay_all.jpg\"></div>\r\n");
      out.write("    <div class=\"mt10 gray2 mb5\">我们支持更多带有银联标志的银行卡</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"presentRecharge-way p10 bc\" style=\"margin-right: 0px;\">\r\n");
      out.write("    <div class=\"hd f14 fb pb5\">使用银联、网银、信用卡在线充值</div>\r\n");
      out.write("        <div class=\"bd p10 f12\">\r\n");
      out.write("        <form name=\"recharge\" id=\"recharge\" action=\"pay\">\r\n");
      out.write("            <div><p>充值金额：\r\n");
      out.write("            <label><input type=\"text\" id=\"price\" name=\"price\" value=\"\" onkeyup=\"isChecked()\">&nbsp;元</label>\r\n");
      out.write("            <input value=\"充值\" type=\"submit\" class=\"dil presentRecharge-apply my_submit_button\"> \r\n");
      out.write("            <br>\r\n");
      out.write("            <span id=\"msg\" class=\"red ml10\"></span>\r\n");
      out.write("            </p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("        <div class=\"recharge-note mt10\">请输入您要充值的金额，点击充值按钮后将去<span class=\"orange\">银联</span>网站完成支付操作，支付成功后，款项将实时加入到您在颐健通的账户里\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"presentRecharge-note clearfix mt10 f12\">\r\n");
      out.write("              <div>请注意：</div>\r\n");
      out.write("        <div class=\"fl presentRecharge-note-r fn\">\r\n");
      out.write("        <p>如果您在支付过程中遇到任何问题，请联系我们：</p>\r\n");
      out.write("        <p>客服电话(工作日9:30-19:00)&nbsp;&nbsp;4008-900-120&nbsp;&nbsp; 客服邮箱&nbsp;&nbsp; dgssadfu@yijiantong.com</p>\r\n");
      out.write("        </div>\r\n");
      out.write("        <p class=\"dil w\">\r\n");
      out.write("        </p><div class=\"red bold\">\r\n");
      out.write("\r\n");
      out.write("<!--placebeg [space_content_mgr][onlyone][showtelaccount_tip] -->\r\n");
      out.write("\r\n");
      out.write("<!--placeend [space_content_mgr][onlyone][showtelaccount_tip] -->\r\n");
      out.write("</div>\r\n");
      out.write("<br>\r\n");
      out.write("        <p></p>\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>");
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
