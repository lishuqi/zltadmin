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
   <!-- 模态框（Modal）授权 -->
		<div class="modal fade" id="myModalRoleTree" tabindex="-1" role="dialog" 
		   aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog modal-sm">
		      <div class="modal-content">
		         <div class="modal-header">
		            <button type="button" class="close" 
		               data-dismiss="modal" aria-hidden="true">
		                  &times;
		            </button>
		            <h4 class="modal-title" id="myModalLabel">
		               	用户授权
		            </h4>
		         </div>
		         	<div class="panel-body" style="heigth:100%;">
						<ul id="treeRole" class="ztree" style="width:700px;heigth:100%;"></ul>
						<span id="userId" style="display: none"></span>
					</div>
		         <div class="modal-footer">
		            <button type="button" id="addButton" class="btn btn-primary" onclick="authenrization()">
		               	确认
		            </button>
		         </div>
		      </div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
		<script type="text/javascript">
		//授权
		function authenrization(){
			var userId = $("#userId").val();
			var treeObj=$.fn.zTree.getZTreeObj("treeRole");
	        var nodeSelect=treeObj.getCheckedNodes(true);
	        var arr = [];
	        for(var i = 0;i<nodeSelect.length;i++){
	        	if(nodeSelect[i].pId != 0){
		        	if(nodeSelect[i].roleId!=null && nodeSelect[i].roleId != "" && typeof(nodeSelect[i].roleId) != 'undefinde'){
			        	arr.push(nodeSelect[i].roleId);
			        }
	        	}
	        }
	        var params = arr.join(",");
	        $.ajax({
	        	url:'<%=basePath%>Manage/User/authenrization.do',
	        	type:'POST',
	        	data:eval('[{\"userId\":\"'+userId+'\",\"roleId\":\"'+params+'\"}]')[0],
	        	dataType:'text',
	        	success:function(result){
	        		var t = eval('('+result+')');
	        		if(t.status == -2){
	        			$('#myModalRoleTree').modal('hide');
	        			layer.msg(t.msg,{type:6,icon:2});
	        		}
	        		if(t.status == -1){
	        			$('#myModalRoleTree').modal('hide');
	        			layer.msg(t.msg,{type:6,icon:2});
	        		}
	        		if(t.status == 99){
	        			$('#myModalRoleTree').modal('hide');
	        			layer.alert('授权成功',{icon:1});
	        		}
	        	}
	        });
	        
		}
		 var settingTree = {
			        check: {
			            enable: true
			        },
			        view: {
			        	showLine: false
			        },
			        data: {
			            simpleData: {
			                enable:true,
			                idKey: "id",
			                pIdKey: "pId",
			                rootPId: ""
			            }
			        }
			    };
			    var nodesRole;
			    function initTreeNodeRole(){
					$.ajax({
						url:'<%=basePath%>Manage/Role/tree.do?userId='+$("#userId").val(),
						type:'GET',
						dataType:'text',
						async:false,
						success:function(result){
							nodesRole = eval('('+result+')');
						}
					});
					 var t2 = $("#treeRole");
				     t2 = $.fn.zTree.init(t2, settingTree, nodesRole);
				}
				//授权modalandtree
				function showRoleTree(userId){
					$('#myModalRoleTree').modal('show');
					$("#userId").val(userId);
					initTreeNodeRole();
					//授权回显
					$.ajax({
						url:'<%=basePath%>Manage/User/anthReturnView.do?userId='+userId,
						type:'GET',
						success:function(result){
							for(var i in result){
								var treeObj = $.fn.zTree.getZTreeObj("treeRole");
								var node = treeObj.getNodeByParam("roleId",result[i].roleId);
								//treeObj.selectNode(node);
								treeObj.checkNode(node, true, true);//复选框被选中
								treeObj.updateNode(node);  // 注：设置checked属性之后，一定要更新该节点，否则会出现只有鼠标滑过的时候节点才被选中的情况
							}
							
						}
					});
				}
		</script>
  </body>
</html>
