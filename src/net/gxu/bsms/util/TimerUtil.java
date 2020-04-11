package net.gxu.bsms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class TimerUtil {

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String time2String(Date d) {
		if (d == null){
			return "";
		}
		String s = sdf.format(d);
		return s;
	}

	public static Date string2Time(String dateStr) {

		try {
			Date d = sdf.parse(dateStr);
			return d;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}

}
