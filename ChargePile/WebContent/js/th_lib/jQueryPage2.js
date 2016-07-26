//分页插件
/**
  调用方法：
    $(".tcdPageCode").createPage({
        pageCount:10,
        current:1,
        backFn:function(p){
            //单击回调方法，p是当前页码
        }
    });
    pageCount：总页数
    current：当前页
**/
(function($){
	var ms = {
		init:function(obj,args){
			return (function(){
				ms.fillHtml(obj,args);
				ms.bindEvent(obj,args);
			})();
		},
		//填充html
		fillHtml:function(obj,args){
			return (function(){
				obj.empty();
				//上一页
				if(args.current > 1){
					obj.append('<li id="prevPage"><a href="javascript:;">&laquo;</a></li>');
				}else{
					obj.append('<li class="disabled"><a>&laquo;</a></li>');
				}
				//中间页码
				if(args.current != 1 && args.current >= 4 && args.pageCount != 4){
					obj.children().attr('class','');
					obj.append('<li id="jumpNumber"><a href="javascript:;">'+1+'</a></li>');
				}
				if(args.current-2 > 2 && args.current <= args.pageCount && args.pageCount > 5){
					obj.append('<li><a>...</a></li>');
				}
				var start = args.current -2,end = args.current+2;
				if((start > 1 && args.current < 4)||args.current == 1){
					end++;
				}
				if(args.current > args.pageCount-4 && args.current >= args.pageCount){
					start--;
				}
				for (;start <= end; start++) {
					if(start <= args.pageCount && start >= 1){
						if(start != args.current){
							obj.append('<li id="jumpNumber"><a href="javascript:;">'+ start +'</a><li>');
						}else{
							obj.append('<li class="active"><a class="current">'+ start +'</a></li>');
						}
					}
				}
				if(args.current + 2 < args.pageCount - 1 && args.current >= 1 && args.pageCount > 5){
					obj.append('<li><a>...</a></li>');
				}
				if(args.current != args.pageCount && args.current < args.pageCount -2  && args.pageCount != 4){
					obj.append('<li id="jumpNumber"><a href="javascript:;">'+args.pageCount+'</a></li>');
				}
				//下一页
				if(args.current < args.pageCount){
					obj.append('<li id="nextPage"><a href="javascript:;">&raquo;</a></li>');
				}else{
					obj.remove('#nextPage');
					obj.append('<li class="disabled"><a>&raquo;</a></li>');
				}
			})();
		},
		//绑定事件
		bindEvent:function(obj,args){
			return (function(){
				obj.on("click","li#jumpNumber",function(){//jump
					var current = parseInt($(this).children('a').text());
					ms.fillHtml(obj,{"current":current,"pageCount":args.pageCount});
					if(typeof(args.backFn)=="function"){
						args.backFn(current);
					}
				});
				//上一页
				obj.on("click","li#prevPage",function(){
					var current = parseInt(obj.children().children("a.current").text());
					ms.fillHtml(obj,{"current":current-1,"pageCount":args.pageCount});
					if(typeof(args.backFn)=="function"){
						args.backFn(current-1);
					}
				});
				//下一页
				obj.on("click","li#nextPage",function(){
					var current = parseInt(obj.children().children("a.current").text());
					ms.fillHtml(obj,{"current":current+1,"pageCount":args.pageCount});
					if(typeof(args.backFn)=="function"){
						args.backFn(current+1);
					}
				});
			})();
		}
	}
	$.fn.createPage = function(options){
		var args = $.extend({
			pageCount : 10,
			current : 1,
			backFn : function(){}
		},options);
		ms.init(this,args);
	}
})(jQuery);