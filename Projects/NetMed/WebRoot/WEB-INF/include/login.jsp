<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="mask"></div>
<div class="login-div">
<div class="close-div"><a href="javascript:void(0)"><span class="close-btn"></span></a></div>
<div class="login-title"></div>
<div class="loginForm-div">
	<form id="loginForm" method="post">
	<table class="login-table">
	<tr><td>[用户类型]</td><td><select id="usertype">
		<option value="user" selected="selected">普通用户</option>
        <option value="expe">服务专家</option>
        <option value="medical-institutions">服务机构</option>
	</select></td></tr>
	<tr><td>[用 户 名]</td><td><input name="username" type="text" /></td></tr>
	<tr><td>[密   码]</td><td><input name="password" type="password" /></td></tr>
	<tr><td colspan="2"><button id="login-button">登录</button></td></tr>
	<tr><td colspan="2"><a href="javascript:void(0)">忘记密码？</a></td></tr>
	</table>
	</form>
</div>
</div>