package localdatetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class LocalDateD {

	public static void main(String[] args) {

		LocalDate date = LocalDate.now();
		System.out.println(date);
		
		LocalDate apr1_2014 = LocalDate.of(2014, Month.APRIL, 1);
		
		System.out.println(apr1_2014);
		
		LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		
		LocalDate newyork = LocalDate.now(ZoneId.of("America/New_York"));

		System.out.println(todayKolkata);
		
		LocalDate todayKolkata_1 = todayKolkata.plus(1, ChronoUnit.DAYS);
		System.out.println(todayKolkata);

		System.out.println(todayKolkata_1);


		System.out.println(newyork);
	}

}
