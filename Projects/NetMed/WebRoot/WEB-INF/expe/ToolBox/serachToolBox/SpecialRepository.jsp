<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.Date"%>
<%@ page language="java" import="java.sql.*"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
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
<script type="text/javascript" src="${url}/js/jquery.pagination.js"></script>
<script>

	function check() {
		if ($('#search_ToolBox').val() == "") {
			alert("输入框不能为空!");
		} else {
			$('#SerachToolBox').submit();
		}
	}
</script>

<style type="text/css">
.mainContext {
	width: 700px;
	margin-left:80px;
	padding: 0;
}

.leftContext {
    margin-left:10px;
	float: left;
	width: 300px;
}

.rightContext {
    margin-right:100px;
	float: right;
	width: 300px;
}

</style>

</head>

<body>
<div><img src="${url}/imgs/left.png"/>&nbsp;<span style="font-family:'仿宋';font-size:33px;color:#c9b28b">专业知识库</span>
		&nbsp;<img src="${url}/imgs/right.png"/></div>
	<div style="margin-top:10px">
		<font size="5" color="#BFA789">我的专科：</font>&nbsp;<font size="4" color="#BFA789">中医内科>>中医脑病</font>
	</div>
	
	<div class="mainContext"
		style="margin-top:80px;width: 80%;font-family:'宋体';font-size:8pt">
		
		<div class="leftContext">
		   <h2>中医</h2>
		<ul>
		   <li class="specialRepositoy"><a  href="http://www.zygjw.net/Item/list.asp?id=1227">中医脑病古籍经典原文</a></li>
		   <br/>
		   <li class="specialRepositoy"><s:a href="FamousPrescrip">名医名家脑病名方验案</s:a></li>
		   <br/>
		   <li class="specialRepositoy"><a href="javascript:void(0)" onclick="alert('正在实现中')">颐健通脑病数据挖掘资源库</a></li>
		</ul>
		
		</div>

		<div class="rightContext">
		
		   <h2>西医 </h2>
		<ul>
		   <li class="specialRepositoy"><a href="http://guide.medlive.cn/">神经科临床指南</a></li>
		    <br/>
		   <li class="specialRepositoy"><a  href="http://guide.medlive.cn/guideline/list?branch=2">神经科常用量表</a></li>
		    <br/>
		   <li class="specialRepositoy"><a  href="http://paper.medlive.cn/">神经科医学期刊</a></li>
		   <br/>
		   <li class="specialRepositoy"><a  href="http://disease.medlive.cn/wiki/">神经科影响图谱</a></li>
		</ul>
		
		</div>

		<div id="Pagination" class="pager"></div>
	</div>

</body>
</html>
