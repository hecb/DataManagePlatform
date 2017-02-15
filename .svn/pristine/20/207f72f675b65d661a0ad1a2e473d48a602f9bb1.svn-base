<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/commons/global.jsp"%>


<html>
<head>
<title>操作日志</title>
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
<script type="text/javascript"
	src="${staticPath }/plugins/zTree/js/jquery.ztree.exedit.js"></script>
<script type="text/javascript">
	var setting = {
		async : {
			enable : true,//开启异步加载处理
			url : encodeURI(encodeURI(basePath + "/perm/findPerm")),
			autoParam : [ "id" ],
			contentType : "application/json",
			type : "get"
		},
		view : {
			selectedMulti : false
		},
		edit: {
			enable: true,
			showRemoveBtn: false,
			showRenameBtn: false
		},
		data : {
			simpleData : {
				enable : true
			}
		}
	};	



	function add(e) {
		var zTree = $.fn.zTree.getZTreeObj("tree"), 
			isParent = e.data.isParent, 
			nodes = zTree.getSelectedNodes(), 
			treeNode = nodes[0];
		var pid = "";
		if (treeNode) {
			pid = treeNode.id;
		} else {
			pid = "";
		}
		layer.open({
			title : [ '新增权限' ],
			type : 2,
			area : [ '700px', '530px' ],
			fixed : false, //不固定
			maxmin : true,
			btn : [ '确定', '取消' ],
			content : encodeURI(encodeURI(basePath + "/perm/addPermView?pid="
					+ pid)),
			yes : function(index, layero) {
				/* var content = $(layero).find("iframe")[0].contentWindow;
				var name = $(content.resname).val();*/
				$(layero).find("iframe")[0].contentWindow.subForm();
			},
			end : function() {
				location.reload();
			}
		});
	};
	
	
	function edit() {
		var zTree = $.fn.zTree.getZTreeObj("tree"), 
			nodes = zTree.getSelectedNodes(),
			treeNode = nodes[0];
		if (nodes.length == 0) {
			layer.alert("请先选择一个资源");
			return;
		}
		
		layer.open({
			title : [ '新增权限' ],
			type : 2,
			area : [ '700px', '530px' ],
			fixed : false, //不固定
			maxmin : true,
			btn : [ '确定', '取消' ],
			content : encodeURI(encodeURI(basePath + "/perm/modifyPermView?id="
					+ treeNode.id)),
			yes : function(index, layero) {
				$(layero).find("iframe")[0].contentWindow.subForm();
			},
			end : function() {
				location.reload();
			}
		});
	};
	
	
	function remove(e) {
		var zTree = $.fn.zTree.getZTreeObj("tree"), nodes = zTree
				.getSelectedNodes(), treeNode = nodes[0];
		if (nodes.length == 0) {
			layer.alert("请先选择一个资源");
			return;
		}

		if (treeNode.isParent) {
			layer.alert("资源" + treeNode.name + " 存在子节点，不能执行删除操作!");
		} else {
			layer.confirm('确定删除资源' + treeNode.name + '吗 ?', {
				btn : [ '确定', '取消' ]
			}, function() {
				layer.closeAll();
				$.ajax({
					type : "POST",
					url : basePath + '/perm/delPerm',
					data : {
						id : treeNode.id
					},
					dataType : "json",
					async : false,
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						layer.alert("error");
					},
					success : function(result, textStatus) {
						if (result.success) {
							layer.msg("删除成功！");
							zTree.removeNode(treeNode);
						} else {
							layer.msg("删除失败！");
						}
					}
				});
			}, function() {
				layer.close();
			});
		}

	};

	$(function() {
		$.fn.zTree.init($("#tree"), setting);
		$("#addParent").bind("click", {
			isParent : true
		}, add);
		$("#addLeaf").bind("click", {
			isParent : false
		}, add);
		$("#edit").bind("click", edit);
		$("#remove").bind("click", remove);
	});
</script>
</head>
<body>
	<div class="breadcrumbs" id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home home-icon"></i> <a href="#">主页</a></li>
			<li>权限管理</li>
		</ul>
		<!-- .breadcrumb -->
	</div>
	<div class="page-content">
		<div class="row" style="position: absolute;  left: 34%;">
			&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="addParent" href="#" title="增加资源" onclick="return false;">增加资源</a> ]
			&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="addLeaf" href="#" title="增加子资源" onclick="return false;">增加子资源</a> ]
 			&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="edit" href="#" title="编辑资源" onclick="return false;">编辑资源</a> ]
 			&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="remove" href="#" title="删除资源" onclick="return false;">删除资源</a> ]
		</div>
		<div class="row">

			<div class=".col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div style="position: absolute; top: 20%; left: 27%;">
					<ul id="tree" class="ztree"></ul>
				</div>
			</div>
		</div>

		<!-- /.row -->
	</div>
	<!-- /.page-content -->
</body>
</html>