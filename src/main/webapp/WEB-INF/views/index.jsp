<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>首页</title>
	<%@ include file="/commons/basejs.jsp" %>
	<script type="text/javascript">
	function logout(){
		layer.confirm('确定退出登录吗 ?', {
				btn: ['确定','取消'] //按钮
			},function(){
				layer.closeAll();
		            $.post(basePath + '/logout', function(result) {
		                if(result.success){
		                    window.location.href=basePath + '/login';
		                }
		            }, 'json');
			}, function(){
				layer.close();
			});
		 }
	</script>
</head>

<body>

<%@ include file="../views/system/head.jsp" %>
<div class="main-container" id="main-container">
	<div class="main-container-inner">
		<a class="menu-toggler" id="menu-toggler" href="#">
			<span class="menu-text"></span>
		</a>
		<%@ include file="../views/system/left.jsp" %>
		<div class="main-content" id="mains">
			<iframe id="mainframe" name="mainframe" src="${staticPath }/defaultjsp" style="width: 100%;border: 0px;"></iframe>
		</div>
	</div>
</div>
<script type="text/javascript">
		var height = jQuery(window).height() - 50;
		jQuery("#mainframe").attr("height", "" + height + "px;");
</script>
</body>
</html>

