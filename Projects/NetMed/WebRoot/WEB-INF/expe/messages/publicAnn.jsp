<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.Date"%>
<%@ page language="java" import="java.sql.*"%>
<%
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	String name = (String) session.getAttribute("expename");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${url}/css/style.css"/>
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script>
         function check(){
				if($('#content').val()==""){
					$("#content").select();
					$("#content").focus();
				}else{
					submit();
				}
			}
			function submit(){
			$.ajax({
		        url : '<%=templateUrl%>/expe/AddGongGao',
				type : 'POST',
				data:"content="+$('#content').val(),
				contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				dataType : 'text',
				timeout : 8000,
				cache : true,
				errot:erryFunction,
				success : succFunction
			//成功执行方法  
			});
			function erryFunction() {
				alert("有错误，请刷新页面");
			}
			function succFunction(data) {
				var  data= String($.trim(data)); 
				if(data=="yes"){
					alert("发送新公告成功");
					window.location="publicAnn";
				}else{
					alert("新公告发布失败！请重试");
				}
			}
		}
	</script>
</head>
<body>
<div><img src="${url}/imgs/left.png"/>&nbsp;&nbsp;<span style="font-family:'仿宋';font-size:30pt">公告栏</span>
		&nbsp;&nbsp;<img src="${url}/imgs/right.png"/></div>


		   <div style="margin-top:10px;margin-left:150px">
			<textarea id="content" name="content" placeholder="请输入公告内容" style="width:60%;height:100px;border:solid 2px #BFA789;border-radius:8px"></textarea>
			</div>
			<div id="mysubmit" style="margin-top:15px;width:500px;margin-left:250px;font-family:'宋体';font-size: 25pt; text-align: center;">
				<input type="button"  value="发公告" onclick="check();" style="font-family:'宋体';font-size: 20pt;border-radius:6px">
			</div>
</body>
</html>