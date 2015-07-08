<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	String username = (String) session.getAttribute("username");
	String expe_id = request.getParameter("expe_id");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="../../include/topbarhead.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="${url}/css/tab02.css" />
<link rel="stylesheet" type="text/css" href="${url}/css/style.css" />
<link rel="stylesheet" type="text/css" href="${url}/css/main.css" />
<link rel="stylesheet" type="text/css" href="${url}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${url}/css/style.css"/>
<link rel='stylesheet' type="text/css" href='${url}/schedule/jquery-ui-1.11.4/jquery-ui.css' />

<script type="text/javascript" src="${url}/js/tab.js"></script>
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script type="text/javascript" src='${url}/schedule/jquery-ui-1.11.4/jquery-ui.js'></script>

<script charset="utf-8" type="text/javascript">
	//在线聊天  
function payDialog2(){
	
	$("#dialog").dialog("open");
	
	$("#confirm_consult").click(function(){
	var s="user/payAction3?userId=<%=username%>&expe_id=<%=expe_id%>";
	window.open("<%=templateUrl%>/"+s);
	$("#dialog").dialog("close");       //确认咨询后关闭对话框
	window.location.reload(true);   //关闭支付窗口后重新刷新一下页面！！！
	});
	};
		
$(window).load(function(){
	$("#dialog").dialog({
		  open:function(){//对话框打开时初始化
			getMemberCredit();
		  },
	    autoOpen: false,
	    height:400,
	    width:500,
	    modal:true,
	    title:'支付界面',
	    draggable:true,
	    buttons:[{
	    text:"关闭",
	    click:function(){
	       $(this).dialog("close");
	       window.location.reload(true);   //关闭支付窗口后重新刷新一下页面！！！
	     }
	   }]
	  });	
});

function getMemberCredit(){
	var sss='<%=username%>';
	//alert(sss);
    $.ajax({
        url : '<%=templateUrl%>/getMemberCreditValue?userId=<%=username%>',
		type : 'POST',
		contentType : "application/json; charset=utf-8",
		dataType : 'json',
		timeout : 18000,
		cache : true,
		error : erryFunction, //错误执行方法  
		success : succFunction
	//成功执行方法  
	});
	function erryFunction() {
		alert("有错误，请刷新页面");
	}
	function succFunction(data) {
		//未读消息条数
		
		var credit = data.credit;
		$("#remainCredit").html(credit);
		if(credit<10){
		  alert("您的积分不足，请先去积分中心充值！");
		  // 为什么用命名空间不可以 user/user-center
		  window.location.href="<%=templateUrl%>/user/user-center";
		  }
	}
}

$(document).ready(function(){
	if('<%=expe_id%>'!=""){
		getExpeDetail();
	}
});

//获取当前专家信息
function getExpeDetail(){
  $.ajax({
    url : '<%=templateUrl%>/user/getExpeDetailAction?expe_id=<%=expe_id%>',
    type : 'POST',
    contentType: "application/x-www-form-urlencoded; charset=utf-8",
	dataType : 'json',
	timeout : 18000,
	cache : true,
	beforeSend : LoadFunction, //加载执行方法  
	error : erryFunction, //错误执行方法  
	complete : conFunction,
	success : succFunction
			//成功执行方法  
	});
	function LoadFunction() {
	}
	function erryFunction() {
	   alert("error");
	}
	function conFunction() {
		// $(".pager").show();
	}
	function succFunction(data) {
	    $('#username').text(data.username);
	    $('#keshi').text(data.keshi);
	    $('#zhicheng').text(data.zhicheng);
	    $('#yiyuan').text(data.username);
	    $('#good').text(data.good);
	    $('#isCollect').html(data.isCollect);
	    $('#offlineConsult').attr("href",'addofflineConsultForm?expe_id=<%=expe_id%>&expe_name='+data.username);
	    $('#yuyue').attr('href','yuyue?doctorId=<%=expe_id%>&doctorName='+data.username);
   }
}
//收藏
function collectExpert(){
	var  collectData= String($.trim( $('#isCollect').html())); 
	 $.ajax({
         url : '<%=templateUrl%>/CollectAction?collect='+collectData+'&userId=<%=expe_id%>',
         type : 'POST',
         contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		 dataType : 'text',
		 timeout : 18000,
		 cache : true,
    	 error : erryFunction, //错误执行方法  
		 success : succFunction	//成功执行方法  
		});
		function erryFunction() {alert($('#isCollect').html()+"失败，请重试!!");}
		function succFunction(data) {
			var data = String($.trim(data)); 
			if(data=='yes'){
				alert( $('#isCollect').html()+"成功!");
			  if($('#isCollect').html()=="收藏")
				  $('#isCollect').html("取消收藏");
				else
					$('#isCollect').html("收藏");
			}else{
				alert($('#isCollect').html()+"失败，请重试!!");
			}	
		};
	};
</script>
<title>在线咨询--专家</title>
</head>
<body>
	<div style="font-family:'宋体';">
			<img src="${url}/imgs/membercenter/left.png" />&nbsp;&nbsp;<font
				size="6">专家详情
			</font><img
				src="${url}/imgs/membercenter/right.png" />
	</div>
	<div class="doc" style="margin-left: 30%;margin-top: 10%;height: 20%">
		<div class="docpic">
			<img src="${url}/image/headpic.png" />
		</div>
		<div class="docinfo">
			<p id="username"></p>
			<p id="keshi"></p>
			<p id="zhicheng"></p>
			<p id="yiyuan"></p>
			<p id="good"></p>
		</div>
		<div class="clear"></div>
		<br/>
		<div class="action">
			<div class="singleact">
				<img src="${url}/image/icon3.png" /><br />
				<a href="javascript:void(0);" onclick="javascript:payDialog2();">在线咨询</a> 
				<dd></dd>
			</div>
			<div class="singleact">
				<img src="${url}/image/icon4.png" /><br />
				<a target="_blank"	id="offlineConsult" >离线咨询</a>
				<dd></dd>
			</div>
			<div class="singleact">
				<img src="${url}/image/icon1.png" /><br />
				<a href="javascript:void(0);"
					onclick="javascript:collectExpert();" id="isCollect"></a>
				<dd></dd>
			</div>
			<div class="singleact">
				<img src="${url}/image/icon5.png" /><br />
				<a target="_blank" id="yuyue">预约</a>
				<dd></dd>
			</div>
		</div>
		
		  <div id="dialog" style="display: none">
	<div class="user_center_bigtitle" style="text-align:center"> <span>支付窗口</span> 
   <hr></hr>
	</div>
	<div class="my_dis_diray">
		<div class="my_dis_diray_con">
			<div class="mg_info" style="font-family: '宋体';font-size: 18px;">
					<h3 style="text-align:center">您目前还剩积分:<a id="remainCredit" href="javascript:void(0)" style="text-decoration:none">0</a></h3>
					<h3 style="text-align:center">本次咨询需要10个积分</h3>
			</div>
			
			<div style="margin-top:50px;margin-left:400px">
			
			   <input type="button" id="confirm_consult" name="confirm_consult" value="确认咨询"  />
			
			</div>
		
		</div>
	</div>
  </div>
<div id="footer">
<!-- 日志信息 -->
</div>
	</div>
	<a target="_blank"  id="chat" style="display: none"></a>
</body>
</html>
