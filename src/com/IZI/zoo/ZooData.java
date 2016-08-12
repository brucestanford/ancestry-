package com.IZI.zoo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;





public class ZooData extends DatabaseAccess {


	public ZooData() {
		super();
		accessDatabase();
	}

	
	public static int createIntoDatabase(Zoo dataToInsert) {

		
		try {	 
			accessDatabase();
			String insertTableSQL = "INSERT INTO Zoo (Zoo_Name,Description,Quantity_Left,Reorder_Quanty,OnReorder,note) VALUES (?,?,?,?,?,?);";
	
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

		String sqlTemplate = "SELECT Quantity from Zoo Where Animal_ID   =?";
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

	
	public static void updateDatabaseForQuantity(String Zoo_ID, int amount) {
		PreparedStatement preparedStatement = null;
		String sqlTemplate = "select * from Zoo where Zoo_ID  is "+Zoo_ID+" limit 1";
		try {

			preparedStatement = connection.prepareStatement(sqlTemplate);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {	
				String id = rs.getString("Zoo_ID");
				int currentAmount = rs.getInt("Quantity_Left");

				int updateAmount = currentAmount - amount;
				String updateTableSQL = "UPDATE Zoo SET Quantity_Left = "+updateAmount+"  WHERE P_ID = ?";
				preparedStatement = connection.prepareStatement(updateTableSQL);
				preparedStatement.setString(1, id);
				preparedStatement.executeUpdate();
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
}
