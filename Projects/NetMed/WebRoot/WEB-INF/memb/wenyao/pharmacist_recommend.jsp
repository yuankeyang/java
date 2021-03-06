<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<%

String path = request.getContextPath();
String templateUrl = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath();
request.setAttribute("url", templateUrl);

String search_str=new String(request.getParameter("search_str").getBytes("iso8859-1"),"utf-8");
//String search_str=request.getParameter("search_str");
String searchSelect=new String(request.getParameter("searchSelect").getBytes("iso8859-1"),"utf-8");
//String mediId=new String(request.getParameter("mediId").getBytes("iso8859-1"),"utf-8"); 
String username =(String) session.getAttribute("username");

%>
<jsp:include page="../../include/core_head.jsp"></jsp:include>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="${url}/css0623/expert_recommendation.css"/>
<link rel='stylesheet' type="text/css" href='${url}/schedule/jquery-ui-1.11.4/jquery-ui.css' />
<link href="${url}/css0623/pagination.css" rel="stylesheet">

<jsp:include page="/WEB-INF/include/head.jsp"></jsp:include>
<script type="text/javascript" src="${url}/js0623/jquery.pagination.js"></script>
<script type="text/javascript"  src='${url}/schedule/jquery-ui-1.11.4/jquery-ui.js'></script>   <!-- 支付弹出窗口 -->

<script charset="utf-8"  type="text/javascript">

//筛选条件

var tiaojian = {
	"currProvince":"",
	"currZhicheng":"",
	"search_str":"<%=search_str%>",
	"pageIndex":0
} ;

