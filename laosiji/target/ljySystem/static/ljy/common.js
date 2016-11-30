/**
 * 通用js
 * qq BY237442461 2016-9-3
 * 
 * @param url
 */

/**
 * 执行添加数据
 */
function add(url){
		var form=$("[method='add']");
		var params="";	
		for(var i =0;i<form.size();i++){
			if($.trim($(form[i]).val()) == ""){
				layer.alert('请将添加信息填写完整！',{icon:7});
				return;
			}
			params+=""+(form[i].name)+":'"+$(form[i]).val()+"',";
		}
		params="[{"+params+"tmp:''}]";
		$.ajax({
			url:url,
			type:'POST',
			data:eval(params)[0],
			dataType:'text',
			async:false,//同步加载
			success: function(result){
			console.log(result);
				var t = eval('('+result+')');
				if(t.status == '99'){
					$('#myModalAdd').modal('hide');
					//刷新表格
					refreshTable();
					layerBlackTwoSeconedNoReload('添加成功');
				}
				if(t.status == '-1'){
					$('#myModalAdd').modal('hide');
					layer.laert('添加失败', {icon: 2});
				}
			}
		});
}
/**
 * treeAdd
 * @param url
 * @return
 */
function addTree(url){
	var nodeId = $.fn.zTree.getZTreeObj("tree").getSelectedNodes()[0].id;
	var form=$("[method='add']");
	var params="";	
	for(var i =0;i<form.size();i++){
		if($.trim($(form[i]).val()) == ""){
			layer.alert('请将添加信息填写完整！',{icon:7});
			return;
		}
		params+=""+(form[i].name)+":'"+$(form[i]).val()+"',";
	}
	params+="treeId:'"+nodeId+"',";
	params="[{"+params+"tmp:''}]";
	$.ajax({
		url:url,
		type:'POST',
		data:eval(params)[0],
		dataType:'text',
		async:false,//同步加载
		success: function(result){
			var t = eval('('+result+')');
			if(t.status == '99'){
				$('#myModalAdd').modal('hide');
				//刷新表格
				refreshTable();
				layerBlackTwoSeconedNoReload('添加成功');
			}
			if(t.status == '-1'){
				$('#myModalAdd').modal('hide');
				layer.alert('添加失败',{icon: 2});
			}
		}
	});
}


/**
 * 执行删除数据操作
 * @param url
 * @return
 */
function del(url){
	var ids = $("#table").bootstrapTable('getSelections');
	if(ids.length != 0){
		var _ids = "";
		for(i = 0; i < ids.length; i++){
			_ids += ids[i].id+"|";
		}
		//询问框
		layer.confirm('您确定要删除选中行数据吗？', {
		  btn: ['确认','取消'] //按钮
		},  function(){
			$.ajax({
				url:url,
				type:'get',
				data:{'ids':_ids},
				dataType:'text',
				async:false,
				success:function(result){
					var t = eval('('+result+')');
					if(t.status == '99'){
						//刷新表格
						refreshTable();
						layer.msg('删除成功', {icon: 1});
					}
					if(t.status == '-1'){
						//刷新表格
						refreshTable();
						layer.msg(t.msg, {icon: 2});
						
					}
				}
			});
		},function(){
			layer.closeAll();
		}
		);
	}else{
		layer.msg('请选中行再进行删除操作', {icon: 2});
	}
}

/**
 * 提示信息并重新加载列表
 * @param infomation
 * @return
 */
function layerBlackTwoSeconed(infomation){
	layer.msg(infomation, {
		  icon: 1,
		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
		}, function(){
			location.reload(true);
	});
}
/**
 * 提示信息不重新加载列表
 * @param infomation
 * @return
 */
function layerBlackTwoSeconedNoReload(infomation){
	layer.msg(infomation, {
		  icon: 1,
		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
		}, function(){
	});
}

/**
 * 弹出添加模态狂
 * @return
 */
function showAddModel(){
	$("[method='add']").each(function(){
		$(this).val("");
	});
	$('#myModalAdd').modal('show');
}

function showAddModelTree(){
	if(typeof($.fn.zTree.getZTreeObj("tree").getSelectedNodes()[0]) == "undefined"){
		layer.alert('请选择数据分类再进行添加操作',{icon:7});
		return;
	}
	if($.fn.zTree.getZTreeObj("tree").getSelectedNodes()[0].pId == 0){
		layer.alert('请选择数据分类的叶子节点再进行添加操作',{icon:7});
		return;
	}
	$("[method='add']").each(function(){
		$(this).val("");
	});
	$('#myModalAdd').modal('show');
}
/**
 * 弹出编辑模态框
 * @return
 */
function showEditModel(){
	var selections = $("#table").bootstrapTable('getSelections');
	if(selections.length>1){
		layer.alert('请选择一条记录,再进行修改操作 ',{icon:7});
		return;
	}
	if(selections!=null && selections != ""){
		var from = $("[method='edit']");
		var size = from.size();
		var fromName;
		for(var i = 0;i<size; i++){
			fromName = from[i].name;
			$('#myModalEdit').find("input[name = '"+fromName+"']").val(selections[0].fromName);
		}
		$('#myModalEdit').modal('show');
	}else{
		layer.alert('请选择要修改的记录 ',{icon:7});
	}
}
/**
 * 刷新表格
 * @return
 */
function refreshTable(){
	$('#table').bootstrapTable('refresh');
}

/**
 * 根据树id和节点的名称填充下拉框
 * @param name
 * @param treeId
 * @return
 */
function selSelections(name,treeId){
	console.log(name);
	$.ajax({
		url:'Manage/Dictionary/getSelections.do?treeId=' + treeId,
		type:'GET',
		success:function(result){
			if(typeof(result) != "undefined"){
				for(var i = 0;i < result.length; i++){
					console.log(result[i].code);
					$("select[name='"+name+"']").append("<option value="+result[i].code+">"+result[i].name+"</option>");
				}
			}
		}
	});
	
}
























