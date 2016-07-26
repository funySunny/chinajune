$(function(){
	var basePath = $('base').attr('href');
	var $del = $('#btn_delete');
	var $table = $('#table');
	var $delC = $('#btn_delete_c');
	var $tableC = $('#tableC');
	
	var browserType  = function(){

		if(navigator.userAgent.indexOf("MSIE")>0) {    
              return "IE";       //IE浏览器  
		}  
		if(isFirefox=navigator.userAgent.indexOf("Firefox")>0){    
              return "FF";     //Firefox浏览器  
		}  
		if(isSafari=navigator.userAgent.indexOf("Safari")>0) {    
			return "SF";      //Safan浏览器 、谷歌 
		}  
		
	};
	
	$table.bootstrapTable({
		url: 'sale/getSaleByPage',
		method : 'get',
//		detailView:true, //显示行详细信息
		detailFormatter : detailFormatter,//展开数据显示回调函数
        idField:"c_p_id", //标识字段
        pagination:true, //显示分页
        toolbar:"#toolbar", // 工具栏
        toolbarAlign:"left", //工具栏位置
        queryParamsType:"limit", //请求附带其他参数必须设置为 limit
        queryParams:queryParamsfun, //附加参数方法
        showRefresh:true, //显示刷新
        showColumns:true,//提供选择进行切换显示那些列
        showToggle : true,//切换行显示样式
        showExport: true,//导出按钮
//        exportTypes: ['csv','txt','excel'],//导出类型选项//basic', 'all', 'selected'.
        exportDataType: "all", 
//        search: true, //显示搜索框（服务器端分页不检索）
        smartDisplay: true,
        sortName:["c_p_id","saled_time"], //默认排序的列
        sidePagination:'server',//设置为服务器端分页
        striped : true,//条纹样式
//        searchOnEnterKey : true,
        iconsPrefix:"fa", //定义是那一种类型的图标
        clickToSelect:true, //点击行选中 多选框或单选框
        formatLoadingMessage: function () {
            return "请稍等，正在加载中...";
        },
        formatNoMatches: function () {  //没有匹配的结果
            return '无符合条件的记录';
        },
        onLoadError: function (data) {
            $('#table').bootstrapTable('removeAll');
        },
//        onClickRow: function (row) {
//            window.location.href = "/qStock/qProInfo/" + row.ProductId;
//        },
        icons:{ //对应的图标样式
              detailClose: "fa-minus fa-1x",
              columns:"fa-bars fa-1x",
              toggle: 'fa-exchange fa-1x',
              refresh:"fa-refresh",
              detailOpen: "fa-plus"
            },
		columns: [{checkbox:true},{
            field: 'c_p_id',
            align:"center",
            title: '充电桩编号',
            sortable:true, //是否允许排序
            order:"asc", //默认排序
            visible:true //是否具有收起效果
        },{
            field: 'location',
            align:"center",
            visible:true,
            title: '位置'
        }, {
            field: 'company_name',
            align:"center",
            title: '公司名称',
            visible:true
        }, {
            field: 'saled_time',
            align:"center",
            visible:true,
            sortable:true,
            order:"asc",
            title: '售出时间'
        },{
            field: 'operate',
            title: '操作',
            align: 'center',
            events: 'operateEvents',// bind event
            formatter: operateFormatter //最后一列显示内容
        }],
//        onClickRow:function(row,tr){
//            
//            ids =row.id + "," + ids;
//         }
	});
	//end bootstrapTable
	
	//查询参数
    function queryParamsfun(params){
    	var s_time = $('#start_time').val();
    	var e_time = $('#end_time').val();
    	var s_timeStr = s_time.replace('十二月','12').replace('十一月','11').replace('十月','10').replace('九月','09').replace('八月','08').replace('七月','07').replace('六月','06').replace('五月','05').replace('四月','04').replace('三月','03').replace('二月','02').replace('一月','01');
    	var e_timeStr = e_time.replace('十二月','12').replace('十一月','11').replace('十月','10').replace('九月','09').replace('八月','08').replace('七月','07').replace('六月','06').replace('五月','05').replace('四月','04').replace('三月','03').replace('二月','02').replace('一月','01');
    	
    	var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
    			limit: params.limit, //页面大小  
    			offset: params.offset, //页码 
    			order: params.order,   
    			sortName: params.sort,   
    			start_time : s_timeStr,
    			end_time : e_timeStr 
    			};
    	
        return temp;
    }
    
  //点击  + 图标 显示行详细记录
    function detailFormatter(index, row) {
        var html = [];
        $.each(row, function (key, value) {
            
//            if(key == "invalid"){
//                
//                return true;
//            }
//            if(key == "userId"){
//                
//                key = "userName";
//                value = value.loginName;
//            }
            
            html.push('<p><b class="col-lg-2">' + key + ':</b> <input type="text" value="' + value + '" disabled/></p>');
        });
        return html.join('');
    } 
    
    //每行后面显示操作的列
    function operateFormatter(value, row, index) {
        
     /*   if(flag == "已审批"){
            
            return [
                    '<a class="remove" href="javascript:void(0)" title="删除">',
                    '<i class="fa fa-times fa-1x"></i>',
                    '</a>'
                ].join('');
            
        }
        
        return [
            '<a class="like" href="javascript:void(0)" title="处理">',
            '<i class="fa fa-pencil-square-o fa-1x"></i>',
            '</a>  ',
            '<a class="remove" href="javascript:void(0)" title="删除">',
            '<i class="fa fa-times fa-1x"></i>',
            '</a>'
        ].join('');*/
    	
         var d = '<a class="remove" href="javascript:void(0)" title="删除">'+
         '<i class="fa fa-trash fa-1x"></i></a>';  
              return d; 
    }
    
//    操作按钮事件
    window.operateEvents = {
            'click .remove': function (e, value, row, index) {
            	var deleteFalg = false;
				$.ajax({
					url : 'sale/deleteSale/'+row.c_p_id,
					type : "POST",
					async: false,
					success : function(data){
					if(data && undefined != data.deleteFlag){
						if(data.deleteFlag){
							deleteFalg = true;
							 $('#Alert').alertClear();
							 $('#Alert').alertSuccess('删除成功。');
						}else{
							$('#Alert').alertClear();
							$('#Alert').alertSuccess('删除数据失败，请重试。');
						}
					}else{
						$('#Alert').alertClear();
						$('#Alert').alertSuccess('您的网络连接有问题。');
					};
					}
						});
				if(deleteFalg){
					$table.bootstrapTable('remove', {
						field: 'c_p_id',
						values: [row.c_p_id]
					});
				}
            }
        };
    
    $('#startTimeSelect').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 0,
		maxView: 1,
		forceParse: 0
    });
        
    $('#endTimeSelect').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 0,
		maxView: 1,
		forceParse: 0
    });
    
