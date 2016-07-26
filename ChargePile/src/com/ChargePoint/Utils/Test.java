package com.ChargePoint.Utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.cache.Cache;

import com.ChargePoint.bean.ChargePoint;
import com.ChargePoint.bean.ChargePointLive;
import com.ChargePoint.bean.ChargePointLive2;
import com.ChargePoint.bean.ChargePointStation;
import com.ChargePoint.bean.ChargeRecords2;
import com.ChargePoint.bean.Company;
import com.ChargePoint.bean.Feedbacks;
import com.ChargePoint.bean.MobileUser;
import com.ChargePoint.bean.Sale;
import com.ChargePoint.bean.TempAppointment;
import com.ChargePoint.bean.MobileUser;
import com.ChargePoint.services.ChargePointLiveService;
import com.ChargePoint.services.ChargePointService;
import com.ChargePoint.services.ChargePointStationService;
import com.ChargePoint.services.ChargeRecordsService;
import com.ChargePoint.services.CommonService;
import com.ChargePoint.services.CompanyService;
import com.ChargePoint.services.FeedbacksService;
import com.ChargePoint.services.MobileUserService;
import com.ChargePoint.services.SaleService;
import com.ChargePoint.services.TempAppointmentService;
import com.ChargePoint.services.TradeService;
import com.ChargePoint.services.PCUserService;

public class Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
//		Thread th = new Thread(new Runnable(){
//			@Override
//			public void run() {
//				System.out.println("1取: "+TradeService.moneyOut("userNaem", "100")+"1剩: "+TradeService.getMoney("userNaem"));
//			}
//			
//		});
//		Thread th1 = new Thread(new Runnable(){
//			@Override
//			public void run() {
//				System.out.println("2取: "+TradeService.moneyOut("userNaem", "100")+"2剩: "+TradeService.getMoney("userNaem"));
//			}
//			
//		});
//		Thread th2 = new Thread(new Runnable(){
//			@Override
//			public void run() {
//				System.out.println("3取: "+TradeService.moneyOut("userNaem", "100")+"3剩: "+TradeService.getMoney("userNaem"));
//			}
//			
//		});
//		Thread th3 = new Thread(new Runnable(){
//			@Override
//			public void run() {
//				System.out.println("4取: "+TradeService.moneyOut("userNaem", "100")+"4剩: "+TradeService.getMoney("userNaem"));
//			}
//			
//		});
//		th.start();
//		th1.start();
//		th2.start();
//		th3.start();
//		Sale sale = new Sale();
//		sale.setC_p_id("c_p_i_dsyh");
//		sale.setLocation("sjdl");
//		System.out.println(SaleService.addSale(sale));
//	}

//		System.out.println(ChargePointService.getHomeCPTable(""));
		
//		Feedbacks fd = new Feedbacks();
//		fd.setContent("cnotent");
//		fd.setUser_name("user_name");
//		fd.setVersion("versio23");
//		System.out.println(FeedbacksService.addFeedbacks(fd));
//		System.out.println(FeedbacksService.getFeedbacksList(fd));
//		System.out.println(FeedbacksService.updateFeedbacks(fd));
		
//		ChargePointStation cps = new ChargePointStation();
//		cps.setC_p_id("cp1454515445");
//		cps.setLocation("location");
//		cps.setName("汉语就");
//		cps.setPicture("picture");
//		cps.setPlace("place");
//		System.out.println(ChargePointStationService.updateChargePointStation(cps));
		TempAppointment tempAppointment = new TempAppointment();
		tempAppointment.setC_p_id("123456789");
		tempAppointment.setUser_id("14");
		TempAppointmentService.addTempAppointment(tempAppointment);
	}
}
