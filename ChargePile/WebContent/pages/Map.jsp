<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>百度地图测试</title>
<!-- BootStrap -->
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath}/css/manage.css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/CPstatus.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.2"></script> 
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
		
		<h2>百度地图</h2>
<div id="maps" style="width:100%;height:500px;">
</div>
<script type="text/javascript">
$(function(){

$("#maps").show();
var map = new BMap.Map("maps");
var myCity = new BMap.LocalCity();
        myCity.get(function(res){
            map.centerAndZoom(res.center,res.level); 
        });
});
</script>
	
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