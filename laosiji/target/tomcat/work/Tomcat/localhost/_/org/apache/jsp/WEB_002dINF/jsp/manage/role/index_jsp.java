/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-10-18 09:06:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.manage.role;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/jsp/manage/role/../../common/base.jsp", Long.valueOf(1476780415150L));
  }

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
      response.setContentType("text/html;charset=utf-8");
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
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html >\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("\t\t<title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</title>\r\n");
      out.write("\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("\t<meta charset=\"utf-8\" />\r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,Chrome=1\" />\r\n");
      out.write("\t<!-- IE9 -->\r\n");
      out.write("    <script src=\"http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js\"></script>\r\n");
      out.write("    <script src=\"http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js\"></script>\r\n");
      out.write("\t<!-- jquery 1.7.2 -->\r\n");
      out.write("\t<script type=\"text/javascript\"src=\"static/jquery/jquery-1.9.1.js\"></script>\r\n");
      out.write("\t<!-- bootstarp 3.3.5 -->\r\n");
      out.write("\t<link href=\"static/bootstarp/dist/css/bootstrap.css\"rel=\"stylesheet\">\r\n");
      out.write("\t<script type=\"text/javascript\"src=\"static/bootstarp/dist/js/bootstrap.js\"></script>\r\n");
      out.write("\t<!-- bootstarp-table -->\r\n");
      out.write("\t<script type=\"text/javascript\"src=\"static/bootstarptable/dist/bootstrap-table.js\"></script>\r\n");
      out.write("\t<link href=\"static/bootstarptable/dist/bootstrap-table.css\"rel=\"stylesheet\">\r\n");
      out.write("\t<script type=\"text/javascript\"src=\"static/bootstarptable/dist/locale/bootstrap-table-zh-CN.js\"></script>\r\n");
      out.write("\t<!-- 模态框dialog -->\r\n");
      out.write("\t<script type=\"text/javascript\"src=\"static/bootstarptable/js/modal.js\"></script>\r\n");
      out.write("\t<!-- layer弹出框 -->\r\n");
      out.write("\t<script type=\"text/javascript\"src=\"static/layer-v2.4/layer/layer.js\"></script>\r\n");
      out.write("\t<!-- common.js -->\r\n");
      out.write("\t<script type=\"text/javascript\"src=\"static/ljy/common.js\"></script>\r\n");
      out.write("\t<!-- zTree相关 -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"static/zTree/css/zTreeStyle/metro.css\" type=\"text/css\">\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"static/zTree/js/jquery.ztree.all-3.5.min.js\"></script>\r\n");
      out.write("\t<!-- 图标库 -->\r\n");
      out.write("\t<link href=\"static/index/css/font-awesome.min.css?v=4.4.0\" rel=\"stylesheet\">\r\n");
      out.write("\t<!-- layui -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"static/layui/css/layui.css\" type=\"text/css\">");
      out.write("\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"margin:0px; height:82%;\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "add.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "auth.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t<!-- ztree start -->\r\n");
      out.write("\t\t<div class=\"panel-body\" style=\"padding-bottom: 0px;width:20%;heigth:100%;float:left\">\r\n");
      out.write("\t\t\t<div class=\"panel panel-default\" style=\"heigth:100%;\" >\r\n");
      out.write("\t\t\t\t<div class=\"panel-heading\"> \r\n");
      out.write("\t\t\t\t\t组织机构 \r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"panel-body\" style=\"heigth:100%;\">\r\n");
      out.write("\t\t\t\t\t<ul id=\"tree\" class=\"ztree\" style=\"width:700px;heigth:100%;\"></ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- ztree end -->\r\n");
      out.write("\t\t<div class=\"panel-body\" style=\"padding-bottom: 0px;width:80%;float:right\">\r\n");
      out.write("\t\t\t<div id=\"toolbar\" class=\"btn-group\" style=\"width:35%;float:left\">\r\n");
      out.write("\t\t\t\t<button id=\"btn_add\" type=\"button\" class=\"btn btn-default\" onclick=\"showAddModel()\">\r\n");
      out.write("\t\t\t\t\t<span class=\"glyphicon glyphicon-plus\" aria-hidden=\"true\" ></span>新增\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t<button id=\"btn_edit\" type=\"button\" class=\"btn btn-default\">\r\n");
      out.write("\t\t\t\t\t<span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></span>修改\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t<button id=\"btn_delete\" type=\"button\" class=\"btn btn-default\" onclick=\"del('");
      out.print(basePath);
      out.write("Manage/Role/delete.do?date = ' + new Date())\">\r\n");
      out.write("\t\t\t\t\t<span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span>删除\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<table class=\"table-condensed\" id=\"table\"></table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t  //initZtree\r\n");
      out.write("\t\t  var t = $(\"#tree\");\r\n");
      out.write("          t = $.fn.zTree.init(t, setting, zNodes);\r\n");
      out.write("\t\t  //调用函数，初始化表格  \r\n");
      out.write("          initTable();\r\n");
      out.write("          selSelections(\"available\",83);\r\n");
      out.write("\t});\r\n");
      out.write("\tfunction zTreeOnClick(event, treeId, treeNode) {\r\n");
      out.write("    \trefreshTable();\r\n");
      out.write("\t};\r\n");
      out.write("\tvar setting = {\r\n");
      out.write("        check: {\r\n");
      out.write("            enable: false\r\n");
      out.write("        },\r\n");
      out.write("        data: {\r\n");
      out.write("            simpleData: {\r\n");
      out.write("                enable:true,\r\n");
      out.write("                idKey: \"id\",\r\n");
      out.write("                pIdKey: \"pId\",\r\n");
      out.write("                rootPId: \"\"\r\n");
      out.write("            }\r\n");
      out.write("        },\r\n");
      out.write("        callback: {\r\n");
      out.write("        \tonClick: zTreeOnClick //单击事件  \r\n");
      out.write("        }\r\n");
      out.write("    };\r\n");
      out.write("\tvar zNodes =[\r\n");
      out.write("        {id:1, pId:3, name:\"客户端\", open:false},\r\n");
      out.write("        {id:2, pId:3, name:\"服务端\", open:false},\r\n");
      out.write("    ];\r\n");
      out.write("\tfunction initTable() {  \r\n");
      out.write("        //先销毁表格  \r\n");
      out.write("        $('#table').bootstrapTable('destroy');  \r\n");
      out.write("        //初始化表格,动态从服务器加载数据  \r\n");
      out.write("        $(\"#table\").bootstrapTable({  \r\n");
      out.write("            method: \"get\",  //使用get请求到服务器获取数据  \r\n");
      out.write("            url: \"");
      out.print(basePath);
      out.write("Manage/Role/list.do?date=\"+new Date(), //获取数据的Servlet地址  \r\n");
      out.write("            striped: true,  //表格显示条纹  \r\n");
      out.write("            pagination: true, //启动分页  \r\n");
      out.write("            cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）\r\n");
      out.write("             pageSize: 20,  //每页显示的记录数  \r\n");
      out.write("            pageNumber:1, //当前第几页  \r\n");
      out.write("            pageList : [ 20, 50, 100], //可供选择的每页的行数（*）    \r\n");
      out.write("            search: false,  //是否启用查询  \r\n");
      out.write("            showColumns: false,  //显示下拉框勾选要显示的列  \r\n");
      out.write("            showRefresh: true,  //显示刷新按钮  \r\n");
      out.write("            lickToSelect : true, //是否启用点击选中行\r\n");
      out.write("            sidePagination: \"server\", //表示服务端请求  \r\n");
      out.write("            showToggle : true, //是否显示详细视图和列表视图的切换按钮\r\n");
      out.write("\t\t\tcardView : false, //是否显示详细视图\r\n");
      out.write("\t\t\tdetailView : false, //是否显示父子表\r\n");
      out.write("            //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder  \r\n");
      out.write("            //设置为limit可以获取limit, offset, search, sort, order  \r\n");
      out.write("            queryParamsType : \"undefined\",   \r\n");
      out.write("            queryParams: function queryParams(params) {   //设置查询参数 \r\n");
      out.write("            \tvar nodeId;\r\n");
      out.write("            \tif($.fn.zTree.getZTreeObj(\"tree\").getSelectedNodes(true)[0] == null){\r\n");
      out.write("            \t\tnodeId = null;\r\n");
      out.write("            \t}else{\r\n");
      out.write("            \t\tnodeId = $.fn.zTree.getZTreeObj(\"tree\").getSelectedNodes(true)[0].id\r\n");
      out.write("            \t} \r\n");
      out.write("              var param = {    \r\n");
      out.write("                  pageNumber: params.pageNumber,    \r\n");
      out.write("                  pageSize: params.pageSize,  \r\n");
      out.write("                  treeNodeId:nodeId\r\n");
      out.write("              };    \r\n");
      out.write("              return param;                   \r\n");
      out.write("            },\r\n");
      out.write("            columns : [ {\r\n");
      out.write("\t\t\t\t\tcheckbox : true\r\n");
      out.write("\t\t\t\t\t// radio: true  单选\r\n");
      out.write("\t\t\t\t},{\r\n");
      out.write("\t\t\t\t\tfield : 'name',\r\n");
      out.write("\t\t\t\t\ttitle : '角色名称',\r\n");
      out.write("\t\t\t\t\talign: 'left',\r\n");
      out.write("                    valign: 'top'\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\tfield : 'available',\r\n");
      out.write("\t\t\t\t\ttitle : '状态',\r\n");
      out.write("\t\t\t\t\talign: 'center',\r\n");
      out.write("                    valign: 'top',\r\n");
      out.write("                    formatter:function(value,row,index){\r\n");
      out.write("                    \tif(value == 1){\r\n");
      out.write("                    \t\treturn \"&nbsp;&nbsp;<div class=\\\"fa-hover col-md-4 col-sm-4\\\"><i class=\\\"fa fa-unlock\\\"></i>&nbsp;&nbsp;&nbsp;未锁定</div><div style=\\\"margin-right:5%;float:right\\\"><button class='layui-btn layui-btn-mini' onclick='showPermissionTree(\"+value+\")'><i class=\\\"fa fa-asterisk\\\"></i>&nbsp;&nbsp;锁定</button></div>\";\r\n");
      out.write("                    \t}\r\n");
      out.write("                    \treturn \"&nbsp;&nbsp;<div class=\\\"fa-hover col-md-4 col-sm-4\\\"><a href=\\\"#unlock-alt\\\"><i class=\\\"fa fa-unlock-alt\\\"></i>&nbsp;&nbsp;已锁定</a></div><div style=\\\"margin-left:4px;\\\"><button class='layui-btn layui-btn-mini' onclick='showPermissionTree(\"+value+\")'><i class=\\\"fa fa-asterisk\\\"></i>&nbsp;&nbsp;解锁</button></div>\";\r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tfield : 'updated',\r\n");
      out.write("\t\t\t\t\ttitle : '修改时间 ',\r\n");
      out.write("\t\t\t\t\talign: 'left',\r\n");
      out.write("                    valign: 'top',\r\n");
      out.write("                    formatter:function(value,row,index){ \r\n");
      out.write("                    \tvar date = new Date(value); \r\n");
      out.write("\t\t\t\t\t\treturn date.getFullYear()+\"-\"+(date.getMonth()+1)+\"-\"+date.getDate();\r\n");
      out.write("                    } \r\n");
      out.write("\t\t\t\t},{\r\n");
      out.write("\t\t\t\t\tfield : 'created',\r\n");
      out.write("\t\t\t\t\ttitle : '创建时间',\r\n");
      out.write("\t\t\t\t\talign: 'left',\r\n");
      out.write("                    valign: 'top',\r\n");
      out.write("                    formatter:function(value,row,index){ \r\n");
      out.write("                    \tvar date = new Date(value); \r\n");
      out.write("\t\t\t\t\t\treturn date.getFullYear()+\"-\"+(date.getMonth()+1)+\"-\"+date.getDate();\r\n");
      out.write("                    } \r\n");
      out.write("\t\t\t\t},{\r\n");
      out.write("\t\t\t\t\tfield : 'id',\r\n");
      out.write("\t\t\t\t\ttitle : '操作',\r\n");
      out.write("\t\t\t\t\talign: 'center',\r\n");
      out.write("                    valign: 'top',\r\n");
      out.write("                    formatter:function(value,row,index){ \r\n");
      out.write("\t\t\t\t\t\treturn \"<button class='layui-btn layui-btn-mini' onclick='showPermissionTree(\"+value+\")'><i class='layui-icon'>&#xe608;</i> 授权</button>\" ;\r\n");
      out.write("                    } \r\n");
      out.write("\t\t\t\t} ],  \r\n");
      out.write("            onLoadSuccess: function(){  //加载成功时执行  \r\n");
      out.write("            },  \r\n");
      out.write("            onLoadError: function(){  //加载失败时执行  \r\n");
      out.write("            }  \r\n");
      out.write("          });  \r\n");
      out.write("      }\r\n");
      out.write("</script>\r\n");
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
