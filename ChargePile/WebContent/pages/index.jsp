<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>
<head>
<jsp:include page="../common/head.jsp"/>
<meta name="author" content="">
<meta name="keywords" content="充电桩后台管理系统">
<meta name="description" content="">
<title>充电桩后台管理系统(管理员)-首页</title>
<link href="bootstrap-table/css/bootstrap-table.min.css" rel="stylesheet"/>

<script src="js/th_lib/highcharts.js"></script>
<script src="bootstrap-table/js/bootstrap-table.js"></script>
<script src="bootstrap-table/extends/bootstrap-table-export.min.js"></script>
<script src="bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
<script src="js/th_lib/TipModal.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=X40I2az9TIWsO6uwcvnabxSe"></script>
<script src="js/adminHome.js"></script>
</head>
<body>
	<%  if(null == session.getAttribute("userName")){ %>
  		 <c:redirect url="/index.jsp"/>
 	<% } %>
   <jsp:include page="../common/header.jsp"/>
<div class="container m-container">
	<div class="row">
	   <jsp:include page="../common/aside.jsp"/>
	<div class="col-md-10 content">
		<ol class="breadcrumb header">
      <li class="active">当前位置：<a href="/ChargePile/pages/">首页</a>﹥<span>充电桩分布</span></li>
		</ol>
    <div class="mag" id='js-ChargePoint'>
      <span>共有充电桩<em class="t-blue"></em>台</span>
      <span>空闲<em class="t-green">15</em>台</span>
      <span>占用<em class="t-red">15</em>台</span>
      <span>已预约<em class="t-red">15</em>台</span>
      <span>利用率<em class="t-blue">45%</em>台</span>
    </div>
  	<ul class="nav nav-tabs" role="tablist" style="margin:0 auto;">
      <li role="presentation" class="active"><a href="#homeMap" onclick="return false" role="tab" data-toggle="tab">充电桩分布</a></li>
      <li role="presentation"><a href="#homeTable" onclick="return false" role="tab" data-toggle="tab">充电桩列表</a></li>
    </ul>
        <div class="tab-content">
        	<div role="tabpanel" class="tab-pane active" id="homeMap">
 						<div id="CPmap" style="width:100%;height:500px;"></div>
			    </div>
          <div role="tabpanel" class="tab-pane pileslist" id="homeTable">
            <div id="toolbar">
   				    <div class="form-inline" role="form">
              	<div class="form-group">
                  <input name="c_p_id" id="txt_search_id" class="form-control" type="text" placeholder="搜索充电桩编号">
                </div>
            		<div class="form-group">
                		<select id="txt_select_free" class="form-control">
                			<optgroup label="筛选状态">
                				<option value="">全部</option>
                				<option value="0">空闲</option>
                				<option value="1">占用</option>
                				<option value="2">被预约</option>
                			</optgroup>
                		</select>
            		</div>
            		<div class="form-group">
            			<button id="ok" type="submit"class="btn btn-warning ">搜索</button>
            		</div>
            	</div>
   			</div>
       <table id="CPTable" class="table table-condensed table-responsive"></table>
      </div>
	</div>
	</div><!-- end row -->
	</div><!-- end container -->
		<jsp:include page="../common/footer.jsp"/>	
</body>

</html>