package ten;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Exercise10_1 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2010, 0, 1);
		
		for (int i = 0; i < 12; i++) {
			int weekDay = cal.get(Calendar.DAY_OF_WEEK);
			
			if (weekDay == 1) {
				cal.set(Calendar.DAY_OF_MONTH, 8);
			}
			else {
				cal.set(Calendar.DAY_OF_MONTH, 16-weekDay);
			}
			
			Date date = cal.getTime();
			System.out.println(new SimpleDateFormat("yyyy-MM-dd는 F번째 E요일입니다.").format(date));
			cal.add(Calendar.MONTH, 1);
			cal.set(Calendar.DAY_OF_MONTH, 1);
	
		}
	}
}
