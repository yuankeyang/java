<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
 
<jsp:include page="/WEB-INF/include/core_head.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${url}/css0623/index.css"/>
<title>主页</title>
<jsp:include page="/WEB-INF/include/head.jsp"></jsp:include>
</head>
<script type="text/javascript">
<%
String info=request.getParameter("reginfo");
if(info!=null) {
%>
alert("注册成功！");
<%
}
%>
</script>
<body>
	<!--背景图-->
	<img class="bg-01" src="imgs/bg-01.jpg"/>
	<span class="headerBg"></span>
	<span class="footerBg"></span>
	<span class="indexBgLeft"></span>
	<span class="indexBgRight"></span>
	<span class="logo"></span>
	<!--首页内容-->
	<div class="indexCon">
		<img class="logo" src="imgs/logo.png"/>
		<p class="callCen">
			<s:a namespace="/" action="welcome">健康咨询平台</s:a>
		</p>
		<ul>
		<jsp:include page="/WEB-INF/include/topbar.jsp"></jsp:include>
		</ul>
	</div>
	<!--切换-->
	<div class="indexFind">
		<ul id="turnBg">
			<li id="choose1" value="qiuyi">
				<div id="choose1" class="con">
					<img id="choose1" class="top" src="${url}/imgs/nav_braceTop.png"/>
					<span id="choose1">求医</span>
					<img  id="choose1" class="bottom" src="${url}/imgs/nav_bracebottom.png"/>
				</div>
			</li>
			<li id="choose2" value="wenyao">
				<div class="con" id="choose2">
					<img id="choose2" class="top" src="${url}/imgs/nav_braceTop.png"/>
					<span id="choose2">问药</span>
					<img id="choose2" class="bottom" src="${url}/imgs/nav_bracebottom.png"/>
				</div>
			</li>
			<li id="choose3" value="yangsheng">
				<div id="choose3" class="con">
					<img id="choose3" class="top" src="${url}/imgs/nav_braceTop.png"/>
					<span id="choose3">养生</span>
					<img id="choose3" class="bottom" src="${url}/imgs/nav_bracebottom.png"/>
				</div>
			</li>
		</ul>
	</div>
	<!--搜索-->
	<form id="searchIn"  method="get">
		<input type="text" name="search_str" id="search_str" maxlength=200 />
		<input type="button" value="搜索"/>
	</form>
	<div class="footer">
	<p>颐健通研发小组</p>
	<p>&#169;版权所有 2015-2016</p>
	</div>
	<jsp:include page="/WEB-INF/include/login.jsp"></jsp:include>
</body>

</html>