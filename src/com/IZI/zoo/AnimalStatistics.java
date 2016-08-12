package com.IZI.zoo;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;



public class AnimalStatistics {

	public static void findStatisticsAmountFedPerDayAverage() {
		System.out.println(" STATS Amount Fed per day average");


		ArrayList<String> allAnimals = FeedingLogData.findAllAnimals();
		ArrayList<String> allDates = FeedingLogData.findAllDates();		
		
		Iterator<String> iteratorForAnimals = allAnimals.iterator();
		while (iteratorForAnimals.hasNext()) {
			String animalId = iteratorForAnimals.next();
		
			int total =0;
			int count =0;
			Iterator<String> iterator = allDates.iterator();
			while (iterator.hasNext()) {
				String dateToCheck = iterator.next();
				int daily = FeedingLogData.countHowMuchFeed(animalId,dateToCheck,dateToCheck);
				total = total +daily;
				count++;
			}
			System.out.println(" Animal ID "+animalId+" average "+total/count);
		}
		System.out.println(" STATS COMPLETE");

	}

	public static void findStatisticsTimesFedPerDayAverageBySpecies() {
		System.out.println(" STATS Times Fed per day average by Species");

		int speciesID =1;

		ArrayList<String> allAnimals = FeedingLogData.findAllAnimalsOrderBySpecies();
		ArrayList<String> allDates = FeedingLogData.findAllDates();		
		
		int total =0;
		int count =0;
		Iterator<String> iteratorForAnimals = allAnimals.iterator();
		while (iteratorForAnimals.hasNext()) {
			String animalId = iteratorForAnimals.next();
			int countTimesFeed =0;
			Iterator<String> iterator = allDates.iterator();
			while (iterator.hasNext()) {
				String dateToCheck = iterator.next();
				int daily = FeedingLogData.countHowMuchFeed(animalId,dateToCheck,dateToCheck);
				countTimesFeed++;
			}
			total = total + countTimesFeed;
			count++;
		}
		System.out.println(" Species ID "+speciesID+" average "+total/count);
		System.out.println(" STATS COMPLETE");

	}

	

}
