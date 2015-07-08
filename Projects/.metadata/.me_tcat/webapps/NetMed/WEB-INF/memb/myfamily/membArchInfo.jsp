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
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script>
    function getmembArchInfoList(){
	    $.ajax({
	        url : '<%=templateUrl%>/user/getArchInfoBriefListForRead',
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
				var th=$("<thead><tr align='center'height='40px' bgcolor='#BFA789' style='color: #FFF;'> <th>编号</th><th>名字</th><th>性别</th><th>年龄</th><th>职业</th><th>手机号码</th><th>地址</th><th colSpan='3'>相 关 操 作</th></tr></thead>");
				th.appendTo("#membArchInfoList");
				//alert(data.archInfoArray[0].title);
				$.each(data.archInfoArray,function(index) {
					//alert(data.OfflineConsultArray[index].electronic_record);
					var s1 = "<tr align='center' height='40px' bgcolor='#FFFFFF' style='font-size: 16px;color: #000;'><td>"+(index+1)+"</td>";
					var s2 = "<td>"+data.archInfoArray[index].username+"</td>";
					var s3 = "<td>"+data.archInfoArray[index].sex+"</td>";
					var s4 = "<td>"+data.archInfoArray[index].age+"</td>";
					var s5 = "<td>"+data.archInfoArray[index].occupation+"</td>";
					var s7 = "<td>"+data.archInfoArray[index].telephone+"</td>";
					var s8 = "<td>"+data.archInfoArray[index].address+"</td>";
					//var s9= "<td><a  href='UpdateMemberFamilyAction?MembFamily_Id="+data.archInfoArray[index].MembFamily_Id+"'>更新</a></td>";
					var s10="<td><a href='javascript:void(0)' id="+data.archInfoArray[index].archId+" class='delete'>删除</a></td>";
					var s11= "<td><a title=\"修改一下\" href='UpdateArchInfoAction?ArchInfo_Id="+data.archInfoArray[index].archId+"'>更新</a></td>";
					var s12= "<td><a target=\"_blank\" title=\"查看一下\" href='ArchInfoDetailForUserRead?ArchInfo_Id="+data.archInfoArray[index].archId+"'>查看</a></td></tr>";
					var tr=$(s1+s2+s3+s4+s5+s7+s8+s10+s11+s12);
				    tr.appendTo("#membArchInfoList");
				});
				$('#membArchInfoList').show();
				 $(".delete").click(function (){
					 //alert("sd");
					 //$(this)获取的是点击的对象，点击的对象是a标签，a标签的上一级的上一级是tr
					 //  
					 var statu=confirm("确定删除该电子病历?");
						if(!statu){
							return false;
						}
					 
					 var archId = $(this).attr("id");
					 $.ajax({
					        url : '<%=templateUrl%>/user/DeleteArchInfoAction?archId='+archId,
							type : 'POST',
							contentType: "application/x-www-form-urlencoded; charset=utf-8", 
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
							$("#"+archId).parent().parent().remove();
							$("#recAID").html($("#membArchInfoList tr").length-1);
							if($("#membArchInfoList tr").length==1){
								$("#membArchInfoList thead").remove();
								$("#membArchInfoList").hide();
							}
						}
				   });
			}
		}
	}
	window.onload = function() {
		getmembArchInfoList();
		$('#membArchInfoList').hide();
		$("#recAID").click(function(){
			$('#membArchInfoList').toggle();
		 });
	};
</script>
</head>
<body>
	<div><img src="${url}/imgs/left.png"/>&nbsp;<span style="font-family:'仿宋';font-size:33px;color:#c9b28b">电子档案</span>
		&nbsp;<img src="${url}/imgs/right.png"/></div>

	<div class="my_dis_diray">
		<div class="my_dis_diray_con">
			<div class="mg_info" style="font-family:'宋体';font-size: 18px;">
				<h3>
					总共有（<a id="recAID" href="javascript:void(0)"></a>）个电子健康病历
				</h3>
				<table id="membArchInfoList" width="780px" border="0" id="table" bordercolor="#FFFFFF" align="center" style="text-align: center;font-weight:bold">
                </table>
			</div>
		</div>
		<br/><br/>
		 <form action="NewMembArchInfo" method="post">
		  <div align="right">
		    <input type="submit" id="newMember" value="新建电子健康档案" style="font-family:'宋体';font-size: 18px;">
		</div>
		</form>
	</div>

</body>

</html>
