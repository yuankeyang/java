<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String basepath = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	String userId = (String) session.getAttribute("username");
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${url}/css0623/style.css" />
<script type="text/javascript" src="${url}/js/jquery.js"></script>

</head>
<body>
	<div>
		<img src="${url}/imgs/membercenter/left.png" />&nbsp;&nbsp;<font
			size="6"><b>财务管理</b> </font>&nbsp;&nbsp;<img
			src="${url}/imgs/membercenter/right.png" />
	</div>
	<div class="funds-query f14" style="font-family: '宋体' ;">
		<div class="funds-query-title">
			<h3>账户资金查询</h3>
		</div>
		<div class="clearfix p10">
			<span class="fl">现金账户可用余额：<span class="orange fb">0.00</span>元</span>
		</div>



		<div class="myAdvisory-box mt10">
			<ul class="myAdvisory-menu clearfix f14">
				<li class="myAdvisory-menu-active">充值中心
				</li>
				<li>账户明细
				</li>
				<li>账户信息
				</li>
				<li>充值帮助
				</li>
			</ul>
		</div>

		<div class="presentRecharge-present mt10">
			<div class="banks_bar mt10">
				<ul class="clearfix f14" style="width:700px">
					<li style="margin-bottom:10px" class="button_active">网银/信用卡
					</li>
					<li style="margin-bottom:10px">支付宝
					</li>
					<li style="margin-bottom:10px">微信支付
					</li>
					<li style="margin-bottom:10px">线下汇款
					</li>
				</ul>
			</div>
			<div class="clearfix mt10">
				<link href="http://i1.hdfimg.com/userspace/css/payment.5e1c7347.css"
					rel="stylesheet" type="text/css">
				
				<div class="fl f12">
					<div style="margin-left:-10px;">
						<img width="220px;" src="<%=basepath%>/images/unionpay_all.jpg">
					</div><br/>
					<div class="mt10 gray2 mb5">我们支持更多带有银联标志的银行卡</div>
				</div>
				<div class="presentRecharge-way p10 bc" style="margin-right: 0px;">
					<div class="hd f14 fb pb5">使用银联、网银、信用卡在线充值</div>
					<div class="bd p10 f12">
						<form name="recharge" id="recharge" action="pay">
							<div>
								<p>
									充值金额： <label><input type="text" id="price" name="price"
										value="" onkeyup="isChecked()">&nbsp;元</label>
										<a href="javascript:void(0)" onclick="alert('功能正在实现')">充值</a>
										 <br>
									<span id="msg" class="red ml10"></span>
								</p>
							</div>
						</form>
						<div class="recharge-note mt10">
							请输入您要充值的金额，点击充值按钮后将去<span class="orange">银联</span>网站完成支付操作，支付成功后，款项将实时加入到您在颐健通的账户里
						</div>
					</div>
				</div>

			</div>
			<br/>
			<div class="presentRecharge-note clearfix mt10 f12">
				<div><b>请注意：</b></div>
				<div class="fl presentRecharge-note-r fn">
					<p>如果您在支付过程中遇到任何问题，请联系我们：</p>
					<p>客服电话(工作日9:30-19:00)&nbsp;&nbsp;4008-900-120&nbsp;&nbsp;
						客服邮箱&nbsp;&nbsp; dgssadfu@yijiantong.com</p>
				</div>
				<p class="dil w"></p>
				<div class="red bold">

					<!--placebeg [space_content_mgr][onlyone][showtelaccount_tip] -->

					<!--placeend [space_content_mgr][onlyone][showtelaccount_tip] -->
				</div>
				<br>
				<p></p>
			</div>
		</div>
	</div>
</body>
</html>