<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	String expe_id=request.getParameter("doctorId");
	String doctorName=new String(request.getParameter("doctorName").getBytes("iso8859-1"),"utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href='${url}/schedule/jquery-ui-1.11.4/jquery-ui.min.css' />
<link rel="stylesheet" type="text/css" href='${url}/schedule/fullcalendar-2.3.1/fullcalendar.css'  />
<link rel='stylesheet' type="text/css" href='${url}/schedule/fullcalendar-2.3.1/fullcalendar.print.css'  media='print' />
<link rel='stylesheet' type="text/css" href='${url}/schedule/jQuery-Timepicker-Addon-master/jquery-ui-timepicker-addon.css' />

<script src='${url}/schedule/fullcalendar-2.3.1/lib/moment.min.js'></script>
<script src='${url}/schedule/fullcalendar-2.3.1/lib/jquery.min.js'></script>
<script src='${url}/schedule/fullcalendar-2.3.1/fullcalendar.min.js'></script>
<script src='${url}/schedule/fullcalendar-2.3.1/lang-all.js'></script>
<script src='${url}/schedule/jquery-ui-1.11.4/jquery-ui.min.js'></script>
<script src='${url}/schedule/jQuery-Timepicker-Addon-master/jquery-ui-timepicker-addon.js'></script>


<script  type='text/javascript'>

$(document).ready(function() {
	
//收费信息的请求
	$.ajax({
	type: "POST", //使用post方法访问后台
    timeout:20000,
    url:'price',
    dataType:"json",
    cache : true,
    async:false,
	success:function(data){
	$("#price").text(data.price+'积分/次');
	},
	error:function(){
	   alert("获取专家价格出错！");
	}
	});

	  var selectdateGlobal=moment().toDate();//选中的日期，全局变量
    //结束时间
      $("#appoTime").datetimepicker({
    	  defaultDate: selectdateGlobal,
    	  minDate:selectdateGlobal,
    	  dayNamesMin: [ "日","一", "二", "三", "四", "五", "六"],
    	  monthNames: [ "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" ],
    	  currentText: "现在",
    	  closeText: "完成",
    	  dateFormat: 'yy-mm-dd', 
    	  hourMin: 5, hourMax: 23, hourGrid: 3, 
    	  minuteGrid: 15, timeText: '时间', hourText: '时', 
    	  minuteText: '分', 
    	  onClose: function (dateText, inst) {
    		  
        },
         onSelect: function (selectedDateTime) {
            }
        });

        $("#addhelper").hide();
        var date = new Date();
        var d = date.getDate();
        var m = date.getMonth();
        var y = date.getFullYear();

			$("#calendar").fullCalendar({
        		theme:true,
				header: {
					left: 'prev,next today',
					center: 'title',
					right: 'month,agendaWeek,agendaDay'
				},
				lang: 'zh-cn',
				buttonIcons: false, // show the prev/next text
				weekNumbers: true,
				editable: true,
				eventLimit: true, // allow "more" link when too many events
        viewRender:function(view,element){
          //创建时调用
          var viewSart=$.fullCalendar.moment(view.start).format("YYYY-MM-DD HH:mm:ss");
          var viewEnd=$.fullCalendar.moment(view.end).format("YYYY-MM-DD HH:mm:ss");
          $("#calendar").fullCalendar('removeEvents');
         // alert("viewEnd");
          $.ajax({
           type: "POST", //使用post方法访问后台
           timeout:20000,
           cache : true,
           dataType:"json",
           url: "huoquData?t=<%=expe_id%>", //要访问的后台地址
           success: function (data) {
       	   if(data.length>0)
        	for(i=0;i<data.length;i++){
        	   var testdata={id:data.array[i].id,title:data.array[i].title,fullname:data.array[i].title,start:data.array[i].starttime,
            	   end:data.array[i].endtime,description:data.array[i].content};
                   $("#calendar").fullCalendar('renderEvent', testdata, true);
        	 }
           },
           error:function(){
               alert("getScheduleData---获取数据出错");
           }
          });
        },
        titleFormat: "YYYYMMMM",
        loading: function (bool,view) {
                if (bool) $("#loading").show();
                else $("#loading").hide();
            },
        eventAfterRender: function (event, element, view) {//数据绑定上去后添加相应信息在页面上
         var fstart = $.fullCalendar.moment(event.start).format("HH:mm");
         var fend = $.fullCalendar.moment(event.end).format("HH:mm");

         var confbg = '';
         if (event.confid == 1) {
             confbg = confbg + '<span class="fc-event-bg"></span>';
         } else if (event.confid == 2) {
             confbg = confbg + '<span class="fc-event-bg"></span>';
         } else if (event.confid == 3) {
             confbg = confbg + '<span class="fc-event-bg"></span>';
         } else if (event.confid == 4) {
             confbg = confbg + '<span class="fc-event-bg"></span>';
         } else if (event.confid == 5) {
             confbg = confbg + '<span class="fc-event-bg"></span>';
         } else if (event.confid == 6) {
             confbg = confbg + '<span class="fc-event-bg"></span>';
         } else {
             confbg = confbg + '<span class="fc-event-bg"></span>';
         }

         if (view.name == "month") {//按月份
             var evtcontent = '<div class="fc-event-vert"><a>';
             evtcontent = evtcontent + confbg;
             evtcontent = evtcontent + '<span class="fc-event-titlebg">' + fstart + " - " + fend + event.fullname + '</span>';
             element.html(evtcontent);
         } else if (view.name == "agendaWeek") {//按周
             var evtcontent = '<a>';
             evtcontent = evtcontent + confbg;
             evtcontent = evtcontent + '<span class="fc-event-time">' + fstart + "-" + fend  + '</span>';
             evtcontent = evtcontent + '<span>'+ event.fullname + '</span>';
             element.html(evtcontent);
          } else if (view.name == "agendaDay") {//按日
              var evtcontent = '<a>';
              evtcontent = evtcontent + confbg;
              evtcontent = evtcontent + '<span class="fc-event-time">' + fstart + " - " + fend +  '</span>';
                    element.html(evtcontent);
                }
          },
            eventMouseover: function (calEvent, jsEvent, view) {
                var fstart = $.fullCalendar.moment(calEvent.start).format("YYYY/MM/dd HH:mm");
                var fend = $.fullCalendar.moment(calEvent.end).format("YYYY/MM/dd HH:mm");
                $(this).attr('title', fstart + " - " + fend + " " + "简述" + " : " + calEvent.title);
                $(this).css('font-weight', 'normal');
                $(this).tooltip({
                    effect: 'toggle',
                    cancelDefault: true
                });
            },

           
            events: []
        });



        //goto date function
        if ($.browser.msie) {
            $("#calendar .fc-header-right table td:eq(0)").before('<td><div class="ui-state-default ui-corner-left ui-corner-right" style="border-right:0px;padding:1px 3px 2px;" ><input type="text" id="selecteddate" size="10" style="padding:0px;"></div></td><td><div class="ui-state-default ui-corner-left ui-corner-right"><a><span id="selectdate" class="ui-icon ui-icon-search">goto</span></a></div></td><td><span class="fc-header-space"></span></td>');
        } else {
            $("#calendar .fc-header-right table td:eq(0)").before('<td><div class="ui-state-default ui-corner-left ui-corner-right" style="border-right:0px;padding:3px 2px 4px;" ><input type="text" id="selecteddate" size="10" style="padding:0px;"></div></td><td><div class="ui-state-default ui-corner-left ui-corner-right"><a><span id="selectdate" class="ui-icon ui-icon-search">goto</span></a></div></td><td><span class="fc-header-space"></span></td>');
        }

        $("#selecteddate").datepicker({
            dateFormat: 'yy-mm-dd',
            beforeShow: function (input, instant) {
                setTimeout(
							function () {
							    $('#ui-datepicker-div').css("z-index", 15);
							}, 100
						);
            }
        });



        $("#selectdate").click(function () {
            var selectdstr = $("#selecteddate").val();
            var selectdate = $.fullCalendar.moment(selectdstr).format("YYYY-MM-DD");
            $('#calendar').fullCalendar('gotoDate', selectdate.getFullYear(), selectdate.getMonth(), selectdate.getDate());
        });

        // conference function
        $("#calendar .fc-header-left table td:eq(0)").before('<td><div class="ui-state-default ui-corner-left ui-corner-right" id="selectmeeting"><a><span id="selectdate" class="ui-icon ui-icon-search" style="float: left;padding-left: 5px; padding-top:1px"></span>meeting room</a></div></td><td><span class="fc-header-space"></span></td>');
    });

 function check(){
		//alert($('#title').val());appoTime
		if($('#title').val()==""){
			alert("请输入预约内容");
			$("#title").select();
			$("#title").focus();
		}else if($('#appoTime').val()==""){
			alert("请输入预约时间");
			$("#appoTime").select();
			$("#appoTime").focus();
		}else{
			submit();
		}
	}
	//<form action="AddJiuyiExp" id="AddJiuyiExp" method="post">
	function submit(){
	$.ajax({
     url : '<%=templateUrl%>/user/MemberAppointmentAction',
		type : 'POST',
		data:"title="+$('#title').val()+"&appoTime="+$('#appoTime').val()+"&expe_id=<%=expe_id%>",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		dataType : 'text',
		timeout : 18000,
		cache : true,
		errot:erryFunction,
		success : succFunction
	//成功执行方法  
	});
	function erryFunction() {
		alert("有错误，请刷新页面");
	}
	function succFunction(data) {
		var data = String($.trim(data)); 
		 if(data=='yes'){
			alert("提交成功!页面即将关闭");
			window.close();
		  }else{
			  alert("操作失败！请重试");
		  }
		}
	}
</script>

<style>

#appoBox{

 width: 900px;
 margin: 0 auto;
}
  #calendar
    {
        width: 900px;
        margin: 0 auto;
    }
