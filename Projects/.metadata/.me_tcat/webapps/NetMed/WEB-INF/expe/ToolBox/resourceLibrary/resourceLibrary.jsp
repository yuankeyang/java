<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.Date"%>
<%@ page language="java" import="java.sql.*"%>
<%
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${url}/css/style.css" />
<script type="text/javascript" src="${url}/js/jquery.js"></script>

<script>
	function check() {
		if ($('#search_ToolBox').val() == "") {
			alert("输入框不能为空!");
		} else {
			$('#SerachToolBox').submit();
		}
	}
</script>
</head>

<body>
<div><img src="${url}/imgs/left.png"/>&nbsp;&nbsp;<span style="font-family:'仿宋';font-size:33px;color:#c9b28b">资料库</span>
		&nbsp;&nbsp;<img src="${url}/imgs/right.png"/></div>
	<div style="width: 90%;">
		<div style="margin-left: 70px">
			<form method="get" id="ResourceLibrary" action="ResourceLibrary">
				<h1>
					<label style="font-family:'宋体';margin-left:200px">资料库搜索</label>
				</h1>
				<div align="center">
					<img src="${url}/image/normalbutton_a.png" onclick="check();"
						style="height: 36px;margin-left:10px;float: right;margin-right: 150px" />
					<input type="text" name="search_ToolBox" value="" id="search_ToolBox" maxlength=200
						placeholder="请输入资料名..." style="width: 60%;height: 40px;float: right;font-family:'宋体';font-size:18px;border-radius:8px" />
				</div>
			</form>
		</div>
		<br />

		<div style="margin-top:50px;margin-left:130px;width: 80%;">
			<div style="" class="container" id="toolBox_list">
				<div style="height: 140px;width:600px;margin-top: 10px">
					<a href="http://drugs.medlive.cn/index.jsp"><img
						src="${url}/images/r1.png">
						
					</a> &nbsp;&nbsp;&nbsp; <a href="http://meddic.medlive.cn/index.do"
						><img src="${url}/images/r2.png">
					</a> &nbsp;&nbsp;&nbsp; <a href="http://cals.medlive.cn/"
						><img src="${url}/images/r3.png">
					</a>
				</div>

				<div style="height: 140px;width:600px;margin-top: 20px">
					<a href="http://inspects.medlive.cn/"><img
						src="${url}/images/r4.png">
					</a> &nbsp;&nbsp;&nbsp; <a href="http://jour.medlive.cn/"
						> <img src="${url}/images/r5.png">
					</a> &nbsp;&nbsp;&nbsp; <a href="http://mesh.medlive.cn/"
						><img src="${url}/images/r6.png">
					</a>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
