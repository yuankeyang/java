<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String templateUrl = request.getScheme() + "://"
		+ request.getHeader("host") + request.getContextPath();
request.setAttribute("url", templateUrl);

String search_str = new String(request.getParameter("search_str")
		.getBytes("iso8859-1"), "utf-8");
String searchSelect="yangsheng";
%>
<!DOCTYPE>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>养生品列表</title>
<link href="${url}/css0623/pagination.css" rel="stylesheet">
<link rel="stylesheet" href="${url}/css0623/recommendation.css"/>
<jsp:include page="/WEB-INF/include/head.jsp"></jsp:include>
<script type="text/javascript" src="${url}/js0623/jquery.pagination.js"></script>

<script charset="utf-8" type="text/javascript">



document.onkeyup = function (e) { 
	
	var theEvent = window.event || e; 
	var code = theEvent.keyCode || theEvent.which; 
	if (code == 13) { 
		if($('#search_str').val()=="")//  输入为空不能用null，只能用空字符串！！
		     alert("输入不能为空！！！");
		else
		   $('#btn-search').trigger("click");
	} 
	
};

$(document).ready(function(){
	
	if("<%=search_str%>"!=""&&"<%=searchSelect%>"=="yangsheng"){
	$("#turnBg li").removeClass("addBg");
		$("#turnBg li[id=choose3]").attr("class","addBg");
		$("#searchSelect").val("<%=searchSelect%>");
	}
	
	$("#turnBg li").each(function(){
	$(this).click(function(){
	$(this).siblings(".addBg").removeClass("addBg");
	$(this).attr("class","addBg");
	$("#searchSelect").val($(this).attr("value"));
	});
	});
	
	
	$(".midiTab li").eq(0).addClass("addBg");
	$("#healFood_list").show();
	$(".midiTab li").each(function(){
		$(this).click(function(){
			$(this).siblings(".addBg").removeClass("addBg");
			$(this).attr("class","addBg");
			$("#content .midiCon").hide();
			$("#content .midiCon").eq($(this).index()).show();
		});
	});
	
	if("<%=search_str%>"!=""){
		bind(0);
	}
	
 
function pageselectCallback(page_id,jq){
   bind(page_id);
};

function bind(pageIndex){
  var total = 0;
  
  $.ajax({
    url : '<%=templateUrl%>/SearchRegimenAction?pageIndex='+(pageIndex+1),
    type : 'POST',
    data:"search_str="+$('#search_str').val(),
	contentType: "application/x-www-form-urlencoded; charset=utf-8", 
	dataType : 'json',
	timeout : 20000,
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
	    // alert("error");
	}
	function conFunction() {
		// $(".pager").show();
	}
function succFunction(data) {
foodtotal = data.typeNumb.Nfood;
$("#healFood_list").html("");
$.each(data.healFoodArray, function(index) {
var picture=data.healFoodArray[index].Picture;
var s1="<li><img src=\"<%=templateUrl%>/"+ picture
				+ "\" /><div class=\"midiMess\"><p class=\"midiName\">"
												+ data.healFoodArray[index].Name
												+ "</p>";
										var s2 = "<p class=\"midiText\">"
												+ data.healFoodArray[index].Function
												+ "</p></div>";
										var st1 ="<span class=\"midiInter\"></span>";
										var s3 = "<div class=\"midiUse\"><p class=\"midiUseName\">[ 用法用量 ]</p>"
												+"<p class=\"midiUseText\">"
												+ data.healFoodArray[index].Usage
												+ "</p></div>";
										var s4 = "<div class=\"midiUse\"><p class=\"midiUseName\">[ 注意事项 ]</p>"
												+"<p class=\"midiUseText\">"
												+ data.healFoodArray[index].Precaution
												+ "</p></div>";
										var s5 = "<div class=\"midiMore\"><div class=\"midiMoreText\"><a href='RegimenDetail?regiId="
												+ data.healFoodArray[index].regiId
												+ "&search_strD="
												+ $('#search_str').val()
												+ "'><span class=\"left\">查看</span><span class=\"right\">详情</span></a></div></div></li>";
										$("#healFood_list").html(
										$("#healFood_list").html()+ s1+s2+st1+s3+st1+s4+st1+s5);
									});
$(".megas512").hide();
					$("#Pagination1").pagination(foodtotal, { //recordCount在后台定义的一个公有变量，通过从数据库查询记录进行赋值，返回记录的总数
						recordCount : 30,
						callback : pageselectCallback, //点击分页时，调用的回调函数  
						prev_text : '« 上一页', //显示上一页按钮的文本  
						next_text : '下一页 »', //显示下一页按钮的文本  
						items_per_page : 4, //每页显示的项数  
						num_display_entries : 10, //分页插件中间显示的按钮数目  
						current_page : pageIndex, //当前页索引  
						num_edge_entries : 2
					//分页插件左右两边显示的按钮数目  
					}); //分页功能结束
									
								
comptotal = data.typeNumb.Ncomp;
$("#regiComp_list").html("");
$.each(data.regiCompArray, function(index) {
    var picture=data.regiCompArray[index].Picture;
    var s1="<li><img src=\"<%=templateUrl%>/"+ picture
	+ "\" /><div class=\"midiMess\"><p class=\"midiName\">"
									+ data.regiCompArray[index].Name
									+ "</p>";
							var s2 = "<p class=\"midiText\">"
									+ data.regiCompArray[index].Function
									+ "</p></div>";
							var st1 ="<span class=\"midiInter\"></span>";
							var s3 = "<div class=\"midiUse\"><p class=\"midiUseName\">[ 用法用量 ]</p>"
									+"<p class=\"midiUseText\">"
									+ data.regiCompArray[index].Usage
									+ "</p></div>";
							var s4 = "<div class=\"midiUse\"><p class=\"midiUseName\">[ 注意事项 ]</p>"
									+"<p class=\"midiUseText\">"
									+ data.regiCompArray[index].Precaution
									+ "</p></div>";
							var s5 = "<div class=\"midiMore\"><div class=\"midiMoreText\"><a href='RegimenDetail?regiId="
									+ data.regiCompArray[index].regiId
									+ "&search_strD="
									+ $('#search_str').val()
									+ "'><span class=\"left\">查看</span><span class=\"right\">详情</span></a></div></div></li>";
										$("#regiComp_list").html(
										$("#regiComp_list").html()+ s1+s2+st1+s3+st1+s4+st1+s5);
									});
$(".megas512").hide();
					$("#Pagination2").pagination(comptotal, { //recordCount在后台定义的一个公有变量，通过从数据库查询记录进行赋值，返回记录的总数
						recordCount : 30,
						callback : pageselectCallback, //点击分页时，调用的回调函数  
						prev_text : '« 上一页', //显示上一页按钮的文本  
						next_text : '下一页 »', //显示下一页按钮的文本  
						items_per_page : 4, //每页显示的项数  
						num_display_entries : 14, //分页插件中间显示的按钮数目  
						current_page : pageIndex, //当前页索引  
						num_edge_entries : 2
					//分页插件左右两边显示的按钮数目  
					}); //分页功能结束
bathtotal = data.typeNumb.Nbath;
$("#mediBath_list").html("");
$.each(data.mediBathArray, function(index) {
var picture=data.mediBathArray[index].Picture;
var s1="<li><img src=\"<%=templateUrl%>/"+ picture
+ "\" /><div class=\"midiMess\"><p class=\"midiName\">"
								+ data.mediBathArray[index].Name
								+ "</p>";
						var s2 = "<p class=\"midiText\">"
								+ data.mediBathArray[index].Function
								+ "</p></div>";
						var st1 ="<span class=\"midiInter\"></span>";
						var s3 = "<div class=\"midiUse\"><p class=\"midiUseName\">[ 用法用量 ]</p>"
								+"<p class=\"midiUseText\">"
								+ data.mediBathArray[index].Usage
								+ "</p></div>";
						var s4 = "<div class=\"midiUse\"><p class=\"midiUseName\">[ 注意事项 ]</p>"
								+"<p class=\"midiUseText\">"
								+ data.mediBathArray[index].Precaution
								+ "</p></div>";
						var s5 = "<div class=\"midiMore\"><div class=\"midiMoreText\"><a href='RegimenDetail?regiId="
								+ data.mediBathArray[index].regiId
								+ "&search_strD="
								+ $('#search_str').val()
								+ "'><span class=\"left\">查看</span><span class=\"right\">详情</span></a></div></div></li>";
									$("#mediBath_list").html(
									$("#mediBath_list").html()+ s1+s2+st1+s3+st1+s4+st1+s5);
								});
$(".megas512").hide();
				$("#Pagination3").pagination(bathtotal, { //recordCount在后台定义的一个公有变量，通过从数据库查询记录进行赋值，返回记录的总数
					recordCount : 30,
					callback : pageselectCallback, //点击分页时，调用的回调函数  
					prev_text : '« 上一页', //显示上一页按钮的文本  
					next_text : '下一页 »', //显示下一页按钮的文本  
					items_per_page : 4, //每页显示的项数  
					num_display_entries : 14, //分页插件中间显示的按钮数目  
					current_page : pageIndex, //当前页索引  
					num_edge_entries : 2
				//分页插件左右两边显示的按钮数目  
				}); //分页功能结束
				
									
		prestotal = data.typeNumb.Npres;
		 $("#massPres_list").html("");
		 $.each(data.massPresArray, function(index) {
			     var picture=data.massPresArray[index].Picture;
			     var s1="<li><img src=\"<%=templateUrl%>/"+ picture
					+ "\" /><div class=\"midiMess\"><p class=\"midiName\">"
													+ data.massPresArray[index].Name
													+ "</p>";
											var s2 = "<p class=\"midiText\">"
													+ data.massPresArray[index].Function
													+ "</p></div>";
											var st1 ="<span class=\"midiInter\"></span>";
											var s3 = "<div class=\"midiUse\"><p class=\"midiUseName\">[ 操作方法 ]</p>"
													+"<p class=\"midiUseText\">"
													+ data.massPresArray[index].Usage
													+ "</p></div>";
											var s4 = "<div class=\"midiUse\"><p class=\"midiUseName\">[ 注意事项 ]</p>"
													+"<p class=\"midiUseText\">"
													+ data.massPresArray[index].Precaution
													+ "</p></div>";
											var s5 = "<div class=\"midiMore\"><div class=\"midiMoreText\"><a href='RegimenDetail?regiId="
													+ data.massPresArray[index].regiId
													+ "&search_strD="
													+ $('#search_str').val()
													+ "'><span class=\"left\">查看</span><span class=\"right\">详情</span></a></div></div></li>";
													$("#massPres_list").html(
													$("#massPres_list").html()+s1+s2+st1+s3+st1+s4+st1+s5);
												});
		  $(".megas512").hide();
								$("#Pagination4").pagination(prestotal, { //recordCount在后台定义的一个公有变量，通过从数据库查询记录进行赋值，返回记录的总数
									recordCount : 30,
									callback : pageselectCallback, //点击分页时，调用的回调函数  
									prev_text : '« 上一页', //显示上一页按钮的文本  
									next_text : '下一页 »', //显示下一页按钮的文本  
									items_per_page : 4, //每页显示的项数  
									num_display_entries : 14, //分页插件中间显示的按钮数目  
									current_page : pageIndex, //当前页索引  
									num_edge_entries : 2
								//分页插件左右两边显示的按钮数目  
								}); //分页功能结束
								
equitotal = data.typeNumb.Nequi;
 $("#mediEqui_list").html("");
 $.each(data.mediEquiArray, function(index) {
	     var picture=data.mediEquiArray[index].Picture;
	     var s1="<li><img src=\"<%=templateUrl%>/"+ picture
	+ "\" /><div class=\"midiMess\"><p class=\"midiName\">"
									+ data.mediEquiArray[index].Name
									+ "</p>";
							var s2 = "<p class=\"midiText\">"
									+ data.mediEquiArray[index].Apply
									+ "</p></div>";
							var st1 ="<span class=\"midiInter\"></span>";
							var s3 = "<div class=\"midiUse\"><p class=\"midiUseName\">[ 适用于 ]</p>"
									+"<p class=\"midiUseText\">"
									+ data.mediEquiArray[index].Apply
									+ "</p></div>";
							var s4 = "<div class=\"midiUse\"><p class=\"midiUseName\">[ 注意事项 ]</p>"
									+"<p class=\"midiUseText\">"
									+ data.mediEquiArray[index].Precaution
									+ "</p></div>";
							var s5 = "<div class=\"midiMore\"><div class=\"midiMoreText\"><a href='RegimenDetail?regiId="
									+ data.mediEquiArray[index].regiId
									+ "&search_strD="
									+ $('#search_str').val()
									+ "'><span class=\"left\">查看</span><span class=\"right\">详情</span></a></div></div></li>";
									$("#mediEqui_list").html(
									$("#mediEqui_list").html()+s1+s2+st1+s3+st1+s4+st1+s5);
								});

				$("#Pagination5").pagination(equitotal, { //recordCount在后台定义的一个公有变量，通过从数据库查询记录进行赋值，返回记录的总数
					recordCount : 30,
					callback : pageselectCallback, //点击分页时，调用的回调函数  
					prev_text : '« 上一页', //显示上一页按钮的文本  
					next_text : '下一页 »', //显示下一页按钮的文本  
					items_per_page : 3, //每页显示的项数  
					num_display_entries : 14, //分页插件中间显示的按钮数目  
					current_page : pageIndex, //当前页索引  
					num_edge_entries : 2
				//分页插件左右两边显示的按钮数目  
				}); //分页功能结束
				$("#Pagination5").show();
							} //  function succFunction(data)  结束

						} //  function bind(pageIndex)  结束

					});
</script>

<style type="text/css">
#logintab {
	margin-top: 20px;
}

