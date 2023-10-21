// [10-1] Calendar 클래스와 SimpleDateFormat클래스를 이용해서 2010년의 매월 두 번째 일요일의 날짜를 출력하시오.

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Exercise10-1 {
	public static void main(String[] args){
		Calendar cal = Calendar.getInstance();
		
		cal.set(2010,0,1); 
		
		for(int i =0;i<12;i++){
			int day = cal.get(Calendar.DAY_OF_WEEK);
			
			int sunday = (day == 1)?8:16-day;
			
			cal.set(Calendar.DAY_OF_MONTH, sunday);
			
			Date d = cal.getTime();
			System.out.println(new SimpleDateFormat("yyyy-MM-dd은 F번째 E요일입니다.").format(d));
			
			cal.add(Calendar.MONTH, 1);
			cal.set(Calendar.DAY_OF_MONTH,1);
		}
	}
}