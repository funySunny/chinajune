<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" import="com.ChargePoint.bean.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
  	<link href="${pageContext.request.contextPath}/images/company_logo.png" rel="shortcut icon"/>
    <base href="<%=basePath%>">
    <title>用户信息设值</title>
    <meta name="renderer" content="webkit">
	<!-- <meta name="renderer" content="webkit|ie-comp|ie-stand">360 急速、IE兼容、IE模式 -->
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

  </head>
  
  <body>
  <form method="post">
  <%
	  	 if(null == session.getAttribute("userName")){
  %>
  		 <c:redirect url="/index.jsp"/>
 	<%
		}
 	%>
 
 
 
  </form>