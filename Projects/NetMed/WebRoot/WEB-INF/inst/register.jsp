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
		<h1>服务机构注册</h1>
	</div>
	<div id="content">
		<p id="status"></p>
		<s:form action="inst-regi-chec" method="get" id="inst-reg">
			<fieldset>
				<legend>机构信息</legend>
				<ul>
					<li>
						<label for="inst_id">
							<span class="required">机构id</span>
						</label>
						<input id="inst_id" name="inst_id" type="text">
						<label for="inst_id" class="error">请输入9位数的组织机构代码</label>
					</li>
                	<li>
						<label for="inst_name">
							<span class="required">机构名称</span>
						</label>
						<input id="inst_name" name="inst_name" type="text">
						<label for="inst_name" class="error">请输入机构名称的全称</label>
					</li>
					<li>
						<label for="inst_clas">
							<span class="required">机构类别</span>
						</label>
						<input id="inst_clas" name="inst_clas" type="text">
						<label for="inst_clas" class="error">类别指药企、药房、保健机构、餐饮机构等</label>
					</li>
					<li>
						<label for="busi_scop">
							<span class="required">经营范围</span>
						</label>
						<textarea id="busi_scop" name="busi_scop" clos="30" rows="3" warp="virtual"></textarea>
						<label for="busi_scop" class="error">请用20以内字加以描述</label>
					</li>
					<li>
						<label for="lega_repr_name">
							<span class="required">法定代表人姓名</span>
						</label>
						<input id="lega_repr_name" name="lega_repr_name" type="text">
						<label for="lega_repr_name" class="error">请输入真实姓名</label>
					</li>
					<li>
						<label for="lega_repr_id">
							<span class="required">法定代表人身份证号</span>
						</label>
						<input id="lega_repr_id" name="lega_repr_id" type="text">
					</li>
					<li>
						<label for="busi_lice">
						<span class="required">营业执照扫描件</span>
						</label>
						 <input id="busi_lice" type="file" name="uploadFile" />
					</li>
					<li>
						<label for="orga_code">
						<span class="required">组织机构代码证扫描件</span>
						</label>
						 <input id="orga_code" type="file" name="uploadFile" />
					</li>
					<li>
						<label for="inst_prov">
							<span class="required">所在省</span>
						</label>
						<input id="inst_prov" name="inst_prov" type="text">
						<label for="inst_prov" class="error">为方便顾客查找，请认真填写</label>
					</li>
					<li>
						<label for="inst_city">
							<span class="required">所在市</span>
						</label>
						<input id="inst_city" name="inst_city" type="text">
						<label for="inst_city" class="error">为方便顾客查找，请认真填写</label>
					</li>
					<li>
						<label for="inst_coun">
							<span class="required">所在县（区）</span>
						</label>
						<input id="inst_coun" name="inst_coun" type="text">
						<label for="inst_coun" class="error">为方便顾客查找，请认真填写</label>
					</li>
					<li>
						<label for="inst_over">
							<span class="required">机构概况</span>
						</label>
						<textarea name="inst_over" clos="100" rows="5" warp="virtual" style="overflow:auto"></textarea>
						<label for="inst_over" class="error">请输入100以内的汉字进行简要描述</label>
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
						<label for="password">
							<span class="required">密码</span>
						</label>
						<input name="password" type="password" id="password">
					</li>
                    <li>
						<label for="confirm_password">
							<span class="required">重新输入密码</span>
						</label>
						<input type="password" id="confirm_password" name="confirm_password">
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