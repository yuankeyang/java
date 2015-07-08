<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", -10);
%>
<%
String basepath = request.getScheme() + "://"
		+ request.getHeader("host") + request.getContextPath();
String templateUrl = request.getScheme() + "://"
	+ request.getHeader("host") + request.getContextPath();
request.setAttribute("url", templateUrl);
	String name = (String) session.getAttribute("expename");
	String times = System.currentTimeMillis() + "";
%>
<!DOCTYPE>
<html>
<head>
<script type="text/javascript" src="${url}/js/centerLeft.js"></script>
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script type="text/javascript" src="${url}/js/ajax-pushlet-client.js"></script>

<style type="text/css">
   .offAccount a{ color:#000;text-decoration:none }
   .offAccount a:hover{color:#ff0000}
   .offAccount a:active{color:#ff0000}   
</style>

<script>

$(document).ready(function(){

	var dd='<%=name%>';
	if(dd==null){
		alert("您已不在线，请重新登录！");
		window.location.reload();
	}else{
		//setInterval("geChatInfo()", 10000);
		getGeRenInfo();
		
	}

});

function getGeRenInfo(){
	$.ajax({
        url : '<%=templateUrl%>/expe/getExpeCenData',
        type : 'POST',
        contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		 dataType : 'json',
		 timeout : 20000,
		 cache : true,
		 error : erryFunction, //错误执行方法  
		 success : succFunction	//成功执行方法  
		});
		function erryFunction() {alert("正获取个人信息，请耐心等待");}
		function succFunction(data) {
			
			$('#rank').html(data.rank);
			$('#credit').html(data.credit);
			$('#money').html(data.money);
			//alert(data.photo);
			$('#photo').attr("src",'<%=basepath%>'+data.photo+"?_t<%=times%>");
			if(parseInt(data.membConsAccount)!=0){
				$("#records").append("<li class=\"offAccount\">您有<font size=\"7\"><b><a href='noreadBox'>"+data.membConsAccount+"</a></b></font>条未处理的离线咨询，请到通知中心尽快处理呦!</li>");
			}
			if(parseInt(data.appointmentAccount)!=0){
				$("#records").append("<li class=\"offAccount\">您有<font size=\"7\"><b><a href='appointMan'>"+data.appointmentAccount+"</a></b></font>条未处理的预约，请到通知中心尽快处理呦!</li>");
			}//
	};
}
</script>
</head>
<body >
<div><img src="${url}/imgs/left.png"/>&nbsp;&nbsp;<span style="font-family:'仿宋';font-size:30px;color:#c9b28b">个人中心</span>
		&nbsp;&nbsp;<img src="${url}/imgs/right.png"/></div>
  <div>
	<div><%--
	    <div style="margin-top:20px;margin-left: 10px;width: 40%;height: 0px;">
			<a	href="<%=basepath%>/expe/upload?exp_id=<%=name%>"> 
			<img id="photo" alt="头像" title="点击修改头像" width="100px" height="100px"/>
			</a>
		</div> 
		--%>
		
		<div  style="margin-left: 100px; margin-top:10px;width:70%;" >
		   <div style="height: 0px;margin-left: 160px;" >
		      <h1 style="font-family:'宋体'"> <%=name%>&nbsp;您好！</h1>
		   </div>
			<div style="margin-right: 20px;margin-top: 20px;" align="right">
				<a target="_blank"  href="javascript:void(0)"><img width="110" height="35"
					src="<%=basepath%>/images/nousedphone.png" title="下载手机客户端，随时随地联系颐健通">
				</a>
			</div>
			<div style="margin-left: 100px;margin-top: 30px;font-size: 14pt;font-family: '宋体';" align="left"  >
			      积分: <a href="javascript:void(0)" id="credit"></a>分&nbsp;&nbsp;
			    账户余额: <a href="javascript:void(0)" id="money"></a>元&nbsp;&nbsp;
			    等级: <a href="javascript:void(0)" id="rank"></a>
			    <label id="test"></label>
	     	</div>
		</div>
		
	</div>
	<br/>
    <hr>
	<div style="margin-top: 20px;font-size: 14pt;font-family:'宋体';">
		<h3>最近的通知:</h3>
		<ul id="records"></ul>
	</div>
</div>	
	
</body>

</html>