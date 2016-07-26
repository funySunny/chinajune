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
<title>实时数据信息详情</title>
<base href="<%= basePath %>"/>
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="pragma" content="no-cache">
<meta name="renderer" content="webkit">
<!-- BootStrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
<link href="bootstrap/css/font-awesome.min.css" rel="stylesheet"/>
<link href="bootstrap/css/fileinput.min.css" rel="stylesheet"/>
<link href="bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet"/>
<link href="bootstrap-validate/css/bootstrapValidator.min.css" rel="stylesheet"/>
<%-- <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" /> --%>

<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/js/fileinput.min.js" charset="utf-8"></script>
<script src="bootstrap/js/fileinput_locale_zh.js"></script>
<script src="bootstrap-select/js/bootstrap-select.min.js"></script>
<script src="bootstrap-select/js/i18n/defaults-zh_CN.min.js"></script>
<script src="bootstrap-validate/js/bootstrapValidator.min.js" charset="utf-8"></script>
<script src="bootstrap-validate/js/locale/zh_CN.js"></script>
<script src="js/th_lib/BootstrapAlert.js"></script>
<script src="js/th_lib/MD5Factory.js"></script>
<script src="js/CPLiveDetails.js" charset="utf-8"></script>
</head>
<body>
<div class="container">
	<div class="row">
		<nav style="background-color: #EDF5FA" class="navbar navbar-default navbar-fixed-top" role="navigation">
			<ul class="nav navbar-nav navbar-left">
					<li ><a href="javascript:window.close();">&laquo;返回</a></li>	
			</ul>
			<div style="width : 200px;margin:0 auto">
				<ul class="nav navbar-nav">
					<li><span class="navbar-brand">ID:${id }</span></li>						
				</ul>
			</div>
		</nav>
					
		<div class="col_mod_12" style="margin-top:60px;">
		<!-- 
				<table class="table table-hover table-bordered">
      				
      				<tr>
      				<td>
      				充电桩编号
      				</td>
      				</tr>
      				<tr>
      				</tr>
      				<tr>
      				</tr>
      				<tr>
      				</tr>
      				<tr>
      				</tr>
      				<tr>
      				</tr>
      				<tr>
      				</tr>
      				<tr>
      				</tr>
      				<tr>
      				</tr>
      				<tr>
      				</tr>
      				<tr>
      				</tr>
      				<tr>
      				</tr>
      				<tr>
      				</tr>
      				<tr>
      				</tr>
      				<tr>
      				</tr>
      				<tr>
      				</tr>

      			</table> -->
      			<pre>
	发送协议时间
	电压需求（V）
	电流需求（A）
	充电模式
	充电电压测量值（V）
	充电电流测量值（A）
	最高单体动力蓄电池电压及其组号
	当前荷电状态SOC（%）
	估算剩余充电时间（min）
	电压输出值（V)
	电流输出值（A）
	累计充电时间（min）
	充电机充电允许（<00>:=暂停；<01>：=允许）
	最高单体动力蓄电池电压所在编号
	最高动力蓄电池温度
	最高温度检测点编号
	最低动力蓄电池温度
	最低动力蓄电池温度检测点编号	
	单体动力蓄电池电压(过高/过低)
	整车动力蓄电池荷电状态SOC(过高/过低)
	动力蓄电池充电过电流
	动力蓄电池温度过高
	动力蓄电池绝缘状态
	动力蓄电池组输出连接器连接状态
	动力电池充电允许
      			</pre>
		</div>
		
	</div>
</div>
</body>
</html>