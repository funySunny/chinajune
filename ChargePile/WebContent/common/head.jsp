<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
    <base href="<%= basePath %>"/>
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="pragma" content="no-cache">
	<meta name="renderer" content="webkit">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="bootstrap/css/font-awesome.min.css" rel="stylesheet"/>
	<link href="css/common.css" rel="stylesheet"/>
	<!--[if lt IE 8]>
	  <link href="bootstrap/css/bootstrap-ie7.css" rel="stylesheet">
	<![endif]-->
	<script src="bootstrap/js/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="bootstrap/js/bootstrap-treeview.min.js"></script>
	<script src="js/th_lib/jQueryPlaceholder.js"></script>