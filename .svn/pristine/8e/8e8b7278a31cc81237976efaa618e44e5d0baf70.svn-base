<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/commons/global.jsp"%>


<html>
<head>
<title>权限添加页面</title>
<%@ include file="/commons/basejs.jsp"%>
<script type="text/javascript">
function subForm(){
	var name = $("#name").val();
	var action = $("#action").val();
	/* var module = $("#module").val(); */
	var pid = $("#pid").val();
	var seq = $("#seq").val();
	var type = $("#type").val();
	if(name == null || name == ""){
		layer.alert("请输入菜单或按钮名称！");
		return;
	}
	if(type == null || type == ""){
		layer.alert("请选择资源类型！");
		return;
	}
	

	$.post(basePath + "/perm/addPerm", {
		name : name,
//		module : module,
		pid : pid,
		seq : seq,
		type : type
	}, function(data) {
		 var result = eval('(' + data + ')');
		 var index = parent.layer.getFrameIndex(window.name);
		if (result.success) {
			layer.alert("保存成功");
			parent.layer.close(index);
		} else {
			layer.alert(result.msg);
		}
	});
}




</script>
</head>
<body>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<form class="form-horizontal" id="permForm" action="${staticPath }/perm/addPerm" method="post">
				<div class="form-group"> 
					<label for="name" class="col-sm-2 control-label">资源名称</label> 
					<div class="col-md-4"> 
					<input class="form-control" type="text" id="name"  name="name" value="${prem.name }" /></div> 
					<label for="action" class="col-sm-2 control-label">资源URL地址</label> 
					<div class="col-md-4"> 
					<input class="form-control" type="text" id="action" name="action" value="${prem.action }"/></div>
				</div>
				
					<div class="space-4"></div>
					
				<div class="form-group"> 
					<label for="seq" class="col-sm-2 control-label">排序</label> 
					<div class="col-md-4"> 
					<input class="form-control" type="text" id="seq" name="seq" value="${prem.seq }" readonly="readonly"/></div> 
					<label for="pid" class="col-sm-2 control-label">所属父节点</label> 
					<div class="col-md-4"> 
					<input class="form-control" type="text" id="pid" name="pid" value="${prem.pid }" readonly="readonly"/></div>
				</div>
					
				<div class="space-4"></div>
					
				<div class="form-group"> 
<%-- 				<label for="module" class="col-sm-2 control-label">所属模版</label> 
					<div class="col-md-4"> 
						<select class="form-control" name="module" id="module">
							<option value="">&nbsp;</option>
							<c:forEach items="${modules}" var="a">
								<option value="${a }">${a }</option>
							</c:forEach>
							
						</select>
					</div>  --%>
					<label for="type" class="col-sm-2 control-label">资源类型</label> 
					<div class="col-md-4"> 
						<select class="form-control" name="type" id="type">
									<option value="">&nbsp;</option>
									<option value="menu">菜单</option>
									<option value="btn">按钮</option>
						</select>
					</div>
			 	</div>

			</form>
		</div>
	</div>
</div>	
</body>
</html>