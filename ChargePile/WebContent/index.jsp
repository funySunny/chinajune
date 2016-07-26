<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.net.URLDecoder"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
  <!-- 为了让 Bootstrap 开发的网站对移动设备友好，确保适当的绘制和触屏缩放，需要在网页的 head 之中添加 viewport meta 标签-->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <base href="<%= basePath %>"/>
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta name="renderer" content="webkit">
  <!-- <meta name="renderer" content="webkit|ie-comp|ie-stand">360 急速、IE兼容、IE模式 -->
  <!-- 前端bootstrap框架，适应手机浏览 -->
  <title>充电桩后台管理系统-用户登录</title>
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
  <link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
  <link href="css/login.css" rel="stylesheet" />
  <!--[if lt IE 8]>
      <link href="bootstrap/css/bootstrap-ie7.css" rel="stylesheet">
  <![endif]-->
  <!--[if lt IE 9]>
    <script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
    <script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
  <script src="bootstrap/js/jquery.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>
  <script src="js/th_lib/MD5Factory.js"></script>
  <script src="js/th_lib/jQueryPlaceholder.js"></script>
  <script src="js/index.js"></script>

</head>
<body>
<%
     String username = "";
     String password = "";
     String hiddenStr = "";
     //获取当前站点的所有Cookie
     Cookie[] cookies = request.getCookies();
    	 //对cookies中的数据进行遍历，找到用户名、密码的数据
    if(null != cookies){
     	for (int i = 0; i < cookies.length; i++) {
         	if ("cookieName".equals(cookies[i].getName())) {
             	username = URLDecoder.decode(cookies[i].getValue(),"utf-8");
         	} else if ("cookiePW".equals(cookies[i].getName())) {
             	password = cookies[i].getValue();
         	}
    	}
    }
    	 if(!"".equals(username)&& !"".equals(password)){
    		 hiddenStr = username+"-"+password;
    	 }
 %>
 <span style="display:none;" id="hiddenStr"><%=hiddenStr %></span>
<div class="container m-login m-login-bg">
  <div class="panel panel-success login">
      <h2 class="panel-title text-center title"> 
        <img src="img/logo_dl.png" alt="">
        智能充电桩后台管理系统
      </h2>
        <form class="form-horizontal"  role="form" action="${pageContext.request.contextPath}/login/pc" method="post">
        <div class="form-group">
          <label class="col-md-2"><i class="glyphicon glyphicon-user icon"></i></label>
          <div class="col-md-10">
            <input type="text" name="userName" class="form-control" placeholder="请输入账号">
            <span class="note"><c:if test="${errorCode == 1}">&times;${errorMsg }</c:if></span>
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-2"><i class="glyphicon glyphicon-lock icon"></i></label>
          <div class="col-md-10">
            <input type="password" name="pw" class="form-control" placeholder="请输入密码">
            <span class="note"><c:if test="${errorCode == 2}">&times;${errorMsg }</c:if></span>
          </div>
        </div>
        <div class="form-group jzpwd">
          <div class="checkbox col-md-9">
            <label style="font-size:12px;">
              <input id="autoLogin" name="isRemember" type="checkbox" value="true" />记住密码（请勿在公共电脑使用）</label>
          </div>
          <button type="button" class="col-md-3 btn btn-primary">登录</button>
        </div>
        </form>
      <div class="panel-footer" >
        <a href="f/Register" class="btn">新用户注册</a>
        <a href="f/ForgetPassword" class="btn">忘记密码？</a>
      </div>           
  </div>
</div>
<div class="m-footer">
  <a href="pages/City.jsp">CITY</a>
  <p class="copyright">©版权所有 <a href="http://www.chinajune.com/" target="_blank">深圳市中工巨能科技有限公司</a></p>
</div>
</body>
</html>