<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="dbmanager" class="com.Bean.db_manager"></jsp:useBean>
<%
String username=(String)session.getAttribute("username");
	%>
	<div>
	<script type="text/javascript">
	
		function saveChange(){
			var nameReg=/^[a-zA-Z][a-zA-Z0-9_]{5}$/;
			var mobileReg=/^1[3|4|5|8][0-9]\d{4,8}$/;
			var mailReg=/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
			var name=$("#username1").val();
			var mobile=$("#phone1").val();
			var mail=$("#mail1").val();
			if(!nameReg.test(name)){
				alert("用户名由英文字母和数字组成，英文开头开头，输入6位");
			}else if(!mobileReg.test(mobile)){
				alert("手机号码填写不正确");
			}else if(!mailReg.test(mail)){
				alert("邮箱填写不正确");
			}else{
				$("#change").submit();
			}
		}
	</script>
	<s:form id="change" method="post" action="fixCheck">
<table border="1" style="font-size:20px">
	<tr><th>昵称</th><td><input id="username1" name="memb_id" type="text" placeholder="<%= username%>"></td></tr>
	<tr><th>手机号码</th><td><input id="phone1" name="memb_mobile" type="text"  placeholder="<%=session.getAttribute("phoneNum")%>"></td></tr>
	<tr><th>邮箱</th><td><input id="mail1" name="memb_mail" type="text"  placeholder="<%=session.getAttribute("mail")%>"></td></tr>
	<tr><td><input type="reset" value="重置"></td><td><input onclick="saveChange()" type="button" value="保存"></td></tr>
</table>
</s:form>
</div>
