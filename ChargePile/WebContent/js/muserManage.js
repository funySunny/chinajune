$(function(){
	var basePath = $('base').attr('href');
		$('#myLoginModal').modal('show');
		$('#btnExit').click(function(){
			window.location.href = 'f/Index';	
		});
		
		$('#toSaler').click(function(){
			window.open(basePath+ 'pages/salerHome.jsp');
		});
		
		var setUserList =function(data){
			$('#addTr tr').remove('#append');
			for(var i = 0; i < data.length ; i++){
				switch(data[i].gender){
				case ('0') : data[i].gender = '男';break;
				case ('1') : data[i].gender = '女';break;
				case ('2') : data[i].gender = '保密';break;
				}
				
				$('#addTr').append("<tr id='append'><td>"+data[i].user_name
						+"<td>******</td>"
						+"<td>"+data[i].tel+"</td>"
						+"<td>"+data[i].reg_time+"</td>"
						+"<td>"+data[i].true_name+"</td>"
						+"<td>"+data[i].gender+"</td>"
						+"<td>"+data[i].identity+"</td>"
						+"<td>"+data[i].money+"</td>"
						+"<td><img with='30' height='30' src='"+data[i].head_portrait+"'/></td>"
						+"<td>"+data[i].plate_no+"</td>"
						+"<td>"+data[i].car_type+"</td>"
						+"<td>"+data[i].interface_type+"</td>"
						+"<td>"+data[i].car_frame_no+"</td>"
						+"<td><span id='modifyUser' title='修改' class='glyphicon glyphicon-edit'></span>|<span id='deleteUser' title='删除' class='glyphicon glyphicon-trash'></span></td></tr>");
				
			}
			
		};
		
//		添加用户按钮
		$('#addUser').click(function(){
			window.open(basePath+'pages/register.jsp');
		});
		
//		过滤按钮
		$("#txt_search_id").keyup(function() {
			$("td").removeClass('text-danger');
			var filterText = $(this).val();
			if('' != filterText){
				$("table.table tr").not(":first").hide().filter(":contains('" + filterText + "')").show().children('td').removeClass('text-success').filter(":contains('" + filterText + "')").addClass('text-danger');
			}
		}).keyup();
		
		var user_btn_function = function(){
			$('#addTr #append').each(function(){//contents() all child nodes
//		删除用户按钮(当有列表数据才执行)
				$(this).children('td').find('#deleteUser').click(function(){
					var userName = $(this).parent().prevAll('td:last').text();
					var deleteFalg = false;
					$.ajax({
						type:'POST',
						url : 'admin/deleteUser/'+userName,
						async: false,
						success : function(data){
							if(data && data.success == 'true' && undefined != data.deleteResult){
								deleteFalg = true;
							}
						}
					});
					if(deleteFalg){
						$(this).parent().parent('tr').remove();
					}
				});
//			修改用户按钮
				$(this).children('td').find('#modifyUser').click(function(){
					var carFrameNO = $(this).parent().prevAll('td:first').text();
					var userName = $(this).parent().prevAll('td:last').text();
					var interfaceType = $(this).parent().prevAll('td:eq(1)').text();
					var carType = $(this).parent().prevAll('td:eq(2)').text();
					var plateNO = $(this).parent().prevAll('td:eq(3)').text();
					var headPortrait = $(this).parent().prevAll('td:eq(4)').children('img').attr('src');
					var money = $(this).parent().prevAll('td:eq(5)').text();
					var identity = $(this).parent().prevAll('td:eq(6)').text();
					var gender = $(this).parent().prevAll('td:eq(7)').text();
					var trueName = $(this).parent().prevAll('td:eq(8)').text();
					var regTime = $(this).parent().prevAll('td:eq(9)').text();
					var tel = $(this).parent().prevAll('td:eq(10)').text();
					var pw = $(this).parent().prevAll('td:eq(11)').text();
					
//					var email = $(this).parent().prevAll('td:eq(5)').text();
					var jsonData = {
							'userName':userName,
							'money':money,
							'headPortrait':headPortrait,
							'identity':identity,
							'gender':gender,
							'trueName':trueName,
							'regTime':regTime,
							'pw':pw,
							'tel':tel,
							'carType':carType,
							'carFrameNO':carFrameNO,
							'interfaceType':interfaceType,
							'plateNO':plateNO
							};
//					以post方式打开（修改页面）窗口
					var jsonStr  = encodeURI(JSON.stringify(jsonData));
					$('#modifyUserPage>input').attr('value',jsonStr);
					$('form').submit();
					
				});
			});
			
		};
		
		var setUserByPage = function(startIndex,pageSize){
			$.ajax({
				type : "POST",
				url : "mobile/getUserByPage",
				data : {"startIndex":startIndex,"pageSize":pageSize},
				//没有取得数据前显示执行方法
//				beforeSend: function () { loadingTips('数据加载中...', 300 , true); },	
				success : function(data){
						if (data && data.success == "true") {
							if('' == data.data){
//								showTips(tips, height, time) 
//								loadingTips('未找到数据', 300 , false);
								
								$('#addTr').remove('#append').append("<tr id='append'><td colspan='9' style='text-align:center;'>未找到数据</td><tr>");
							}else{
//								loadingTips('', 300 , false);
								setUserList(data.userList);
								user_btn_function();
							}
						
						}else{
							$('#addTr').remove('#append').append("<tr id='append'><td colspan='9' style='text-align:center;'>未找到数据</td><tr>");
						}
					}
			});//end post
		};
		
		var getTotalCount = function(tableName){
			var pageCount = 0;
			$.ajax({
				type : "POST",//与controller一致
				dataType : 'json',
				url : "common/getTotalCount",
				data : {"tableName" : tableName},
				async:false,
				success : function(data){
					if (data && data.success == "true") {
						if('' == data.pageCount || undefined == data.pageCount){
							$('#addTr').append("<tr id='append'><td colspan='9' style='text-align:center;'>未找到数据</td><tr>");
						}else{
							pageCount = data.pageCount;
						}
					
					}else{
						$('#addTr').append("<tr id='append'><td colspan='9' style='text-align:center;'>连接服务器出错</td><tr>");
					}
				}
			});
			return pageCount;
		};
		
		$('#userCount').text('共'+Math.ceil(getTotalCount('user')/10)+'页');
		setUserByPage(0,10);
		/*
		$('#page').createPage({
	        pageCount:10,
	       current:1,
	        backFn:function(p){
	           //单击回调方法，p是当前页码
	        }
	    });
	    pageCount：总页数
	    current：当前页
	*/
		
		$('#pageNagvator').createPage({
	        pageCount: Math.ceil(getTotalCount('user')/10),
	       current:1,
	        backFn:function(p){
	           //单击回调方法，p是当前页码
	        	setUserByPage((p-1)*10,10);
	        }
		});
});