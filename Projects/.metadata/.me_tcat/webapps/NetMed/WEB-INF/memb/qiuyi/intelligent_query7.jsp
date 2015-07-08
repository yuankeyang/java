<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	String search_str = new String(request.getParameter("search_str")
			.getBytes("iso8859-1"), "utf-8");
	String searchSelect = new String(request.getParameter(
			"searchSelect").getBytes("iso8859-1"), "utf-8");
%>
<jsp:include page="../../include/core_head.jsp"></jsp:include>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="../../include/topbarhead.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${url}/css0623/expert_recommendation.css"/>
<jsp:include page="/WEB-INF/include/head.jsp"></jsp:include>
<script type="text/javascript">
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
</script>
<title>智能咨询结果</title>
</head>

<body>
	<!--顶部背景-->
	<div class="topCon">
		<img class="bg-01" src="imgs/bg-01.jpg"/>
		<span class="headerBg"></span>
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
						<img id="choose1" class="top" src="imgs/nav_braceTop.png"/>
						<span id="choose1">求医</span>
						<img  id="choose1" class="bottom" src="imgs/nav_bracebottom.png"/>
					</div>
				</li>
				<li id="choose2" value="wenyao">
					<div class="con" id="choose2">
						<img id="choose2" class="top" src="imgs/nav_braceTop.png"/>
						<span id="choose2">问药</span>
						<img id="choose2" class="bottom" src="imgs/nav_bracebottom.png"/>
					</div>
				</li>
				<li id="choose3" value="yangsheng">
					<div id="choose3" class="con" >
						<img id="choose3" class="top" src="imgs/nav_braceTop.png"/>
						<span id="choose3">养生</span>
						<img id="choose3" class="bottom" src="imgs/nav_bracebottom.png"/>
					</div>
				</li>
			</ul>
		</div>
		<!--搜索-->
		<form  method="get" id="searchIn">
			<input type="text" name="search_str" id="search_str" value="<%=search_str%>"/>
			<input type="hidden" name = "searchSelect" value="qiuyi" id="searchSelect"/>
			<input type="button" value="搜索"/>
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
		<br/><br/><br/>
		<div id="contleft" align="center">
			<img src="imgs/midiTopPic.png" style="margin:-60px 0 0 40px" />
		</div>
		<!----查询结果---->
		<div id="contright" class="one">
			<div id="summary" style="margin-left:500px">
				<div id="suggesthead"><font size="5"><b>阴虚火旺证结果:</b></font></div>
				<br />
				<p style="font-size:16px;font-weight:bold">根据您目前的情况，颐健通提示您目前存在以下疾病：</p>
				<p style="font-size:16px">中医辨病：不寐</p>
				<p style="font-size:16px">中医辨证：阴虚火旺证</p>
				<p style="font-size:16px">西医诊断：失眠</p>
			</div>
			<br />
			<p style="font-size:16px;font-weight:bold;margin-left:500px">建议:</p>
			<div style="margin-left:550px">
				<p style="font-size:16px">1.调畅情志；避免情绪剧烈波动</p>
				<p style="font-size:16px">2.睡前不做运动，可适当饮用温牛奶；</p>
				<p style="font-size:16px">3.晚饭后避免饮茶；可适当进食</p>
				<p>
					<a target="_blank" href="http://baike.baidu.com/view/4823926.htm">熟地黄炖甲鱼</a>、
					<a target="_blank" href="http://baike.baidu.com/view/71255.htm">沙参玉竹老鸭汤</a>。
				</p>
				<p style="font-size:16px">4.穴位按摩：</p>
				<p style="font-size:16px">（睡前揉按15分钟，以酸胀为宜）</p>
				<p style="font-size:16px">涌泉穴：位于足前部凹陷处2、3趾趾缝纹头端与足跟连线的前三分之一处</p>
				<img src="image/xuewei03.png"> <br />
				<p style="font-size:16px">三阴交穴：在小腿内侧，当足内踝尖上3寸，胫骨内侧缘后方；正坐屈膝成直角取穴。</p>
			    <img src="image/xuewei05.png"> <br />
			</div>
			</div><br/>
			<div id="bottombtn" style="margin-left:500px">
				<h3>
				以上建议您认为是否有帮助？</h3><br/>
				<a
					href="intelligent_query4?search_str=<%=search_str%>&searchSelect=<%=searchSelect%>"><img
					src="image/largebutton_prev.png" height="43"/> </a> <a href="welcome"> <img
					src="image/xlbutton.png" width="159" height="43" /> </a> <a
					href="expert_recommendation?search_str=<%=search_str%>&searchSelect=<%=searchSelect%>">
					<img src="image/xxlbutton.png" height="43" onclick="myreset();" /> </a>
			</div>
		</div>

	<jsp:include page="/WEB-INF/include/login.jsp"></jsp:include>
</body>
</html>