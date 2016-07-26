
/**
  调用方法：
  $('#id').alertWarning(msg);
  $('#id').alertSuccess(msg);
  $('#id').alertClear();
**/
(function($){
var obj = {
		//填充html
		alertWarning : function(obj,msg){
			obj.empty();
				//上一页
					obj.append('<div id="alertWarning" class="alert alert-warning">'+
					   		'<a href="#" class="close" data-dismiss="alert">'+
				      		'&times;'+
				   		'</a>'+
				   	'<strong>警告！</strong><span>'+msg+'</span></div>');
			},		
		
			alertSuccess : function(obj,msg){
				obj.empty();
				//上一页
					obj.append('<div id="alertSuccess" class="alert alert-success">'+
					   		'<a href="#" class="close" data-dismiss="alert">'+
				      		'&times;'+
				   		'</a>'+
				   	'<strong>提示！</strong><span>'+msg+'</span></div>');
				
			},
			alertClear : function(obj){
					obj.empty();
			}
	}
	
$.fn.alertWarning = function(msg){
	obj.alertWarning(this,msg);
}

$.fn.alertSuccess = function(msg){
	obj.alertSuccess(this,msg);
}

$.fn.alertClear = function(){
	obj.alertClear(this);
}

})(jQuery);