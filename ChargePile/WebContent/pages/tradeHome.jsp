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
<jsp:include page="../common/head.jsp"/>
<meta name="author" content="">
<meta name="keywords" content="交易管理">
<meta name="description" content="">
<title>交易管理</title>
<link href="bootstrap-table/css/bootstrap-table.min.css" rel="stylesheet"/>

<script src="bootstrap-table/js/bootstrap-table.js"></script>
<script src="bootstrap-table/extends/bootstrap-table-export.min.js"></script>
<script src="js/th_lib/tableExport.js"></script>
<script src="js/th_lib/TipModal.js"></script>
<script src="bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
<script src="js/tradeHome.js" charset="utf-8"></script>
</head>
<body>
<jsp:include page="../common/header.jsp"/>

<div class="container" style="width:100%;">
	<div class="row">
	<div class="col-md-2" style="padding:0px;">
			<ul id="main-nav" class="main-nav nav nav-tabs nav-stacked" style="">
                    <li>
                        <a href="pages/index.jsp">
                            <i class="glyphicon glyphicon-th-large"></i>
                           	 首页 		
                        </a>
                    </li>
                    <li>
                        <a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse">
                            <i class="fa fa-users"></i>
							用户管理                            
                            <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
                        </a>
                        <ul id="systemSetting" class="nav nav-list secondmenu collapse">
                            <li><a href="pages/userManage.jsp"><i class="fa fa-desktop"></i>&nbsp;电脑用户管理</a></li>
                             <li>
                            	<a href="#muserManage" class="nav-header collapse" data-toggle="collapse" >
                            		<i class="fa fa-mobile"></i>&nbsp;
                            		手机用户管理
                            		<span class="pull-right glyphicon  glyphicon-chevron-toggle"></span>
                            	</a>
                	            <ul id="muserManage" class="nav nav-list secondmenu collapse in">
	                	            <li><a href="pages/muserManage.jsp"><i class="fa fa-info"></i>&nbsp;用户信息管理</a></li>
    	                	        <li><a href="#"><i class="fa fa-cny"></i>&nbsp;充值记录</a></li>
        	                	    <li><a href="#"><i class="fa fa-flash"></i>&nbsp;充电记录</a></li>
            	                </ul>
                            </li>
                            <li><a id="toSaler" href="javascript:void(0);"><i class="fa fa-user"></i>&nbsp;销售用户管理</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#CPLiveDataConfig" class="nav-header collapsed" data-toggle="collapse">
                            <i class="fa fa-gears"></i>
                          	  设备管理	
                                   <span class="pull-right glyphicon  glyphicon-chevron-toggle"></span>
                        </a>
                        <ul id="CPLiveDataConfig" class="nav nav-list secondmenu collapse">
                        	<li>
                            	<a href="#ACLive" class="nav-header collapsed" data-toggle="collapse" >
                            		<i class="fa fa-random"></i>&nbsp;
                            		交流充电桩
                            		<span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
                            	</a>
                	            <ul id="ACLive" class="nav nav-list secondmenu collapse">
     			                    <li><a href="pages/CPManage.jsp">&nbsp;交流充电桩管理</a></li>
	                	            <li><a href="pages/CPLive.jsp"><i class="fa fa-info"></i>&nbsp;实时数据</a></li>
        	                	    <li><a href="pages/CPLineChar.jsp"><i class="fa fa-line-chart"></i>&nbsp;数据分析</a></li>
            	                </ul>
                            </li>
                            <li>
                            	<a href="#DCLive" class="nav-header collapsed" data-toggle="collapse" >
                            		<i class="fa fa-minus"></i>&nbsp;
                            		直流充电桩
                            		<span class="pull-right glyphicon  glyphicon-chevron-toggle"></span>
                            	</a>
                	            <ul id="DCLive" class="nav nav-list secondmenu collapse">
                            		<li><a href="pages/CPManageDC.jsp">&nbsp;直流充电桩管理</a></li>
	                	            <li><a href="pages/CPLiveDC.jsp"><i class="fa fa-info"></i>&nbsp;实时数据</a></li>
        	                	    <li><a href="pages/CPLineCharDC.jsp"><i class="fa fa-line-chart"></i>&nbsp;数据分析</a></li>
            	                </ul>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#tradeManage" class="nav-header collapse" data-toggle="collapse">
                            <i class="fa fa-credit-card-alt"></i>
							订单管理
                            <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
                        </a>
                        <ul id="tradeManage" class="nav nav-list secondmenu collapse in">
                            <li class="active"><a href="pages/tradeHome.jsp"><i class="fa fa-globe"></i>&nbsp;订单概览</a></li>
                            <li><a href="pages/muserManage.jsp"><i class="fa fa-check-square-o"></i>&nbsp;已完成订单</a></li>
                            <li><a href="#"><i class="fa fa-ban"></i>&nbsp;已失效订单</a></li>
                            <li><a href="#"><i class="fa fa-clock-o"></i>&nbsp;待处理订单</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>&nbsp;日志查看</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">
                            <i class="glyphicon glyphicon-fire"></i>
                            		关于系统
                            <span class="badge pull-right">1</span>
                        </a>
                    </li>

                </ul><!-- end ul main-nav -->
			
	</div>
	
	<div class="col-md-10">
		 <ol class="breadcrumb">
  					<li><a href="pages/index.jsp">首页</a></li>
  					<li><a href="javascript:void(0);">订单管理</a></li>
  					<li class="active">订单概览</li>
		</ol>
	
	<h1>充电记录列表</h1>
	
	<div id="toolbar">
   			<div class="form-inline" role="form">
   					<div class="form-group">
   						<button id="btn_delete" type="button" class="btn btn-danger">
    						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除选中
   						</button>
   					</div>
                		
               		<div class="form-group">
                   		<input id="search_text" class="form-control" size="45" type="text" placeholder="搜索充电桩ID、订单号、用户名、充电地址等关键字">
               		</div>
               		<div class="form-group">
                   		<input id="search_status" class="form-control" type="text" placeholder="搜索交易状态">
               		</div>
               		<div class="form-group">
               			<button id="ok" type="submit" class="btn btn-default">搜索</button>
               		</div>
            </div>
   </div>
	
	
	<table class="table table-striped table-bordered table-hover table-responsive">
   		<!-- <thead>
      		<tr>
         		<th>订单号</th>
         		<th>订单状态</th>
         		<th>用户名</th>
         		<th>订单简介</th>
         		<th>订单生成时间</th>
  	     		<th>订单金额</th>
         		<th>订单类型</th>
      		</tr>
   		</thead>
   		<tbody id="addTr">
   		</tbody> -->
	</table>
	
	</div><!-- end col-10 -->
	</div><!-- end row -->
	
	</div><!-- end container -->
	<jsp:include page="../common/footer.jsp"/>
</body>

</html>