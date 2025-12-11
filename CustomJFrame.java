import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.NumberFormatter;

/**
 * 
 * The Program Creates a Custom JFrame for the Dietary Survey.
 * It takes in the values entered by the user and store them
 * inside the survey_results.csv file.
 * 
 * @author Philimon Tegegn
 */
public class CustomJFrame extends JFrame
{
	// Declaring Instance variables
	private JLabel headingLabel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel phoneNumberLabel;
	private JLabel emailLabel;
	private JLabel dietaryLabel;
	private JLabel genderLabel;
	private JLabel waterLabel;
	private JLabel mealsLabel;
	private JLabel checkBoxLabel;
	private JLabel walkLabel;
	private JLabel weightLabel;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField phoneNumberTextField;
	private JTextField emailTextField;
	private JRadioButton maleRadioButton;
	private JRadioButton femaleRadioButton;
	private JRadioButton preferRadioButton;
	private ButtonGroup radioButtonGroup;
	private JSpinner waterIntakeSpinner;
	private JSlider mealSlider;
	private JCheckBox wheatCheckBox;
	private JCheckBox sugarCheckBox;
	private JCheckBox dairyCheckBox;
	private JComboBox walkComboBox;
	private String[] walkOptions;
	private JFormattedTextField weightFormattedTextField;
	private JButton clearButton;
	private JButton submitButton;
	private FileHandler fileHandler;
	
