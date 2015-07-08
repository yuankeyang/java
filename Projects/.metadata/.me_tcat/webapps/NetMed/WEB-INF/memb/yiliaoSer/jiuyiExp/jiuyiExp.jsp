<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.Date"%>
<%@ page language="java" import="java.sql.*"%>
<%
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	String userId = (String) session.getAttribute("username");
	userId="xianggen";
%>
<!DOCTYPE>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${url}/css0623/style.css"/>
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script>
    function getJiuyiJinYanList(){
	    $.ajax({
	        url : '<%=templateUrl%>/user/JiuyiExpListAction',
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
			//alert("有错误，请刷新页面");
		}
		function succFunction(data) {
			//未读消息条数
			var num = data.acount;
			//alert(num);
			$("#recAID").html(num);
			if(parseInt(data.acount)!=0){
				var th=$("<thead><tr align='center'height='40px' bgcolor='#BFA789' class='xu' style='color: #FFF;'><th width='5%'>[编号]</th> <th width='20%'>[题目]</th><th width='20%'>[发表时间]</th> <th width='10%' colSpan='2'>[相关操作]</th></tr></thead>");
				th.appendTo("#articleList");
				$.each(data.JiuyiExpArray,function(index) {
					//alert(data.OfflineConsultArray[index].electronic_record);
					var s1 = "<tr align='center' height='40px' bgcolor='#FFFFFF' style='font-size: 16px;color: #000;'><td>"+(index+1)+"</td>";
					var s2 = "<td><a target=\"_blank\" title=\"查看详情\" href='OpenJiuyiExp?JiuyiExp_Id="+data.JiuyiExpArray[index].JiuyiExp_Id+"'>"+data.JiuyiExpArray[index].title+"</a></td>";
					var s3 = "<td>"+data.JiuyiExpArray[index].time+"</td>";
					var s4= "<td><a title=\"修改一下\" href='UpdateJiuyiExpAction?JiuyiExp_Id="+data.JiuyiExpArray[index].JiuyiExp_Id+"'>更新</a></td>";
					var s5="<td><a href='javascript:void(0)' title=\"删除它\" id="+data.JiuyiExpArray[index].JiuyiExp_Id+" class='delete'>删除</a></td></tr>";
					var tr=$(s1+s2+s3+s4+s5);
				    tr.appendTo("#articleList");
				});
				 $('#articleList').show();
				 $(".delete").click(function (){
					 var statu=confirm("确定删除该就医经验?");
						if(!statu){
							return false;
						}
					 
					 var JiuyiExp_Id = $(this).attr("id");
					 $.ajax({
					        url : '<%=templateUrl%>/user/DeleteJiuyiExp?JiuyiExp_Id='+JiuyiExp_Id,
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
							$("#"+JiuyiExp_Id).parent().parent().remove();
							$("#recAID").html($("#articleList tr").length-1);
							if($("#articleList tr").length==1){
								$("#articleList thead").remove();
								$("#articleList").hide();
							}
						}
				   });
			}
		}
	}
	window.onload = function() {
		getJiuyiJinYanList();
		$('#articleList').hide();
		$("#recAID").click(function(){
			$('#articleList').toggle();
		 });
	};
</script>
</head>
<body>
	<div id="right">
	<div><img src="${url}/imgs/left.png"/>&nbsp;<span style="font-family:'仿宋';font-size:33px;color:#c9b28b">就医经验</span>
		&nbsp;<img src="${url}/imgs/right.png"/></div>
		
		<div class="my_dis_diray">
		<div class="my_dis_diray_con">
		
			<div class="mg_info" style="font-family: '宋体';font-size: 18px;">
				<h3>
					<h3>总共有<a id="recAID" href="javascript:void(0)"></a>篇就医经验</h3>
				</h3>
				<table id="articleList" cellspacing="1" cellpadding="0" width="800" border="1" id="table"  align="center" style="text-align: center;">
                </table>
			</div>
			<br/><br/>
			<form action="NewJiuyiExpAction" method="post">
		<div class="" align="right">
		 <input type="submit" id="newjiuyiExp" value="新建就医经验" style="font-family: '宋体';font-size: 18px;">
		</div>
		</form>
		</div>
	</div>

	</div>
</body>

</html>
