import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHandler 
{
	// Declaring instance variables
	private String surveyFile;
	private FileWriter fileOutput;
	private PrintWriter printWriter;
	
	public FileHandler () throws IOException 
	{
		fileOutput = new FileWriter("survey_results.csv");
		printWriter = new PrintWriter(fileOutput);
		
		// Writing the header
		printWriter.println("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight");
		printWriter.close();
		
		
	} // End of Constructor
	
	
	public void writeResults ( String surveyData ) throws IOException
	{
		FileWriter fileOutputStream = new FileWriter("survey_results.csv", true);
		PrintWriter printWriterResults = new PrintWriter(fileOutputStream);
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		printWriterResults.println(dateFormat.format(now) + surveyData );
		printWriterResults.close();
	} // End of method
	
	
} // End of class
