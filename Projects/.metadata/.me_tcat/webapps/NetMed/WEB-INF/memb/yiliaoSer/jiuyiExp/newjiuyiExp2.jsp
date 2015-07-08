<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../../../include/core_head.jsp"></jsp:include>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Default Examples</title>
		<style>
			form {
				margin: 0;
			}
			textarea {
				display: block;
			}
		</style>
		
		<link rel="stylesheet" type="text/css" href="${url}/wangEditor/wangEditor-1.3.0.min.css">
		<script type="text/javascript" src='${url}/js/jquery.js'></script>
		<script type="text/javascript" src='${url}/wangEditor/wangEditor-1.3.0.min.js'></script>
		<script type="text/javascript">
	    $(function(){
		         $('#content').wangEditor();
	    });
</script>
	</head>
	<body>
		<h3>记录您的就医经验</h3>
		<form>
		<div>
		   <label style="width:80%;height:30px;font-family: KaiTi_GB2312;font-size: 18px;">文章标题:</label>
		   <input type="text" name="jiuyi_experience_title" style="width:80%;height:25px;font-family: KaiTi_GB2312;font-size: 18px;"/>
		   </div>
		   <div style="margin-top: 10px;">
			<textarea name="content" style="width:90%;height:400px;"></textarea>
			<p>
				<input type="button" name="getHtml" value="取得HTML" />
				<input type="button" name="isEmpty" value="判断是否为空" />
				<input type="button" name="getText" value="取得文本(包含img,embed)" />
				<input type="button" name="selectedHtml" value="取得选中HTML" />
				<br />
				<br />
				<input type="button" name="setHtml" value="设置HTML" />
				<input type="button" name="setText" value="设置文本" />
				<input type="button" name="insertHtml" value="插入HTML" />
				<input type="button" name="appendHtml" value="添加HTML" />
				<input type="button" name="clear" value="清空内容" />
				<input type="reset" name="reset" value="Reset" />
			</p>
			</div>
		</form>
	</body>
</html>
