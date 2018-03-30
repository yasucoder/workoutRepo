package java8feature;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Time {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate lDate = LocalDate.now();		
		System.out.println(lDate);
		
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println(currentTime);
		
		Month mon = currentTime.getMonth();
		System.out.println(mon);
		LocalDate date3 = LocalDate.of(2005, Month.JANUARY, 27);
		System.out.println(date3);
		
		LocalDate nextweek = LocalDate.now().plus(2,ChronoUnit.WEEKS); 
		System.out.println(nextweek);
		
		Period elspperiod = Period.between(nextweek, lDate);
		System.out.println(elspperiod);
		
		LocalTime time1 = LocalTime.now();
		Duration twoHours = Duration.ofHours(2);
		LocalTime time2 = time1.plus(twoHours);
		Duration dura = Duration.between(time2, time1);
		System.out.println("Duration:"+ dura);
		
		ZonedDateTime zDate = ZonedDateTime.now();
		System.out.println("ZoneTime:"+zDate);
		
		ZoneId zoneid = ZoneId.of("Europe/Paris");
		System.out.println("ZoneId: " + zoneid);
		
		//ZoneId currentZone = ZoneId.systemDefault();
	    //  System.out.println("CurrentZone: " + currentZone);
	      
	      Date currentDate = new Date();
	    //Get the instant of current date in terms of milliseconds
	      Instant now = currentDate.toInstant();
	      ZoneId currentZone = ZoneId.systemDefault();
			
	      LocalDateTime localDateTime = LocalDateTime.ofInstant(now, currentZone);
	      System.out.println("Local date: " + localDateTime);
			
	      ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, currentZone);
	      System.out.println("Zoned date: " + zonedDateTime);
		
	}
	public void testDuration(){
	      LocalTime time1 = LocalTime.now();
	      Duration twoHours = Duration.ofHours(2);
			
	      LocalTime time2 = time1.plus(twoHours);
	      Duration duration = Duration.between(time1, time2);
			
	      System.out.println("Duration: " + duration);
	   }

}
