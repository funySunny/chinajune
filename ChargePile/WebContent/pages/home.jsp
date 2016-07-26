<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
<head>
<jsp:include page="../common/head.jsp"/>
<!-- BootStrap -->
<meta name="author" content="">
<meta name="keywords" content="充电桩后台管理系统">
<meta name="description" content="">
<title>充电桩后台管理系统-首页</title>
<!-- BootStrap -->
<link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet"/>

<script src="${pageContext.request.contextPath}/js/home.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=FbzOyQ4YujPrZsxiQKoB07aB"></script>
</head>
<body>
	<% if(null == session.getAttribute("userName")){ %>
  		 <c:redirect url="/index.jsp"/>
 	<% } %>
 <jsp:include page="../common/header.jsp"/>
<div class="container" style="width:100%;">
	<div class="row">
	<div class="col-md-2" style="padding:0px;">
			<ul id="main-nav" class="main-nav nav nav-tabs nav-stacked" style="">
                    <li class="active">
                        <a href="${pageContext.request.contextPath}/f/Home">
                            <i class="glyphicon glyphicon-th-large"></i>
                           	 首页 		
                        </a>
                    </li>
                    <li>
                        <a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse">
                            <i class="glyphicon glyphicon-cog"></i>
                          	  系统管理
                            <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
                        </a>
                        <ul id="systemSetting" class="nav nav-list secondmenu collapse">
                            <li><a href="${pageContext.request.contextPath}/f/UserManage"><i class="glyphicon glyphicon-user"></i>&nbsp;用户管理</a></li>
                            <li><a href="${pageContext.request.contextPath}/pages/Map.jsp"><i class="glyphicon glyphicon-th-list"></i>&nbsp;菜单管理</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>&nbsp;角色管理</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-edit"></i>&nbsp;修改密码</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>&nbsp;日志查看</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#configSetting" class="nav-header collapsed" data-toggle="collapse">
                            <i class="glyphicon glyphicon-credit-card"></i>
                          	  设备管理	
                                   <span class="pull-right glyphicon  glyphicon-chevron-toggle"></span>
                        </a>
                        <ul id="configSetting" class="nav nav-list secondmenu collapse">
                            <li><a href="${pageContext.request.contextPath}/f/CPM"><i class="glyphicon glyphicon-globe"></i>&nbsp;充电桩管理</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-star-empty"></i>&nbsp;未开通用户配置</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-star"></i>&nbsp;退订用户配置</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-text-width"></i>&nbsp;试用用户配置</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-ok-circle"></i>&nbsp;开通用户配置</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">
                            <i class="glyphicon glyphicon-fire"></i>
                            		关于系统
                            <span class="badge pull-right">1</span>
                        </a>
                    </li>

                </ul><!-- end ul main-nav -->
			
	</div>
	
	<div class="col-md-10">
		 <ol class="breadcrumb">
  					<li class="active">首页</li>
		</ol>
	
	<h1>充电桩分布</h1><small class="help-block"></small>
	
	</div>
	</div><!-- end row -->
	
	</div><!-- end container -->
	<jsp:include page="../common/footer.jsp"/>
</body>

</html>