<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	//专家调用
	String expename = (String) session.getAttribute("expename");
	String mem_id = request.getParameter("mem_id");
    //用户调用
	String username = (String) session.getAttribute("username");
	String expe_id = request.getParameter("expe_id");
    
	String sender=expename;
	String reciver=mem_id;
	if((expename==null||expename=="")||(mem_id==null||mem_id=="")){
		   sender=username;
		   reciver=expe_id;	
	}
			
%>
<!--专家在线咨询页面 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="../include/topbarhead.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="${url}/css/tab02.css" />
<link rel="stylesheet" type="text/css" href="${url}/css/style.css" />
<link rel="stylesheet" type="text/css" href="${url}/css/main.css" />
<link rel="stylesheet" type="text/css" href="${url}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${url}/css/chat-2.0.css">
<link rel="stylesheet" type="text/css" href="${url}/css/article.css" />   <!-- 背景图片！！！ -->

<script type="text/javascript" src="${url}/js/tab.js"></script>
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script type="text/javascript" src="${url}/js/ajax-pushlet-client.js"></script>  <!-- 缺了对话框不能出来 -->

<script type="text/javascript">
        window.contextPath = "<%=path%>";
        window["serverDomin"] = "iZ94kqx1u2hZ";   //设置openfire域名，必须与服务器域名一致   iZ94kqx1u2hZ
</script>

<script type="text/javascript" src="${url}/js/jsjac.js"></script>
<script type="text/javascript" src="${url}/js/send.message.editor-1.0.js"></script>
<script type="text/javascript" src="${url}/js/jquery.easydrag.js"></script>
<script type="text/javascript" src="${url}/js/remote.jsjac.chat-2.0.js"></script>
<script type="text/javascript" src="${url}/js/local.chat-2.0.js"></script>


<script charset="utf-8" type="text/javascript">
var userchat ={
		sender:'<%=sender%>',
		reciver:'<%=reciver%>'
	};
PL.userId = '<%=expename%>';
PL._init();
PL.joinListen('chat');
PL.joinListen('newMessage');
function onData(event) {
	//alert("sdsd");
	if(event.get("sender")!=null&&event.get("sender")!=""){
		alert(event.get("sender"));
		userchat.reciver = event.get("sender");
		chat();
		document.getElementById("chat").click();
	}
	if(event.get("message")!=null&&event.get("message")!=""){
		   alert(event.get('message'));
	}
}

	//在线聊天  
function chat(){
              // 建立一个聊天窗口应用，并设置发送者和消息接收者
              $.WebIM({
                  sender: userchat.sender,
                  receiver: userchat.reciver.toLowerCase()
              });
              
              
              /*
              $.WebIM({
                  sender: userchat.sender,
                  receiver: userchat.reciver.toLowerCase()
              });
              */
              
}
$(document).ready(function(){
	var user={
				userName:userchat.sender,
				password:"xianggen"       //用户openfire密码
			};
	
	// 登陆到openfire服务器
    remote.jsjac.chat.login(user);
	if(('<%=expename%>'!= "")&&('<%=mem_id%>'!="")) {
			chat();
		}
	});
</script>
<title>在线咨询--专家</title>
</head>
<body>
	<div class="doc" style="margin-left:50%;margin-top: 10%;height: 20%">
		<div id="footer">
			<!-- 日志信息 -->
			<div id="error" style="display:none ; background-color: red;"></div>
			<div id="info" style="display:none ; background-color: #999999;"></div>
			
			<!-- 聊天来消息提示 -->
			
			<div class="chat-message" style="margin-left: 35%;margin-top: 90%">
				<img src="${url}/images/write_icon.png" class="no-msg" /> <img
					src="${url}/images/write_icon.gif" class="have-msg"
					style="display: none;" />
			</div>
		</div>
	</div>
</body>
</html>
