/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-10-18 06:03:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.manage.permission;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("   <!-- 添加模态框（Modal） -->\r\n");
      out.write("\t\t<div class=\"modal fade\" id=\"myModalAdd\" tabindex=\"-1\" role=\"dialog\" \r\n");
      out.write("\t\t   aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("\t\t   <div class=\"modal-dialog\">\r\n");
      out.write("\t\t      <div class=\"modal-content\">\r\n");
      out.write("\t\t         <div class=\"modal-header\">\r\n");
      out.write("\t\t            <button type=\"button\" class=\"close\" \r\n");
      out.write("\t\t               data-dismiss=\"modal\" aria-hidden=\"true\">\r\n");
      out.write("\t\t                  &times;\r\n");
      out.write("\t\t            </button>\r\n");
      out.write("\t\t            <h4 class=\"modal-title\" id=\"myModalLabel\">\r\n");
      out.write("\t\t               \t添加\r\n");
      out.write("\t\t            </h4>\r\n");
      out.write("\t\t         </div>\r\n");
      out.write("\t\t         <div class=\"modal-body\">\r\n");
      out.write("\t\t         \t<form class=\"form-horizontal\" role=\"form\"> \r\n");
      out.write("\t\t\t\t\t    <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t        <label class=\"col-sm-2 control-label\">资源名称</label>\r\n");
      out.write("\t\t\t\t\t        <div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t\t            <input type=\"text\" method=\"add\" class=\"form-control\" name=\"name\" id=\"name\" placeholder=\"请输入资源名称\">\r\n");
      out.write("\t\t\t\t\t        </div>\r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t    <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t        <label class=\"col-sm-2 control-label\">资源地址</label>\r\n");
      out.write("\t\t\t\t\t        <div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t\t            <input type=\"text\" method=\"add\" class=\"form-control\" name=\"url\" id=\"url\" placeholder=\"请输入资源地址\">\r\n");
      out.write("\t\t\t\t\t        </div>\r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t    <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t        <label class=\"col-sm-2 control-label\">资源标识</label>\r\n");
      out.write("\t\t\t\t\t        <div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t\t            <input type=\"text\" method=\"add\" class=\"form-control\" name=\"percode\" id=\"percode\" placeholder=\"请输入资源标识\">\r\n");
      out.write("\t\t\t\t\t        </div>\r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t    <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t        <label class=\"col-sm-2 control-label\">排序</label>\r\n");
      out.write("\t\t\t\t\t        <div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t\t            <input type=\"text\" method=\"add\" class=\"form-control\" name=\"sort\" id=\"sort\" placeholder=\"请输入排序序号\">\r\n");
      out.write("\t\t\t\t\t        </div>\r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t    <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t        <label class=\"col-sm-2 control-label\">是否可用</label>\r\n");
      out.write("\t\t\t\t\t        <div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t        <select  class=\"form-control m-b\" method=\"add\" name=\"available\">\r\n");
      out.write("\t                            </select>\r\n");
      out.write("                            </div>\r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t         </div>\r\n");
      out.write("\t\t         <div class=\"modal-footer\">\r\n");
      out.write("\t\t            <button type=\"button\" class=\"btn btn-default\" \r\n");
      out.write("\t\t               data-dismiss=\"modal\">关闭\r\n");
      out.write("\t\t            </button>\r\n");
      out.write("\t\t            <button type=\"button\" id=\"buttonAdd\" class=\"btn btn-primary\" onclick=\"addTree('");
      out.print(basePath);
      out.write("Manage/Permission/add.do?date='+new Date())\">\r\n");
      out.write("\t\t               \t确认\r\n");
      out.write("\t\t            </button>\r\n");
      out.write("\t\t         </div>\r\n");
      out.write("\t\t      </div><!-- /.modal-content -->\r\n");
      out.write("\t\t\t</div><!-- /.modal -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
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
