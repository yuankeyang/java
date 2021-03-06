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
<link rel="stylesheet" type="text/css" href="${url}/css0623/style.css" />
<script type="text/javascript" src="${url}/js/jquery.js"></script>
</head>
<body>
<div><img src="${url}/imgs/left.png"/>&nbsp;<span style="font-family:'仿宋';font-size:33px;color:#c9b28b">患友会</span>
		&nbsp;<img src="${url}/imgs/right.png"/></div>
	
	<div class="hy_title clearfix pr" style="font-family:'宋体';">
		<h2 class="fl">我的患友会</h2>
		<span class="fr"><strong>！！</strong>发表话题请先进入相应的小组</span>
	</div>
	<div class="hy_wel" style="font-family:'宋体';">
		<p>
			尊敬的<span class="orange">xianggen</span>用户：
		</p>
		<p>欢迎您来到患友会！</p>
		<p>患友会是每个大夫个人网站下的一个分组讨论区，如跟医生交流过，您就有机会加入他的患友会.</p>
	</div>
	<div class="hy_method" style="font-family:'宋体';">
		<h2 class="orange">入会方式：</h2>
		<h3>1.医生的患友会小组</h3>
		<p>当您向医生咨询并且得到医生2次回复时，即可自动入会。</p>
		<h3>2.医生的专业组</h3>
		<p>医生根据您的疾病、地区、病情、治疗等方面，邀请您加入患友会。</p>
		<p>
			如您还没有入会，欢迎您随时加入。 (如何使用患友会？)
		</p>
	</div>
</body>
</html>