<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" import="javax.servlet.http.HttpSession"%>
<jsp:include page="../include/core_head.jsp"></jsp:include>
<%
	String memb_id = (String) session.getAttribute("username");
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();

	if (memb_id == null) {
		response.sendRedirect(templateUrl);
	}
	String expe_id = (String)session.getAttribute("expe_id");
	String expe_name=(String)session.getAttribute("expe_name");
	if(expe_id==null||expe_name==null){
		 expe_id = (String)request.getParameter("expe_id");
		 expe_name=new String(request.getParameter("expe_name").getBytes("iso8859-1"),"utf-8");
		 
	}
	
%>
<jsp:include page="../include/oldtopbar.jsp"></jsp:include>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../include/topbarhead.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="${url}/css/style.css" />
<link rel="stylesheet" type="text/css" href="${url}/css/article.css" />
<style type="text/css">
.consultInput{
   border-radius:10px;
   box-shadow:2px;
   border-color:#BFA789;
}
</style>

<title>离线咨询</title>

<script type="text/javascript">
function check() {
		if ($('#illn_desc').val() == "") {
			$("#illn_desc").select();
			$("#illn_desc").focus();
		} else if ($('#fami_hist').val() == "") {
			$("#fami_hist").select();
			$("#fami_hist").focus();
		}else if ($('#PeopleName').val() == "") {
			$("#PeopleName").select();
			$("#PeopleName").focus();
		} else if ($('#pers_hist').val() == "") {
			$("#pers_hist").select();
			$("#pers_hist").focus();
		} else {
			$("#offlineConsult").submit();
		}
	}
	
	

$(function() {
	getPeopleName('<%=memb_id%>');
	
	
function getPeopleName(memb_id){
	$.ajax({
        url : "<%=templateUrl%>/user/PeopleNameAction?memb_id=<%=memb_id%>",
		type : 'POST',
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		dataType : 'json',
		timeout : 18000,
		cache : true,
		error : erryFunction, //错误执行方法  
		success : succFunction
		});
	
		function erryFunction() {
			alert("获取会员及家属姓名出错，请重试!!");
		}
		function succFunction(data) {
			//alert("ssssss");
			//alert(data.PeopleNameArray[0].value);
			$("#relationship").find("option").remove();
			$.each(data.PeopleNameArray, function(index) {
				$("#relationship").append(
						"<option value="+data.PeopleNameArray[index].name+">"
								+ data.PeopleNameArray[index].name
								+ "</option>");
			});
			var consultName = $("#relationship").val(); 
			getHistory(memb_id,consultName);
		}
		
	}

$(document).ready(function(){
  $("#relationship").change(function () {
       var consultName=$('#relationship').val(); 
  	   getHistory(memb_id,consultName);
});
});

function getHistory(memb_id,consultName){
	//alert(memb_id);
	//alert(consultName);
	
	$.ajax({
        url : '<%=templateUrl%>/user/HistoryAction?memb_id=<%=memb_id%>'+'&consultName='+consultName,
					type : 'POST',
					contentType : "application/x-www-form-urlencoded; charset=utf-8",
					dataType : 'json',
					timeout : 18000,
					cache : true,
					error : erryFunction, //错误执行方法  
					success : succFunction
				//成功执行方法  
				});
		function erryFunction() {
			alert("获取会员及家属姓名出错，请重试!!");
		}
		function succFunction(data) {
			$("#pers_hist").text(data.personHistory);
			$("#fami_hist").text(data.familyHistory);
		}
	}
	
});

</script>
</head>
<body>
	<div style="margin-left:300px;margin-top:10px">
		<p
			style="background:url(${url}/image/suggestionbg.png) no-repeat;font-size:18px;font-weight:400;width:600px">&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;专家信息：</p>
		<div class="docIn"
			style="border:2px solid #BFA789;border-radius:10px;width:730px;height:170px;margin-left:20px">
			<img id="expertPhoto" src="${url}/image/offlineDoctor.png" style="border:2px solid #BFA789;border-radius:8px" />
			<div style="float:left">
				<ul>
					<li id="name"><%=expe_id%></li>
				</ul>
			</div>
		</div>
		<br />
		<form action="user/OfflineConsultAction" method="post"
			enctype="multipart/form-data" id="offlineConsult">
			<div style="margin-left:25px">
				请选择具体咨询人：
				<select id="relationship" style="width:100px" name="relationship"></select>
			</div>
			<br/>
			<p
				style="background:url(${url}/image/suggestionbg.png) no-repeat;font-size:18px;font-weight:400;width:600px">&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;我的信息：</p>

			<input type="hidden" name="memb_id" id="memb_id" value="<%=memb_id%>">
			<input type="hidden" name="expe_id" id="expe_id" value="<%=expe_id%>">
			
			<div style="margin-top:30px">
				<div style="margin-left:30px;">
					<img src="${url}/image/angle_blue.png" />&nbsp;&nbsp;&nbsp;&nbsp;
					<label style="font-size:18px">病情描述</label>
				</div>
				<textarea id="illn_desc" name="illn_desc" placeholder="请描述下你的病情" class="consultInput"
					style="width:720px;height:100px;overflow-y:scroll;resize:none;margin-left:30px;border:solid 2px #BFA789"></textarea>
			</div>
			<div style="margin-top:15px;">
				<div style="margin-left:30px;float:left">
					<img src="${url}/image/angle_blue.png" />&nbsp;&nbsp;&nbsp;&nbsp;
					<label style="font-size:18px">个人病史</label>
				</div>
				<br />
				<div style="float:none;margin-top:20px">
					<textarea id="pers_hist" name="pers_hist" class="consultInput"
						style="width:720px;height:100px;overflow-y:scroll;resize:none;margin-left:30px;border:solid 2px #BFA789"></textarea>
				</div>
			</div>
			<div style="margin-top:15px">
				<div style="margin-left:30px;float:left">
					<img src="${url}/image/angle_blue.png" />&nbsp;&nbsp;&nbsp;&nbsp;
					<label style="font-size:18px">家族病史</label>
				</div>
				<br /> <br />
				<div style="float:none">
					<textarea id="fami_hist" name="fami_hist" class="consultInput"
						style="width:720px;height:100px;overflow-y:scroll;resize:none;margin-left:30px;border:solid 2px #BFA789"></textarea>
				</div>
			</div>
			
			
			<div style="margin-top:30px;height:150px;width:800px;">
				<div style="float:left;width:820px;height:100px;margin-left:30px">
					<table style="border:solid 1px #BFA789;" rules=rows>
						<tr>
							<td style="width:200px"><h3>上传附件</h3>
							</td>
							<td style="width:200px"></td>
						</tr>
						<tr>
							<td><span id="fileName">病历资料</span></td>
							<td style="width:510px"><input type="file" id="attachment"
								name="attachment">
							</td>
						</tr>
						<tr>
							<td>体检资料</td>
							<td><input type="file" id="attachment" name="attachment">
							</td>
						</tr>
						<tr>
							<td>语音资料</td>
							<td><input type="file" id="attachment" name="attachment">
							</td>
						</tr>
					</table>
				</div>

				<div id="mysubmit"
					style="margin-top:30px;width:600px;float:right;margin-top:80px;margin-right:100px;">
					<img src="${url}/image/largebutton_subsave.png" onclick="check();"
						style="float:right;">
				</div>
			</div>
		</form>
	</div>
	
	
	<!--版权信息等-->
	<div id="footer" style="margin-top:100px;text-align:center">
		<jsp:include page="/WEB-INF/bottom/footer.jsp"></jsp:include>
	</div>
</body>
</html>