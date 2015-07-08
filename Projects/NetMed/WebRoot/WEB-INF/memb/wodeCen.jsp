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
<link rel="stylesheet" type="text/css" href="${url}/css0623/wodeCen.css" />
</head>
<body >
  <div id="right">
		<div><img id="left-img" src="${url}/imgs/left.png"/><span>我的中心</span>
		<img id="right-img" src="${url}/imgs/right.png"/></div>
		<div style="font-family:'宋体';font-weight:bold;font-size:24px;margin:13px 0 0 335px;">[最近通知]</div>
		<div>
		<table width="800px" height="40px" cellpadding="0" cellspacing="0" style="margin-top:20px;">
		<tr><td align="center"bgcolor="#F5ECE2" style="font-family:'宋体';font-size:18px;color:#000;">暂无任何信息</td></tr>
		</table>
		</div>
	</div>
</body>
</html>