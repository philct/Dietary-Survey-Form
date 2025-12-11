import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The program creates the file for the data. It also writes the contents 
 * inside the file.
 * @author Philimon Tegegn
 */
public class FileHandler 
{
	// Declaring instance variables
	private String surveyFile = "survey_results.csv";;
	private FileWriter fileOutput;
	private PrintWriter printWriter;
	
	/**
	 * The Constructor creates the file and writes the header for it.
	 * 
	 * @throws IOException - Throws exception if there is an issue writing the file.
	 */
	public FileHandler () throws IOException 
	{
		fileOutput = new FileWriter(surveyFile);
		printWriter = new PrintWriter(fileOutput);
		
		// Writing the header
		printWriter.println("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight");
		printWriter.close();
		
	} // End of Constructor
	
	/**
	 * The method writes the file contents using the provided string 
	 * in the parameter.
	 * 
	 * @param surveyData - The string to be written to the file.
	 * @throws IOException - Throws exception if there is an error writing the file.
	 */
	public void writeResults ( String surveyData ) throws IOException
	{
		FileWriter fileOutputStream = new FileWriter(surveyFile, true);
		PrintWriter printWriterResults = new PrintWriter(fileOutputStream);
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		printWriterResults.println(dateFormat.format(now) + surveyData );
		printWriterResults.close();
		
	} // End of method
	
} // End of class
