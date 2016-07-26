<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<jsp:include page="../common/head.jsp"/>
<!-- BootStrap -->
<meta name="author" content="">
<meta name="keywords" content="充电桩后台管理系统">
<meta name="description" content="">
<title>充电桩后台管理系统(顾客)-首页</title>
<!-- BootStrap -->
<link href="bootstrap/css/bootstrap-treeview.min.css" rel="stylesheet">
<link href="css/customerHome.css" rel="stylesheet"/>

<script src="js/customerHome.js"></script>
</head>
<body>
	<% if(null == session.getAttribute("userName")){ %>
  		 <c:redirect url="/index.jsp"/>
 	<% } %>
			<span id="userName" style="display:none;">${sessionScope.userName }</span>
 <jsp:include page="../common/header.jsp"/>            
<div class="container" style="width:100%;">
	<div class="row">
	<div class="col-md-2" style="padding:0px;">
			<ul id="main-nav" class="main-nav nav nav-tabs nav-stacked" style="">
                    <li class="active">
                        <a href="javascript:location.reload();">
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
                            <li><a href="pages/userManage.jsp"><i class="fa fa-desktop"></i>&nbsp;电脑用户管理</a></li>
                            <li><a href="pages/Map.jsp"><i class="fa fa-tablet"></i>&nbsp;手机用户管理</a></li>
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
                            <li><a href="f/CPM"><i class="fa fa-plug"></i>&nbsp;充电桩管理</a></li>
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
	
	<h1>充电桩分布</h1><small class="label label-info">共有充电桩<label id="tatolChargePoint" class="text-warning"></label>台</small>
	
	 <div id="treeview2" class=""></div>
	
	</div>
	</div><!-- end row -->
	
	</div><!-- end container -->
		<jsp:include page="../common/footer.jsp"/>	
</body>

</html>