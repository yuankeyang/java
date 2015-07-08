<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", -10);
%>
<%
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	String userId = (String) session.getAttribute("username");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<link rel="stylesheet" type="text/css" href="${url}/css0623/style.css" />
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script>
    function getSleepRecord(){
    	
	    $.ajax({
	        url : '<%=templateUrl%>/user/SleepRecordAction',
			type : 'POST',
			contentType : "application/json; charset=utf-8",
			dataType : 'json',
			timeout : 18000,
			cache : true,
			error : erryFunction, //错误执行方法  
			success : succFunction
		//成功执行方法  
		});
		function erryFunction() {
			//alert("请刷新页面!!");
		}
		function succFunction(data) {
			
			//未读消息条数
			var num = data.acount;
			//alert(num);
			$("#recAID").html(num);
			//初入睡时间	睡眠时间长度	  熟睡总时间    浅睡总时间    醒/做梦总时间   呼吸中止指数  记录时间    
			if(parseInt(data.acount)!=0){
				var th=$("<thead><tr align='center'height='40px' bgcolor='#BFA789' class='xu' style='color: #FFF;'> <th>[编号]</th><th>[初入睡时间]</th><th>[睡眠时间长度]</th><th>[熟睡总时间]</th><th>[浅睡总时间]</th><th>[醒/做梦总时间]</th><th>[呼吸中止指数]</th><th>[记录时间]</th><th colSpan='2'>[相 关 操 作]</th></tr></thead>");
				th.appendTo("#sleepRecord");
				
				$.each(data.sleepRecordArray,function(index) {
					//alert(data.sleepRecordArray[index].sleepRecordId);
					var s1 = "<tr align='center' height='40px' bgcolor='#FFFFFF' style='font-size: 16px;color: #000;'><td>"+(index+1)+"</td>";
					var s2 = "<td>"+data.sleepRecordArray[index].fallSleep+"</td>";
					var s3 = "<td>"+data.sleepRecordArray[index].sleepDuration+"</td>";
					var s4 = "<td>"+data.sleepRecordArray[index].deepDuration+"</td>";
					var s5 = "<td>"+data.sleepRecordArray[index].simpleDuration+"</td>";
					var s6 = "<td>"+data.sleepRecordArray[index].dreamDuration+"</td>";
					var s7 = "<td>"+data.sleepRecordArray[index].breathIndex+"</td>";
					var s8 = "<td>"+data.sleepRecordArray[index].measureTime+"</td>";
					//var s8 = "<td>"+data.bloodPressureArray[index].address+"</td>";
					var s9= "<td><a  href='updateSleepRecordAction?sleepRecordId="+data.sleepRecordArray[index].sleepRecordId+"'>修改</a></td>";
					var s10="<td><a href='javascript:void(0)' id="+data.sleepRecordArray[index].sleepRecordId+" class='delete'>删除</a></td></tr>";
					var tr=$(s1+s2+s3+s4+s5+s6+s7+s8+s9+s10);
				    tr.appendTo("#sleepRecord");
				});
				
				$('#sleepRecord').show();
				
				$(".delete").click(function (){
					var statu=confirm("确定删除该睡眠记录?");
					if(!statu){
						return false;
					}
					 //$(this)获取的是点击的对象，点击的对象是a标签，a标签的上一级的上一级是tr
					 var sleepRecordId = $(this).attr("id");
					 $.ajax({
					        url : '<%=templateUrl%>/user/DeleteSleepRecord?sleepRecordId='
														+ sleepRecordId,
												type : 'POST',
												contentType : "application/x-www-form-urlencoded; charset=utf-8",
												dataType : 'text',
												timeout : 18000,
												cache : true,
												error : erryFunction, //错误执行方法  
												success : succFunction
											//成功执行方法  
											});
									function erryFunction() {
										alert("删除失败");
									}
									function succFunction(data) {
										alert("删除成功");
										//alert($("#"+JiuyiExp_Id).attr("id"));
										$("#" + sleepRecordId).parent()
												.parent().remove();
										$("#recAID")
												.html(
														$("#sleepRecord tr").length - 1);
										if ($("#sleepRecord tr").length == 1) {
											$("#sleepRecord thead").remove();
											$("#sleepRecord").hide();
										}
									}
								});
			}
		}
	}
	window.onload = function() {
		getSleepRecord();
		$('#sleepRecord').hide();
		$("#recAID").click(function() {
			$('#sleepRecord').toggle();
		});
	};
</script>
</head>
<body>
	<div><img src="${url}/imgs/left.png"/>&nbsp;<span style="font-family:'仿宋';font-size:33px;color:#c9b28b">我的睡眠</span>
		&nbsp;<img src="${url}/imgs/right.png"/></div>
	<div class="my_dis_diray">
		<div class="my_dis_diray_con">

			<div class="mg_info"
				style="font-family: '宋体' ;font-size: 18px;">
				<h3>
					总共有<a id="recAID" href="javascript:void(0)"></a>条睡眠记录
				</h3>
				<table id="sleepRecord" width="800" border="1"></table>
			</div>
			<br/><br/>
			<form action="NewSleepRecord" method="post">
				<div align="right">
					<input type="submit" id="newMember" value="新增睡眠记录"
						style="font-family: '宋体';font-size: 18px;">
				</div>
			</form>
		</div>
	</div>

</body>

</html>
