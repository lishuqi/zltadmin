/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-10-19 10:06:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.manage.unauth;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
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
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\t\r\n");
      out.write("    <title>无权访问</title>\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"shortcut icon\"> <link href=\"");
      out.print(basePath );
      out.write("static/index/css/bootstrap.min.css?v=3.3.5\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"");
      out.print(basePath );
      out.write("static/index/css/font-awesome.min.css?v=4.4.0\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <link href=\"");
      out.print(basePath );
      out.write("static/index/css/animate.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"");
      out.print(basePath );
      out.write("static/index/css/style.min.css?v=4.0.0\" rel=\"stylesheet\"><base target=\"_blank\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"gray-bg\">\r\n");
      out.write("    <div class=\"middle-box text-center animated fadeInDown\">\r\n");
      out.write("    <br/>\r\n");
      out.write("           <br/>\r\n");
      out.write("        <h2 style=\"font-size:60px\">无权访问</h2>\r\n");
      out.write(" <br/> <br/> <br/>\t <br/> <br/> <br/> <br/>\r\n");
      out.write("        <div class=\"error-desc\">\r\n");
      out.write("           请联系管理员进行授权操作...\r\n");
      out.write("           <br/>\r\n");
      out.write("            <br/>您可以返回主页看看\r\n");
      out.write("            <br/><a href=\"");
      out.print(basePath );
      out.write("Manage/index.do\" class=\"btn btn-primary m-t\">主页</a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <script src=\"");
      out.print(basePath );
      out.write("static/index/js/jquery.min.js?v=2.1.4\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(basePath );
      out.write("static/index/js/bootstrap.min.js?v=3.3.5\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"http://tajs.qq.com/stats?sId=9051096\" charset=\"UTF-8\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
