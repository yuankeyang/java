<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.Date"%>
<%@ page language="java" import="java.sql.*"%>
<%
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	//String name = (String) session.getAttribute("expename");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${url}/css0623/style.css"/>
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script>
    function getDoctorOfflineConsult(){
	    $.ajax({
	        url : '<%=templateUrl%>/expe/OfflineConsultFormBriefForRead',
			type : 'POST',
			contentType : "application/json; charset=utf-8",
			dataType : 'json',
			timeout : 8000,
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
			var num = data.acount;
			//alert(num);
			$("#recAID").html(num);
			if(parseInt(data.acount)!=0){
				var th=$("<thead><tr align='center'height='40px' bgcolor='#BFA789' class='xu' style='color: #FFF;'> <th>[序号]</th><th>[患者] </th><th>[姓名] </th><th>[病情简介] </th><th>[咨询时间]</th><th colSpan='2'>[相关操作]</th></tr></thead>");
				th.appendTo("#records");
				$.each(data.OfflineConsultArray,function(index) {
					//alert(data.OfflineConsultArray[index].electronic_record);
					var s1 = "<tr align='center' height='40px' bgcolor='#FFFFFF' style='font-size: 16px;color: #000;'><td><a title=\"查看详情\" target=\"_blank\" href='OfflineConsultFormDetailForRead?electronic_record="+ data.OfflineConsultArray[index].electronic_record+ "'>"	+ (index + 1)+ "</a></td>";
					var s2 ="<td>"+data.OfflineConsultArray[index].userId+"</td>";
					var s3 ="<td>"+data.OfflineConsultArray[index].consultName+"</td>";
					var s4 ="<td>"+data.OfflineConsultArray[index].brief+"</td>";
					var s5 = "<td>"+data.OfflineConsultArray[index].time+"</td>";
					var s6 = "<td class=\"offAccount\"><a title=\"查看详情\" target=\"_blank\" href='OfflineConsultFormDetailForRead?electronic_record="+ data.OfflineConsultArray[index].electronic_record+ "'>查看</a></td>";
					var s7 = "<td class=\"offAccount\"><a title=\"追加意见\" target=\"_blank\" href='OfflineConsultFormDetailForAppend?electronic_record="+ data.OfflineConsultArray[index].electronic_record+ "'>修改</a></td></tr>";
					var tr=$(s1+s2+s3+s4+s5+s6+s7);
				    tr.appendTo("#records");
				});
			}
		}
	}
    
	window.onload = function() {
		getDoctorOfflineConsult();
		$("#recAID").click(function(){
			 $("#records").toggle();
		 });
	};
	 
</script>
<style type="text/css">
   
   .offAccount a{ color:#0000ff;text-decoration:none;font-weight:bold}
   .offAccount a:hover{color:#ff0000}
   .offAccount a:active{color:#ff0000}   
</style>

</head>
<body>
	<div>
		<img src="${url}/imgs/membercenter/left.png" /><span
			style="font-family:'仿宋';font-size:33px;color:#c9b28b;">已处理离线表单 </span><img
			src="${url}/imgs/membercenter/right.png" />
	</div>
	<br/>
	<div class="my_dis_diray">
		<div class="my_dis_diray_con">
			<div class="mg_info" style="font-family: '宋体' ;font-size: 18px;">
				<h3>
					总共有<a id="recAID" href="javascript:void(0)">0</a>条记录
				</h3>
				<table id="records" width="800" border="0" style="font-weight:bold;">
                </table>
			</div>
		</div>
	</div>

</body>

</html>
