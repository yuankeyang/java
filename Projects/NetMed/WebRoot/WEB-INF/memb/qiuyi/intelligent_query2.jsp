<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	String search_str = new String(request.getParameter("search_str")
			.getBytes("iso8859-1"), "utf-8");
	String searchSelect = new String(request.getParameter(
			"searchSelect").getBytes("iso8859-1"), "utf-8");
	String username = (String) session.getAttribute("username");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${url}/css0623/expert_recommendation.css" />
<jsp:include page="/WEB-INF/include/head.jsp"></jsp:include>
	
<script charset="utf-8" type="text/javascript">
$(document).ready(function(){
	$("#turnBg li[id=choose1]").attr("class","addBg");
	$("#searchSelect").val("<%=searchSelect%>");
		
	$("#turnBg li").each(function(){
		$(this).click(function(){
		$(this).siblings(".addBg").removeClass("addBg");
		$(this).attr("class","addBg");
		$("#searchSelect").val($(this).attr("value"));
		});
		});

	$("#searchIn").find("input[type=button]").click(function(){
		var item=$("#turnBg .addBg").attr("value");
		if(item=="qiuyi"){
			$('#searchIn').attr('action','MediKnow');
		}else if(item=="wenyao"){
			$('#searchIn').attr('action','SearchMedicine');
		}else{
			$('#searchIn').attr('action','SearchRegimen');
		}
		if($('#search_str').val()=='')
			alert('请输入搜索词条！');
		else{
		$('#searchIn').submit();}
	});
	
	$("#expert_recommendBtn").click(function(){
	
		$("#expert_recommend").attr("href","expert_recommendation?search_str=" + $('#search_str').val()+"&searchSelect="+$('#searchSelect').val());
		document.getElementById("expert_recommend").click();
      });
	$("#intelligenBtn").click(function(){
		
		$("#intelligen").attr("href","intelligent_query?search_str=" + $('#search_str').val()+"&searchSelect="+$('#searchSelect').val());
		document.getElementById("intelligen").click();
      });
});

	
	
	function myreset() {
		$("#sleepQuestion")[0].reset();
	}
</script>

<style type="text/css">
.input_text {
	text-align: center;
	width: 80px;
	border-color: #000000;
	border-style: solid;
	border-top-width: 0px;
	border-right-width: 0px;
	border-bottom-width: 1px;
	border-left-width: 0px;
}
</style>

