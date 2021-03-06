<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%

	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);

	String search_str = new String(request.getParameter("search_str")
			.getBytes("iso8859-1"), "utf-8");
	String searchSelect ="wenyao";
%>
<!DOCTYPE>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>药物列表</title>
<link rel="stylesheet" href="${url}/css0623/recommendation.css"/>
<link href="${url}/css0623/pagination.css" rel="stylesheet">
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
	
if("<%=search_str%>"!=""&&"<%=searchSelect%>"=="wenyao"){
	$("#turnBg li").removeClass("addBg");
	$("#turnBg li[id=choose2]").attr("class","addBg");
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
	$("#westmedi_list").show();
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
   //alert(page_id);
   bind(page_id);
};
function bind(pageIndex){
  var total = 0;
  
  $.ajax({
    url : '<%=templateUrl%>/SearchMedicineAction?pageIndex='+(pageIndex+1),
    type : 'POST',
    data:"search_str="+$('#search_str').val(),
	contentType: "application/x-www-form-urlencoded; charset=utf-8", 
	dataType : 'json',
	timeout : 20000,
	cache : true,
	beforeSend : LoadFunction, //加载执行方法  
	error : erryFunction, //错误执行方法  
	complete : conFunction,
	success : succFunction,
			//成功执行方法  
	});
	function LoadFunction() {
	}
	function erryFunction() {
	    // alert("正在查询，请耐心等待");
	}
	function conFunction() {
	}
	
	
	
	function succFunction(data) {
	   
		westMeditotal = data.number.NwestMedi;
       // alert(data.number.Nprescrip);
	  // 显示药物列表
          $("#westmedi_list").html("");
		  $.each(data.westMediArray, function(index) {
			     var picture=data.westMediArray[index].Picture;
				 var s1="<li><img src=\"<%=templateUrl%>/"+ picture
								+ "\" /><div class=\"midiMess\"><p class=\"midiName\">"
																+ data.westMediArray[index].Name
																+ "</p>";
														var s2 = "<p class=\"midiText\">"
																+ data.westMediArray[index].Function
																+ "</p></div>";
														var st1 ="<span class=\"midiInter\"></span>";
														var s3 = "<div class=\"midiUse\"><p class=\"midiUseName\">[ 用法用量 ]</p>"
																+"<p class=\"midiUseText\">"
																+ data.westMediArray[index].Usage
																+ "</p></div>";
														var s4 = "<div class=\"midiUse\"><p class=\"midiUseName\">[ 禁忌症]</p>"
																+"<p class=\"midiUseText\">"
																+ data.westMediArray[index].Contraindication
																+ "</p></div>";
														var s5 = "<div class=\"midiMore\"><div class=\"midiMoreText\"><a href='MedicineDetail?mediId="
																+ data.westMediArray[index].MediId
																+ "&search_strD="
																+ $('#search_str').val()
																+ "'><span class=\"left\">查看</span><span class=\"right\">详情</span></a></div></div></li>";
														$("#westmedi_list").html(
														$("#westmedi_list").html()+ s1+s2+st1+s3+st1+s4+st1+s5);
													});
$(".megas512").hide();
									$("#Pagination1").pagination(westMeditotal, { //recordCount在后台定义的一个公有变量，通过从数据库查询记录进行赋值，返回记录的总数
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
									
								//}
			prescriptotal = data.number.Nprescrip;
			//方剂
			 $("#prescrip_list").html("");
			 $.each(data.prescripArray, function(index) {
			     var picture=data.prescripArray[index].Picture;
			     var s1="<li><img src=\"<%=templateUrl%>/"+ picture
					+ "\" /><div class=\"midiMess\"><p class=\"midiName\">"
													+ data.prescripArray[index].Name
													+ "</p>";
											var s2 = "<p class=\"midiText\">"
													+ data.prescripArray[index].Function
													+ "</p></div>";
											var st1 ="<span class=\"midiInter\"></span>";
											var s3 = "<div class=\"midiUse\"><p class=\"midiUseName\">[ 主治 ]</p>"
													+"<p class=\"midiUseText\">"
													+ data.prescripArray[index].MajorFunction
													+ "</p></div>";
											var s4 = "<div class=\"midiUse\"><p class=\"midiUseName\">[ 注意事项 ]</p>"
													+"<p class=\"midiUseText\">"
													+ data.prescripArray[index].Precaution
													+ "</p></div>";
											var s5 = "<div class=\"midiMore\"><div class=\"midiMoreText\"><a href='MedicineDetail?mediId="
													+ data.prescripArray[index].MediId
													+ "&search_strD="
													+ $('#search_str').val()
													+ "'><span class=\"left\">查看</span><span class=\"right\">详情</span></a></div></div></li>";
														$("#prescrip_list").html(
														$("#prescrip_list").html()+ s1+s2+st1+s3+st1+s4+st1+s5);
													});
			 $(".megas512").hide();
									$("#Pagination2").pagination(prescriptotal, { //recordCount在后台定义的一个公有变量，通过从数据库查询记录进行赋值，返回记录的总数
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
			mediMatetotal = data.number.NmediMate;
			
									//中药材
			 $("#medimate_list").html("");
			 $.each(data.MediMateArray, function(index) {
			     var picture=data.MediMateArray[index].Picture;
			     var s1="<li><img src=\"<%=templateUrl%>/"+ picture
					+ "\" /><div class=\"midiMess\"><p class=\"midiName\">"
													+ data.MediMateArray[index].Name
													+ "</p>";
											var s2 = "<p class=\"midiText\">"
													+ data.MediMateArray[index].Function
													+ "</p></div>";
											var st1 ="<span class=\"midiInter\"></span>";
											var s3 = "<div class=\"midiUse\"><p class=\"midiUseName\">[ 主治 ]</p>"
													+"<p class=\"midiUseText\">"
													+ data.MediMateArray[index].MajorFunction
													+ "</p></div>";
											var s4 = "<div class=\"midiUse\"><p class=\"midiUseName\">[ 注意事项 ]</p>"
													+"<p class=\"midiUseText\">"
													+ data.MediMateArray[index].Precaution
													+ "</p></div>";
											var s5 = "<div class=\"midiMore\"><div class=\"midiMoreText\"><a href='MedicineDetail?mediId="
													+ data.MediMateArray[index].MediId
													+ "&search_strD="
													+ $('#search_str').val()
													+ "'><span class=\"left\">查看</span><span class=\"right\">详情</span></a></div></div></li>";
														$("#medimate_list").html(
														$("#medimate_list").html()+ s1+s2+st1+s3+st1+s4+st1+s5);
													});
			 $(".megas512").hide();
									$("#Pagination3").pagination(mediMatetotal, { //recordCount在后台定义的一个公有变量，通过从数据库查询记录进行赋值，返回记录的总数
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
									
		pateMeditotal = data.number.NpateMedi;
		//中成药
		 $("#patemedi_list").html("");
		 $.each(data.pateMediArray, function(index) {
			     var picture=data.pateMediArray[index].Picture;
			     var s1="<li><img src=\"<%=templateUrl%>/"+ picture
					+ "\" /><div class=\"midiMess\"><p class=\"midiName\">"
													+ data.pateMediArray[index].Name
													+ "</p>";
											var s2 = "<p class=\"midiText\">"
													+ data.pateMediArray[index].Function
													+ "</p></div>";
											var st1 ="<span class=\"midiInter\"></span>";
											var s3 = "<div class=\"midiUse\"><p class=\"midiUseName\">[ 用法用量 ]</p>"
													+"<p class=\"midiUseText\">"
													+ data.pateMediArray[index].Usage
													+ "</p></div>";
											var s4 = "<div class=\"midiUse\"><p class=\"midiUseName\">[ 注意事项 ]</p>"
													+"<p class=\"midiUseText\">"
													+ data.pateMediArray[index].Precaution
													+ "</p></div>";
											var s5 = "<div class=\"midiMore\"><div class=\"midiMoreText\"><a href='MedicineDetail?mediId="
													+ data.pateMediArray[index].MediId
													+ "&search_strD="
													+ $('#search_str').val()
													+ "'><span class=\"left\">查看</span><span class=\"right\">详情</span></a></div></div></li>";
													$("#patemedi_list").html(
													$("#patemedi_list").html()+s1+s2+st1+s3+st1+s4+st1+s5);
												});
		    $(".megas512").hide();
								$("#Pagination4").pagination(pateMeditotal, { //recordCount在后台定义的一个公有变量，通过从数据库查询记录进行赋值，返回记录的总数
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
								$("#Pagination4").show();		
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
			<input type="hidden" name = "searchSelect" value="wenyao" id="searchSelect"/>
			<input type="button" value="搜索"/>
		</form>
	</div>
	<!--选药-->
	<div class="chooseMidi">
		<ul class="midiTab">
			<li>
				<div class="con">
					<span>西药</span>
				</div>
			</li>
			<li>
				<div class="con">
					<span>方剂</span>
				</div>
			</li>
			<li>
				<div class="con">
					<span>中药</span>
				</div>
			</li>
			<li>
				<div class="con">
					<span class="left">中成</span>
					<span class="right">药</span>
				</div>
			</li>
		</ul>
		
		
		<span class="midiTopPic"></span>
		<div id="content">
		
		<div>
		<ul id="westmedi_list" class="midiCon">
		</ul>
		<div id="Pagination1" class="megas512"></div>
		</div>
		
		<div><ul id="prescrip_list" class="midiCon">
		</ul>
		<div id="Pagination2" class="megas512"></div>
		</div>
		
		<div>
		<ul id="medimate_list" class="midiCon">
		</ul>
		<div id="Pagination3" class="megas512"></div>
		</div>
		
		<div>
		<ul id="patemedi_list" class="midiCon">
		</ul>
		  <div id="Pagination4" class="megas512"></div>
		</div>
		
		</div>
	</div>
<jsp:include page="/WEB-INF/include/login.jsp"></jsp:include>
</body>
</html>
