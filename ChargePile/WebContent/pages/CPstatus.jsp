<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>CPstatus</title>
<!-- BootStrap -->
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath}/css/manage.css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/CPstatus.js"></script>
</head>
<body>
		<div class="col_mod_12">
			<!-- 导航栏 -->
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  				 <div class="navbar-header">
      				<a class="navbar-brand" href="HTTP://www.chinajune.com">CHINAJUNE</a>
   				 </div>
   				 <div style="margin:0 auto;width:290px;">
   				 <ul id="tabOption" class="nav navbar-nav" >
						<li><a href="${pageContext.request.contextPath}/f/UserManage">用户管理</a></li>
         				<li><a href="${pageContext.request.contextPath}/f/CPP">充电桩参数</a></li>
         				<li class="active"><a href="${pageContext.request.contextPath}/f/CPS">充电桩状态</a></li>
         		 </ul>
   				 </div>
   				 <div>
   				 	<!--向右对齐-->
      				<ul class="nav navbar-nav navbar-right">
         				<li style="padding-right:20px;" class="dropdown">
            				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
               					<span class="glyphicon glyphicon-user"></span>
               					账号管理
               				<b class="caret"></b>
            				</a>
            			<ul class="dropdown-menu">
               				<li><a href="#">
               				<span class="glyphicon glyphicon-cog"></span>
               				用户信息设置</a></li>
               				<li class="divider"></li>
               				<li><a href="./Register">注册</a></li>
               				<li class="divider"></li>
               				<li><a href="#">分离的链接</a></li>
               				<li class="divider"></li>
               				<li><a href="#" data-toggle="modal" data-target="#Exit">
               				<!-- 开始演示模态框 -->
               				<span class="glyphicon glyphicon-off"></span>
               				退出</a></li>
            			</ul>
         			</li>
      			</ul>
   			</div>
		</nav>	
<div class="container">
	<div class="row">
		
		<!-- 按钮触发模态框 -->
	<!-- 	<button style="margin-top:200px;" class="btn btn-primary btn-lg" data-toggle="modal" 
		data-target="#myLoginModal">
		</button> -->
		<!-- 登录模态框（Modal） -->
		<div class="modal fade" id="myLoginModal" tabindex="-1" role="dialog" 
   			aria-labelledby="myModalLabel" aria-hidden="true">
   		<div style="width:300px;" class="modal-dialog">
      	<div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" 
               aria-hidden="true">×
            </button>
            <h4 class="modal-title" id="myModalLabel">
               	请登录（按下 ESC 按钮退出）
            </h4>
         </div>
         <div class="modal-body">
            <form class="form-horizontal" role="form">
            	<div class="form-group" style="padding:20px;">
            		<div class="input-group col-md-12">
            			<span class="input-group-addon">
            				<span class="glyphicon glyphicon-user"></span>
            			</span>
            			<input class="form-control" placeholder="请输入名称">
            		</div>
            	</div>
            	<div class="form-group" style="padding:20px;">
            		<div class="input-group col-md-12">
            			<span class="input-group-addon">
            				<span class="glyphicon glyphicon-user"></span>
            			</span>
            			<input type="password" class="form-control" placeholder="请输入密码">
            		</div>
            	</div>
            	<div class="form-group" >
            	<p class="text-center">
            		<label ><a href="${pageContext.request.contextPath}/pages/register.jsp">新用户，注册</a></label>
            		<label style="padding-left:20px;"><a href="${pageContext.request.contextPath}/pages/register.jsp">忘记密码？</a></label>
            	</p>
            	</div>
            </form>
         </div>
         <div class="modal-footer">
            <div class="checkbox" style="padding:0px;;">
            <button type="button" class="btn btn-primary">
             	登录
            </button>
            			<label style="font-size:12px;">
            			<input type="checkbox" >
            			下次自动登录
            			</label>
            </div>
         </div>
      	</div><!-- /.modal-content -->
   		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
		
	
	<div id="userManage" style="padding-top:80px;display:none;">
		<ul class="list-group">
			<li class="list-group-item"><span class="label label-info">信息标签</span></li>
   			<li class="list-group-item">免费域名注册</li>
   			<li class="list-group-item">免费 Window 空间托管</li>
   			<li class="list-group-item">图像的数量</li>
   			<li class="list-group-item">24*7 支持</li>
   			<li class="list-group-item">每年更新成本</li>
		</ul>
		<ul class="pagination">
  			<li><a href="#">&laquo;</a></li>
  			<li class="active"><a href="#">1</a></li>
  			<li><a href="#">2</a></li>
  			<li><a href="#">3</a></li>
  			<li><a href="#">4</a></li>
  			<li><a href="#">5</a></li>
  			<li><a href="#">&raquo;</a></li>
		</ul>
	</div>
	
	<div id="P" style="padding-top:80px;display:none;">
		<ul class="list-group">
			<li class="list-group-item"><span class="label label-default">标签</span></li>
   			<li class="list-group-item">免费域名注册</li>
   			<li class="list-group-item">免费 Window 空间托管</li>
   			<li class="list-group-item">图像的数量</li>
   			<li class="list-group-item">24*7 支持</li>
   			<li class="list-group-item">每年更新成本</li>
		</ul>
		<ul class="pagination">
  			<li><a href="#">&laquo;</a></li>
  			<li class="active"><a href="#">1</a></li>
  			<li><a href="#">2</a></li>
  			<li><a href="#">3</a></li>
  			<li><a href="#">4</a></li>
  			<li><a href="#">5</a></li>
  			<li><a href="#">&raquo;</a></li>
		</ul>
	</div>
	
	
	
	<!-- 模态框（Modal） -->
<div class="modal fade" id="Exit" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  <!-- &times; -->
                 <span class="glyphicon glyphicon-remove-circle"></span>  
            </button>
            <h4 class="modal-title" id="myModalLabel">
             	  模态框（Modal）标题
            </h4>
         </div>
         <div class="modal-body text-center">
          	 <span class="glyphicon glyphicon-warning-sign"></span> 
          	   确定退出？
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default"  data-dismiss="modal">
             	<span class="glyphicon glyphicon-remove"></span> 
             	  关闭
            </button>
            <button type="button" class="btn btn-primary">
              	<span class="glyphicon glyphicon-share"></span>
              	 继续退出
            </button>
         </div>
      </div><!-- /.modal-content -->
	</div><!-- /.modal -->
	</div><!-- 模态框（Modal） -->
	
		</div>
	</div><!-- end row -->
<!-- 页脚 -->
<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
   <div class="navbar-header">
      <a class="navbar-brand" href="#">CHINAJUNE</a>
   </div>
   <ul class="nav navbar-nav" style="margin:0px 300px 0px 300px;">
         <li class="text-center"><a href="#">© Shenzhen CHINAJUNE technology co., LTD. All rights reserved</a></li>
   </ul>
   <div>
      <ul class="nav navbar-nav navbar-right" >
         <li style="padding-right:20px;"><a href="#">SVN</a></li>
      </ul>
   </div>
</nav>
	
</div>
</body>
</html>