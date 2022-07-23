/**
 * 
 */
package base.converter;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;

/**
 * Details of developer
 * @author Ravhudzulo UE
 * @version 0.0.1
 * @see javax.swing.JFrame
 * 
 * Extends JFrame to access Java Swing GUI
 */
public class BaseConverter extends JFrame {
	
	/** Attributes **/
	private JPanel panel = null;
	
	private JLabel decimalNumLb    = null;
	private JLabel baseToConvertLb = null;
	private JLabel displayOutputLb = null;
	
	private JTextField decimalNumTF     = null;
	private JTextField baseToConvertTF = null;
	
	private JTextArea displayOutputArea = null;
	
	private JButton convertButton = null;
	private JButton exitButton    = null;
	
	/** UID number* */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor
	 */
	public BaseConverter() {
		
		setGUI();      // invoke setGUI method
		styleTheUI();  // invoke styleTheUI method
		
		// action to exit the app
		exitButton.addActionListener(e -> {
			
			System.exit(-1);
			
		});
		
		// action to convert 
		convertButton.addActionListener(e -> {
			
			displayOutputLb.setText("Hello World 1.0.0"); 
			displayOutputLb.setForeground(Color.GREEN);
			
			String strDecimalNum = decimalNumTF.getText();
			String strBaseNum    = baseToConvertTF.getText();
			
			System.out.println("Convert Decimal Number " + strDecimalNum + " To Number with base " + strBaseNum);
			
			/*if(strBaseNum == "" && strBaseNum == "") {
				
				displayOutputLb.setText("Please fill in the field(s) above");
				displayOutputLb.setForeground(Color.RED);
				
			}*/
			
			/*if(strBaseNum != "" && strBaseNum != "") { 
			
				int decimalNum = Integer.parseInt(decimalNumTF.getText());
				int baseNum    = Integer.parseInt(baseToConvertTF.getText());
				
				String answer = baseConversion(decimalNum, baseNum);
				
				displayOutputArea.setText(answer);
				
			} */
			
			try { // Handle the exception
				
				int decimalNum = Integer.parseInt(decimalNumTF.getText());
				int baseNum    = Integer.parseInt(baseToConvertTF.getText());
				
				String answer = baseConversion(decimalNum, baseNum);
				
				displayOutputArea.setText(answer);
				
			} catch (NumberFormatException e2) {
				
				displayOutputLb.setText("Please fill in the Number and/or base in the field(s) above");
				displayOutputLb.setForeground(Color.RED);
				
			}
		});
		
	}
	
	/**
	 * setGUI method set the users interface 
	 */
	private void setGUI() {
		
		panel = new JPanel();
		
		decimalNumLb    = new JLabel("Enter The Decimal Number You Want from Convert : ");
		baseToConvertLb = new JLabel("Enter The Base(i.e 16) You Want To Convert To : "); 
		displayOutputLb = new JLabel("Hello World 1.0.0");
		
		decimalNumTF     = new JTextField(); 
		baseToConvertTF  = new JTextField();

		displayOutputArea = new JTextArea();
		
		convertButton = new JButton("CONVERT");
		exitButton    = new JButton("EXIT");
		
		panel.add(decimalNumLb);
		panel.add(decimalNumTF);
		panel.add(displayOutputLb);
		panel.add(baseToConvertLb);
		panel.add(baseToConvertTF);
		panel.add(displayOutputArea);
		panel.add(convertButton);
		panel.add(exitButton);
		
		panel.setLayout(null);  
		
		this.add(panel);
	}
	
