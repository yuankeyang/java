<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="../include/topReg.jsp"></jsp:include>
<script type="text/javascript" src="${url}/js0623/jquery-1.11.1.js"></script>
<style style="text/css">
<!--
body {
	background-color:#FFF;
	background-image:url(${url}/image/asidepic05.png);
	background-repeat: repeat;
}
-->

</style>
<script charset="utf-8" type="text/javascript">

</script>
<div id="page">
	<div id="header">
		<h1>普通用户注册</h1>
	</div>
	<div id="content">
		<p id="status"></p>
		<s:form action="user-regi-chec" method="post" id="user-reg">
			<fieldset>
				<legend>用户信息</legend>
				<ul>
                	<li>
						<label for="username">
							<span class="required">昵称</span>
						</label>
						<input id="username" name="username" type="text">
						<label for="username" class="error">必须由字母数字下划线组成</label>
					</li>
					<li>
						<label for="email">
							<span class="required">认证邮箱</span>
						</label>
						<input id="email" name="email" type="text">
						<label for="email" class="error">必须是一个有效的邮箱地址</label>
					</li>
					<li>
						<label for="sex">
							<span class="required">性别</span>
						</label>
						<input name="sex" type="radio" value="male" checked="checked">男&nbsp;&nbsp;
						<input name="sex" type="radio" value="female">女
					</li>
					<li>
						<label for="password">
							<span class="required">密码</span>
						</label>
						<input name="password" type="password" id="password">
					</li>
                    <li>
						<label for="repass">
							<span class="required">重新输入密码</span>
						</label>
						<input type="password" id="repass" name="confirm_password">
					</li>
					<li>
						<label class="centered info"><a id="forgotpassword" href="#">找回密码</a>
						</label>
					</li>
				</ul>
			</fieldset>
			<fieldset class="submit">
				<input type="submit" class="submit" value="注册">
			</fieldset>
			<div class="clear"></div>
		</s:form>
	</div>
</div>
</body>
</html>