window.onload = function(){
	if('<%=search_str%>'!=""){
		bind(0);
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
	$("#intelligenBtn").click(function(){
		if($('#search_str').val()=="失眠"){
			$("#intelligen").attr("href","intelligent_query?search_str=" + $('#search_str').val()+"&searchSelect="+$('#searchSelect').val());
			document.getElementById("intelligen").click();
		}else{
		    alert('目前只能咨询失眠');
			return;
		}
		  
	});
	$(".expertsT a").click(function(){
		if($(this).parent().parent().attr("class")=="one"){
			alert("yes");
		}
		if($(this).parent().parent().attr("class")=="two"){
			tiaojian.currProvince = $(this).text();
			$(".one .twoT").remove();
			$(".one").append("<span class=\"twoT\"><a onclick=\"deleteTiaoJian(this);\" href=\"javascript:void(0)\">"+ $(this).text()+"<img src=\"imgs/redX.jpg\" ></img></a></span>");
		}
		if($(this).parent().parent().attr("class")=="three"){
			tiaojian.currZhicheng = $(this).text();
			$(".one .threeT").remove();
			$(".one").append("<span class=\"threeT\"><a onclick=\"deleteTiaoJian(this);\" href=\"javascript:void(0)\">"+ $(this).text()+"<img src=\"imgs/redX.jpg\" ></img></a></span>");
		}
		bind(0);
	});
};

function  deleteTiaoJian(obj){
	if($(obj).parent().attr("class")=="twoT"){
		tiaojian.currProvince = "";
	}
	if($(obj).parent().attr("class")=="threeT"){
		tiaojian.currZhicheng = "";
	}
	$(obj).parent().remove();
	bind(0);
}
	
function getProvince(currProvince){
	tiaojian.currProvince = currProvince;
	 bind(0);
}
function getZhicheng(currZhicheng){
	tiaojian.currZhicheng = currZhicheng;
    bind(0);
}

function pageselectCallback(page_id,jq){
    bind(page_id);
};


function bind(pageIndex){
	//alert($('#input_doctor').val());
	//alert("sd");
  var total = 0;
  tiaojian.pageIndex = (pageIndex+1);
  
  $.ajax({
    url : '<%=templateUrl%>/PharmacistAction',
    type : 'POST',
    data: JSON.stringify(tiaojian),
    contentType: "application/json; charset=utf-8", 
	dataType : 'json',
	timeout : 15000,
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
	  // alert("请刷新页面");
	}
	function conFunction() {
		;
	}
	function succFunction(data) {
	    //alert("success");
	    $("#doctor_list").html("");
	    var total = data.account;
	    $(".doctorCon li").remove();
	    if(total==0){
	    	$("#doctor_list").html($("#doctor_list").html()+"<p>"+data.nullInfo+"</p>");
	    }
	    else{
	    	 $.each(data.pharmacistArray, function(index) {
	    		var s1 = "<li><img src=\"imgs/man_3.png\"/><div class=\"doctorMess\">";
	 	    	var s2 = "<p class=\"doctorName\">"+data.pharmacistArray[index].pharmacistName+"</p><p class=\"doctorMess2\"><span>[职称] </span>"+data.pharmacistArray[index].zhicheng+"</p><p class=\"doctorMess2\"><span>[医院] </span>"+data.pharmacistArray[index].yiyuan+"</p><p class=\"doctorMess2\"><span>[科室] </span>"+data.pharmacistArray[index].keshi+"</p></div>";
	 	    	var s3 ="<span class=\"doctorInter\"></span><div class=\"doctorMiddle\"><p class=\"doctorMess2\"><span>[擅长] </span></p><p class=\"doctorMess22\">"+data.pharmacistArray[index].good+"</p></div><span class=\"doctorInter\"></span><div class=\"doctorMore\"><div class=\"doctorMoreText\">";
	 	    	var s4 ="<span class=\"one\" onclick=\"javascript:payDialog2(this,'"+data.pharmacistArray[index].pharmacistId+"','"+data.pharmacistArray[index].pharmacistName+"');\"></span>";
	 	    	var s5 ="<span class=\"two\" onclick=\"javascript:payDialog(this,'"+data.pharmacistArray[index].pharmacistId+"','"+data.pharmacistArray[index].pharmacistName+"');\"></span>";
	 	    	var s6 ="<span class=\"three\" onclick=\"javascript:appointMentExpert(this,'"+data.pharmacistArray[index].pharmacistId+"','"+data.pharmacistArray[index].pharmacistName+"');\"></span>";
	 	    	var s7 ="<span class=\"four\" onclick=\"javascript:collectExpert(this,'"+data.pharmacistArray[index].pharmacistId+"');\"></span></div></div></li>";
	 	    	$(".doctorCon").append(s1+s2+s3+s4+s5+s6+s7);
			});
	    	 
	    	if('<%=username%>'=='null'){
				 $(".doctorMoreText span").each(function(index){
					 $(this).attr("onclick","javascript:alert('请先登录')");
					 $(this).attr("href");
				 });
			}
	    	 
	    	 $('#Pagination').pagination(total,{ //recordCount在后台定义的一个公有变量，通过从数据库查询记录进行赋值，返回记录的总数
	  	        recordCount: total,   
	              callback: pageselectCallback,  //点击分页时，调用的回调函数  
	              prev_text: '« 上一页',  //显示上一页按钮的文本  
	              next_text: '下一页 »',  //显示下一页按钮的文本  
	              items_per_page:4,  //每页显示的项数  
	              num_display_entries:14,  //分页插件中间显示的按钮数目  
	              current_page:pageIndex,  //当前页索引  
	              num_edge_entries:2 //分页插件左右两边显示的按钮数目  
	          });  
	    	
	    }
	  
   }
}


//预约
function appointMentExpert(self,doctorId,doctorName){
	if('<%=username%>'=='null'){
		 $(this).attr("onclick","javascript:alert('请先登录')");
		 $(this).attr("href");
	}else{
		var s="user/yuyue?doctorId="+doctorId+"&doctorName="+doctorName;
		window.open("<%=templateUrl%>/"+s);
	}
}

//收藏
function collectExpert(collect,expeId){
	var  collectData="收藏";
	 $.ajax({
         url : '<%=templateUrl%>/CollectAction?collect='+collectData+'&userId='+expeId,
         type : 'POST',
         contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		 dataType : 'text',
		 timeout : 18000,
		 cache : true,
    	 error : erryFunction, //错误执行方法  
		 success : succFunction	//成功执行方法  
		});
		function erryFunction() {alert("收藏失败，请重试!!");}
		function succFunction(data) {
			var data = String($.trim(data)); 
			if(data=='yes'){
				alert("收藏成功!");
			}else{
				alert("收藏失败，请重试!!");
			}	
		};
	};
	
	function payDialog(self,id,name){
		
		$("#dialog").dialog("open");
		$("#confirm_consult").click(function(){
		var s="user/payAction?userId=<%=username%>&searchSelect=<%=searchSelect%>&expe_id="+id+"&expe_name="+name+"";
		window.open("<%=templateUrl%>/"+s);
		$("#dialog").dialog("close");       //确认咨询后关闭对话框
		window.location.reload(true);   //关闭支付窗口后重新刷新一下页面！！！
		});
		};
		
		function payDialog2(self,id,name){
		
		$("#dialog").dialog("open");
		$("#confirm_consult").click(function(){
		var s="user/payAction2?userId=<%=username%>&searchSelect=<%=searchSelect%>&expe_id="+id+"&expe_name="+name+"";
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
	    $.ajax({
	        url : '<%=templateUrl%>/getMemberCreditValue?userId=<%=username%>',
			type : 'POST',
			contentType : "application/json; charset=utf-8",
			dataType : 'json',
			timeout : 10000,
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
	
</script>
<title>药师列表</title>
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
			<input type="hidden" name = "searchSelect" value="wenyao" id="searchSelect"/>
			<input type="button" value="搜索"/>
		</form>
	</div>
	
	<!--选药-->
	<div class="chooseMidi">
		<ul class="midiTab">
			<li id="expert_recommendBtn"  class="addBg">
				<div class="con">
					<span class="left">专家</span>
					<span class="right">推荐</span>
				</div>
			</li>
			<li id="intelligenBtn" >
				<div class="con">
					<span class="left">智能</span>
					<span class="right">咨询</span>
				</div>
				<a target="_blank" id="intelligen" style="display: none"></a>
			</li>
		</ul>
		<ul class="expertsT">
			<li class="one">
				<img class="left" src="imgs/paixu_3.png"/>
				<p>已选:</p>
			</li>
			<li class="two">
				<img class="left" src="imgs/diqu_3.png"/>
				<p>地区:</p>
				<span><a href="javascript:void(0)">北京</a></span>
				<span><a href="javascript:void(0)">湖南</a></span>
				<span><a href="javascript:void(0)">河南</a></span>
				<span><a href="javascript:void(0)">上海</a></span>
			</li>
			<li class="three">
				<img class="left" src="imgs/zhichen_3.png"/>
				<p>职称:</p>
				 <span><a href="javascript:void(0)">主任药师</a></span>
				 <span><a href="javascript:void(0)">副主任药师</a></span>
			</li>
		</ul>
		<span class="doctorTopPic"></span>
		<ul class="doctorCon">
		</ul>
		<div id="Pagination" class="megas512"></div>
	</div>
	
	<div id="dialog" style="display: none">
		<div class="user_center_bigtitle" style="text-align:center">
			<span>支付窗口</span>
			<hr></hr>
		</div>
		<div class="my_dis_diray">
			<div class="my_dis_diray_con">
				<div class="mg_info"
					style="font-family: '宋体';font-size: 18px;">
					<h3 style="text-align:center">
						您目前还剩积分:<a id="remainCredit" href="javascript:void(0)"
							style="text-decoration:none">0</a>
					</h3>
					<h3 style="text-align:center">本次咨询需要10个积分</h3>
				</div>

				<div style="margin-top:50px;margin-left:300px">

					<input type="button" id="confirm_consult" name="confirm_consult"
						value="确认咨询" />

				</div>

			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/include/login.jsp"></jsp:include>
</body>
</html>
