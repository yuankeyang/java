<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	String templateUrl = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath();
	request.setAttribute("url", templateUrl);
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
		<link rel="stylesheet" type="text/css" href="${url}/css0623/style.css" />
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
					//alert(editor.html());
					//alert(editor.isEmpty());
					//editor.html('<h3>Hello KindEditor</h3>');
					//editor.text('<h3>Hello KindEditor</h3>');
			});
			
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
					submit();
				}
			}
			//<form action="AddArticle" id="AddArticle" method="post">
			function submit(){
			$.ajax({
		        url : '<%=templateUrl%>/expe/AddArticle',
				type : 'POST',
				data:"title="+$('#title').val()+"&content="+editor.html(),
				contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				dataType : 'text',
				timeout : 18000,
				cache : true,
				errot:erryFunction,
				success : succFunction
			//成功执行方法  
			});
			function erryFunction() {
				alert("请刷新页面");
			}
			function succFunction(data) {
				alert("创建新文章成功");
				window.location="articleMan";
			}
			}
			
		</script>
	</head>
	<body>
		<div>
			<img src="${url}/imgs/membercenter/left.png"/><font
				size="6">创建文章(公开)
			</font><img
				src="${url}/imgs/membercenter/right.png" />
		</div>
		<br/><br/>
		<form action="AddArticle" id="AddArticle" method="post">
		<div>
		   <label style="width:80%;height:30px;font-family:'宋体';font-size: 18px;">文章标题:</label>
		   <input type="text" id ="title" name="title" style="width:81%;height:25px;font-family: '宋体';font-size: 18px;"/>
		   </div>
		   <div style="margin-top: 10px;">
			<textarea id="content" name="content" style="width:97%;height:400px;"></textarea>
			</div>
			<div id="mysubmit" style="margin-top:8px;width:800px;float:right;margin-right:100px;">
				    <img src="${url}/image/largebutton_subsave.png" onclick="check();" style="float:right;">
			</div>
	  </form>
	</body>
</html>
