package org.apache.jsp.WEB_002dINF.expe.gerenMan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.sql.*;

public final class myappoint_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");

	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	String name = (String) session.getAttribute("expename");

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css0623/style.css\"/>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    function getAppointMent(){\r\n");
      out.write("\t  // var data=encodeURIComponent(JSON.stringify($('#input_doctor').val()),\"utf-8\");\r\n");
      out.write("\t  // alert(encodeURI(encodeURI($('#input_doctor').val())));//验证是否在线\r\n");
      out.write("\t    $.ajax({\r\n");
      out.write("\t        url : '");
      out.print(templateUrl);
      out.write("/expe/AppointMentBriefForRead',\r\n");
      out.write("\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\tcontentType : \"application/json; charset=utf-8\",\r\n");
      out.write("\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\ttimeout : 8000,\r\n");
      out.write("\t\t\tcache : true,\r\n");
      out.write("\t\t\terror : erryFunction, //错误执行方法  \r\n");
      out.write("\t\t\tsuccess : succFunction\r\n");
      out.write("\t\t//成功执行方法  \r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction erryFunction() {\r\n");
      out.write("\t\t\talert(\"请刷新页面\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t//未读消息条数\r\n");
      out.write("\t\t\tvar num = data.acount;\r\n");
      out.write("\t\t\t$('#acceptAccount').html(data.acceptAccount);\r\n");
      out.write("\t\t\t$('#rejectAccount').html(data.rejectAccount);\r\n");
      out.write("\t\t\t//alert(num);\r\n");
      out.write("\t\t\t$(\"#recAID\").html(num);\r\n");
      out.write("\t\t\tif(parseInt(data.acount)!=0){\r\n");
      out.write("\t\t\t   var th=$(\"<thead><tr align='center'height='40px' bgcolor='#BFA789' class='xu' style='color: #FFF;'><th>[序号]</th><th>[患者] </th><th>[预约内容 ]</th><th>[预约时间]</th><th>[处理结果]</th><th>[对方是否违约]</th></tr></thead>\");\r\n");
      out.write("\t\t\t   th.appendTo(\"#records\");\r\n");
      out.write("\t\t\t    $.each(data.AppointmentArray,function(index) {\r\n");
      out.write("\t\t\t\t\t//具体信息\r\n");
      out.write("\t\t\t\t\tvar s1 = \"<tr align='center' height='40px' bgcolor='#FFFFFF' style='font-size: 16px;color: #000;'><td>\"+ (index + 1)+ \"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s2 =\"<td>\"+data.AppointmentArray[index].userId+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s3 =\"<td>\"+data.AppointmentArray[index].brief+\"</td>\";\r\n");
      out.write("\t\t\t\t\tvar s4 = \"<td>\"+data.AppointmentArray[index].time+\"</td>\";\r\n");
      out.write("\t\t\t\t\t//var s5=\"<td>\"+data.AppointmentArray[index].state+\"</td>\";//处理状态\r\n");
      out.write("\t\t\t\t\t//onclick=\\\"javascript:collectExpert(this,'\"+data.doctorArray[index].userId+\"');\\\"\r\n");
      out.write("\t\t\t\t\tvar s5=\"<td><a title=\\\"点击改变处理状态\\\" href='javascript:void(0)'   id=\"+data.AppointmentArray[index].appointment_id+\" onclick=\\\"javascript:dealAppoint(this,'\"+data.AppointmentArray[index].isAccept+\"');\\\">\"+data.AppointmentArray[index].state+\"</a></td>\";\r\n");
      out.write("\t\t\t\t\tvar s6=\"<td><a title=\\\"点击改变违约状态\\\" href='javascript:void(0)'  id=\"+data.AppointmentArray[index].appointment_id+\" onclick=\\\"javascript:dealDefaultMemb(this,'\"+data.AppointmentArray[index].isdefaultMemb+\"');\\\">\"+data.AppointmentArray[index].defaultMemb+\"</a></td></tr>\";\r\n");
      out.write("\t\t\t\t\t//var s7=\"<td>\"+data.AppointmentArray[index].defaultMemb+\"</td></tr>\";\r\n");
      out.write("\t\t\t\t\tvar tr=$(s1+s2+s3+s4+s5+s6);\r\n");
      out.write("\t\t\t\t    tr.appendTo(\"#records\");\r\n");
      out.write("\t\t\t  });\r\n");
      out.write("\t\t\t    $('#records').show();\r\n");
      out.write("\t\t }\r\n");
      out.write("\t  }\r\n");
      out.write("\t}\r\n");
      out.write("    function dealAppoint(obj,isAccept){\r\n");
      out.write("\t\t\t var Appointment_Id = $(obj).attr(\"id\");\r\n");
      out.write("\t\t\t //alert(Appointment_Id);\r\n");
      out.write("\t\t\t $.ajax({\r\n");
      out.write("\t\t\t        url : '");
      out.print(templateUrl);
      out.write("/expe/AppointMentAction?appointment_id='+Appointment_Id+\"&isAccept=\"+isAccept,\r\n");
      out.write("\t\t\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\t\t\tcontentType: \"application/x-www-form-urlencoded; charset=utf-8\", \r\n");
      out.write("\t\t\t\t\tdataType : 'text',\r\n");
      out.write("\t\t\t\t\ttimeout : 8000,\r\n");
      out.write("\t\t\t\t\tcache : true,\r\n");
      out.write("\t\t\t\t\terror : erryFunction, //错误执行方法  \r\n");
      out.write("\t\t\t\t\tsuccess : succFunction\r\n");
      out.write("\t\t\t\t//成功执行方法  \r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t function erryFunction() {\r\n");
      out.write("\t\t\t\t\talert(\"操作失败\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t function succFunction(data) {\r\n");
      out.write("\t\t\t\t var data = String($.trim(data)); \r\n");
      out.write("\t\t\t\t if(data=='yes'){\r\n");
      out.write("\t\t\t\t\talert(\"操作成功\");\r\n");
      out.write("\t\t\t\t\twindow.location=\"myappoint\";\r\n");
      out.write("\t\t\t\t  }else{\r\n");
      out.write("\t\t\t\t\t  alert(\"操作失败！请重试\");\r\n");
      out.write("\t\t\t\t  }\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("    }\r\n");
      out.write("    function dealDefaultMemb(obj,isdefaultMemb){\r\n");
      out.write("\t\t var Appointment_Id = $(obj).attr(\"id\");\r\n");
      out.write("\t\t //alert(Appointment_Id);\r\n");
      out.write("\t\t $.ajax({\r\n");
      out.write("\t\t        url : '");
      out.print(templateUrl);
      out.write("/expe/UpdateDefaultMembAction?appointment_id='+Appointment_Id+\"&isdefaultMemb=\"+isdefaultMemb,\r\n");
      out.write("\t\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\t\tcontentType: \"application/x-www-form-urlencoded; charset=utf-8\", \r\n");
      out.write("\t\t\t\tdataType : 'text',\r\n");
      out.write("\t\t\t\ttimeout : 8000,\r\n");
      out.write("\t\t\t\tcache : true,\r\n");
      out.write("\t\t\t\terror : erryFunction, //错误执行方法  \r\n");
      out.write("\t\t\t\tsuccess : succFunction\r\n");
      out.write("\t\t\t//成功执行方法  \r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t function erryFunction() {\r\n");
      out.write("\t\t\t\talert(\"操作失败\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t function succFunction(data) {\r\n");
      out.write("\t\t\t var data = String($.trim(data)); \r\n");
      out.write("\t\t\t if(data=='yes'){\r\n");
      out.write("\t\t\t\talert(\"操作成功\");\r\n");
      out.write("\t\t\t\twindow.location=\"myappoint\";\r\n");
      out.write("\t\t\t  }else{\r\n");
      out.write("\t\t\t\t  alert(\"操作失败！请重试\");\r\n");
      out.write("\t\t\t  }\r\n");
      out.write("\t\t\t}\r\n");
      out.write("}\r\n");
      out.write("\twindow.onload = function() {\r\n");
      out.write("\t\tgetAppointMent();\r\n");
      out.write("\t\t$(\"#recAID\").click(function(){\r\n");
      out.write("\t\t\t $(\"#records\").toggle();\r\n");
      out.write("\t\t });\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/left.png\" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font\r\n");
      out.write("\t\t\tsize=\"6\"><b>我的预约</b></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img\r\n");
      out.write("\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/right.png\" />\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br/>\r\n");
      out.write("\t<div class=\"user_center_bigtitle\" style=\"font-family: '宋体' ;font-size: 18px;\">\r\n");
      out.write("\t\t<h3>已处理的预约信息(接受：\r\n");
      out.write("\t\t<a id=\"acceptAccount\" href=\"javascript:void(0)\">0</a>\r\n");
      out.write("\t\t；拒绝 : <a id=\"rejectAccount\" href=\"javascript:void(0)\">0</a> )</h3>\r\n");
      out.write("\t\t<hr></hr> \r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"my_dis_diray\">\r\n");
      out.write("\t\t<div class=\"my_dis_diray_con\">\r\n");
      out.write("\t\t\t<div class=\"mg_info\" style=\"font-family: '宋体' ;font-size: 18px;\">\r\n");
      out.write("\t\t\t\t<h3>\r\n");
      out.write("\t\t\t\t\t<h3>总共有<a id=\"recAID\" href=\"javascript:void(0)\"></a>条预约记录</h3>\r\n");
      out.write("\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t<table id=\"records\" width=\"800\" border=\"1\" id=\"table\" bordercolor=\"#FFFFFF\" align=\"center\" style=\"text-align: center;\">\r\n");
      out.write("                </table>\r\n");
      out.write("                <hr>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
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
