<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.Date"%>
<%@ page language="java" import="java.sql.*"%>
<%
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	String expeId = (String) session.getAttribute("expename");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${url}/css0623/style.css" />
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script>
    function getDiaryList(){
	  // var data=encodeURIComponent(JSON.stringify($('#input_doctor').val()),"utf-8");
	  // alert(encodeURI(encodeURI($('#input_doctor').val())));//验证是否在线
	    $.ajax({
	        url : '<%=templateUrl%>/expe/DiaryListAction',
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
				var th=$("<thead><tr align='center'height='40px' bgcolor='#BFA789' class='xu' style='color: #FFF;'><th>[序号]</th> <th>[题目]</th><th>[发表时间]</th> <th colSpan='2'>[相 关 操 作]</th></tr></thead>");
				th.appendTo("#diaryList");
				//alert(data.DiaryArray[0].title);
				$.each(data.DiaryArray,function(index) {
					//alert(data.OfflineConsultArray[index].electronic_record);
					var s5 = "<tr align='center' height='40px' bgcolor='#FFFFFF' style='font-size: 16px;color: #000;'><td>"+(index+1)+"</td>";
					var s1 = "<td><a title=\"查看详情\" target=\"_blank\" href='OpenDiary?Diary_Id="+data.DiaryArray[index].Diary_Id+"'>"+data.DiaryArray[index].title+"</a></td>";
					var s2 = "<td>"+data.DiaryArray[index].time+"</td>";
					var s3= "<td><a title=\"修改一下\" href='UpdateDiaryAction?Diary_Id="+data.DiaryArray[index].Diary_Id+"'>更新</a></td>";
					var s4="<td><a title=\"删除它\" href='javascript:void(0)' id="+data.DiaryArray[index].Diary_Id+" class='delete'>删除</a></td></tr>";
					var tr=$(s5+s1+s2+s3+s4);
				    tr.appendTo("#diaryList");
				});
				$('#diaryList').show();
				 $(".delete").click(function (){
					 //alert("sd");
					 //$(this)获取的是点击的对象，点击的对象是a标签，a标签的上一级的上一级是tr
					 //  
					 var statu=confirm("确定删除该日记?");
						if(!statu){
							return false;
						}
					 
					 var Diary_Id = $(this).attr("id");
					 $.ajax({
					        url : '<%=templateUrl%>/expe/DeleteDiary?Diary_Id='
														+ Diary_Id,
												type : 'POST',
												contentType : "application/x-www-form-urlencoded; charset=utf-8",
												dataType : 'text',
												timeout : 8000,
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
										//alert($("#"+Diary_Id).attr("id"));
										$("#" + Diary_Id).parent().parent()
												.remove();
										$("#recAID").html(
												$("#diaryList tr").length - 1);
										if ($("#diaryList tr").length == 1) {
											$("#diaryList thead").remove();
											$("#diaryList").hide();
										}
									}
								});
			}
		}
	}
	window.onload = function() {
		getDiaryList();
		$('#diaryList').hide();
		$("#recAID").click(function() {
			$('#diaryList').toggle();
		});
	};
</script>
</head>
<body>
	<div>
		<img src="${url}/imgs/membercenter/left.png" />&nbsp;&nbsp;<span
			style="font-family:'仿宋';font-size:33px;color:#c9b28b;">日记管理</span>&nbsp;&nbsp;<img
			src="${url}/imgs/membercenter/right.png" />
	</div>
	<br/>
	<div class="my_dis_diray">
		<div class="my_dis_diray_con">
			
			<div class="mg_info"
				style="font-family: '宋体' ;font-size: 18px;">
				<h3>
						总共有<a id="recAID" href="javascript:void(0)"></a>篇专家日记
				</h3>
				<table id="diaryList" width="800" border="0" style="font-weight:bold">
				</table>
			</div>
			<br/><br/>
			<form action="NewDiaryAction" method="post">
				<div class="" align="right">
					<input type="submit" id="newDiary" value="创建新的专家日记"
						style="font-family: '宋体' ;font-size: 18px;">
				</div>
			</form>
		</div>
	</div>

</body>

</html>
