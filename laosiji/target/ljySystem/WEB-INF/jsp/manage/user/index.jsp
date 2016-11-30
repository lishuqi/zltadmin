<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html style="margin:0px; height:90%;">
	<head>
		<base href="<%=basePath%>">

		<title>${title }</title>

		<%@ include file="../../common/base.jsp"%>
		<!-- layui -->
		<link rel="stylesheet" href="<%=basePath%>static/layui/css/layui.css" type="text/css">
	</head>
	<body style="margin:0px; padding:0px; height:92%;">
		<jsp:include page="add.jsp"></jsp:include>
		<jsp:include page="auth.jsp"></jsp:include>
		<!-- ztree start -->
		<div class="panel-body" style="padding-bottom: 0px;width:20%;heigth:100%;float:left">
			<div class="panel panel-default" style="heigth:100%;" >
				<div class="panel-heading"> 
					组织机构 
				</div>
				<div class="panel-body" style="heigth:100%;">
					<ul id="tree" class="ztree" style="width:700px;heigth:100%;"></ul>
				</div>
			</div>
		</div>
		<!-- ztree end -->
		<div class="panel-body" style="padding-bottom: 0px;width:80%;float:right">
			<div id="toolbar" class="btn-group" style="width:35%;float:left">
				<button id="btn_add" type="button" class="btn btn-default" onclick="showAddModelTree()">
					<span class="glyphicon glyphicon-plus" aria-hidden="true" ></span>新增
				</button>
				<button id="btn_edit" type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
				</button>
				<button id="btn_delete" type="button" class="btn btn-default" onclick="del('<%=basePath%>Manage/User/delete.do')">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
				</button>
			</div>
			<table class="table-condensed" id="table"></table>
		</div>
	</body>
	<script type="text/javascript">
	$(function() {
		 var t = $("#tree");
         t = $.fn.zTree.init(t, setting, zNodes);
		 //调用函数，初始化表格  
         initTable(); 
	});
	function zTreeOnClick(event, treeId, treeNode) {
    	refreshTable();
	};
	var setting = {
        check: {
            enable: false
        },
        data: {
            simpleData: {
                enable:true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: ""
            }
        },
        callback: {
        	onClick: zTreeOnClick //单击事件  
        }
    };
	var zNodes =[
        {id:1, pId:0, name:"客户端", open:true},
        {id:101, pId:1, name:"司机"},
        {id:102, pId:1, name:"乘客"},
        
        {id:2, pId:0, name:"服务端", open:true},
        {id:201, pId:2, name:"研发"},
        {id:202, pId:2, name:"测试"},
        {id:203, pId:2, name:"总经办"}
    ];
	function initTable() {  
        //先销毁表格  
        $('#table').bootstrapTable('destroy');  
        //初始化表格,动态从服务器加载数据  
        $("#table").bootstrapTable({  
            method: "get",  //使用get请求到服务器获取数据  
            url: "<%=basePath%>Manage/User/list.do?date="+new Date(), //获取数据的Servlet地址  
            striped: true,  //表格显示条纹  
            pagination: true, //启动分页  
            cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
             pageSize: 20,  //每页显示的记录数  
            pageNumber:1, //当前第几页  
            pageList : [ 20, 50, 100], //可供选择的每页的行数（*）    
            search: false,  //是否启用查询  
            showColumns: false,  //显示下拉框勾选要显示的列  
            showRefresh: true,  //显示刷新按钮  
            lickToSelect : true, //是否启用点击选中行
            sidePagination: "server", //表示服务端请求  
            showToggle : true, //是否显示详细视图和列表视图的切换按钮
			cardView : false, //是否显示详细视图
			detailView : false, //是否显示父子表
            //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder  
            //设置为limit可以获取limit, offset, search, sort, order  
            queryParamsType : "undefined",   
            queryParams: function queryParams(params) {   //设置查询参数  
            	var nodeId;
            	if($.fn.zTree.getZTreeObj("tree").getSelectedNodes(true)[0] == null){
            		nodeId = null;
            	}else{
            		nodeId = $.fn.zTree.getZTreeObj("tree").getSelectedNodes(true)[0].id
            	}
              	var param = {    
                  	pageNumber: params.pageNumber,    
                 	pageSize: params.pageSize,
                  	treeNodeId: nodeId
              	};    
              	return param;                   
            },
            columns : [ {
					checkbox : true
					// radio: true  单选
				},{
					field : 'userName',
					title : '姓名',
					align: 'left',
                    valign: 'top'
				}, {
					field : 'gender',
					title : '性別',
					align: 'left',
                    valign: 'top',
                    formatter:function(value,row,index){
                    	if(value == 1){
                    		return "男";
                    	}
                    	return "女";
                    }
				},
				{
					field : 'lastLoginDate',
					title : '上次登陆时间 ',
					align: 'left',
                    valign: 'top',
                    formatter:function(value,row,index){ 
                    	var date = new Date(value); 
						return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
                    } 
				},{
					field : 'created',
					title : '创建时间',
					align: 'left',
                    valign: 'top',
                    formatter:function(value,row,index){ 
                    	var date = new Date(value); 
						return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
                    } 
				},{
					field : 'id',
					title : '操作',
					align: 'center',
                    valign: 'top',
                    formatter:function(value,row,index){ 
						return "<button class='layui-btn layui-btn-mini' onclick='showRoleTree("+value+")'><i class='layui-icon'>&#xe608;</i> 授权</button>" ;
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
