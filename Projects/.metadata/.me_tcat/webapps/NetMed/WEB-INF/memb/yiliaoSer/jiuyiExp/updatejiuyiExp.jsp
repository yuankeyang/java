<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	String templateUrl = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath();
	request.setAttribute("url", templateUrl);
	//文章的id
    String JiuyiExp_Id=request.getParameter("JiuyiExp_Id");   
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
		<link rel="stylesheet" type="text/css" href="${url}/css0623/style.css"/>
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
		$(document).ready(function(){
			$(document).ready(function(){
				if('<%=JiuyiExp_Id%>'!=""){
					getJiuyiExp('<%=JiuyiExp_Id%>');
				}
			});
		});
		//获取电子病历表
		function getJiuyiExp(JiuyiExp_Id){
			
			 $.ajax({
		            url : '<%=templateUrl%>/user/JiuyiExpForRead?JiuyiExp_Id=<%=JiuyiExp_Id%>',
		            type : 'POST',
		            contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				    dataType : 'json',
				    timeout : 18000,
				    cache : true,
					error : erryFunction, //错误执行方法  
					success : succFunction	//成功执行方法  
				});
				function erryFunction() {
					//alert("请刷新页面!!");
					}
				function succFunction(data) {
					//alert(data.content);
					$('#title').val(data.title);
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
					//$('#UpdateJiuyiExp').submit();
					submit();
				}
			}
			//<form action="AddJiuyiExp" id="AddJiuyiExp" method="post">
			function submit(){
			$.ajax({
		        url : '<%=templateUrl%>/user/UpdateJiuyiExp',
				type : 'POST',
				data:"title="+$('#title').val()+"&content="+editor.html()+'&JiuyiExp_Id=<%=JiuyiExp_Id%>',
				contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				dataType : 'text',
				timeout : 18000,
				cache : true,
				errot:erryFunction,
				success : succFunction
			//成功执行方法  
			});
			function erryFunction() {
				//alert("请刷新页面!!");
			}
			function succFunction(data) {
				//修改成功
				alert("修改成功");
				window.location="jiuyiExp";
			}
			}
			
		</script>
	</head>
	<body>
	<div><img src="${url}/imgs/left.png"/>&nbsp;<span style="font-family:'仿宋';font-size:33px;color:#c9b28b">修改就医经验</span>
		&nbsp;<img src="${url}/imgs/right.png"/></div>
	    
		<br/><br/>
		<div>
		   <label style="width:80%;height:30px;font-family: '宋体' ;font-size: 18px;">文章标题:</label>
		   <input type="text" id ="title" name="title" style="width:81%;height:25px;font-family: KaiTi_GB2312;font-size: 18px;"/>
		   </div>
		   <div style="margin-top: 10px;">
			<textarea id="content" name="content" style="width:97%;height:400px;"></textarea>
			</div>
			<div id="mysubmit" style="margin-top:8px;width:800px;float:right;margin-right:100px;">
				    <img src="${url}/image/largebutton_subsave.png" onclick="check();" style="float:right;">
				</div>
	</body>
</html>
