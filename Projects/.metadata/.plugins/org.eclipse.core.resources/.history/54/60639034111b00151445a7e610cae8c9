<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<% String templateUrl = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath(); %>
<script>
function exitFunc(name){
	  //alert(name);
      $.ajax({
			url:'<%=templateUrl%>/exit',
			success:function(){
				//alert("success!");
				window.location.href="welcome";  //退出后返回到首页
			},
			error:function(){alert("加载信息错误");},
			async:false
			});
}
</script>
<%
String username=(String)session.getAttribute("username");

if(username==null )//&& cookies==null)
{
	String expename=(String)session.getAttribute("expename");
	if(expename==null){
		String instname=(String)session.getAttribute("instname");
		if(instname==null){
%>
<!--顶端信息-->
<div id="top">
   <div id="leftTop"> <s:a namespace="/" action="welcome">颐健通</s:a>&nbsp;&nbsp;&nbsp;&nbsp; <a href="javascript:void(0)" id="loginbtn">登录</a> </div>
  <div id="rightTop">
  <ul id="navul">
  <li>
   	<a href="#">注册</a>
   	<ul>
  	<li><s:a namespace="/user" action="user-regi">会员注册</s:a></li>
  	<li><s:a namespace="/expe" action="expe-regi">专家注册</s:a></li>
  	<li><s:a namespace="/inst" action="inst-regi">机构注册</s:a></li>
  	</ul>
  </li>
  </ul>
   </div>
</div><%}else{%>
<div id="top">
    <div id="leftTop">
 		<s:a namespace="/" href="welcome">颐健通</s:a>&nbsp;&nbsp;&nbsp;&nbsp;
 		<s:a href="inst/inst-center">机构中心</s:a>
    </div>
     <div id="rightTop">
      <label>你好！ <%=instname%></label>&nbsp;&nbsp;<span>
    <a href="javascript:void(0)" onclick="exitFunc()">退出</a></span>
 		
    </div>
</div>
	<%}
}else{%>
	<div id="top">
    <div id="leftTop">
    <s:a namespace="/" href="welcome">颐健通</s:a>&nbsp;&nbsp;&nbsp;&nbsp;
    <s:a href="expe/expe-center">专家中心</s:a>
    </div>
     <div id="rightTop">
     <label>你好！ <%=expename %></label>&nbsp;&nbsp;<span><a href="javascript:void(0)" onclick="exitFunc('<%=expename%>')">退出</a></span>
 		
    </div>
  </div>
	<%} %>
<%}else{%>
<div id="top">
    <div id="leftTop">
    <s:a namespace="/" href="welcome">颐健通</s:a>&nbsp;&nbsp;&nbsp;&nbsp;
    <s:a href="user/user-center">用户中心</s:a>
    </div>
     <div id="rightTop">
     <label>你好！ <%=username %></label>&nbsp;&nbsp;<span><a href="javascript:void(0)" onclick="exitFunc('<%=username%>')">退出</a></span>
    </div>
</div>

<%}%>