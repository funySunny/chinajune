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
<!-- BootStrap -->
<meta name="author" content="">
<meta name="keywords" content="充电桩管理">
<meta name="description" content="">
<title>充电桩管理（交流）</title>

<!-- BootStrap -->
<link href="bootstrap-table/css/bootstrap-table.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="bootstrap-table/extends/bootstrap-editable/css/bootstrap-editable.css"></link>
<link href="css/CPManage.css" rel="stylesheet"/>

<script src="bootstrap-table/js/bootstrap-table.js"></script>
<script src="bootstrap-table/extends/bootstrap-table-export.min.js"></script>
<script src="js/th_lib/tableExport.js"></script>
<script src="js/th_lib/TipModal.js"></script>
<!-- 国际化，表格汉化after  bootstrap-table-->
<script src="bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
<script src="bootstrap-table/extends/bootstrap-editable/js/bootstrap-editable.min.js"></script>
<script src="js/CPManage.js"></script>
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
                            	<a href="#muserManage" class="nav-header collapsed" data-toggle="collapse" >
                            		<i class="fa fa-mobile"></i>&nbsp;
                            		手机用户管理
                            		<span class="pull-right glyphicon  glyphicon-chevron-toggle"></span>
                            	</a>
                	            <ul id="muserManage" class="nav nav-list thirdmenu collapse">
	                	            <li><a href="pages/muserManage.jsp"><i class="fa fa-info"></i>&nbsp;用户信息管理</a></li>
    	                	        <li><a href="pages/chargeMoneyRecords.jsp"><i class="fa fa-cny"></i>&nbsp;充值记录</a></li>
        	                	    <li><a href="pages/chargeRecords.jsp"><i class="fa fa-flash"></i>&nbsp;充电记录</a></li>
            	                </ul>
            	                <li><a id="toSaler" href="javascript:void(0);"><i class="fa fa-user"></i>&nbsp;销售用户管理</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#CPLiveDataConfig" class="nav-header collapse" data-toggle="collapse">
                            <i class="fa fa-gears"></i>
                          	  设备管理	
                                   <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
                        </a>
                        <ul id="CPLiveDataConfig" class="nav nav-list secondmenu collapse in">
                        	<li>
                            	<a href="#ACLive" class="nav-header collapse" data-toggle="collapse" >
                            		<i class="fa fa-random"></i>&nbsp;
                            		交流充电桩
                            		<span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
                            	</a>
                	            <ul id="ACLive" class="nav nav-list secondmenu collapse in">
     			                    <li class="active"><a href="javascript:location.reload();">&nbsp;交流充电桩管理</a></li>
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
                        <a href="#tradeManage" class="nav-header collapsed" data-toggle="collapse">
                            <i class="fa fa-credit-card-alt"></i>
							订单管理
                            <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
                        </a>
                        <ul id="tradeManage" class="nav nav-list secondmenu collapse">
                            <li><a href="pages/tradeHome.jsp"><i class="fa fa-globe"></i>&nbsp;订单概览</a></li>
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
  					<li><a href="javascript:void(0);">设备管理</a></li>
  					<li class="active">交流充电桩管理</li>
		</ol>
	<h1>交流充电桩列表</h1>
	<div id="toolbar">
   					<div class="form-inline" role="form">
   						<div class="form-group">
   							<button id="btn_delete" type="button" class="btn btn-danger">
    							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除选中
   							</button>
   						</div>
                		
                		<div class="form-group">
                    		<input name="c_p_id" id="txt_search_id" class="form-control" type="text" placeholder="搜索充电桩编号">
                		</div>
                		<div class="form-group">
                			<button id="ok" type="submit" class="btn btn-default">搜索</button>
                		</div>
            </div>
   </div>
		<table id="table"></table>
	</div><!-- end col-10 -->
	</div><!-- end row -->
	
	</div><!-- end container -->
	<jsp:include page="../common/footer.jsp"/>
</body>

</html>