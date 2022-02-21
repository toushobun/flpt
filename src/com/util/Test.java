package com.util;

import java.text.ParseException;

import com.entity.Testinfo;

public class Test {

	public static void main(String[] args) throws ParseException {
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd H:m:s");
//		// 使用SimpleDateFormat的parse()方法生成Date
//		Date date1 = sf.parse("2020-01-03 12:00:00.0");
//		Date date2 = sf.parse("2021-12-06 16:09:00.0");
//		Date date = new Date();
//		System.out.println(MyUtil.isEffectiveDate(date, date1, date2));
//		System.out.println(String.format("%04d", Math.round(Math.random() * 9999 + 1)));
//		System.out.println(MyUtil.getStringID().substring(0, 4));
		Testinfo testinfo = new Testinfo();
		testinfo.setTest_time("2015-09-24 13:59:59");
		testinfo = MyUtil.FormatTestinfoTime(testinfo);
		System.out.println(testinfo.getTest_time());
	}

}
