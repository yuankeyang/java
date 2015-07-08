package org.apache.jsp.WEB_002dINF.memb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class yuyue_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	String expe_id=request.getParameter("doctorId");
	System.out.println(expe_id);

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset='utf-8' />\r\n");
      out.write("<link rel='stylesheet' href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/schedule/jquery-ui-1.11.4/jquery-ui.min.css' />\r\n");
      out.write("<link href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/schedule/fullcalendar-2.3.1/fullcalendar.css' rel='stylesheet' />\r\n");
      out.write("<link href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/schedule/fullcalendar-2.3.1/fullcalendar.print.css' rel='stylesheet' media='print' />\r\n");
      out.write("<link rel='stylesheet'\r\n");
      out.write("href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/schedule/jQuery-Timepicker-Addon-master/jquery-ui-timepicker-addon.css' />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/article.css\" />\r\n");
      out.write("\r\n");
      out.write("<script src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/schedule/fullcalendar-2.3.1/lib/moment.min.js'></script>\r\n");
      out.write("<script src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/schedule/fullcalendar-2.3.1/lib/jquery.min.js'></script>\r\n");
      out.write("<script src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/schedule/fullcalendar-2.3.1/fullcalendar.min.js'></script>\r\n");
      out.write("<script src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/schedule/fullcalendar-2.3.1/lang-all.js'></script>\r\n");
      out.write("<script src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/schedule/jquery-ui-1.11.4/jquery-ui.min.js'></script>\r\n");
      out.write("\r\n");
      out.write("<script src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/schedule/jQuery-Timepicker-Addon-master/jquery-ui-timepicker-addon.js'></script>\r\n");
      out.write("<script  type='text/javascript'>\r\n");
      out.write("\r\n");
      out.write(" $(document).ready(function() {\r\n");
      out.write("$(document).ready(function() {\r\n");
      out.write("\t  var selectdateGlobal=moment().toDate();//选中的日期，全局变量\r\n");
      out.write("    //结束时间\r\n");
      out.write("      $(\"#appoTime\").datetimepicker({\r\n");
      out.write("    \t  defaultDate: selectdateGlobal,\r\n");
      out.write("    \t  minDate:selectdateGlobal,\r\n");
      out.write("    \t  dayNamesMin: [ \"日\",\"一\", \"二\", \"三\", \"四\", \"五\", \"六\"],\r\n");
      out.write("    \t  monthNames: [ \"一月\", \"二月\", \"三月\", \"四月\", \"五月\", \"六月\", \"七月\", \"八月\", \"九月\", \"十月\", \"十一月\", \"十二月\" ],\r\n");
      out.write("    \t  currentText: \"现在\",\r\n");
      out.write("    \t  closeText: \"完成\",\r\n");
      out.write("    \t  dateFormat: 'yy-mm-dd', \r\n");
      out.write("    \t  hourMin: 5, hourMax: 23, hourGrid: 3, \r\n");
      out.write("    \t  minuteGrid: 15, timeText: '时间', hourText: '时', \r\n");
      out.write("    \t  minuteText: '分', \r\n");
      out.write("    \t  onClose: function (dateText, inst) {\r\n");
      out.write("    \t\t  \r\n");
      out.write("        },\r\n");
      out.write("         onSelect: function (selectedDateTime) {\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        $(\"#addhelper\").hide();\r\n");
      out.write("        var date = new Date();\r\n");
      out.write("        var d = date.getDate();\r\n");
      out.write("        var m = date.getMonth();\r\n");
      out.write("        var y = date.getFullYear();\r\n");
      out.write("\r\n");
      out.write("\t\t\t$(\"#calendar\").fullCalendar({\r\n");
      out.write("        \t\ttheme:true,\r\n");
      out.write("\t\t\t\theader: {\r\n");
      out.write("\t\t\t\t\tleft: 'prev,next today',\r\n");
      out.write("\t\t\t\t\tcenter: 'title',\r\n");
      out.write("\t\t\t\t\tright: 'month,agendaWeek,agendaDay'\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tlang: 'zh-cn',\r\n");
      out.write("\t\t\t\tbuttonIcons: false, // show the prev/next text\r\n");
      out.write("\t\t\t\tweekNumbers: true,\r\n");
      out.write("\t\t\t\teditable: true,\r\n");
      out.write("\t\t\t\teventLimit: true, // allow \"more\" link when too many events\r\n");
      out.write("        viewRender:function(view,element){\r\n");
      out.write("          //创建时调用\r\n");
      out.write("          var viewSart=$.fullCalendar.moment(view.start).format(\"YYYY-MM-DD HH:mm:ss\");\r\n");
      out.write("          var viewEnd=$.fullCalendar.moment(view.end).format(\"YYYY-MM-DD HH:mm:ss\");\r\n");
      out.write("          $(\"#calendar\").fullCalendar('removeEvents');\r\n");
      out.write("         // alert(\"viewEnd\");\r\n");
      out.write("          $.ajax({\r\n");
      out.write("           type: \"GET\", //使用post方法访问后台\r\n");
      out.write("           timeout:4000,\r\n");
      out.write("           cache:false,\r\n");
      out.write("           dataType:\"json\",\r\n");
      out.write("           url: \"getScheduleData?t=");
      out.print(expe_id);
      out.write("\", //要访问的后台地址\r\n");
      out.write("           success: function (data) {\r\n");
      out.write("        \t   //(data.length);\r\n");
      out.write("        \t   alert(data.length);\r\n");
      out.write("       \t   if(data.length>0)\r\n");
      out.write("        \tfor(i=0;i<data.length;i++){\r\n");
      out.write("        \t   var testdata={id:data[i].id,title:data[i].title,fullname:data[i].title,start:data[i].starttime,\r\n");
      out.write("            \t   end:data[i].endtime,description:data[i].content};\r\n");
      out.write("                   $(\"#calendar\").fullCalendar('renderEvent', testdata, true);\r\n");
      out.write("        \t }\r\n");
      out.write("           },\r\n");
      out.write("           error:function(){\r\n");
      out.write("           alert(\"获取数据出错\");\r\n");
      out.write("           }\r\n");
      out.write("          });\r\n");
      out.write("        },\r\n");
      out.write("        titleFormat: \"YYYYMMMMdddd\",\r\n");
      out.write("        loading: function (bool,view) {\r\n");
      out.write("                if (bool) $(\"#loading\").show();\r\n");
      out.write("                else $(\"#loading\").hide();\r\n");
      out.write("            },\r\n");
      out.write("        eventAfterRender: function (event, element, view) {//数据绑定上去后添加相应信息在页面上\r\n");
      out.write("         var fstart = $.fullCalendar.moment(event.start).format(\"HH:mm\");\r\n");
      out.write("         var fend = $.fullCalendar.moment(event.end).format(\"HH:mm\");\r\n");
      out.write("\r\n");
      out.write("         var confbg = '';\r\n");
      out.write("         if (event.confid == 1) {\r\n");
      out.write("             confbg = confbg + '<span class=\"fc-event-bg\"></span>';\r\n");
      out.write("         } else if (event.confid == 2) {\r\n");
      out.write("             confbg = confbg + '<span class=\"fc-event-bg\"></span>';\r\n");
      out.write("         } else if (event.confid == 3) {\r\n");
      out.write("             confbg = confbg + '<span class=\"fc-event-bg\"></span>';\r\n");
      out.write("         } else if (event.confid == 4) {\r\n");
      out.write("             confbg = confbg + '<span class=\"fc-event-bg\"></span>';\r\n");
      out.write("         } else if (event.confid == 5) {\r\n");
      out.write("             confbg = confbg + '<span class=\"fc-event-bg\"></span>';\r\n");
      out.write("         } else if (event.confid == 6) {\r\n");
      out.write("             confbg = confbg + '<span class=\"fc-event-bg\"></span>';\r\n");
      out.write("         } else {\r\n");
      out.write("             confbg = confbg + '<span class=\"fc-event-bg\"></span>';\r\n");
      out.write("         }\r\n");
      out.write("\r\n");
      out.write("         if (view.name == \"month\") {//按月份\r\n");
      out.write("             var evtcontent = '<div class=\"fc-event-vert\"><a>';\r\n");
      out.write("             evtcontent = evtcontent + confbg;\r\n");
      out.write("             evtcontent = evtcontent + '<span class=\"fc-event-titlebg\">' + fstart + \" - \" + fend + event.fullname + '</span>';\r\n");
      out.write("             element.html(evtcontent);\r\n");
      out.write("         } else if (view.name == \"agendaWeek\") {//按周\r\n");
      out.write("             var evtcontent = '<a>';\r\n");
      out.write("             evtcontent = evtcontent + confbg;\r\n");
      out.write("             evtcontent = evtcontent + '<span class=\"fc-event-time\">' + fstart + \"-\" + fend  + '</span>';\r\n");
      out.write("             evtcontent = evtcontent + '<span>'+ event.fullname + '</span>';\r\n");
      out.write("             element.html(evtcontent);\r\n");
      out.write("          } else if (view.name == \"agendaDay\") {//按日\r\n");
      out.write("              var evtcontent = '<a>';\r\n");
      out.write("              evtcontent = evtcontent + confbg;\r\n");
      out.write("              evtcontent = evtcontent + '<span class=\"fc-event-time\">' + fstart + \" - \" + fend +  '</span>';\r\n");
      out.write("                    element.html(evtcontent);\r\n");
      out.write("                }\r\n");
      out.write("          },\r\n");
      out.write("            eventMouseover: function (calEvent, jsEvent, view) {\r\n");
      out.write("                var fstart = $.fullCalendar.moment(calEvent.start).format(\"YYYY/MM/dd HH:mm\");\r\n");
      out.write("                var fend = $.fullCalendar.moment(calEvent.end).format(\"YYYY/MM/dd HH:mm\");\r\n");
      out.write("                $(this).attr('title', fstart + \" - \" + fend + \" \" + \"标题\" + \" : \" + calEvent.title);\r\n");
      out.write("                $(this).css('font-weight', 'normal');\r\n");
      out.write("                $(this).tooltip({\r\n");
      out.write("                    effect: 'toggle',\r\n");
      out.write("                    cancelDefault: true\r\n");
      out.write("                });\r\n");
      out.write("            },\r\n");
      out.write("\r\n");
      out.write("           \r\n");
      out.write("            events: []\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        //goto date function\r\n");
      out.write("        if ($.browser.msie) {\r\n");
      out.write("            $(\"#calendar .fc-header-right table td:eq(0)\").before('<td><div class=\"ui-state-default ui-corner-left ui-corner-right\" style=\"border-right:0px;padding:1px 3px 2px;\" ><input type=\"text\" id=\"selecteddate\" size=\"10\" style=\"padding:0px;\"></div></td><td><div class=\"ui-state-default ui-corner-left ui-corner-right\"><a><span id=\"selectdate\" class=\"ui-icon ui-icon-search\">goto</span></a></div></td><td><span class=\"fc-header-space\"></span></td>');\r\n");
      out.write("        } else {\r\n");
      out.write("            $(\"#calendar .fc-header-right table td:eq(0)\").before('<td><div class=\"ui-state-default ui-corner-left ui-corner-right\" style=\"border-right:0px;padding:3px 2px 4px;\" ><input type=\"text\" id=\"selecteddate\" size=\"10\" style=\"padding:0px;\"></div></td><td><div class=\"ui-state-default ui-corner-left ui-corner-right\"><a><span id=\"selectdate\" class=\"ui-icon ui-icon-search\">goto</span></a></div></td><td><span class=\"fc-header-space\"></span></td>');\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        $(\"#selecteddate\").datepicker({\r\n");
      out.write("            dateFormat: 'yy-mm-dd',\r\n");
      out.write("            beforeShow: function (input, instant) {\r\n");
      out.write("                setTimeout(\r\n");
      out.write("\t\t\t\t\t\t\tfunction () {\r\n");
      out.write("\t\t\t\t\t\t\t    $('#ui-datepicker-div').css(\"z-index\", 15);\r\n");
      out.write("\t\t\t\t\t\t\t}, 100\r\n");
      out.write("\t\t\t\t\t\t);\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        $(\"#selectdate\").click(function () {\r\n");
      out.write("            var selectdstr = $(\"#selecteddate\").val();\r\n");
      out.write("            var selectdate = $.fullCalendar.moment(selectdstr).format(\"YYYY-MM-DD\");\r\n");
      out.write("            $('#calendar').fullCalendar('gotoDate', selectdate.getFullYear(), selectdate.getMonth(), selectdate.getDate());\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        // conference function\r\n");
      out.write("        $(\"#calendar .fc-header-left table td:eq(0)\").before('<td><div class=\"ui-state-default ui-corner-left ui-corner-right\" id=\"selectmeeting\"><a><span id=\"selectdate\" class=\"ui-icon ui-icon-search\" style=\"float: left;padding-left: 5px; padding-top:1px\"></span>meeting room</a></div></td><td><span class=\"fc-header-space\"></span></td>');\r\n");
      out.write("    });\r\n");
      out.write(" });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("#appoBox{\r\n");
      out.write("\r\n");
      out.write(" width: 900px;\r\n");
      out.write(" margin: 0 auto;\r\n");
      out.write("}\r\n");
      out.write("  #calendar\r\n");
      out.write("    {\r\n");
      out.write("        width: 900px;\r\n");
      out.write("        margin: 0 auto;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write(" <div id=\"wrap\">\r\n");
      out.write("        <div id='calendar'>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"appoBox\">\r\n");
      out.write("        <form method=\"get\">\r\n");
      out.write("        <div class=\"rowElem\">\r\n");
      out.write("                <label>\r\n");
      out.write("                    标题:</label>\r\n");
      out.write("                <input id=\"title\" name=\"start\">\r\n");
      out.write("            </div>\r\n");
      out.write("        <div class=\"rowElem\">\r\n");
      out.write("        <label>\r\n");
      out.write("        预约时间：</label><input id=\"appoTime\" name=\"appoTime\" readonly='true'>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"rowElem\">\r\n");
      out.write("            <label>\r\n");
      out.write("                    备忘内容:</label>\r\n");
      out.write("                <textarea id=\"details\" rows=\"3\" cols=\"43\" name=\"details\"></textarea>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div class=\"rowElem\">\r\n");
      out.write("         <button>提交</button>\r\n");
      out.write("         </div>\r\n");
      out.write("            \r\n");
      out.write("            </form>\r\n");
      out.write("\t \t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
