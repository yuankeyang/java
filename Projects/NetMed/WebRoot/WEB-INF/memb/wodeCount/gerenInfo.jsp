<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.Date"%>
<%@ page language="java" import="java.sql.*"%>
<%
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	String userId = (String) session.getAttribute("username");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%--<link rel="stylesheet" type="text/css" href="${url}/css/style.css" />--%>
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script type="text/javascript">
	function change() {
		$("#origin").hide();
		$("#xiugai").show();
	}
	function saveChange() {
		//var nameReg = /^[a-zA-Z][a-zA-Z0-9_]{5}$/;
		var mobileReg = /^1[3|4|5|8][0-9]\d{4,8}$/;
		var mailReg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
		var name = $("#username1").val();
		var mobile = $("#phone1").val();
		var mail = $("#mail1").val();
		//if (!nameReg.test(name)) {
		//	alert(name);
		//	alert("用户名由英文字母和数字组成，英文开头开头，输入6位");
		//} else
		if (!mobileReg.test(mobile)) {
			alert("手机号码填写不正确");
		} else if (!mailReg.test(mail)) {
			alert("邮箱填写不正确");
		} else {
			///$("#change").submit();
			submit();
		}
	}
	function submit(){
		$.ajax({
	        url : '<%=templateUrl%>/user/UpdatePersonInfoAction',
			type : 'get',
			data:"memb_name="+$('#username1').val()+"&memb_mobile="+$('#phone1').val()+"&memb_mail="+$('#mail1').val(),
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			dataType : 'text',
			timeout : 8000,
			cache : true,
			errot:erryFunction,
			success : succFunction
		//成功执行方法  
		});
		function erryFunction() {
			alert("有错误，请刷新页面");
		}
		function succFunction(data) {
			var  data= String($.trim(data)); 
			if(data=="yes"){
				alert("修改成功");
				window.location="gerenInfo";
			}else{
				alert("信息填写有误!请重试");
			}
		}
		}
	window.onload = function(){
		//获取个人信息
		getGeRenInfo();
	};
	function getGeRenInfo(){
		$.ajax({
	        url : '<%=templateUrl%>/user/GetPersonInfoAction',
	        type : 'POST',
	        contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			 dataType : 'json',
			 timeout : 18000,
			 cache : true,
			 error : erryFunction, //错误执行方法  
			 success : succFunction	//成功执行方法  
			});
			function erryFunction() {alert("获取个人信息出错，请重试!!");}
			function succFunction(data) {
				$('#username').text(data.username);
				$('#phone').text(data.phone);
				$('#mail').text(data.mail);
				
				//$('#username1').val(data.username);
				//$('#phone1').val(data.phone);
				//$('#mail1').val(data.mail);
		};
	}
</script>
</head>
<body>
<div align="center" style="margin-top: 10px;">
<div><img src="${url}/imgs/left.png"/>&nbsp;<span style="font-family:'宋体';font-size:30px;color:#c9b28b;">修改个人信息</span>&nbsp;<img src="${url}/imgs/right.png"/></div>
		
	<div id="origin" style="height: 60px;margin-top: 30px;" align="center">
	<table style="font-family:'宋体';font-size: 15pt; text-align: left;">   <!-- 宋体 -->
		<tr>	
		   <td><label>姓名:</label></td>
		   <td><label id="username"></label></td>
		</tr>
		<tr> 
			<td><label>手机号码:</label></td>
			<td><label id="phone"></label></td>
		</tr>
		<tr> 
			<td><label>邮箱:</label></td>
			<td><label id="mail"></label></td>
		</tr>
		<tr>
		  <td colspan="2">
			<input type="button" onclick="change();" value="修   改" style="font-family:'宋体';font-size: 15pt;text-align:center">
		  <td>
		</tr>	
	</table>
	</div>

	<div id="xiugai" style="display:none;margin-top: 30px;">
		<form id="change" method="get" action="UpdateExpePersonInfoAction">
			<table style="font-family:'宋体';font-size: 15pt; text-align: center;">
				<tr>	
				   <td><label>姓名:</label></td>
				   <td><input id="username1" name="expe_name" type="text" ></td>
				</tr>
				<tr> 
					<td><label>手机号码:</label></td>
					<td><input id="phone1" name="expe_mobile" type="text"	></td>
				</tr>
				<tr> 
					<td><label>邮箱:</label></td>
					<td><input id="mail1" name="expe_mail" type="text"></td>
				</tr>
				<tr>
				  <td>
					<input type="reset" value="重置" style="font-family: '宋体';font-size: 15pt;"/>
				  <td>
				
				  <input onclick="saveChange()" type="button" value="保存" style="font-family:'宋体';font-size: 15pt;">
				  </td>
				</tr>	
			</table>
		</form>
	</div>
</div>
</body>
</html>
