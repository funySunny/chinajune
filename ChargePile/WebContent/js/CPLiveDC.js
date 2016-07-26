$(function(){
	var basePath = $('base').attr('href');
	
	$('#toSaler').click(function(){
		window.open(basePath+ 'pages/salerHome.jsp');
	});
	
//获取最新数据	
	$.ajax({
		url: basePath+'admin/getChargePointByPage/0',//直流电
		type : 'GET',
		data : {offset : 0,limit : 20,sortName : 'is_free'},
//		async : false,
		success : function(data){
			if(undefined != data && undefined != data.rows){
				$('.panel-body').empty();
				for(var i = 0 ; i < data.rows.length ; i++){
				if(data.rows[i].is_free=='0'){//空闲
					$('.panel-body').append('<ul class="list-group col-md-2">'
							+'<li class="list-group-item" style="font-size:12px;height:80px;background-color:#96A734;">ID:&nbsp;'+data.rows[i].c_p_id
							+'<br><a id="more_c_p_info" style="float:right;">更多>></a></li>'
						+'</ul>');
				}else if(data.rows[i].is_free=='1'){//被预约
					$('.panel-body').append('<ul class="list-group col-md-2">'
							+'<li class="list-group-item" style="height:80px;background-color:#F49B49;">ID:&nbsp;<br>'+data.rows[i].c_p_id
							+'<br><a id="more_c_p_info" style="float:right;">更多>></a></li>'
						+'</ul>');
				}else if(data.rows[i].is_free=='2'){//充电中
					$('.panel-body').append('<ul class="list-group col-md-2">'
							+'<li class="list-group-item" style="height:80px;background-color:#E84A25;">ID:&nbsp;<br>'+data.rows[i].c_p_id
							+'<br><a id="more_c_p_info" style="float:right;">更多>></a></li>'
						+'</ul>');
				}

				}
			}
		}
	});
//	$('#table').
	
});