<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.Date"%>
<%@ page language="java" import="java.sql.*"%>
<%
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	String name = (String) session.getAttribute("expename");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${url}/css0623/style.css"/>
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script>
    function getMemberAppointment(){
	  // var data=encodeURIComponent(JSON.stringify($('#input_doctor').val()),"utf-8");
	  // alert(encodeURI(encodeURI($('#input_doctor').val())));//验证是否在线
	    $.ajax({
	        url : '<%=templateUrl%>/user/MemberAppointmentBriefForUserRead',
			type : 'POST',
			contentType : "application/json; charset=utf-8",
			dataType : 'json',
			timeout : 10000,
			cache : true,
			error : erryFunction, //错误执行方法  
			success : succFunction
		//成功执行方法  
		});
		function erryFunction() {
			alert("请刷新页面");
		}
		function succFunction(data) {
			//未读消息条数
			var numYD = data.acountYD;
			var numWD = data.acountWD;
			//alert(num);
			$("#recAIDYD").html(numYD);
			$("#recAIDWD").html(numWD);
			if(parseInt(data.acountYD)!=0){
				var th=$("<thead><tr align='center'height='40px' bgcolor='#BFA789' class='xu' style='color: #FFF;'> <th>[序号] </th><th>[专家]</th><th>[病情简介] </th><th>[预约时间]</th><th>[预约结果]</th></tr></thead>");
				th.appendTo("#recordsYD");
     			$.each(data.AppointmentArrayYD,function(index) {
     				//具体信息
					var s1 = "<tr align='center' height='40px' bgcolor='#FFFFFF' style='font-size: 16px;color: #000;'><td>"+ (index + 1)+ "</td>";
					var s2 ="<td>"+data.AppointmentArrayYD[index].expeId+"</td>";
					var s3 ="<td>"+data.AppointmentArrayYD[index].brief+"</td>";
					var s4 = "<td>"+data.AppointmentArrayYD[index].time+"</td>";
					var s5 = "<td>"+data.AppointmentArrayYD[index].state+"</td></tr>";
					var tr=$(s1+s2+s3+s4+s5);
				    tr.appendTo("#recordsYD");
				});
			}
			if(parseInt(data.acountWD)!=0){
				var th=$("<thead><tr align='center'height='40px' bgcolor='#BFA789' class='xu' style='color: #FFF;'> <th>[序号]</th><th>[专家]</th><th>[病情简介] </th><th>[预约时间]</th></tr></thead>");
				th.appendTo("#recordsWD");
				$.each(data.AppointmentArrayWD,function(index) {
					var s1 = "<tr align='center' height='40px' bgcolor='#FFFFFF' style='font-size: 16px;color: #000;'><td>"+ (index + 1)+ "</td>";
					var s2 ="<td>"+data.AppointmentArrayWD[index].expeId+"</td>";
					var s3 ="<td>"+data.AppointmentArrayWD[index].brief+"</td>";
					var s4 = "<td>"+data.AppointmentArrayWD[index].time+"</td></tr>";
					var tr=$(s1+s2+s3+s4);
				    tr.appendTo("#recordsWD");
				});
			}
		}
	}
	window.onload = function() {
		getMemberAppointment();
		$("#recAIDYD").click(function(){
			 $("#recordsYD").toggle();
		});
		$("#recAIDWD").click(function(){
			 $("#recordsWD").toggle();
		 });
	};
	 
</script>
</head>
<body>
	<div><img src="${url}/imgs/left.png"/>&nbsp;&nbsp;<span style="font-family:'仿宋';font-size:33px;color:#c9b28b">我的预约</span>
		&nbsp;&nbsp;<img src="${url}/imgs/right.png"/></div>
	<div class="my_dis_diray">
		<div class="my_dis_diray_con">
			<div class="mg_info" style="font-family: '宋体' ;font-size: 18px;">
				<h3>
					总共有<a id="recAIDYD" href="javascript:void(0)">0</a>条已处理预约
				</h3>
				<table id="recordsYD" width="800" border="1" id="table" bordercolor="#FFFFFF" align="center" style="text-align: center;">
                </table>
<hr></hr>
				<h3>
					总共有<a id="recAIDWD" href="javascript:void(0)">0</a>条未处理预约
				</h3>
				<table id="recordsWD" width="800" border="1" id="table" bordercolor="#FFFFFF" align="center" style="text-align: center;">
                </table>
                <hr></hr>
			</div>
		</div>
	</div>

</body>

</html>
