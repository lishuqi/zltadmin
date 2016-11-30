<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
  </head>
  <body>
   <!-- 模态框（Modal） -->
		<div class="modal fade" id="myModalAdd" tabindex="-1" role="dialog" 
		   aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog">
		      <div class="modal-content">
		         <div class="modal-header">
		            <button type="button" class="close" 
		               data-dismiss="modal" aria-hidden="true">
		                  &times;
		            </button>
		            <h4 class="modal-title" id="myModalLabel">
		               	添加角色
		            </h4>
		         </div>
		         <div class="modal-body">
		         	<form class="form-horizontal" role="form">  
					    <div class="form-group">
					        <label class="col-sm-2 control-label">角色名称</label>
					        <div class="col-sm-10">
					            <input type="text" class="form-control" method="add" name="name" placeholder="请输入角色名称">
					        </div>
					    </div>
					    <div class="form-group">
					        <label class="col-sm-2 control-label">是否可用</label>
					        <div class="col-sm-10">
						        <select  class="form-control m-b" method="add" name="available">
	                            </select>
                            </div>
					    </div>
					    </form>
		         </div>
		         <div class="modal-footer">
		            <button type="button" class="btn btn-default" 
		               data-dismiss="modal">关闭
		            </button>
		            <button type="button" id="addButton" class="btn btn-primary" onclick="addTree('<%=basePath%>Manage/Role/add.do?date = '+ new Date())">
		               	确认
		            </button>
		         </div>
		      </div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
  </body>
</html>
