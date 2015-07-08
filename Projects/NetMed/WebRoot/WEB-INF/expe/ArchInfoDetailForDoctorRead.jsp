<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<jsp:include page="../include/core_head.jsp"></jsp:include>
<%
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
request.setAttribute("url", templateUrl);
	
	//电子档案唯一标识id
	String electronic_record=request.getParameter("electronic_record");
%>
<jsp:include page="../include/oldtopbar.jsp"></jsp:include>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../include/topbarhead.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${url}/css/style.css"/>
<script type="text/javascript" src="${url}/js/jquery.js"></script>

<title>个人健康档案</title>
<style type="text/css">
  .archInput{
   border-radius:6px;
   box-shadow:2px;
   border-color:#BFA789;
}
.archContent{
   border:2px solid #BFA789;
   border-radius:10px;
 
}
</style>
</head>
<script type="text/javascript">
$(function() {
	if('<%=electronic_record%>'!=""){
					getArchInfo('<%=electronic_record%>');
	}
	function getArchInfo(electronic_record) {
					$.ajax({
		            url : '<%=templateUrl%>/expe/ArchInfoForDoctorRead?electronic_record=<%=electronic_record%>',
		            type : 'POST',
		            contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				    dataType : 'json',
				    timeout : 20000,
				    cache : true,
					error : function(){
						alert("正在获取个人健康档案，请等待3秒后刷新");
						}, //错误执行方法  
					success : function(data) {
							$.each(data.ArchArray, function(index) {
								$("#name").val(data.ArchArray[index].name);
								$("#sex").val(data.ArchArray[index].sex);
								$("#idCardNumber").val(data.ArchArray[index].idCardNumber);
								$("#address").val(data.ArchArray[index].address);
								$("#occupation").val(data.ArchArray[index].occupation);
								$("#telephone").val(data.ArchArray[index].telephone);
								$("#mariStat").val(data.ArchArray[index].mariStat);
								$("#province").val(data.ArchArray[index].province);
								$("#city").val(data.ArchArray[index].city);
								$("#county").val(data.ArchArray[index].county);
								$("#age").val(data.ArchArray[index].age);
								$("#guomin").val(data.ArchArray[index].guomin);
								$("#fami_hist").val(data.ArchArray[index].fami_hist);
								$("#pers_hist").val(data.ArchArray[index].pers_hist);
								$("#licence ").val(data.ArchArray[index].licence );
								$("#meditype").val(data.ArchArray[index].meditype);
								});
						}//成功执行方法  
				});
	}
});
</script>

<body>

	<div style="margin-left:220px;margin-top:30px" >
		<div class="archContent" style="height:800px;padding-top:25px;margin-left:150px;width:690px">
			<div style="margin-left:50px">
				
				<label>姓名</label> <input type="text" class="archInput" style="width:85px" name="name" id="name" disabled="disabled"/>
				&nbsp; &nbsp; 
				
				<label>性别</label> 
				<select id="sex" style="width:50px" class="archInput" name="sex" disabled="disabled">
					<option  value="male" selected="selected">男</option>
					<option  value="female" >女</option>
				</select> &nbsp; &nbsp; 
				
				<label>年龄</label> <input type="text" class="archInput" style="width:50px" id="age" name="age" disabled="disabled"/> &nbsp; &nbsp;
				
				<label>医保类型</label>
				<select id="meditype" name="meditype" class="archInput" style="width:120px" disabled="disabled">
					<option  selected="selected" value="1">湖南省职工医保</option>
					<option  value="2">大学生医保</option>
					<option  value="3">城镇医疗保险</option>
					<option  value="4">农村医疗保险</option>
				</select> 
				<br /> <br /> 
				<label>证件类型</label> 
				<select id="licence" style="width:80px" name="licence" class="archInput" disabled="disabled">
					<option  selected="selected" value="idCardNumber1">身份证</option>
					<option  value="idCardNumber2">老年证</option>
					<option  value="idCardNumber3">残疾证</option>
				</select>
				&nbsp; &nbsp;
				<label>证件号码</label>  
				<input type="text" style="width:300px" id="idCardNumber" class="archInput" name="idCardNumber" disabled="disabled"/>
				<br /> <br /> 
				
				 <label>户籍</label> &nbsp; &nbsp;
                 <input type="text" class="archInput" style="width:75px" name="province" id="province" disabled="disabled"/> <label>省(市,自治区)</label> &nbsp;
                 <input type="text" class="archInput" style="width:75px" name="city" id="city" disabled="disabled"/> <label>市(自治州,旗)</label>&nbsp; 
                 <input type="text" class="archInput" style="width:75px" name="county" id="county" disabled="disabled"/> <label>县(区)</label> 
				
				 <br/> <br/>
				<label>住址</label> 
				<input type="text" class="archInput" style="width:507px" name="address" id="address" disabled="disabled"/> <br /> <br /> 
				
				<label>职业</label>
				<input type="text" class="archInput" style="width:120px" name="occupation" id="occupation" disabled="disabled"/> &nbsp; &nbsp; 
				
				<label>婚姻状况</label> <select class="archInput" style="width:70px" id="marriage" name="marriage" disabled="disabled">
					<option value="married">已婚</option>
					<option value="Nmarried" selected="selected">未婚</option>
				</select> &nbsp; &nbsp; 
				
				<label>电话号码</label> <input type="text" class="archInput"
					style="width:146px" name="telephone" id="telephone" disabled="disabled"/>
					
				<div style="margin-top:30px">
					<div>
						<img src="${url}/image/angle_blue.png" />&nbsp;&nbsp;&nbsp;&nbsp; 
						<label style="font-size:18px">药物/食物过敏史</label>
					</div>
					<textarea id="guomin" name="guomin" class="archInput"
						style="width:540px;height:100px;overflow-y:scroll;resize:none;margin-left:20px 0 0 0;border:solid 2px #BFA789" disabled="disabled"></textarea>
				</div>
				
				<div style="margin-top:30px">
					<div style="float:left">
						<img src="${url}/image/angle_blue.png" />&nbsp;&nbsp;&nbsp;&nbsp; <label
							style="font-size:18px">个人病史</label>
					</div>
					<div
						style="float:right;text-align:left;margin-right:200px;margin-top:10px">

					</div>
					<br />
					<br />
					<textarea id="pers_hist" name="pers_hist" class="archInput"
						style="width:540px;height:100px;overflow-y:scroll;resize:none;margin-left:20px 0 0 0;border:solid 2px #BFA789" disabled="disabled"></textarea>
				</div>
				<div style="margin-top:30px">
					<div style="float:left">
						<img src="${url}/image/angle_blue.png" />&nbsp;&nbsp;&nbsp;&nbsp; <label
							style="font-size:18px">家族病史</label>
					</div>
					<br />
					<br />
					<textarea id="fami_hist" name="fami_hist" class="archInput"
						style="width:540px;height:100px;overflow-y:scroll;resize:none;margin-left:20px 0 0 0;border:solid 2px #BFA789" disabled="disabled"></textarea>
				</div>
				<!--版权信息等-->
	<div id="footer" style="margin-top:100px;text-align:center">
		<jsp:include page="/WEB-INF/bottom/footer.jsp"></jsp:include>
	</div>
			</div>
		</div>
	</div>
	

</body>
</html>