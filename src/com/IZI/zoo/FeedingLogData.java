package com.IZI.zoo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;





public class FeedingLogData extends DatabaseAccess {


	public FeedingLogData() {
		super();
		accessDatabase();
	}

	
	public static int createIntoDatabase(FeedingLog dataToInsert) {

		try {	 
			accessDatabase();
			String insertTableSQL = "INSERT INTO Log_of_Feeding (Animal_ID,Feed_ID,Quantity,Time_of_Day24Hour, Date_of_Feeding, Recorded_Flag, note) VALUES (?,?,?,?,?,?,?);";
	
			PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, dataToInsert.getAnimal_ID());
			preparedStatement.setInt(2, dataToInsert.getFeed_ID());
			preparedStatement.setInt(3,dataToInsert.getQuantity());
			preparedStatement.setLong(4, dataToInsert.getTime_of_Day24Hour());
			preparedStatement.setDate(5, dataToInsert.getDate_of_Feeding());
			preparedStatement.setInt(6,dataToInsert.getRecorded_Flag() );
			preparedStatement.setString(7, dataToInsert.getNote());
	
			int success = preparedStatement.executeUpdate();
			return success;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static int readDatabaseByAnimalId(String Animal_ID ) {

		String sqlTemplate = "SELECT Quantity from Log_of_Feeding Where Animal_ID   =?";
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement(sqlTemplate);
			preparedStatement.setString(1, Animal_ID );
			ResultSet rs = preparedStatement.executeQuery();
			int recordAt = 0 ;
			while (rs.next()) {
	
				String value = rs.getString("Quantity");
				recordAt = recordAt + Integer.valueOf(value);
	
			}
			return recordAt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static int countHowMuchFeed(String Animal_ID, String fromDate, String toDate ) {
		accessDatabase();
		
//		select sum(quantity) from log_of_feeding 
//		WHERE date_of_feeding  BETWEEN '2016-07-01' AND '2016-07-02'
//		AND note = 'Jaguar'
		
		String sqlTemplate = "SELECT sum(Quantity) from Log_of_Feeding Where Animal_ID   =? AND  date_of_feeding  BETWEEN '"+fromDate+"' AND '"+toDate+"'";
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement(sqlTemplate);
			preparedStatement.setString(1, Animal_ID );
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
	
				int value = rs.getInt(1);
				return value;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static ArrayList<String> findAllDates() {
		accessDatabase();
		ArrayList<String> singleList = new ArrayList<String>();
		String sqlTemplate = "select distinct date_of_feeding from log_of_feeding order by date_of_feeding";
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement(sqlTemplate);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String value = rs.getString(1);
				singleList.add(value);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return singleList;
	}

	public static ArrayList<String> findAllAnimals() {
		accessDatabase();
		ArrayList<String> singleList = new ArrayList<String>();
		String sqlTemplate = "select distinct Animal_ID from log_of_feeding order by Animal_ID";
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement(sqlTemplate);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String value = rs.getString(1);
				singleList.add(value);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return singleList;
	}
	public static ArrayList<String> findAllAnimalsOrderBySpecies() {
		accessDatabase();
		ArrayList<String> singleList = new ArrayList<String>();
		String sqlTemplate = "select distinct log_of_feeding.Animal_ID from log_of_feeding Inner Join Animal on log_of_feeding.Animal_ID=Animal.Animal_Id order by Animal.Species_Id";
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement(sqlTemplate);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String value = rs.getString(1);
				singleList.add(value);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return singleList;
	}
	
	
	public static String updateDatabaseForQuantity(String Log_of_Feeding_ID) {
		String flag = "";
		PreparedStatement preparedStatement = null;
		String sqlTemplate = "select * from Log_of_Feeding where Log_of_Feeding_ID is "+Log_of_Feeding_ID+" limit 1";
		try {

			preparedStatement = connection.prepareStatement(sqlTemplate);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {	
				String id = rs.getString("Log_of_Feeding_ID");
				flag = rs.getString("Recorded_Flag");
				int amount = rs.getInt("Quantity");
				String feedId = rs.getString("Feed_ID");
				String updateTableSQL = "UPDATE Log_of_Feeding SET Recorded_Flag = '1'  WHERE P_ID = ?";
				preparedStatement = connection.prepareStatement(updateTableSQL);
				preparedStatement.setString(1, id);
				preparedStatement.executeUpdate();
				// update feed
				FeedData.updateDatabaseForQuantity(feedId, amount);
		
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}
	
	
	
}
