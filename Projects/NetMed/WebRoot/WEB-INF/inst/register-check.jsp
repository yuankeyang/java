<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:useBean id="instBean" class="com.Bean.InstBean" scope="request">
<jsp:setProperty property="*" name="instBean"/>
</jsp:useBean>
<jsp:useBean id="regist" class="com.Bean.InstRegister" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container">
<%
	String inst_id=request.getParameter("inst_id");
	String inst_name=request.getParameter("inst_name");
	String inst_clas=request.getParameter("inst_clas");
	String busi_scop=request.getParameter("busi_scop");
	String lega_repr_name=request.getParameter("lega_repr_name");
	String lega_repr_id=request.getParameter("lega_repr_id");
	String busi_lice=request.getParameter("busi_lice");
	String orga_code=request.getParameter("orga_code");
	String inst_prov=request.getParameter("inst_prov");
	String inst_city=request.getParameter("inst_city");
	String inst_coun=request.getParameter("inst_coun");
	String inst_over=request.getParameter("inst_over");
	String phone=request.getParameter("phone");
	String telephone=request.getParameter("telephone");
	String email=request.getParameter("email");
	String password=request.getParameter("password");
	
// 	System.out.println(inst_name);
// 	System.out.println(inst_clas);
// 	System.out.println(busi_scop);
// 	System.out.println(lega_repr_name);
// 	System.out.println(lega_repr_id);
// 	System.out.println(busi_lice);
// 	System.out.println(orga_code);
// 	System.out.println(inst_prov);
// 	System.out.println(inst_city);
// 	System.out.println(inst_coun);

	instBean.setInst_id(inst_id);
	instBean.setInst_name(inst_name);
	instBean.setInst_clas(inst_clas);
	instBean.setBusi_scop(busi_scop);
	instBean.setLega_repr_id(lega_repr_id);
	instBean.setLega_repr_name(lega_repr_name);
	instBean.setBusi_lice(busi_lice);
	instBean.setOrga_code(orga_code);
	instBean.setInst_prov(inst_prov);
	instBean.setInst_city(inst_city);
	instBean.setInst_coun(inst_coun);
	instBean.setInst_line_phon(phone);
	instBean.setInst_mobi_phon(telephone);
	instBean.setInst_emai(email);
	instBean.setInst_pass(password);
	regist.setInstBean(instBean);
	if(regist.register()){
%>
<h2 class="page-header">注册成功!</h2>
<script type="text/javascript">
function tiaozhuan(){
	window.location.href="<s:url namespace="/" action="welcome"/>";
}
window.setTimeout("tiaozhuan();",1000);
 </script>
 <%}else{%>
 <h2 class="page-header">注册失败!</h2>
 <p>请严格按照格式输入信息。。。</p>
<script type="text/javascript">
function tiaozhuan(){
	window.location.href="<s:url namespace="/inst" action="inst-regi"/>";
}
window.setTimeout("tiaozhuan();",1000);
 </script>
 <%} %>
</div>
</body>
</html>