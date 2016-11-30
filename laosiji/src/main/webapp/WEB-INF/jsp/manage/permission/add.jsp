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
   <!-- 添加模态框（Modal） -->
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
		               	添加
		            </h4>
		         </div>
		         <div class="modal-body">
		         	<form class="form-horizontal" role="form"> 
					    <div class="form-group">
					        <label class="col-sm-2 control-label">资源名称</label>
					        <div class="col-sm-10">
					            <input type="text" method="add" class="form-control" name="name" id="name" placeholder="请输入资源名称">
					        </div>
					    </div>
					    <div class="form-group">
					        <label class="col-sm-2 control-label">资源地址</label>
					        <div class="col-sm-10">
					            <input type="text" method="add" class="form-control" name="url" id="url" placeholder="请输入资源地址">
					        </div>
					    </div>
					    <div class="form-group">
					        <label class="col-sm-2 control-label">资源标识</label>
					        <div class="col-sm-10">
					            <input type="text" method="add" class="form-control" name="percode" id="percode" placeholder="请输入资源标识">
					        </div>
					    </div>
					    <div class="form-group">
					        <label class="col-sm-2 control-label">排序</label>
					        <div class="col-sm-10">
					            <input type="text" method="add" class="form-control" name="sort" id="sort" placeholder="请输入排序序号">
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
		            <button type="button" id="buttonAdd" class="btn btn-primary" onclick="addTree('<%=basePath%>Manage/Permission/add.do?date='+new Date())">
		               	确认
		            </button>
		         </div>
		      </div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
  </body>
</html>
