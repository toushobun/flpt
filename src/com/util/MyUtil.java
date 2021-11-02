package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.entity.Testinfo__room;

public class MyUtil {
	public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
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
	public static List<Testinfo__room> pushTestinfo__roomToBuser(List<Testinfo__room> testinfo__roomList){
		boolean ifInTime;			// ②是否在报名时间内
		boolean ifHaveQuota;		// ①名额是否足够
		Testinfo__room testinfo__room;			// 每个考试信息
		for(int i=0;i<testinfo__roomList.size();i++) {
			testinfo__room = testinfo__roomList.get(i);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd H:m:s");
			Date date1 = null;
			Date date2 = null;
			try {
				date1 = sf.parse(testinfo__room.getRegist_start_time());			// 获取报名开始时间
				date2 = sf.parse(testinfo__room.getRegist_end_time());		// 获取报名截止时间
			} catch (ParseException e) {e.printStackTrace();}		
			Date date = new Date();		// 获取当前系统时间
			ifInTime = MyUtil.isEffectiveDate(date, date1, date2);		// 判断是否在报名时间内
			ifHaveQuota = testinfo__room.getRquota() > 0;						// 判断名额是否足够
			// 状态，1可报名，0名额已满，-1不在报名时间，-2名额已满且不在报名时间
			if(ifInTime && ifHaveQuota){
				testinfo__room.setStatus(1);
			}
			else if(ifInTime && !ifHaveQuota) {
				testinfo__room.setStatus(0);
			}
			else {
				testinfo__room.setStatus(-1);
			}
		}
		return testinfo__roomList;
	}
}
