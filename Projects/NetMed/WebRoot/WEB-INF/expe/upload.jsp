<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%
String id=request.getParameter("exp_id");
if(id==null||id.equals("")) {
%>
<script type="text/javascript">
alert("上传的图片大小不能超过500KB！");
</script>
<%
}
 %>
</head>
<body>
<s:form action="uploadImg" method="POST" enctype="multipart/form-data">
	<input type="hidden" name="exp_id" value="<%=id %>"/>
     <s:file name="upload" label="File"/>
     <s:submit cssClass="btn btn-primary"/>
 </s:form>
</body>
</html>