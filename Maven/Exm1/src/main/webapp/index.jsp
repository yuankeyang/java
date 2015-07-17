<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<html>
<head>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>WebService</title>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#query").click(function(){
		sno=$("#sno").val();
		//alert(sno);
		var messagews='<?xml version="1.0" encoding="utf-8" ?>'+
	'<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">'+
    '<S:Header/>'+
    '<S:Body>'+
    '<ns2:getInfo xmlns:ns2="http://webservice.yang.com">'+
    '<sno>'+sno+'</sno>'+
    '</ns2:getInfo>'+
    '</S:Body>'+
    '</S:Envelope>';
		$.ajax({
			type:"POST",
			url:"http://localhost:8083/Exm1/services/Hello.HelloHttpEndpoint/hello",
// 			data:messagews,
// 			contentType:'text/xml; charset="utf-8"',
			dataType:'text',
			success:function(result){
				alert(result);
				//xmlDoc = $.parseXML(result);
// 				jsonobj=$(result).find("soapenv:Envelope")
// 						.find("soapenv:Body")
// 						.find("ns:getInfoResponse")
// 						.find("ns:return");
// 				alert(jsonobj.toString());
// 				alert(result);
// 				jsonstr=$(result).find("ns:return").text();
// 				alert(jsonstr);
// 				json=JSON.stringify(jsonstr);
// 				alert(json);

			},
			error:function(){
				alert("请求失败！");
			}
		});
	});
});
</script>

</head>
<body>
<div class="container">
<div class="form-inline">
<div class="form-group">
<label>学号</label><input type="text" class="form-control" id="sno" placeholder="请输入学号">
<button id="query" class="btn btn-default">查询</button>
</div>
<div class="form-group">
<label>结果:</label><div id="result"></div>
</div>
</div>
</div>
</body>
</html>