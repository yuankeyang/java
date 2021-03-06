<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../../include/core_head.jsp"></jsp:include>
<%
    

	String memb_id = (String) session.getAttribute("username");
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	
	if (memb_id == null) {
		response.sendRedirect(templateUrl);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<link rel="stylesheet" type="text/css" href="${url}/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<title>新建个人健康档案</title>
<style type="text/css">
.archInput{
   border-radius:6px;
   box-shadow:2px;
   border-color:#BFA789;
}
.archContent{
   border:1px solid #BFA789;
   border-radius:10px;
 
}
  .saveButton{
  color:#fff;font-size:18pt;font-weight:bold;background:#C9B28B;width:80px;
  border-radius:8px;border:none;
  }
  .cancelButton{
  color:#fff;font-size:18pt;font-weight:bold;background:#C9B28B;width:80px;
  border-radius:8px;border:none;
  }
</style>
</head>

<script type="text/javascript">
function check(){
	if($('#name').val()==""){     //姓名非空
		$("#name").select();
		$("#name").focus();
	}else if($('#age').val()==""){    //年龄非空
		$("#age").select();
		$("#age").focus();
	}else if($('#idCardNumber').val()==""){       //证件号非空
		$("#idCardNumber").select();
		$("#idCardNumber").focus();
	}else{
		$("#membArchInfo").submit();
	}
}

function myreset(){
	
	$("#membArchInfo")[0].reset();
}

</script>

<body>
<div><img src="${url}/imgs/left.png"/>&nbsp;&nbsp;<span style="font-family:'FangSong';font-size:30pt;color:#c9b28b;">电子健康档案
</span>&nbsp;&nbsp;<img src="${url}/imgs/right.png"/></div>
    <span style="font-color:#FF0000;font-family:'宋体';font-size:24pt;bold;margin-left:250px">[请完善电子健康档案]</span>
    
    <form action="NewMembArchInfoAction" id="membArchInfo" method="post">
	
	<div class="archContent" style="margin-top:30px;width:700px;margin-left:30px">
		<div style="padding-top:5px;margin-left:30px">
			<div style="margin-left:50px">
				
				<label>[姓名]</label> <input type="text" style="width:80px;" name="name" id="name" class="archInput"/>
				&nbsp; &nbsp; 
				
				<label>[性别]</label> 
				<select id="sex" style="width:50px" name="sex" class="archInput">
					<option  value="male" selected="selected">男</option>
					<option  value="female" >女</option>
				</select> &nbsp; &nbsp; 
				
				<label>[年龄]</label> <input type="text" style="width:40px" id="age" name="age" class="archInput"/> &nbsp; &nbsp;
				
				<label>[医保类型]</label>
				<select id="meditype" name="meditype" style="width:105px" class="archInput">
					<option  selected="selected" value="1">职工医保</option>
					<option  value="2">大学生医保</option>
					<option  value="3">城镇医疗保险</option>
					<option  value="4">农村医疗保险</option>
				</select> 
				<br /> <br /> 
				
				<label>[证件类型]</label> 
				<select id="licence" style="width:83px" name="licence" class="archInput">
					<option  selected="selected" value="idCardNumber1">身份证</option>
					<option  value="idCardNumber2">老年证</option>
					<option  value="idCardNumber3">残疾证</option>
				</select>
				&nbsp; &nbsp;
				<label>[证件号码]</label>  
				<input type="text" style="width:300px" id="idCardNumber" name="idCardNumber" class="archInput"/>
				<br /> <br /> 
				
				 <label>[户籍]</label>
                 <input type="text" style="width:75px" name="province" id="province" class="archInput"/> <label>[省(市,自治区)]</label> &nbsp;
                 <input type="text" style="width:75px" name="city" id="city" class="archInput"/> <label>[市(自治州,旗)]</label>&nbsp; 
                 <input type="text" style="width:75px" name="county" id="county" class="archInput"/> <label>[县(区)]</label> 
				
				 <br/> <br/>
				<label>[住址]</label> 
				<input type="text" style="width:510px" name="address" id="address" class="archInput"/> <br /> <br /> 
				
				<label>[职业]</label>
				<input type="text" style="width:110px" name="occupation" id="occupation" class="archInput"/> &nbsp; &nbsp; 
				
				<label>[婚姻状况]</label> 
				<select style="width:70px" id="marriage" name="marriage" class="archInput">
					<option value="married">已婚</option>
					<option value="Nmarried" selected="selected">未婚</option>
				</select> &nbsp; &nbsp; 
				
				<label>[电话号码]</label> <input type="text"
					style="width:130px" name="telephone" id="telephone" class="archInput"/>
					
				<div style="margin-top:30px">
						<label style="font-size:18px">[药物/食物过敏史]</label>&nbsp;300字以内
					<textarea id="guomin" name="guomin" class="archInput"
						style="width:555px;height:100px;overflow-y:scroll;resize:none;margin-left:20px 0 0 0;border:solid 2px #BFA789"></textarea>
				</div>
				
				<div style="margin-top:30px">
						<label style="font-size:18px">[个人病史]</label>&nbsp;500字以内
				
					<br />
					<textarea id="pers_hist" name="pers_hist" class="archInput"
						style="width:555px;height:100px;overflow-y:scroll;resize:none;margin-left:20px 0 0 0;border:solid 2px #BFA789"></textarea>
				</div>
				
				<div style="margin-top:30px">
					<label style="font-size:18px">[家族病史]</label>&nbsp;500字以内
					
					<br />
					<textarea id="fami_hist" name="fami_hist" class="archInput"
						style="width:555px;height:100px;overflow-y:scroll;resize:none;margin-left:20px 0 0 0;border:solid 2px #BFA789"></textarea>
				</div>
				
				<div style="margin-left:180px;margin-top:15px">
				    <%--<button class="saveButton" onclick="check();">保存</button>--%>&nbsp;&nbsp;
				    <%--<button class="cancelButton" onclick="myreset();">取消</button>--%>
					<img src="${url}/image/buttonnormal_save.png" onclick="check();"/> &nbsp;&nbsp;
					<img src="${url}/image/buttonnormal_quite.png" onclick="myreset();" />
				</div>
			
			</div>
		</div>
		
	</div>

  </form> 

</body>
</html>
