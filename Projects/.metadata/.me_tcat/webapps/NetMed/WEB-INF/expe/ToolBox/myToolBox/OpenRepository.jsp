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
<link rel="stylesheet" type="text/css" href="${url}/css/article.css" />
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
		function erryFunction() {alert("正获取您的个人知识库详情，请耐心等待再刷新页面");}
		function succFunction(data) {
			//alert(data.content);
			$('#title').html("<h1>"+data.presName+"</h1>");
			$('#time').html("<h3>"+data.time+"</h3>");
			$('#illnDesc').html("<h3>病情描述："+data.illnDesc+"</h3>");
			$('#syndrome').html("<h3>证候："+data.syndrome+"</h3>");
			$('#mediMate').html("<h3>方剂组成："+data.mediMate+"</h3>");
			$('#westMedi').html("<h3>西药："+data.westMedi+"</h3>");
			$('#chinDise').html("<h3>中医疾病："+data.chinDise+"</h3>");
			$('#westDise').html("<h3>西医疾病："+data.westDise+"</h3>");
			
	};
}
</script>
</head>
<body>
 <div align="center" >
    <div style="width: 70%;margin-top: 40px;">
         <center><span id="title" ></span></center>
         <span id="time" style="text-align: right;"></span>
         <hr align="center"></hr>
    </div>
    
    <div id="illnDesc" class="illnDesc" style=""></div>
    <div id="mediMate" class="mediMate" style=""></div>
     <div id="westMedi" class="westMedi" style=""></div>
    <div id="syndrome" class="syndrome" style=""></div>
    <div id="chinDise" class="chinDise" style=""></div>
    <div id="westDise" class="westDise" style=""></div>
	<div id="presDetail" class="presDetail" style="width: 70%;border: 0px solid #200;"></div>
	
	
</div>
</body>

</html>
