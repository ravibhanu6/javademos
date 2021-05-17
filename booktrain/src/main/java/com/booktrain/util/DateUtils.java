package com.booktrain.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	
	public static String getDayFromDate(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE");
		return simpleDateFormat.format(date).toUpperCase();
	}

}
