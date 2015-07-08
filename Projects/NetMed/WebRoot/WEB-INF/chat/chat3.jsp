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
	String expe_id = (String) session.getAttribute("expe_id");
	String sender=expename;
	String reciver=mem_id;
	if((expename==null||expename=="")||(mem_id==null||mem_id=="")){
		   sender=username;
		   reciver=expe_id;	
	}
			
%>
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

<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script type="text/javascript">
        window.contextPath = "<%=path%>";
        window["serverDomin"] = "iZ94kqx1u2hZ";    //设置openfire域名，必须与服务器域名一致 iZ94kqx1u2hZ
 </script>
<script type="text/javascript" src="${url}/js/jsjac.js"></script>
<script type="text/javascript" src="${url}/js/send.message.editor-1.0.js"></script>
<script type="text/javascript" src="${url}/js/jquery.easydrag.js"></script>
<script type="text/javascript" src="${url}/js/remote.jsjac.chat-2.0.js"></script>
<script type="text/javascript" src="${url}/js/local.chat-2.0.js"></script>

<script charset="utf-8" type="text/javascript">

//在线聊天  
function checkOnline(){
	
	    $.ajax({
	                url : '<%=templateUrl%>/CheckOnlineAction',
	                type : 'POST',
	                data: JSON.stringify(userchat),
	                contentType: "application/json; charset=utf-8",  
					dataType : 'text',
					timeout : 18000,
					cache : true,
					beforeSend : LoadFunction, //加载执行方法  
					error : erryFunction, //错误执行方法  
					complete : conFunction,
					success : succFunction	//成功执行方法  
				});
				function LoadFunction() {;}
				function erryFunction() {alert("该专家不在线,请稍后再试！");}
	     		function conFunction()  {}
				function succFunction(data) {
					var data = String($.trim(data)); 
					if(data=="no"){
						alert("该专家不在线,请稍后再试！");
						return;
					}else{
						alert("请求成功");
						chat();
				}
				};
};
			

var userchat ={
		sender:'<%=sender%>',
		reciver:'<%=reciver%>'
	};
//在线聊天  
function chat(){
	var user={
			userName:userchat.sender,
			password:"xianggen"
		};
	
// 登陆到openfire服务器
remote.jsjac.chat.login(user);
              // 建立一个聊天窗口应用，并设置发送者和消息接收者
              
              /*
              $.WebIM({
                  sender: userchat.sender,
                  receiver: userchat.reciver
              });*/
              

           $.WebIM({
                 sender: userchat.sender,
                 receiver: userchat.reciver.toLowerCase()
           });
}

</script>
<title>在线咨询--会员</title>
</head>
<body>
<div style="margin-top:5%; margin-left:400px;">
  <img title="点击发起在线聊天" id="online" src="${url}/image/online.png" style="border:2px solid #09F;border-radius:5px"  onclick="checkOnline();"/> <br/>  <br/>  <br/>
  <img title="电话连线" id="telphone" src="${url}/image/telphone.png" style="border:2px solid #09F;border-radius:5px"  onclick="alert('请拨15111285014');"/>
  <br/>  <br/>  <br/>
  <img title="远程视频聊天" id="videoChat" src="${url}/image/videoChat.png" style="border:2px solid #09F;border-radius:5px"  onclick="alert('功能正在实现');"/>
</div>
	<div class="doc" style="margin-left: 30%;margin-top: 10%;float: left;">
		<div id="footer">
			<!-- 日志信息 -->
			<div id="error" style="display:none ; background-color: red;"></div>
			<div id="info" style="display:none ; background-color: #999999;"></div>
			
			<!-- 聊天来消息提示 -->
			<div class="chat-message" style="margin-left: 35%;">
				<img src="${url}/images/write_icon.png" class="no-msg" /> 
				<img src="${url}/images/write_icon.gif" class="have-msg" style="display: none;" />
			</div>
		</div>
	</div>
</body>
</html>
