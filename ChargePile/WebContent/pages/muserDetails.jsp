<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>MUserDetails</title>
<base href="<%= basePath %>"/>
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="pragma" content="no-cache">
<meta name="renderer" content="webkit">
<!-- BootStrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
<link href="bootstrap/css/font-awesome.min.css" rel="stylesheet"/>
<link href="bootstrap/css/fileinput.min.css" rel="stylesheet"/>
<%-- <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" /> --%>

<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/fileinput.min.js" charset="utf-8"></script>
<script src="bootstrap/js/fileinput_locale_zh.js"></script>
<script src="js/muserDetails.js" charset="utf-8"></script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col_mod_12" >
		<nav style="background-color: #EDF5FA" class="navbar navbar-default navbar-fixed-top" role="navigation">
			<ul class="nav navbar-nav navbar-left">
					<li ><a href="javascript:window.close();">&laquo;返回</a></li>	
			</ul>
			<div style="width : 200px;margin:0 auto">
				<ul class="nav navbar-nav">
					<li><span class="navbar-brand">用户名:${jsonData.userName }</span></li>						
				</ul>
			</div>
			<ul class="nav navbar-nav navbar-right">
					<li><span class="navbar-brand">用户信息</span></li>						
			</ul>
		</nav>
					
		<form class="form-horizontal" role="form">
		<div class="col-md-6">
   			<div class="form-group" style="padding-top:100px;">
      			<label for="name" class="control-label col-md-2">用户名称:</label>
      			<div class="col-md-8 input-group">
      			<span class="input-group-addon">
      			<span class="glyphicon glyphicon-user"></span>
      			</span>
      			<input type="text" class="form-control" id="name" 
         		placeholder="请输入名称" value="${jsonData.userName }">
         		</div>
   			</div>
   			<div class="form-group" style="padding-top:40px;">
   				<label for="name" class="control-label col-md-2">用户头像:</label>
   				<div class="col-md-8 input-group">
   				<!-- multiple表示允许同时上传多个文件 -->
      					<input type="file" id="headPhoto">
      			</div>
      		</div>
   			<div class="form-group" style="padding-top:40px;">
      			<label for="pw" class="control-label col-md-2">密码:</label>
      			<div class="col-md-8 input-group">
      			<span class="input-group-addon">
      			<span class="glyphicon glyphicon-lock"></span>
      			</span>
      			<input class="form-control" type="password" id="pw" 
      			placeholder="请输入密码" value="${jsonData.pw }">
      			</div>
   			</div>
   			<div class="form-group" style="padding-top:40px;">
      			<label for="pw" class="control-label col-md-2">确认密码:</label>
      			<div class="col-md-8 input-group">
      			<span class="input-group-addon">
      			<span class="glyphicon glyphicon-lock"></span>
      			</span>
      			<input class="form-control" type="password" id="pw" 
      			placeholder="请再次输入密码" value="">
      			</div>
   			</div>
   			<div class="form-group" style="padding-top:40px;">
      			<label class="control-label col-md-2">注册时间:</label>
      			<div class="input-group col-md-8">
      			<span class="input-group-addon">
      			<span class="glyphicon glyphicon-envelope"></span>
      			</span>
      			<input type="email" disabled class="form-control" 
      			 value="${jsonData.regTime }">
      			</div>
   			</div>
   			
   		</div>
   		<div class="col-md-6">
   			<div class="form-group" style="padding-top:100px;">
      			<label class="control-label col-md-2">车架号:</label>
      			<div class="input-group col-md-8">
      			<span class="input-group-addon">
      			<span class="glyphicon glyphicon-envelope"></span>
      			</span>
      			<input type="text" disabled class="form-control" 
      			 value="${jsonData.carFrameNO }">
      			</div>
   			</div>
   			<div class="form-group" style="padding-top:40px;">
      			<label class="control-label col-md-2">车品牌:</label>
      			<div class="input-group col-md-8">
      			<span class="input-group-addon">
      			<span class="glyphicon glyphicon-envelope"></span>
      			</span>
      			<input type="text" disabled class="form-control" 
      			 value="${jsonData.carType }">
      			</div>
   			</div>
   			<div class="form-group" style="padding-top:40px;">
      			<label class="control-label col-md-2">车类型:</label>
      			<div class="input-group col-md-8">
      			<span class="input-group-addon">
      			<span class="glyphicon glyphicon-envelope"></span>
      			</span>
      			<input type="text" disabled class="form-control" 
      			 value="${jsonData.interfaceType }">
      			</div>
   			</div>
   			<div class="form-group" style="padding-top:40px;">
      			<label class="control-label col-md-2">手机号:</label>
      			<div class="input-group col-md-8">
      			<span class="input-group-addon">
      			<span class="glyphicon glyphicon-earphone"></span>
      			</span>
      			<input type="number" class="form-control" placeholder="请输入电话号码" value="${jsonData.tel }">
      			</div>
   			</div>
   			<div class="form-group" style="padding-top:40px;">
      			<label class="control-label col-md-2">真实姓名:</label>
      			<div class="input-group col-md-8">
      			<span class="input-group-addon">
      			<span class="fa fa-desktop"></span>
      			</span>
      			<input type="text" class="form-control" value="${jsonData.trueName }" placeholder="请输入真实姓名">
      			</div>
   			</div>
   			
   			<div class="form-group" style="padding-top:40px;">
      		<label class="control-label col-md-2">性别:</label>
      		
      		<label class="checkbox-inline">
      			<input type="radio" name="optionsSex" id="optionsRadios3" 
         		value="option1" checked> 男
   			</label>
   			<label class="checkbox-inline">
      			<input type="radio" name="optionsSex" id="optionsRadios4" 
         	value="option2"> 女
   			</label>
      		
   			</div>
   			<div class="form-group" style="padding-top:40px;">
      			<label class="control-label col-md-2">身份证号:</label>
      			<div class="input-group col-md-8">
      			<span class="input-group-addon">
      			<span class="glyphicon glyphicon-earphone"></span>
      			</span>
      			<input type="text" class="form-control" value="${jsonData.identity }" placeholder="请输入身份证号">
      			</div>
   			</div>
   			<div class="form-group" style="padding-top:40px;">
      			<label class="control-label col-md-2">账户余额:</label>
      			<div class="input-group col-md-8">
      			<span class="input-group-addon">
      			<span class="fa fa-jpy"></span>
      			</span>
      			<input type="text" class="form-control" value="${jsonData.money }" disabled="disabled">
      			</div>
   			</div>
   		</div>
   		<div class="col-md-12">
   				<p class="text-center" style="padding-top:40px;">
   				<button type="submit" class="btn btn-primary">提交</button>
   				</p>
   		</div>
			</form>

		</div>
	</div>
</div>
</body>
</html>