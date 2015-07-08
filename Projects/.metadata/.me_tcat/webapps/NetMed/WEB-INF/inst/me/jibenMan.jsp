<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
    $(".usercenter_nav .item ul .on").parent().show().prev("div").addClass("on");
    </script>
<iframe width="0" height="0" name="report_image_iframe" id="report_image_iframe" style="display:none;"></iframe>
<div class="user_center_bigtitle"><span>基本信息修改</span></div>
                <div class="mg_info">
                    <fieldset>
				<ul>
                	<li>
						<label for="inst_name">
							<span class="required"><font size=2>机构名称：</font></span>
						</label>
						<input id="inst_name" name="inst_name" type="text">
						<label for="inst_name" class="error"><font size=1>（请输入机构名称的全称）</font></label>
					</li>
					<br/>
					<li>
						<label for="inst_clas">
							<span class="required"><font size=2>机构类别：</font></span>
						</label>
						<input id="inst_clas" name="inst_clas" type="text">
						<label for="inst_clas" class="error"><font size=1>（类别指药企、药房、保健机构、餐饮机构等）</font></label>
					</li>
					<br/>
					<li>
						<label for="busi_scop">
							<span class="required"><font size=2>经营范围：</font></span>
						</label>
						<textarea name="busi_scop" clos="30" rows="3" warp="virtual"></textarea>
						<label for="busi_scop" class="error"><font size=1>（请用20以内字加以描述）</font></label>
					</li>
					<br/>
					<li>
						<label for="lega_repr_name">
							<span class="required"><font size=2>法定代表人姓名：</font></span>
						</label>
						<input id="lega_repr_name" name="lega_repr_name" type="text">
						<label for="lega_repr_name" class="error"><font size=1>（请输入真实姓名）</font></label>
					</li>
					<br/>
					<li>
						<label for="lega_repr_id">
							<span class="required"><font size=2>法定代表人身份证号：</font></span>
						</label>
						<input id="lega_repr_id" name="lega_repr_id" type="text">
					</li>
					<br/>
					<li>
						<label for="inst_prov">
							<span class="required"><font size=2>所在省：</font></span>
						</label>
						<input id="inst_prov" name="inst_prov" type="text">
						<label for="inst_prov" class="error"><font size=1>（为方便顾客查找，请认真填写）</font></label>
					</li>
					<br/>
					<li>
						<label for="inst_city">
							<span class="required"><font size=2>所在市：</font></span>
						</label>
						<input id="inst_city" name="inst_city" type="text">
						<label for="inst_city" class="error"><font size=1>（为方便顾客查找，请认真填写）</font></label>
					</li>
					<br/>
					<li>
						<label for="inst_coun">
							<span class="required"><font size=2>所在县（区）：</font></span>
						</label>
						<input id="inst_coun" name="inst_coun" type="text">
						<label for="inst_coun" class="error"><font size=1>（为方便顾客查找，请认真填写）</font></label>
					</li>
					<br/>
					<li>
						<label for="inst_over">
							<span class="required"><font size=2>机构概况：</font></span>
						</label>
						<textarea name="inst_over" clos="100" rows="5" warp="virtual" style="overflow:auto"></textarea>
						<label for="inst_over" class="error"><font size=1>（请输入100以内的汉字进行简要描述）</font></label>
					</li>
					<br/>
					<li>
						<label for="phone">
						<span class="required"><font size=2>固定电话：</font></span>
						</label>
						<input id="phone" name="phone" type="text">
						<label for="phone" class="error"><font size=1>（为能及时联系到您，请输入您的电话号码）</font></label>
					</li>
					<br/>
					<li>
						<label for="telephone">
						<span class="required"><font size=2>移动电话：</font></span>
						</label>
						<input id="telephone" name="telephone" type="text">
						<label for="telephone" class="error"><font size=1>（为能及时联系到您，请输入您的电话号码）</font></label>
					</li>
					<br/>
					<li>
						<label for="email">
							<span class="required"><font size=2>认证邮箱：</font></span>
						</label>
						<input id="email" name="email" type="text">
						<label for="email" class="error"><font size=1>（必须是一个有效的邮箱地址）</font></label>
					</li>
					<br/>
					<li>
						<label for="password">
							<span class="required"><font size=2>原密码：</font></span>
						</label>
						<input name="password" type="password" id="password">
					</li>
					<br/>
                    <li>
						<label for="confirm_password">
							<span class="required"><font size=2>输入新的密码：</font></span>
						</label>
						<input type="password" id="confirm_password" name="confirm_password">
					</li>
				</ul>
			</fieldset>
			<fieldset class="submit">
				<input type="submit" class="submit" value="提交">
			</fieldset>
			<div class="clear"></div>
                </div>
            
</body>
</html>