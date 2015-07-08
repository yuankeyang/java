<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dbmanager" class="com.Bean.db_manager"></jsp:useBean>
<%@ page language="java" import="java.sql.*" %>
<%
String templateUrl = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath();
String memb_id=request.getParameter("memb_id");
String memb_mobile=request.getParameter("memb_mobile");
String memb_mail=request.getParameter("memb_mail");
String username=(String)session.getAttribute("username");
String sql="update memb_regi set memb_id='"+
memb_id+"',phon_numb='"+memb_mobile+
"',memb_emai='"+memb_mail+"'"+
" where memb_id='"+username+"'";
System.out.println(sql);
if(dbmanager.update(sql)==0){
	session.invalidate();
	session.setAttribute("username", memb_id);
	response.sendRedirect(templateUrl);
}else{
	session.invalidate();
	response.sendRedirect(templateUrl);
}
%>