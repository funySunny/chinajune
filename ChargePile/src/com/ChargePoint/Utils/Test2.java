package com.ChargePoint.Utils;

import java.text.SimpleDateFormat;

import com.ChargePoint.bean.AddHeart;
import com.ChargePoint.bean.ChargeMoneyRecords2;
import com.ChargePoint.bean.ChargePoint;
import com.ChargePoint.bean.ChargePointStation;
import com.ChargePoint.bean.ChargeRecords;
import com.ChargePoint.bean.ChargeRecords2;
import com.ChargePoint.bean.Company;
import com.ChargePoint.bean.Feedbacks;
import com.ChargePoint.bean.MobileUser;
import com.ChargePoint.bean.Operate2;
import com.ChargePoint.bean.OperateResults;
import com.ChargePoint.bean.OperateResults2;
import com.ChargePoint.bean.PCUser;
import com.ChargePoint.bean.Review;
import com.ChargePoint.bean.TempAppointment;
import com.ChargePoint.bean.TempCharge;
import com.ChargePoint.bean.TradeRecords2;
import com.ChargePoint.bean.Versions;
import com.ChargePoint.bean.WriteBack;
import com.ChargePoint.services.AddHeartService;
import com.ChargePoint.services.ChargeMoneyRecordsService;
import com.ChargePoint.services.ChargePointService;
import com.ChargePoint.services.ChargePointStationService;
import com.ChargePoint.services.ChargeRecordsService;
import com.ChargePoint.services.CommonService;
import com.ChargePoint.services.CompanyService;
import com.ChargePoint.services.FeedbacksService;
import com.ChargePoint.services.MobileUserService;
import com.ChargePoint.services.OperateResultsService;
import com.ChargePoint.services.OperateService;
import com.ChargePoint.services.PCUserService;
import com.ChargePoint.services.ReviewService;
import com.ChargePoint.services.TempAppointmentService;
import com.ChargePoint.services.TempChargeService;
import com.ChargePoint.services.TradeRecordsService;
import com.ChargePoint.services.TradeService;
import com.ChargePoint.services.VersionsService;
import com.ChargePoint.services.WriteBackService;

public class Test2 {

