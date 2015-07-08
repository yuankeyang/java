<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<jsp:include page="../include/core_head.jsp"></jsp:include>
<%
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
request.setAttribute("url", templateUrl);
	//String expe_id=request.getParameter("doctorName");   //获取的不是专家ID；
	//String expe_id = new String(request.getParameter("doctorName").getBytes("iso8859-1"), "utf-8");
	
	//电子病历，唯一标识
	String electronic_record=request.getParameter("electronic_record");   
	// out.println(expe_id);
%>
<jsp:include page="../include/oldtopbar.jsp"></jsp:include>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${url}/css/article.css" />
<link rel="stylesheet" type="text/css" href="${url}/css/style.css"/>

<jsp:include page="../include/topbarhead.jsp"></jsp:include>
<title>专家查看离线咨询</title>

<style type="text/css">
.consultInput{
   border-radius:10px;
   box-shadow:2px;
   border-color:#BFA789;
}
</style>

</head>
<script type="text/javascript">

$(function() {
	if('<%=electronic_record%>'!=""){
					getGeRenInfo('<%=electronic_record%>');
	}
	function getGeRenInfo(electronic_record) {
					$.ajax({
		            url : '<%=templateUrl%>/expe/PatientInfoAction?electronic_record=<%=electronic_record%>',
		            type : 'POST',
		            contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				    dataType : 'json',
				    timeout : 20000,
				    cache : true,
					error : function(){
						//alert("请刷新页面!!");
						}, //错误执行方法  
					success : function(data) {
							$.each(data.ArchArray, function(index) {
								//alert(data.content);
								$("#name").val(data.ArchArray[index].name);
								$("#sex").val(data.ArchArray[index].sex);
								$("#age").val(data.ArchArray[index].age);
								});
						}//成功执行方法  
				});
	}
});



window.onload = function() {
		if('<%=electronic_record%>'!=""){
			getElectronic_record('<%=electronic_record%>');
		}
	};
//获取电子病历表
function getElectronic_record(electronic_record){
	 $.ajax({
         url : '<%=templateUrl%>/expe/ElectronicRecordActionForRead?electronic_record=<%=electronic_record%>',
         type : 'POST',
         contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		 dataType : 'json',
		 timeout : 15000,
		 cache : true,
			error : erryFunction, //错误执行方法  
			success : succFunction	//成功执行方法  
		});
		function erryFunction() {
			//alert("获取电子病历出错，请重试!!");
			}
		function succFunction(data) {
			$("#username").html(data.userId);
			$('#illn_desc').val(data.illn_desc);
			$('#fami_hist').val(data.fami_hist);
			$('#pers_hist').val(data.pers_hist);
			
			$('#medeical_zheng').text(data.medeical_zheng);
			$('#medeical_disease').text(data.medeical_disease);
			//$('#medical_result').val(data.medical_result);
			$('#medical_advice').val(data.medical_advice);
			
			if(parseInt(data.fileAccount)!=0){
				$("#fileList").html("附件：");
				$.each(data.file, function(index) {
					$("#fileList").append("<li><a target=\"_blank\" href='expe/FileDownloadAction?fileNumber="+index+"&fileName="+data.file[index].fileName+"&electronic_record="+'<%=electronic_record%>'+"'>"+data.file[index].fileName+"</a></li>");
				});
			};
	};
};
</script>

<body>

	<div style="margin-left:300px;margin-top:10px">
		<p
			style="background:url(${url}/image/suggestionbg.png) no-repeat;font-size:18px;font-weight:400;width:600px">
			&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;患者信息：<label id="username"></label>
		</p>
		
		<p>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;姓名：<input type="text" style="width:45px;border:0;font-weight:bold" name="name" id="name"/>
		&nbsp; &nbsp;&nbsp;性别：<input type="text" style="width:35px;border:0;font-weight:bold" name="sex" id="sex"/>
		&nbsp; &nbsp;&nbsp;年龄：<input type="text" style="width:45px;border:0;font-weight:bold" name="age" id="age"/></p>

		<div style="margin-top:30px">
			<div style="margin-left:30px;">
				<img src="${url}/image/angle_blue.png" />&nbsp;&nbsp;&nbsp;&nbsp; <label
					style="font-size:18px">病情描述</label>
			</div>
			<textarea id="illn_desc" name="illn_desc" class="consultInput"
				style="width:720px;height:100px;overflow-y:scroll;resize:none;margin-left:30px;border:solid 2px #BFA789"
				disabled="disabled"></textarea>
		</div>

		<div>
			<div style="margin-left:30px;float:left">
				<img src="${url}/image/angle_blue.png" />&nbsp;&nbsp;&nbsp;&nbsp; <label
					style="font-size:18px">个人病史</label>
			</div>
			<br />
			<div style="float:none;margin-top:20px">
				<textarea id="pers_hist" name="pers_hist" class="consultInput"
					style="width:720px;height:100px;overflow-y:scroll;resize:none;margin-left:30px;border:solid 2px #BFA789"
					disabled="disabled"></textarea>
			</div>

		</div>

		<div style="margin-top:30px">
			<div style="margin-left:30px;float:left">
				<img src="${url}/image/angle_blue.png" />&nbsp;&nbsp;&nbsp;&nbsp; <label
					style="font-size:18px">家族病史</label>
			</div>
			<br /> <br />
			<div style="float:none">
				<textarea id="fami_hist" name="fami_hist" class="consultInput"
					style="width:720px;height:100px;overflow-y:scroll;resize:none;margin-left:30px;border:solid 2px #BFA789"
					disabled="disabled"></textarea>
			</div>
<br/>
			<p
				style="background:url(${url}/image/suggestionbg.png) no-repeat;font-size:18px;font-weight:400;width:600px">&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;专家诊断：</p>
		</div>
		
		
			<div style="margin-left:30px;float:left">
			
			<div style="margin-top:10px;">
					<img src="${url}/image/angle_blue.png" />&nbsp;&nbsp;&nbsp;&nbsp; <label
						style="font-size:18px">辨病结果</label>
			</div>
				<label  id="medeical_disease" style="margin-top:14px;margin-left:200px;font-size:16px;" ></label>
			
			<div style="margin-top:15px;">
					<img src="${url}/image/angle_blue.png" />&nbsp;&nbsp;&nbsp;&nbsp; <label
						style="font-size:18px">辩证结果</label>
			</div>
				<label  id="medeical_zheng" style="margin-top:14px;margin-left:200px;font-size:16px;" ></label>
			
			</div>
			
			
			
			<div style="margin-top:200px">
				<div style="margin-left:30px;float:left">
					<img src="${url}/image/angle_blue.png" />&nbsp;&nbsp;&nbsp;&nbsp; <label
						style="font-size:18px">专家建议</label>
				</div>
				<br /> <br />
				<div style="float:none">
					<textarea id="medical_advice" name="medical_advice" class="consultInput"
						style="width:720px;height:100px;overflow-y:scroll;resize:none;margin-left:30px;border:solid 2px #BFA789" disabled="disabled"></textarea>
				</div>
			</div>
			  <ul id="fileList" style="list-style:none;"></ul>

	</div>
	<!--版权信息等-->
	<jsp:include page="/WEB-INF/bottom/footer.jsp"></jsp:include>

</body>
</html>