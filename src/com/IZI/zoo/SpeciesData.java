package com.IZI.zoo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;





public class SpeciesData extends DatabaseAccess {


	public SpeciesData() {
		super();
		accessDatabase();
	}

	
	public static int createIntoDatabase(Species dataToInsert) {

		
		try {	 
			accessDatabase();
			String insertTableSQL = "INSERT INTO Species (Species_Name,Description,Quantity_Left,Reorder_Quanty,OnReorder,note) VALUES (?,?,?,?,?,?);";
	
			PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, dataToInsert.getName());

			int success = preparedStatement.executeUpdate();
			return success;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static int readDatabaseByAnimalId(String Animal_ID ) {

		String sqlTemplate = "SELECT Quantity from Species Where Animal_ID   =?";
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

	
	public static void updateDatabaseForQuantity(String Species_ID, int amount) {
		PreparedStatement preparedStatement = null;
		String sqlTemplate = "select * from Species where Species_ID  is "+Species_ID+" limit 1";
		try {

			preparedStatement = connection.prepareStatement(sqlTemplate);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {	
				String id = rs.getString("Species_ID");
				int currentAmount = rs.getInt("Quantity_Left");

				int updateAmount = currentAmount - amount;
				String updateTableSQL = "UPDATE Species SET Quantity_Left = "+updateAmount+"  WHERE P_ID = ?";
				preparedStatement = connection.prepareStatement(updateTableSQL);
				preparedStatement.setString(1, id);
				preparedStatement.executeUpdate();
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
}