	/**
	 * 
	 * The Constructor initializes all the instance variables
	 * of the object. It also assigns the correct position for each
	 * instance values.
	 * 
	 * @throws IOException - Throws exception if there is a problem writing the file
	 */
	public CustomJFrame () throws IOException 
	{
		setTitle("Dietary Survey");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Creating The header
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		headingLabel = new JLabel("Personal Information");
		mainPanel.add(headingLabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		firstNameLabel = new JLabel("First Name: ");
		mainPanel.add(firstNameLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		firstNameTextField = new JTextField(15);
		mainPanel.add(firstNameTextField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		lastNameLabel = new JLabel("Last Name: ");
		mainPanel.add(lastNameLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		lastNameTextField = new JTextField(15);
		mainPanel.add(lastNameTextField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		phoneNumberLabel = new JLabel("Phone Number: ");
		mainPanel.add(phoneNumberLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		phoneNumberTextField = new JTextField(15);
		mainPanel.add(phoneNumberTextField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		emailLabel = new JLabel("Email: ");
		mainPanel.add(emailLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		emailTextField = new JTextField(15);
		mainPanel.add(emailTextField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		genderLabel = new JLabel("Sex: ");
		mainPanel.add(genderLabel, gbc);
		
		maleRadioButton = new JRadioButton("Male");
		femaleRadioButton = new JRadioButton("Female");
		preferRadioButton = new JRadioButton("Prefer not to say");
		radioButtonGroup = new ButtonGroup(); // Create a button group for the genders
		radioButtonGroup.add(maleRadioButton);
		radioButtonGroup.add(femaleRadioButton);
		radioButtonGroup.add(preferRadioButton);
		JPanel genderPanel = new JPanel(); // Create panel for the genders
		genderPanel.setLayout(new GridLayout(3,1)); // Make the list vertical
		genderPanel.add(maleRadioButton);
		genderPanel.add(femaleRadioButton);
		genderPanel.add(preferRadioButton);
		gbc.gridx = 1;
		gbc.gridy = 5;
		mainPanel.add(genderPanel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		dietaryLabel= new JLabel("Dietary Questions");
		mainPanel.add(dietaryLabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		waterLabel = new JLabel("How many cups of water on average do you drink a day?");
		mainPanel.add(waterLabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 8;
		waterIntakeSpinner = new JSpinner(new SpinnerNumberModel(15, 0, 15, 1));
		JPanel waterPanel = new JPanel();
		waterPanel.add(waterIntakeSpinner);
		waterPanel.setPreferredSize(new Dimension(80, 30)); // make the spinner size small
		mainPanel.add(waterPanel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.insets = new Insets(5, 20, 5, 5);
		mealsLabel = new JLabel("How many meals on average do you eat a day?");
		mainPanel.add(mealsLabel, gbc);
		
		JPanel mealsPanel = new JPanel();
		mealSlider = new JSlider(0, 10, 3);
		mealSlider.setMinorTickSpacing(1);
		mealSlider.setMajorTickSpacing(1);
		mealSlider.setPaintLabels(true);
		mealSlider.setPaintTicks(true);
		mealSlider.setPreferredSize(new Dimension(180, 40));
		mealsPanel.add(mealSlider);
		gbc.gridx = 0;
		gbc.gridy = 10;		
		mainPanel.add(mealsPanel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 11;
		gbc.insets = new Insets(5, 40, 5, 5);
		checkBoxLabel = new JLabel("Do any of these meals regularly contain:");
		mainPanel.add(checkBoxLabel, gbc);
		
		JPanel checkBoxPanel = new JPanel();
		dairyCheckBox = new JCheckBox("Dairy");
		wheatCheckBox = new JCheckBox("Wheat");
		sugarCheckBox = new JCheckBox("Sugar");
		checkBoxPanel.add(dairyCheckBox);
		checkBoxPanel.add(wheatCheckBox);
		checkBoxPanel.add(sugarCheckBox);
		gbc.gridx = 0;
		gbc.gridy = 12;
		gbc.insets = new Insets(5, 5, 5, 5);
		mainPanel.add(checkBoxPanel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 13;
		gbc.insets = new Insets(5, 15, 5, 5);
		walkLabel = new JLabel("On average how many miles do you walk in a day?");
		mainPanel.add(walkLabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 14;
		walkOptions = new String[4];
		walkOptions[0] = "Less than 1 Mile";
		walkOptions[1] = "More than 1 Mile but less than 2 miles";
		walkOptions[2] = "More than 2 miles but less than 3 miles";
		walkOptions[3] = "More than 3 Mile";
		walkComboBox = new JComboBox<>(walkOptions);
		walkComboBox.setPreferredSize(new Dimension(225, 20));
		walkComboBox.setSelectedIndex(0); // Make default select value the first index
		JPanel walkPanel = new JPanel();
		walkPanel.add(walkComboBox);
		mainPanel.add(walkPanel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 15;
		gbc.insets = new Insets(5, 85, 5, 5);
		weightLabel = new JLabel("How much do you weigh?");
		mainPanel.add(weightLabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 16;
		gbc.insets = new Insets(5, 50, 5, 50);
		NumberFormatter formatter = new NumberFormatter();
        formatter.setValueClass(Integer.class);
        formatter.setAllowsInvalid(false);
        formatter.setMinimum(0);
        formatter.setMaximum(999);
        weightFormattedTextField = new JFormattedTextField(formatter);
        weightFormattedTextField.setColumns(5);
		mainPanel.add(weightFormattedTextField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 17;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(5, 5, 5, 50);
		clearButton = new JButton("Clear");
		clearButton.setBackground(Color.yellow);
		mainPanel.add(clearButton, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 17;
		gbc.insets = new Insets(5, 110, 5, 5);
		submitButton = new JButton("Submit");
		submitButton.setBackground(Color.green);
		mainPanel.add(submitButton, gbc);
		
		fileHandler = new FileHandler(); // Initialize the file handler
		
		InnerActionListener listener = new InnerActionListener();
		submitButton.addActionListener(listener);
		clearButton.addActionListener(listener);
		
		add(mainPanel, BorderLayout.NORTH);
	} // End of Constructor
	
	/**
	 * 
	 * The Class Creates an action listener for the custom JFrame. It will take in
	 * all the data then stores them to the file when submit button is clicked. It 
	 * also clears the form when clear button is clicked.
	 * 
	 * @author Philimon Tegegn
	 */
	class InnerActionListener implements ActionListener 
	{
		/**
		 * The method get the survey data stores them to the file
		 * when submit is pressed and clears the survey form when
		 * clear button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Object source = e.getSource();
			String fileData = "";
			
			// Write text field data to the fileData string
			if ( source == submitButton ) 
			{
				fileData += "," + firstNameTextField.getText() + "," + lastNameTextField.getText() + "," + phoneNumberTextField.getText()
							+ "," + emailTextField.getText();
				
				// Get the value for radio button
				String sex = "";
				if ( maleRadioButton.isSelected() ) 
				{
					sex = "Male";
				}
				else if ( femaleRadioButton.isSelected() ) 
				{
					sex = "Female";
				}
				else if ( preferRadioButton.isSelected() ) 
				{
					sex = "Prefer not to say";
				} // End of condition
				
				// Add sex to file data
				fileData += "," + sex;
				
				// Add JSpinner and Slider value to file Data
				fileData += "," + waterIntakeSpinner.getValue() + "," + mealSlider.getValue();
				
				// Add meal check box to file Data
				fileData += "," + wheatCheckBox.isSelected() + "," + sugarCheckBox.isSelected() + "," + dairyCheckBox.isSelected(); 
				
				// Add walk combo box to file Data
				fileData += "," + (String)walkComboBox.getSelectedItem();
				
				// Add formatted text field to file data
				fileData += "," + (Integer)weightFormattedTextField.getValue();
				
				// Write the file data into the file
				try 
				{
					fileHandler.writeResults(fileData);
				}
				catch (IOException e1) { } // End of catch
				
				clearForm();
			}
			else if ( source == clearButton ) 
			{
				clearForm();
			}// End of Condition
			
		} // End of Method
		
		/**
		 * The method clear the survey form and set some of the values to their
		 * default values.
		 */
		private void clearForm() 
		{
			firstNameTextField.setText("");
			lastNameTextField.setText("");
			phoneNumberTextField.setText("");
			emailTextField.setText("");
			radioButtonGroup.clearSelection();
			waterIntakeSpinner.setValue(15);
			mealSlider.setValue(3);
			dairyCheckBox.setSelected(false);
			wheatCheckBox.setSelected(false);
			sugarCheckBox.setSelected(false);
			walkComboBox.setSelectedIndex(0);
			weightFormattedTextField.setValue(null);
			
		} // End of Method
		
	} // End of Action Listener method
	
} // End of class
