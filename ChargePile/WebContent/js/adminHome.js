$(function(){
	var basePath = $('base').attr('href');
	var $table = $('#CPTable');
	var $ok = $('#ok');
	
	$('#toSaler').click(function(){
		window.open(basePath+ 'pages/salerHome.jsp');
	});


    //获取充电桩数量
    $.ajax({
        url : basePath+'common/getTotalCount',
        type : 'POST',
        data : {"tableName" : 'charge_point'},
        async : false,
        success : function(data){
          var Point = $('#js-ChargePoint ').find('span');
          if(undefined != data && undefined != data.pageCount){
            Point.eq(0).children('em').text(data.pageCount);
            // $('#tatolChargePoint').text(data.pageCount);
          }
        }
    });
	
	$table.bootstrapTable({
		url: 'admin/getCPHomeByPage',//交流电
		method : 'get',// only get support
		clickToSelect:true, //点击行选中 多选框或单选框
		// detailView:true, //显示行详细信息
		// detailFormatter : detailFormatter,//展开数据显示回调函数
        idField:"c_p_id", //标识字段
        iconsPrefix:"fa", //定义是那一种类型的图标
        pagination:true, //显示分页
        pageNumber:1,            //初始化加载第一页，默认第一页
        pageSize: 10,            //每页的记录行数（*）
        pageList: [10, 25, 50, 100,200, 500],    //可供选择的每页的行数（*）
        toolbar:"#toolbar", // 工具栏
        toolbarAlign:"left", //工具栏位置
        queryParamsType:"limit", //请求附带其他参数必须设置为 limit
        queryParams:queryParamsfun, //附加参数方法
//        exportTypes: ['csv','txt','excel'],//导出类型选项//basic', 'all', 'selected'.
//        exportDataType: "basic",
        exportDataType: "all",
        uniqueId: "c_p_id",      //每一行的唯一标识，一般为主键列
        smartDisplay: true,
        sortName:["c_p_id","is_free","total_degree","time_count"], //默认排序的列
        sortable: true,      //是否启用排序
//        sortOrder: "asc",     //排序方式
        height: $(window).height() - 100,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        showRefresh:true, //显示刷新
        showColumns:true,//提供选择进行切换显示那些列
        showToggle:true,     //是否显示详细视图和列表视图的切换按钮   
        showExport: true,//导出按钮
        showColumns: true,     //是否显示所有的列
        sidePagination:'server',//设置为服务器端分页
        striped : true,//条纹样式
//        search: true, //显示搜索框（服务器端分页不检索）
//        searchOnEnterKey : true,
        formatLoadingMessage: function () {
            return "请稍等，正在加载中...";
        },
        formatNoMatches: function () {  //没有匹配的结果
            return '无符合条件的记录';
        },
        onLoadError: function (data) {
            $table.bootstrapTable('removeAll');
        },
//        onClickRow: function (row) {
//            window.location.href = "/qStock/qProInfo/" + row.ProductId;
//        },
        rowStyle: function (row, index) {
            //这里有5个取值代表5中颜色['active', 'success', 'info', 'warning', 'danger'];
            var strclass = "";
            if (row.battery_type == "锂电池") {
                strclass = 'success';//还有一个active
            }
            else if (row.battery_type == "铅酸电池") {
                strclass = 'danger';
            }
            else {
                return {};
            }
            return { classes: strclass }
        },
        icons:{ //对应的图标样式
              columns:"fa-bars",
              toggle: "fa-th-list",
              refresh:"fa-refresh",
              detailClose: "fa-minus",
              detailOpen: "fa-plus"
            },
		columns: [//{checkbox:true},
        {
            field: 'c_p_id',
            align:"center",
            title: '充电桩编号',
            sortable:true, //是否允许排序
            order:"asc", //默认排序
            visible:true //是否具有收起效果
        },{
            field: 'time_count',
            align:"center",
            title: '累计充电时间(h)',
            sortable:true, //是否允许排序
            order:"desc", //默认排序            
            visible:true
        },{
            field: 'total_degree',
            align:"center",
            title: '累计充电量(kw/h)',
            sortable:true, //是否允许排序
            order:"desc", //默认排序            
            visible:true
        },{
            field: 'is_free',
            align:"center",
            title: '是否空闲',
            sortable:true, //是否允许排序
            formatter: freeStatusFormatter,
            visible:true
        },{
            field: 'c_p_type',
            align:"center",
            visible:true,
            order:"asc",
            formatter: CPTypeFormatter,
            title: '充电桩类型'
        },{
            field: 'place',
            align:"center",
            title: '充电桩位置',
            visible:true
        },{
            field: 'e_price',
            align:"center",
            visible:true,
            sortable:true,
            title: '电费'
        }],
        onClickRow:function(row,tr){
//            alert(row.c_p_id);
//            ids =row.id + "," + ids;
         },
	});
	//end bootstrapTable
	
	//查询参数
    function queryParamsfun(params){
        
    	var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
    			limit: params.limit, //页面大小  
    			offset: params.offset, //页码 
    			order: params.order,   
    			sortName: params.sort,   
    			c_p_id : $("#txt_search_id").val(),
    			is_free : $("#txt_select_free option:selected").val()
    			};
    	
        return temp;
    }
    
    //自定义空闲状态值
    function freeStatusFormatter(value, row, index) {
    	var d = '';  
//    	0-空闲，1-占用，2-被预约
    		if(row.is_free == "0"){
    			d = '空闲'
    		}else if(row.is_free == "1"){
    			d = '占用'
    		}
    		else if(row.is_free == "2"){
    			d = '被预约'
    		}else{
    			d = '-'
    		}
              return d; 
    }
    
  //自定义充电桩类型
    function CPTypeFormatter(value, row, index) {
    	var d = '';  
    		if(row.c_p_type == "0"){
    			d = '直流'
    		}else if(row.c_p_type == "1"){
    			d = '交流'
    		}
    		else{
    			d = '-'
    		}
              return d; 
    }
	
	
    $ok.click(function () {
        $table.bootstrapTable('refresh');
    });
    
	/*-------------------end table tab-----------------------------------*/
	
   // 百度地图
    
	var map = new BMap.Map("CPmap");
	var point = new BMap.Point(116.331398,39.897445);
	map.centerAndZoom(point,12);                // 初始化地图,设置城市和地图级别。
	map.enableScrollWheelZoom(true);
	
	function myFun(result){
		var cityName = result.name;
		map.setCenter(cityName);
		// alert("当前定位城市:"+cityName);
	}
	var myCity = new BMap.LocalCity();
	myCity.get(myFun);
	
	var index = 0;
	var myGeo = new BMap.Geocoder();
	
	// 获取坐标覆盖图标
    $.ajax({
        type : 'GET',
        url : 'admin/getCPMap'
    }).done(function(res){
        if (res.chargePointList != null) {
            $.each(res.chargePointList,function(i,k){
                if (k.location != null) {
                    var landmark = k.location(',');
                    var lng = landmark[0];
                    var lat = landmark[1];
                    var cppoint = new BMap.Point(lng,lat);
                    adds.push(cppoint);
                    var marker = new BMap.Marker(adds[i]);
                    map.addOverlay(marker);
                    var content = '充电桩ID:'+k.c_p_id+'地址:'+k.place;
                    var sContent =
                        "<h4 style='margin:0 0 5px 0;padding:0.2em 0'>充电桩ID: "+k.c_p_id+"</h4>" + 
                        "<img style='float:right;margin:4px' id='imgDemo' src='http://app.baidu.com/map/images/tiananmen.jpg' width='139' height='104' title='天安门'/>" + 
                        "<p style='margin:0;line-height:1.5;font-size:13px;text-indent:2em'>天安门坐落在中国北京市中心,故宫的南侧,与天安门广场隔长安街相望,是清朝皇城的大门...</p>" + 
                        "</div>";
                    addClickHandler(sContent,marker);                    
                }
            });
        }
    });
	function addClickHandler(content,marker){
		marker.addEventListener("click",function(e){
			openInfo(content,e)}
		);
	}
	
	var opts = {
        width : 300,     // 信息窗口宽度
        height: 200,     // 信息窗口高度
        // title : "海底捞王府井店" , // 信息窗口标题
        enableMessage:true,//设置允许信息窗发送短息
        // message:"亲耐滴，晚上一起吃个饭吧？戳下面的链接看下地址喔~"
	}
	
	function openInfo(content,e){
		var p = e.target;
		var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
		var infoWindow = new BMap.InfoWindow(content,opts);  // 创建信息窗口对象 
		map.openInfoWindow(infoWindow,point); //开启信息窗口
	}
	
	function bdGEO(){	
		var pt = adds[index];
		geocodeSearch(pt);
		index++;
	}
	function geocodeSearch(pt){
		if(index < adds.length-1){
			setTimeout(window.bdGEO,400);
		} 
		myGeo.getLocation(pt, function(rs){
			var addComp = rs.addressComponents;
			document.getElementById("result").innerHTML += index + ". " +adds[index-1].lng + "," + adds[index-1].lat + "："  + "商圈(" + rs.business + ")  结构化数据(" + addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber + ")<br/><br/>";
		});
	}
});
