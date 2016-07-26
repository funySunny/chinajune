$(function(){
	var basePath = $('base').attr('href');
	
	$('#toSaler').click(function(){
		window.open(basePath+ 'pages/salerHome.jsp');
	});
	
//获取最新数据	
	$.ajax({
		url: basePath+'admin/getChargePointByPage/1',//交流电
		type : 'GET',
		data : {offset : 0,limit : 20,sortName : 'is_free'},
//		async : false,
		success : function(data){
			if(undefined != data && undefined != data.rows){
				$('.panel-body').empty();
				for(var i = 0 ; i < data.rows.length ; i++){
				if(data.rows[i].is_free=='0'){//空闲
					$('.panel-body').append('<ul class="list-group col-md-2">'
							+'<li class="list-group-item" style="height:50px;color:white;background-color:#96A734;">ID:&nbsp;<span>'+data.rows[i].c_p_id
							+'</span></li>'
							+'<li class="list-group-item text-right text-primary">更多>></li>'
						+'</ul>');
				}else if(data.rows[i].is_free=='1'){//被预约
					$('.panel-body').append('<ul class="list-group col-md-2">'
							+'<li class="list-group-item" style="height:50px;color:white;background-color:#F49B49;">ID:&nbsp;<span>'+data.rows[i].c_p_id
							+'</span></li>'
							+'<li class="list-group-item text-right text-primary">更多>></li>'
						+'</ul>');
				}else if(data.rows[i].is_free=='2'){//充电中
					$('.panel-body').append('<ul class="list-group col-md-2">'
							+'<li class="list-group-item" style="height:50px;color:white;background-color:#F80707;">ID:&nbsp;<span>'+data.rows[i].c_p_id
							+'</span></li>'
							+'<li class="list-group-item text-right text-primary">更多>></li>'
						+'</ul>');
				}

				}
				$('.text-primary').css('cursor','pointer').each(function(){
					$(this).click(function(){
						var id = $(this).prev('li').children('span').text();
						alert(id);
						window.open(basePath+ 'pages/salerHome.jsp');
					});
				});
					
			}
		}
	});
//	$('#table').
	
});