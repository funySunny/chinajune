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
<base href="<%= basePath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>重置密码验证成功</title>
<!-- BootStrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
<link href="bootstrap/css/font-awesome.min.css" rel="stylesheet"/>
<link href="bootstrap-validate/css/bootstrapValidator.min.css" rel="stylesheet"/>
<link href="css/forgetPW.css" rel="stylesheet" />

<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap-validate/js/bootstrapValidator.min.js" charset="utf-8"></script>
<script src="bootstrap-validate/js/locale/zh_CN.js"></script>
<script src="js/th_lib/MD5Factory.js"></script>
<script src="js/th_lib/TipModal.js"></script>
<script src="js/forgetPWSuccess.js"></script>
</head>
<body>

	<c:set var="un" value="${CODE}"/>
	<c:set var="UN" value="${UN}"/>
	<c:if test="${empty un && empty UN}">
  		 <c:redirect url="/index.jsp"/>
	</c:if>

<div class="container">
	<div class="row">
		<div class="col_mod_12">
		<nav style="background-color: #EDF5FA" class="navbar navbar-default navbar-fixed-top" role="navigation">
			<ul class="nav navbar-nav navbar-left">
					<li ><a href="f/Index">&laquo;返回</a></li>	
			</ul>
			<div style="width : 120px;margin:0 auto">
				<ul class="nav navbar-nav">
					<li><span class="navbar-brand">忘记密码</span></li>						
				</ul>
			</div>
		</nav>
					

		<form class="form-horizontal" role="form" action="admin/updateUser">
		<div class="col-md-12">
		
		<ul class="breadcrumb" style="margin-top:100px;">
				  <li>
    				①找回密码 <span class="divider">></span>
  				  </li>
  				  <li>
    				②验证 <span class="divider">></span>
  				  </li>
	              <li>③新密码 <span class="divider">></span></li>
  				  <li>
    				④完成验证
  				  </li>
		</ul>
		
		<input type="hidden" class="form-control" id="code" value="${ un}">
		<input type="hidden" class="form-control" id="name" value="${ UN}">
		
      		<div id="step3">
   			
   			<div class="form-group" style="padding-top:40px;">
      			<div class="col-md-5 col-md-offset-4">
      			<div class="input-group">
      				<span class="input-group-addon">
      				&nbsp;&nbsp;新密码:&nbsp;
      				</span>
      				<input class="form-control" type="password" name="password" id="password" placeholder="请输入密码(6-15个字符)" style="height:50;">
      			</div>
      			</div>
   			</div>
   			
   			<div class="form-group" style="padding-top:40px;">
      			<div class="col-md-5 col-md-offset-4">
      			<div class="input-group">
      				<span class="input-group-addon">
      				确认密码:
      				</span>
      				<input class="form-control" name="confirm_password" type="password" id="confirm_password" placeholder="请再次输入密码" style="height:50;">
      			</div>
   			</div>
   			</div>
   			
   				<ul class="pager">
   					<li id="step3-next" class="disabled"><a href="#" onclick="return false">下一步</a></li>
				</ul>
				
   				<!-- <p class="text-center" style="padding-top:40px;">
   				<button type="submit" class="btn btn-primary">提交</button>
   				</p> -->
   			</div><!-- end step3 -->
   			
   			<div id="step4">
   			
      		<div class="col-md-6 col-md-offset-3">
      				<div class="panel panel-success">
   					<div class="panel-heading">
      					<h3 class="panel-title text-center"><i class="fa fa-check"></i>完成验证</h3>
   					</div>
   					<div class="panel-body">
   					<div class="col-md-4">
      					<img width="160px" id="userPortrait" height="160px" alt="" src="userPictures/QRCode.png">
   					</div>
   					<div class="col-md-8 text-center">
   						<label id="userName"></label>
   						<br>
   						(用户ID:<label id="userID"></label>)
   					</div>
   					</div>
   				<div class="panel-footer text-center">
	   				<a href="f/Index">确定并返回</a>
   				</div>
				</div>
   			</div>
   			
   			</div><!-- end step4 -->
   			
   			</div>
			</form>

		</div>
	</div>
</div>
</body>
</html>