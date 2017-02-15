<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/commons/global.jsp" %>


<html>
<head>
<title>操作日志</title>
<%@ include file="/commons/pagejs.jsp" %>
		
 </head>
<body>
        <div class="breadcrumbs" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="icon-home home-icon"></i>
                    <a href="#">主页</a>
                </li>
                <li>
                    操作日志
                </li>
            </ul><!-- .breadcrumb -->
        </div>
        <div class="page-content">
<!-- 			<div class="page-header">
				<h1>
					jqGrid
					<small>
						<i class="icon-double-angle-right"></i>
						Dynamic tables and grids using jqGrid plugin
					</small>
				</h1>
			</div>/.page-header -->
	
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
	
<!-- 					<div class="alert alert-info">
						<i class="icon-hand-right"></i>
	
						Please note that demo server is not configured to save the changes, therefore you may get an error message.
						<button class="close" data-dismiss="alert">
							<i class="icon-remove"></i>
						</button>
					</div> -->
	
					<table id="grid-table"></table>
	
					<div id="grid-pager"></div>
	
	
					<!-- PAGE CONTENT ENDS -->
				</div><!-- /.col -->
			</div><!-- /.row -->
        </div><!-- /.page-content -->
</body>

<script type="text/javascript">
			
$(function($) {
		var grid_selector = "#grid-table";
		var pager_selector = "#grid-pager";
	
		$(grid_selector).jqGrid({
			url: basePath + '/user/userlist',
			contentType : "application/json",
   			datatype : "json",
   			mtype : "post",
			height: 250,
	    	colModel : [{
	    		label : '选择',
	    		name : 'id',
	    		key : true,
	    		hidden : true
	    	}, {
	    		label : '用户名',
	    		name : 'username'
	    	}, {
	    		label : '密码',
	    		name : 'password'
	    	}],
			viewrecords : true,
			rowNum:10,
			rowList:[10,20,50],
			pager : pager_selector,
			altRows: true,
			multiselect: true,
	        multiboxonly: true,
	    	jsonReader : {
	    		root : "formList", 
	    		records : "records",
	    		page : "page", 
	    		total : "total",
	    		repeatitems : false
	    	},
	
	    	loadComplete : function() {
				var table = this;
				setTimeout(function(){
					updatePagerIcons(table);
					enableTooltips(table);
				}, 0);
			},
			autowidth: true
	
		});
	
	
		
	

		function updatePagerIcons(table) {
			var replacement = 
			{
				'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
				'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
				'ui-icon-seek-next' : 'icon-angle-right bigger-140',
				'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
			};
			$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
				var icon = $(this);
				var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
				
				if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
			})
		}
	
		function enableTooltips(table) {
			$('.navtable .ui-pg-button').tooltip({container:'body'});
			$(table).find('.ui-pg-div').tooltip({container:'body'});
		}
	
	
	});
</script>

</html>