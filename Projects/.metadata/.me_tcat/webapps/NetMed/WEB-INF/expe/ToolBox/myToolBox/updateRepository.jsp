<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.Date"%>
<%@ page language="java" import="java.sql.*"%>
<%
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	//文章的id
     String repoId=request.getParameter("repoId");   
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style>
.repositoryForm{
   border-radius:6px;
   box-shadow:2px;
   border-color:#BFA789;
}
 .saveButton{
  color:#fff;font-size:18pt;background:#C9B28B;width:80px;
  font-family:'宋体';
  border-radius:8px;
  }
</style>
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script>
$(document).ready(function(){
	$(document).ready(function(){
		if('<%=repoId%>'!=""){
			getRepository('<%=repoId%>');
		}
	});
});
//获取电子病历表
function getRepository(repoId){
	
	 $.ajax({
            url : '<%=templateUrl%>/expe/RepositoryForRead?repoId=<%=repoId%>',
            type : 'POST',
            contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		    dataType : 'json',
		    timeout : 8000,
		    cache : true,
			error : erryFunction, //错误执行方法  
			success : succFunction	//成功执行方法  
		});
		function erryFunction() {alert("获取知识库出错，请重试!!");}
		function succFunction(data) {
			//alert(data.content);
			$('#pres_name').val(data.presName);
			$('#illn_desc').val(data.illnDesc);
			$('#synd_name').val(data.syndrome);
			$('#chin_dise_name').val(data.chinDise);
			$('#west_dise_name').val(data.westDise);
			$('#pres_detail').val(data.presDetail);
			$('#medi_mate_name').val(data.mediMate);
			$('#west_medi_name').val(data.westMedi);
	};
}

//提交检查	
function check(){
	//alert($('#title').val());
	if($('#pres_name').val()==""){
		$("#pres_name").select();
		$("#pres_name").focus();
	}else if($('#illn_desc').val()==""){
		$("#illn_desc").select();
		$("#illn_desc").focus();
	}else if($('#pres_detail').val()==""){
		$("#pres_detail").select();
		$("#pres_detail").focus();
	}else{
		submit();
	}
	}
	function submit(){
	$.ajax({
        url : '<%=templateUrl%>/expe/UpdateRepository?repoId=<%=repoId%>',
		type : 'POST',
		data:"pres_name="+$('#pres_name').val()+"&synd_name="+$('#synd_name').val()+"&chin_dise_name="+$('#chin_dise_name').val()+"&medi_mate_name="+$('#medi_mate_name').val()+"&west_medi_name="+$('#west_medi_name').val()+"&illn_desc="+$('#illn_desc').val()+"&pres_detail="+$('#pres_detail').val()+"&west_dise_name="+$('#west_dise_name').val(),
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		dataType : 'text',
		timeout : 8000,
		cache : true,
		errot:erryFunction,
		success : succFunction
	//成功执行方法  
	});
	function erryFunction() {
		alert("请刷新页面!!");
	}
	function succFunction(data) {
		//修改成功
		alert("修改成功");
		window.location="myRepository";
	}
	}

</script>
</head>
<body>
	<div><img src="${url}/imgs/left.png"/>&nbsp;<span style="font-family:'仿宋';font-size:33px;color:#c9b28b">创建知识库</span>
		&nbsp;<img src="${url}/imgs/right.png"/></div>
		
		<div style="margin-left:80px;margin-top:30px">
			<span style="width:85px;display:inline-block;height:30px;font-family: SimSun;font-size: 18px;">方剂名称:</span>
			<input type="text" id="pres_name" name="pres_name" class="repositoryForm"
				style="height:25px;font-family: SimSun;font-size: 18px;" /> 
				&nbsp;&nbsp;&nbsp;
				
			<span style="width:82px;display:inline-block;height:30px;font-family: SimSun;font-size: 18px;">证候:</span>
			<input type="text" id="synd_name" name="synd_name" class="repositoryForm"
				style="height:25px;font-family: SimSun;font-size: 18px;" /> 
			<br />
			<br /> 
			
			<span style="width:85px;display:inline-block;height:30px;font-family: SimSun;font-size: 18px;">中医病名:</span>
			<input type="text" id="chin_dise_name" name="chin_dise_name" class="repositoryForm"
				style="height:25px;font-family: SimSun;font-size: 18px;" />
				&nbsp;&nbsp;&nbsp;
				 
			<span style="width:85px;display:inline-block;height:30px;font-family: SimSun;font-size: 18px;">西医病名:</span>
			<input type="text" id="west_dise_name" name="west_dise_name" class="repositoryForm"
				style="height:25px;font-family: SimSun;font-size: 18px;" /> 
			<br />
			<br /> 
			
		</div>

        <div style="margin-top: 20px;margin-left:80px">
			<label
				style="width:80%;height:30px;font-family: SimSun;font-size: 18px;">方剂组成:</label>
			<textarea id="medi_mate_name" name="medi_mate_name" class="repositoryForm" style="width:70%;height:80px;"></textarea>
		</div>

        <div style="margin-top: 20px;margin-left:80px">
			<span
				style="width:82px;display:inline-block;height:30px;font-family: SimSun;font-size: 18px;">西药:</span>
			<textarea id="west_medi_name" name="west_medi_name" class="repositoryForm" style="width:70%;height:80px;"></textarea>
		</div>
		
		<!-- 内容编辑框 -->
		<div style="margin-top: 20px;margin-left:80px">
			<label
				style="width:80%;height:30px;font-family: SimSun;font-size: 18px;">病情描述:</label>
			<textarea id="illn_desc" name="illn_desc" class="repositoryForm" style="width:70%;height:80px;"></textarea>
		</div>

		<div style="margin-top: 20px;margin-left:80px">
			<label
				style="width:80%;height:30px;font-family: SimSun;font-size: 18px;">其他内容:</label>
			<textarea id="pres_detail" name="pres_detail" class="repositoryForm" style="width:70%;height:80px;"></textarea>
		</div>
		<div id="mysubmit"
			style="margin-top:8px;width:800px;float:right;margin-right:100px;">
			<img src="${url}/image/largebutton_subsave.png" onclick="check();"
				style="float:right;">
		</div>

</body>

</html>
