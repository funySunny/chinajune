package com.ChargePoint.Utils;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;

public class TextUtils
{

	/**
	 * 编码格式转换
	 * 
	 * @param oldStr
	 * @return
	 */
	public static String TOUTF8(String oldStr)
	{
		String newStr = oldStr;
		try
		{
			newStr = new String(oldStr.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return newStr;
	}
	
	
	/**获取随机字符串
	 * @param int strLength 随机字符串长度
	 * @return String
	 */
	public static String getRandomString(int strLength)
	{
		/****默认去掉了容易混淆的字符oOLl,9gq,Vv,Uu,I1****/
		String chars = "ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678";    
		int maxPos = chars.length();
		String newStr = "";
		for (int i = 0; i < strLength; i++) {
			newStr += chars.charAt((int) Math.floor(Math.random() * maxPos));
		};
		return newStr;
	}
}
