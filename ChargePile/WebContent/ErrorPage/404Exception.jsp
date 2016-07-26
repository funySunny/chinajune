<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<base href="<%= basePath %>"/>

<meta name="renderer" content="webkit">
	<!-- <meta name="renderer" content="webkit|ie-comp|ie-stand">360 急速、IE兼容、IE模式 -->
<title>页面出错</title>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
</HEAD>
<body>
  <div style="text-align:center;height:400px;color:red;">
	<h1 style="line-height:400px;">页面未找到<span></span><a href="#">点击</a>重新登录...</h1>
  </div>

</body>
</html>
