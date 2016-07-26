package com.ChargePoint.Utils;

import java.util.Random;

public class RandomStringUtils
{

	/**
	 * 产生指定长度的随机字符串
	 * 
	 * @param int length
	 * @return string
	 */
	public static String getStr(int length)
	{
		StringBuffer sb = null;
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();   
	    sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();  
	}

}
