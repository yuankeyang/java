<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<%
String templateUrl = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath();
request.setAttribute("url", templateUrl);
%>