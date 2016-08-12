package com.IZI.zoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;



public class FileSystemAccess {

	
	public void readDataForInsertIntoFeedingLog()
	{
		FileSystemAccess fileData = new FileSystemAccess();
		ArrayList<ArrayList<String>> listAll = fileData.readFile(".LOF");
		
		Iterator<ArrayList<String>> listOuter  =listAll.iterator();
		while(listOuter.hasNext()) {
			ArrayList<String> listInner  =listOuter.next();

			Iterator<String> iterator = listInner.iterator();
			while (iterator.hasNext()) {

				FeedingLog dataToInsert = new FeedingLog();
				dataToInsert.setAnimal_ID(Integer.valueOf(iterator.next()));
				dataToInsert.setFeed_ID(Integer.valueOf(iterator.next()));
				dataToInsert.setQuantity(Integer.valueOf(iterator.next()));
				dataToInsert.setTime_of_Day24Hour(Integer.valueOf(iterator.next()));
				dataToInsert.setDate_of_Feeding(new Date(System.currentTimeMillis())); iterator.next();
				dataToInsert.setRecorded_Flag(Integer.valueOf(iterator.next()));
				dataToInsert.setNote(iterator.next());
				FeedingLogData.createIntoDatabase(dataToInsert);
			}		
		}
	}
	

	public ArrayList<ArrayList<String>> readFile(String type) {

		ArrayList<ArrayList<String>> dataReadFromFileSystem = new ArrayList<ArrayList<String>>();
		
		File findAllFiles = new File(".");
		String [] allFiles = findAllFiles.list();
		
		for (String fileName : allFiles) {
			
			try {
				String suffix = fileName.substring(fileName.lastIndexOf("."),fileName.length());

				if(suffix.equalsIgnoreCase(type)) {
					try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
						String line;
						while ((line = br.readLine()) != null) {
							
							ArrayList<String>  lineValues  = convertCSVtoArray(line);
							dataReadFromFileSystem.add(lineValues);
						}
	
					} catch (IOException e) {
						// create exception
					}
				}
			} catch (Exception e) {
				// create exception
			}
		}
 


		return dataReadFromFileSystem;
	}

	public  ArrayList<String>  convertCSVtoArray (String str) {
		ArrayList<String> singleList = new ArrayList<String>();
		StringTokenizer parseData = new StringTokenizer(str, ",");

		while (parseData.hasMoreElements()) {
			singleList.add((String) parseData.nextElement());			
		}
		return singleList;
	}

}
