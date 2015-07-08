<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.Date"%>
<%@ page language="java" import="java.sql.*"%>
<%
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	String name = (String) session.getAttribute("expename");
%>
<!DOCTYPE>
<html>
<head>
<link href="${url}/css0623/style.css" rel="stylesheet">
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script>
    function getDoctorOfflineConsult(){
	    $.ajax({
	        url : '<%=templateUrl%>/user/OfflineConsultFormBriefForUserRead',
			type : 'POST',
			contentType : "application/json; charset=utf-8",
			dataType : 'json',
			timeout : 20000,
			cache : true,
			error : erryFunction, //错误执行方法  
			success : succFunction
		//成功执行方法  
		});
		function erryFunction() {
			//alert("请刷新页面");
		}
		function succFunction(data) {
			//未读消息条数
			var numYD = data.acountYD;
			var numWD = data.acountWD;
			//alert(num);
			$("#recAIDYD").html(numYD);
			$("#recAIDWD").html(numWD);
			if (parseInt(data.acountYD) != 0) {
				var th = $("<thead><tr  align='center'height='40px' bgcolor='#BFA789' style='color: #FFF;'> <th>序号</th><th>专家</th><th>病情简介 </th><th>辩证结果</th><th>辨病结果</th><th>回复时间</th></tr></thead>");
				th.appendTo("#recordsYD");
				$
						.each(
								data.OfflineConsultArrayYD,
								function(index) {

									//alert(data.OfflineConsultArray[index].electronic_record);
									var s1 = "<tr  align='center' height='40px' bgcolor='#FFFFFF' style='font-size: 16px;color: #000;'><td><a target=\"_blank\" title=\"查看详情\" href='OfflineConsultFormDetailForUserRead?electronic_record="
											+ data.OfflineConsultArrayYD[index].electronic_record
											+ "'>" + (index + 1) + "</a></td>";
									var s2 = "<td>"
											+ data.OfflineConsultArrayYD[index].expeId
											+ "</td>";
									var s3 = "<td>"
											+ data.OfflineConsultArrayYD[index].brief
											+ "</td>";
									var s4 = "<td>"
											+ data.OfflineConsultArrayYD[index].medeical_zheng
											+ "</td>";
									var s6 = "<td>"
											+ data.OfflineConsultArrayYD[index].medeical_disease
											+ "</td>";
									var s5 = "<td>"
											+ data.OfflineConsultArrayYD[index].time
											+ "</td></tr>";
									//var s5 = "<td><a target=\"_blank\" href='OfflineConsultFormDetailForAppend?electronic_record="+ data.OfflineConsultArrayYD[index].electronic_record+ "'>追加</a></td></tr>";
									var tr = $(s1 + s2 + s3 + s4 + s6 + s5);
									tr.appendTo("#recordsYD");

								});
			}
			if (parseInt(data.acountWD) != 0) {
				var th = $("<thead><tr  align='center'height='40px' bgcolor='#BFA789' style='color: #FFF;'> <th>序号</th><th>专家</th><th>病情简介 </th><th>咨询时间</th></tr></thead>");
				th.appendTo("#recordsWD");
				$
						.each(
								data.OfflineConsultArrayWD,
								function(index) {
									var s1 = "<tr  align='center' height='40px' bgcolor='#FFFFFF' style='font-size: 16px;color: #000;'><td><a target=\"_blank\" title=\"查看详情\" href='OfflineConsultFormDetailForUserRead?electronic_record="
											+ data.OfflineConsultArrayWD[index].electronic_record
											+ "'>" + (index + 1) + "</a></td>";
									var s2 = "<td>"
											+ data.OfflineConsultArrayWD[index].expeId
											+ "</td>";
									var s3 = "<td>"
											+ data.OfflineConsultArrayWD[index].brief
											+ "</td>";
									var s4 = "<td>"
											+ data.OfflineConsultArrayWD[index].time
											+ "</td></tr>";
									var tr = $(s1 + s2 + s3 + s4);
									tr.appendTo("#recordsWD");
								});
			}
		}
	}
	window.onload = function() {
		getDoctorOfflineConsult();
		$("#recAIDYD").click(function() {
			$("#recordsYD").toggle();
		});
		$("#recAIDWD").click(function() {
			$("#recordsWD").toggle();
		});
	};
</script>
</head>
<body>

	<div id="right">
	<div><img src="${url}/imgs/left.png"/>&nbsp;<span style="font-family:'仿宋';font-size:33px;color:#c9b28b">离线咨询</span>
		&nbsp;<img src="${url}/imgs/right.png"/></div>


		<div
			style="font-family:'宋体';font-weight:bold;font-size:28px;margin-top:15px;margin-left:265px">[我的专家咨询信息]</div>
		<br />
		<div>
			<table>
				<tr>
					<td align="center" colspan="5" bgcolor="#F5ECE2"
						style="font-family:'宋体';font-size:18pt;color:#000;">总共有<a
						id="recAIDYD" href="javascript:void(0)"><span
							style="font-family:'宋体';font-size:30px;color:#c9b28b;">0</span>
					</a>条已处理记录</td>
				</tr>
				<tr>
					<td>
						<table id="recordsYD" style="width:780px;font-weight:bold"></table>
					</td>
				</tr>
				<tr>
					<td colspan="5" height="40px"></td>
				</tr>
				<!-- 两个表格之间空格 -->
				<tr>
					<td align="center" colspan="5" bgcolor="#F5ECE2"
						style="font-family:'宋体';font-size:18pt;color:#000;">总共有<a
						id="recAIDWD" href="javascript:void(0)"><span
							style="font-family:'宋体';font-size:30px;color:#c9b28b;">0</span>
					</a>条未处理记录</td>
				</tr>
				<tr>
					<td>
						<table id="recordsWD" style="width:780px; font-weight:bold"></table>
					</td>
				</tr>
			</table>
		</div>
	</div>

</body>

</html>
