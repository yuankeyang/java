<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	String templateUrl = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath();
	request.setAttribute("url", templateUrl);
	//文章的id
    String Article_Id=request.getParameter("Article_Id");   
	%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8" />
		<style>
			form {
				margin: 0;
			}
			textarea {
				display: block;
			}
		</style>
		<%--<link rel="stylesheet" type="text/css" href="${url}/css0623/style.css" />--%>
		<link rel="stylesheet" href="${url}/kindeditor/themes/default/default.css" />
		<script type="text/javascript" src="${url}/js/jquery.js"></script>
		<script charset="utf-8" src="${url}/kindeditor/kindeditor-min.js"></script>
		<script charset="utf-8" src="${url}/kindeditor/lang/zh_CN.js"></script>
		<script>
		var editor;
		KindEditor.ready(function(K) {
			editor = K.create('textarea[name="content"]', {
				allowFileManager : true
			});
		});
		
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
				    timeout : 18000,
				    cache : true,
					error : erryFunction, //错误执行方法  
					success : succFunction	//成功执行方法  
				});
				function erryFunction() {alert("请刷新一下页面!!");}
				function succFunction(data) {
					//alert(data.content);
					$('#title').val(data.title);
					//$('#content').val(data.content);
					editor.html(data.content);
			};
		}
			
		//提交检查	
		function check(){
			  //alert($('#title').val());
				if($('#title').val()==""){
					$("#title").select();
					$("#title").focus();
				}else if(editor.isEmpty()){
					$("#content").select();
					$("#content").focus();
				}else{
					$('#content').val(editor.html());
					//$('#UpdateArticle').submit();
					submit();
				}
			}
			//<form action="AddArticle" id="AddArticle" method="post">
			function submit(){
				//alert("ssss");
			$.ajax({
		        url : '<%=templateUrl%>/expe/UpdateArticle',
				type : 'POST',
				data:"title="+$('#title').val()+"&content="+editor.html()+'&Article_Id=<%=Article_Id%>',
				contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				dataType : 'text',
				timeout : 18000,
				cache : true,
				errot:erryFunction,
				success : succFunction
			//成功执行方法  
			});
			function erryFunction() {
				alert("请刷新一下页面!!");
			}
			function succFunction(data) {
				//修改成功
				alert("更新新文章成功");
				window.location="articleMan";
			}
			}
			
		</script>
	</head>
	<body>
		<div>
			<img src="${url}/imgs/membercenter/left.png"/>&nbsp;&nbsp;<font
				size="6">修改文章
			</font>&nbsp;&nbsp;<img
				src="${url}/imgs/membercenter/right.png" />
		</div>
		<br/><br/>
		<div>
		   <label style="width:80%;height:30px;font-family: '宋体';font-size: 18px;">文章题目:</label>
		   <input type="text" id ="title" name="title" style="width:81%;height:25px;font-family:'宋体';font-size: 18px;"/>
		   </div>
		   <div style="margin-top: 10px;">
			<textarea id="content" name="content" style="width:97%;height:400px;"></textarea>
			</div>
			<div id="mysubmit" style="margin-top:8px;width:800px;float:right;margin-right:100px;">
				    <img src="${url}/image/largebutton_subsave.png" onclick="check();" style="float:right;">
				</div>
	</body>
</html>
