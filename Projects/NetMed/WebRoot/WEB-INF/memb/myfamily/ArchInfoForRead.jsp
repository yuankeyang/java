<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<jsp:include page="../../include/core_head.jsp"></jsp:include>
<%
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
request.setAttribute("url", templateUrl);
	
	//电子档案唯一标识id
	String ArchInfo_Id=request.getParameter("ArchInfo_Id");   
%>
<jsp:include page="../../include/oldtopbar.jsp"></jsp:include>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="../../include/topbarhead.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${url}/css/style.css"/>
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script type="text/javascript" src="${url}/js/jquery.validate.js"></script>
<script type="text/javascript" src="${url}/js/register.js"></script>
<link href="${url}/css/bootstrap.min.css" rel="stylesheet">

<title>个人健康档案</title>

<style type="text/css">
body{background:url(../imgs/bg-01.jpg) repeat:repeat-x;}
.archInput{
   border-radius:6px;
   box-shadow:2px;
   border-color:#BFA789;
}
.archContent{
   border:2px solid #BFA789;
   border-radius:10px;
 
}
  .saveButton{
  color:#fff;font-size:18pt;font-weight:bold;background:#C9B28B;width:80px;
  border-radius:8px;
  }
  .cancelButton{
  color:#fff;font-size:18pt;font-weight:bold;background:#C9B28B;width:80px;
  border-radius:8px;
  }
</style>
</head>
<script type="text/javascript">
$(document).ready(function(){
			$(document).ready(function(){
				if('<%=ArchInfo_Id%>'!=""){
					getArchInfo('<%=ArchInfo_Id%>');
				}
			});
		});
		
		function getArchInfo(ArchInfo_Id){
			 $.ajax({
		            url : '<%=templateUrl%>/user/ArchInfoForRead?ArchInfo_Id=<%=ArchInfo_Id%>',
		            type : 'POST',
		            contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				    dataType : 'json',
				    timeout : 8000,
				    cache : true,
					error : erryFunction, //错误执行方法  
					success : succFunction	//成功执行方法  
				});
				function erryFunction() {alert("请刷新页面!!");}
				function succFunction(data) {
					//alert(data.content);
					$("#ArchInfo_Id").val(data.ArchInfo_Id);
					$("#name").val(data.name);
					$("#sex").val(data.sex);
					$("#idCardNumber").val(data.idCardNumber);
					$("#address").val(data.address);
					$("#occupation").val(data.occupation);
					$("#telephone").val(data.telephone);
					$("#mariStat").val(data.mariStat);
					$("#province").val(data.province);
					$("#city").val(data.city);
					$("#county").val(data.county);
					$("#age").val(data.age);
					$("#guomin").val(data.guomin);
					$("#fami_hist").val(data.fami_hist);
					$("#pers_hist").val(data.pers_hist);
					$("#licence ").val(data.licence );
					$("#meditype").val(data.meditype);
			};
		}
</script>

<body>

	<div style="margin-left:220px;margin-top:10px">
		<div  class="archContent" style="height:800px;margin-top:45px;margin-left:150px;width:690px">
			<div style="margin-left:50px;padding-top:10px">
				
				<label>[姓名]</label> <input type="text" style="width:80px;" name="name" id="name" class="archInput" disabled="disabled"/>
				&nbsp; &nbsp; 
				
				<label>[性别]</label> 
				<select id="sex" style="width:50px" name="sex" class="archInput" disabled="disabled">
					<option  value="male" selected="selected">男</option>
					<option  value="female" >女</option>
				</select> &nbsp; &nbsp; 
				
				<label>[年龄]</label> <input type="text" style="width:40px" id="age" name="age" class="archInput" disabled="disabled"/> &nbsp; &nbsp;
				
				<label>[医保类型]</label>
				<select id="meditype" name="meditype" style="width:105px" class="archInput" disabled="disabled">
					<option  selected="selected" value="1">职工医保</option>
					<option  value="2">大学生医保</option>
					<option  value="3">城镇医疗保险</option>
					<option  value="4">农村医疗保险</option>
				</select> 
				<br /> <br /> 
				
				<label>[证件类型]</label> 
				<select id="licence" style="width:83px" name="licence" class="archInput" disabled="disabled">
					<option  selected="selected" value="idCardNumber1">身份证</option>
					<option  value="idCardNumber2">老年证</option>
					<option  value="idCardNumber3">残疾证</option>
				</select>
				&nbsp; &nbsp;
				<label>[证件号码]</label>  
				<input type="text" style="width:300px" id="idCardNumber" name="idCardNumber" class="archInput" disabled="disabled"/>
				<br /> <br /> 
				
				 <label>[户籍]</label>
                 <input type="text" style="width:75px" name="province" id="province" class="archInput" disabled="disabled"/> <label>[省(市,自治区)]</label> &nbsp;
                 <input type="text" style="width:75px" name="city" id="city" class="archInput" disabled="disabled"/> <label>[市(自治州,旗)]</label>&nbsp; 
                 <input type="text" style="width:75px" name="county" id="county" class="archInput" disabled="disabled"/> <label>[县(区)]</label> 
				
				 <br/> <br/>
				<label>[住址]</label> 
				<input type="text" style="width:510px" name="address" id="address" class="archInput" disabled="disabled"/> <br /> <br /> 
				
				<label>[职业]</label>
				<input type="text" style="width:110px" name="occupation" id="occupation" class="archInput" disabled="disabled"/> &nbsp; &nbsp; 
				
				<label>[婚姻状况]</label> 
				<select style="width:70px" id="marriage" name="marriage" class="archInput" disabled="disabled">
					<option value="married">已婚</option>
					<option value="Nmarried" selected="selected">未婚</option>
				</select> &nbsp; &nbsp; 
				
				<label>[电话号码]</label> <input type="text"
					style="width:130px" name="telephone" id="telephone" class="archInput" disabled="disabled"/>
					
				<div style="margin-top:30px">
						<label style="font-size:18px">[药物/食物过敏史]</label>&nbsp;300字以内
					<textarea id="guomin" name="guomin" class="archInput"
						style="width:555px;height:100px;overflow-y:scroll;resize:none;margin-left:20px 0 0 0;border:solid 2px #BFA789" disabled="disabled"></textarea>
				</div>
				
				<div style="margin-top:30px">
						<label style="font-size:18px">[个人病史]</label>&nbsp;500字以内
				
					<br />
					<textarea id="pers_hist" name="pers_hist" class="archInput"
						style="width:555px;height:100px;overflow-y:scroll;resize:none;margin-left:20px 0 0 0;border:solid 2px #BFA789" disabled="disabled"></textarea>
				</div>
				
				<div style="margin-top:30px">
					<label style="font-size:18px">[家族病史]</label>&nbsp;500字以内
					
					<br />
					<textarea id="fami_hist" name="fami_hist" class="archInput"
						style="width:555px;height:100px;overflow-y:scroll;resize:none;margin-left:20px 0 0 0;border:solid 2px #BFA789" disabled="disabled"></textarea>
				</div>
				<!--版权信息等-->
	<div id="footer" style="margin-top:140px;text-align:center">
		<jsp:include page="/WEB-INF/bottom/footer.jsp"></jsp:include>
	</div>
			</div>
		</div>
	</div>
	

</body>
</html>