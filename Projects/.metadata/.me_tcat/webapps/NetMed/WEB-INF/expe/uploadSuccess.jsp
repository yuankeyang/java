<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>upload SUCCESS</title>
</head>
<body>
<div>
<p style="color:green;text-align:center;">上传成功！3秒后跳转</p>
<p style="color:red;text-align:center;">文件名：${uploadFileName}</p>
</div>

<script>
window.onload=function(){
	setTimeout("gotoUserCenter()",3000 );
};
function gotoUserCenter(){
	location.href="wodeCen";
}

</script>
</body>
</html>