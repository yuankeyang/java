<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	//String search_str=request.getParameter("search_str");
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

	function check() {
		//alert("csvadbfdsv");
		var Fruit1 = document.getElementsByName("Fruit1");
		var Fruit2 = document.getElementsByName("Fruit2");
		var Fruit3 = document.getElementsByName("Fruit3");
		var Fruit4 = document.getElementsByName("Fruit4");
		var value1="";
		var value2="";
		var value3="";
		var value4="";
		for ( var i = 0; i < Fruit1.length; i++) {
			if (Fruit1[i].checked == true) {
				value1 = Fruit1[i].value;
				break;
			}
		}
		//alert(value1);
		for ( var i = 0; i < Fruit2.length; i++) {
			if (Fruit2[i].checked == true) {
				value2 = Fruit2[i].value;
				break;
			}
		}
		//alert(value2);
		for ( var i = 0; i < Fruit3.length; i++) {
			if (Fruit3[i].checked == true) {
				value3 = Fruit3[i].value;
				break;
			}
		}
		//alert(value3);
		for ( var i = 0; i < Fruit4.length; i++) {
			if (Fruit4[i].checked == true) {
				value4 = Fruit4[i].value;
				break;
			}
		}
		//alert(value4);
		if(((value1=="yes")||(value2=="yes"))&&((value3=="no")&&(value4=="no")))
		{
			window.location.href="intelligent_query5?search_str=<%=search_str%>&searchSelect=<%=searchSelect%>";
		}else if(((value1=="no")&&(value2=="no"))&&((value3=="yes")||(value4=="yes")))
		{
			window.location.href="intelligent_query6?search_str=<%=search_str%>&searchSelect=<%=searchSelect%>";
		}else if(((value1=="yes")||(value2=="yes"))&&((value3=="yes")||(value4=="yes")))
		{
			window.location.href="intelligent_query7?search_str=<%=search_str%>&searchSelect=<%=searchSelect%>";
		}else if(((value1=="no")&&(value2=="no")&&(value3=="no")&&(value4=="no")))
		{
			window.location.href="intelligent_query8?search_str=<%=search_str%>&searchSelect=<%=searchSelect%>";
		} else {
			alert("请将信息填写完整");
		}
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

<title>智能咨询问题</title>

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
		<div class="one">
				<div style="margin-left:550px">
			<div id="tab_mo_1" style="width:600px;">
				<ul id="a13" style="list-style:none">
					<li>13.您夜间睡眠时出汗吗</li>
					<li>
						<form>
							<label> <input name="Fruit1" type="radio" value="no" />无
								</label> <label> <input name="Fruit1"
								type="radio" value="yes"  />偶尔有
							</label> <label> <input name="Fruit1"
								type="radio" value="yes" />有时有 </label> <label>
								<input name="Fruit1" type="radio" value="yes" />经常有 </label>
						</form></li>
				</ul>
				<br/>
				<ul id="a14" style="list-style:none">
					<li>14.您体验手足心热的感觉吗</li>
					<li>
						<form>
							<label> <input name="Fruit2" type="radio" value="no" />无
							</label><label> <input name="Fruit2"
								type="radio" value="yes" />偶尔有 </label><label>
								<input name="Fruit2" type="radio" value="yes" />有时有 </label>
							<label> <input name="Fruit2" type="radio"
								 value="yes" /> 经常有</label>
						</form></li>
				</ul>
				<br/>
				<ul id="a15" style="list-style:none">
					<li>15.您感到口苦吗</li>
					<li>
						<form>
							<label> <input name="Fruit3" type="radio" value="no" />没有
							</label> <label> <input name="Fruit3"
								type="radio" value="yes" />偶尔有 </label><label>
								<input name="Fruit3" type="radio"  value="yes" />有时有</label>
							<label> <input name="Fruit3" type="radio" value="yes" />
								经常有 </label>
						</form></li>
				</ul>
				<br/>
				<ul id="a16" style="list-style:none">
					<li>16.您感到头疼吗</li>
					<li>
						<form>
							<label> <input name="Fruit4" type="radio"
								 value="no" /> 没有 </label><label>
								<input name="Fruit4" type="radio" value="yes" /> 偶尔有</label>
							<label> <input name="Fruit4"
								type="radio" value="yes" /> 有时有 </label><label>
								<input name="Fruit" type="radio" value="yes" /> 经常有 </label>
						</form></li>
				</ul>
				<br/>
				<ul id="a" style="list-style:none">
					<li><b>您是否还有其他基础疾病？（如高血压、糖尿病等）</b>
					</li>
					<li style="margin-top:8px">
						<form>
							<label> <input name="Fruit" type="radio"
								 value="" />无</label><label>
								<input name="Fruit" type="radio" value="" />有</label>
								<input type="text" style="height:25px;width:200px">
						</form>
					</li>
				</ul>

				<br />
				<div id="mysubmit" style="margin-left:10px">
					<a
						href="intelligent_query3?search_str=<%=search_str%>&searchSelect=<%=searchSelect%>"><img
						src="image/largebutton_prev.png" /> </a>
					<a href="javascript:void(0)"><img
						src="image/largebutton_result.png" onclick="check();" /> </a>
				</div>
			</div>
			<div id="tab_mo_2" style="display:none"></div>
			<br /><br />
			<div style="margin-right: 500px;">
				<jsp:include page="/WEB-INF/bottom/footer.jsp"></jsp:include>
			</div>
		</div>
	</div>
	</div>

	<jsp:include page="/WEB-INF/include/login.jsp"></jsp:include>
</body>
</html>
