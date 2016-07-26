package com.ChargePoint.services;

import java.io.IOException;
import java.text.DecimalFormat;

import com.ChargePoint.Utils.DESUtils;
import com.ChargePoint.bean.MobileUser;

public class TradeService {

	/**存钱
	 * @param userName
	 * @param money
	 * @return boolean
	 */
	public synchronized static boolean moneyIn(String userName,String money) {
		boolean resF = false;
		String m = null;
		try {
			m = TradeService.getMoney(userName);
			if(m != null && null != money && !"".equals(money)){
				float fmoney = parseFloat(m);
				fmoney += parseFloat(money);
				String forStrMoney = formatFloat(fmoney);
				resF = MobileUserService.updateMoney(userName,forStrMoney);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resF;
	}
	
	public synchronized static boolean moneyOut(String userName,String money) {
		boolean resF = false;
		float fmoney = 0.00f;
		float submoney = 0.00f;
		fmoney = parseFloat(MobileUserService.getMobileUser(userName).getMoney());
		submoney = parseFloat(money);
		if(fmoney > 0.00f && fmoney >= submoney){
			try {
				fmoney -= submoney;
				String storeMoney = DESUtils.encrypt(formatFloat(fmoney), userName);
				resF = MobileUserService.updateMoney(userName, storeMoney);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resF;
	}
	
	/**根据用户名获取用户余额(解密后)
	 * @param userName
	 * @return String money
	 */
	public static String getMoney(String userName){
		MobileUser user = MobileUserService.getMobileUser(userName); 
		String money = user.getMoney();
		String decryptMoney = null;
		if(null != money){
			try {
				decryptMoney = DESUtils.decrypt(money, userName);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return decryptMoney;
	}
	
	private static float parseFloat(String money){
		float initmoney = 0.00f;
		if(null != money && !"".equals(money)){
			initmoney = Float.parseFloat(money);
		}
		return initmoney;
	}
	
	private static String formatFloat(float money){
		String initmoney = "0.00";
		DecimalFormat decf = new DecimalFormat("0.00");
			initmoney = decf.format(money);
		return initmoney;
	}
}
