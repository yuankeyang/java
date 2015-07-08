<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.Date"%>
<%@ page language="java" import="java.sql.*"%>
<%
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	String expeId = (String) session.getAttribute("expename");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${url}/css/style.css" />
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script>
		$(function() {
			var passReg = /^[a-zA-Z0-9]{6,15}$/;
			$("#submit1").click(function() {
				var pass = $("#passConInput").val();
				if (!passReg.test(pass)) {
					alert("密码由英文字母及数字组成，6到15位！");
				} else {
					$.ajax({
				        url : '<%=templateUrl%>/expe/EnsurePassAction',
						type : 'get',
						data:"passConInput="+$('#passConInput').val(),
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
							$('#passConDiv').hide();
							$('#newpassConDiv').show();
						}else{
							alert("密码错误!请重试");
						}
						//window.location="gerenInfo";
					}
				}
			});

			$("#submit2").click(function() {
				var newpass = $("#newpassConInput").val();
				alert(newpass);
				if (!passReg.test(newpass)) {
					alert("密码由英文字母及数字组成，6到15位！");
				}else{
					$.ajax({
				        url : '<%=templateUrl%>/expe/UpdatePassAction',
						type : 'get',
						data:"newpassConInput="+$('#newpassConInput').val(),
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
							window.location="passChange";
						}else{
							alert("密码修改错误!请重试");
						}
					}
				}
			});
		});
	</script>
</head>
<body>
<div><img src="${url}/imgs/left.png"/>&nbsp;&nbsp;<span style="font-family:'仿宋';font-size:33px;color:#c9b28b;">修改密码</span>
		&nbsp;&nbsp;<img src="${url}/imgs/right.png"/></div>
	<div id="passConDiv" style="display: block;margin-top:30px;margin-left:200px">
		<span>请输入原密码:</span>
			<input id="passConInput" type="text"> 
			<input id="submit1"	type="button" value="提交">
	</div>
	<div id="newpassConDiv" style="display: none;margin-top:30px;margin-left:200px">
		<span>请输入新密码:</span>
			<input id="newpassConInput" type="text"><br/>
			<span> 新密码确认:</span>
			 <input
				id="renewpass" type="text"> <br/><input id="submit2"
				type="button" value="提交">
	</div>
	
</body>
</html>