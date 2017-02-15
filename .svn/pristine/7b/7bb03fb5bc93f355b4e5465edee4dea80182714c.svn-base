<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/commons/global.jsp"%>


<html>
<head>
<title>权限添加页面</title>
<%@ include file="/commons/basejs.jsp"%>
<script type="text/javascript">
function subForm(){
	var userid = $("#userid").val();
	var roleid = $("#roleid").val();

	if(roleid == null || roleid == ""){
		layer.alert("请选择角色！");
		return;
	}
	$.post(basePath + "/user/configUserRole", {
		userid : userid,
		roleid : roleid
	}, function(data) {
		 var result = eval('(' + data + ')');
		 var index = parent.layer.getFrameIndex(window.name);
		if (result.success) {
			layer.alert("操作成功");
			parent.layer.close(index);
		} else {
			layer.alert("操作失败");
		}
	});
}




</script>
</head>
<body>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<form class="form-horizontal"   method="post">
				<div class="form-group"> 
					<input type="hidden" name="userid" id="userid" value="${user.id }"/>
					<label for="name" class="col-sm-2 control-label">用户名称</label> 
					<div class="col-md-4"> 
					<input class="form-control" type="text" id="username"  name="username" value="${user.username }" readonly="readonly"/></div> 
				</div>

			 	<div class="space-4"></div>
					
				<div class="form-group"> 
 					<label for="roleid" class="col-sm-2 control-label">角色名称</label> 
					<div class="col-md-4"> 
						<select class="form-control" name="roleid" id="roleid">
							<option value="">&nbsp;</option>
							<c:forEach items="${roles}" var="role">
								<option value="${role.id }" <c:if test="${role.flag}">selected='selected'</c:if> >${role.roleName }</option>
							</c:forEach>
						</select>
					</div>
			 	</div>
			</form>
		</div>
	</div>
</div>	
</body>
</html>