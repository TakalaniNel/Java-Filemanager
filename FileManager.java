package za.ac.tut.file;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
//import java.io.*;
public class FileManager
{
	private File file;
	
	public void open(String filePath)
	{
		file = new File(filePath);
	}

    public int numberOfRecords(String filePath)throws IOException // transfer the exception to where the method is called
	{
		int counter = 0;
		//open the file for reading
		open(filePath);
		//Open the file for reading
		FileReader fileReader = new FileReader(file);
		//Open the file into a buffer
		BufferedReader buffer = new BufferedReader(fileReader);
		//Read each record in a buffer
		while(buffer.readLine() != null) // we test whether reached end of file
		{
			counter++; // increment a counter based on a read record
		}
		buffer.close();
		fileReader.close();
		return counter;	
	
	}
	
	public String[] readFile(String fileName) throws IOException
	{
	    int countRecords = numberOfRecords(fileName);
		//Resize the array with number of records
		String[] persons = new String[countRecords];
		//Open the file 
		open(fileName);
		//Read the records into the array
		//Open the file for reading
		FileReader fileReader = new FileReader(file);
		//Read the file into a buffer
		BufferedReader buffer = new BufferedReader(fileReader);
		//read each record into array
		String record = buffer.readLine();
		int count=0;
		while(record != null)
		{
			//store it the array
			persons[count] = record;
			//read the next record
			record = buffer.readLine();
			//increment counter 
			count++;
		}
		buffer.close(); //close the buffer
		fileReader.close(); // close the fileReader
		//return the array
		return persons;
	}
	
	public ArrayList<String> readFiles(String filePath)throws IOException
	{
		ArrayList<String> list = new ArrayList<String>();
		//open the file for reading
		open(filePath);
		//open the file for reading
		FileReader fileReader = new FileReader(file);
		//Read into buffer
		BufferedReader buffer = new BufferedReader(fileReader);
		//Read each record 
		String strRecord = buffer.readLine();		
		while(strRecord != null)
		{
		  //Store each record to a list
		  list.add(strRecord);
		  //read next record
		  strRecord = buffer.readLine();		
		}
		buffer.close();
		fileReader.close();
		return list;	
	}
	
	public void writeTofile(String[] records, String filePath) throws IOException
	{
		//open the file
		open(filePath);
		//Open the file for writing - output
		FileWriter fileWriter = new FileWriter(file);
		//Prepare to write 
		PrintWriter printToFile = new PrintWriter(fileWriter);
		// we can write each record using advanced loop
		
		for (String record : records) // for each record in a collection
		{
			printToFile.println(record);
			
		}
		printToFile.close();
			fileWriter.close();	
	}
	
	public void writeTofile(String record, String filePath) throws IOException
	{
		//open the file 
		open(filePath);
		//Open file for writing - the opened file becomes the output file
		FileWriter fileWriter = new FileWriter(file);
		//Print to the file
		PrintWriter writeToFile = new PrintWriter(fileWriter);
		//Write the 
		writeToFile.println(record);
		//close streams
		writeToFile.close();
		fileWriter.close();		
	}
		
}