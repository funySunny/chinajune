$(function(){
	var basePath = $('base').attr('href');
	var $del = $('#btn_delete');
	var $table = $('#table');
	var $ok = $('#ok');
	
	$table.bootstrapTable({
		url: 'admin/getChargePointByPage/1',//交流电
		method : 'get',
		clickToSelect:true, //点击行选中 多选框或单选框
		detailView:false, //显示行详细信息
		detailFormatter : detailFormatter,//展开数据显示回调函数
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
//      四个参数field, row, oldValue, $el分别对应着当前列的名称、当前行数据对象、更新前的值、编辑的当前单元格的jQuery对象。
        onEditableSave: function (field, row, oldValue, $el) {
        	
        	var rowData = {'c_p_id':row.c_p_id,'w':row.w,'e_price':row.e_price,'dtu_id':row.dtu_id,'v_max_charge_out':row.v_max_charge_out,'v_min_charge_out':row.v_min_charge_out,'i_max_charge_out':row.i_max_charge_out,'i_min_charge_out':row.i_min_charge_out};
            $.ajax({
                type: "post",
                url: basePath + "admin/updateChargePoint",
                data: { jsonStr: encodeURI(JSON.stringify(rowData)) },
                success: function (data, status) {
                    if (status == "success" && data.updateResult) {
                        alert("编辑成功");
                    }else{
                    	alert("编辑失败");
                    	alert(row);
                    	$el.text(oldValue);//回退修改之前的值
                    }
                },
                error: function () {
                    alert("连接错误");
                },
                complete: function () {
//                	updateResult;
                }

            });
        },
        uniqueId: "c_p_id",      //每一行的唯一标识，一般为主键列
        smartDisplay: true,
        sortName:["c_p_id","w","v_total_allow"], //默认排序的列
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
            $('#table').bootstrapTable('removeAll');
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
              toggle: "fa-th-large",
              refresh:"fa-refresh",
              detailClose: "fa-minus",
              detailOpen: "fa-plus"
            },
		columns: [{checkbox:true},
		{
            field: 'operate',
            title: '操作',
            align: 'center',
            events: 'operateEvents',// bind event
            formatter: operateFormatter //最后一列显示内容
        },
        {
            field: 'c_p_id',
            align:"center",
            title: '充电桩编号',
            sortable:true, //是否允许排序
            order:"asc", //默认排序
            visible:true //是否具有收起效果
        },{
            field: 'w',
            align:"center",
            title: '充电桩功率（W）',
            sortable:true, //是否允许排序
            order:"desc", //默认排序            
            visible:true
        },{
            field: 'is_free',
            align:"center",
            title: '是否空闲',
            formatter: freeStatusFormatter,
            visible:true
        },{
            field: 'dtu_id',
            align:"center",
            title: 'DTU编号',
            editable:true,//enable edit
            visible:true
        }, {
            field: 'e_price',
            align:"center",
            visible:true,
            sortable:true,
            editable:true,//enable edit
            title: '电费'
        }, {
            field: 'v_max_charge_out',
            align:"center",
            visible:true,
            sortable:true,
            order:"asc",
            editable:true,//enable edit
            title: '最高输出电压（V）'
        }, {
            field: 'v_min_charge_out',
            align:"center",
            visible:true,
            sortable:true,
            editable:true,//enable edit
            title: '最低输出电压（V)'
        }, {
            field: 'i_max_charge_out',
            align:"center",
            visible:true,
            sortable:true,
            order:"asc",
            editable:true,//enable edit
            title: '最大输出电流（A)'
        }, {
            field: 'i_min_charge_out',
            align:"center",
            visible:true,
            editable:true,//enable edit
            title: '最小输出电流（A）'
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
	
//	批量删除按钮
	 $('#btn_delete').click(function () {
		 
         var ids = $.map($table.bootstrapTable('getSelections'), function (row) {
             return row.c_p_id;
         });
         
         var deleteFlag = false;
			$.ajax({
				url : 'admin/deleteChargePoints/'+ids,
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
            
            html.push('<p><b class="col-lg-2">' + key + ':</b> <label disabled>' + value + '<label/></p>');
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
    
    $ok.click(function () {
        $table.bootstrapTable('refresh');
    });
    
//    操作按钮事件
    window.operateEvents = {
            'click .remove': function (e, value, row, index) {
            	var deleteFlag = false;
				$.ajax({
					url : 'admin/deleteChargePoint/'+row.c_p_id,
					type : "POST",
					async: false,
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
						values: [row.c_p_id]
					});
				}
            }
        };
    
    
    $('#toSaler').click(function(){
		window.open(basePath+ 'pages/salerHome.jsp');
	});
});