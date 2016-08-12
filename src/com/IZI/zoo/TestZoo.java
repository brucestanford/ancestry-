package com.IZI.zoo;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;



/*
 
 INSERT INTO animal (Animal_ID, Zoo_ID, Species_ID, Animal_Name, Description, Health, TimesToFeedADay, AmountToFeedEachTime, note) VALUES (0, 0, 0, '', '', '', 0, 0, '');
INSERT INTO company (Company_ID, Company_Name, note) VALUES (0, '', '');
INSERT INTO zoo (Zoo_ID, Company_ID, Zoo_Name, note) VALUES (0, 0, '', '');
INSERT INTO species (Species_ID, Name, note) VALUES (0, '', '');
 
 
 
 */

public class TestZoo {

	public static void main(String[] args) {
		System.out.println(" Zoo Test ");

		AnimalStatistics.findStatisticsAmountFedPerDayAverage();
		AnimalStatistics.findStatisticsTimesFedPerDayAverageBySpecies();
//		ArrayList<String> i = FeedingLogData.findAllDates();
//		int total = FeedingLogData.countHowMuchFeed("1","2016-07-01","2016-07-02");
//		
//		FileSystemAccess fileData = new FileSystemAccess();
////		fileData.readDataForInsertIntoFeedingLog();
////
//		
		
	
//		LocalDate First = LocalDate.parse("2016-07-01");
//		for(int d =1; d < 5; d++) {	
//			LocalDate next = First.plusDays(d);
//			for(int i =1; i < 5; i++) {	
//				FeedingLog dataToInsert = new FeedingLog();
//				dataToInsert.setAnimal_ID(5);
//				dataToInsert.setFeed_ID(1);
//				dataToInsert.setQuantity(2);
//				dataToInsert.setTime_of_Day24Hour(i*4);
//				dataToInsert.setDate_of_Feeding(Date.valueOf(next)); 
//				dataToInsert.setRecorded_Flag(1);
//				dataToInsert.setNote("Lyger");
//				FeedingLogData.createIntoDatabase(dataToInsert);
//			}
//		}
//	
		
		
		
		
		
	}
//	public static Date convertFrom(LocalDate date) {
//		
//		
//		Instant instant = Instant.from(date.atStartOfDay(ZoneId.of("GMT")));
//		java.util.Date date2 = Date.from(instant);
////		LocalDateTime s = date.atStartOfDay();
////	    Timestamp t = java.sql.Timestamp.valueOf(date.atStartOfDay());
//	    Date d = Date.valueOf(date);
////	    Date rc = new Date(t.getDate());
//	    return d;
//	}

}
