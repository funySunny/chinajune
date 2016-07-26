$(function(){
	var basePath = $('base').attr('href');
	
	$('#toSaler').click(function(){
		window.open(basePath+ 'pages/salerHome.jsp');
	});
	
//获取充电桩数量	
	$('#CPlineChart').highcharts({
		chart: { 
        	zoomType: 'xy' ,  //X、Y轴均可放大 
        	type: 'line',//柱状图  
			},                                                                  
	        title: {                                                          
	            text: '充电桩折线图'                                     
	        },  
			//x轴
	        xAxis: {
	         categories: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'], //x轴标签名称 
	            gridLineWidth: 1, //设置网格宽度为1 
	            lineWidth: 2,  //基线宽度 
	        },
	        yAxis: {  //y轴 
	            title: {text: '电压(V)'}, //标题 
	            lineWidth: 2 //基线宽度 
	        }, 
	         plotOptions:{ //设置数据点 
	            line:{ 
	                dataLabels:{ 
	                    // enabled:true  //在数据点上显示对应的数据值 
	                }, 
	                // enableMouseTracking: false //取消鼠标滑向触发提示框 
	            } 
	        }, 
	        legend: {  //图例 
	            layout: 'horizontal',  //图例显示的样式：水平（horizontal）/垂直（vertical） 
	            backgroundColor: '#ffc', //图例背景色 
	            align: 'left',  //图例水平对齐方式 
	            verticalAlign: 'top',  //图例垂直对齐方式 
	            x: 700,  //相对X位移 
	            y: -10,   //相对Y位移 
	            floating: true, //设置可浮动 
	            shadow: true  //设置阴影 
	        }, 
	         series: [
	        { //数据列
	            name: '交流充电桩', 
	            data: [12.3, 15.4, 17.7, 22.9, 23.6, 27.2, 35.8, 32.1, 24.2, 21.7, 10.3, 9.6] 
	        },{ 
	            name: '直流充电桩', 
	            data: [14.3, 16.4, 13.7, 12.9, 26.6, 33.2, 36.8, 38.1, 22.2, 22.7, 21.3, 12.6] 
	        }
	        ] 
	});
	
});