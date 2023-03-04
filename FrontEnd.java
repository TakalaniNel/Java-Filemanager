import za.ac.tut.file.FileManager;
import java.io.IOException;
public class FrontEnd
{
	public static void main(String[] args)
	{
		FileManager manageFile = new FileManager();
		try
		{
			/*String[] inputRecords = manageFile.readFile("c:\\data\\person.txt");
			//for loop to read out the records from array
			for(String eachRecord :inputRecords)
			{
				System.out.println(eachRecord);
			}
			*/
			
			String [] data = {"Ronnie#hans#25","Vusi#Skhosana#45","Frans#Galane#23"};
			manageFile.writeTofile(data,"c:\\data\\person.txt");
			
		}
		catch(IOException er)
		{
		
			System.out.println(er.getMessage());
		}
	
	}

}