		public static void main(String[] args) {
			/*建表测试*/
//			System.out.println(CommonService.createChargeRecord(105205));
//			System.out.println(CommonService.createChargeMoneyRecord(105205));
//			System.out.println(CommonService.createChargePointACLiveTable("105205"));
//			System.out.println(CommonService.createChargePointLiveTable("105205"));
//			System.out.println(CommonService.createChargeMoneyRecord(105205));
//			System.out.println(CommonService.createOperation(105205));
//			System.out.println(CommonService.createOperationResults(105205));
//			System.out.println(CommonService.createTradeRecord(105205));
			/*建表测试*/
			
			/*充值记录测试*/
//			ChargeMoneyRecords2 chargeMoneyRecords = new ChargeMoneyRecords2();
//			chargeMoneyRecords.setTable_name("105205");
//			chargeMoneyRecords.setPass(1220f);
//			chargeMoneyRecords.setId(1);
//			chargeMoneyRecords.setCard_id("card_id-0");
//			chargeMoneyRecords.setLeft_money("left_money");
//			chargeMoneyRecords.setPlace("place");
//			chargeMoneyRecords.setTime(TimeFormatUtil.getFormattedNow());
//			System.out.println(ChargeMoneyRecordsService.addChargeMoneyRecords(chargeMoneyRecords));
//			System.out.println(ChargeMoneyRecordsService.getChargeMoneyRecordsList(chargeMoneyRecords));
//			System.out.println(ChargeMoneyRecordsService.updatechargeMoneyRecords(chargeMoneyRecords));
//			System.out.println(ChargeMoneyRecordsService.deletechargeMoneyRecords(chargeMoneyRecords));
//			System.out.println(ChargeMoneyRecordsService.getChargeMoneyRecordsByPage("charge_money_records_105205", null,null,0, 10,null,null));
			/*充值记录测试*/
			
			/*充电记录测试*/
//			ChargeRecords2 chargeRecords = new ChargeRecords2();
//			chargeRecords.setTable_name("105205");
//			chargeRecords.setUser_name("7");
//			chargeRecords.setC_p_id("123456789");
//			chargeRecords.setDegree(15f);
//			chargeRecords.setMoney(0.12f);
//			chargeRecords.setPlace("place");
//			System.out.println(ChargeRecordsService.addChargeRecords(chargeRecords));			
//			System.out.println(ChargeRecordsService.getChargeRecords(chargeRecords));			
//			System.out.println(ChargeRecordsService.getChargeRecordsByPage("charge_records_105205", 0, 10, null, null, null,null));			
//			System.out.println(ChargeRecordsService.searchChargeRecords(105205, null));			
//			System.out.println(ChargeRecordsService.deleteChargeRecords(chargeRecords));			
			
			/*充电记录测试*/
			
			/*交易记录测试*/
//			TradeRecords2 trades = new TradeRecords2();
//			trades.setTable_name("105205");
//			trades.setTrade_status("0");
//			trades.setMoney("money");
//			trades.setTrade_no("trade_no");
//			System.out.println(TradeRecordsService.addTradeRecords(trades));
//			System.out.println(TradeRecordsService.getTradeRecordsByPage("trade_records_105205",0, 10, null, null, null, null));
//			System.out.println(TradeRecordsService.getTradeRecordsList(trades));
//			System.out.println(TradeRecordsService.deleteTradeRecords(trades));
//			System.out.println(TradeRecordsService.updateTradeRecords(trades));
			/*交易记录测试*/
			
			/*公司记录测试*/
//			Company com = new Company();
//			com.setName("company_name1");
//			com.setAddress("深证市茶光路中集成产业园1089号");
//			com.setReg_no("reg_no+");
//			com.setTel("12345678910");
//			com.setAc1_count(1);
//			com.setAc2_count(2);
//			com.setAdmin_count(3);
//			com.setC_p_count(6);
//			com.setDc1_count(6);
//			com.setDc2_count(9);
//			com.setProfit("profit");
//			System.out.println(CompanyService.addCompany(com));
//			System.out.println(CompanyService.deleteCompany("company_name"));
//			System.out.println(CompanyService.updateCompany(com));
//			System.out.println(CompanyService.getCompany("company_nam"));
			/*公司记录测试*/

			/*充电站测试*/
//			ChargePointStation cps = new ChargePointStation();
//			cps.setName("深圳市集成电路设计应用产业园");
//			cps.setAc1_count(20);
//			cps.setAc2_count(0);
//			cps.setDc1_count(0);
//			cps.setDc2_count(10);
//			cps.setC_p_count(8);
//			cps.setEnd_time("end_time");
//			cps.setLocation("location,4545");
//			cps.setOther_introduce("other_introduce");
//			cps.setParking_fee("parking_fee");
//			cps.setPicture("picture");
//			cps.setPlace("place");
//			cps.setService_fee("service_fee");
//			System.out.println(ChargePointStationService.addChargePointStation(cps));
//			System.out.println(ChargePointStationService.updateChargePointStation(cps));
//			System.out.println(ChargePointStationService.deleteChargePointStation(cps));
//			System.out.println(ChargePointStationService.getChargePointStation(2));
			
			/*充电站测试*/

			/*充电桩测试*/
//			ChargePoint c = new ChargePoint();
//			c.setC_p_id("123456789");
//			c.setC_p_type("0");
//			c.setDtu_id("dtu_id");
//			c.setStation_id("2");
//			c.setE_price("0.1215");
//			c.setI_max_charge_out("12121");
//			c.setI_min_charge_out("i_min_charge_out");
//			c.setV_max_charge_out("v_max_charge_out");
//			c.setW("w");
//			c.setIs_free("1");
//			System.out.println(ChargePointService.addChargePoint(c));
//			System.out.println(ChargePointService.getChargePoint("1234567"));
//			System.out.println(ChargePointService.getChargePointByPage(0, 10, null, null, null , null));
//			System.out.println(ChargePointService.getChargePointList(null));
//			System.out.println(ChargePointService.getChargePointListByUserName("33333333"));
//			System.out.println(ChargePointService.deleteChargePoint(c));
//			System.out.println(ChargePointService.updateChargePoint(c));
//			System.out.println(ChargePointService.getCPMap());
//			System.out.println(ChargePointService.getHomeCPTable(0, 10, null, null, null, null));
			/*充电桩测试*/
			
			/*操作测试*/
//			Operate2 op = new Operate2();
//			op.setCharge_method("0");
//			op.setTable_name("105205");
//			op.setCharger_no(1);
//			System.out.println(OperateService.addOperate(op));
//			System.out.println(OperateService.getOperateList(op));
//			System.out.println(OperateService.getOperateByPage("operation_105205" ,0, 10 , null, null));
//			System.out.println(OperateService.deleteoperate(op));
//			System.out.println(OperateService.updateoperate(op));
			
			/*操作测试*/

//			System.out.println(CommonService.dynamicSql("alter table mobile_user auto_increment = 10000"));
			
			/*操作返回测试*/
//			OperateResults2 result = new OperateResults2(); 
//			result.setTable_name("105205");
//			result.setC_p_id("123456789");
//			result.setFailure_case("5");
//			result.setIs_send("Y");
//			result.setOperation_result("1");
//			result.setResult_details("0");
//			result.setUser_id("4");
//			result.setId(2);
//			System.out.println(OperateResultsService.addOperateResults(result));
//			System.out.println(OperateResultsService.getOperateResultsList(result));
//			System.out.println(OperateResultsService.getOperateResultsByPage("operation_105205", 0, 10, null, null));
//			System.out.println(OperateResultsService.deleteoperate(result));
//			System.out.println(OperateResultsService.updateoperate(result));
			/*操作返回测试*/
			
			/*操作测试*/
			
//			System.out.println(CommonService.getTableNames("charge_point_live_"));
			
			
			/*版本测试*/
//			Versions versions = new Versions();
//			versions.setSize(2.67d);
//			versions.setVersion_no("1.3.0");
//			System.out.println(VersionsService.addVersions(versions));
//			System.out.println(VersionsService.checkNewVersions("versionNO"));
//			System.out.println(VersionsService.updateVersions(versions));
//			System.out.println(VersionsService.getVersionsByPage(0, 10, null, null));
//			System.out.println(VersionsService.getVersionsList(versions));
//			System.out.println(VersionsService.deleteVersions(versions));
			
			/*版本测试*/
			
			/*充电缓存测试*/
//			TempCharge temO = new TempCharge();
//			temO.setUser_id("2");
//			temO.setC_p_id("123456789");
//			temO.setCharger_no(1);
//			System.out.println(TempChargeService.addTempCharge(temO));
//			System.out.println(TempChargeService.updateTempCharge(temO));
//			System.out.println(TempChargeService.getTempChargeByPage(0, 10));
//			System.out.println(TempChargeService.getTempChargeList(temO));
//			System.out.println(TempChargeService.deleteTempCharge(temO));
			/*充电缓存测试*/
			
			/*充电缓存测试*/
//			TempAppointment tempAppointment = new TempAppointment();
//			tempAppointment.setC_p_id("123456789");
//			tempAppointment.setUser_id("14");
//			System.out.println(TempAppointmentService.addTempAppointment(tempAppointment));
//			System.out.println(TempAppointmentService.getTempAppointmentByPage(0, 10));
//			System.out.println(TempAppointmentService.getTempAppointmentList(tempAppointment));
//			System.out.println(TempAppointmentService.deleteTempAppointment(tempAppointment));
			/*充电缓存测试*/

			/*反馈测试*/
//			Feedbacks feedBack = new Feedbacks();
//			feedBack.setUser_name("3333345");
//			feedBack.setContent("ontent");
//			feedBack.setVersion("12212");
//			System.out.println(FeedbacksService.addFeedbacks(feedBack));
//			System.out.println(FeedbacksService.updateFeedbacks(feedBack));
//			System.out.println(FeedbacksService.getFeedbacksByPage(0, 10, null, null));
//			System.out.println(FeedbacksService.getFeedbacksList(feedBack));
//			System.out.println(FeedbacksService.deleteFeedbacks(feedBack));
			/*反馈测试*/
			
			/*手机用户测试*/
//			MobileUser mU = new MobileUser();
//			mU.setCar_frame_no("car_frame_no");
//			mU.setCar_type("car_type");
//			mU.setEngine_no("engine_no");
//			mU.setHead_portrait("head_portrait");
//			mU.setIdentity("154545454484451454");
//			mU.setInterface_type("0");
//			mU.setLicense("license");
//			mU.setPlate_no("plate_no");
//			mU.setReg_time(TimeFormatUtil.getFormattedNow());
//			mU.setTel("12152416464");
//			mU.setTrue_name("true_nam");
//			mU.setUser_name("天气变了呵呵");
//			mU.setMoney("");
//			mU.setPassword(MD5Util.GetMD5("password"));
//			System.out.println(MobileUserService.addMobileUser(mU));
//			System.out.println(MobileUserService.deleteMobileUser("天气变糯了"));
//			System.out.println(MobileUserService.updateMoney("天气变了呵呵", "0.25"));
//			System.out.println(MobileUserService.updateMobileUser(mU));
//			System.out.println(MobileUserService.getMobileUser("天气变了呵呵");
//			System.out.println(MobileUserService.getMobileUser("天气变了呵呵", MD5Util.GetMD5("password")));
//			System.out.println(MobileUserService.getMobileUserByPage(0, 10));
			/*手机用户测试*/

			/*电脑用户测试*/
//			PCUser pcuser = new PCUser();
//			pcuser.setEmail("email");
//			pcuser.setEmployee_no("employee_no");
//			pcuser.setHead_portrait("head_portrait");
//			pcuser.setPassword(MD5Util.GetMD5("password"));
//			pcuser.setQuestion("question");
//			pcuser.setReg_no("reg_no");
//			pcuser.setReg_time(TimeFormatUtil.getFormattedNow());
//			pcuser.setTel("15215199999");
//			pcuser.setUser_name("测试用户名哈哈");
//			System.out.println(PCUserService.addPCUser(pcuser));
//			System.out.println(PCUserService.deletePCUser("电脑用户测试名"));
//			System.out.println(PCUserService.resetPCUserPW(pcuser));
//			System.out.println(PCUserService.updatePCUser(pcuser));
//			System.out.println(PCUserService.getPCUser("测试用户名哈哈"));
//			System.out.println(PCUserService.getPCUserByPage(0, 10));
//			System.out.println(PCUserService.getPCUser("测试用户名哈哈", "5F4DCC3B5AA765D61D8327DEB882CF99"));
			/*电脑用户测试*/
			
			/*评论测试*/
//			Review review = new Review();
//			review.setReview_user_name("33333333");
//			review.setContent("content汉语");
//			review.setHead_portrait("head_portrait");
//			review.setScore(5);
//			review.setStation_id(1);
//			System.out.println(ReviewService.addReview(review));
//			System.out.println(ReviewService.getReviewByPage(0, 10));
//			System.out.println(ReviewService.getReviewList(review));
//			System.out.println(ReviewService.updateReview(review));
//			System.out.println(ReviewService.deleteReview(review));
//			System.out.println(ReviewService.getReviewAvgScoreByStationID(1));
			/*评论测试*/
			
			/*回复测试*/
//			WriteBack writeBack = new WriteBack();
//			writeBack.setId(2);
//			writeBack.setReview_user_name("33333333");
//			writeBack.setContent("content汉语");
//			writeBack.setStation_id(1);
//			writeBack.setTime(TimeFormatUtil.getFormattedNow());
//			writeBack.setWrite_back_user_name("5644");
//			writeBack.setReview_id(4);
//			System.out.println(WriteBackService.addWriteBack(writeBack));
//			System.out.println(WriteBackService.getWriteBackByPage(0, 10));
//			System.out.println(WriteBackService.getWriteBackList(writeBack));
//			System.out.println(WriteBackService.updateWriteBack(writeBack));
//			System.out.println(WriteBackService.deleteWriteBack(writeBack));
//			System.out.println(WriteBackService.getWriteBackCountByReview(1,4));
			
			/*回复测试*/
			
			/*点赞测试*/
//			AddHeart addHeart = new AddHeart();
//			addHeart.setId(2);
//			addHeart.setReview_user_name("33333333");
//			addHeart.setStation_name("深圳市集成电路设计应用产业园");
//			addHeart.setReview_id(4);
//			addHeart.setStation_id(1);
//			System.out.println(AddHeartService.addAddHeart(addHeart));
//			System.out.println(AddHeartService.getAddHeartByPage(0, 10));
//			System.out.println(AddHeartService.getAddHeartList(addHeart));
//			System.out.println(AddHeartService.updateAddHeart(addHeart));
//			System.out.println(AddHeartService.deleteAddHeart(addHeart));
//			System.out.println(AddHeartService.getAddHeartCountByReview(1, 4));
			/*点赞测试*/

			/*用户余额测试*/
//			TradeService.moneyIn("userone", "0.20");
//			System.out.println(MobileUserService.updateMoney("userone", "0.02"));
//			System.out.println(TradeService.getMoney("userone"));
//			System.out.println(MobileUserService.getMobileUser("userone").getMoney());
			
			/*用户余额测试*/
		}

}
