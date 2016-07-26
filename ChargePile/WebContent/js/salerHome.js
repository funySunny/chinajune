$(function(){
	var basePath = $('base').attr('href');
	var $form1 = $('#form1');
	var $lng = $('#lng');
	var $lat = $('#lat');
	
	 $.getJSON(basePath+'/json/sql_areas.json',function(data){

	        /**重定义数据结构**/
	        /**
	         * id 键,name 名字,level 层级,parentId 父级
	         */
	        for (var i = 0; i < data.length; i++) {
	            var area = {id:data[i].id,name:data[i].cname,level:data[i].level,parentId:data[i].upid};
	            data[i] = area;
	        }

	        $('.bs-chinese-region').chineseRegion('source',data);/*导入数据并实例化*/
	        
	    });
	 
	 $.ajax({
			url : 'company/getCompanyList',
			type : "POST",
			success : function(data){
			if(data && undefined != data.companyList){
				$('#appendC').empty();
				for(var i = 0; i < data.companyList.length; i++){
					$('#companyName').append('<option id="appendC">'+data.companyList[i].company_name+'</option>');
				}
				}
			}
				});
	 
	 $('#dateTimeSelect').datetimepicker({
	        language:  'zh-CN',
	        weekStart: 1,
	        todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			minView: 0,
			maxView: 1,
			forceParse: 0
	    });
	 
	 $('button[id="submit"]').click(function(){
		 var time = $('#dtp_input').val();
		 var place = '';
		 var privance = $('#address').val();
		 var details = $('#addressAddon').val();
		 if(details.indexOf('市') > 0){//包含省、市
			 place = details;
		 }else{
			 place = privance + details;
		 }
		 var timeStr = time.replace('十二月','12').replace('十一月','11').replace('十月','10').replace('九月','09').replace('八月','08').replace('七月','07').replace('六月','06').replace('五月','05').replace('四月','04').replace('三月','03').replace('二月','02').replace('一月','01');
		 var json = {'c_p_id':$('#c_p_id').val(),'location':$lng.text().trim()+'$'+$lat.text().trim(),'place':place,'company_name':$('#companyName').find('option:selected').text(),'saled_time':timeStr,'no':$('#inner_no').val()};
		 var jsonStr = encodeURI(JSON.stringify(json));
		 $.post(basePath+'/sale/addSale',{'jsonStr':jsonStr}, function(data){
			 if(undefined != data && undefined != data.addFlag){
				 if(data.addFlag){
					 $('#Alert').alertClear();
					 $('#Alert').alertSuccess('添加成功。');
				 }else{
					 $('#Alert').alertClear();
					 $('#Alert').alertWarning('添加数据失败，请重新检查各项。');					 
				 }
			 }else{
				 $('#Alert').alertClear();
				 $('#Alert').alertWarning('您的网络连接有问题。');
			 }
		 });
	 });

//    百度地图
    
	var map = new BMap.Map("maps");
	map.centerAndZoom("北京",12);                   // 初始化地图,设置城市和地图级别。

	$('.tab-pane').click(function(){
		map.centerAndZoom($('#address').val(),12);                   // 初始化地图,设置城市和地图级别。
	});
	
	var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
		{"input" : "addressAddon"
		,"location" : map
	});
	
	$("input#addressAddon").bind('keyup',function(){
		if(ac.getResults().getNumPois() == 0){
//			$lng.text('');
//			$lat.text('');
			$('#address_help').attr('class','text-danger');
			$('button[id="submit"]').attr('disabled',true);
		}else{
			$('#address_help').attr('class','text-primary');
			$('button[id="submit"]').removeAttr('disabled');
		}
	});
	
	ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
	var str = "";
		var _value = e.fromitem.value;
		var value = "";
		if (e.fromitem.index > -1) {
			value = _value.province +  _value.city +  _value.district + _value.street + _value.business;
		}    
		str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
		
		value = "";
		if (e.toitem.index > -1) {
			_value = e.toitem.value;
			value = _value.province +  _value.city +  _value.district + _value.street + _value.business;
		}    
		str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
		$("#addressAddon").html = str;
	});

	var myValue;
	ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
	var _value = e.item.value;
		myValue = _value.province +  _value.city +  _value.district + _value.street + _value.business;
		$("#addressAddon").html ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
		$('#address_help').attr('class','text-primary');
		$('button[id="submit"]').removeAttr('disabled');
		setPlace();
	});
	
	function setPlace(){
		map.clearOverlays();    //清除地图上所有覆盖物
		function myFun(results){
			var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
			map.centerAndZoom(pp, 18);
			var marker = new BMap.Marker(pp);// 创建标注
			map.addOverlay(marker);             // 将标注添加到地图中
			marker.enableDragging();	// 覆盖物可拖拽
			
			var geoc = new BMap.Geocoder();
			
			//拖拽结束事件
			marker.addEventListener("dragend", function(e){
			//获取覆盖物位置
			var o_Point_now =  marker.getPosition();
			var lng = o_Point_now.lng;
			var lat = o_Point_now.lat;
			var pt = e.point;
			//e.point.lng 地理经度。
			// e.point.lat 地理纬度。
			//alert(e.point.lng + "---, " + e.point.lat);
			geoc.getLocation(pt, function(rs){
				var addComp = rs.addressComponents;
//				alert('经度:'+pt.lng+' '+'维度:'+pt.lat+addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
				$("#addressAddon").val(addComp.province + addComp.city + addComp.district +  addComp.street + addComp.streetNumber);
				$('#address_help').attr('class','text-primary');
				$('button[id="submit"]').removeAttr('disabled');
				$lng.text(pt.lng);
				$lat.text(pt.lat);
			});
			});
			
			$lng.text(pp.lng);
			$lat.text(pp.lat);
		}
		var local = new BMap.LocalSearch(map, { //智能搜索
		  onSearchComplete: myFun,
//		  renderOptions:{map: map}
		});
		 
		local.search(myValue);
		
	}
	
	/*----------------------------------------------------------------------------------------------------------------*/
	
	var $cN = $('#cN');
	var $cA = $('#cA');
	var $tel = $('#tel');
	var $regNO = $('#regNO');
	
	$('#cN,#regNO').keyup(function(){
		if(this.value != undefined && this.value != ''){
			$(this).parent('div').attr('class','form-group');
		}else{
			$(this).parent('div').attr('class','form-group has-feedback has-error');
		}
		
	});
	
	$form1.find('input').change(function(){
		if($('#cN').val() != undefined && $('#cN').val() != '' && $('#regNO').val() != undefined && $('#regNO').val() != ''){
			$('button[id="submit1"]').removeAttr('disabled');
		}else{
			$('button[id="submit1"]').attr('disabled',true);
		}
	});

	$('#submit1').click(function(){
		var jsonData = {
				company_name : $cN.val(),
				reg_no : $regNO.val(),
				is_reg : $('input[name="radiosinline"]:checked').val(),
				company_addr : $cA.val(),
				tel : $tel.val()
		};
		var jsonStr = encodeURI(JSON.stringify(jsonData));
		 $.post(basePath+'/company/addCompany',{'jsonStr':jsonStr}, function(data){
			 if(undefined != data && undefined != data.addFlag){
				 if(data.addFlag){
					 $('#AlertTip').alertClear();
					 $('#AlertTip').alertSuccess('添加成功。');
				 }else{
					 $('#AlertTip').alertClear();
					 $('#AlertTip').alertWarning('添加数据失败，请重新检查各项。');					 
				 }
			 }else{
				 $('#AlertTip').alertClear();
				 $('#AlertTip').alertWarning('您的网络连接有问题。');
			 }
		 });
	});
	
	
});