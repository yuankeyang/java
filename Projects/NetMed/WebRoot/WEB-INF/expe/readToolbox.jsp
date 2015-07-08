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


<jsp:include page="../include/core_head.jsp"></jsp:include>
<jsp:include page="../include/topbar.jsp"></jsp:include>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${url}/css/style.css"/>
<link rel="stylesheet" type="text/css" href="${url}/css/article.css" />
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script>
    function getToolBoxList(){
	  // var data=encodeURIComponent(JSON.stringify($('#input_doctor').val()),"utf-8");
	  // alert(encodeURI(encodeURI($('#input_doctor').val())));//验证是否在线
	    $.ajax({
	        url : '<%=templateUrl%>/expe/ToolBoxListAction',
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
				var th=$("<thead><tr> <th>序号</th><th>方名</th><th>适应证</th><th>记录时间</th> <th>相 关 操 作</th></tr></thead>");
				th.appendTo("#toolBoxList");
				//alert(data.ToolBoxArray[0].title);
				$.each(data.ToolboxArray,function(index) {
					//alert(data.OfflineConsultArray[index].electronic_record);
					var s5 = "<tr><td>"+(index+1)+"</td>"  ;
					var s1 = "<td class=\"offAccount\"><a target=\"_blank\" href='OpenToolBox?ToolBox_Id="+data.ToolboxArray[index].ToolBox_Id+"'>"+data.ToolboxArray[index].title+"</a></td>";
					var s6= "<td>"+data.ToolboxArray[index].syndrome+"</td>";
					var s2 = "<td>"+data.ToolboxArray[index].time+"</td>";
					var s3= "<td class=\"offAccount\"><a title=\"修改一下\" href='UpdateToolBoxAction?ToolBox_Id="+data.ToolboxArray[index].ToolBox_Id+"'>添加</a></td>";
					//var s4="<td class=\"offAccount\"><a title=\"删除\" href='javascript:void(0)' id="+data.ToolboxArray[index].ToolBox_Id+" class='delete'>删除</a></td></tr>";
					var tr=$(s5+s1+s6+s2+s3);
				    tr.appendTo("#toolBoxList");
				});
				$('#toolBoxList').show();
				 $(".delete").click(function (){
					 //alert("sd");
					 //$(this)获取的是点击的对象，点击的对象是a标签，a标签的上一级的上一级是tr
					 //  
					 var statu=confirm("确定删除该处方记录?");
						if(!statu){
							return false;
						}
					 var ToolBox_Id = $(this).attr("id");
					 $.ajax({
					        url : '<%=templateUrl%>/expe/DeleteToolBox?ToolBox_Id='+ToolBox_Id,
							type : 'POST',
							contentType: "application/x-www-form-urlencoded; charset=utf-8", 
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
							//alert($("#"+ToolBox_Id).attr("id"));
							$("#"+ToolBox_Id).parent().parent().remove();
							$("#recAID").html($("#toolBoxList tr").length-1);
							if($("#toolBoxList tr").length==1){
								$("#toolBoxList thead").remove();
								$("#toolBoxList").hide();
							}
						}
				   });
			}
		}
	}
	window.onload = function() {
		getToolBoxList();
		$('#toolBoxList').hide();
		$("#recAID").click(function(){
			$('#toolBoxList').toggle();
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
	<div class="user_center_bigtitle" style="text-align:center"> <span><h3>我的知识库</h3></span> 
   <hr></hr>
	</div>
	<div class="my_dis_diray">
		<div class="my_dis_diray_con">
			<div class="mg_info" style="font-family: KaiTi_GB2312;font-size: 18px;">
					<h3 style="text-align:center">总共有（<a id="recAID" href="javascript:void(0)">0</a>）篇开方记录</h3>
				<table id="toolBoxList" width="900" border="1" id="table" bordercolor="#FFFFFF" align="center" style="text-align: center;">
                   </table>
			</div>
			
		</div>
	</div>
</div>
</body>
</html>
