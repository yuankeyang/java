<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<% String templateUrl = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath(); %>
<% 
 String membId = (String) session.getAttribute("username");
 String expeId = (String) session.getAttribute("expename");
 String inst=(String) session.getAttribute("instname");
  %>
<% if(membId!=null){ %>
		<li><s:a namespace="/user" action="user-center"><%=membId %></s:a></li>
		<li><s:a namespace="/" action="exit">退出</s:a></li>
		<% }else if(expeId!=null){%>
		<li><s:a namespace="/expe" action="expe-center"><%=expeId %></s:a></li>
		<li><s:a namespace="/" action="exit">退出</s:a></li>
		<%} else if(inst!=null){%>
		<li><s:a namespace="/inst" action="inst-center"><%=inst %></s:a></li>
		<li><s:a namespace="/" action="exit">退出</s:a></li>
		<%}else{ %>
			<li><a id="login-btn" href="javascript:void(0)">登录</a></li>
			<li><a href="#">注册</a>
				<ul>
					<li><s:a namespace="/user" action="user-regi">会员注册</s:a></li>
					<li><s:a namespace="/expe" action="expe-regi">专家注册</s:a></li>
					<li><s:a namespace="/inst" action="inst-regi">机构注册</s:a></li>
				</ul>
			</li>
			<%}%>