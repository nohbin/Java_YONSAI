package day0403;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Type_Casting {
	public static void main(String[] args) {

		int i = 10;
		
		Integer intg = (Integer)i;
		Object obj = (Object)i;
		
		Long lng = 100L;
		
		int i2 = intg + 10;
		long l = intg + lng;
		
		Integer intg2 = new Integer(20);
		int i3 = (int)intg2;
		
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		System.out.println(df);
		System.out.println(today);
		String result = df.format(today);
		System.out.println(result);
		Calendar cal = Calendar.getInstance();
		Date d = new Date(cal.getTimeInMillis());
		System.out.println(d);
	}
}
