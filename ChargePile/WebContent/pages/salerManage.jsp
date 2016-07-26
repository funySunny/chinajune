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
<meta name="keywords" content="充电桩后台管理系统">
<meta name="description" content="">
<title>充电桩后台管理系统(销售)</title>

<!-- BootStrap -->
<link type=text/css href="bootstrap/css/bootstrap-datetimepicker.css" rel="stylesheet" media="screen">
<link type=text/css href="bootstrap-table/css/bootstrap-table.min.css" rel="stylesheet"/>

<script src="bootstrap-table/js/bootstrap-table.min.js"></script>
<script src="bootstrap-table/extends/bootstrap-table-export.min.js"></script>
<script src="bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
<script src="js/th_lib/tableExport.js"></script>
<script src="bootstrap/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script src="bootstrap/locale/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="js/th_lib/BootstrapAlert.js"></script>
<script src="js/th_lib/TipModal.js"></script>
<script src="js/salerManage.js"></script>
</head>
<body>
	<% if(null == session.getAttribute("userName")){ %>
  		 <c:redirect url="/index.jsp"/>
 	<% } %>
<jsp:include page="../common/header.jsp"/>
<div class="container" style="width:100%;">
	<div class="row">
	<div class="col-md-2" style="padding:0px;">
			<ul id="main-nav" class="main-nav nav nav-tabs nav-stacked" style="">
                    <li>
                        <a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse">
                            <i class="glyphicon glyphicon-cog"></i>
                          	  系统管理
                            <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
                        </a>
                        <ul id="systemSetting" class="nav nav-list secondmenu collapse in">
                            <li><a href="pages/salerHome.jsp"><i class="fa fa-edit"></i>&nbsp;信息录入</a></li>
                            <li class="active"><a href="pages/salerManage.jsp"><i class="fa fa-list"></i>&nbsp;信息管理</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="http://www.chinajune.com">
                            <i class="glyphicon glyphicon-fire"></i>
                            		关于我们
                            <span class="badge pull-right">1</span>
                        </a>
                    </li>

                </ul><!-- end ul main-nav -->
			
	</div>
	
	<div class="col-md-10">
		 <ol class="breadcrumb">
		 			<li><a href="javascript:void(0);">系统管理</a></li>
  					<li class="active">信息管理</li>
		</ol>
	
	<ul class="nav nav-tabs" role="tablist" style="margin:0 auto;">
                    <li role="presentation" class="active"><a href="#saleManage" onclick="return false" role="tab" data-toggle="tab"><h4>管理销售信息</h4></a></li>
                    <li role="presentation"><a href="#companyManage" onclick="return false" role="tab" data-toggle="tab"><h4>管理公司信息</h4></a></li>
    </ul>
    <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="saleManage">
                    
	<div id="Alert"></div>

	<div id="toolbar">
   		<div class="form-inline" role="form">
   			<div class="form-group">
				<button id="btn_delete" type="button" class="btn btn-danger">
    				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除选中
   				</button>
   			</div>
                	
            <div class="form-group">
                <!-- <label class="control-label"></label> -->
        		<div id="startTimeSelect" class="input-group date form_datetime" data-date="" 
             		data-date-format="yyyy年 MMdd日  HH:mm:ss" data-link-field="start_time" data-link-format="yyyy-MM-dd HH:mm:ss">
             		<input class="form-control" placeholder="起始时间" size="21" data-toggle="tooltip" title="开始时间" type="text" value="" readonly>
             		<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
					<span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
				</div>
			<input type="hidden" id="start_time" value="" /><br/>
			</div>
			
			<div class="form-group">
                <!-- <label class="control-label"></label> -->
        		<div id="endTimeSelect" class="input-group date form_datetime" data-date="" 
             		data-date-format="yyyy年 MMdd日  HH:mm:ss" data-link-field="end_time" data-link-format="yyyy-MM-dd HH:mm:ss">
             		<input class="form-control" size="21" data-toggle="tooltip" title="结束时间" placeholder="结束时间" type="text" value="" readonly>
             		<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
					<span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
				</div>
			<input type="hidden" id="end_time" value="" /><br/>
			</div>
						
            <div class="form-group">
            	<button id="ok" type="submit" class="btn btn-default">搜索</button>
            </div>
            
            </div>
   	</div>
   	
   	<div>
	<table id="table"></table>
   	</div>
	
	</div>
	
	<div role="tabpanel" class="tab-pane" id="companyManage">
	
		<div id="toolbarC">
   		<div class="form-inline" role="form">
   			<div class="form-group">
				<button id="btn_delete_c" type="button" class="btn btn-danger">
    				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除选中
   				</button>
   			</div>
                	
            <div class="form-group">
                
			<input type="text" class="form-control" placeholder="请输入关键字" size="25" id="search_text" value="" /><br/>
			</div>
			
						
            <div class="form-group">
            	<button id="GO" type="submit" class="btn btn-default">搜索</button>
            </div>
            
            </div>
   	</div><!-- end toolbarC -->
   	
   	<table id="tableC"></table>
   	
	</div>
	
	</div>
	
	</div>
	</div><!-- end row -->
	
	</div><!-- end container -->
		<jsp:include page="../common/footer.jsp"/>	
</body>

</html>