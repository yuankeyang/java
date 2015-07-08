<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="righttd">
   <div class="scenter-review">                    
    <div class="scenter-main-title clearfix"> 
        <h3 class="scenter-review-title fl">收件箱</h3> 
    </div>  

<div class="myAdvisory-box mt10 pr">
    <ul class="myAdvisory-menu clearfix f14">
        <li class="myAdvisory-menu-active"><a href="showmycomment">全部</a></li>
    </ul>
</div>
<div class="user_center_tablebox">
    <html>

<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>标题一</title>
<script>
function Menu(term){
   if(term.style.display=="none"){
      Menu_1.style.display="none";
   Menu_2.style.display="none";
   Menu_3.style.display="none";
   term.style.display="";
    }}
</script>
</head>

<body>

<p><a href="###" onclick="Menu(Menu_1)"><font size=3>未读信息</font></a>;<a href="###" onclick="Menu(Menu_2)"><font size=3>已读信息</font></a>;<a href="###" onclick="Menu(Menu_3)"><font size=3>全部信息</font></a></p>
<div style="position: absolute; width: 700;z-index: 1;" id="Menu_1">
<table cellspacing="0" cellpadding="0" width="700" border="1" style=" border-collapse:separate; border-spacing:1px; padding:inherit;">
       <tbody>
          <tr class="user_center_tabletitle">
             <td width="12%" align="center">发件人</td>
             <td width="88%" align="center">邮件主题</td>
         </tr> 
       </tbody>
              <tr class="user_center_tabletitle">
            <td colspan="7" align="center">目前没有任何信息</td>
        </tr>

            </table>
 </div>
<div style="display:none;position: absolute; width: 700; z-index: 1;" id="Menu_2">
<table cellspacing="0" cellpadding="0" width="700" border="1"style=" border-collapse:separate; border-spacing:1px; padding:inherit;">
       <tbody>
          <tr class="user_center_tabletitle">
             <td width="12%" align="center">发件人</td>
             <td width="88%" align="center">邮件主题</td>
         </tr> 
       </tbody>
              <tr class="user_center_tabletitle">
            <td colspan="7" align="center">目前没有任何信息，如果有了新的信息，我们会及时通知您的</td>
        </tr>

            </table>
 </div>
<div style="display:none;position: absolute; width: 700;z-index: 1;" id="Menu_3">
<table cellspacing="0" cellpadding="0" width="700" border="1"style=" border-collapse:separate; border-spacing:1px; padding:inherit;">
       <tbody>
          <tr class="user_center_tabletitle">
             <td width="12%" align="center">发件人</td>
             <td width="88%" align="center">邮件主题</td>
         </tr> 
       </tbody>
              <tr class="user_center_tabletitle">
            <td colspan="7" align="center">目前没有任何信息</td>
        </tr>

            </table>
 </div>

</body>

</html>
</div>