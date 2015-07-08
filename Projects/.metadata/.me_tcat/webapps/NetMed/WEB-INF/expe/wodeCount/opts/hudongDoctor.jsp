<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="dbmanager" class="com.Bean.db_manager"></jsp:useBean>
<%@ page language="java" import="java.sql.*" %>
<font size=3>互动医生</font>
<br />
<%
	String id = session.getAttribute("username").toString();
	out.println(id);
	String sql = "select expe_name,indi_resu from expe_regi where expe_id=(select expe_id from memb_cons_info where memb_id='+id+' limit 1)";
	Connection connect = null;
	ResultSet rs = null;
	try {
		connect = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/netmed", "root",
				"xianggen");
		Statement stmt = connect.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		rs = stmt.executeQuery(sql);
	} catch (SQLException ex) {
		System.err.println("error");
	}
	
		while (rs.next()) 
		{
			out.println("<p><font size=2>"+"<b>"+"<a href='javascript:void(0)'>"+rs.getString(1)+"</a></b>"+": "+ rs.getString(2) +"</font></p>");
		}
	
%>
