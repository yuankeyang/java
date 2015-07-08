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
<link rel="stylesheet" type="text/css" href="${url}/css/style.css" />
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script>
	function showDetail() {
		
		document.getElementById('title').innerHTML="";
		document.getElementById('author').innerHTML="";
		document.getElementById('source').innerHTML="";

		document.getElementById('title2').innerHTML="";
		document.getElementById('author2').innerHTML="";
		document.getElementById('source2').innerHTML="";
		
		var title="<a href=\"javascript:void(0);\" onclick=\"alert('正在实现')\">【标题】：杨云汉老中医治疗失眠经验</a>";
		var author="【作者】：李俊彪、彭靖欧";
		var source="【来源】：新医学, 1983, (02), 59-62";
		
		var title2="<a href=\"javascript:void(0);\" onclick=\"alert('正在实现')\">【标题】：归脾汤治疗心悸失眠68例</a>";
		var author2="【作者】：冯章巧、吴红霞";
		var source2="【来源】：中国民间疗法, 2006, (10), 33-34";
		
		$("#title").html($("#title").html()+title);
		$("#author").html($("#author").html()+author);
		$("#source").html($("#source").html()+source);
		
		$("#title2").html($("#title2").html()+title2);
		$("#author2").html($("#author2").html()+author2);
		$("#source2").html($("#source2").html()+source2);
	}

	function check() {
		if ($('#search_ToolBox').val() == "") {
			alert("输入框不能为空!");
		} else {
			$('#SerachToolBox').submit();
		}
	}
</script>
<style type="text/css">
.specil li {
	float: left;
	text-align: center;
}

.specil ul {
	list-style: none;
	margin-left: 30px;
	line-height: 52px;
}

.specil ul li {
	margin-left: 70px;
}

#search_ToolBox {
	width: 65%;
	height: 40px;
	float: right;
	border-radius: 5px;
}

.menu {
	padding: 0;
	margin: 0;
	list-style-type: none;
}

.menu li {
	background: #BFA789;
	margin-right: 1px;
	float: left;
	border-radius: 5px
}

.menu li a {
	display: block;
	width: 80px;
	text-align: center;
	height: 32px;
	line-height: 32px;
	color: #fff;
	font-size: 13px;
	text-decoration: none;
}

.cur {
	background: #D96C00;
	font-weight: bold;
}

.offAccount a {
	color: #0000ff;
	text-decoration: none;
	font-weight: bold;
}

.offAccount a:hover {
	color: #ff0000
}

.offAccount a:active {
	color: #ff0000
}
</style>

</head>

<body>
<div><img src="${url}/imgs/left.png"/>&nbsp;&nbsp;<span style="font-family:'仿宋';font-size:33px;color:#c9b28b">专业知识库</span>
		&nbsp;&nbsp;<img src="${url}/imgs/right.png"/></div>
	<div style="margin-top:10px">
		<font size="5" style="text-algin:left" color="#BFA789">我的专科：</font>&nbsp;<font
			size="4" color="#BFA789">中医内科>>中医脑病</font>
		
	</div>

	<div style="margin-top: 50px" align="center">

		<h2>
			<span><label style="font-family:'宋体'">名医名家脑病名方验案</label></span>
		</h2>
	
	
		<div>
			<div style="padding-top:10px;">
				<img src="${url}/image/normalbutton_a.png" onclick="check();"
					style="height: 36px;float: right;margin-right: 120px" />
				<form method="get" id="SerachToolBox" action="FamousPrescrip">
					<input type="text" name="search_ToolBox" id="search_ToolBox"
						placeholder="请输入医家姓名、证型、方名..." maxlength=200; />
				</form>
			</div>

			<br /> <br />
			<div class="specil">

				<ul class="menu" id="menu">
					<li class="offAccount"><a href="javascript:void(0)"
						onclick="alert('功能正在实现！')"><font size="3px">中风</font>
					</a>
					</li>
					<li class="offAccount"><a href="javascript:void(0)"
						onclick="alert('功能正在实现！')"><font size="3px">癫痫</font>
					</a>
					</li>
					<li class="offAccount"><a href="javascript:void(0)"
						onclick="alert('功能正在实现！')"><font size="3px">郁证</font>
					</a>
					</li>
					<li class="offAccount"><a href="javascript:void(0)"
						onclick="showDetail()"><font size="3px">不寐</font>
					</a>
					</li>

					<br />

					<li class="offAccount"><a href="javascript:void(0)"
						onclick="alert('功能正在实现！')"><font size="3px">痿证</font>
					</a>
					</li>
					<li class="offAccount"><a href="javascript:void(0)"
						onclick="alert('功能正在实现！')"><font size="3px">眩晕</font>
					</a>
					</li>
					<li class="offAccount"><a href="javascript:void(0)"
						onclick="alert('功能正在实现！')"><font size="3px">头痛</font>
					</a>
					</li>
					<li class="offAccount"><a href="javascript:void(0)"
						onclick="alert('功能正在实现！')"><font size="3px">痴呆</font>
					</a>
					</li>
				</ul>
			</div>
			
			 <div style="margin-top:50px;float:right;margin-right:450px">
			 
             <ul style="list-style-type:none;text-align:left">
               <li id="title"></li>
               <li id="author"></li>
               <li id="source"></li> 
             </ul>
             
             <ul style="list-style-type:none;text-align:left">
               <li id="title2"></li>
               <li id="author2"></li>
               <li id="source2"></li> 
             </ul>
            </div>

		</div>
       
   
	</div>
</body>
</html>
