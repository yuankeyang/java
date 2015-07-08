package org.apache.jsp.WEB_002dINF.memb.yiliaoSer.jiuyiExp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newjiuyiExp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write('	');

	String templateUrl = request.getScheme() + "://" + request.getHeader("host") +request.getContextPath();
	request.setAttribute("url", templateUrl);
	
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"utf-8\" />\r\n");
      out.write("\t\t<style>\r\n");
      out.write("\t\t\tform {\r\n");
      out.write("\t\t\t\tmargin: 0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\ttextarea {\r\n");
      out.write("\t\t\t\tdisplay: block;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css0623/style.css\"/>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/kindeditor/themes/default/default.css\" />\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("\t\t<script charset=\"utf-8\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/kindeditor/kindeditor-min.js\"></script>\r\n");
      out.write("\t\t<script charset=\"utf-8\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/kindeditor/lang/zh_CN.js\"></script>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\tvar editor;\r\n");
      out.write("\t\t\tKindEditor.ready(function(K) {\r\n");
      out.write("\t\t\t\teditor = K.create('textarea[name=\"content\"]', {\r\n");
      out.write("\t\t\t\t\tallowFileManager : true\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t//alert(editor.html());\r\n");
      out.write("\t\t\t\t\t//alert(editor.isEmpty());\r\n");
      out.write("\t\t\t\t\t//editor.html('<h3>Hello KindEditor</h3>');\r\n");
      out.write("\t\t\t\t\t//editor.text('<h3>Hello KindEditor</h3>');\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction check(){\r\n");
      out.write("\t\t\t\t//alert($('#title').val());\r\n");
      out.write("\t\t\t\tif($('#title').val()==\"\"){\r\n");
      out.write("\t\t\t\t\t$(\"#title\").select();\r\n");
      out.write("\t\t\t\t\t$(\"#title\").focus();\r\n");
      out.write("\t\t\t\t}else if(editor.isEmpty()){\r\n");
      out.write("\t\t\t\t\t$(\"#content\").select();\r\n");
      out.write("\t\t\t\t\t$(\"#content\").focus();\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t$('#content').val(editor.html());\r\n");
      out.write("\t\t\t\t\tsubmit();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//<form action=\"AddJiuyiExp\" id=\"AddJiuyiExp\" method=\"post\">\r\n");
      out.write("\t\t\tfunction submit(){\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t        url : '");
      out.print(templateUrl);
      out.write("/user/AddJiuyiExp',\r\n");
      out.write("\t\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\t\tdata:\"title=\"+$('#title').val()+\"&content=\"+editor.html(),\r\n");
      out.write("\t\t\t\tcontentType: \"application/x-www-form-urlencoded; charset=utf-8\", \r\n");
      out.write("\t\t\t\tdataType : 'text',\r\n");
      out.write("\t\t\t\ttimeout : 8000,\r\n");
      out.write("\t\t\t\tcache : true,\r\n");
      out.write("\t\t\t\terrot:erryFunction,\r\n");
      out.write("\t\t\t\tsuccess : succFunction\r\n");
      out.write("\t\t\t//成功执行方法  \r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\tfunction erryFunction() {\r\n");
      out.write("\t\t\t\talert(\"请刷新页面!!\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfunction succFunction(data) {\r\n");
      out.write("\t\t\t\talert(\"创建新文章成功\");\r\n");
      out.write("\t\t\t\twindow.location=\"jiuyiExp\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/left.png\"/>&nbsp;&nbsp;<font\r\n");
      out.write("\t\t\t\tsize=\"6\">创建就医经验\r\n");
      out.write("\t\t\t</font>&nbsp;&nbsp;<img\r\n");
      out.write("\t\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/imgs/membercenter/right.png\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br/><br/>\r\n");
      out.write("\t\t<form action=\"AddJiuyiExp\" id=\"AddJiuyiExp\" method=\"post\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t   <label style=\"width:80%;height:30px;font-family: '宋体' ;font-size: 18px;\">文章标题:</label>\r\n");
      out.write("\t\t   <input type=\"text\" id =\"title\" name=\"title\" style=\"width:81%;height:25px;font-family: KaiTi_GB2312;font-size: 18px;\"/>\r\n");
      out.write("\t\t   </div>\r\n");
      out.write("\t\t   <div style=\"margin-top: 10px;\">\r\n");
      out.write("\t\t\t<textarea id=\"content\" name=\"content\" style=\"width:97%;height:400px;\"></textarea>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"mysubmit\" style=\"margin-top:8px;width:800px;float:right;margin-right:100px;\">\r\n");
      out.write("\t\t\t\t    <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/image/largebutton_subsave.png\" onclick=\"check();\" style=\"float:right;\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t  </form>\r\n");
      out.write("\t</body>\r\n");
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
