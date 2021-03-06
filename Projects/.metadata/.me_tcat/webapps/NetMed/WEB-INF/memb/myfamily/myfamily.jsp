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
<!DOCTYPE>
<html>
<head>
<jsp:include page="/WEB-INF/include/head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${url}/css0623/style.css" />
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script>
    function getMembFamilyList(){
	  
	    $.ajax({
	        url : '<%=templateUrl%>/user/MemberFamilyListAction',
			type : 'POST',
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			dataType : 'json',
			timeout : 18000,
			cache : true,
			error : erryFunction, //错误执行方法  
			success : succFunction
		//成功执行方法  
		});
		function erryFunction() {
			//alert("有错误，请刷新页面");
		}
		function succFunction(data) {
			//未读消息条数
			var num = data.acount;
			//alert(num);
			$("#recAID").html(num);
			//姓名	性别	生日	地区	本人关系
			if(parseInt(data.acount)!=0){
				var th=$("<thead><tr align='center'height='40px' bgcolor='#BFA789' class='xu' style='color: #FFF;'><th>[编号]</th><th>[名字]</th><th>[性别]</th><th>[年龄]</th><th>[与本人关系]</th><th>[手机]</th><th>[固话]</th><th>[地址]</th><th colSpan='2'>[相 关 操 作]</th></tr></thead>");
				th.appendTo("#membFamilyList");
				//alert(data.MembFamilyArray[0].title);
				$.each(data.MembFamilyArray,function(index) {
					//alert(data.OfflineConsultArray[index].electronic_record);
					var s1 = "<tr align='center' height='40px' bgcolor='#FFFFFF' style='font-size: 16px;color: #000;'><td>"+(index+1)+"</td>";
					var s2 = "<td><b>"+data.MembFamilyArray[index].username+"</b></td>";
					var s3 = "<td><b>"+data.MembFamilyArray[index].sex+"</b></td>";
					var s4 = "<td><b>"+data.MembFamilyArray[index].age+"</b></td>";
					var s5 = "<td><b>"+data.MembFamilyArray[index].relation+"</b></td>";
					var s6 = "<td><b>"+data.MembFamilyArray[index].mobile+"</b></td>";
					var s7 = "<td><b>"+data.MembFamilyArray[index].telephone+"</b></td>";
					var s8 = "<td><b>"+data.MembFamilyArray[index].address+"</b></td>";
					var s9= "<td><b><a href='UpdateMemberFamilyAction?MembFamily_Id="+data.MembFamilyArray[index].MembFamily_Id+"'>更新</a></b></td>";
					var s10="<td><b><a href='javascript:void(0)' id="+data.MembFamilyArray[index].MembFamily_Id+" class='delete'>删除</a></b></td></tr>";
					var tr=$(s1+s2+s3+s4+s5+s6+s7+s8+s9+s10);
				    tr.appendTo("#membFamilyList");
				});
				$('#membFamilyList').show();
				 $(".delete").click(function (){
					 //alert("sd");
					 //$(this)获取的是点击的对象，点击的对象是a标签，a标签的上一级的上一级是tr
					 var statu=confirm("确定删除该家属信息?");
						if(!statu){
							return false;
						}//  
					 
					 var MembFamily_Id = $(this).attr("id");
					 $.ajax({
					        url : '<%=templateUrl%>/user/DeleteMemberFamily?MembFamily_Id='
														+ MembFamily_Id,
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
										$("#" + MembFamily_Id).parent()
												.parent().remove();
										$("#recAID")
												.html(
														$("#membFamilyList tr").length - 1);
										if ($("#membFamilyList tr").length == 1) {
											$("#membFamilyList thead").remove();
											$("#membFamilyList").hide();
										}
									}
								});
			}
		}
	}
	window.onload = function() {
		getMembFamilyList();
		$('#membFamilyList').hide();
		$("#recAID").click(function() {
			$('#membFamilyList').toggle();
		});
	};
</script>
</head>
<body>
	<div id="right">
		<div><img src="${url}/imgs/left.png"/>&nbsp;<span style="font-family:'仿宋';font-size:33px;color:#c9b28b">我的家属</span>
		&nbsp;<img src="${url}/imgs/right.png"/></div>
		<div class="my_dis_diray">
			<div class="my_dis_diray_con">

				<div class="mg_info" style="font-family: '宋体';font-size: 18px;">
					<h3>
						<h3 >
							总共有<a id="recAID" href="javascript:void(0)"></a>个家属信息
						</h3>
					</h3>
					<table id="membFamilyList" width="800" border="0">
					</table>
				</div>
				<br/><br/>
				<form action="NewMemberFamilyAction" method="post" >
					<div class="" align="right">
						<input type="submit" id="newMember" value="新建家属信息"
							style="font-family: '宋体';font-size: 18px;">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>
