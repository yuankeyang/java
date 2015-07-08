<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.Date"%>
<%@ page language="java" import="java.sql.*"%>
<%
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	//文章的id
     String Article_Id=request.getParameter("Article_Id");   
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${url}/css/article.css" />
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script>
$(document).ready(function(){
	$(document).ready(function(){
		if('<%=Article_Id%>'!=""){
			getArticle('<%=Article_Id%>');
		}
	});
});
//获取电子病历表
function getArticle(Article_Id){
	
	 $.ajax({
            url : '<%=templateUrl%>/expe/ArticleForRead?Article_Id=<%=Article_Id%>',
            type : 'POST',
            contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		    dataType : 'json',
		    timeout : 8000,
		    cache : true,
			error : erryFunction, //错误执行方法  
			success : succFunction	//成功执行方法  
		});
		function erryFunction() {alert("请刷新一下页面!!");}
		function succFunction(data) {
			$('#title').html("<h1>"+data.title+"</h1>");
			$('#time').html("<h3>"+data.time+"</h3>");
			$('#content').html(data.content);
	};
}
</script>
<title>查看文章</title>

</head>
<body>
 <div align="center" >
    <div style="width: 70%;margin-top: 40px;">
         <center><span id="title" ></span></center>
         <span id="time" style="text-align: right;"></span>
         <hr align="center"></hr>
    </div>
    
	<div id="content" class="content" style="width: 70%;border: 0px solid #200;">
		
	</div>
</div>
</body>

</html>
