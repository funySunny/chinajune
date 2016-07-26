package com.ChargePoint.listener;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ChargePoint.Utils.TimeFormatUtil;
import com.ChargePoint.bean.ChargePoint;
import com.ChargePoint.bean.TempAppointment;
import com.ChargePoint.services.ChargePointService;
import com.ChargePoint.services.TempAppointmentService;

public class TempAppointmentListener implements ServletContextListener{

	private Timer timer = null;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		//监听器销毁时执行		
		TempAppointmentService.deleteTempAppointment(null);
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		//监听器销毁时执行-----启动时检测临时操作表
		final Runnable run = new Runnable() {
			
			@Override
			public void run() {
//	    	timer = new Timer(true);
//				//调用Timer1,Timer2，0表示任务无延迟，5*1000表示每隔5秒执行任务，60*60*1000表示一个小时。  
//    	    timer.schedule(new TimerController(),0,10*1000);
			 
			}
		}; 
		Thread thread = new Thread(run);
		thread.start();
	}
	
	/**
	 * @author Lv
	 *	定时器--一个小时执行一次
	 */
	private class TimerController extends TimerTask {

		@Override
		public void run() {
//			查询所有已预约数据
//			List<TempAppointment> tempAppointmentList = TempAppointmentService.getTempAppointmentList(null);
//			if(0 != tempAppointmentList.size() && null != tempAppointmentList){
				//删除tempAppointment已预约仍未操作数据
//			for(TempAppointment item : tempAppointmentList){
//				预约失效,删除缓存数据
//				if(TimeFormatUtil.compare2Now(item.getEnd_time()) == 1){
//					boolean res = TempAppointmentService.deleteTempAppointment(item);
//			System.out.println("del :"+res);
//					String cpid = item.getC_p_id();
//					ChargePoint chargePoint = new ChargePoint();
//					chargePoint.setC_p_id(cpid);
////					更改为已空闲状态
//					chargePoint.setIs_free("0");
//					ChargePointService.updateChargePoint(chargePoint);
//				}
//				
//			}	
//			}
		}
		
	}

}
