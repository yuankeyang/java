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
<jsp:include page="../include/topbarhead.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="${url}/css/style.css"/>
<style type="text/css">
.consultInput{
   border-radius:10px;
   box-shadow:2px;
   border-color:#BFA789;
}
</style>
<title>查看我的离线咨询</title>
</head>
<script type="text/javascript">

window.onload = function() {
	$(document).ready(function(){
		if('<%=electronic_record%>'!=""){
			getElectronic_record('<%=electronic_record%>');
		}
	});
};
//获取电子病历表
function getElectronic_record(electronic_record){
	 $.ajax({
         url : '<%=templateUrl%>/user/ElectronicRecordActionForUserRead?electronic_record=<%=electronic_record%>',
         type : 'POST',
         contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		 dataType : 'json',
		 timeout : 3000,
		 cache : true,
			error : erryFunction, //错误执行方法  
			success : succFunction	//成功执行方法  
		});
		function erryFunction() {alert("获取电子病历出错，请重试!!");}
		function succFunction(data) {
			$("#username").html(data.userId);
			$("#consultName").html(data.consultName);
			$('#illn_desc').val(data.illn_desc);
			$('#fami_hist').val(data.fami_hist);
			$('#pers_hist').val(data.pers_hist);
			$('#medeical_zheng').text(data.medeical_zheng);
			$('#medeical_disease').text(data.medeical_disease);
			$('#medical_advice').val(data.medical_advice);
			if(parseInt(data.fileAccount)!=0){
				$("#fileList").html("附件：");
				$.each(data.file, function(index) {
					//alert(index);
					$("#fileList").append("<li><a target=\"_blank\" href='expe/FileDownloadAction?fileNumber="+index+"&fileName="+data.file[index].fileName+"&electronic_record="+'<%=electronic_record%>'+"'>"+data.file[index].fileName+"</a></li>");
				});
			}
	};
}
</script>

<body>

	<div style="margin-left:300px;margin-top:10px">
		<p
			style="background:url(${url}/image/suggestionbg.png) no-repeat;font-size:18px;font-weight:400;width:600px;margin-left:15px">
			<span>&nbsp;&nbsp;&nbsp;</span>&nbsp;&nbsp;&nbsp;&nbsp;专家：<label id="username"></label>
		</p>
         <div style="text-align:center"> 患者姓名：<label id="consultName"></label></div>
		<div style="margin-top:15px">
			<div style="margin-left:30px;">
				<img src="${url}/image/angle_blue.png" />&nbsp;&nbsp;&nbsp;&nbsp; <label
					style="font-size:18px">病情描述</label>
			</div>
			<textarea id="illn_desc" name="illn_desc" class="consultInput"
				style="width:720px;height:100px;overflow-y:scroll;resize:none;margin-left:30px;border:solid 2px #BFA789"
				disabled="disabled"></textarea>
		</div>

		<div style="margin-top:15px">
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

		<div style="margin-top:15px">
			<div style="margin-left:30px;float:left">
				<img src="${url}/image/angle_blue.png" />&nbsp;&nbsp;&nbsp;&nbsp; <label
					style="font-size:18px">家族病史</label>
			</div>
			<br /> <br />
			<div style="float:none">
				<textarea id="fami_hist" name="fami_hist"  class="consultInput"
					style="width:720px;height:100px;overflow-y:scroll;resize:none;margin-left:30px;border:solid 2px #BFA789"
					disabled="disabled"></textarea>
			</div>
<br/>
			<p
				style="background:url(${url}/image/suggestionbg.png) no-repeat;font-size:18px;font-weight:400;width:600px">&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;专家诊断：</p>
		</div>
			<div style="margin-left:30px;float:left">
			    <div style="margin-top:4px;">
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
			
			
			
			<div style="margin-top:180px">
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
	<div id="footer" style="margin-top:80px;text-align:center">
		<jsp:include page="/WEB-INF/bottom/footer.jsp"></jsp:include>
	</div>

</body>
</html>