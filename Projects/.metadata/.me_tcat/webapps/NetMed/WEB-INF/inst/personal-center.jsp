<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<%
String basePath = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath();
String instname=(String)session.getAttribute("instname");
if(instname==null)
{
	response.sendRedirect(basePath);
}%>

<div class="container">
<div class="usercenter_box">
  <div class="usercenter clearfix">
    <div class="usercenter_bg"></div>
    <div class="usercenter_nav">
      <div class="bigtitle"><a id="wodeCen" href="javascript:void(0)">我的中心</a></div>
      <div class="item">
        <div class="listtitle"><i></i>医院信息</div>
        <ul class="item_list" style="display:none;">
           <li> <a id="jibenMan" href="javascript:void(0)">基本信息修改</a> </li>
          <li> <a id="yishengMan" href="javascript:void(0)">医生信息</a> </li>
		  <li> <a id="yaopinMan" href="javascript:void(0)">药品信息</a> </li>
        </ul>
      </div>
	  <div class="item">
        <div class="listtitle"><i></i>医疗服务</div>
        <ul class="item_list" style="display:none;">
          <li> <a id="shangmenSer" href="javascript:void(0)">上门服务</a> </li>
          <li><a id="dingdanMan" href="javascript:void(0)">订单信息</a></li>
          <li><a id="yonghupingQia" href="javascript:void(0)">用户评价</a></li>
        </ul>
      </div>
      <div class="item">
        <div class="listtitle"><i></i>通知中心</div>
        <ul class="item_list" style="display:none;">
          <li> <a id="messageBox" href="javascript:void(0)">收件箱</a></li>
        </ul>
      </div>
      <div class="lastadvice"> <a href="#" class="blue" target="_blank">意见反馈</a> </div>
    </div>
    
    <!--start scenterContent-->
    <div class="usercenter_con"> 
      <!--start scenterMain--> 
      
  </div><!-- 右边结束 -->
</div>
</div>
</body>
</html>