//	批量删除按钮
	 $('#btn_delete').click(function () {
		 
        var ids = $.map($table.bootstrapTable('getSelections'), function (row) {
            return row.c_p_id;
        });
        
        var deleteFlag = false;
			$.ajax({
				url : 'sale/deleteSales/'+ids,
				type : "POST",
				async: false,
				beforesend : function(){
					loadingTip('数据加载中..');
				},
				success : function(data){
				if(data && undefined != data.deleteResult){
					if(data.deleteResult){
						deleteFlag = true;
						alertTip('删除成功');
						
					}else{
						alertTip('删除数据失败');
					}
				}else{
					alertTip('服务器连接出错');
				};
				}
					});
        if(deleteFlag){
       	 $table.bootstrapTable('remove', {
       		 field: 'c_p_id',
       		 values: ids
       	 });
       	 $table.bootstrapTable('refresh');
        }
    });
    
    $('#ok').click(function(){
    	$table.bootstrapTable('refresh');
    });
    
    if(browserType() == "IE"){
    	$("[data-toggle='tooltip']").tooltip();
    }
    
    /*-----------------------end sale--------------------------------*/
    $tableC.bootstrapTable({
		url: 'company/getCompanyByPage',
		method : 'get',
//		detailView:true, //显示行详细信息
		detailFormatter : detailFormatterC,//展开数据显示回调函数
        idField:"company_name", //标识字段
        pagination:true, //显示分页
        toolbar:"#toolbarC", // 工具栏
        toolbarAlign:"left", //工具栏位置
        queryParamsType:"limit", //请求附带其他参数必须设置为 limit
        queryParams:queryParamsfunC, //附加参数方法
        showRefresh:true, //显示刷新
        showColumns:true,//提供选择进行切换显示那些列
        showToggle : true,//切换行显示样式
        showExport: true,//导出按钮
//        exportTypes: ['csv','txt','excel'],//导出类型选项//basic', 'all', 'selected'.
        exportDataType: "basic", 
//        search: true, //显示搜索框（服务器端分页不检索）
        smartDisplay: true,
        sortName:["company_name","reg_no","company_addr"], //默认排序的列
        sidePagination:'server',//设置为服务器端分页
        striped : true,//条纹样式
//        searchOnEnterKey : true,
        iconsPrefix:"fa", //定义是那一种类型的图标
        clickToSelect:true, //点击行选中 多选框或单选框
        formatLoadingMessage: function () {
            return "请稍等，正在加载中...";
        },
        formatNoMatches: function () {  //没有匹配的结果
            return '无符合条件的记录';
        },
        onLoadError: function (data) {
            $('#table').bootstrapTable('removeAll');
        },
//        onClickRow: function (row) {
//            window.location.href = "/qStock/qProInfo/" + row.ProductId;
//        },
        icons:{ //对应的图标样式
              detailClose: "fa-minus fa-1x",
              columns:"fa-bars fa-1x",
              toggle: 'fa-exchange fa-1x',
              refresh:"fa-refresh",
              detailOpen: "fa-plus"
            },
		columns: [{checkbox:true},{
            field: 'company_name',
            align:"center",
            title: '公司名字',
            sortable:true, //是否允许排序
            order:"asc", //默认排序
            visible:true //是否具有收起效果
        },{
            field: 'reg_no',
            align:"center",
            visible:true,
            sortable:true, //是否允许排序
            title: '注册编号'
        }, {
            field: 'company_addr',
            align:"center",
            title: '公司地址',
            sortable:true, //是否允许排序
            visible:true
        },{
            field: 'is_reg',
            align:"center",
            title: '是否注册',
            visible:true,
            formatter: regFormatterC
        },{
            field: 'operate',
            title: '操作',
            align: 'center',
            events: 'operateEvents',// bind event
            formatter: operateFormatterC //最后一列显示内容
        }],
//        onClickRow:function(row,tr){
//            
//            ids =row.id + "," + ids;
//         }
        });
	//end bootstrapTable
	
	//查询参数
    function queryParamsfunC(params){
    	var search_text = $('#search_text').val();
    	
    	var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
    			limit: params.limit, //页面大小  
    			offset: params.offset, //页码 
    			order: params.order,   
    			sortName: params.sort,   
    			searchText : search_text
    			};
    	
        return temp;
    }
    
  //点击  + 图标 显示行详细记录
    function detailFormatterC(index, row) {
        var html = [];
        $.each(row, function (key, value) {
            
//            if(key == "invalid"){
//                
//                return true;
//            }
//            if(key == "userId"){
//                
//                key = "userName";
//                value = value.loginName;
//            }
            
            html.push('<p><b class="col-lg-2">' + key + ':</b> <input type="text" value="' + value + '" disabled/></p>');
        });
        return html.join('');
    } 
    
    //每行后面显示操作的列
    function operateFormatterC(value, row, index) {
        
     /*   if(flag == "已审批"){
            
            return [
                    '<a class="remove" href="javascript:void(0)" title="删除">',
                    '<i class="fa fa-times fa-1x"></i>',
                    '</a>'
                ].join('');
            
        }
        
        return [
            '<a class="like" href="javascript:void(0)" title="处理">',
            '<i class="fa fa-pencil-square-o fa-1x"></i>',
            '</a>  ',
            '<a class="remove" href="javascript:void(0)" title="删除">',
            '<i class="fa fa-times fa-1x"></i>',
            '</a>'
        ].join('');*/
    	
         var d = '<a class="removeC" href="javascript:void(0)" title="删除">'+
         '<i class="fa fa-trash fa-1x"></i></a>';  
              return d; 
    }
    
  //每行后面显示操作的列
    function regFormatterC(value, row, index) {
    	var d = '';  
    		if(row.is_reg == "N"){
    			d = '否'
    		}else if(row.is_reg == "Y"){
    			d = '是'
    		}
    		else{
    			d = '-'
    		}
              return d; 
    }
    
