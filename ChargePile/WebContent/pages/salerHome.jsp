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

<link href="bootstrap/css/bootstrap-chinese-region.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap-datetimepicker.css" rel="stylesheet" media="screen">

<script src="bootstrap/js/bootstrap-chinese-region.js"></script>
<script src="bootstrap/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script src="bootstrap/locale/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="js/th_lib/BootstrapAlert.js"></script>
<script charset="utf-8" src="js/salerHome.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=X40I2az9TIWsO6uwcvnabxSe"></script>
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
                            <li class="active"><a href="pages/salerHome.jsp"><i class="fa fa-edit"></i>&nbsp;信息录入</a></li>
                            <li><a href="pages/salerManage.jsp"><i class="fa fa-list"></i>&nbsp;信息管理</a></li>
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
		 			<li><a>系统管理</a></li>
  					<li class="active">信息录入</li>
		</ol>
	
	
	
	<ul class="nav nav-tabs" role="tablist" style="margin:0 auto;">
                    <li role="presentation" class="active"><a href="#saleInfo" onclick="return false" role="tab" data-toggle="tab"><h4>录入销售信息</h4></a></li>
                    <li role="presentation"><a href="#companyInfo" onclick="return false" role="tab" data-toggle="tab"><h4>录入公司信息</h4></a></li>
    </ul>
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="saleInfo">
               			
               			
<form role="form">
   <div class="form-group">
      <label for="id">充电桩ID</label>
      <input type="text" class="form-control" id="c_p_id" 
         placeholder="请输入充电桩ID">
   </div>
   <div class="form-group">
      <label for="location">充电桩所在位置</label>
      <div class="bs-chinese-region flat dropdown" data-submit-type="id" data-min-level="1" data-max-level="3">
        <input type="text" class="form-control" name="address" id="address" placeholder="选择你的地区" data-toggle="dropdown" readonly="" value="">
        <div class="dropdown-menu" role="menu" aria-labelledby="dLabel">
            <div>
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#province" onclick="return false" data-next="city" role="tab" data-toggle="tab">省份</a></li>
                    <li role="presentation"><a href="#city" onclick="return false" data-next="district" role="tab" data-toggle="tab">城市</a></li>
                    <li role="presentation"><a href="#district" onclick="return false" data-next="street" role="tab" data-toggle="tab">县区</a></li>
                </ul>
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="province">--</div>
                    <div role="tabpanel" class="tab-pane" id="city">--</div>
                    <div role="tabpanel" class="tab-pane" id="district">--</div>
                </div>
            </div>
        </div>
      </div>

      <label class="help-block">详细位置&nbsp;&nbsp;<small id="address_help" class="text-primary"><i class="fa fa-exclamation-triangle"></i>&nbsp;请键入具体位置后拖拽图标</small></label>
      <div class="input-group">
		    <input type="text" class="form-control" id="addressAddon" placeholder="详细位置"/>
         <span class="input-group-addon">经度<b id="lng" class="text-primary">116.331398</b>，纬度<b id="lat" class="text-primary">39.897445</b></span>
      </div>
   
   
   <h4></h4>
   <div id="maps" style="width:100%;height:500px;">
</div>
   
