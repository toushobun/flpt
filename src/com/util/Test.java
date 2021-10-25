package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd H:m:s");
		//使用SimpleDateFormat的parse()方法生成Date
		Date date1 = sf.parse("2020-01-03 12:00:00.0");
		Date date2 = sf.parse("2021-12-06 16:09:00.0");
		Date date = new Date();
		System.out.println(MyUtil.isEffectiveDate(date, date1, date2));
		System.out.println(String.format("%04d", Math.round(Math.random()*9999+1)));
	}

}
