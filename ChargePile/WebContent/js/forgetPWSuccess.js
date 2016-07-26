$(function(){
	var basePath = $('base').attr('href');
	var inputUserName = $("#name").val().trim();
	var code = $("#code").val().trim();
	
//	check security
		$.ajax({
			url : basePath + 'admin/getUser', 
			type : 'POST',
			data : {"userName" : inputUserName},
			success :function(result) {
				if(null != result.user.email_code && result.user.email_code == code){
					loadingTip('验证成功，请完成以下步骤完成密码重置');
				}else{
					location.href = basePath+'index.jsp';
				}
					
			}
			});
	
	
	$('#step4').css('display','none');
	$('.breadcrumb li').eq(2).addClass('breadcrumb_active');
	
	var $form = $('.form-horizontal');
	
	// Form validate
	$form.bootstrapValidator({
		message : '不合法的输入值',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			password : {
				validators : {
					notEmpty : {
						message : '密码不能为空'
					},
					stringLength : {
						min : 6,
						max : 30,
						message : '密码必须为6-30个字符'
					}
				}
			},
			confirm_password : {
				validators : {
					notEmpty : {
						message : '请再次输入密码'
					},
					identical : {
						field : 'password',
						message : '两次密码不一致'
					}
				}
			}
		}
	});
	
	$('#step3 input').keyup(function(){
		var $divFlag = $('#step3').children('div');
		if($divFlag.eq(0).attr('class') == 'form-group has-feedback has-success'
			&& $divFlag.eq(1).attr('class') == 'form-group has-feedback has-success'
		){
			
			$('#step3-next').attr('class','');
		}else{
			$('#step3-next').attr('class','disabled');
		}
	});
	
	var doReset = function(jsonData){
		
		 var jsonStr  = encodeURI(JSON.stringify(jsonData));
		// Use Ajax to submit form data
		$.ajax({
				url : $form.attr('action'), 
				type : 'POST',
				data : {"jsonStr" : jsonStr},
				success :function(result) {
			if(result.updateResult){
				$('.breadcrumb li').removeClass('breadcrumb_active');
				$('.breadcrumb li').eq(3).addClass('breadcrumb_active');
				$('#step1,#step2,#step3').css('display','none');
				$('#step4').css('display','block');
				$.ajax({
					url : basePath + 'admin/getUser', 
					type : 'POST',
					data : {"userName" : inputUserName},
					success :function(result) {
				if(null != result.user){
					$('#userName').text(inputUserName);
					$('#userID').text(result.user.id);
					$('#userPortrait').attr('src',result.user.head_portrait);
				}
					}
				});
			}else{
				alertTip('重置密码失败，请检查密保问题和答案是否正确');
			}
		} 
		});
		
		};//end submit function
	
	$('#step3-next').click(function(){
		 var jsonData = {
				 	'user_name' : inputUserName,
					'password' : MD5($("input[name='password']").val().trim())
		 };
		doReset(jsonData);
	});
	

});