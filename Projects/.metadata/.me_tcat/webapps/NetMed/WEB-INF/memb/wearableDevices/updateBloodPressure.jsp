<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", -10);
%>
<%
String templateUrl = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath();
request.setAttribute("url", templateUrl);
String bloodPressureId = request.getParameter("bloodPressureId");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${url}/css0623/style.css" />
<link rel='stylesheet'href='${url}/schedule/jquery-ui-1.11.4/jquery-ui.css' />
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script type="text/javascript" src="${url}/js/jquery.validate.js"></script>
<script type="text/javascript" src="${url}/js/register.js"></script>
<script src='${url}/schedule/jquery-ui-1.11.4/jquery-ui.min.js'></script>
<script src='${url}/schedule/jQuery-Timepicker-Addon-master/datepicker-zh.js'></script>

<script type="text/javascript">

function getMembFamilyById(){
	    //alert('<%=bloodPressureId%>');
	    $.ajax({
	        url : '<%=templateUrl%>/user/ReadBloodPressureDetail?bloodPressureId=<%=bloodPressureId%>',
			type : 'POST',
			contentType : "application/json; charset=utf-8",
			dataType : 'json',
			timeout : 18000,
			cache : true,
			error : erryFunction, //错误执行方法  
			success : succFunction
		//成功执行方法  
		});
		function erryFunction() {
			//alert("请刷新页面!!");
		}
		function succFunction(data) {
			$("#consultName").val(data.consultName);
			//$("input:radio[name='sex']").eq(parseInt(data.sex)).attr("checked",true);
			$("#shouSuoYa").val(data.shouSuoYa);
			$("#shuZhangYa").val(data.shuZhangYa);
			$("#bloodOxygen").val(data.bloodOxygen);
			$("#temperature").val(data.temperature);
		}
	}
	window.onload = function() {
		getMembFamilyById();
	};
</script>

<title>更新血压记录</title>
</head>
<style>
</style>
<body>
<div id="page">
<form  method="post" action="UpdateBloodPressure" id="BloodPressure">
	<div><img src="${url}/imgs/left.png"/>&nbsp;<span style="font-family:'仿宋';font-size:33px;color:#c9b28b">修改血压信息</span>
		&nbsp;<img src="${url}/imgs/right.png"/></div>
	<br/>
	<table class="wwFormTable" style="font-family: '宋体';font-size: 18px;">
			<fieldset>
				<ul>
                	<li>
						<label for="consultName">
							<span class="required" style="font-family: '宋体';font-size: 18px;width:80px;display:inline-block;"><b>[姓名]</b></span>
						</label>
						<input id="consultName" name="consultName" type="text">
						<label for="consultName" class="error">患者姓名不可为空</label>
					</li>
					<br/>
					<li>
						<label for="shouSuoYa">
							<span class="required" style="font-family: '宋体';font-size: 18px;width:80px;display:inline-block;"><b>[收缩压]</b></span>
						</label>
						<input name="shouSuoYa" type="text" id="shouSuoYa">
					</li>
					<br/>
					<li>
						<label for="shuZhangYa">
							<span class="required" style="font-family: '宋体';font-size: 18px;width:80px;display:inline-block;"><b>[舒张压]</b></span>
						</label>
						<input name="shuZhangYa" type="text" id="shuZhangYa">
					</li>
					<br/>
					<li>
						<label for="bloodOxygen">
							<span class="required" style="font-family: '宋体';font-size: 18px;width:80px;display:inline-block;"><b>[血氧]</b></span>
						</label>
						<input id="bloodOxygen" name="bloodOxygen"  type="text">
					</li>
					<br/>
					<li>
						<label for="temperature">
							<span class="required" style="font-family: '宋体';font-size: 18px;width:80px;display:inline-block;"><b>[体温]</b></span>
						</label>
						<input name="temperature" type="text" id="temperature">
					</li>
				</ul>
				
			</fieldset>
			<fieldset class="submit">
			    <input type="hidden" name="bloodPressureId" id="bloodPressureId" value="<%=bloodPressureId%>">
				<input type="submit" class="submit" value="确认" style="margin-left:500px"/>
			</fieldset>
			<div class="clear"></div>
		</table></form>
</div>
</body>
</html>