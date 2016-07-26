<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<% if(null == session.getAttribute("userName")){ %>
  		 <c:redirect url="/index.jsp"/>
 	<% } 	%>
	<!-- navbar  -->
	<nav style="height:70px;" class="navbar navbar-default navbar-fixed-top m-nav" role="navigation">
      <h1 class="logo"><a href="/ChargePile/pages/"><img src="img/logo.png" alt="中工巨能"></a></h1>
				 <div style="padding-top:10px;">
				 	<!--navbar-right-->
  				<ul class="nav navbar-nav navbar-right">
     				<li style="padding-right:20px;" class="dropdown">
        				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
           					<span class="glyphicon glyphicon-user"></span>
           					${sessionScope.userName }
           				<b class="caret"></b>
        				</a>
        			<ul class="dropdown-menu">
           				<li><a href="#" data-toggle="modal" data-target="#ModifyPW">
           				<span class="glyphicon glyphicon-edit"></span>
           				 	修改密码</a></li>
           				<li class="divider"></li>
           				<li><a href="f/Register">注册</a></li>
           				<li class="divider"></li>
           				<li><a href="#" data-toggle="modal" data-target="#Exit">
           				<span class="glyphicon glyphicon-off"></span>
           				退出</a></li>
        			</ul>
     			</li>
  			</ul>
			</div>
  </nav>	
		
	<!-- 退出模态框（Modal） -->
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
               	<!--   模态框（Modal）标题 -->
              </h4>
           </div>
           <div class="modal-body text-center text-danger">
            	 <span class="glyphicon glyphicon-warning-sign"></span> 
            	   确定退出？
           </div>
           <div class="modal-footer">
              <button type="button" class="btn btn-default"  data-dismiss="modal">
               	<span class="glyphicon glyphicon-remove"></span> 
               	  关闭
              </button>
              <button id="btnExit" type="button" class="btn btn-primary">
                	<span class="glyphicon glyphicon-share"></span>
                	 继续退出
              </button>
           </div>
        </div><!-- /.modal-content -->
  	</div><!-- /.modal -->
	</div><!-- 模态框（Modal） -->
		
	<!-- 修改密码模态框（Modal） -->
	<div class="modal fade" id="ModifyPW" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 		<div style="width:300px;" class="modal-dialog">
    	<div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" 
             aria-hidden="true">×
          </button>
          <h4 class="modal-title" id="myModalLabel">
             	修改密码<small>（按下 ESC 按钮退出）</small>
          </h4>
        </div>
        <div class="modal-body">
          <form class="form-horizontal" role="form">
          	<div class="form-group" style="padding:20px;">
          		<div class="input-group col-md-12">
          			<span class="input-group-addon">
          				<span class="glyphicon glyphicon-user"></span>
          			</span>
          			<input value="${sessionScope.userName }" readonly class="form-control" placeholder="请输入名称">
          		</div>
          	</div>
          	<div class="form-group" style="padding:20px;">
          		<div class="input-group col-md-12">
          			<span class="input-group-addon">
          				<span class="glyphicon glyphicon-lock"></span>
          			</span>
          			<input type="password" class="form-control" placeholder="请旧输入密码">
          		</div>
          	</div>
          	<div class="form-group" style="padding:20px;">
          		<div class="input-group col-md-12">
          			<span class="input-group-addon">
          				<span class="glyphicon glyphicon-lock"></span>
          			</span>
          			<input type="password" class="form-control" placeholder="请再次输入密码">
          		</div>
          	</div>
          </form>
        </div>
        <div class="modal-footer">
          <div class="checkbox" style="text-align:center;">
            <button type="button" class="btn btn-primary">提交修改</button>
          </div>
        </div>
    	</div><!-- /.modal-content -->
 		</div><!-- /.modal-dialog -->
  </div><!-- /.modal -->
	<form id="logout" action="logout/pc" method="post"></form>
	<script type="text/javascript">
	$('#btnExit').click(function(){
		$('#logout').submit();	
	});
	</script>