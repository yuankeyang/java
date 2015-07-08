<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="/WEB-INF/include/core_head.jsp"></jsp:include>
<%
String templateUrl = request.getScheme() + "://"
		+ request.getHeader("host") + request.getContextPath();
String basepath = request.getScheme() + "://"
		+ request.getHeader("host") + request.getContextPath();
String name = (String) session.getAttribute("expename"); 
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
<title>专家个人中心</title>
<link href="${url}/css0623/style.css" rel="stylesheet">
<jsp:include page="/WEB-INF/include/head.jsp"></jsp:include>
<script type="text/javascript" src="${url}/js/ajax-pushlet-client.js"></script>
<script type="text/javascript">
function geChatInfo(){
	$.ajax({
        url : '<%=templateUrl%>/expe/GetChatDataByExpertId',
			type : 'POST',
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			dataType : 'json',
			timeout : 25000,
			cache : true,
			error : erryFunction, //错误执行方法  
			success : succFunction
		//成功执行方法  
		});
		function erryFunction() {
			//alert("正在获取个人信息，请稍后刷新重试");
		}
		function succFunction(data) {

			if (parseInt(data.account) != 0) {
				$.each(data.chatArray, function(index) {
					alert("您有新的在线咨询！");
					$('#chat').attr("href",
							"chat?mem_id=" + data.chatArray[index].mem_id);
					document.getElementById("chat").click();
				});
			}
		}
	}

$(document).ready(function(){

	var dd='<%=name%>';
	if(dd==null){
		alert("您已不在线，请重新登录！");
		window.location.reload();
	}else{
		
		setInterval("geChatInfo()", 10000);
		getGeRenInfo();
	}

$('#menu ul li a').each(function(){
$(this).click(function(){
var item=$(this).attr('id');
$('#secondry iframe').attr('src','<%=templateUrl%>/expe/'+item);
});

$("#edit-bnt").click(function(){
	var item="gerenInfo";
	$('#secondry iframe').attr('src','<%=templateUrl%>/expe/'+item);
	  
});

});
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
		function erryFunction() {
			//alert("正获取个人信息，请耐心等待");
		}
		function succFunction(data) {
			
			$('#rank').html(data.rank);
			$('#credit').html(data.credit);
			$('#money').html(data.money);
			$('#headImg').attr("src",'<%=basepath%>'+data.photo);
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
						<h2><span>个人管理</span></h2>
						<a href="javascript:void(0)" id="diaryMan"><span>日记管理</span></a>
						<a href="javascript:void(0)" id="articleMan"><span>文章管理</span></a>
						<a href="javascript:void(0)" id="scheduleArr"><span>日程安排</span></a>
						<a href="javascript:void(0)" id="myservice"><span>离线服务</span></a>
						<a href="javascript:void(0)" id="myappoint"><span>我的预约</span></a>
					</li>
					<li class="item-2">
						<h2><span>工具箱</span></h2>
						<a href="javascript:void(0)" id="myRepository"><span>我的知识库</span></a>
						<a href="javascript:void(0)" id="SpecialRepository"><span>专业知识库</span></a>
						<a href="javascript:void(0)" id="resourceLibrary"><span>资料库</span></a>
					</li>
					<li class="item-3">
						<h2><span>通知中心</span></h2>
						<a href="javascript:void(0)" id="noreadBox"><span>离线申请</span></a>
						<a href="javascript:void(0)" id="appointMan"><span>预约申请</span></a>
						<a href="javascript:void(0)" id="publicAnn"><span>公告</span></a>
					</li>
					<li class="item-4">
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
				<iframe name="rightContent" src="${url}/expe/wodeCen">
				</iframe>
			</div>
		</div>
		<div id="footer">
			<p>颐健通研发小组</p>
	<p>&#169;版权所有&nbsp;2015-2016</p>
		</div>
	</div>
	<a target="_blank" id="chat" style="display: none"></a>   <!-- 在线咨询的 id -->
</body>

</html>