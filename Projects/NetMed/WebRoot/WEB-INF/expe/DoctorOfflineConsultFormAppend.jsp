<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<jsp:include page="../include/core_head.jsp"></jsp:include>
<%
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	//电子病历，唯一标识
	String electronic_record = request
			.getParameter("electronic_record");
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../include/topbarhead.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${url}/css/article.css" />
<link rel="stylesheet" type="text/css" href="${url}/css/style.css" />
<link rel='stylesheet' href='${url}/schedule/jquery-ui-1.11.4/jquery-ui.css' />
<script type="text/javascript" src='${url}/schedule/jquery-ui-1.11.4/jquery-ui.js'></script>

<title>修改离线咨询</title>
<style type="text/css">
.consultInput{
   border-radius:10px;
   box-shadow:2px;
   border-color:#BFA789;
}
</style>

</head>
<script type="text/javascript">

$(function() {
	if('<%=electronic_record%>'!=""){
					getGeRenInfo('<%=electronic_record%>');
	}
	function getGeRenInfo(electronic_record) {
					$.ajax({
		            url : '<%=templateUrl%>/expe/PatientInfoAction?electronic_record=<%=electronic_record%>',
		            type : 'POST',
		            contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				    dataType : 'json',
				    timeout : 15000,
				    cache : true,
					error : function(){alert("请刷新页面!!");}, //错误执行方法  
					success : function(data) {
							$.each(data.ArchArray, function(index) {
								//alert(data.content);
								$("#name").val(data.ArchArray[index].name);
								$("#sex").val(data.ArchArray[index].sex);
								$("#age").val(data.ArchArray[index].age);
								});
						}//成功执行方法  
				});
	}
});



 function split( val ) {
      return val.split( /,\s*/ );
    }
    function extractLast( term ) {
      return split( term ).pop();
    }

function checkSubmit(){
	if($('#medical_advice').val()==""){
		$("#medical_advice").select();
		$("#medical_advice").focus();
	}else{
		submit();
	}
}
function submit(){
	$.ajax({
        url : '<%=templateUrl%>/expe/DoctorOfflineConsultActionAppend',
		type : 'POST',
		data:"electronic_record=<%=electronic_record%>&suggest1="+$('#suggest1').val()+"&suggest2="+$('#suggest2').val()+"&medical_advice="+$('#medical_advice').val(),
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		dataType : 'text',
		timeout : 15000,
		cache : true,
		errot:erryFunction,
		success : succFunction
	//成功执行方法  
	});
	function erryFunction() {
		alert("请刷新页面！");
	}
	function succFunction(data) {
		var data = String($.trim(data)); 
		if(data=="yes"){
     		alert("提交成功!页面即将关闭");
	     	window.close();
	    }else{
	    	 alert("请重新操作！");
	   }
		//window.location="diaryMan";
	}
}


//获得辩证
function getMidecalZheng(data){
	$.ajax({
        url : '<%=templateUrl%>/expe/MidecalZhengAction?midecalZheng='+data,
        type : 'POST',
        contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		 dataType : 'json',
		 timeout : 15000,
		 cache : true,
		 error : erryFunction, //错误执行方法  
		 success : succFunction	//成功执行方法  
		});
		function erryFunction() {alert("请刷新页面！");}
		function succFunction(data) {
			//alert("sdaf");
			var ar=new Array();
			$.each(data.MidecalZhengArray,function(index){
				ar[index]=data.MidecalZhengArray[index].name;
			});
			
			$("#suggest1")
			.bind("keydown",function(event){
			if(event.keyCode==$.ui.keyCode.TAB &&
			$(this).data("ui-autocomplete").menu.active){
			event.preventDefault();
			}
			})
			.autocomplete({
			source:function(request, response){
			response( $.ui.autocomplete.filter(
            ar, extractLast( request.term ) ) );
			},
			minLength: 0,
			focus: function() {
          // 防止在获得焦点时插入值
          return false;
        	}, 
        select: function( event, ui ) {
          var terms = split( this.value );
          // 移除当前输入
          terms.pop();
          // 添加被选项
          terms.push( ui.item.value );
          // 添加占位符，在结尾添加逗号
          terms.push( "" );
          this.value = terms.join( "," );
          return false;
        }
			});
// 			$("#suggest1").bind("input.autocomplete",function(){
			
// 			$(this).autocomplete("search",this.value);
// 			});
	};
}

