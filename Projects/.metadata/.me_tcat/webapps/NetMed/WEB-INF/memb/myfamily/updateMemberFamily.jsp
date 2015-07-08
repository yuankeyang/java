<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String templateUrl = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath();
request.setAttribute("url", templateUrl);
String MembFamily_Id = request.getParameter("MembFamily_Id");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${url}/css0623/style.css" />
<script type="text/javascript" src="${url}/js/jquery.js"></script>

<script>
    function getMembFamilyById(){
    	$.ajax({
	        url : '<%=templateUrl%>/user/MembFamilyForReadAction?MembFamily_Id=<%=MembFamily_Id%>',
			type : 'POST',
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			dataType : 'json',
			timeout : 18000,
			cache : true,
			error : erryFunction, //错误执行方法  
			success : succFunction
		//成功执行方法  
		});
		function erryFunction(data) {
			//alert("等待3秒后请刷新页面");
		}
		function succFunction(data) {
			$("#FamilyName").val(data.FamilyName);
			$("input:radio[name='sex']").eq(parseInt(data.sex)).attr("checked",true);
			$("#age").val(data.age);
			$("#relation").val(data.relation);
			$("#mobile").val(data.mobile);
			$("#telephone").val(data.telephone);
			$("#address").val(data.address);
		}
	}
	window.onload = function() {
		getMembFamilyById();
	};
</script>
</head>
<style>

</style>
<body>
<div id="page">
	
<form id="newFamilyMember" name="newFamilyMember"  method="post" action="UpdateMemberFamily">
	<div><img src="${url}/imgs/left.png"/>&nbsp;<span style="font-family:'仿宋';font-size:33px;color:#c9b28b">修改家属信息</span>
		&nbsp;<img src="${url}/imgs/right.png"/></div>
	<br/>
	<table class="wwFormTable" style="font-family: '宋体';font-size: 18px;">
			<fieldset>
				<ul>
                	<li>
						<label for="FamilyName">
							<span class="required" style="font-family: '宋体';font-size: 18px;width:120px;display:inline-block;"><b>[患者姓名]</b></span>
						</label>
						<input id="FamilyName" name="FamilyName" type="text">
						<label for="FamilyName" class="error">患者姓名不可为空</label>
					</li>
					<br/>
					<li>
						<label for="sex">
							<span class="required" style="font-family: '宋体';font-size: 18px;width:120px;display:inline-block;"><b>[性别]</b></span>
						</label>
						<input name="sex" type="radio" value="male" checked="checked" >男&nbsp;&nbsp;
						<input name="sex" type="radio" value="female" >女
					</li>
					<br/>
					<li>
						<label for="age">
							<span class="required" style="font-family: '宋体';font-size: 18px;width:120px;display:inline-block;"><b>[年龄]</b></span>
						</label>
						<input id="age" name="age"  type="text">
						<label for="age" class="error">请填写正确的年龄</label>
					</li>
					<br/>
					<li>
						<label for="relation">
							<span class="relation" style="font-family: '宋体';font-size: 18px;width:120px;display:inline-block;"><b>[与患者关系]</b></span>
						</label>
						<select id="relation" name="relation">
							<option value="本人" selected="selected">本人</option>
							<option value="家庭成员">家庭成员</option>
							<option value="亲戚">亲戚</option>
							<option value="朋友">朋友</option>
							<option value="其他">其他</option>
					</select>
					</li>
					<br/>
					<li>
						<label for="mobile">
							<span class="mobile" style="font-family: '宋体';font-size: 18px;width:120px;display:inline-block;"><b>[手机号]</b></span>
						</label>
						<input id="mobile" name="mobile"  type="text">
						<label for="mobile" class="error">请填写正确的手机号</label>
					</li>
					<br/>
					<li>
						<label for="telephone">
							<span class="telephone" style="font-family: '宋体';font-size: 18px;width:120px;display:inline-block;"><b>[固定电话]</b></span>
						</label>
						<input id="telephone" name="telephone"  type="text">
						<label for="telephone" class="error">请填写正确的固定电话</label>
					</li>
					<br/>
					<li>
						<label for="address">
							<span class="address" style="font-family: '宋体';font-size: 18px;width:120px;display:inline-block;"><b>[家庭地址]</b></span>
						</label>
						<input id="address" name="address"  type="text">
						<label for="address" class="error">家庭地址不可为空</label>
					</li>
				</ul>
			</fieldset>
			<fieldset class="submit">
			<input type="hidden" name="MembFamily_Id" value="<%=MembFamily_Id%>" >
				<input type="submit" class="submit" value="确认" style="margin-left:500px"/>
			</fieldset>
		</table>
</form>
</div>
</body>
</html>