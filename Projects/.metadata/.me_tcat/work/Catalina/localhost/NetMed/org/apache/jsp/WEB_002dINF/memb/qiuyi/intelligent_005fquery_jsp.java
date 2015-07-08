package org.apache.jsp.WEB_002dINF.memb.qiuyi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class intelligent_005fquery_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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

	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	//String search_str=request.getParameter("search_str");
	String search_str = new String(request.getParameter("search_str")
			.getBytes("iso8859-1"), "utf-8");
	String searchSelect = new String(request.getParameter(
			"searchSelect").getBytes("iso8859-1"), "utf-8");

      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../include/core_head.jsp", out, false);
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../include/topbarhead.jsp", out, false);
      out.write("\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/tab.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/bootstrap.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/main.css\" />\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction myreset() {\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"#sleepQuestion\")[0].reset();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".input_text {\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\twidth: 80px;\r\n");
      out.write("\tborder-color: #000000;\r\n");
      out.write("\tborder-style: solid;\r\n");
      out.write("\tborder-top-width: 0px;\r\n");
      out.write("\tborder-right-width: 0px;\r\n");
      out.write("\tborder-bottom-width: 1px;\r\n");
      out.write("\tborder-left-width: 0px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<title>智能咨询问题</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<!--顶端信息-->\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../include/topbar.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!--中上部分-->\r\n");
      out.write("\t<div id=\"middle\">\r\n");
      out.write("\t\t<!--左端logo-->\r\n");
      out.write("\t\t<div id=\"leftMid\">\r\n");
      out.write("\t\t\t<a href=\"welcome\"><img src=\"image/logo.png\" /> </a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!--左端logo-->\r\n");
      out.write("\t\t<!--右端输入框-->\r\n");
      out.write("\t\t<div id=\"rightMid\">\r\n");
      out.write("\t\t\t<form method=\"get\" id=\"searchForm\">\r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t<div style=\"\">\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" checked=\"checked\" name=\"searchSelect\"\r\n");
      out.write("\t\t\t\t\t\tvalue=\"qiuyi\" /> <label>求医</label> &nbsp;&nbsp;&nbsp; <input\r\n");
      out.write("\t\t\t\t\t\ttype=\"radio\" name=\"searchSelect\" value=\"wenyao\" /> <label>问药</label>\r\n");
      out.write("\t\t\t\t\t&nbsp;&nbsp;&nbsp; <input type=\"radio\" name=\"searchSelect\"\r\n");
      out.write("\t\t\t\t\t\tvalue=\"yangsheng\" /> <label>养生</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!--搜索-->\r\n");
      out.write("\t\t\t\t<div id=\"searchIn\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"search_str\" id=\"search_str\" maxlength=200\r\n");
      out.write("\t\t\t\t\t\tvalue=\"");
      out.print(search_str);
      out.write("\" /> <a href=\"javascript:void(0)\"> <img\r\n");
      out.write("\t\t\t\t\t\tsrc=\"image/normalbutton_a.png\" /> </a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<input style=\"display:none\" />\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!--右端输入框-->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!--中上部分-->\r\n");
      out.write("\r\n");
      out.write("\t<!--查询信息-->\r\n");
      out.write("\t<div class=\"page\">\r\n");
      out.write("\t\t<ul class=\"tab\">\r\n");
      out.write("\t\t\t<li id=\"tab_to_1\" class=\"no\"><a href=\"#\"\r\n");
      out.write("\t\t\t\tonclick=\"tab('tab',2,1)\" onmouseout=\"\">智能咨询</a></li>\r\n");
      out.write("\t\t\t<li id=\"tab_to_2\"><a\r\n");
      out.write("\t\t\t\thref=\"expert_recommendation?search_str=");
      out.print(search_str);
      out.write("&searchSelect=");
      out.print(searchSelect);
      out.write("\"\r\n");
      out.write("\t\t\t\tonclick=\"tab('tab',2,2)\" onmouseout=\"\">专家推荐</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<div id=\"contleft\">\r\n");
      out.write("\t\t\t<img src=\"image/asidepic04.png\" style=\"margin:-60px 0 0 40px\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div style=\"margin-left:450px\">\r\n");
      out.write("\t\t\t<div id=\"tab_mo_1\" style=\"width:600px;\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<form method=\"get\" id=sleepQuestion>\r\n");
      out.write("\t\t\t\t\t\t<p>下面一些问题是关于您最近1个月的睡眠情况，请您按实际情况选择或填写最符合您近1个月实际情况的答案：</p>\r\n");
      out.write("\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t⒈近1个月，晚上上床睡觉通常<input type=\"text\" class=\"input_text\" />&nbsp;点钟。<br />\r\n");
      out.write("\t\t\t\t\t\t\t⒉近1个月，从上床到入睡通常需要<input type=\"text\" class=\"input_text\" />&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t分钟。<br /> ⒊近1个月，通常早上<input type=\"text\" class=\"input_text\" />&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t点起床。<br /> ⒋近1个月，每夜通常实际睡眠<input type=\"text\" class=\"input_text\" />&nbsp;小时（不等于卧床时间）。\r\n");
      out.write("\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t<p>对下列问题请选择1个最适合您的答案</p>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<p>⒌近1个月 ，因下列情况影响睡眠而烦恼：</p>\r\n");
      out.write("\t\t\t\t\t<ul style=\"list-style:none\">\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<ul id=\"a01\" style=\"list-style:none\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>a. 入睡困难（30分钟内不能入睡）</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label> <input name=\"Fruit\" type=\"radio\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t无 </label> <label> <input name=\"Fruit\" type=\"radio\" value=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tchecked=\"checked\" /> &lt;1次/周 </label> <label> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"Fruit\" type=\"radio\" value=\"\" /> 1-2次/周 </label> <label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input name=\"Fruit\" type=\"radio\" value=\"\" /> &ge;1次/周 </label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<ul id=\"a02\" style=\"list-style:none\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>b. 夜间易醒或早醒</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label> <input name=\"Fruit\" type=\"radio\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t无 </label> <label> <input name=\"Fruit\" type=\"radio\" value=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tchecked=\"checked\" /> &lt;1次/周 </label> <label> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"Fruit\" type=\"radio\" value=\"\" /> 1-2次/周 </label> <label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input name=\"Fruit\" type=\"radio\" value=\"\" /> &ge;1次/周 </label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<ul id=\"a03\" style=\"list-style:none\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>C.夜间去厕所</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label> <input name=\"Fruit\" type=\"radio\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t无 </label> <label> <input name=\"Fruit\" type=\"radio\" value=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tchecked=\"checked\" /> &lt;1次/周 </label> <label> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"Fruit\" type=\"radio\" value=\"\" /> 1-2次/周 </label> <label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input name=\"Fruit\" type=\"radio\" value=\"\" /> &ge;1次/周 </label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<ul id=\"a04\" style=\"list-style:none\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>d. 呼吸不畅</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label> <input name=\"Fruit\" type=\"radio\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t无 </label> <label> <input name=\"Fruit\" type=\"radio\" value=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tchecked=\"checked\" /> &lt;1次/周 </label> <label> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"Fruit\" type=\"radio\" value=\"\" /> 1-2次/周 </label> <label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input name=\"Fruit\" type=\"radio\" value=\"\" /> &ge;1次/周 </label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<ul id=\"a05\" style=\"list-style:none\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>e. 咳嗽或鼾声高</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label> <input name=\"Fruit\" type=\"radio\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t无 </label> <label> <input name=\"Fruit\" type=\"radio\" value=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tchecked=\"checked\" /> &lt;1次/周 </label> <label> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"Fruit\" type=\"radio\" value=\"\" /> 1-2次/周 </label> <label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input name=\"Fruit\" type=\"radio\" value=\"\" /> &ge;1次/周 </label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<ul id=\"a06\" style=\"list-style:none\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>f. 感觉冷</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label> <input name=\"Fruit\" type=\"radio\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t无 </label> <label> <input name=\"Fruit\" type=\"radio\" value=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tchecked=\"checked\" /> &lt;1次/周 </label> <label> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"Fruit\" type=\"radio\" value=\"\" /> 1-2次/周 </label> <label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input name=\"Fruit\" type=\"radio\" value=\"\" /> &ge;1次/周 </label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<ul id=\"a07\" style=\"list-style:none\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>g. 感觉热</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label> <input name=\"Fruit\" type=\"radio\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t无 </label> <label> <input name=\"Fruit\" type=\"radio\" value=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tchecked=\"checked\" /> &lt;1次/周 </label> <label> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"Fruit\" type=\"radio\" value=\"\" /> 1-2次/周 </label> <label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input name=\"Fruit\" type=\"radio\" value=\"\" /> &ge;1次/周 </label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<ul id=\"a08\" style=\"list-style:none\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>h. 做恶梦</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label> <input name=\"Fruit\" type=\"radio\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t无 </label> <label> <input name=\"Fruit\" type=\"radio\" value=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tchecked=\"checked\" /> &lt;1次/周 </label> <label> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"Fruit\" type=\"radio\" value=\"\" /> 1-2次/周 </label> <label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input name=\"Fruit\" type=\"radio\" value=\"\" /> &ge;1次/周 </label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<ul id=\"a09\" style=\"list-style:none\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>i. 疼痛不适</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label> <input name=\"Fruit\" type=\"radio\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t无 </label> <label> <input name=\"Fruit\" type=\"radio\" value=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tchecked=\"checked\" /> &lt;1次/周 </label> <label> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"Fruit\" type=\"radio\" value=\"\" /> 1-2次/周 </label> <label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input name=\"Fruit\" type=\"radio\" value=\"\" /> &ge;1次/周 </label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<ul id=\"a10\" style=\"list-style:none\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>j. 其它影响睡眠的事情</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label> <input name=\"Fruit\" type=\"radio\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t无 </label> <label> <input name=\"Fruit\" type=\"radio\" value=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tchecked=\"checked\" /> &lt;1次/周 </label> <label> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"Fruit\" type=\"radio\" value=\"\" /> 1-2次/周 </label> <label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input name=\"Fruit\" type=\"radio\" value=\"\" /> &ge;1次/周 </label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<div style=\"margin-left:60px\">\r\n");
      out.write("\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a\r\n");
      out.write("\t\t\t\t\t\thref=\"intelligent_query2?search_str=");
      out.print(search_str);
      out.write("&searchSelect=");
      out.print(searchSelect);
      out.write("\"><img\r\n");
      out.write("\t\t\t\t\t\tsrc=\"image/largebutton_next.png\" /> </a>\r\n");
      out.write("\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a\r\n");
      out.write("\t\t\t\t\t\thref=\"javascript:void(0)\"><img\r\n");
      out.write("\t\t\t\t\t\tsrc=\"image/largebutton_clear.png\" onclick=\"myreset();\" /> </a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"tab_mo_2\" style=\"display:none\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!--查询信息-->\r\n");
      out.write("\t</br>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/bottom/footer.jsp", out, false);
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
}
