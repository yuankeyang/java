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
    function getAppointMent(){
	    $.ajax({
	        url : '<%=templateUrl%>/expe/AppointMentBriefForRead',
			type : 'POST',
			contentType : "application/json; charset=utf-8",
			dataType : 'json',
			timeout : 8000,
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
			$('#acceptAccount').html(data.acceptAccount);
			$('#rejectAccount').html(data.rejectAccount);
			//alert(num);
			$("#recAID").html(num);
			if(parseInt(data.acount)!=0){
			   var th=$("<thead><tr align='center'height='40px' bgcolor='#BFA789' class='xu' style='color: #FFF;'><th>[序号]</th><th>[患者] </th><th>[预约内容 ]</th><th>[预约时间]</th><th>[处理结果]</th><th>[对方是否违约]</th></tr></thead>");
			   th.appendTo("#records");
			    $.each(data.AppointmentArray,function(index) {
					//具体信息
					var s1 = "<tr align='center' height='40px' bgcolor='#FFFFFF' style='font-size: 16px;color: #000;'><td>"+ (index + 1)+ "</td>";
					var s2 ="<td>"+data.AppointmentArray[index].userId+"</td>";
					var s3 ="<td>"+data.AppointmentArray[index].brief+"</td>";
					var s4 = "<td>"+data.AppointmentArray[index].time+"</td>";
					//var s5="<td>"+data.AppointmentArray[index].state+"</td>";//处理状态
					//onclick=\"javascript:collectExpert(this,'"+data.doctorArray[index].userId+"');\"
					var s5="<td><a title=\"点击改变处理状态\" href='javascript:void(0)'   id="+data.AppointmentArray[index].appointment_id+" onclick=\"javascript:dealAppoint(this,'"+data.AppointmentArray[index].isAccept+"');\">"+data.AppointmentArray[index].state+"</a></td>";
					var s6="<td><a title=\"点击改变违约状态\" href='javascript:void(0)'  id="+data.AppointmentArray[index].appointment_id+" onclick=\"javascript:dealDefaultMemb(this,'"+data.AppointmentArray[index].isdefaultMemb+"');\">"+data.AppointmentArray[index].defaultMemb+"</a></td></tr>";
					//var s7="<td>"+data.AppointmentArray[index].defaultMemb+"</td></tr>";
					var tr=$(s1+s2+s3+s4+s5+s6);
				    tr.appendTo("#records");
			  });
			    $('#records').show();
		 }
	  }
	}
    function dealAppoint(obj,isAccept){
			 var Appointment_Id = $(obj).attr("id");
			 //alert(Appointment_Id);
			 $.ajax({
			        url : '<%=templateUrl%>/expe/AppointMentAction?appointment_id='+Appointment_Id+"&isAccept="+isAccept,
					type : 'POST',
					contentType: "application/x-www-form-urlencoded; charset=utf-8", 
					dataType : 'text',
					timeout : 8000,
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
					window.location="myappoint";
				  }else{
					  alert("操作失败！请重试");
				  }
				}
    }
    function dealDefaultMemb(obj,isdefaultMemb){
		 var Appointment_Id = $(obj).attr("id");
		 //alert(Appointment_Id);
		 $.ajax({
		        url : '<%=templateUrl%>/expe/UpdateDefaultMembAction?appointment_id='+Appointment_Id+"&isdefaultMemb="+isdefaultMemb,
				type : 'POST',
				contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				dataType : 'text',
				timeout : 8000,
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
				window.location="myappoint";
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
	<div>
		<img src="${url}/imgs/membercenter/left.png" />&nbsp;&nbsp;<span
			style="font-family:'仿宋';font-size:33px;color:#c9b28b;">我的预约</span>&nbsp;&nbsp;<img
			src="${url}/imgs/membercenter/right.png" />
	</div>
	<br/>
	<div class="user_center_bigtitle" style="font-family: '宋体' ;font-size: 18px;">
		<h3>已处理的预约信息(接受：
		<a id="acceptAccount" href="javascript:void(0)">0</a>
		；拒绝 : <a id="rejectAccount" href="javascript:void(0)">0</a> )</h3>
		<hr></hr> 
	</div>

	<div class="my_dis_diray">
		<div class="my_dis_diray_con">
			<div class="mg_info" style="font-family: '宋体' ;font-size: 18px;">
				<h3>
					总共有<a id="recAID" href="javascript:void(0)"></a>条预约记录
				</h3>
				<table id="records" width="800" border="0"  style="font-weight:bold;">
                </table>
			</div>
		</div>
	</div>

</body>

</html>
