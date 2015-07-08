<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<style>
#passConDiv{display:block;}
#newpassConDiv{display:none;}
</style>
</head>
<body>
<div id="passConDiv">
   <span>请输入原密码:</span>
   <s:form method="post" id="passConForm">
   <input id="passConInput" type="text">
   <input id="submit1" type="button" value="提交">
    </s:form>
</div>
<div id="newpassConDiv">
   <span>请输入新密码:</span>
   <s:form method="post" id="newpassConForm">
   <input id="newpassConInput" type="text">
   <input id="renewpass" type="text">
   <input id="submit2" type="button" value="提交">
    </s:form>
</div>
<script>
$(function(){
	var passReg=/^[a-zA-Z0-9]{6,15}$/;
	$("#submit1").click(function(){
	var pass=$("#passConInput").val();
	if(!passReg.test(pass)){
	alert("密码由英文字母及数字组成，6到15位！");	
	}else{
		$("#passConForm").submit();
		$.ajax({
			url:'passCheck',
			success:function(){},
			error:function(){alert("加载信息错误");},
			async:false
			});
	}
	});
	
	$("#submit2").click(function(){
		var newpass=$("#newpassConInput").val();
		if(!passReg.test(pass)){
			alert("密码由英文字母及数字组成，6到15位！");	
			}
	});
});
</script>
</body>
</html>