<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String templateUrl = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath();
request.setAttribute("url", templateUrl);
%>

<jsp:include page="../../include/core_head.jsp"></jsp:include>
<html>
<head>
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="${url}/membcss/wodeDoc.css" />
<link rel="stylesheet" type="text/css" href="${url}/css0623/style.css" />
<script type="text/javascript">

    $(document).ready(function () {
        $("#tabs li").bind("click", function () {
            var index = $(this).index();
            var divs = $("#tabs-body > div");
            $(this).parent().children("li").attr("class", "tab-nav");//将所有选项置为未选中
            $(this).attr("class", "tab-nav-action"); //设置当前选中项为选中样式
            divs.hide();//隐藏所有选中项内容
            divs.eq(index).show(); //显示选中项对应内容
        });
        getMyDoc();
        $(".hudong").each(function(index){
        	  $(this).find("a").click(function(){
        	      $(this).next("ul").toggle();
		   });
        });
        
    });
    function getMyDoc(){
  	    $.ajax({
  	        url : '<%=templateUrl%>/user/allDoctor',
  			type : 'POST',
  			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
  			dataType : 'json',
  			timeout : 20000,
  			cache : true,
  			error : erryFunction, //错误执行方法  
  			success : succFunction
  		//成功执行方法  
  		});
  		function erryFunction() {
  			alert("正在获取互动专家，请耐心等待");
  		}
  		function succFunction(data) {
  			var dataNum = [data.yishiNum, data.yaoshiNum, data.anmoNum,data.xinliNum,data.jiankangNum,data.yingyangNum]; 
  			var dataDetail = [data.yishi, data.yaoshi, data.anmo,data.xinli,data.jiankang,data.yingyang];
  			$(".hudong").each(function(i){
  				//alert(i);
  				$(this).find("a").html($(this).find("a").html()+"("+dataNum[i]+")");
  				var list = $(this).find("ul");
  				if(parseInt(dataNum[i])!=0){
  					var dataI = dataDetail[i];
  					//alert(dataI[0].expertName);
	  				 $.each(dataI,function(index) {
	  					list.append("<li style='font-family: 宋体;font-size: 18px;'><a href='getExpeDetail?expe_id="+dataI[index].expe_id+"'>"+ dataI[index].expertName+ "</a>,擅长："+ dataI[index].instroduction+ "</li>");
	  				 });
	  				 list.show();
  				}else{
  					list.append("<li>暂时还没有和相关专家互动！！</li>");
  				}
  			});
  			
  			 //收藏
  			if(parseInt(data.colectNum)!=0){
	  		    $.each(data.colectArray,function(index) {//target=\"_blank\"
		  			$("#colect").append("<li><a  href='getExpeDetail?expe_id="+data.colectArray[index].expe_id+"'>"+ data.colectArray[index].expertName+ "</a>,擅长："+ data.colectArray[index].introduction+ "</li>");
		  		});
  			}else{
  				$("#colect").append("<li>你还没有收藏任何专家！！！赶快去收藏吧</li>");
  			}
  		}
  	}
</script>
</head>
<body style="font-family:'宋体';font-size: 14pt">
	<div><img src="${url}/imgs/left.png"/>&nbsp;<span style="font-family:'仿宋';font-size:33px;color:#c9b28b">我的专家</span>
		&nbsp;<img src="${url}/imgs/right.png"/></div>
	<br/><br/>
	<div class="tabs">
		<ul id="tabs">
			<li class="tab-nav-action" style="font-family: '宋体';"><b>收藏的专家</b></li>
			<li class="tab-nav" style="font-family: '宋体';"><b>互动的专家</b></li>
		</ul>
	</div>
	<div id="tabs-body" class="tabs-body" >
		<div id="tab1" style="display:block">
		     <ul id="colect"></ul>
		</div>
		
		<div style="display:none;" id="tab2">
		 <div class="hudong">
		   <a id="recAIDYD" href="javascript:void(0)" style="font-family: '宋体';">医师</a>
		   <ul id="yishi" style="display: none;margin-bottom: 0px"></ul>
		</div>
		<div class="hudong" >
		   <a id="recAIDYD" href="javascript:void(0)" style="font-family: '宋体';">药师</a>
		   <ul id="yaoshi" style="display: none;margin-bottom: 0px"></ul>
		</div>
		<div class="hudong">
		   <a id="recAIDYD" href="javascript:void(0)" style="font-family: '宋体';">按摩理疗师</a>
		   <ul id="anmo" style="display: none;margin-bottom: 0px"></ul>
		</div>
		<div class="hudong">
		   <a id="recAIDYD" href="javascript:void(0)" style="font-family: '宋体';">心理咨询师</a>
		   <ul id="xinli" style="display: none;margin-bottom: 0px"></ul>
		</div>
		<div class="hudong">
		   <a id="recAIDYD" href="javascript:void(0)" style="font-family: '宋体';">健康管理师</a>
		   <ul id="jiankang" style="display: none;margin-bottom: 0px"></ul>
		</div>
		<div class="hudong">
		   <a id="recAIDYD" href="javascript:void(0)" style="font-family: '宋体';">营养师</a>
		   <ul id="yingyang" style="display: none;margin-bottom: 0px"></ul>
		</div>
	</div>
	</div>
</body>