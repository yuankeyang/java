package org.apache.jsp.WEB_002dINF.chat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class chat3_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();
	String templateUrl = request.getScheme() + "://"
			+ request.getHeader("host") + request.getContextPath();
	request.setAttribute("url", templateUrl);
	//专家调用
	String expename = (String) session.getAttribute("expename");
	String mem_id = request.getParameter("mem_id");
    //用户调用
	String username = (String) session.getAttribute("username");
	String expe_id = (String) session.getAttribute("expe_id");
	String sender=expename;
	String reciver=mem_id;
	if((expename==null||expename=="")||(mem_id==null||mem_id=="")){
		   sender=username;
		   reciver=expe_id;	
	}
			

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/topbarhead.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/tab02.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/main.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/chat-2.0.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/article.css\" />   <!-- 背景图片！！！ -->\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("        window.contextPath = \"");
      out.print(path);
      out.write("\";\r\n");
      out.write("        window[\"serverDomin\"] = \"iZ94kqx1u2hZ\";    //设置openfire域名，必须与服务器域名一致\r\n");
      out.write(" </script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jsjac.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/send.message.editor-1.0.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.easydrag.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/remote.jsjac.chat-2.0.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/local.chat-2.0.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script charset=\"utf-8\" type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("//在线聊天  \r\n");
      out.write("function checkOnline(){\r\n");
      out.write("\t\r\n");
      out.write("\t    $.ajax({\r\n");
      out.write("\t                url : '");
      out.print(templateUrl);
      out.write("/CheckOnlineAction',\r\n");
      out.write("\t                type : 'POST',\r\n");
      out.write("\t                data: JSON.stringify(userchat),\r\n");
      out.write("\t                contentType: \"application/json; charset=utf-8\",  \r\n");
      out.write("\t\t\t\t\tdataType : 'text',\r\n");
      out.write("\t\t\t\t\ttimeout : 8000,\r\n");
      out.write("\t\t\t\t\tcache : true,\r\n");
      out.write("\t\t\t\t\tbeforeSend : LoadFunction, //加载执行方法  \r\n");
      out.write("\t\t\t\t\terror : erryFunction, //错误执行方法  \r\n");
      out.write("\t\t\t\t\tcomplete : conFunction,\r\n");
      out.write("\t\t\t\t\tsuccess : succFunction\t//成功执行方法  \r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\tfunction LoadFunction() {;}\r\n");
      out.write("\t\t\t\tfunction erryFunction() {alert(\"该专家不在线,请稍后再试！\");}\r\n");
      out.write("\t     \t\tfunction conFunction()  {}\r\n");
      out.write("\t\t\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t\t\t//alert(data);\r\n");
      out.write("\t\t\t\t\tvar data = String($.trim(data)); \r\n");
      out.write("\t\t\t\t\tif(data==\"no\"){\r\n");
      out.write("\t\t\t\t\t\talert(\"该专家不在线,请稍后再试！\");\r\n");
      out.write("\t\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\talert(\"请求成功\");\r\n");
      out.write("\t\t\t\t\t\tchat();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("};\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("var userchat ={\r\n");
      out.write("\t\tsender:'");
      out.print(sender);
      out.write("',\r\n");
      out.write("\t\treciver:'");
      out.print(reciver);
      out.write("'\r\n");
      out.write("\t};\r\n");
      out.write("//在线聊天  \r\n");
      out.write("function chat(){\r\n");
      out.write("\tvar user={\r\n");
      out.write("\t\t\tuserName:userchat.sender,\r\n");
      out.write("\t\t\tpassword:\"xianggen\"\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\r\n");
      out.write("// 登陆到openfire服务器\r\n");
      out.write("remote.jsjac.chat.login(user);\r\n");
      out.write("              // 建立一个聊天窗口应用，并设置发送者和消息接收者\r\n");
      out.write("              \r\n");
      out.write("              /*\r\n");
      out.write("              $.WebIM({\r\n");
      out.write("                  sender: userchat.sender,\r\n");
      out.write("                  receiver: userchat.reciver\r\n");
      out.write("              });*/\r\n");
      out.write("              \r\n");
      out.write("\r\n");
      out.write("           $.WebIM({\r\n");
      out.write("                 sender: userchat.sender,\r\n");
      out.write("                 receiver: userchat.reciver.toLowerCase()\r\n");
      out.write("           });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<title>在线咨询--会员</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div style=\"margin-top:5%; margin-left:400px;\">\r\n");
      out.write("  <img title=\"点击发起在线聊天\" id=\"online\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/image/online.png\" style=\"border:2px solid #09F;border-radius:5px\"  onclick=\"checkOnline();\"/> <br/>  <br/>  <br/>\r\n");
      out.write("  <img title=\"电话连线\" id=\"telphone\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/image/telphone.png\" style=\"border:2px solid #09F;border-radius:5px\"  onclick=\"alert('请拨15111285014');\"/>\r\n");
      out.write("  <br/>  <br/>  <br/>\r\n");
      out.write("  <img title=\"远程视频聊天\" id=\"videoChat\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/image/videoChat.png\" style=\"border:2px solid #09F;border-radius:5px\"  onclick=\"alert('功能正在实现');\"/>\r\n");
      out.write("</div>\r\n");
      out.write("\t<div class=\"doc\" style=\"margin-left: 30%;margin-top: 10%;float: left;\">\r\n");
      out.write("\t\t<div id=\"footer\">\r\n");
      out.write("\t\t\t<!-- 日志信息 -->\r\n");
      out.write("\t\t\t<div id=\"error\" style=\"display:none ; background-color: red;\"></div>\r\n");
      out.write("\t\t\t<div id=\"info\" style=\"display:none ; background-color: #999999;\"></div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 聊天来消息提示 -->\r\n");
      out.write("\t\t\t<div class=\"chat-message\" style=\"margin-left: 35%;\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/write_icon.png\" class=\"no-msg\" /> \r\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/write_icon.gif\" class=\"have-msg\" style=\"display: none;\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
