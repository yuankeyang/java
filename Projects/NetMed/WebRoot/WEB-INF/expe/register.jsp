<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="../include/topReg.jsp"></jsp:include>
<style>
<!--
body {
	background-color:#FFF;
	background-image:url(${url}/image/asidepic05.png);
	background-repeat: repeat;
}
-->
</style>
<div id="page">
	<div id="header">
		<h1>专家注册</h1>
	</div>
	<div id="content">
		<p id="status"></p>
		<s:form action="expe-regi-chec" method="get" id="expe-reg">
			<fieldset>
				<legend>专家信息</legend>
				<ul>
					<li>
						<label for="username">
						<span class="required">昵称</span>
						</label>
						<input id="username" name="username" type="text">
						<label for="username" class="error">必须由字母数字下划线组成</label>
					</li>
					<li>
						<label for="realname">
						<span class="required">姓名</span>
						</label>
						<input id="realname" name="realname" type="text">
						<label for="realname" class="error">请输入您的真实姓名</label>
					</li>
					<li>
						<label for="sex">
						<span class="required">性别</span>
						</label>
						<input name="sex" type="radio" value="male" checked="checked">男&nbsp;&nbsp;
						<input name="sex" type="radio" value="female">女
					</li>
					
					<li>
						<label for="id_card_numb">
						<span class="required">身份证号码</span>
						</label>
						<input id="id_card_numb" name="id_card_numb" type="text">
					</li>
					<li>
						<label for="id_pict">
						<span class="required">身份证照片</span>
						</label>
						 <input type="file" id="id_pict" name="uploadFile" />
					</li>
					<li>
					<ul id="typeUl">
					</ul>
					<label>专家类别</label>
					<select id="selectType">
					<option value="1" selected="selected">医师</option>
					<option value="2">药师</option>
					<option value="3">按摩理疗师</option>
					<option value="4">心理咨询师</option>
					<option value="5">健康管理师</option>
					<option value="6">营养师</option>
					</select>
					<button id="addType">添加</button>
					</li>
					<li>
						<label for="phone">
						<span class="required">固定电话</span>
						</label>
						<input id="phone" name="phone" type="text">
						<label for="phone" class="error">为能及时联系到您，请输入您的电话号码</label>
					</li>
					<li>
						<label for="telephone">
						<span class="required">移动电话</span>
						</label>
						<input id="telephone" name="telephone" type="text">
						<label for="telephone" class="error">为能及时联系到您，请输入您的电话号码</label>
					</li>
					<li>
						<label for="email">
						<span class="required">认证邮箱</span>
						</label>
						<input id="email" name="email" type="text">
						<label for="email" class="error">必须是一个有效的邮箱地址</label>
					</li>
					<li>
						<label for="referrer">
						<span class="required">推荐人</span>
						</label>
						<input id="referrer" name="referrer" type="text">
					</li>
					<li>
						<label for="password">
						<span class="required">密码</span>
						</label>
						<input name="password" type="password" id="password">
					</li>
					<li>
						<label for="confirm_password">
						<span class="required">重新输入密码</span>
						</label>
						<input type="password" id="confirm_password" name="confirm_password" >
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