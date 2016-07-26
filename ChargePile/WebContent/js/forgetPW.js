$(function() {
	var basePath = $('base').attr('href');
	var Froms = $('#js-forgetPaw');
	var inputUserName = Froms.find("input[name='name']").val();
	var inputPassWord = Froms.find("input[name='password']").val();
	var EmailCaptcha = '';
	forgetStep(); //初次调用
	// 下一步操作
	Froms.on('click','.nt',function(e){
		inputUserName = Froms.find("input[name='name']").val();
		inputPassWord = Froms.find("input[name='password']").val();
		var k = $(this).data('id');
		if (!$(this).hasClass('disabled')) {
			if (k == 1) {
				getPCUser(inputUserName);
			}else if (k == 2  && $('#emailCode').val() != EmailCaptcha) {
				return false;
			}else if (k == 3) {
				doReset({
				 	'user_name' : inputUserName,
					'password' : MD5(inputPassWord)
				});
				return false;
			};
			window.location.href = basePath+'f/ForgetPassword/'+k+'?userName='+inputUserName;
			forgetStep('next');
			return;
		};
	});
	// 上一步操作
	Froms.on('click','.prev',function(){
		forgetStep('prev');
	});

	// 点击发送验证码
	$('#js-sendEmail').on('click',function(){
		sendEmail($('#js-email').text());
		$(this).addClass('disabled').text('秒重发验证码');
		Countdown({
			box: this,
			num : 29,
			fun:function(){
				$('#js-sendEmail').removeClass('disabled').html('重发验证码');
			}
		});
	});
	//	刷新验证码
	$('#imgValidate').click(function(){
		$(this).attr('src','common/getCodeImg?temp='+(new Date().getTime().toString(36)));
	});
	// 验证验证码输入
	$('#step1 input').keyup(function(){
		var $divFlag = $('#step1').children('div');
		if($divFlag.eq(0).hasClass('has-success')
			&& $divFlag.eq(1).hasClass('has-success')
		){
			inputUserName = Froms.find("input[name='name']").val();
			$('#step1-next').removeClass('disabled');
		}else{
			$('#step1-next').addClass('disabled');
		}
	});
	// 邮箱验证码输入
	$('#step2 #emailCode').keyup(function(){
		if($(this).val() == EmailCaptcha){
			$('#step2-next').removeClass('disabled');
			$(this).next('span').remove();
		}else{
			if (!$(this).next('span').length) {
				$(this).after('<span class="note">输入验证码不正确！</span>');
			};
			$('#step2-next').addClass('disabled');
		}
	});
	// 重置密码输入
	$('#step3 input').keyup(function(){
		var $divFlag = $('#step3').children('div');
		if($divFlag.eq(0).hasClass('has-success')
			&& $divFlag.eq(1).hasClass('has-success')
		){
			$('#step3-next').removeClass('disabled');
		}else{
			$('#step3-next').addClass('disabled');
		}
	});
	// 发送修改
	var doReset = function(jsonData){
		 var jsonStr  = encodeURI(JSON.stringify(jsonData));
		// Use Ajax to submit form data
		$.ajax({
				url : Froms.attr('action'), 
				type : 'POST',
				data : {"jsonStr" : jsonStr},
				// 这两个参数需要被定义，否则报错
				// contentType : false,
	   			// processData : false,
				success :function(result) {
					if(result.resetFlag){
						forgetStep('next');
						Countdown({
							box:'#js-autoLg',
							num : 5,
							fun : function(){
								IntervalLogin({userName:result.resetedPCUser.user_name,pw:result.resetedPCUser.password});
							}
						});
					}else{
						alertTip('重置密码失败，请检查输入内容是否正确');
					}
				} 
		});
		
	};//end submit function
	//登录
	function IntervalLogin(data){
		$.ajax({
			type:'POST',
			url:basePath + 'login/pc',
			data:data,
		}).done(function(res){
			console.log('login success');
			if (res) {
				window.location.href = '/ChargePile/pages/index.jsp';
			};
		});
	};
	/*
	 *倒计时
	 *Countdown对象调用 box显示的盒子 num时间 fun回调函数
	 */
	function Countdown (e){
		var timer= null;
		$(e.box).prepend('<em></em>');
		timer =  setInterval(function(){
			$(e.box).find('em').html(e.num);e.num--;
			if (e.num < 0) {
				clearTimeout(timer);
				if (typeof e.fun == 'function') {
					e.fun();
				};
			};
		},1000);
	};
	// 页面跳转函数
	function forgetStep(step){
		var num = $('#js-step').val();
		num = num == '' ? 0 : num;
		if (step == 'next') {
			num++;
		}else if (step == 'prev') {
			num--;
		};
		$('#js-step').val(num);
		Froms.find('.step').eq(num).css('display','block').siblings('.step').css('display','none');
		$('#js-nav').find('li').eq(num).addClass('act').siblings('li').removeClass('act');
	};
	// 发送用户名
	function getPCUser(name){
		$.ajax({
			type:'POST',
			url:basePath + 'admin/getPCUser',
			data:{"userName" : name},
		}).done(function(result){
			if (result.user != null) {
				Froms.find('#js-email').html(result.user.email);
				Froms.find("input[name='email']").val(result.user.email);
			}
		});
	};
	//send email function
	var sendEmail = function(emailAddr,contents){
		$.ajax({
			url : basePath + 'common/sendEmailCode',
			type : 'POST',
			async : false,
			data : {"emailAddr" : emailAddr,"userName":inputUserName},
			success : function(result) {
				if (result.success) {
					EmailCaptcha = result.emailCode;
				}else{
					$('#js-sendEmail').html('请重发验证码');
				};
			}
		});
	};
	// Form validate
	Froms.bootstrapValidator({
		message : '不合法的输入值',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			name : {
				message : '不合法的用户名',
				validators : {
					notEmpty : {
						message : '用户名不能为空'
					},
					stringLength : {
						min : 6,
						max : 15,
						message : '用户名必须为6-15个字符'
					},
					regexp : {
						regexp : /^[\u4e00-\u9fa5a-zA-Z0-9_@\.]+$/,
						message : '用户名只能包含字母数字下划线和@号'
					},
					remote : {
						url : basePath + '/pc/resetCheckUserName',
						type : 'POST',
						message : '用户名不存在'
					}
				}
			},
			validateCode : {
				validators : {
					notEmpty : {
						message : '验证码不能为空'
					},
					remote : {
						url : basePath + '/pc/checkValidateCode',
						type : 'POST',
						message : '验证码错误',
					}
				}
			},
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
			answer1 : {
				message : '不合法的输入',
				validators : {
					stringLength : {
						max : 15,
						message : '密保答案最多15个字符'
					},
					regexp : {
						regexp : /^[\u4e00-\u9fa5a-zA-Z0-9_@\.]+$/,
						message : '密保答案只能包含字母数字下划线和@号'
					}
					
				}
			},
			answer2 : {
				message : '不合法的输入',
				validators : {
					stringLength : {
						max : 15,
						message : '密保答案最多15个字符'
					},
					regexp : {
						regexp : /^[\u4e00-\u9fa5a-zA-Z0-9_@\.]+$/,
						message : '密保答案只能包含字母数字下划线和@号'
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
	}).on('success.form.bv', function(e) {
		//验证通过 阻止当前提交事件，自行实现，否则会跳转
		e.preventDefault();
	});
	// end validate
});