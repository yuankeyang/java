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
<link rel="stylesheet" type="text/css" href="${url}/css/article.css" />
<script type="text/javascript" src="${url}/js/jquery.js"></script>
</head>

<body>
	文章收藏
	<br>
</body>
</html>