</style>
<title>我的预约</title>
</head>
<body>
 <div id="wrap">
        <div id='calendar' style="width: 48%;height: 48%;margin-left: 40px;margin-top:3%;height: 0px">
        </div>
        <div id="appoBox" style="border: 2px solid;width:40%;margin-top: 5%;margin-left:57%;font-family: KaiTi_GB2312;font-size: 18pt;float: left ;" >
         <div class="rowElem" style="height: 45px;margin-top: 10px;">
            <label>预约专家：</label><label id="expertName"><%=doctorName%></label>
            <br>
        </div>
         <div class="rowElem" style="height: 45px;margin-top: 10px;">
            <label>预约价格：</label><label id="price"></label>   <br>
        </div>
          <div class="rowElem" style="height: 45px;margin-top: 10px;">
            <label>预约时间：</label><input id="appoTime" name="appoTime"  style="height: 25px;font-family: KaiTi_GB2312;font-size: 18pt;width: 70%;"  readonly/>
            <br>
        </div>
        <div class="rowElem" style="height: 45px;margin-top: 10px;">
           <label style="margin-top: 20px;">预约内容:</label>
           <br>
           <textarea  id="title" name="title"  style="margin-top:0px;;margin-left:120px;;height: 80px;font-family: KaiTi_GB2312;font-size: 15pt;width: 70%;"></textarea>
		 </div>
		 <div id="mysubmit" style="margin-top:90px;float:right;margin-right:20px;">
				    <img src="${url}/image/largebutton_subsave.png" onclick="check();" style="float:right;height: 35px">
		 </div>
         </div>
            
	 	</div>
</body>
</html>