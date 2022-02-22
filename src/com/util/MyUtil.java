package com.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.entity.Testinfo;

public class MyUtil {

	public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
		if (nowTime.getTime() == startTime.getTime() || nowTime.getTime() == endTime.getTime()) {
			return true;
		}

		Calendar date = Calendar.getInstance();
		date.setTime(nowTime);

		Calendar begin = Calendar.getInstance();
		begin.setTime(startTime);

		Calendar end = Calendar.getInstance();
		end.setTime(endTime);

		if (date.after(begin) && date.before(end)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获得时间字符串
	 */
	public static String getStringID() {
		String id = null;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		id = sdf.format(date);
		return id;

	}

	public static boolean isInTime(Date nowTime, Date startTime, Date endTime) {
		if (nowTime.getTime() == startTime.getTime() || nowTime.getTime() == endTime.getTime()) {
			return true;
		}

		Calendar date = Calendar.getInstance();
		date.setTime(nowTime);

		Calendar begin = Calendar.getInstance();
		begin.setTime(startTime);

		Calendar end = Calendar.getInstance();
		end.setTime(endTime);

		if (date.after(begin) && date.before(end)) {
			return true;
		} else {
			return false;
		}
	}

	public static Testinfo FormatTestinfoTime(Testinfo testinfo) {
		String temp;
		if ("".equals(testinfo.getRegist_end_time()) == false && testinfo.getRegist_end_time() != null) {
			temp = testinfo.getRegist_end_time();
			temp = temp.substring(0, 10) + "T" + temp.substring(11, temp.length());
			testinfo.setRegist_end_time(temp);
		}
		if ("".equals(testinfo.getRegist_start_time()) == false && testinfo.getRegist_start_time() != null) {
			temp = testinfo.getRegist_start_time();
			temp = temp.substring(0, 10) + "T" + temp.substring(11, temp.length());
			testinfo.setRegist_start_time(temp);
		}
		if ("".equals(testinfo.getTest_time()) == false && testinfo.getTest_time() != null) {
			temp = testinfo.getTest_time();
			temp = temp.substring(0, 10) + "T" + temp.substring(11, temp.length());
			testinfo.setTest_time(temp);
		}
		return testinfo;
	}

}
