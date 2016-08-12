package com.IZI.zoo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;





public class FeedingLog {


	
	int Log_of_Feeding_ID;
	int Animal_ID;
	int Feed_ID;
	int Quantity;
	long Time_of_Day24Hour;
	Date Date_of_Feeding;
	int Recorded_Flag ;
	String note ;
	public int getLog_of_Feeding_ID() {
		return Log_of_Feeding_ID;
	}
	public void setLog_of_Feeding_ID(int log_of_Feeding_ID) {
		Log_of_Feeding_ID = log_of_Feeding_ID;
	}
	public int getAnimal_ID() {
		return Animal_ID;
	}
	public void setAnimal_ID(int animal_ID) {
		Animal_ID = animal_ID;
	}
	public int getFeed_ID() {
		return Feed_ID;
	}
	public void setFeed_ID(int feed_ID) {
		Feed_ID = feed_ID;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public long getTime_of_Day24Hour() {
		return Time_of_Day24Hour;
	}
	public void setTime_of_Day24Hour(long time_of_Day24Hour) {
		Time_of_Day24Hour = time_of_Day24Hour;
	}
	public Date getDate_of_Feeding() {
		return Date_of_Feeding;
	}
	public void setDate_of_Feeding(Date date_of_Feeding) {
		Date_of_Feeding = date_of_Feeding;
	}
	public int getRecorded_Flag() {
		return Recorded_Flag;
	}
	public void setRecorded_Flag(int recorded_Flag) {
		Recorded_Flag = recorded_Flag;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

}
