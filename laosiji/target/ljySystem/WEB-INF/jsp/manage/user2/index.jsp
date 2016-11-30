<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>LJY后台管理系统</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<!-- jquery 1.7.2 -->
		<script type="text/javascript"
			src="<%=basePath%>static/jquery/jquery-1.9.1.js"></script>

		<!-- bootstarp 3.3.5 -->
		<script type="text/javascript"
			src="<%=basePath%>static/bootstarp/dist/js/bootstrap.js"></script>
		<link href="<%=basePath%>static/bootstarp/dist/css/bootstrap.css"
			rel="stylesheet">

		<!-- bootstarp-table -->
		<script type="text/javascript"
			src="<%=basePath%>static/bootstarptable/dist/bootstrap-table.js"></script>
		<link
			href="<%=basePath%>static/bootstarptable/dist/bootstrap-table.css"
			rel="stylesheet">
		<script type="text/javascript"
			src="<%=basePath%>static/bootstarptable/dist/locale/bootstrap-table-zh-CN.js"></script>
			
		<!-- 模态框dialog -->
		<script type="text/javascript"
			src="<%=basePath%>static/bootstarptable/js/modal.js"></script>
	</head>

	<body>
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
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
					        <label class="col-sm-2 control-label">Email</label>
					        <div class="col-sm-10">
					            <p class="form-control-static">email@example.com</p>
					        </div>
					    </div>
					    <div class="form-group">
					        <label for="inputPassword" class="col-sm-2 control-label">密码</label>
					        <div class="col-sm-10">
					            <input type="password" class="form-control" id="inputPassword" placeholder="请输入密码">
					        </div>
					    </div>
					</form> 
		         </div>
		         <div class="modal-footer">
		            <button type="button" class="btn btn-default" 
		               data-dismiss="modal">关闭
		            </button>
		            <button type="button" class="btn btn-primary">
		               	确认
		            </button>
		         </div>
		      </div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
		<div class="panel-body" style="padding-bottom: 0px;">
			<div class="panel panel-default">
				<div class="panel-heading"> 
					查询条件 
				</div>
				<div class="panel-body">
					<form id="formSearch" class="form-horizontal">
						<div class="form-group" style="margin-top: 5px">
							<label class="control-label col-sm-1"
								for="txt_search_rolename">
								角色名称
							</label>
							<div class="col-sm-3">
								<input type="text" class="form-control"
									id="txt_search_departmentname">
							</div>
							<!--  
							<label class="control-label col-sm-1" for="txt_search_statu">
								状态
							</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="txt_search_statu">
							</div>
							-->
							<div class="col-sm-4" style="text-align: left;">
								<button type="button" style="margin-left: 30px" id="btn_query"
									class="btn btn-primary">
									查询
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>

			<div id="toolbar" class="btn-group">
				<button id="btn_add" type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
				</button>
				<button id="btn_edit" type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
				</button>
				<button id="btn_delete" type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
				</button>
			</div>
			<table id="table"></table>
		</div>
	</body>
	<script type="text/javascript">
	$(function() {
		//1.初始化Table
		var oTable = new TableInit();
		oTable.Init();

		//2.初始化Button的点击事件
		var oButtonInit = new ButtonInit();
		oButtonInit.Init();

	});
	var TableInit = function() {
		var oTableInit = new Object();
		//初始化Table
		oTableInit.Init = function() {
			$('#table').bootstrapTable( {
				url : '<%=basePath%>Manage/Role/list.do', //请求后台的URL（*）
				method : 'get', //请求方式（*）
				toolbar : '#toolbar', //工具按钮用哪个容器
				striped : true, //是否显示行间隔色
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination : true, //是否显示分页（*）
				sortable : false, //是否启用排序
				sortOrder : "asc", //排序方式
				pageNumber : 1, //初始化加载第一页，默认第一页
				pageSize : 10, //每页的记录行数（*）
				queryParams : oTableInit.queryParams,//传递参数（*）
				sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
				
				pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*）
				//search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
				strictSearch : true,
				//showColumns : true, //是否显示所有的列
				showRefresh : true, //是否显示刷新按钮
				minimumCountColumns : 2, //最少允许的列数
				clickToSelect : true, //是否启用点击选中行
				height : $(window).height() - 200, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
				uniqueId : "ID", //每一行的唯一标识，一般为主键列
				showToggle : true, //是否显示详细视图和列表视图的切换按钮
				cardView : false, //是否显示详细视图
				detailView : false, //是否显示父子表
				columns : [ {
					checkbox : true
					// radio: true  单选
				}, {
					field : 'id',
					title : 'ID',
					align: 'left',
                    valign: 'top'
				}, {
					field : 'name',
					title : '角色名称',
					align: 'left',
                    valign: 'top'
				}, {
					field : 'available',
					title : '状态',
					align: 'left',
                    valign: 'top'
				},
				{
					field : 'updated',
					title : '修改时间 ',
					align: 'left',
                    valign: 'top'
				},{
					field : 'created',
					title : '创建时间',
					align: 'left',
                    valign: 'top'
				} ]
			});
		};

		//得到查询的参数
		oTableInit.queryParams = function(params) {
			var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
				limit : params.limit, //页面大小
				offset : params.offset, //页码
				//pageSize: params.pageSize,
                //pageNumber: params.pageNumber,
				name : $("#txt_search_rolename").val()
			};
			return temp;
		};
		return oTableInit;
	};

	var ButtonInit = function() {
		var oInit = new Object();
		oInit.Init = function() {
			//初始化页面上面的按钮事件
			$("#btn_add").on('click',function(){
				$("#myModal").modal('show');
			});
			$(".btn-primary").on('click',function(){
				alert($("#inputPassword").val());
			});
		};
		return oInit;
	};
</script>
</html>
