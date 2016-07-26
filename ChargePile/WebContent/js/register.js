$(function() {
	var basePath = $('base').attr('href');
	var $form1 = $('#form1');
	var $form2 = $('#form2');
	var inputUserName = $("input[name='name']").val();
	var inputPassWord = $("input[name='password']").val();
	var question = '';
	var answer = '';
	//	默认样式
	$('#step2,#step3').css('display', 'none');

	$('#step1 input').keyup(function() {
		var $divFlag = $('#step1').find('.form-group');
		if ($divFlag.eq(2).hasClass('has-success')
			 && $divFlag.eq(3).hasClass('has-success')) {
			$('#step1-next').removeClass('disabled');
		} else {
			$('#step1-next').addClass('disabled');
		}
	});

	// 下一步
	$('#step1-next').click(function() {
		if (!$(this).hasClass('disabled')) {
			$('#step1,#step3').css('display', 'none');
			$('#step2').css('display', 'block');
		}
	});


	$('#step2 input').bind('keyup blur', function() {
		var $divFlag = $('#step2').children('div');
		if ($divFlag.eq(0).hasClass('has-success')) {
			$('#step2-next').removeClass('disabled');
		} else {
			$('#step2-next').addClass('disabled');
		}
	});

	$('#step2-next').click(function() {
		if (!$(this).hasClass('disabled')) {
			question = $("#question1").find("option:selected").val() + '$' + $("#question2").find("option:selected").val();
			answer = $("textarea[name='answer1']").val().trim() + '$' + $("textarea[name='answer2']").val().trim();
			$('#step1,#step2').css('display', 'none');
			$('#step3').css('display', 'block');
		}
	});

	$('#step2-prev').click(function() {
		$('#step2,#step3').css('display', 'none');
		$('#step1').css('display', 'block');
	});


	$('#step3-prev').click(function() {
		$('#step1,#step3').css('display', 'none');
		$('#step2').css('display', 'block');
	});

	// 获取公司列表
	$.ajax({
		url: basePath + 'company/getCompanyList',
		type: "POST",
		success: function(data) {
			var html= "";
			$.each(data.companyList,function(i,k){
				html  += '<option id="appendC">'+k.name +'</option>';
			});
			$('#companyName').append(html);
		}
	});

	// 初始化fileinput控件（第一次初始化）
	function initFileInput(ctrlName, uploadUrl, name) {
		var control = $('#' + ctrlName);

		control.fileinput({
			language: 'zh', // 设置语言
			uploadUrl: uploadUrl + name, // 上传的地址
			allowedFileExtensions: ['jpg', 'png', 'gif'], // 接收的文件后缀
			showUpload: true, // 是否显示上传按钮
			showCaption: false, // 是否显示标题
			showPreview: true, //预览框
			browseClass: "btn btn-default", // 按钮样式
			browseLabel: "添加文件",
			removeClass: "btn btn-danger",
			removeLabel: "移除",
			removeIcon: '<i ></i>',
			uploadClass: "btn btn-info",
			uploadLabel: "上传",
			uploadIcon: '<i ></i>',
			elErrorContainer: "#fileError",
			// dropZoneEnabled: false,//是否显示拖拽区域
			// minImageWidth: 50, //图片的最小宽度
			// minImageHeight: 50,//图片的最小高度
			maxImageWidth: 1000, // 图片的最大宽度
			maxImageHeight: 1000, // 图片的最大高度
			// maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
			// minFileCount: 0,
			maxFileCount: 1, // 表示允许同时上传的最大文件个数
			validateInitialCount: true,
			msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
			multiple: false,
			previewFileIcon: "<i class='fa fa-folder-open'></i>",
		});
	};

	//点击上传按钮、导入文件上传完成之后的事件
	$("#headPhoto").on("fileuploaded", function(event, data, previewId, index) {
		if (data.response.success == true) {
			var filePath = data.response.filePath; //供注册下面使用
			var jsonData = {
				'user_name': inputUserName,
				'head_portrait': filePath
			};
			var jsonStr = encodeURI(JSON.stringify(jsonData));
			$.ajax({
				url: basePath + 'admin/updateUser',
				type: "POST",
				data: {
					"jsonStr": jsonStr
				},
				success: function(result) {
					if (result.updateResult) {

						$('#Alert').alertClear();
						$('#Alert').alertSuccess('上传成功。');
					} else {
						$('#Alert').alertClear();
						$('#Alert').alertWarning('上传失败');
					}
				}
			});
		} else {
			$('#Alert').alertClear();
			$('#Alert').alertWarning('上传失败');
		};
	});

	var doSubmit = function(jsonData) {

		var jsonStr = encodeURI(JSON.stringify(jsonData));
		// Use Ajax to submit form data
		$.ajax({
			url: $form1.attr('action'),
			type: 'POST',
			data: {
				"jsonStr": jsonStr
			},
			success: function(result) {
				if (result.success) { //注册完成继续上传头像
					$('#Submit').modal({
						show: true,
						backdrop: true
					});
					$('#Submit').modal({
						show: true,
						backdrop: 'static'
					});
					$('#cancel').click(function() {
						location.href = basePath + 'f/Index';
					});
					$('#goOnUpload').click(function() {
						$('#step1,#step2').css('display', 'none');
						$('#step3').css('display', 'block');
						$('#Submit').modal('hide');
						$.ajax({
							url: basePath + 'admin/getUser',
							type: 'POST',
							data: {
								"userName": inputUserName
							},
							success: function(result) {
								if (null != result.user) {

									//将用户名定义为头像名并赋值隐藏域供，提交上传使用
									$("input[name='fileName']").val(result.user.id);

									// 初始化fileinput控件（第一次初始化）
									initFileInput("headPhoto", basePath + "common/uploadUserPhoto/", result.user.id);
								}

							}
						});
					});
					//				location.href = basePath + 'f/Index';
				} else {
					alertTip('注册失败，请正确填写表单');
				}
			}
		});

	}; //end submit function

	// Form validate
	$form1.bootstrapValidator({
		message: '不合法的输入值',
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			name: {
				message: '不合法的用户名',
				validators: {
					notEmpty: {
						message: '用户名不能为空'
					},
					stringLength: {
						min: 6,
						max: 15,
						message: '用户名必须为6-15个字符'
					},
					regexp: {
						regexp: /^[\u4e00-\u9fa5a-zA-Z0-9_@\.]+$/,
						message: '用户名只能包含字母数字下划线和@号'
					},
					remote: {
						url: basePath + '/pc/checkUserName',
						type: 'POST',
						message: '用户名已存在'
					}
				}
			},
			email: {
				validators: {
					notEmpty: {
						message: '邮箱不能为空'
					},
					regexp: {
						regexp: /\w+((-w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+/,
						message: '邮箱输入格式错误'
					},
					emailAddress: {
						message: '您输入的邮箱格式有误'
					}
				}
			},
			password: {
				validators: {
					notEmpty: {
						message: '密码不能为空'
					},
					stringLength: {
						min: 6,
						max: 15,
						message: '密码必须为6-15个字符'
					}
				}
			},
			confirm_password: {
				validators: {
					notEmpty: {
						message: '请再次输入密码'
					},
					identical: {
						field: 'password',
						message: '两次密码不一致'
					}
				}
			},
			tel: {
				message: '不合法的输入',
				validators: {
					regexp: {
						regexp: /^1[0-9]{10}$/,
						message: '手机号码格式错误'
					}

				}
			},
			answer1: {
				message: '不合法的输入',
				validators: {
					stringLength: {
						max: 15,
						message: '密保答案最多15个字符'
					},
					regexp: {
						regexp: /^[\u4e00-\u9fa5a-zA-Z0-9_@\.]+$/,
						message: '密保答案只能包含字母数字下划线和@号'
					}

				}
			},
			answer2: {
				message: '不合法的输入',
				validators: {
					stringLength: {
						max: 15,
						message: '密保答案最多15个字符'
					},
					regexp: {
						regexp: /^[\u4e00-\u9fa5a-zA-Z0-9_@\.]+$/,
						message: '密保答案只能包含字母数字下划线和@号'
					}

				}
			},
			reg_no: {
				message: '不合法的注册编号',
				validators: {
					notEmpty: {
						message: '注册编号不能为空'
					},
					remote: {
						url: basePath + '/pc/checkRegNO',
						type: 'POST',
						message: '注册编号不存在'
					}
				}
			}
		}
	}).on('success.form.bv', function(e) {
		//验证通过 阻止当前提交事件，自行实现，否则会跳转
		e.preventDefault();
		var inputMail = $("input[name='email']").val();
		var inputAccess = $("#access").find("option:selected").val();
		var inputCompanyName = $("#companyName").find("option:selected").val();
		var tel = $("input[name='tel']").val().trim();
		var regNO = $("input[name='reg_no']").val().trim();

		var jsonData = {
			'user_name': inputUserName,
			'password': MD5(inputPassWord),
			'email': inputMail,
			'question': question,
			'answer': answer,
			'tel': tel,
			'reg_no': regNO,
			'access': inputAccess,
		};
		doSubmit(jsonData);
	});

	// end validate


});