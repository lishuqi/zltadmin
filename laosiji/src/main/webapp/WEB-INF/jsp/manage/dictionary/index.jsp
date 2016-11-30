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
		<title>${title}</title>
		<%@ include file="../../common/base.jsp"%>
	</head>

	<body style="margin:0px; height:82%;">
		<jsp:include page="add.jsp"></jsp:include>
		<!-- 编辑 模态框（Modal） -->
		<div class="modal fade" id="myModalEdit" tabindex="-1" role="dialog" 
		   aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog">
		      <div class="modal-content">
		         <div class="modal-header">
		            <button type="button" class="close" 
		               data-dismiss="modal" aria-hidden="true">
		                  &times;
		            </button>
		            <h4 class="modal-title" id="myModalLabel">
		               	编辑
		            </h4>
		         </div>
		         <div class="modal-body">
		         	<form class="form-horizontal" role="form"> 
		         		<div class="form-group" style="display: none">
					        <label class="col-sm-2 control-label">id</label>
					        <div class="col-sm-10">
					            <input type="text" method="edit" class="form-control" name="id" id="id" >
					        </div>
					    </div>
					    <div class="form-group">
					        <label class="col-sm-2 control-label">数据名称</label>
					        <div class="col-sm-10">
					            <input type="text" method="edit" class="form-control" name="name" id="name" >
					        </div>
					    </div>
					    <div class="form-group">
					        <label class="col-sm-2 control-label">标识</label>
					        <div class="col-sm-10">
					            <input type="text" method="edit" class="form-control" name="code" id="code">
					        </div>
					    </div>
					    <div class="form-group">
					        <label class="col-sm-2 control-label">排序</label>
					        <div class="col-sm-10">
					            <input type="text" method="edit" class="form-control" name="sort" id="sort">
					        </div>
					    </div>
					</form>
		         </div>
		         <div class="modal-footer">
		            <button type="button" class="btn btn-default" 
		               data-dismiss="modal">关闭
		            </button>
		            <button type="button" id="buttonEdit" class="btn btn-primary" onclick="edit('<%=basePath%>Manage/Dictionary/edit.do?date='+new Date())">
		               	确认
		            </button>
		         </div>
		      </div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
		
		<!-- ztree start -->
		<div class="panel-body" style="padding-bottom: 0px;width:20%;heigth:100%;float:left">
			<div class="panel panel-default" style="heigth:100%;" >
				<div class="panel-heading"> 
					数据字典分类 
				</div>
				<div class="panel-body" style="heigth:100%;">
					<ul id="tree" class="ztree" style="width:700px;heigth:100%;"></ul>
				</div>
			</div>
		</div>
		<!-- ztree end -->
		<!-- table start -->
		<div class="panel-body" style="padding-bottom: 0px;width:80%;float:right">
			<div id="toolbar" class="btn-group" style="width:35%;float:left">
				<button id="btn_add" type="button" class="btn btn-default" onclick="showAddModelTree()">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
				</button>
				<button id="btn_edit" type="button" class="btn btn-default" onclick="showEditModel()">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
				</button>
				<button id="btn_delete" type="button" class="btn btn-default" onclick="del('<%=basePath%>Manage/Dictionary/delete.do?date='+new Date())">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
				</button>
			</div>
			<table id="table"></table>
		</div>
		<!-- table end -->
	</body>
	<script type="text/javascript">
	var zTree;
	//鼠标移动上去
    function addHoverDom(treeId, treeNode) {
	    	var sObj = $("#" + treeNode.tId + "_span");
	    	if($("#addBtn_" + treeNode.tId).length > 0 ){
	    		return;
	    	}
	        if(treeNode.pId==""){
	        	var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "'></span>";
	        }
	        sObj.after(addStr);
	        var btn = $("#addBtn_"+treeNode.tId);
	        if (btn) btn.bind("click", function(){	
	        	//将新节点添加到数据库中  
	            var name='NewNode';  
	            $.post('<%=basePath%>Manage/ZtreeNode/add.do?pid='+treeNode.id+'&name='+name+'&type=1',function (data) {  
	                var newID = data; //获取新添加的节点Id  
	                var zTree = $.fn.zTree.getZTreeObj("tree");
	                zTree.addNodes(treeNode, {id:newID, pId:treeNode.id, name:name}); //页面上添加节点  
	                var node = zTree.getNodeByParam("id", newID, null); //根据新的id找到新添加的节点  
	                zTree.selectNode(node); //让新添加的节点处于选中状态  
	            });  
	            return false;
	        });
    };
    function removeHoverDom(treeId, treeNode) {
	    if(treeNode.pId==""){
	    	$("#addBtn_"+treeNode.tId).unbind().remove();	
	    }
        $("#removeBtn_"+treeNode.tId).unbind().remove();
        $("#editBtn_"+treeNode.tId).unbind().remove();
    };
    function onRename(e, treeId, treeNode, isCancel) {  
        //需要对名字做判定的，可以来这里写~~  
        $.post('<%=basePath%>Manage/ZtreeNode/edit.do?id='+treeNode.id+'&name='+treeNode.name);  
    }
    function onRemove(e, treeId, treeNode) {  
        $.post('<%=basePath%>Manage/ZtreeNode/delete.do?id='+treeNode.id,function (result) {  
		   var t = eval('('+result+')');
		   if(t.status == '99'){
		      layerBlackTwoSeconedNoReload('刪除成功');
		   }else{
		      layerBlackTwoSeconedNoReload(t.msg);
		   } 
		}); 
    }    
    function beforeRename(treeId, treeNode, newName, isCancel) {  
        if (newName.length == 0) {  
            alert("节点名称不能为空.");  
            return false;  
        }  
        return true;  
    } 
    function zTreeOnClick(event, treeId, treeNode) {
    	refreshTable();
	};
    var setting = {
        check: {
            enable: false//设置 zTree 的节点上是否显示 checkbox / radio 默认值: false
        },
        view: {
            addHoverDom: addHoverDom,
            removeHoverDom: removeHoverDom,
            beforeRename:beforeRename,
            dblClickExpand: false,
            showLine: true,
            selectedMulti: false
        },
        edit: {  
	        enable: true, //单独设置为true时，可加载修改、删除图标  
	        editNameSelectAll: true,  
	        showRemoveBtn: true,  
	        showRenameBtn: true  
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
        	onClick: zTreeOnClick, //单击事件  
       	 	onRemove: onRemove, //移除事件  
            onRename: onRename //修改事件 
        }
    };

	var zNodes;
	function initTreeNode(){
		$.ajax({
			url:'<%=basePath%>Manage/ZtreeNode/list.do?type=1',
			type:'GET',
			async:false,
			success:function(result){
				zNodes = eval('('+result+')');
			}
		});
		 var t = $("#tree");
	     t = $.fn.zTree.init(t, setting, zNodes);
	}
	$(function() {
		initTreeNode();
		initTable();
	});
	//初始化表格
	function initTable() {
        //先销毁表格  
        $('#cusTable').bootstrapTable('destroy');
        //初始化表格,动态从服务器加载数据  
        $("#table").bootstrapTable({  
            method: "get",  //使用get请求到服务器获取数据  
            url: "<%=basePath%>Manage/Dictionary/list.do?date=" + new Date(), //获取数据的Servlet地址  
            striped: true,  //表格显示条纹  
            pagination: true, //启动分页  
            toolbar:'toolbar',
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
            queryParams: function queryParams(params) {
            	var nodeId;
            	if(typeof($.fn.zTree.getZTreeObj("tree").getSelectedNodes()[0]) == "undefined"){
            		nodeId = null;
            	}else{
            		nodeId = $.fn.zTree.getZTreeObj("tree").getSelectedNodes()[0].id
            	}
              //设置查询参数  
              var param = {    
                  pageNumber: params.pageNumber,    
                  pageSize: params.pageSize,  
                  //queryString : $("#txt_search_dictionary_name").val(),
                  treeNodeId : nodeId
              };    
              return param;                   
            },
            columns : [ {
					checkbox : true
					// radio: true  单选
				}, {
					field : 'name',
					title : '数据名称',
					align: 'left',
                    valign: 'top'
				}, {
					field : 'code',
					title : '标识符',
					align: 'left',
                    valign: 'top'
				}, {
					field : 'sort',
					title : '排序',
					align: 'left',
                    valign: 'top'
				} ],  
            onLoadSuccess: function(){  //加载成功时执行  
            	//alert("加载成功");
            },  
            onLoadError: function(){  //加载失败时执行  
              layer.msg("加载数据失败", {time : 1500, icon : 2}); 
            }  
          });  
      }
</script>
</html>
