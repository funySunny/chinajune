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
<title>城市测试</title>
<base href="<%= basePath %>"/>
<!-- BootStrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap-chinese-region.css" rel="stylesheet" />
<link href="css/common.css" rel="stylesheet"/>
<link href="bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet"/>

<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/js/bootstrap-chinese-region.js"></script>
<script src="bootstrap-select/js/bootstrap-select.min.js"></script>
<!-- <script charset="utf-8" src="js/salerHome.js"></script> -->
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
						<li><a href="f/UserManage">用户管理</a></li>
         				<li><a href="f/CPP">充电桩参数</a></li>
         				<li class="active"><a href="f/CPS">充电桩状态</a></li>
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
               				<li><a href="f/Index" data-toggle="modal" data-target="#Exit">
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
		<h1>城市</h1>
		<div class="form-group">
		<select class="selectpicker">
  			<option>Mustard</option>
  			<option>Ketchup</option>
  			<option>Relish</option>
		</select>
    <label for="address">地区</label>
    <div class="bs-chinese-region flat dropdown" data-submit-type="id" data-min-level="1" data-max-level="3">
        <input type="text" class="form-control" name="address" id="address" placeholder="选择你的地区" data-toggle="dropdown" readonly="" value="440103">
        <div class="dropdown-menu" role="menu" aria-labelledby="dLabel">
            <div>
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#province" data-next="city" role="tab" data-toggle="tab">省份</a></li>
                    <li role="presentation"><a href="#city" data-next="district" role="tab" data-toggle="tab">城市</a></li>
                    <li role="presentation"><a href="#district" data-next="street" role="tab" data-toggle="tab">县区</a></li>
                </ul>
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="province">--</div>
                    <div role="tabpanel" class="tab-pane" id="city">--</div>
                    <div role="tabpanel" class="tab-pane" id="district">--</div>
                </div>
            </div>
        </div>
    </div>
</div>

<form id="notifyEmail" style="display:none;" action="" target="_blank" method="post">
		<input type="hidden" name="code"/>
		<input type="hidden" name="userName"/>
</form>

<a href="javascript:void(0)" onclick="clickEvent();return false">点击继续完成验证步骤</a>
		
		<script>
		function clickEvent(){
				$('#notifyEmail input').eq(0).val(encodeURI('sdjg'));
				$('#notifyEmail input').eq(1).val(encodeURI('汉化'));
				$('form[id="notifyEmail"]').attr('action','http://localhost:8080/ChargePile/f/ResetPasswordSuccess').submit();
		};
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

<script type="text/javascript">
$(function(){
	
    $.getJSON('../json/sql_areas.json',function(data){

        /**重定义数据结构**/
        /**
         * id 键,name 名字,level 层级,parentId 父级
         */
        for (var i = 0; i < data.length; i++) {
            var area = {id:data[i].id,name:data[i].cname,level:data[i].level,parentId:data[i].upid};
            data[i] = area;
        }

        $('.bs-chinese-region').chineseRegion('source',data);/*导入数据并实例化*/
    });
    
    
});
</script>

	
</div>
</body>
</html>