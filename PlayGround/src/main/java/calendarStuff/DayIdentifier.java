package calendarStuff;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DayIdentifier {

	public static String identify(String input_date) throws ParseException {
		Calendar c = Calendar.getInstance(Locale.US);
		
//		  String input_date="01/08/2012";
		  SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
		  Date dt1=format1.parse(input_date);
		  DateFormat format2=new SimpleDateFormat("EEEE"); 
		  String finalDay=format2.format(dt1);

		  return(finalDay);
		  
	}

}