<title>智能咨询</title>
<style type="text/css">
</style>
</head>
<body>
	<!--顶部背景-->
	<div class="topCon">
		<img class="bg-01" src="imgs/bg-01.jpg" /> <span class="headerBg"></span>
		<!--内容-->
		<div class="indexCon">
			<a href="welcome"><img class="logo" src="imgs/logo.png"/></a>
			<p class="callCen">
			健康咨询平台
			</p>
			<ul>
				<jsp:include page="/WEB-INF/include/topbar.jsp"></jsp:include>
			</ul>
		</div>
		<!--切换-->
		<div class="indexFind">
			<ul id="turnBg">
				<li id="choose1" value="qiuyi">
					<div id="choose1" class="con">
						<img id="choose1" class="top" src="imgs/nav_braceTop.png" /> <span
							id="choose1">求医</span> <img id="choose1" class="bottom"
							src="imgs/nav_bracebottom.png" />
					</div></li>
				<li id="choose2" value="wenyao">
					<div class="con" id="choose2">
						<img id="choose2" class="top" src="imgs/nav_braceTop.png" /> <span
							id="choose2">问药</span> <img id="choose2" class="bottom"
							src="imgs/nav_bracebottom.png" />
					</div></li>
				<li id="choose3" value="yangsheng">
					<div id="choose3" class="con">
						<img id="choose3" class="top" src="imgs/nav_braceTop.png" /> <span
							id="choose3">养生</span> <img id="choose3" class="bottom"
							src="imgs/nav_bracebottom.png" />
					</div></li>
			</ul>
		</div>
		<!--搜索-->
		<form method="get" id="searchIn">
			<input type="text" name="search_str" id="search_str" value="<%=search_str%>" /> 
			<input type="hidden" name="searchSelect" value="qiuyi" id="searchSelect" /> 
			<input type="button" value="搜索" />
		</form>
	</div>

	<!--选药-->
	<div class="chooseMidi">
		<ul class="midiTab">
			<li id="intelligenBtn" class="addBg">
				<div class="con">
					<span class="left">智能</span>
					<span class="right">咨询</span>
				</div>
				<a id="intelligen" style="display: none"></a>
				<a id="expert_recommend" style="display: none"></a>
			</li>
			<li id="expert_recommendBtn" >
				<div class="con">
				  <span class="left">专家</span>
				  <span class="right">推荐</span>
				</div>
			</li>
		</ul>
		<br />
		<br />
		<br />
		<div id="contleft" align="center">
			<img src="imgs/midiTopPic.png" style="margin:-60px 0 0 40px" />
		</div>
		<div class="one">
			<div style="margin-left:500px" >
				<div id="tab_mo_1" style="width:600px;">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<ul>
						<p>
							<b>对下列问题请选择1个最适合您的答案:</b>
						</p>
						<br />
						<p style="margin-left:80px">&nbsp;&nbsp;&nbsp;&nbsp;5.近1个月 ，因下列情况影响睡眠而烦恼：</p><br/>
						<ul style="list-style:none;margin-left:100px">
							<li>
								<ul id="a01" style="list-style:none">
									<li>a. 入睡困难（30分钟内不能入睡）</li>
									<li>
										<form>
											<label> <input name="Fruit" type="radio" value="" />
												无 </label> <label> <input name="Fruit" type="radio" value=""/> &lt;1次/周 </label> <label> <input
												name="Fruit" type="radio" value="" /> 1-2次/周 </label> <label>
												<input name="Fruit" type="radio" value="" /> &ge;1次/周 </label>
										</form></li>
								</ul></li>
								<br/>
							<li>
								<ul id="a02" style="list-style:none">
									<li>b. 夜间易醒或早醒</li>
									<li>
										<form>
											<label> <input name="Fruit" type="radio" value="" />
												无 </label> <label> <input name="Fruit" type="radio" value=""/> &lt;1次/周 </label> <label> <input
												name="Fruit" type="radio" value="" /> 1-2次/周 </label> <label>
												<input name="Fruit" type="radio" value="" /> &ge;1次/周 </label>
										</form></li>
								</ul></li><br/>
							<li>
								<ul id="a03" style="list-style:none">
									<li>C.夜间去厕所</li>
									<li>
										<form>
											<label> <input name="Fruit" type="radio" value="" />
												无 </label> <label> <input name="Fruit" type="radio" value=""/> &lt;1次/周 </label> <label> <input
												name="Fruit" type="radio" value="" /> 1-2次/周 </label> <label>
												<input name="Fruit" type="radio" value="" /> &ge;1次/周 </label>
										</form></li>
								</ul></li><br/>
							<li>
								<ul id="a04" style="list-style:none">
									<li>d. 呼吸不畅</li>
									<li>
										<form>
											<label> <input name="Fruit" type="radio" value="" />
												无 </label> <label> <input name="Fruit" type="radio" value=""/> &lt;1次/周 </label> <label> <input
												name="Fruit" type="radio" value="" /> 1-2次/周 </label> <label>
												<input name="Fruit" type="radio" value="" /> &ge;1次/周 </label>
										</form></li>
								</ul></li><br/>
							<li>
								<ul id="a05" style="list-style:none">
									<li>e. 咳嗽或鼾声高</li>
									<li>
										<form>
											<label> <input name="Fruit" type="radio" value="" />
												无 </label> <label> <input name="Fruit" type="radio" value=""/> &lt;1次/周 </label> <label> <input
												name="Fruit" type="radio" value="" /> 1-2次/周 </label> <label>
												<input name="Fruit" type="radio" value="" /> &ge;1次/周 </label>
										</form></li>
								</ul></li><br/>
							<li>
								<ul id="a06" style="list-style:none">
									<li>f. 感觉冷</li>
									<li>
										<form>
											<label> <input name="Fruit" type="radio" value="" />
												无 </label> <label> <input name="Fruit" type="radio" value=""/> &lt;1次/周 </label> <label> <input
												name="Fruit" type="radio" value="" /> 1-2次/周 </label> <label>
												<input name="Fruit" type="radio" value="" /> &ge;1次/周 </label>
										</form></li>
								</ul></li><br/>
							<li>
								<ul id="a07" style="list-style:none">
									<li>g. 感觉热</li>
									<li>
										<form>
											<label> <input name="Fruit" type="radio" value="" />
												无 </label> <label> <input name="Fruit" type="radio" value=""
												 /> &lt;1次/周 </label> <label> <input
												name="Fruit" type="radio" value="" /> 1-2次/周 </label> <label>
												<input name="Fruit" type="radio" value="" /> &ge;1次/周 </label>
										</form></li>
								</ul></li><br/>
							<li>
								<ul id="a08" style="list-style:none">
									<li>h. 做恶梦</li>
									<li>
										<form>
											<label> <input name="Fruit" type="radio" value="" />
												无 </label> <label> <input name="Fruit" type="radio" value=""
												 /> &lt;1次/周 </label> <label> <input
												name="Fruit" type="radio" value="" /> 1-2次/周 </label> <label>
												<input name="Fruit" type="radio" value="" /> &ge;1次/周 </label>
										</form></li>
								</ul></li><br/>
							<li>
								<ul id="a09" style="list-style:none">
									<li>i. 疼痛不适</li>
									<li>
										<form>
											<label> <input name="Fruit" type="radio" value="" />
												无 </label> <label> <input name="Fruit" type="radio" value=""
												/> &lt;1次/周 </label> <label> <input
												name="Fruit" type="radio" value="" /> 1-2次/周 </label> <label>
												<input name="Fruit" type="radio" value="" /> &ge;1次/周 </label>
										</form></li>
								</ul></li><br/>
							<li>
								<ul id="a10" style="list-style:none">
									<li>j. 其它影响睡眠的事情</li>
									<li>
										<form>
											<label> <input name="Fruit" type="radio" value="" />
												无 </label> <label> <input name="Fruit" type="radio" value=""
												 /> &lt;1次/周 </label> <label> <input
												name="Fruit" type="radio" value="" /> 1-2次/周 </label> <label>
												<input name="Fruit" type="radio" value="" /> &ge;1次/周 </label>
										</form></li>
								</ul>
							</li>
						</ul>
					</ul>
					<br/>
					<div style="margin-left:150px">
						
						</a><a
							href="intelligent_query?search_str=<%=search_str%>&searchSelect=<%=searchSelect%>"><img
							src="image/largebutton_prev.png" /> </a></a><a
							href="intelligent_query3?search_str=<%=search_str%>&searchSelect=<%=searchSelect%>"><img
							src="image/largebutton_next.png" /> </a>

					</div><br/>
					<div style="margin-right: 120px;">
						<jsp:include page="/WEB-INF/bottom/footer.jsp"></jsp:include>
					</div>
				</div>
				<div id="tab_mo_2" style="display:none;"></div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/include/login.jsp"></jsp:include>
</body>

</html>