#logintab li a {
	outline: none;
	text-decoration: none
}
</style>

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
					<div id="choose3" class="con">
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
			<input type="hidden" name = "searchSelect" value="yangsheng" id="searchSelect"/>
			<input type="button" value="搜索"/>
		</form>
	</div>
	<!--选药-->
	<div class="chooseMidi">
		<ul class="midiTab">
			<li>
				<div class="con">
					<span class="left">保健</span>
					<span class="right">食品</span>
				</div>
			</li>
			<li>
				<div class="con">
					<span class="left">养生</span>
					<span class="right">复方</span>
				</div>
			</li>
			<li>
				<div class="con">
					<span class="left">中药</span>
					<span class="right">浴方</span>
				</div>
			</li>
			<li>
				<div class="con">
					<span class="left">按摩</span>
					<span class="right">方</span>
				</div>
			</li>
			<li>
				<div class="con">
					<span class="left">医疗</span>
					<span class="right">器械</span>
				</div>
			</li>
		</ul>
		
		
		<span class="midiTopPic"></span>
		<div id="content">
		<ul id="healFood_list" class="midiCon">
		</ul>
		<div id="Pagination1" class="megas512"></div>
		<ul id="regiComp_list" class="midiCon">
		</ul>
		<div id="Pagination2" class="megas512"></div>
		<ul id="mediBath_list" class="midiCon">
		</ul>
		<div id="Pagination3" class="megas512"></div>
		<ul id="massPres_list" class="midiCon">
		</ul>
		<div id="Pagination4" class="megas512"></div>
		<ul id="mediEqui_list" class="midiCon">
		</ul>
		<div id="Pagination5" class="megas512"></div>
		</div>
	</div>
<jsp:include page="/WEB-INF/include/login.jsp"></jsp:include>
</body>
</html>