<script type="text/javascript">
$(function(){

     // 百度地图API功能
     
			// 创建地址解析器实例
	/* var map = new BMap.Map("maps");
	map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
	var point = new BMap.Point(116.331398,39.897445); 
	map.centerAndZoom(point,12);// 初始化地图,设置中心点坐标和地图级别
	map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
	map.enableDragging();   //两秒后开启拖拽
	var geoc = new BMap.Geocoder();    

	map.addEventListener("click", function(e){        
		var pt = e.point;
		geoc.getLocation(pt, function(rs){
			var addComp = rs.addressComponents;
			$('#addressAddon').val('经度:'+pt.lng+' '+'维度:'+pt.lat);
			alert('经度:'+pt.lng+' '+'维度:'+pt.lat+addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
		});        
	}); */
			
			
     /* 定位*/
     /* var map = new BMap.Map("maps");
	var point = new BMap.Point(116.331398,39.897445);
	map.centerAndZoom(point,12);
	var geolocation = new BMap.Geolocation();
	geolocation.getCurrentPosition(function(r){
		if(this.getStatus() == BMAP_STATUS_SUCCESS){
			var mk = new BMap.Marker(r.point);
			map.addOverlay(mk);
			map.panTo(r.point);
			alert('您的位置：'+r.point.lng+','+r.point.lat);
		}
		else {
			alert('failed'+this.getStatus());
		}        
	},{enableHighAccuracy: true}); 
 */
     
    	//关于状态码
    	//BMAP_STATUS_SUCCESS	检索成功。对应数值“0”。
    	//BMAP_STATUS_CITY_LIST	城市列表。对应数值“1”。
    	//BMAP_STATUS_UNKNOWN_LOCATION	位置结果未知。对应数值“2”。
    	//BMAP_STATUS_UNKNOWN_ROUTE	导航结果未知。对应数值“3”。
    	//BMAP_STATUS_INVALID_KEY	非法密钥。对应数值“4”。
    	//BMAP_STATUS_INVALID_REQUEST	非法请求。对应数值“5”。
    	//BMAP_STATUS_PERMISSION_DENIED	没有权限。对应数值“6”。(自 1.1 新增)
    	//BMAP_STATUS_SERVICE_UNAVAILABLE	服务不可用。对应数值“7”。(自 1.1 新增)
    	//BMAP_STATUS_TIMEOUT	超时。对应数值“8”。(自 1.1 新增)
        
        
        
});
</script>
	
   
   
   
   </div>
   
   
   
   <div class="form-group">
      <label for="companyName">选择公司</label>
      <select id="companyName" class="form-control">
         <!-- <option>1</option>
         <option>2</option>
         <option>3</option>
         <option>4</option>
         <option>5</option> -->
      </select>
   </div>
   <div class="form-group">
   <label class="control-label">选择时间</label>
        <div id="dateTimeSelect" class="input-group date form_datetime col-md-5" data-date="" 
             data-date-format="yyyy年 MMdd日  HH:mm:ss" data-link-field="dtp_input" data-link-format="yyyy-MM-dd HH:mm:ss">
             <input class="form-control" size="16" type="text" value="" readonly>
             <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
			<span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
		</div>
		<input type="hidden" id="dtp_input" value="" /><br/>
	</div>
	<div class="form-group">
      <label for="inner_no" class="control-label">充电站内编号</label>
      <input type="number" placeholder="请给该充电桩编号以方便找到充电桩" id="inner_no" class="form-control">
   </div>
	
	<div id="Alert"></div>
   	
   <button type="button" disabled id="submit" class="btn btn-default">提交</button>
</form>
               			
               			
           </div>
               		
           <div role="tabpanel" class="tab-pane" id="companyInfo">
               		
           <form role="form" id="form1">
   				<div class="form-group">
      					<label for="cN">公司名称</label>
      					<input type="text" class="form-control" id="cN" 
         				placeholder="请输入所售出的公司名称">
   				</div>
   				
   				<div class="form-group">
      				<label for="location">公司所在位置</label>
        			<input type="text" class="form-control" id="cA" 
         				placeholder="请输入所售出的公司名称">
      			</div><!-- end form group -->
      			
      			<div class="form-group">
      				<label for="regNO">注册编号</label>
        			<input type="text" class="form-control" name="regNO" id="regNO" 
         				placeholder="请输入注册编号">
      			</div><!-- end form group -->
      			
      			<div class="form-group">
      				<label for="tel">公司联系方式</label>
        			<input type="text" class="form-control" id="tel" 
         				placeholder="请输入该公司的联系方式">
      			</div><!-- end form group -->
      			
      			<div class="form-group">
      				<label>是否已注册用户</label>
        			   <label class="checkbox-inline">
      						<input type="radio" name="radiosinline" 
         						value="Y" checked> 是
   						</label>
   						<label class="checkbox-inline">
      					<input type="radio" name="radiosinline" 
         						value="N"> 否
   						</label>
      			</div><!-- end form group -->
      			
      			<div id="AlertTip"></div>
      			
      			<button type="button" disabled id="submit1" class="btn btn-default">提交</button>
   	</form>
               		
               		
               		</div>
               </div>
	
	</div>
	</div><!-- end row -->
	
	</div><!-- end container -->
		<jsp:include page="../common/footer.jsp"/>	
</body>

</html>