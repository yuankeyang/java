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
<link rel="stylesheet" type="text/css" href="${url}/css/style.css"/>
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script>
    function getAppointMent(){
	    $.ajax({
	        url : '<%=templateUrl%>/expe/AppointMentBrief',
			type : 'POST',
			contentType : "application/json; charset=utf-8",
			dataType : 'json',
			timeout : 18000,
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
			var num = data.acount;
			//alert(num);
			$("#recAID").html(num);
			if(parseInt(data.acount)!=0){
			   var th=$("<thead><tr align='center'height='40px' bgcolor='#BFA789' style='color: #FFF;'> <th>序号</th><th>患者 </th><th>内容简介 </th><th>预约时间</th><th colSpan='2'>操     作</th></tr></thead>");
			   th.appendTo("#records");
			    $.each(data.AppointmentArray,function(index) {
					//具体信息
					var s1 = "<tr align='center' height='40px' bgcolor='#FFFFFF' style='font-size: 16px;color: #000;'><td>"+ (index + 1)+ "</td>";
					var s2 ="<td>"+data.AppointmentArray[index].userId+"</td>";
					var s3 ="<td>"+data.AppointmentArray[index].brief+"</td>";
					var s4 = "<td>"+data.AppointmentArray[index].time+"</td>";
					//相关操作
					var s5="<td><a title=\"接受它\" href='javascript:void(0)' id="+data.AppointmentArray[index].appointment_id+" class='accept'>接受</a></td>";
					var s6="<td><a title=\"拒绝它\" href='javascript:void(0)' id="+data.AppointmentArray[index].appointment_id+" class='reject'>拒绝</a></td></tr>";
					var tr=$(s1+s2+s3+s4+s5+s6);
				    tr.appendTo("#records");
			});
			    $('#records').show();
			    $(".accept").click(function (){
			    	dealAppoint(this,1);
			    });
			    $(".reject").click(function (){
			    	dealAppoint(this,0);
			    });
		 }
	  }
	}
    function dealAppoint(obj,isAccept){
    	 
    	    var statu=confirm("确定执行该操作?");
			if(!statu){
				return false;
			}
			 var Appointment_Id = $(obj).attr("id");
			 //alert(Appointment_Id);
			 $.ajax({
			        url : '<%=templateUrl%>/expe/AppointMentAction?appointment_id='+Appointment_Id+"&isAccept="+isAccept,
					type : 'POST',
					contentType: "application/x-www-form-urlencoded; charset=utf-8", 
					dataType : 'text',
					timeout : 18000,
					cache : true,
					error : erryFunction, //错误执行方法  
					success : succFunction
				//成功执行方法  
				});
			 function erryFunction() {
					alert("操作失败");
				}
			 function succFunction(data) {
				 var data = String($.trim(data)); 
				 if(data=='yes'){
					alert("操作成功");
					$("#"+Appointment_Id).parent().parent().remove();
					$("#recAID").html($("#records tr").length-1);
					if($("#records tr").length==1){
						$("#records thead").remove();
						$("#records").hide();
					}
				  }else{
					  alert("操作失败！请重试");
				  }
				}
    }
	window.onload = function() {
		getAppointMent();
		$("#recAID").click(function(){
			 $("#records").toggle();
		 });
	};
	
</script>
</head>
<body>
<div><img src="${url}/imgs/left.png"/>&nbsp;&nbsp;<span style="font-family:'仿宋';font-size:33px;color:#c9b28b">预约管理</span>
		&nbsp;&nbsp;<img src="${url}/imgs/right.png"/></div>

	<div class="my_dis_diray">
		<div class="my_dis_diray_con">
			<div class="mg_info">
				<h3>
					总共有（<a id="recAID" href="javascript:void(0)"></a>）条预约记录
				</h3>
				<table id="records" width="780" border="0"></table>
			</div>
		</div>
	</div>

</body>

</html>
