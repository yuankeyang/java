<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <jsp:useBean id="dbmanager" class="com.Bean.db_manager"></jsp:useBean>
<%

//退出登录后删除session,并置用户状态为false

String expename=(String)session.getAttribute("expename");
String sql2=null;
if(expename!=null){
	sql2="update expe_regi set state=0 where expe_id='"+expename+"'";
	System.out.println("专家    update state=0!!!"+expename);
}else {
	sql2="update memb_regi set state=0 where memb_id='"+session.getAttribute("username")+"'";
	System.out.println("会员   update state=0 !!!"+session.getAttribute("username"));
}
if(dbmanager.update(sql2)==0){
	System.out.println("database update state=0 !!!");
}
session.invalidate();
String index= request.getScheme() + "://" + request.getHeader("host") +request.getContextPath()+"/welcome";
response.sendRedirect(index);

%>