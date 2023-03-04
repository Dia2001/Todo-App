package sbjp.rest.sbjprestful.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	public static String convertDateToddMMyyyy(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(date);
	}
}