//获得辨病
function getMidecalDisease(data){
	$.ajax({
        url : '<%=templateUrl%>/expe/MidecalDiseaseAction?midecalDisease='+data,
        type : 'POST',
        contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		 dataType : 'json',
		 timeout : 15000,
		 cache : true,
		 error : erryFunction, //错误执行方法  
		 success : succFunction	//成功执行方法  
		});
		function erryFunction() {alert("请刷新页面！");}
		function succFunction(data) {
			//alert("sdaf");
			var ar=new Array();
			$.each(data.MidecalDiseaseArray,function(index){
				ar[index]=data.MidecalDiseaseArray[index].name;
			});
			
			$("#suggest2")
			.bind("keydown",function(event){
			if(event.keyCode==$.ui.keyCode.TAB &&
			$(this).data("ui-autocomplete").menu.active){
			event.preventDefault();
			}
			})
			.autocomplete({
			source:function(request, response){
			response( $.ui.autocomplete.filter(
            ar, extractLast( request.term ) ) );
			},
			minLength: 0,
			focus: function() {
          	// 防止在获得焦点时插入值
          	return false;
        	}, 
        	select: function( event, ui ) {
         	 var terms = split( this.value );
	          // 移除当前输入
	          terms.pop();
	          // 添加被选项
	          terms.push( ui.item.value );
	          // 添加占位符，在结尾添加逗号
	          terms.push( "" );
	          this.value = terms.join( "," );
	          return false;
       		 }
			});
			
	};
}




//获取电子病历表
function getElectronic_record(electronic_record){
	 $.ajax({
            url : '<%=templateUrl%>/expe/ElectronicRecordAction?electronic_record=<%=electronic_record%>',
			type : 'POST',
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			dataType : 'json',
			timeout : 15000,
			cache : true,
			error : erryFunction, //错误执行方法  
			success : succFunction
				//成功执行方法  
				});
		function erryFunction() {
			alert("请刷新页面！");
		}
		function succFunction(data) {
			$("#username").html(data.userId);
			$('#illn_desc').val(data.illn_desc);
			$('#fami_hist').val(data.fami_hist);
			$('#pers_hist').val(data.pers_hist);
			if(parseInt(data.fileAccount)!=0){
				$("#fileList").html("附件：");
				$.each(data.file, function(index) {
					//alert(index);
					$("#fileList").append("<li><a target=\"_blank\" href='expe/FileDownloadAction?fileNumber="+index+"&fileName="+data.file[index].fileName+"&electronic_record="+'<%=electronic_record%>'+"'>"+data.file[index].fileName+"</a></li>");
				});
			}
		}
		;
	}
	
