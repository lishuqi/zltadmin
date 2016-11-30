<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html style="margin:0px; height:73%;">
	<head>
		<base href="<%=basePath%>">

		<title>${title }</title>
		<%@ include file="../../common/base.jsp"%>
	</head>
	<body style="margin:0px; height:100%;">
		<div class="panel-body" style="padding-bottom: 0px;" >
			<div class="panel panel-default">
				<div class="panel-heading"> 
					查询条件 
				</div>
				<div class="panel-body">
					<form id="formSearch" class="form-horizontal">
						<div class="form-group" style="margin-top: 5px">
							<label class="control-label col-sm-1"
								for="txt_search_title">
								标题
							</label>
							<div class="col-sm-3">
								<input type="text" class="form-control"
									id="txt_search_log_title">
							</div>
							<label class="control-label col-sm-1"
								for="txt_search_title">
								操作人
							</label>
							<div class="col-sm-3">
								<input type="text" class="form-control"
									id="txt_search_log_adduser">
							</div>
							<div class="col-sm-4" style="text-align: left;">
								<button type="button" style="margin-left: 30px" id="btn_query"
									class="btn btn-primary" onclick="initTable()">
									查询
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<table id="table"></table>
		</div>
	</body>
	<script type="text/javascript">
	$(function() {
		 //调用函数，初始化表格  
          initTable();  
	});
	
	function initTable() {  
        //先销毁表格  
        $('#table').bootstrapTable('destroy');  
        //初始化表格,动态从服务器加载数据  
        $("#table").bootstrapTable({  
            method: "get",  //使用get请求到服务器获取数据  
            url: "<%=basePath%>Manage/Log/list.do?type=1&date="+new Date(), //获取数据的Servlet地址  
            striped: true,  //表格显示条纹  1
            pagination: true, //启动分页  
            cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pageSize: 20,  //每页显示的记录数  
            pageNumber:1, //当前第几页  
            pageList : [ 10, 20, 50], //可供选择的每页的行数（*） 
            search: false,  //是否启用查询  
            showColumns: false,  //显示下拉框勾选要显示的列  
            showRefresh: false,  //显示刷新按钮  
            lickToSelect : false, //是否启用点击选中行
            sidePagination: "server", //表示服务端请求  
            showToggle : false, //是否显示详细视图和列表视图的切换按钮
			cardView : false, //是否显示详细视图
			detailView : false, //是否显示父子表
            //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder  
            //设置为limit可以获取limit, offset, search, sort, order  
            queryParamsType : "undefined",   
            queryParams: function queryParams(params) {   //设置查询参数  
              var param = {    
                  pageNumber: params.pageNumber,    
                  pageSize: params.pageSize,  
                  title : $("#txt_search_log_title").val(),
                  adduser : $("#txt_search_log_adduser").val(),
                  type : 1  
              };    
              return param;                   
            },
            columns : [ {
					checkbox : true
					// radio: true  单选
				}, {
					field : 'title',
					title : '标题',
					align: 'left',
                    valign: 'top'
				}, {
					field : 'addUser',
					title : '操作人',
					align: 'left',
                    valign: 'top'
				},
				{
					field : 'addDate',
					title : '操作时间 ',
					align: 'left',
                    valign: 'top',
                    formatter:function(value,row,index){ 
                    	var date = new Date(value); 
						return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" " +date.getHours()+":"+date.getMinutes();
                    } 
				} ],  
            onLoadSuccess: function(){  //加载成功时执行  
            },  
            onLoadError: function(){  //加载失败时执行  
            }
          });  
      }
</script>
</html>
