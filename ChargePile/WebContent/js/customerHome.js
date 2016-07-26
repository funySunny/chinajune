$(function(){
	var basePath = $('base').attr('href');

	$.ajax({
		url : basePath+'admin/getChargePointListByUserName',
		type : 'POST',
		data : {'userName':$('#userName').text()},
		success : function(data){
			if(undefined != data && undefined != data.chargePointList){
				$('#tatolChargePoint').text(data.chargePointList.length);
				
			}
		}
	});
	
	var treeViewData = [{
		  text: '一级菜单 1',
        href: '#parent1',
        tags: ['4'],
        nodes: [{
      	  text: '二级菜单 ',
            href: '#a',
            tags: ['0']
        }]},
          {
           text: '一级菜单 2',
           href: '#parent1',
           tags: ['4']  	  
          }      
                ];
	
	$('#treeview2').treeview({
        levels: 1,
        data: treeViewData
      });
	
});