function getToolBoxList(){
	    $.ajax({
	        url : '<%=templateUrl%>/expe/RepositoryListAction',
			type : 'POST',
			contentType : "application/json; charset=utf-8",
			dataType : 'json',
			timeout : 15000,
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
			$("#toolBoxList").children().remove();
			
			$("#recAID").html(num);
			
			if(parseInt(data.acount)!=0){
				
				var th=$("<tr> <th>方名</th><th>适应证</th><th>中医病名</th><th>中医病名</th><th>&nbsp</th></tr>");
				th.appendTo("#toolBoxList");
				$.each(data.repoArray,function(index) {
					
					var s1 = "<tr><td>"+(index+1)+"</td>";
					var s2 = "<tr><td class=\"offAccount\"><a target=\"_blank\" href='expe/OpenRepository?repoId="+data.repoArray[index].repoId+"'>"+data.repoArray[index].presName+"</a></td>";
					var s3= "<td>"+data.repoArray[index].syndrome+"</td>";
					var s4= "<td>"+data.repoArray[index].chinDise+"</td>";
					var s5= "<td>"+data.repoArray[index].westDise+"</td>";
					var s6="<td class=\"offAccount\"><a title=\"加入到当前诊断中\" href='javascript:void(0)' id="+data.repoArray[index].repoId+" class='add'>添加</a></td></tr>";
					var tr=$(s2+s3+s4+s5+s6);
				    tr.appendTo("#toolBoxList");
				});
				$('#toolBoxList').show();
				 $(".add").click(function (){
					 var repoId = $(this).attr("id");
					 $.ajax({
				            url : '<%=templateUrl%>/expe/RepositoryForRead?repoId='+repoId,
				            type : 'POST',
				            contentType: "application/x-www-form-urlencoded; charset=utf-8", 
						    dataType : 'json',
						    timeout : 8000,
						    cache : true,
							error : erryFunction, //错误执行方法  
							success : succFunction	//成功执行方法  
						});
						function erryFunction() {alert("正获取知识库，请重试!!");}
						function succFunction(data) {
							$("#dialog").dialog("close");
							$("#toolBoxList tr").remove();
							if($('#medical_advice').val()==""){
								$('#medical_advice').val($('#medical_advice').val()+data.presName+" : "+data.mediMate+"  西药："+data.westMedi);
							}else{
								$('#medical_advice').val($('#medical_advice').val()+"\n"+data.presName+" : "+data.mediMate+"  西药："+data.westMedi);
							}
							
					};
				   });
			}
		}
	}	
function toolbox(){
 $("#dialog").dialog("open");
}

window.onload = function(){
	if('<%=electronic_record%>'!=""){
			getElectronic_record('<%=electronic_record%>');
		}
		getMidecalZheng('bz1.');
		
		getMidecalDisease('zb1.');

	$('#dialog').dialog({
		  open:function(){//对话框打开时初始化
			  getToolBoxList();
		  },
	    autoOpen: false,
	    height:480,
	    width:850,
	    modal:true,
	    title:'我的知识库',
	   draggable: false,
	   buttons:[{
	     text:"关闭",
	     click:function(){
	       $(this).dialog("close");
	     }
	   }]
	  });	
};
</script>
<style type="text/css">
   .offAccount a{ color:#0000ff;text-decoration:none;font-weight:bold}
   .offAccount a:hover{color:#ff0000}
   .offAccount a:active{color:#ff0000} 
.ui-autocomplete {
    max-height: 200px;
    overflow-y: auto;
    /* prevent horizontal scrollbar */
    overflow-x: hidden;
    /* add padding to account for vertical scrollbar */
    padding-right: 20px;
}
/* IE 6 doesn't support max-height
 * we use height instead, but this forces the menu to always be this tall
 */
* html .ui-autocomplete {
    height: 100px;
}  
</style>
<body>
<jsp:include page="../include/oldtopbar.jsp"></jsp:include>
	<div style="margin-left:300px;margin-top:10px">
		<p
			style="background:url(${url}/image/suggestionbg.png) no-repeat;font-size:18px;font-weight:400;width:600px">
			&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;患者信息：<label
				id="username"></label>
		</p>
		<p>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;姓名：<input type="text" style="width:45px;border:0;font-weight:bold" name="name" id="name"/>
		&nbsp; &nbsp;&nbsp;性别：<input type="text" style="width:35px;border:0;font-weight:bold" name="sex" id="sex"/>
		&nbsp; &nbsp;&nbsp;年龄：<input type="text" style="width:45px;border:0;font-weight:bold" name="age" id="age"/></p>
		
	   <div style="text-align:center">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           <a target="_blank" href='expe/ArchInfoDetailForDoctorRead?electronic_record=<%=electronic_record%>'><font size="4px" color="#0000ff">查看患者的电子健康病历</font></a>
       </div>
       
		<div style="margin-top:10px">
			<div style="margin-left:30px;">
				<img src="${url}/image/angle_blue.png" />&nbsp;&nbsp;&nbsp;&nbsp; <label
					style="font-size:18px">病情描述</label>
			</div>
			<textarea id="illn_desc" name="illn_desc" class="consultInput"
				style="width:720px;height:100px;overflow-y:scroll;resize:none;margin-left:30px;border:solid 2px #BFA789"
				disabled="disabled"></textarea>
		</div>

		<div>
			<div style="margin-left:30px;float:left">
				<img src="${url}/image/angle_blue.png" />&nbsp;&nbsp;&nbsp;&nbsp; <label
					style="font-size:18px">个人病史</label>
			</div>
			<br />
			<div style="float:none;margin-top:20px">
				<textarea id="pers_hist" name="pers_hist" class="consultInput"
					style="width:720px;height:100px;overflow-y:scroll;resize:none;margin-left:30px;border:solid 2px #BFA789"
					disabled="disabled"></textarea>
			</div>

		</div>

		<div style="margin-top:30px">
			<div style="margin-left:30px;float:left">
				<img src="${url}/image/angle_blue.png" />&nbsp;&nbsp;&nbsp;&nbsp; <label
					style="font-size:18px">家族病史</label>
			</div>
			<br /> <br />
			<div style="float:none">
				<textarea id="fami_hist" name="fami_hist" class="consultInput"
					style="width:720px;height:100px;overflow-y:scroll;resize:none;margin-left:30px;border:solid 2px #BFA789"
					disabled="disabled"></textarea>
			</div>
			<br />
			<p
				style="background:url(${url}/image/suggestionbg.png) no-repeat;font-size:18px;font-weight:400;width:600px">&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;专家诊断：</p>
		</div>
		<form action="DoctorOfflineConsultAction"
			name="DoctorOfflineConsultAction" method="post"
			id="DoctorofflineConsult">
			<input type="hidden" name="electronic_record" id="electronic_record"
				value="<%=electronic_record%>">
				
			<div style="margin-left:30px;float:left">
				<div style="margin-top:20px;">
					<img src="${url}/image/angle_blue.png" />&nbsp;&nbsp;&nbsp;&nbsp;
					<label style="font-size:18px">辨病结果</label>
				</div>
				<table style="margin-top:15px;font-size:18px;"
					border=0 width="620">
					<tr>
						<td>大类病名：</td>
						<td><select id="firstDisease"
							onchange="getMidecalDisease(this.value);" style="width:200px;">
							    <option value="000" selected>-请选择大类病名-</option>
								<option value="zb1.">传染病、寄生虫病</option>
								<option value="zb2.">脑系病</option>
								<option value="zb3.">心系病</option>
								<option value="zb4.">肺系病</option>
								<option value="zb5.">脾系病</option>
								<option value="zb6.">肝系病</option>
								<option value="zb7.">肾系病</option>
								<option value="zb8.">男性前阴病类</option>
								<option value="zb9.">颈瘿病类、乳房病类</option>
								<option value="zb10.">疮疡病类</option>
								<option value="zb11.">皮肤病类</option>
								<option value="zb12.">妇女经、带、杂病类</option>
								<option value="zb13.">胎、产及其疾病</option>
								<option value="zb14.">新生儿病、小儿特发病</option>
								<option value="zb15.">眼病类</option>
								<option value="zb16.">耳鼻咽喉口齿病类</option>
								<option value="zb17.">肛肠病类</option>
								<option value="zb18.">躯体痹、痿、瘤等病类</option>
								<option value="zb19.">时行病、中毒及其他病类</option>
								<option value="zb20.">症状性名称</option>
						</select>
						</td>
						
					</tr>
					
					<tr>
					<td>具体病名：</td>
					<td><input type="text" id="suggest2" name="suggest2" style="width:400px" placeholder="请输入病名"/></td>
					</tr>
					
				</table>
			</div>	
				
			<div style="margin-left:30px;float:left">
				<div style="margin-top:15px;">
					<img src="${url}/image/angle_blue.png" />&nbsp;&nbsp;&nbsp;&nbsp;
					<label style="font-size:18px">辩证结果</label>
				</div>
				<table style="margin-top:14px;font-size:18px;"
					border=0 width="620">
					<tr>
						<td>大类证名：</td>
						<td><select id="first"
							onchange="getMidecalZheng(this.value);" style="width:200px;">
							    <option value="000" selected>-请选择大类证候-</option>
								<option value="bz1.">基本虚证</option>
								<option value="bz2.">基本实证</option>
								<option value="bz3.">虚实夹杂证</option>
								<option value="bz4.">心系证</option>
								<option value="bz5.">肺系证</option>
								<option value="bz6.">脾系证</option>
								<option value="bz7.">肝系证</option>
								<option value="bz8.">肾系证</option>
								<option value="bz9.">脏腑兼证</option>
								<option value="bz10.">卫表肌肤证</option>
								<option value="bz11.">头面官窍证</option>
								<option value="bz12.">经脉筋骨证</option>
								<option value="bz13.">其他证</option>
								<option value="bz14.">期、度、型</option>
						</select>
						</td>
						
					</tr>
					
					<tr>
					<td>具体证名：</td>
					<td><input type="text" id="suggest1" name="suggest1" style="width:400px" placeholder="请输入证名"/></td>
					</tr>
					
				</table>
			</div>
			
			
			<br /> <br /> <br /> <br />
		
		
			<div style="margin-top:180px">
				<div style="margin-left:30px;float:left">
					<img src="${url}/image/angle_blue.png" />&nbsp;&nbsp;&nbsp;&nbsp;
					<label style="font-size:18px">专家建议</label>
					<!-- 知识库关联专家工具箱 -->&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="expertToolbox" name="expertToolbox" type="button" value="查看知识库" onclick="toolbox();">
				</div>
				<br /> <br />
				<div style="float:none"> 
					<textarea id="medical_advice" name="medical_advice" class="consultInput"
						style="width:720px;height:100px;overflow-y:scroll;resize:none;margin-left:30px;border:solid 2px #BFA789"></textarea>
				</div>

			</div>
            <ul id="fileList" style="list-style:none;"></ul>
			<div style="margin-top:30px;height:80px;width:700px;">
				<div id="mysubmit"
					style="float:right;width:420px;margin-left:170px;">
					<img src="${url}/image/largebutton_subsave.png"
						onclick="checkSubmit();" style="float:right;">
				</div>
			</div>

		</form>

	</div>
	
 <div id="dialog" style="display: none">
	<div class="user_center_bigtitle" style="text-align:center"> <span><h3>我的知识库</h3></span> 
   <hr></hr>
	</div>
	<div class="my_dis_diray">
		<div class="my_dis_diray_con">
			<div class="mg_info" style="font-family:'宋体';font-size: 18px;">
					<h3 style="text-align:center">总共有（<a id="recAID" href="javascript:void(0)">0</a>）篇开方记录</h3>
				<table id="toolBoxList" width="700" border="1" id="table" bordercolor="#FFFFFF" align="center" style="text-align: left;">
                   </table>
			</div>
			
		</div>
	</div>
  </div>
	<!--版权信息等-->
   <jsp:include page="/WEB-INF/bottom/footer.jsp"></jsp:include>

</body>
</html>