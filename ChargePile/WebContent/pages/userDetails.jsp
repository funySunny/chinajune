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
<title>用户信息详情</title>
<base href="<%= basePath %>"/>
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="pragma" content="no-cache">
<meta name="renderer" content="webkit">
<!-- BootStrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
<link href="bootstrap/css/font-awesome.min.css" rel="stylesheet"/>
<link href="bootstrap/css/fileinput.min.css" rel="stylesheet"/>
<link href="bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet"/>
<link href="bootstrap-validate/css/bootstrapValidator.min.css" rel="stylesheet"/>
<%-- <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" /> --%>

<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/js/fileinput.min.js" charset="utf-8"></script>
<script src="bootstrap/js/fileinput_locale_zh.js"></script>
<script src="bootstrap-select/js/bootstrap-select.min.js"></script>
<script src="bootstrap-select/js/i18n/defaults-zh_CN.min.js"></script>
<script src="bootstrap-validate/js/bootstrapValidator.min.js" charset="utf-8"></script>
<script src="bootstrap-validate/js/locale/zh_CN.js"></script>
<script src="js/th_lib/BootstrapAlert.js"></script>
<script src="js/th_lib/MD5Factory.js"></script>
<script src="js/userDetails.js" charset="utf-8"></script>
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
					
		<form class="form-horizontal" role="form" id="form1" action="admin/updateUser">
		<div class="col-md-6">
   			<div class="form-group" style="padding-top:100px;">
      			<label for="name" class="control-label col-md-2">用户名称:</label>
      			<div class="col-md-8 input-group">
      			<span class="input-group-addon">
      			<span class="glyphicon glyphicon-user"></span>
      			</span>
      			<input type="text" class="form-control" id="name" name="name"
         		placeholder="请输入名称" value="${jsonData.userName }" disabled="disabled">
         		</div>
   			</div>
   			<div class="form-group" style="padding-top:40px;">
      			<label for="pw" class="control-label col-md-2">新密码:</label>
      			<div class="col-md-8 input-group">
      				<span class="input-group-addon">
      					<span class="glyphicon glyphicon-lock"></span>
      				</span>
      				<input class="form-control" type="password" name="pw" 
      				placeholder="请输入原始密码" value="${jsonData.pw }">
      			</div>
   			</div>
   			<span class="help-block col-md-offset-3" id="pwMessage"></span>
   			<div class="form-group" style="padding-top:40px;">
      			<label for="pw" class="control-label col-md-2">确认密码:</label>
      			<div class="col-md-8 input-group">
      			<span class="input-group-addon">
      				<span class="glyphicon glyphicon-lock"></span>
      			</span>
      			<input class="form-control" type="password" name="rpw" 
      			placeholder="请再次输入密码" value="">
      			</div>
   			</div>
      			<span class="help-block col-md-offset-3" id="rpwMessage"></span>
   			<div class="form-group" style="padding-top:30px;">
      			<label class="control-label col-md-2">邮箱:</label>
      			<div class="input-group col-md-8">
      			<span class="input-group-addon">
      			<span class="glyphicon glyphicon-envelope"></span>
      			</span>
      			<input type="email" name="email" class="form-control"
      			placeholder="请输入邮箱" value="${jsonData.email }">
      			</div>
   			</div>
   				<span class="help-block col-md-offset-3" id="emailMessage"></span>
   			<div class="form-group" style="padding-top:40px;">
      			<label class="control-label col-md-2">注册时间:</label>
      			<div class="input-group col-md-8">
      			<span class="input-group-addon">
      			<span class="fa fa-clock-o"></span>
      			</span>
      			<input type="text" class="form-control" value="${jsonData.regTime }" disabled="disabled">
      			</div>
   			</div>
   			
      		<span id="access" style="display:none;">${jsonData.access }</span>
   			<div class="form-group" style="padding-top:40px;">
      		<label class="control-label col-md-2">用户权限:</label>
      		<select id="select" class="col-md-8 selectpicker">
      			<option value="1">1(管理员)</option>
      			<option value="2">2(销售专员)</option>
      			<option value="3">3(普通用户)</option>
      		</select>
      		
   			</div>
   		</div>
   		
   		<div class="col-md-6">
   			
   		</div>
			</form>
			<span id="headURL" style="display:none;">${jsonData.headPortrait }</span>
			<form class="form-horizontal" method="post" enctype="multipart/form-data" id="form2" action="common/uploadUserPhoto">
   			<div class="form-group col-md-6" style="padding-top:100px;">
   				<label for="name" class="control-label col-md-2">用户头像:</label>
         		<div class="col-md-8">
   					<div class="input-group">
   					<!-- multiple表示允许同时上传多个文件 -->
      					<input name="file" type="file" id="headPhoto">
      					<input type="hidden" name="fileName" value="">
      				</div>
      			</div>
      		</div>
      			<div class="col-md-6" id="Alert"></div>
      		
			</form>
		<div class="col-md-12">
   				<p class="text-center" style="padding-top:40px;">
   				<button id="submit1" type="button" disabled="true" class="btn btn-primary">提交</button>
   				</p>
   		</div>

		</div>
	</div>
</div>
</body>
</html>