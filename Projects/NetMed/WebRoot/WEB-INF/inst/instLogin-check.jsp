<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:useBean id="dbmanager" class="com.Bean.db_manager"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${url}/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container">
<%
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	String sql="select * from serv_inst_regi where inst_id='"+username+"'";
	ResultSet rs=dbmanager.query(sql);
	if(rs.next()){
		String password_=new String(rs.getString("inst_pass"));
		if(password_.equals(password)){
			session.setAttribute("instname", username);
			String basePath = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath();
			response.sendRedirect(basePath);
		}else{%>
		<h2 class="page-header">登录失败</h2>
	<p>请检查用户名及密码</p>
	<script type="text/javascript">
	document.title="登录失败";
	function tiaozhuan_1(){
	location.href="<s:url namespace="/" action="welcome"/>";}
	window.setTimeout(tiaozhuan_1,1000);
	</script>
	<%}
	dbmanager.dbclose();
	}else{%>
		<h2 class="page-header">登录失败</h2>
		<p>请检查用户名及密码</p>
		<script type="text/javascript">
		document.title="登录失败";
		function tiaozhuan_1(){
		location.href="<s:url namespace="/" action="welcome"/>";}
		window.setTimeout(tiaozhuan_1,1000);
		</script>
<%}%>
</div>
</body>
</html>