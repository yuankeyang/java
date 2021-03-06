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
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script>

    function getrepositoryList(){
	    $.ajax({
	        url : '<%=templateUrl%>/expe/RepositoryListAction',
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
			var num = data.acount;
			//alert(num);
			$("#recAID").html(num);
			
			if(parseInt(data.acount)!=0){
				var th=$("<thead><tr align='center'height='40px' bgcolor='#BFA789' style='color: #FFF;'><th>方名</th><th>证候</th><th>中医病名</th><th>西医病名</th><th>记录时间</th> <th colSpan='2'>相 关 操 作</th></tr></thead>");
				th.appendTo("#repositoryList");
				
				$.each(data.repoArray,function(index) {
					//alert(data.repoArray[index].syndrome);
					var s1 = "<tr align='center' height='40px' bgcolor='#FFFFFF' style='font-size: 16px;color: #000;'><td>"+(index+1)+"</td>"  ;
					var s2 = "<tr><td class=\"offAccount\"><a title=\"查看\" target=\"_blank\" href='OpenRepository?repoId="+data.repoArray[index].repoId+"'>"+data.repoArray[index].presName+"</a></td>";
					var s3= "<td>"+data.repoArray[index].syndrome+"</td>";
					var s4= "<td>"+data.repoArray[index].chinDise+"</td>";
					var s5= "<td>"+data.repoArray[index].westDise+"</td>";
					var s6 = "<td>"+data.repoArray[index].time+"</td>";
					var s7= "<td class=\"offAccount\"><a title=\"修改一下\" href='UpdateRepositoryAction?repoId="+data.repoArray[index].repoId+"'>修改</a></td>";
					var s8="<td class=\"offAccount\"><a title=\"删除\" href='javascript:void(0)' id="+data.repoArray[index].repoId+" class='delete'>删除</a></td></tr>";
					var tr=$(s2+s3+s4+s5+s6+s7+s8);
				    tr.appendTo("#repositoryList");
				});
				$('#repositoryList').show();
				 $(".delete").click(function (){
					 var statu=confirm("确定删除该处方记录?");
						if(!statu){
							return false;
						}
					 var repoId = $(this).attr("id");
					 $.ajax({
					        url : '<%=templateUrl%>/expe/DeleteRepository?repoId='+repoId,
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
							//alert($("#"+repoId).attr("id"));
							$("#"+repoId).parent().parent().remove();
							$("#recAID").html($("#repositoryList tr").length-1);
							if($("#repositoryList tr").length==1){
								$("#repositoryList thead").remove();
								$("#repositoryList").hide();
							}
						}
				   });
			}
		}
	}
	window.onload = function() {
		getrepositoryList();
		$('#repositoryList').hide();
		$("#recAID").click(function(){
			$('#repositoryList').toggle();
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
<div><img src="${url}/imgs/left.png"/>&nbsp;<span style="font-family:'仿宋';font-size:33px;color:#c9b28b">我的知识库</span>
		&nbsp;<img src="${url}/imgs/right.png"/></div>

	<div class="my_dis_diray">
		<div class="my_dis_diray_con">
		
			<div class="mg_info" style="font-family:'宋体';font-size: 18px;">
				<h3>
					总共有（<a id="recAID" href="javascript:void(0)">0</a>）篇开方记录
				</h3>
				<table id="repositoryList" width="780" border="0" style="font-weight:bold">
                   </table>
			</div>
			<br/>
			<form action="NewRepositoryAction" method="post">
		<div align="right">
		 <input type="submit" id="NewRepository" value="记录新的处方" style="font-family:'宋体';font-size: 18px;">
		</div>
		</form>
			
		</div>
	</div>

</body>

</html>
