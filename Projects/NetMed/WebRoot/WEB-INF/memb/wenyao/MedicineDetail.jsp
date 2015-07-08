<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String templateUrl = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath();
request.setAttribute("url", templateUrl);
  String mediId=new String(request.getParameter("mediId").getBytes("iso8859-1"),"utf-8");
  String search_str=new String(request.getParameter("search_strD").getBytes("iso8859-1"),"utf-8");
  String searchSelect = "wenyao";
%>
<jsp:include page="../../include/core_head.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link rel="stylesheet" type="text/css" href="${url}/css0623/MedicineDetail.css" />

<jsp:include page="/WEB-INF/include/head.jsp"></jsp:include>
<script charset="utf-8" type="text/javascript">
$(document).ready(function(){
	$("#turnBg li").removeClass("addBg");
	$("#turnBg li[id=choose2]").attr("class","addBg");
	$("#turnBg li").each(function(){
	$(this).click(function(){
	$(this).siblings(".addBg").removeClass("addBg");
	$(this).attr("class","addBg");
	$("#searchSelect").val($(this).attr("value"));
	});
	});
	
		
	
    //搜索类型为医生时
	if("<%=mediId%>"!=""){
		search_medicine();
	}
    
	$(".experts a").click(function () {
		if($(this).attr("id")=="expert_recommendBtn"){
			$(this).attr("href","pharmacist_recommend?search_str=" + $('#search_str').val()+"&searchSelect="+$('#searchSelect').val());
			document.getElementById($(this).attr("expert_recommendBtn")).click();
		}
	});
});
function search_medicine(){
  $.ajax({
	url : '<%=templateUrl%>/MedicineDetailAction?mediId=<%=mediId%>',
    type : 'POST',
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
	   // alert("dfdfd");
		
		// $(".pager").hide();
	}
	function erryFunction() {
	    //alert("请耐心等待");
	}
	function conFunction() {
		// $(".pager").show();
	}
	function succFunction(data) {
		 
	     if(data.medicine.type=="westMedi"){     //药物类型！！！！
	    	 var name=data.medicine.name;
		     var Yfunction=data.medicine.Yfunction;
		     $('#objectName').html(name);
		     $('#name1').html("[西药名称]");
		     $('#content1').html(name);
		     $('#name2').html("[西药组成]");
		     $('#content2').html(data.medicine.ingredient);
		     $('#name3').html("[不良反应]");
		     $('#content3').html(data.medicine.adverseAction);
		     $('#name4').html("[用法用量]");
		     $('#content4').html(data.medicine.usage);
		    
		     $('#name5').html("[生产企业]");
		     var s="&nbsp;&nbsp;&nbsp;&nbsp;"+"<a href=\"javascript:void(0)\" onclick=\"alert('功能正在实现')\">点击查看详情</a>";
		     $('#content5').html(data.medicine.enterprise+s);
	     }
	     
	     if(data.medicine.type=="prescrip"){     //如果是方剂，显示的内容会有些不一样！！！！
	    	 var name=data.medicine.name;
		     var Yfunction=data.medicine.Yfunction;
		     $('#objectName').html(name);
		     $('#name1').html("[方剂名]");
		     $('#content1').html(name);
		     $('#name2').html("[方剂组成]");
		     $('#content2').html(data.medicine.ingredient);
		     $('#name3').html("[方歌]");
		     $('#content3').html(data.medicine.presSong);
		     $('#name4').html("[用法用量]");
		     $('#content4').html(data.medicine.usage);
		     
		     $('#name5').html("[服务机构]");
		     var s="&nbsp;&nbsp;&nbsp;&nbsp;"+"<a href=\"javascript:void(0)\" onclick=\"alert('功能正在实现')\">点击查看详情</a>";
		     $('#content5').html(data.medicine.institution+s);
	     }
	     
	     if(data.medicine.type=="mediMate"){     //如果是中药材，显示的内容会有些不一样！！！！
	    	 var name=data.medicine.name;
		     var Yfunction=data.medicine.Yfunction;
		     $('#objectName').html(name);
		     $('#name1').html("[中药材名]");
		     $('#content1').html(name);
		     $('#name2').html("[化学组成]");
		     $('#content2').html(data.medicine.ingredient);
		     $('#name3').html("[古籍摘要]");
		     $('#content3').html(data.medicine.ancientBook);
		     $('#name4').html("[用法用量]");
		     $('#content4').html(data.medicine.usage);
		     
		     $('#name5').html("[服务机构]");
		     var s="&nbsp;&nbsp;&nbsp;&nbsp;"+"<a href=\"javascript:void(0)\" onclick=\"alert('功能正在实现')\">点击查看详情</a>";
		     $('#content5').html(data.medicine.institution+s);
		    
	     }
	     
	     if(data.medicine.type=="pateMedi"){     //如果是中成药，显示的内容会有些不一样！！！！
	    	 var name=data.medicine.name;
		     var Yfunction=data.medicine.Yfunction;
		     $('#objectName').html(name);
		     $('#name1').html("[中成药名]");
		     $('#content1').html(name);
		     $('#name2').html("[中成药成份]");
		     $('#content2').html(data.medicine.ingredient);
		     $('#name3').html("[规格]");
		     $('#content3').html(data.medicine.specification);
		     $('#name4').html("[使用方法]");
		     $('#content4').html(data.medicine.usage);
		     
		     $('#name5').html("[生产企业]");
		     var s="&nbsp;&nbsp;&nbsp;&nbsp;"+"<a href=\"javascript:void(0)\" onclick=\"alert('功能正在实现')\">点击查看详情</a>";
		     $('#content5').html(data.medicine.enterprise+s);
	     }
	    
    }    
	
}
</script>

<title>药物详细信息</title>
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
				<li id="choose1"  value="qiuyi">
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
	<!--病症-->
	<div class="pain">
		<div class="painCon5">
			<p class="painName" id="objectName"></p>
			<p class="painShort" id="name1"></p>
			<div class="painShortCon_5">
			<p  id="content1"></p>
			</div>
			<p class="painNormal" id="name2"></p>
			<div class="painShortCon_5" >
			<p id="content2"></p>
			</div>
			<p class="painNormal" id="name3"></p>
			<div class="painNormalCon_5" >
			<p id="content3"></p>
			</div>
			<p class="painLong" id="name4"></p>
			<div class="painLongCon_5">
			<p  id="content4"></p>
			</div>
			
			<p class="painNormal" id="name5"></p>
			<div class="painNormalCon_5" >
			<p id="content5"></p>
			</div>
			
			<!--专家栏-->
			<div class="experts">
				<a href="javascript:void(0)" onclick="alert('问药暂不提供智能咨询')">智能咨询</a>
				<a id="expert_recommendBtn" style="margin-right:0px;">专家推荐</a>
			</div>
			<div style="text-align:center">
		<div>颐健通项目研发小组</div>
		<div>&#169;版权所有 &nbsp;2015-2016</div>
	    </div>
		</div>
		
	</div>
	
	<!--查询信息-->
<jsp:include page="/WEB-INF/include/login.jsp"></jsp:include>
</body>
</html>