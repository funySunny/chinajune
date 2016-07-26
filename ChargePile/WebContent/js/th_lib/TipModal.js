/*
 模态框组件
 loadingTip(tips);
 alertTip(tips);
作者吕
*/

	var loadingTip = function(tips){
		$('body').remove('#LOADINGTEMPMODAL');
		$('body').append(
				'<div class="modal fade" id="LOADINGTEMPMODAL" tabindex="-1" role="dialog"' 
		  +' aria-labelledby="LOADINGTEMPMODALLabel" aria-hidden="true">'
		  +' <div class="modal-dialog">'
		   + '  <div class="modal-content">'
		        +' <div class="modal-header">'
		          +'  <button type="button" class="close"' 
		              +' data-dismiss="modal" aria-hidden="true"> &times;'
		          +'  </button>'
		           +' <h4 class="modal-title" id="LOADINGTEMPMODALLabel">'
		           +'（按下Esc可快速关闭）'
		           +' </h4> </div>'
		         +'<div class="modal-body"><p class="text-center">'
		         +	'<i class="fa fa-spinner fa-pulse"></i>&nbsp;'
		         +tips
		         +'</p></div></div>'
		         +'</div></div><!-- /.modal-content --></div><!-- /.modal --></div>'
		            );
		$('#LOADINGTEMPMODAL').modal();//背景
	}
	
	var alertTip = function(tips){
		$('body').remove('#ALERTTEMPMODAL');
		$('body').append(
				'<div class="modal fade" id="ALERTTEMPMODAL" tabindex="-1" role="dialog"' 
		  +' aria-labelledby="ALERTTEMPMODALLabel" aria-hidden="true">'
		  +' <div class="modal-dialog">'
		   + '  <div class="modal-content">'
		        +' <div class="modal-header">'
		          +'  <button type="button" class="close"' 
		              +' data-dismiss="modal" aria-hidden="true"> &times;'
		          +'  </button>'
		           +' <h4 class="modal-title" id="ALERTTEMPMODALLabel">'
		           +'（按下Esc可快速关闭）'
		           +' </h4> </div>'
		         +'<div class="modal-body"><p class="text-center">'
		         +	'<i class="fa fa-info"></i>&nbsp;'
		         +tips
		         +'</p></div></div>'
		         +'</div></div><!-- /.modal-content --></div><!-- /.modal --></div>'
		            );
		$('#ALERTTEMPMODAL').modal({backdrop:'static'});//背景
	}
  