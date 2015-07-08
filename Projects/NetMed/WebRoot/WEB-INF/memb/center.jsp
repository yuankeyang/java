<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="/WEB-INF/include/core_head.jsp"></jsp:include>
<%
String templateUrl = request.getScheme() + "://"
		+ request.getHeader("host") + request.getContextPath();
String basepath = request.getScheme() + "://"
		+ request.getHeader("host") + request.getContextPath();
String name = (String) session.getAttribute("username"); 
if(name==null){
response.sendRedirect(templateUrl);
return;
}
String times = System.currentTimeMillis() + "";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>会员个人中心</title>
<link href="${url}/css0623/style.css" rel="stylesheet">
<jsp:include page="/WEB-INF/include/head.jsp"></jsp:include>
<script type="text/javascript">
$(document).ready(function(){
	
var dd='<%=name%>';
if(dd==null){
	alert("您已不在线，请重新登录！");
	window.location.reload();
}else{
	getGeRenInfo();
}

$('#menu ul li a').each(function(){
$(this).click(function(){
var item=$(this).attr('id');
$('#secondry iframe').attr('src','<%=templateUrl%>/user/'+item);
});

});

$("#edit-bnt").click(function(){
	var item="gerenInfo";
	$('#secondry iframe').attr('src','<%=templateUrl%>/user/'+item);
	  
});
	
});
	
function getGeRenInfo(){
	$.ajax({
        url : '<%=templateUrl%>/user/getMembCenData',
        type : 'POST',
        contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		dataType : 'json',
	    timeout : 25000,
		cache : true,
		error : erryFunction, //错误执行方法  
		success : succFunction	//成功执行方法  
		});
		function erryFunction() {
			//alert("正获取会员信息，请等待3秒后刷新页面!!");
			}
		function succFunction(data) {
			$('#rank').html(data.rank);
			$('#credit').html(data.credit);
			$('#money').html(data.money);
			$('#headImg').attr("src",'<%=basepath%>'+data.head_img+"?_t<%=times%>");
			$("#records").append("<li>暂无任何通知!</li>");
	};
}
</script>
</head>
<body>
	<div id="bodycnt">
		<div id="head">
			<div class="nav">
				<div class="logo">
					<s:a namespace="/" action="welcome"><img src="${url}/imgs/membercenter/logo.png"></s:a>
				</div>
				<div class="nav-1">健康咨询平台</div>
				<div class="nav-2">
					<a class="name" href="javascript:void(0);"><%=name %></a>
					<s:a cssClass="logout" namespace="/" action="exit">退出</s:a>
				</div>
			</div>
			<div id="menu">
				<div class="cw">个人中心</div>
				<ul class="ul-1">
					<li class="item-1">
						<h2><span>医疗服务</span></h2>
						<a href="javascript:void(0)" id="wodeDoc"><span>我的专家</span></a>
						<a href="javascript:void(0)" id="huanyouSoc"><span>患友会</span></a>
						<a href="javascript:void(0)" id="jiuyiExp"><span>就医经验</span></a>
					</li>
					<li class="item-2">
						<h2><span>可穿戴设备</span></h2>
						<a href="javascript:void(0)" id="myBloodPressure"><span>我的血压</span></a>
						<a href="javascript:void(0)" id="mySleepRecord"><span>睡眠记录</span></a>
					</li>
					<li class="item-3">
						<h2><span>疾病管理</span></h2>
						<a href="javascript:void(0)" id="jibingMan"><span>离线咨询</span></a>
						<a href="javascript:void(0)" id="myAppointment"><span>我的预约</span></a>
					</li>
					<li class="item-4">
						<h2><span>我的家属</span></h2>
						<a href="javascript:void(0)" id="myfamily"><span>我的家属</span></a>
						<a href="javascript:void(0)" id="membArchInfo"><span>电子档案</span></a>
					</li>
					<li class="item-5">
						<h2><span>我的账户</span></h2>
						<a href="javascript:void(0)" id="caiwuMan"><span>财务管理</span></a>
						<a href="javascript:void(0)" id="jifenMan"><span>积分管理</span></a>
						<a href="javascript:void(0)" id="gerenInfo"><span>个人信息</span></a>
						<a href="javascript:void(0)" id="passChange"><span>修改密码</span></a>
					</li>
					<li class="item-5">
						<a href="javascript:void(0)" id="feedback "><span>意见反馈</span></a>
					</li>
				</ul>
				</div>
		</div>
		<div id="content">
			<div id="primary">
				<div class="personal-data">
					<div id="icon"><img id="headImg" class="icon"/></div>
					<div class="welcome"><b><%=name %></b>,欢迎</div>
					<div class="edit">
						<a href="javascript:void(0)" class="edit-bnt" id="edit-bnt">编辑资料</a>
						<%--<a id="edit-bnt00" style="display: none"></a>--%>
					</div>
				</div>
				<div class="acount-detail">
					<ul class="ul-2">
						<li class="point">
							<img src="${url}/imgs/membercenter/point.png">
							<div><a href="">积分</a><span id="credit"></span></div>
						</li>
						<li class="balance">
							<img src="${url}/imgs/membercenter/balance.png">
							<div><a href="">余额</a><span id="money"></span></div>
						</li>
						
						<li class="rate">
							<img src="${url}/imgs/membercenter/rate.png">
							<div><a href="">等级</a><span id="rank"></span></div>
						</li>
					</ul>
				</div>
			</div>
			
			<div id="secondry">
				<iframe name="rightContent" src="${url}/user/wodeCen"></iframe>
			</div>
		</div>
		<div id="footer">
			<p>颐健通研发小组</p>
	        <p>&#169;版权所有&nbsp;2015-2016</p>
		</div>
	</div>
	
</body>

</html>
