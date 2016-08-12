package com.IZI.zoo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;





public class FeedData extends DatabaseAccess {


	public FeedData() {
		super();
		accessDatabase();
	}

	
	public static int createIntoDatabase(Feed dataToInsert) {

		
		try {	 
			accessDatabase();
			String insertTableSQL = "INSERT INTO Feed (Feed_Name,Description,Quantity_Left,Reorder_Quanty,OnReorder,note) VALUES (?,?,?,?,?,?);";
	
			PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, dataToInsert.getFeed_Name());
			preparedStatement.setString(2, dataToInsert.getDescription());
			preparedStatement.setInt(3,dataToInsert.getQuantity_Left());
			preparedStatement.setInt(4, dataToInsert.getReorder_Quanty());
			preparedStatement.setInt(5, dataToInsert.getOnReorder());
			preparedStatement.setString(6, dataToInsert.getNote());
	
			int success = preparedStatement.executeUpdate();
			return success;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static int readDatabaseByAnimalId(String Animal_ID ) {

		String sqlTemplate = "SELECT Quantity from Feed Where Animal_ID   =?";
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

	
	public static void updateDatabaseForQuantity(String feed_ID, int amount) {
		PreparedStatement preparedStatement = null;
		String sqlTemplate = "select * from Feed where Feed_ID  is "+feed_ID+" limit 1";
		try {

			preparedStatement = connection.prepareStatement(sqlTemplate);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {	
				String id = rs.getString("Feed_ID");
				int currentAmount = rs.getInt("Quantity_Left");

				int updateAmount = currentAmount - amount;
				String updateTableSQL = "UPDATE Feed SET Quantity_Left = "+updateAmount+"  WHERE P_ID = ?";
				preparedStatement = connection.prepareStatement(updateTableSQL);
				preparedStatement.setString(1, id);
				preparedStatement.executeUpdate();
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void restock(String feed_ID) {
		PreparedStatement preparedStatement = null;
		String sqlTemplate = "select * from Feed where Feed_ID  is "+feed_ID+" limit 1";
		try {

			preparedStatement = connection.prepareStatement(sqlTemplate);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {	
				String id = rs.getString("Feed_ID");
				int currentAmount = rs.getInt("Quantity_Left");

				log(" Wasted "+currentAmount+" for Feed Id "+id);
				String updateTableSQL = "UPDATE Feed SET Quantity_Left = 100  WHERE P_ID = ?";
				preparedStatement = connection.prepareStatement(updateTableSQL);
				preparedStatement.setString(1, id);
				preparedStatement.executeUpdate();
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
}
