<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/commons/global.jsp"%>


<html>
<head>
<title>权限添加页面</title>
<%@ include file="/commons/basejs.jsp"%>

<link rel="stylesheet" href="${staticPath }/plugins/zTree/css/demo.css"
	type="text/css">
<link rel="stylesheet"
	href="${staticPath }/plugins/zTree/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript"
	src="${staticPath }/plugins/zTree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript"
	src="${staticPath }/plugins/zTree/js/jquery.ztree.core.min.js"></script>
<script type="text/javascript"
	src="${staticPath }/plugins/zTree/js/jquery.ztree.excheck.min.js"></script>

<script type="text/javascript">

var setting = {
 	 async : {
			enable : true,//开启异步加载处理
			url : encodeURI(encodeURI(basePath + "/role/findRolePerms?id="+${role.id })),
			autoParam : [ "id" ],
			contentType : "application/json",
			type : "get"
		},
		check: {
			enable: true
		},
		data: {
			simpleData: {
				enable: true
			}
		}
	};


	
	function setCheck() {
		var zTree = $.fn.zTree.getZTreeObj("tree"),
		type = { "Y":"ps", "N":"ps"};
		zTree.setting.check.chkboxType = type;
	}
	
	$(function() {
		$.fn.zTree.init($("#tree"), setting);
		setCheck();
	});



function subForm(){
	var roleid = $("#roleid").val();
	var arr = [];
	
	var treeObj = $.fn.zTree.getZTreeObj("tree");
    var nodes = treeObj.getCheckedNodes(true);
	$.each(nodes,function(index,node){
  	    // alert(index+"..."+node.id);
		arr.push(node.id);
		
  	})
	
    $.ajax({
        type:"POST",
        traditional :true,
        url: encodeURI(encodeURI(basePath + "/role/configRolePerm")),
        dataType:"json",
        data:{'permids' : arr,'roleid' : roleid},
        error:function(XMLHttpRequest, textStatus, errorThrown){
            layer.alert("error");
        },
        success:function(result,textStatus){
	   		var index = parent.layer.getFrameIndex(window.name);
	   		if (result.success) {
	   			layer.alert("操作成功");
	   			parent.layer.close(index);
	   		} else {
	   			layer.alert("操作失败");
	   		}
        }
    });
/* 	$.post(basePath + "/role/configRolePerm", {
		'permids' : arr,
		'roleid' : roleid
	}, function(data) {
		alert(data);
		 var result = eval('(' + data + ')');
		 var index = parent.layer.getFrameIndex(window.name);
		if (result.success) {
			layer.alert("操作成功");
			parent.layer.close(index);
		} else {
			layer.alert("操作失败");
		}
	}); */
}




</script>
</head>
<body>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<form class="form-horizontal"   method="post">
				<div class="form-group"> 
					<input type="hidden" name="roleid" id="roleid" value="${role.id }"/>
					<label for="name" class="col-sm-2 control-label">角色名称</label> 
					<div class="col-md-4"> 
					<input class="form-control" type="text" id="roleName"  name="roleName" value="${role.roleName }" readonly="readonly"/></div> 
				</div>

			 	<div class="space-4"></div>
					
				<div class="form-group"> 
 					<label for="roleid" class="col-sm-2 control-label">权限信息</label> 
 					<div class="col-md-4"> 
					<div style="position: absolute; top: 80%; left: 2%;">
					<ul id="tree" class="ztree"></ul>
					</div></div>
			 	</div>
			</form>
		</div>
	</div>
</div>	
</body>
</html>