<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String error=request.getAttribute("error").toString();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<script type="text/javascript">
	function redirect(){
	history.go(-1);
	}
	window.setTimeout(redirect,3000);
	</script>
	
  </head>
  
  <body>
   <%if(error.equals("1")){%>
   <h2>用户名错误！</h2>
   <%}else{%>
   <h2>密码错误!</h2>
   <%}%>
   <p>3秒后跳转</p>
  </body>
</html>
