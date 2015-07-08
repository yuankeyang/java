package org.apache.jsp.WEB_002dINF.memb.myfamily;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class NewMembArchInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../include/core_head.jsp", out, false);
      out.write('\r');
      out.write('\n');

    

	String memb_id = (String) session.getAttribute("username");
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	
	if (memb_id == null) {
		response.sendRedirect(templateUrl);
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<title>新建个人健康档案</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".archInput{\r\n");
      out.write("   border-radius:6px;\r\n");
      out.write("   box-shadow:2px;\r\n");
      out.write("   border-color:#BFA789;\r\n");
      out.write("}\r\n");
      out.write(".archContent{\r\n");
      out.write("   border:1px solid #BFA789;\r\n");
      out.write("   border-radius:10px;\r\n");
      out.write(" \r\n");
      out.write("}\r\n");
      out.write("  .saveButton{\r\n");
      out.write("  color:#fff;font-size:18pt;font-weight:bold;background:#C9B28B;width:80px;\r\n");
      out.write("  border-radius:8px;border:none;\r\n");
      out.write("  }\r\n");
      out.write("  .cancelButton{\r\n");
      out.write("  color:#fff;font-size:18pt;font-weight:bold;background:#C9B28B;width:80px;\r\n");
      out.write("  border-radius:8px;border:none;\r\n");
      out.write("  }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function check(){\r\n");
      out.write("\tif($('#name').val()==\"\"){     //姓名非空\r\n");
      out.write("\t\t$(\"#name\").select();\r\n");
      out.write("\t\t$(\"#name\").focus();\r\n");
      out.write("\t}else if($('#age').val()==\"\"){    //年龄非空\r\n");
      out.write("\t\t$(\"#age\").select();\r\n");
      out.write("\t\t$(\"#age\").focus();\r\n");
      out.write("\t}else if($('#idCardNumber').val()==\"\"){       //证件号非空\r\n");
      out.write("\t\t$(\"#idCardNumber\").select();\r\n");
      out.write("\t\t$(\"#idCardNumber\").focus();\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\t$(\"#membArchInfo\").submit();\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function myreset(){\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#membArchInfo\")[0].reset();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<div><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/left.png\"/>&nbsp;&nbsp;<span style=\"font-family:'FangSong';font-size:30pt;color:#c9b28b;\">电子健康档案\r\n");
      out.write("</span>&nbsp;&nbsp;<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/right.png\"/></div>\r\n");
      out.write("    <span style=\"font-color:#FF0000;font-family:'宋体';font-size:24pt;bold;margin-left:250px\">[请完善电子健康档案]</span>\r\n");
      out.write("    \r\n");
      out.write("    <form action=\"NewMembArchInfoAction\" id=\"membArchInfo\" method=\"post\">\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"archContent\" style=\"margin-top:30px;width:700px;margin-left:30px\">\r\n");
      out.write("\t\t<div style=\"padding-top:5px;margin-left:30px\">\r\n");
      out.write("\t\t\t<div style=\"margin-left:50px\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label>[姓名]</label> <input type=\"text\" style=\"width:80px;\" name=\"name\" id=\"name\" class=\"archInput\"/>\r\n");
      out.write("\t\t\t\t&nbsp; &nbsp; \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label>[性别]</label> \r\n");
      out.write("\t\t\t\t<select id=\"sex\" style=\"width:50px\" name=\"sex\" class=\"archInput\">\r\n");
      out.write("\t\t\t\t\t<option  value=\"male\" selected=\"selected\">男</option>\r\n");
      out.write("\t\t\t\t\t<option  value=\"female\" >女</option>\r\n");
      out.write("\t\t\t\t</select> &nbsp; &nbsp; \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label>[年龄]</label> <input type=\"text\" style=\"width:40px\" id=\"age\" name=\"age\" class=\"archInput\"/> &nbsp; &nbsp;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label>[医保类型]</label>\r\n");
      out.write("\t\t\t\t<select id=\"meditype\" name=\"meditype\" style=\"width:105px\" class=\"archInput\">\r\n");
      out.write("\t\t\t\t\t<option  selected=\"selected\" value=\"1\">职工医保</option>\r\n");
      out.write("\t\t\t\t\t<option  value=\"2\">大学生医保</option>\r\n");
      out.write("\t\t\t\t\t<option  value=\"3\">城镇医疗保险</option>\r\n");
      out.write("\t\t\t\t\t<option  value=\"4\">农村医疗保险</option>\r\n");
      out.write("\t\t\t\t</select> \r\n");
      out.write("\t\t\t\t<br /> <br /> \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label>[证件类型]</label> \r\n");
      out.write("\t\t\t\t<select id=\"licence\" style=\"width:83px\" name=\"licence\" class=\"archInput\">\r\n");
      out.write("\t\t\t\t\t<option  selected=\"selected\" value=\"idCardNumber1\">身份证</option>\r\n");
      out.write("\t\t\t\t\t<option  value=\"idCardNumber2\">老年证</option>\r\n");
      out.write("\t\t\t\t\t<option  value=\"idCardNumber3\">残疾证</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t&nbsp; &nbsp;\r\n");
      out.write("\t\t\t\t<label>[证件号码]</label>  \r\n");
      out.write("\t\t\t\t<input type=\"text\" style=\"width:300px\" id=\"idCardNumber\" name=\"idCardNumber\" class=\"archInput\"/>\r\n");
      out.write("\t\t\t\t<br /> <br /> \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t <label>[户籍]</label>\r\n");
      out.write("                 <input type=\"text\" style=\"width:75px\" name=\"province\" id=\"province\" class=\"archInput\"/> <label>[省(市,自治区)]</label> &nbsp;\r\n");
      out.write("                 <input type=\"text\" style=\"width:75px\" name=\"city\" id=\"city\" class=\"archInput\"/> <label>[市(自治州,旗)]</label>&nbsp; \r\n");
      out.write("                 <input type=\"text\" style=\"width:75px\" name=\"county\" id=\"county\" class=\"archInput\"/> <label>[县(区)]</label> \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t <br/> <br/>\r\n");
      out.write("\t\t\t\t<label>[住址]</label> \r\n");
      out.write("\t\t\t\t<input type=\"text\" style=\"width:510px\" name=\"address\" id=\"address\" class=\"archInput\"/> <br /> <br /> \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label>[职业]</label>\r\n");
      out.write("\t\t\t\t<input type=\"text\" style=\"width:110px\" name=\"occupation\" id=\"occupation\" class=\"archInput\"/> &nbsp; &nbsp; \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label>[婚姻状况]</label> \r\n");
      out.write("\t\t\t\t<select style=\"width:70px\" id=\"marriage\" name=\"marriage\" class=\"archInput\">\r\n");
      out.write("\t\t\t\t\t<option value=\"married\">已婚</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"Nmarried\" selected=\"selected\">未婚</option>\r\n");
      out.write("\t\t\t\t</select> &nbsp; &nbsp; \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label>[电话号码]</label> <input type=\"text\"\r\n");
      out.write("\t\t\t\t\tstyle=\"width:130px\" name=\"telephone\" id=\"telephone\" class=\"archInput\"/>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<div style=\"margin-top:30px\">\r\n");
      out.write("\t\t\t\t\t\t<label style=\"font-size:18px\">[药物/食物过敏史]</label>&nbsp;300字以内\r\n");
      out.write("\t\t\t\t\t<textarea id=\"guomin\" name=\"guomin\" class=\"archInput\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"width:555px;height:100px;overflow-y:scroll;resize:none;margin-left:20px 0 0 0;border:solid 2px #BFA789\"></textarea>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div style=\"margin-top:30px\">\r\n");
      out.write("\t\t\t\t\t\t<label style=\"font-size:18px\">[个人病史]</label>&nbsp;500字以内\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t<textarea id=\"pers_hist\" name=\"pers_hist\" class=\"archInput\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"width:555px;height:100px;overflow-y:scroll;resize:none;margin-left:20px 0 0 0;border:solid 2px #BFA789\"></textarea>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div style=\"margin-top:30px\">\r\n");
      out.write("\t\t\t\t\t<label style=\"font-size:18px\">[家族病史]</label>&nbsp;500字以内\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t<textarea id=\"fami_hist\" name=\"fami_hist\" class=\"archInput\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"width:555px;height:100px;overflow-y:scroll;resize:none;margin-left:20px 0 0 0;border:solid 2px #BFA789\"></textarea>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div style=\"margin-left:180px;margin-top:15px\">\r\n");
      out.write("\t\t\t\t    <button class=\"saveButton\" onclick=\"check();\">保存</button>&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t    <button class=\"cancelButton\" onclick=\"myreset();\">取消</button>\r\n");
      out.write("\t\t\t\t\t");
      out.write(" &nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("  </form> \r\n");
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