//    操作按钮事件
    window.operateEvents = {
            'click .removeC': function (e, value, row, index) {
            	var deleteFalg = false;
				$.ajax({
					url : 'company/deleteCompany/'+row.company_name,
					type : "POST",
					async: false,
					success : function(data){
					if(data && undefined != data.deleteFlag){
						if(data.deleteFlag){
							deleteFalg = true;
							 $('#Alert').alertClear();
							 $('#Alert').alertSuccess('删除成功。');
						}else{
							$('#Alert').alertClear();
							$('#Alert').alertSuccess('删除数据失败，请重试。');
						}
					}else{
						$('#Alert').alertClear();
						$('#Alert').alertSuccess('您的网络连接有问题。');
					};
					}
						});
				if(deleteFalg){
					$tableC.bootstrapTable('remove', {
						field: 'company_name',
						values: [row.company_name]
					});
				}
            }
        };
    
//	批量删除按钮
    $delC.click(function () {
		 
        var companyNames = $.map($tableC.bootstrapTable('getSelections'), function (row) {
            return row.company_name;
        });
        
        var deleteFlag = false;
			$.ajax({
				url : 'company/deleteCompanys/'+companyNames,
				type : "POST",
				async: false,
				beforesend : function(){
					loadingTip('数据加载中..');
				},
				success : function(data){
				if(data && undefined != data.deleteResult){
					if(data.deleteResult){
						deleteFlag = true;
						alertTip('删除成功');
						
					}else{
						alertTip('删除数据失败');
					}
				}else{
					alertTip('服务器连接出错');
				};
				}
					});
        if(deleteFlag){
       	 $tableC.bootstrapTable('remove', {
       		 field: 'company_name',
       		 values: companyNames
       	 });
       	 $tableC.bootstrapTable('refresh');
        }
    });
    
    
    $('#GO').click(function(){
    	$tableC.bootstrapTable('refresh');
    });
});