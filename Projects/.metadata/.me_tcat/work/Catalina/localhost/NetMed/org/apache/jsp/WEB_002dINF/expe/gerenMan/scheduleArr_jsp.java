package org.apache.jsp.WEB_002dINF.expe.gerenMan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class scheduleArr_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<link rel='stylesheet'\r\n");
      out.write("href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/schedule/jQuery-Timepicker-Addon-master/jquery-ui-timepicker-addon.css' />\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css0623/style.css\" />\r\n");
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
      out.write("<script src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/schedule/jQuery-Timepicker-Addon-master/jquery-ui-timepicker-addon.js'></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("table{border:1px solid #c9b28b !important}\r\n");
      out.write(".fc-head{background-color: #c9b28b !important}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<script type='text/javascript'>\r\n");
      out.write("\r\n");
      out.write("  $(document).ready(function() {\r\n");
      out.write("\t  var selectdateGlobal=moment().toDate();//选中的日期，全局变量\r\n");
      out.write("\t \r\n");
      out.write("    //开始时间\r\n");
      out.write("      $(\"#start\").timepicker({\r\n");
      out.write("    \tdefaultValue:'05:00',\r\n");
      out.write("    \tcurrentText: \"现在\",\r\n");
      out.write("    \tcloseText: \"完成\",\r\n");
      out.write("        timeFormat:'HH:mm',\r\n");
      out.write("        hourMin:5,hourMax: 23, hourGrid: 3, \r\n");
      out.write("        minuteGrid: 15, timeText: '时间', hourText: '时',\r\n");
      out.write("        minuteText: '分', timeOnlyTitle: '选择时间',\r\n");
      out.write("        onClose:function(dataText,inst){\r\n");
      out.write("        \t//alert(selectdateGlobal);\r\n");
      out.write("        },onSelect:function(selectedDateTime){\r\n");
      out.write("        }\r\n");
      out.write("      });\r\n");
      out.write("    //结束时间\r\n");
      out.write("      $(\"#end\").datetimepicker({\r\n");
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
      out.write("           type: \"POST\", //使用post方法访问后台\r\n");
      out.write("           timeout:4000,\r\n");
      out.write("           cache:false,\r\n");
      out.write("           dataType:\"json\",\r\n");
      out.write("           url: \"getScheduleData\", //要访问的后台地址\r\n");
      out.write("           success: function (data) {\r\n");
      out.write("        \t   //(data.length);\r\n");
      out.write("        \t  // alert(data.array.length);\r\n");
      out.write("        \t  //alert(data.array[1].starttime);\r\n");
      out.write("       \t   if(data.array.length>0)\r\n");
      out.write("        \tfor(i=0;i<data.array.length;i++){\r\n");
      out.write("        \t   var testdata={id:data.array[i].id,title:data.array[i].title,fullname:data.array[i].title,start:data.array[i].starttime,\r\n");
      out.write("            \t   end:data.array[i].endtime,description:data.array[i].content};\r\n");
      out.write("                   $(\"#calendar\").fullCalendar('renderEvent', testdata, true);\r\n");
      out.write("        \t }\r\n");
      out.write("           },\r\n");
      out.write("           error:function(){\r\n");
      out.write("           alert(\"请刷新一下页面\");\r\n");
      out.write("           }\r\n");
      out.write("          });\r\n");
      out.write("        },\r\n");
      out.write("        dayClick:function(date, allDay, jsEvent, view){//点击某一天\r\n");
      out.write("          var selectdate = moment(date).format(\"YYYY-MM-DD\");//选择当前日期的时间转换\r\n");
      out.write("          var curDate=moment().format(\"YYYY-MM-DD\");//当前日期\r\n");
      out.write("          selectdateGlobal=moment(selectdate).toDate();\r\n");
      out.write("        //调整选择控件的属性\r\n");
      out.write("          $(\"#end\").datetimepicker(\"option\", \"minDate\",selectdateGlobal);\r\n");
      out.write("          if(moment(selectdate).isBefore(curDate)){\r\n");
      out.write("        \t  alert(\"选择的时间已经过时\");\r\n");
      out.write("        \t  return false;\r\n");
      out.write("          }\r\n");
      out.write("          $(\"#reservebox\").dialog({\r\n");
      out.write("        \t  open:function(){//对话框打开时初始化\r\n");
      out.write("        \t\t  $(\"#start\").val(''); //开始时间\r\n");
      out.write("                  $(\"#end\").val(''); //结束时间\r\n");
      out.write("                  $(\"#title\").val(''); //标题\r\n");
      out.write("                  $(\"#details\").val(''); //内容\r\n");
      out.write("        \t  },\r\n");
      out.write("            autoOpen: false,\r\n");
      out.write("            height:450,\r\n");
      out.write("            width:400,\r\n");
      out.write("            modal:true,\r\n");
      out.write("            title:'添加日程'+date.format(),\r\n");
      out.write("           draggable: false,\r\n");
      out.write("           buttons:[{\r\n");
      out.write("             text:\"关闭\",\r\n");
      out.write("             click:function(){\r\n");
      out.write("               $(this).dialog(\"close\");\r\n");
      out.write("             }\r\n");
      out.write("           },{\r\n");
      out.write("             text:\"保存\",\r\n");
      out.write("             click:function(){\r\n");
      out.write("              var startdate = $(\"#start\").val(); //开始时间\r\n");
      out.write("              var enddatestr = $(\"#end\").val(); //结束时间\r\n");
      out.write("              var confid = $(\"#title\").val(); //标题\r\n");
      out.write("              var det = $(\"#details\").val(); //内容\r\n");
      out.write("              if(confid==''){//如果标题为空提示用户输入\r\n");
      out.write("            \t  alert(\"请输入标题！\");\r\n");
      out.write("            \t  return;\r\n");
      out.write("              }\r\n");
      out.write("              if(startdatestr='' || enddatestr==''){\r\n");
      out.write("               alert(\"请输入时间！\");\r\n");
      out.write("            \t  return;\r\n");
      out.write("              }\r\n");
      out.write("              \r\n");
      out.write("              var id2;\r\n");
      out.write("              var startdatestr = $.fullCalendar.moment(selectdate + \" \" + startdate).format(\"YYYY-MM-DD HH:mm:ss\");//时间和日期拼接\r\n");
      out.write("              var enddate = $.fullCalendar.moment(enddatestr).format(\"YYYY-MM-DD HH:mm:ss\");\r\n");
      out.write("              var schdata = { title: confid, fullname: confid, description: det, start:startdatestr, end: enddatestr };\r\n");
      out.write("              $.ajax({\r\n");
      out.write("                type: \"POST\", //使用post方法访问后台\r\n");
      out.write("                timeout:4000,\r\n");
      out.write("                url: \"saveScheduleData\", //要访问的后台地址\r\n");
      out.write("                data:{jsonData:JSON.stringify(schdata)}, //要发送的数据\r\n");
      out.write("                dataType:\"json\",\r\n");
      out.write("                success: function (data) {\r\n");
      out.write("                  // 对话框里面的数据提交完成，data为操作结果\r\n");
      out.write("                  alert(\"数据保存成功\");\r\n");
      out.write("                  id2 = data;\r\n");
      out.write("                  //var schdata2 = { title: confid, fullname: confid, description: det, confshortname: 'M1', start: selectdate + ' ' + startdatestr, end: enddatestr, id: id2 };\r\n");
      out.write("                  $(\"#calendar\").fullCalendar('renderEvent', schdata, true);\r\n");
      out.write("                  $(\"#start\").val(''); //开始时间\r\n");
      out.write("                  $(\"#end\").val(''); //结束时间\r\n");
      out.write("                  $(\"#title\").val(''); //标题\r\n");
      out.write("                  $(\"#details\").val(''); //内容\r\n");
      out.write("                },\r\n");
      out.write("                error:function(){\r\n");
      out.write("                alert(\"保存数据出错\");\r\n");
      out.write("                }\r\n");
      out.write("              });\r\n");
      out.write("              $(this).dialog(\"close\");\r\n");
      out.write("             }\r\n");
      out.write("           }]\r\n");
      out.write("          });\r\n");
      out.write("          $(\"#reservebox\").dialog(\"open\");\r\n");
      out.write("          return false;\r\n");
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
      out.write("            eventClick: function (event) {\r\n");
      out.write("                var fstart = $.fullCalendar.moment(event.start).format(\"HH:mm\");\r\n");
      out.write("                var fend = $.fullCalendar.moment(event.end).format(\"YYYY-MM-DD HH:mm\");\r\n");
      out.write("                //  var schdata = { sid: event.sid, deleted: 1, uid: event.uid };\r\n");
      out.write("                var selectdate = $.fullCalendar.moment(event.start).format(\"YYYY-MM-DD\");\r\n");
      out.write("                $(\"#start\").val(fstart);\r\n");
      out.write("                $(\"#end\").datetimepicker('setDate', fend);\r\n");
      out.write("                \r\n");
      out.write("\r\n");
      out.write("                $(\"#title\").val(event.title); //标题\r\n");
      out.write("                $(\"#details\").val(event.description); //内容 \r\n");
      out.write("                $(\"#reservebox\").dialog({\r\n");
      out.write("                    autoOpen: false,\r\n");
      out.write("                    height: 450,\r\n");
      out.write("                    width: 400,\r\n");
      out.write("                    title: '日程修改 '+selectdate,\r\n");
      out.write("                    modal: true,\r\n");
      out.write("                    draggable: false,\r\n");
      out.write("                    beforeClose: function (event, ui) {\r\n");
      out.write("                    },\r\n");
      out.write("                    timeFormat: 'HH:mm{ - HH:mm}',\r\n");
      out.write("\r\n");
      out.write("                    buttons: [{\r\n");
      out.write("                        text:\"删除\",\r\n");
      out.write("                        click: function () {\r\n");
      out.write("                            var aa = window.confirm(\"警告：确定要删除记录，删除后无法恢复！\");\r\n");
      out.write("                            if (aa) {\r\n");
      out.write("                                var para = { id: event.id };\r\n");
      out.write("\r\n");
      out.write("                                $.ajax({\r\n");
      out.write("                                    type: \"POST\", //使用post方法访问后台\r\n");
      out.write("                                    url: \"deleteScheduleData\", //要访问的后台地址\r\n");
      out.write("                                    data: para, //要发送的数据\r\n");
      out.write("                                    success: function (data) { //对话框里面的数据提交完成，data为操作结果\r\n");
      out.write("                                    alert(\"删除数据成功\");\r\n");
      out.write("                                        $(\"#calendar\").fullCalendar(\"removeEvents\", event.id);\r\n");
      out.write("                                    },\r\n");
      out.write("                                    error:function(){\r\n");
      out.write("                                    alert(\"删除数据失败\");\r\n");
      out.write("                                    }\r\n");
      out.write("\r\n");
      out.write("                                });\r\n");
      out.write("\r\n");
      out.write("                            }\r\n");
      out.write("                            $(this).dialog(\"close\");\r\n");
      out.write("                        }},{\r\n");
      out.write("                        text:\"保存\",\r\n");
      out.write("                        click: function () {\r\n");
      out.write("\r\n");
      out.write("                            var startdatestr = $(\"#start\").val(); //开始时间\r\n");
      out.write("                            var enddatestr = $(\"#end\").val(); //结束时间\r\n");
      out.write("                            var confid = $(\"#title\").val(); //标题\r\n");
      out.write("                            var det = $(\"#details\").val(); //内容\r\n");
      out.write("                            \r\n");
      out.write("                            if(confid==''){\r\n");
      out.write("                            alert(\"请输入标题！\");return;\r\n");
      out.write("                            } \r\n");
      out.write("                            if(startdatestr=='' || enddatestr==''){\r\n");
      out.write("                            alert(\"请输入时间！\");return;\r\n");
      out.write("                            }\r\n");
      out.write("                            \r\n");
      out.write("                            var startdate = $.fullCalendar.moment(selectdate + \"T\" + startdatestr).format(\"YYYY-MM-DD HH:mm:ss\");\r\n");
      out.write("                            var enddate = $.fullCalendar.moment(enddatestr).format(\"YYYY-MM-DD HH:mm:ss\");\r\n");
      out.write("\r\n");
      out.write("                            event.fullname = confid;\r\n");
      out.write("                            event.confname = cd;\r\n");
      out.write("                            event.start = startdate;\r\n");
      out.write("                            event.end = enddate;\r\n");
      out.write("                            event.description = det;\r\n");
      out.write("                            var id2;\r\n");
      out.write("\r\n");
      out.write("                            var schdata = { title: confid, fullname: confid, description: det, confname: cd, confshortname: 'M1', start: selectdate + ' ' + startdatestr, end: enddatestr, id: event.id };\r\n");
      out.write("                            $.ajax({\r\n");
      out.write("                                type: \"POST\", //使用post方法访问后台\r\n");
      out.write("                                dataType:\"text\",\r\n");
      out.write("                                timeout:4000,\r\n");
      out.write("                                url: \"saveScheduleData\", //要访问的后台地址\r\n");
      out.write("                                data: schdata, //要发送的数据\r\n");
      out.write("                                success: function (data) { //对话框里面的数据提交完成，data为操作结果\r\n");
      out.write("                                alert(data);\r\n");
      out.write("                                    var schdata2 = { title: confid, fullname: confid, description: det, confname: cd, confshortname: 'M1', start: selectdate + ' ' + startdatestr, end: enddatestr, id: event.id };\r\n");
      out.write("                                    $('#calendar').fullCalendar('updateEvent', event);\r\n");
      out.write("                                },\r\n");
      out.write("                                error:function(){\r\n");
      out.write("                                alert(\"添加日程失败\");\r\n");
      out.write("                                }\r\n");
      out.write("                            });\r\n");
      out.write("\r\n");
      out.write("                            $(this).dialog(\"close\");\r\n");
      out.write("                        }\r\n");
      out.write("\r\n");
      out.write("                    }]\r\n");
      out.write("                });\r\n");
      out.write("                $(\"#reservebox\").dialog(\"open\");\r\n");
      out.write("                return false;\r\n");
      out.write("            },\r\n");
      out.write("            //            events: \"../../sr/AccessDate.ashx\"\r\n");
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
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write(" .ui-datepicker\r\n");
      out.write("    {\r\n");
      out.write("        width: 23em;\r\n");
      out.write("        padding: .2em .2em 0;\r\n");
      out.write("        font-size: 70%;\r\n");
      out.write("        display: none;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    #calendar\r\n");
      out.write("    {\r\n");
      out.write("        width: 800px;\r\n");
      out.write("        margin: 0 auto;\r\n");
      out.write("    }\r\n");
      out.write("    #loading\r\n");
      out.write("    {\r\n");
      out.write("        top: 0px;\r\n");
      out.write("        right: 0px;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .tooltip\r\n");
      out.write("    {\r\n");
      out.write("        padding-bottom: 25px;\r\n");
      out.write("        padding-left: 25px;\r\n");
      out.write("        width: 100px !important;\r\n");
      out.write("        padding-right: 25px;\r\n");
      out.write("        display: none;\r\n");
      out.write("        background: #999;\r\n");
      out.write("        height: 70px;\r\n");
      out.write("        color: red;\r\n");
      out.write("        font-size: 12px;\r\n");
      out.write("        padding-top: 25px;\r\n");
      out.write("        z-order: 10;\r\n");
      out.write("    }\r\n");
      out.write("    .ui-timepicker-div .ui-widget-header\r\n");
      out.write("    {\r\n");
      out.write("        margin-bottom: 8px;\r\n");
      out.write("    }\r\n");
      out.write("    .ui-timepicker-div dl\r\n");
      out.write("    {\r\n");
      out.write("        text-align: left;\r\n");
      out.write("    }\r\n");
      out.write("    .ui-timepicker-div dl dt\r\n");
      out.write("    {\r\n");
      out.write("        height: 25px;\r\n");
      out.write("        margin-bottom: -25px;\r\n");
      out.write("    }\r\n");
      out.write("    .ui-timepicker-div dl dd\r\n");
      out.write("    {\r\n");
      out.write("        margin: 0 10px 10px 65px;\r\n");
      out.write("    }\r\n");
      out.write("    .ui-timepicker-div td\r\n");
      out.write("    {\r\n");
      out.write("        font-size: 90%;\r\n");
      out.write("    }\r\n");
      out.write("    .ui-tpicker-grid-label\r\n");
      out.write("    {\r\n");
      out.write("        background: none;\r\n");
      out.write("        border: none;\r\n");
      out.write("        margin: 0;\r\n");
      out.write("        padding: 0;\r\n");
      out.write("    }\r\n");
      out.write("    .ui-timepicker-rtl\r\n");
      out.write("    {\r\n");
      out.write("        direction: rtl;\r\n");
      out.write("    }\r\n");
      out.write("    .ui-timepicker-rtl dl\r\n");
      out.write("    {\r\n");
      out.write("        text-align: right;\r\n");
      out.write("    }\r\n");
      out.write("    .ui-timepicker-rtl dl dd\r\n");
      out.write("    {\r\n");
      out.write("        margin: 0 65px 10px 10px;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/left.png\" />&nbsp;&nbsp;<span\r\n");
      out.write("\t\t\tstyle=\"font-family:'仿宋';font-size:33px;color:#c9b28b;\">日程安排</span>&nbsp;&nbsp;<img\r\n");
      out.write("\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/right.png\" />\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br/><br/>\r\n");
      out.write("    <div id=\"wrap\">\r\n");
      out.write("        <div id='calendar'>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"reserveinfo\" title=\"Details\">\r\n");
      out.write("            <div id=\"revtitle\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"revdesc\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div style=\"display: none\" id=\"reservebox\" title=\"Reserve meeting room\">\r\n");
      out.write("            <form id=\"reserveformID\" method=\"post\">\r\n");
      out.write("            <div class=\"sysdesc\">\r\n");
      out.write("                &nbsp;</div>\r\n");
      out.write("            <div class=\"rowElem\">\r\n");
      out.write("                <label>\r\n");
      out.write("                    标题:</label>\r\n");
      out.write("                <input id=\"title\" name=\"start\">\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"rowElem\">\r\n");
      out.write("                <label>\r\n");
      out.write("                    开始时间:</label>\r\n");
      out.write("                <input id=\"start\" name=\"start\" readonly='true'>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"rowElem\">\r\n");
      out.write("                <label>\r\n");
      out.write("                    结束时间:</label>\r\n");
      out.write("                <input id=\"end\" name=\"end\" readonly='true'>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"rowElem\">\r\n");
      out.write("                <label>\r\n");
      out.write("                    备忘内容:</label>\r\n");
      out.write("                <textarea id=\"details\" rows=\"3\" cols=\"43\" name=\"details\"></textarea>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"rowElem\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"rowElem\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"addhelper\" class=\"ui-widget\">\r\n");
      out.write("                <div style=\"padding-bottom: 5px; padding-left: 5px; padding-right: 5px; padding-top: 5px\"\r\n");
      out.write("                    class=\"ui-state-error ui-corner-all\">\r\n");
      out.write("                    <div id=\"addresult\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
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