package org.apache.jsp.WEB_002dINF.memb.myfamily;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class updateArchInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	
	String ArchInfo_Id=request.getParameter("ArchInfo_Id"); 

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
      out.write("<title>会员个人电子健康病历</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t\tif('");
      out.print(ArchInfo_Id);
      out.write("'!=\"\"){\r\n");
      out.write("\t\t\t\t\tgetArchInfo('");
      out.print(ArchInfo_Id);
      out.write("');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction getArchInfo(ArchInfo_Id){\r\n");
      out.write("\t\t\t $.ajax({\r\n");
      out.write("\t\t            url : '");
      out.print(templateUrl);
      out.write("/user/ArchInfoForRead?ArchInfo_Id=");
      out.print(ArchInfo_Id);
      out.write("',\r\n");
      out.write("\t\t            type : 'POST',\r\n");
      out.write("\t\t            contentType: \"application/x-www-form-urlencoded; charset=utf-8\", \r\n");
      out.write("\t\t\t\t    dataType : 'json',\r\n");
      out.write("\t\t\t\t    timeout : 8000,\r\n");
      out.write("\t\t\t\t    cache : true,\r\n");
      out.write("\t\t\t\t\terror : erryFunction, //错误执行方法  \r\n");
      out.write("\t\t\t\t\tsuccess : succFunction\t//成功执行方法  \r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\tfunction erryFunction() {alert(\"请刷新页面!!\");}\r\n");
      out.write("\t\t\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t\t\t//alert(data.content);\r\n");
      out.write("\t\t\t\t\t$(\"#ArchInfo_Id\").val(data.ArchInfo_Id);\r\n");
      out.write("\t\t\t\t\t$(\"#name\").val(data.name);\r\n");
      out.write("\t\t\t\t\t$(\"#sex\").val(data.sex);\r\n");
      out.write("\t\t\t\t\t$(\"#idCardNumber\").val(data.idCardNumber);\r\n");
      out.write("\t\t\t\t\t$(\"#address\").val(data.address);\r\n");
      out.write("\t\t\t\t\t$(\"#occupation\").val(data.occupation);\r\n");
      out.write("\t\t\t\t\t$(\"#telephone\").val(data.telephone);\r\n");
      out.write("\t\t\t\t\t$(\"#mariStat\").val(data.mariStat);\r\n");
      out.write("\t\t\t\t\t$(\"#province\").val(data.province);\r\n");
      out.write("\t\t\t\t\t$(\"#city\").val(data.city);\r\n");
      out.write("\t\t\t\t\t$(\"#county\").val(data.county);\r\n");
      out.write("\t\t\t\t\t$(\"#age\").val(data.age);\r\n");
      out.write("\t\t\t\t\t$(\"#guomin\").val(data.guomin);\r\n");
      out.write("\t\t\t\t\t$(\"#fami_hist\").val(data.fami_hist);\r\n");
      out.write("\t\t\t\t\t$(\"#pers_hist\").val(data.pers_hist);\r\n");
      out.write("\t\t\t\t\t$(\"#licence \").val(data.licence );\r\n");
      out.write("\t\t\t\t\t$(\"#meditype\").val(data.meditype);\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
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
      out.write("\t\tupdate();\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function update(){\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t        url : '");
      out.print(templateUrl);
      out.write("/user/UpdateArchInfo',\r\n");
      out.write("\t\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\t\tdata:{\"address\":$('#address').val(),\"age\":$('#age').val(),\"name\":$('#name').val(),\"ArchInfo_Id\":");
      out.print(ArchInfo_Id);
      out.write(",\"sex\":$('#sex').val(),\"idCardNumber\":$('#idCardNumber').val(),\"telephone\":$('#telephone').val(),\"mariStat\":$('#mariStat').val(),\"province\":$('#province').val()\r\n");
      out.write("\t\t\t\t,\"city\":$('#city').val(),\"county\":$('#county').val(),\"occupation\":$('#occupation').val(),\"guomin\":$('#guomin').val(),\"fami_hist\":$('#fami_hist').val(),\"pers_hist\":$('#pers_hist').val(),\"licence\":$('#licence').val(),\"meditype\":$('#meditype').val()},\r\n");
      out.write("\t\t\t\tcontentType: \"application/x-www-form-urlencoded; charset=utf-8\", \r\n");
      out.write("\t\t\t\tdataType : 'text',\r\n");
      out.write("\t\t\t\ttimeout : 8000,\r\n");
      out.write("\t\t\t\tcache : true,\r\n");
      out.write("\t\t\t\terrot:erryFunction,\r\n");
      out.write("\t\t\t\tsuccess : succFunction\r\n");
      out.write("\t\t\t//成功执行方法  \r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\tfunction erryFunction() {\r\n");
      out.write("\t\t\t\talert(\"请刷新页面!!\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t\t//修改成功\r\n");
      out.write("\t\t\t\talert(\"修改成功\");\r\n");
      out.write("\t\t\t\twindow.location=\"membArchInfo\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("function myreset(){\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#membArchInfo\")[0].reset();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <h3 style=\"font-color:#FF0000;margin-left:390px\">请完善电子健康病历</h3>\r\n");
      out.write("\t<div style=\"margin-top:0px\">\r\n");
      out.write("\t\t<div id=\"rightHInfo\" style=\"height:800px;padding-top:5px;margin-left:150px;width:690px\">\r\n");
      out.write("\t\t\t<div style=\"margin-left:50px\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label>姓名</label> <input type=\"text\" style=\"width:85px\" name=\"name\" id=\"name\"/>\r\n");
      out.write("\t\t\t\t&nbsp; &nbsp; \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label>性别</label> \r\n");
      out.write("\t\t\t\t<select id=\"sex\" style=\"width:50px\" name=\"sex\">\r\n");
      out.write("\t\t\t\t\t<option  value=\"male\" selected=\"selected\">男</option>\r\n");
      out.write("\t\t\t\t\t<option  value=\"female\" >女</option>\r\n");
      out.write("\t\t\t\t</select> &nbsp; &nbsp; \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label>年龄</label> <input type=\"text\" style=\"width:50px\" id=\"age\" name=\"age\" /> &nbsp; &nbsp;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label>医保类型</label>\r\n");
      out.write("\t\t\t\t<select id=\"meditype\" name=\"meditype\" style=\"width:120px\">\r\n");
      out.write("\t\t\t\t\t<option  selected=\"selected\" value=\"1\">湖南省职工医保</option>\r\n");
      out.write("\t\t\t\t\t<option  value=\"2\">大学生医保</option>\r\n");
      out.write("\t\t\t\t\t<option  value=\"3\">城镇医疗保险</option>\r\n");
      out.write("\t\t\t\t\t<option  value=\"4\">农村医疗保险</option>\r\n");
      out.write("\t\t\t\t</select> \r\n");
      out.write("\t\t\t\t<br /> <br /> \r\n");
      out.write("\t\t\t\t<label>证件类型</label> \r\n");
      out.write("\t\t\t\t<select id=\"licence\" style=\"width:80px\" name=\"licence\">\r\n");
      out.write("\t\t\t\t\t<option  selected=\"selected\" value=\"idCardNumber1\">身份证</option>\r\n");
      out.write("\t\t\t\t\t<option  value=\"idCardNumber2\">老年证</option>\r\n");
      out.write("\t\t\t\t\t<option  value=\"idCardNumber3\">残疾证</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t&nbsp; &nbsp;\r\n");
      out.write("\t\t\t\t<label>证件号码</label>  \r\n");
      out.write("\t\t\t\t<input type=\"text\" style=\"width:300px\" id=\"idCardNumber\" name=\"idCardNumber\" />\r\n");
      out.write("\t\t\t\t<br /> <br /> \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t <label>户籍</label> &nbsp; &nbsp;\r\n");
      out.write("                 <input type=\"text\" style=\"width:75px\" name=\"province\" id=\"province\"/> <label>省(市,自治区)</label> &nbsp;\r\n");
      out.write("                 <input type=\"text\" style=\"width:75px\" name=\"city\" id=\"city\"/> <label>市(自治州,旗)</label>&nbsp; \r\n");
      out.write("                 <input type=\"text\" style=\"width:75px\" name=\"county\" id=\"county\"/> <label>县(区)</label> \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t <br/> <br/>\r\n");
      out.write("\t\t\t\t<label>住址</label> \r\n");
      out.write("\t\t\t\t<input type=\"text\" style=\"width:507px\" name=\"address\" id=\"address\" /> <br /> <br /> \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label>职业</label>\r\n");
      out.write("\t\t\t\t<input type=\"text\" style=\"width:120px\" name=\"occupation\" id=\"occupation\" /> &nbsp; &nbsp; \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label>婚姻状况</label> <select style=\"width:70px\" id=\"marriage\" name=\"marriage\">\r\n");
      out.write("\t\t\t\t\t<option value=\"married\">已婚</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"Nmarried\" selected=\"selected\">未婚</option>\r\n");
      out.write("\t\t\t\t</select> &nbsp; &nbsp; \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label>电话号码</label> <input type=\"text\"\r\n");
      out.write("\t\t\t\t\tstyle=\"width:146px\" name=\"telephone\" id=\"telephone\" />\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<div style=\"margin-top:30px\">\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/image/angle_blue.png\" />&nbsp;&nbsp;&nbsp;&nbsp; \r\n");
      out.write("\t\t\t\t\t\t<label style=\"font-size:18px\">药物/食物过敏史</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<textarea id=\"guomin\" name=\"guomin\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"width:540px;height:100px;overflow-y:scroll;resize:none;margin-left:20px 0 0 0;border:solid 2px #09F\"></textarea>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div style=\"margin-top:30px\">\r\n");
      out.write("\t\t\t\t\t<div style=\"float:left\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/image/angle_blue.png\" />&nbsp;&nbsp;&nbsp;&nbsp; <label\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"font-size:18px\">个人病史</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\tstyle=\"float:right;text-align:left;margin-right:200px;margin-top:10px\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t<textarea id=\"pers_hist\" name=\"pers_hist\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"width:540px;height:100px;overflow-y:scroll;resize:none;margin-left:20px 0 0 0;border:solid 2px #09F\"></textarea>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"margin-top:30px\">\r\n");
      out.write("\t\t\t\t\t<div style=\"float:left\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/image/angle_blue.png\" />&nbsp;&nbsp;&nbsp;&nbsp; <label\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"font-size:18px\">家族病史</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t<textarea id=\"fami_hist\" name=\"fami_hist\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"width:540px;height:100px;overflow-y:scroll;resize:none;margin-left:20px 0 0 0;border:solid 2px #09F\"></textarea>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"mysubmit\" style=\"margin-left:180px;margin-top:15px\">\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/image/buttonnormal_save.png\" onclick=\"check();\"/> &nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/image/buttonnormal_quite.png\" onclick=\"myreset();\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
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
