/**
 * 自动登录js实现
 */
$(function(){
	var basePath = $('base').attr('href');
	var $userName = $("input[name='userName']");
	var $pw = $("input[name='pw']");
	var $hiddenStr = $('#hiddenStr').text();
	var clearCookie = function(){
		$.post(basePath+'login/clearCookie');
	};
	
	var errorCode = $("#errorCode").val();
	
	if("" != $hiddenStr){//记住密码
		if(!errorCode){//记住密码且无错误信息
		var s =  $hiddenStr.split('-');
		$userName.val(s[0]);
		$pw.val(s[1]);
		$('#autoLogin').attr('checked','checked');
		}
	}else{
		$('#autoLogin').attr('checked',false);
		clearCookie();
	}
	
	$('#autoLogin').click(function(){
		clearCookie();
	});
	
	$("button[class$='btn-primary']").click(function(){
		var pw = $pw.val();
		if(pw.length < 32){
			$("input[name='pw']").val(MD5(pw));
		}
		$('form').submit();
	});
	
    $('input, textarea').placeholder();
});