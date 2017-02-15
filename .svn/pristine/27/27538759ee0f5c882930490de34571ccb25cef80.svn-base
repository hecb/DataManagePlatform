<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="sidebar" id="sidebar">
		<ul class="nav nav-list" >
			<li class="active">
				<a href="default.jsp" target="mainframe">
					<i class="icon-dashboard"></i> 
					<span class="menu-text">首页 </span>
				</a>	
			</li> 
            <c:forEach items="${menus}" var="menu"> 
            <li >
            	<c:choose>
            	<c:when test="${(menu.permList)!= null && fn:length(menu.permList) > 0}">
	            	<a href="javascript:void(0)" target="mainframe" class="dropdown-toggle"> 
		    			<i class="icon-desktop"></i> 
						<span class="menu-text"> ${menu.name } </span> 
							<b class="arrow icon-angle-down"></b>
					</a>
					<ul class="submenu">
						<c:forEach items="${menu.permList}" var="menu2"> 
	                         <li><a href="${staticPath }/${menu2.action}" target="mainframe"> 
								<i class="icon-desktop"></i>${menu2.name }</a>
							</li>
						</c:forEach>
					</ul>
					
            	</c:when>
            	<c:otherwise>
            	<a href="${staticPath }/${menu.action}" target="mainframe" class="dropdown-toggle"> 
	    			<i class="icon-desktop"></i> 
					<span class="menu-text"> ${menu.name }</span> 
				</a>
            	</c:otherwise>
            	</c:choose>

			</li> 
            </c:forEach>  
	    	
	  
		</ul>

		<div class="sidebar-collapse" id="sidebar-collapse">
			<i class="icon-double-angle-left" data-icon1="icon-double-angle-left"data-icon2="icon-double-angle-right"></i>
		</div>
</div>