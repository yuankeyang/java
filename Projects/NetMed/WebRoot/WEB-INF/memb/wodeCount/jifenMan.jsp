<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
.table_green {
	border-collapse: collapse;
}

<%
		String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
%>
.table_green td {
	padding: 5px;
	border-bottom: 1px #e6e6e6 dashed;
}

.table.dataintable {
	border: 1px solid #888888;
	border-collapse: collapse;
	margin: 5px 40px;
	width: 60%;
}

.table.dataintable th {
	background-color: #CCCCCC;
	padding: 2px 2px 2px 2px;
	vertical-align: baseline;
}

.div.h3 {
	padding: 2px 2px 2px 10px;
	font-weight: bold;
}

div.datadiv {
	padding: 2px 2px 2px 20px;
}

div.grouplistdiv {
	padding: 2px 2px 2px 20px;
	margin: 5px 20px;
}

<!--
a:link {
text-decoration: none;
}
a:visited {
text-decoration: none;
}
a:hover {
text-decoration: none;
}
a:active {
text-decoration: none;
}
--> 
</style>
<link rel="stylesheet" type="text/css" href="${url}/css0623/style.css" />
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	getPayInfo();
});

function getPayInfo(){
	$.ajax({
        url : '<%=templateUrl%>/user/getPayInfo',
        type : 'POST',
        contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		dataType : 'json',
		timeout : 18000,
		cache : true,
		error : erryFunction, //错误执行方法  
		success : succFunction	//成功执行方法  
		});
		function erryFunction() {alert("请刷新页面!!");}
		function succFunction(data) {
			$('#credit').html(data.credit);
			$('#money').html(data.money);
	};
}

function doExchange(){
    $.ajax({
        url : '<%=templateUrl%>/jiFenExchange',
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
		//alert("有错误，请刷新页面");
	}
	function succFunction(data) {
		//未读消息条数
		  // 为什么用命名空间不可以 user/user-center
		  window.location.href="<%=templateUrl%>/user/user-center";
		}
	}
</script>
<body>
<div><img src="${url}/imgs/left.png"/>&nbsp;<span style="font-family:'仿宋';font-size:33px;color:#c9b28b;">积分管理</span>
		&nbsp;<img src="${url}/imgs/right.png"/></div>
	<br/>
	<div class="scenterMain" style="min-height: 0px;" style="font-family: '宋体' ;font-size: 18px;">
		<link href="http://i1.hdfimg.com/400/css/n_business.css"
			rel="stylesheet" type="text/css">
		<div class="funds-query f14">
			<div class="funds-query-title" style="font-family: '宋体' ;font-size: 18px;">
				<h3>积分账户管理</h3>
			</div>
			<div class="p10" style="font-family: '宋体' ;font-size: 18px;">
				<p>
					<span>积分账户余额：&nbsp;<a href="javascript:void(0)" id="credit" style="color: black;"></a>&nbsp;积分</span>
					<span style="position:relative;left:150px;"> 咨询点余额: <span
						class="orange fb" style="left: 20px;">0</span>点 <a href="http://www.haodf.com/helper/score.htm#info_ask_point"
						target="_blank" >什么是咨询点？</a> </span>
				</p>
			</div>
			<div class="myAdvisory-box mt10 pr" style="font-family: '宋体' ;font-size: 18px;">
				<ul class="myAdvisory-menu clearfix f14">
					<li class="myAdvisory-menu-active">兑换中心
					</li>
					<li>积分明细
					</li>
				</ul>
				<%--<a href="/index/myscore?i2m=1" class="pa unl pointsMenu-corner gray2">剩余积分兑换到现金账户</a>--%>
			</div>
			<div class="p15" style="font-family: '宋体' ;font-size: 18px;">
				<div>
					<h3>现金账户兑换到积分账户:</h3>
					<ul>
						<form id="submit" method="post" action="#">
							<li class="mt5">您的现金账户余额为:&nbsp;<a href="javascript:void(0)"
								id="money" style="color: black;"></a>&nbsp;元（现金与积分的兑换比例为：5元=10积分）</li>
							<li class="mt5">请填写您要兑换的金额：<input type="text" id="money"
								name="money" class="recharge-input" onkeyup="changeNotice()"
								onchange="changeNotice()">元</li>
						</form>
					</ul>
						<p class="mt10 mb10">
							<input id="content" type="checkbox" checked>同意颐健通在线积分服务条款
						</p>
						<a href="javascript:void(0)" onclick="alert('功能正在实现')">确认兑换</a>
				</div>
				<div class="mt20">
					<h3 class="mb5">积分的获取以及常见问题：</h3>
					<ul>
						<li class="clearfix mb5"><span class="fl">1.充值到现金账户，在下面的兑换中心，进行兑换；</span>
							<a href="javascript:void(0)" onclick="alert('功能正在实现')"> <span
								class="phonePop-btn-l"><span
									class="phonePop-btn-r phonePop-blue">去充值</span> </span> </a></li>
						<li class="clearfix mb5"><span class="fl">2.了解更多积分规则。</span>
						<a href="javascript:void(0)" onclick="alert('功能正在实现')">
							<span
								class="phonePop-btn-l"><span
									class="phonePop-btn-r phonePop-blue">去查看</span> </span></a></li>
					</ul>
				</div>
			</div>
		</div>
		<div style="display:none;" id="footer"></div>
	</div>
</body>
<script type="text/javascript">
	var isSubmitting = false;
	function doSubmit() {
		if (!isSubmitting) {
			if (changeNotice()) {
				if ($('#content').attr('checked')) {
					isSubmitting = true;
					$('#submit').submit();
					return false;
				} else {
					$('#message').html('请参看颐健通在线积分服务条款，勾选同意后才能提交');
					isSubmitting = false;
					return false;
				}
			}
		}
	}
	function changeNotice() {
		var m = $('#from').val();
		var o = $('#overage').html();
		var i = 0;
		var io = $('#to');
		var ms = $('#message');
		if (/^[0-9]*[1-9][0-9]*$/.test(m)) {
			if (o - m >= 0) {
				i = m * 100;
				io.html(i);
				ms.html('&nbsp;');
				return true;
			} else {
				io.html(i);
				ms.html('填写的金额超过了现金余额能兑换的最大额度，请重新填写');
				return false;
			}
		} else if (m !== '') {
			io.html(i);
			ms.html('填写的内容不是数字 请填写正整数');
			return false;
		} else {
			io.html(i);
			ms.html('请您填写要兑换的金额');
			return false;
		}
	}
</script>