	/**
	 * To style the user interface
	 */
	private void styleTheUI() {
		
		// set the color
		displayOutputLb.setForeground(Color.GREEN);
		
		// set the border
		decimalNumTF.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		baseToConvertTF.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		displayOutputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 7));
		convertButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
		exitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
		//panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), 
				//"CONVERT ANY DECIMAL NUMBER (BASE 10) TO THE NUMBER OF ANY BASE ", TitledBorder.CENTER, TitledBorder.TOP));
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), 
				        "CONVERT ANY DECIMAL NUMBER (BASE 10) TO THE NUMBER OF ANY BASE ", TitledBorder.CENTER, TitledBorder.TOP), 
				         BorderFactory.createLineBorder(Color.BLACK, 5, true)));
		displayOutputArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED), 
		        "Converted Number Will Appear bear ", TitledBorder.CENTER, TitledBorder.TOP), 
		         BorderFactory.createLineBorder(Color.BLACK, 2, true)));
		
		// set Position of components
		decimalNumTF.setBounds(410, 30, 150, 50);
		decimalNumLb.setBounds(30, 30, 380, 50);
		baseToConvertTF.setBounds(410, 110, 150, 50);
		baseToConvertLb.setBounds(30, 110, 360, 50);
		displayOutputArea.setBounds(30, 270, 500, 100);
		convertButton.setBounds(160, 190, 100, 50);
		exitButton.setBounds(280, 190, 100, 50);
		displayOutputLb.setBounds(30, 350, 500, 100);

		// set font of components
		decimalNumLb.setFont(new FontUIResource("sansserif", 1, 15));
		baseToConvertLb.setFont(new FontUIResource("sansserif", 1, 15));
		decimalNumTF.setFont(new FontUIResource("sansserif", 1, 25));
		baseToConvertTF.setFont(new FontUIResource("sansserif", 1, 25));
		displayOutputArea.setFont(new FontUIResource("sansserif", 1, 25));
		convertButton.setFont(new FontUIResource("sansserif", 1, 15));
		exitButton.setFont(new FontUIResource("sansserif", 1, 15));
		
		//displayOutputArea.append("Converted Number Will Appear Below....\n"); 
		displayOutputArea.setEditable(false);
		
	}
	
	/**
	 * Handles all the conversion 
	 * 
	 * @param number 
	 *         the decimal number to be converted
	 * @param base
	 *        the base of number to convert
	 * @return string of a successfully converted number
	 * 
	 */
	public String baseConversion(int number, int base) {
		
		if(base == 0) {
			
			displayOutputLb.setText("Warning : Base of a number to convert to to be zero");  
			displayOutputLb.setForeground(Color.RED);
			return null;
			
		}
		
		if(base <= 1) {
			
			displayOutputLb.setText("Warning : Base of a number to convert to must be great than one");
			displayOutputLb.setForeground(Color.RED);
			return null;
		}
		
		// Informing user about the special cases
		switch (base) {
		case 2:
			displayOutputLb.setText("Converting To Binary Number");  
			break;

		case 8:
			displayOutputLb.setText("Converting To Octal Number");
			break;
			
		case 16:
			displayOutputLb.setText("Converting To HexaDecimal Number");
			break;
			
		case 10:
			displayOutputLb.setText("Converting To Decimal Number");
			break;



		default:
			break;
		}
		
		String baseValue = "";
		int nextDigit = 0;
		int[] collectionNextDigit = new int[50];  // Can hold up to 50 values of int data
		
		int i = 0;
		
		while(number > 0) {
			
			nextDigit = number % base;    // Remainder of the quotient
			
			//try {   // Handle the divide by zero exception just he
				
				number = number / base;     // The quotient
			
				collectionNextDigit[i] = nextDigit;
				
				if(number > 0) {
					i++; // Increment if and only if next digit to avoid redundant increment
				}
				
			//} catch (Exception e) {
				
				//System.err.println("Base to convert cannot be zero");

			//}
			
		}
		
		for(int x = 0; x <= i; x++) {
			
			// Handle the hexadecimal conversion
			if(base == 16) {
				switch (collectionNextDigit[i - x]) {
				case 10:
					baseValue = baseValue + "A";
					break;
					
				case 11:
					baseValue = baseValue + "B";
					break;
					
				case 12:
					baseValue = baseValue + "C";
					break;

				case 13:
					baseValue = baseValue + "D";
					break;
					
				case 14:
					baseValue = baseValue + "E";
					break;
					
				case 15:
					baseValue = baseValue + "F";
					break;
					
				default:
					
					baseValue = baseValue + collectionNextDigit[i - x];
					
					break;
					
				}
				
			} else {
				
				baseValue = baseValue + collectionNextDigit[i - x]; // Accessing digits stored from last index to 0
			}
		}
		
		return baseValue; // Returning the collection 
	}

}
