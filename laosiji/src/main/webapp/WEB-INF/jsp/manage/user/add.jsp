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
		               	添加用户
		            </h4>
		         </div>
		         <div class="modal-body">
		         	<form class="form-horizontal" role="form">  
					    <div class="form-group">
					        <label class="col-sm-2 control-label">账号</label>
					        <div class="col-sm-10">
					            <input type="text" class="form-control" method="add" name="userCode" placeholder="请输入账号">
					        </div>
					    </div>
					    <div class="form-group">
					        <label class="col-sm-2 control-label">密码</label>
					        <div class="col-sm-10">
					            <input type="password" class="form-control" method="add" name="password" placeholder="请输入密码">
					        </div>
					    </div>
					    <div class="form-group">
					        <label class="col-sm-2 control-label">姓名</label>
					        <div class="col-sm-10">
					            <input type="text" class="form-control" method="add" name="userName" placeholder="请输入姓名">
					        </div>
					    </div>
					     <div class="form-group">
					        <label class="col-sm-2 control-label">性别</label>
					        <div class="col-sm-10">
					            <select id="gender" class="form-control m-b" method="add" name="gender"></select>
					        </div>
					    </div>
					    <div class="form-group">
					        <label class="col-sm-2 control-label">身份证号</label>
					        <div class="col-sm-10">
					            <input type="text" class="form-control" method="add" name="idCard" placeholder="请输入身份证号码">
					        </div>
					    </div>
					    <div class="form-group">
					        <label class="col-sm-2 control-label">电子邮箱</label>
					        <div class="col-sm-10">
					            <input type="text" class="form-control" method="add" name="email" placeholder="请输入电子邮箱">
					        </div>
					    </div>
					    <div class="form-group">
					        <label class="col-sm-2 control-label">联系方式</label>
					        <div class="col-sm-10">
					            <input type="text" class="form-control" method="add" name="phone" placeholder="请输入联系方式">
					        </div>
					    </div>
					    <div class="form-group">
					        <label class="col-sm-2 control-label">是否锁定</label>
					        <div class="col-sm-10">
						        <select id="locked" class="form-control m-b" method="add" name="locked"></select>
                            </div>
					    </div>
					    </form>
		         </div>
		         <div class="modal-footer">
		            <button type="button" class="btn btn-default" 
		               data-dismiss="modal">关闭
		            </button>
		            <button type="button" id="addButton" class="btn btn-primary" onclick="addTree('<%=basePath%>Manage/User/add.do?date = '+ new Date())">
		               	确认
		            </button>
		         </div>
		      </div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
		<script type="text/javascript">
		//加载下拉框选项
        selSelections("gender",82); 
        selSelections("locked",81); 
		</script>
  </body>
</html>
