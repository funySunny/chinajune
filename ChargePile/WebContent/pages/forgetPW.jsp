<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
<head>
<base href="<%= basePath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>重置密码</title>
<!-- BootStrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
<link href="bootstrap-validate/css/bootstrapValidator.min.css" rel="stylesheet"/>
<link href="bootstrap/css/font-awesome.min.css" rel="stylesheet"/>
<link href="css/login.css" rel="stylesheet" />

<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap-validate/js/bootstrapValidator.min.js" charset="utf-8"></script>
<script src="bootstrap-validate/js/locale/zh_CN.js"></script>
<script src="js/th_lib/MD5Factory.js"></script>
<script src="js/th_lib/TipModal.js"></script>
<script src="js/forgetPW.js"></script>
</head>
<body>
<div class="container">
	<div class="row m-login">
		<div class="col_mod_12 m-forgetpw">
		<nav class="navbar navbar-default navbar-fixed-top  nav-tle" role="navigation">
      <a class="back" href="f/Index"><i class="glyphicon glyphicon-share-alt icon"></i>返回</a>
      <h2>忘记密码</h2>
		</nav>
    <!-- 表单 -->
    <input type="hidden" value="${step}" id="js-step" />  
		<form class="form-horizontal" id="js-forgetPaw" action="pc/resetPCUserPW" role="form" autocomplete="off">
		<div class="col-md-12">
      <ul class="nav nav-pills" id="js-nav">
        <li>填写账户名 &nbsp;&gt; </li>
        <li>验证身份 &nbsp;&gt; </li>
        <li>设置新密码 &nbsp;&gt; </li>
        <li>完成</li>
      </ul>
		  <div id="step1" class="step">
   			<div class="form-group nobd" >
  				<div class="input-group">
      			<span class="input-group-addon">用户名:</span>
  					<input type="text" class="form-control" id="name" name="name" 
     				placeholder="请输入名称(6-15个字符)" value="${user.user_name}" />
  				</div>
   			</div>
   			<div class="form-group" >
  				<div class="input-group">
  					<span class="input-group-addon">验证码:</span>
  					<input type="text" class="form-control" id="validateCode" name="validateCode" placeholder="请输入右侧验证码">
       			<span class="input-group-addon vrf">
        				<img id="imgValidate" title="点击图片刷新" alt="验证码" src="common/getCodeImg"/>
  					</span>
  				</div>
   			</div>
   			<ul class="pager">
  				<li id="step1-next" data-id='1' class="disabled nt"><a href="javascript:void(0)" class="btn" onclick="return false">下一步</a></li>
			  </ul>
			</div>
   		<div id="step2" class="step">
        <div class="tab-content email">
          <div class="form-group" >
              <i class="icon"></i>
              <input type="hidden" name="email" value="${user.email}" />
              <span id="js-email" class="form-control">${user.email}</span>
          </div>
          <div class="form-group vrf">
              <i class="icon"></i>
              <input type="text" class="form-control" id="emailCode" name="emailCode" placeholder="请输入验证码（区分大小写）">
              <a href="javascript:void(0)" id="js-sendEmail" class="input-group-addon btn">获取验证码</a>
          </div>
        </div>
   			<ul class="pager">
   				<li id="step2-prev" class="prev hidden"><a href="#" class="btn btn-info" onclick="return false">上一步</a></li>
  				<li id="step2-next" data-id='2' class="disabled nt"><a href="#" class="btn" onclick="return false">下一步</a></li>
  		  </ul>
     	</div>
   		<div id="step3" class="step">
   			<div class="form-group nobd" >
      			<div class="input-group">
      				<span class="input-group-addon">
      				&nbsp;&nbsp;新密码:&nbsp;
      				</span>
      				<input class="form-control" type="password" name="password" id="password" placeholder="请输入密码(6-15个字符)" >
      			</div>
   			</div>
   			<div class="form-group nobd" >
      			<div class="input-group">
      				<span class="input-group-addon">
      				确认密码:
      				</span>
      				<input class="form-control" name="confirm_password" type="password" id="confirm_password" placeholder="请再次输入密码" >
      			</div>
   			</div>
 				<ul class="pager">
 					<li id="step3-prev" class="prev hidden"><a href="#" class="btn btn-info" onclick="return false">上一步</a></li>
 					<li id="step3-next" data-id='3' class="disabled nt"><a class="btn" href="#" onclick="return false">下一步</a></li>
			  </ul>
   		</div><!-- end step3 -->
 			<div id="step4" class="step">
 			  <div class="form-group success" >
            <h3 class="tle"><img src="img/dui_icon.png" alt="完成"> 恭喜您密码重置成功！</h3>
            <p class="time" id="js-autoLg">秒后自动登录</p>
            <a href="f/Index" class="btn btn-primary">立即登录</a>
        </div>
 			</div><!-- end step4 -->
 			</div>
		</form>
		</div>
	</div>
</div>
</body>
</html>