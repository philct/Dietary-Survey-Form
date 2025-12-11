import java.io.IOException;

import javax.swing.JFrame;

/**
 * The program takes in survey data for a user. It takes in the first name,
 * last name, phone number, email, sex, average cups of water per day, meals
 * per day, what meal contains, miles walk per day and the weight. It then 
 * stores the data to the survey_results csv file. The program uses JFrame 
 * windows GUI to take in the survey data. 
 * 
 * @author Philimon Tegegn (N01513784)
 * @version 17.0
 * @since 2025-12-11
 */
public class Project4 
{
	/**
	 * The main program creates the JFrame, initialize it with the custom JFrame 
	 * and makes it visible.
	 * 
	 * @param args used for command line arguments
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException 
	{
		JFrame DietarySurveyJFrame = new CustomJFrame();
		DietarySurveyJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DietarySurveyJFrame.setSize(350, 680);
		DietarySurveyJFrame.setVisible(true);
		
	} // End of main

} // End of class
