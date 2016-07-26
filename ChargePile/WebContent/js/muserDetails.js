/**
 * 
 */
$(function(){
	var basePath = $('base').attr('href');
	var $userName = $("#name");
	var $pw = $("input[name='pw']"); 
	var $headPhoto = $('#headPhoto');
	var $form1 = $('#form1');
	var $headURL = $('#headURL').text().trim();
	var filePath = '';

	window.history.forward(-1);
     
	//初始化fileinput控件（第一次初始化）
	function initFileInput(ctrlName, uploadUrl, name) {    
	    var control = $('#' + ctrlName); 

	    control.fileinput({
	        language: 'zh', //设置语言
	        uploadUrl: uploadUrl+name, //上传的地址
	        allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀
	        showUpload: true, //是否显示上传按钮
	        showCaption: false,//是否显示标题
	        browseClass: "btn btn-info", //按钮样式             
	       //dropZoneEnabled: false,//是否显示拖拽区域
	        //minImageWidth: 50, //图片的最小宽度
	        //minImageHeight: 50,//图片的最小高度
	        maxImageWidth: 1000,//图片的最大宽度
	        maxImageHeight: 1000,//图片的最大高度
	        //maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
	        //minFileCount: 0,
	        maxFileCount: 1, //表示允许同时上传的最大文件个数
	        //enctype: 'multipart/form-data',
	        //validateInitialCount:true,
//	         msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
	        multiple : false,
	        previewFileIcon: "<i class='fa fa-folder-open'></i>", 
	        initialPreview: [ //预览图片的设置
	                          "<img src='" + $headURL + "' class='file-preview-image' alt='肖像图片' title='肖像图片'>",
	                      ],
	    });
};
	
	
	//初始化fileinput控件（第一次初始化）
	initFileInput("headPhoto", basePath + "common/uploadUserPhoto/",$userName.val());
	
	var doUpdate = function(jsonData){
		
		 var jsonStr  = encodeURI(JSON.stringify(jsonData));
		// Use Ajax to submit form data
		$.ajax({
				url : $form1.attr('action'), 
				type : 'POST',
				data : {"jsonStr" : jsonStr},
				success :function(result) {
			if(result && result.updateResult){
				alert('注册成功！！！');
			}else{
				alertTip('注册失败，请正确填写表单');
			}
		} 
		});
		
		};//end update function
		
		  //点击上传按钮、导入文件上传完成之后的事件
		$("#headPhoto").on("fileuploaded", function (event, data, previewId, index) {
			if(data.response.success == true){
				 filePath = data.response.filePath;//供注册下面使用
				 $(this).fileinput('refresh');
				 $('#Alert').alertClear();
				 $('#Alert').alertSuccess('上传成功。');
			}else{
				$('#Alert').alertClear();
				 $('#Alert').alertWarning('上传失败');
			};
		});
    
 // Form validate
    $form1.bootstrapValidator({
		message : '不合法的输入值',
		submitButtons : '#submit1',
//		feedbackIcons : {
//			valid : 'glyphicon glyphicon-ok',
//			invalid : 'glyphicon glyphicon-remove',
//			validating : 'glyphicon glyphicon-refresh'
//		},
		fields : {
			pw : {
				container : '#pwMessage',
				validators : {
					notEmpty : {
						message : '密码不能为空'
					},
					stringLength : {
						min : 6,
						max : 15,
						message : '密码必须为6-15个字符'
					},
					remote : {
						url : basePath + '/pc/checkpw',
						type : 'POST',
						data: function(validator) {
                            return {
                            	name: $userName.val()
                            };
                        },
						message : '密码错误'
					}
				}
			},
			rpw : {
				container: '#rpwMessage',
				validators : {
					notEmpty : {
						message : '请再次输入密码'
					},
					identical : {
						field : 'pw',
						message : '两次密码不一致'
					}
				}
			},
			email : {
				container: '#emailMessage',
				validators : {
					notEmpty : {
						message : '邮箱不能为空'
					},
					emailAddress : {
						message : '您输入的邮箱格式有误'
					}
				}
			}
		}
	});
    
    $('#form1 input').bind('keyup blur',function(){
    	var $divFlag = $form1.children('div').children('div');
    	var bootstrapValidator = $form1.data('bootstrapValidator');
    	bootstrapValidator.validateField('email');
    	if($divFlag.eq(1).attr('class') == 'form-group has-success'
			&& $divFlag.eq(2).attr('class') == 'form-group has-success'
				&& $divFlag.eq(3).attr('class') == 'form-group has-success'
		){
    		$('#submit1').removeAttr('disabled');
    	}else{
    		$('#submit1').attr('disabled','disabled');
    	}
    });
    
    $('#submit1').on('click', function(e) {
		var inputMail = $("input[name='email']").val();
		var inputGender = $("input[name='optionsSex']").find("option:selected").val();
		
		if(undefined == filePath || filePath == ''){
		 var jsonData = {
				 	'userName' : $userName.val(),
					'password' : MD5($pw.val()),
					'email' : inputMail,
					'access' : inputAccess,
		 };
		}else{
			var jsonData = {
				 	'userName' : $userName.val(),
					'password' : MD5($pw.val()),
					'email' : inputMail,
					'headPortrait' : filePath,
					'access' : inputAccess,
		 };
		}
		doUpdate(jsonData);
	});
    
    var telT = $('input[type="number"]').val().parseInt();
    
    $('input[type="number"]').val(telT);

});