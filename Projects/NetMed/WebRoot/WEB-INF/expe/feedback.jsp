<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", -10);
%>
<%
	String basepath = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/include/head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${url}/css0623/style.css" />
</head>
<body>
	<div id="right">
		<div>
			<img src="${url}/imgs/membercenter/left.png" />&nbsp;&nbsp;<font
				size="6"><b>意见反馈</b>
			</font>&nbsp;&nbsp;<img
				src="${url}/imgs/membercenter/right.png" />
		</div>
		
		<br/>
		<div style="font-family: '宋体';font-size: 18px;">
			<p>亲爱的用户:</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;您好！</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;如果您有任何意见，请编辑您宝贵的意见发送到我们的邮箱：<font color="green"><b>yijiantong@163.com</b></font>，或者拨</p>
			<p>打我们的热线电话：<font color="green"><b>0731-88821978</b></font>，我们会认真听取您的意见！</p>
		</div>
	</div>
</body>
</html>