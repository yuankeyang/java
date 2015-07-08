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
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${url}/css0623/style.css" />
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script type="text/javascript" src="${url}/js/jquery.validate.js"></script>
<script type="text/javascript" src="${url}/js/register.js"></script>
<script src='${url}/schedule/jquery-ui-1.11.4/jquery-ui.min.js'></script>
<script src='${url}/schedule/jQuery-Timepicker-Addon-master/datepicker-zh.js'></script>

<script type="text/javascript">
window.onload = function(){

    $('#birthday').datepicker({
            changeMonth: true ,
            changeYear: true ,
            yearRange: '1900:2099', //取值范围.
            dateFormat: 'yy-mm-dd',
            showOn: 'both', //输入框和图片按钮都可以使用日历控件。
            buttonImage: '${url}/image/calendar.gif', //日历控件的按钮
            buttonImageOnly: true,
            showButtonPanel: true
    });  
};
</script>

<title>新增睡眠记录</title>
</head>
<style>

</style>
<body>
<div id="page">
<form id="SleepRecord" name="NewSleepRecordAction"  method="post" action="NewSleepRecordAction">
	<div><img src="${url}/imgs/left.png"/>&nbsp;<span style="font-family:'仿宋';font-size:33px;color:#c9b28b">新建睡眠信息</span>
		&nbsp;<img src="${url}/imgs/right.png"/></div>
	<br/>
	<table class="wwFormTable" style="font-family: '宋体';font-size: 18px;">
			<fieldset>
				<ul>
                	<li>
						<label for="fallSleep">
							<span class="required" style="font-family: '宋体';font-size: 18px;width:150px;display:inline-block;"><b>[初入睡时间]</b></span>
						</label>
						<input id="fallSleep" name="fallSleep" type="text">
					</li>
					<br/>
					<li>
						<label for="sleepDuration">
							<span class="required" style="font-family: '宋体';font-size: 18px;width:150px;display:inline-block;"><b>[睡眠时间长度]</b></span>
						</label>
						<input name="sleepDuration" type="text" id="sleepDuration">
					</li>
					<br/>
					<li>
						<label for="deepDuration">
							<span class="required" style="font-family: '宋体';font-size: 18px;width:150px;display:inline-block;"><b>[熟睡总时间]</b></span>
						</label>
						<input name="deepDuration" type="text" id="deepDuration">
					</li>
					<br/>
					<li>
						<label for="simpleDuration">
							<span class="required" style="font-family: '宋体';font-size: 18px;width:150px;display:inline-block;"><b>[浅睡总时间]</b></span>
						</label>
						<input id="simpleDuration" name="simpleDuration"  type="text">
					</li>
					<br/>
					<li>
						<label for="dreamDuration">
							<span class="required" style="font-family: '宋体';font-size: 18px;width:150px;display:inline-block;"><b>[醒/做梦总时间]</b></span>
						</label>
						<input name="dreamDuration" type="text" id="dreamDuration">
					</li>
					<br/>
					<li>
						<label for="breathIndex">
							<span class="required" style="font-family: '宋体';font-size: 18px;width:150px;display:inline-block;"><b>[呼吸中止指数]</b></span>
						</label>
						<input name="breathIndex" type="text" id="breathIndex">
					</li>
				</ul>
			</fieldset>
			<fieldset>
			<p><font size="2" color="red">注：时间长度格式为××h××m(如:5h28m)，呼吸中止指数带1位小数(如:4.3)</font></p>
			</fieldset>
			<fieldset class="submit">
				<input type="submit" class="submit" value="确认" style="margin-left:500px"/>
			</fieldset>
			<div class="clear"></div>
		</table></form>
</div>
</body>
</html>