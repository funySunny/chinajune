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
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>充电桩后台管理系统-用户注册</title>
  <!-- BootStrap -->
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
  <link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
  <link href="bootstrap-validate/css/bootstrapValidator.min.css" rel="stylesheet"/>
  <link href="bootstrap/css/font-awesome.min.css" rel="stylesheet"/>
  <link href="bootstrap/css/fileinput.min.css" rel="stylesheet"/>
  <link href="css/login.css" rel="stylesheet" />
  <script src="bootstrap/js/jquery.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>
  <script src="bootstrap-validate/js/bootstrapValidator.min.js" charset="utf-8"></script>
  <script src="bootstrap-validate/js/locale/zh_CN.js"></script>
  <script src="bootstrap/js/fileinput.min.js" charset="utf-8"></script>
  <script src="bootstrap/js/fileinput_locale_zh.js"></script>
  <script src="js/th_lib/TipModal.js"></script>
  <script src="js/th_lib/MD5Factory.js"></script>
  <script src="js/th_lib/BootstrapAlert.js"></script>
  <script src="js/register.js" charset="utf-8"></script>
</head>
<body>
<div class="container m-login">
	<div class="row m-register">
		<div class="col_mod_12" >
		<nav class="navbar navbar-default navbar-fixed-top nav-tle" role="navigation">
      <a class="back" href="f/Index"><i class="glyphicon glyphicon-share-alt icon"></i>返回</a>
      <h2>新用户注册</h2>
		</nav>

		<form class="form-horizontal" id="form1" method="post" action="pc/register" autocomplete="off">
		<div class="col-md-12">
      <div id="step1">
        <div class="form-group">
          <label class="control-label col-md-3" for="companyName">*选择公司</label>
          <div class="col-md-8">
            <select id="companyName" class="form-control "></select>
          </div>
        </div>
        <div class="form-group" >
          <label class="control-label col-md-3" for="access">*选择权限</label>
          <div class="col-md-8">
            <select id="access" name="access" class="form-control ">
              <option value="1">销售人员</option>
              <option value="2">普通顾客</option>
            </select>
          </div>
        </div>
          
        <div class="form-group" >
          <label class="control-label col-md-3">*邮箱:</label>
          <div class="col-md-8">
            <input type="email" name="email" class="form-control" placeholder="请输入合法的邮箱">
          </div>
        </div>
        
        <div class="form-group" >
          <label class="control-label col-md-3">*注册编号:</label>
            <div class="col-md-8">
              <input type="text" name="reg_no" class="form-control" placeholder="请输入公司的注册编号">
            </div>
        </div>
        <div class="form-group pager">
          <p  id="step1-next" class="disabled step"><a href="#"  class="btn btn-default" onclick="return false">下一步</a></p>
        </div>
      </div><!-- end step1 -->
    <!-- </div>     -->
			<div id="step2">
   			<div class="form-group">
      			<label for="name" class="control-label col-md-3">*昵称:</label>
      			<div class="col-md-8">
      				<input type="text" name="name" class="form-control" id="name" 
         			placeholder="请输入6-15位字母或数字组合">
         		</div>
   			</div>
   			<div class="form-group" >
      			<label for="pw" class="control-label col-md-3">*登录密码:</label>
      			<div class="col-md-8">
      				<input class="form-control" name="password" type="password" id="password" placeholder="请输入6-15位字母或数字组合">
      			</div>
   			</div>
   			<div class="form-group" >
      			<label for="pw" class="control-label col-md-3">*确认密码:</label>
      			<div class="col-md-8">
      				<input class="form-control" name="confirm_password" type="password" id="confirm_password" placeholder="请再次输入密码">
      			</div>
   			</div>
     			<div class="form-group">
     				<label class="control-label col-md-3">*手机号:</label>
      			<div class="col-md-8">
      				<input type="text" name="tel" class="form-control" placeholder="请输入11位手机号码">
      			</div>
        	</div>
      		<div class="form-group" >
            <label class="col-md-3 control-label">密保问题1:</label>
            <div class="col-md-8">
            	<select class="form-control" id="question1">
            		<option value="1">我的出生地</option>
            		<option value="2">母亲生日</option>
            		<option value="3">父亲生日</option>
            	</select>
          	</div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label">密保答案:</label>
            <div class="col-md-8">
			        <textarea placeholder="用于找回密码时使用" class="form-control" name="answer1" rows="1"></textarea>
						</div>
          </div>
          <div class="form-group" >
          	<label class="col-md-3 control-label">密保问题2:</label>
          	<div class="col-md-8">
            	<select class="form-control" id="question2">
            		<option value="4">最喜欢的颜色</option>
            		<option value="5">小学班主任姓名</option>
            		<option value="6">初中学校</option>
            	</select>
          	</div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label">密保答案:</label>
            <div class="col-md-8">
			        <textarea placeholder="用于找回密码时使用" class="form-control" name="answer2" rows="1"></textarea>
						</div>
					</div>
        	<div class="form-group">
            <div class="col-md-offset-3 sbt">
                <button type="submit" class="btn btn-primary">提交<i class="fa fa-check"></i></button>            
                <button type="button" id="step2-prev" class="btn btn-default">上一步<i class="fa fa-prev"></i></button>
            </div>
          </div>

   		</div>
   			

		</form>
			
			<form class="form-horizontal" method="post" enctype="multipart/form-data" id="form2" action="common/uploadUserPhoto" autocomplete="off">
			<div id="step3" class="col-md-12">
   			<div class="form-group">
   				<label for="name" class="control-label col-md-2">用户头像:</label>
         		<div class="col-md-8">
   					<div class="input-group">
   					<!-- multiple表示允许同时上传多个文件 -->
      					<input name="file" type="file" id="headPhoto">
      					<input type="hidden" name="fileName" value="">
      				</div>
      			</div>
      			<div class="col-md-12" id="Alert"></div>
      		</div>
      		<div class="form-group" >
   			<ul class="pager">
   				<li id="step4-back" class=""><a href="f/Index">前往登录</a></li>
			</ul>
			</div>
   			</div>
			</form>
		</div>
	</div>
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="Submit" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  <!-- &times; -->
                 <span class="glyphicon glyphicon-remove-circle"></span>  
            </button>
            <h4 class="modal-title text-center text-success" id="myModalLabel">
             	 <!--  模态框（Modal）标题 -->
	          	 <span class="glyphicon glyphicon-warning-sign"></span> 
    	      	   注册成功
            </h4>
         </div>
         <div class="modal-body text-center">
         	<h5>是否继续上传头像？</h5>
         </div>
         <div class="modal-footer">
            <button type="button" id="cancel" class="btn btn-default"  data-dismiss="modal">
             	<i class="glyphicon glyphicon-remove"></i> 
             	  不用了谢谢
            </button>
            <button id="goOnUpload" type="button" class="btn btn-primary">
              	<i class="fa fa-check"></i>
              	 我要上传头像
            </button>
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal -->
	</div><!-- 模态框（Modal） -->
</body>
</html>