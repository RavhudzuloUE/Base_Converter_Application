import javax.swing.JFrame;

import base.converter.BaseConverter;

/**
 * 
 */

/**
 * @author Ravhudzulo UE
 * @version 0.0.1
 * @see base.converter.BaseConverter
 * 
 * Launch swing application and contain main method
 */
public class Main {

	/**
	 * main method
	 * @param args
	 *      Command Line Argument
	 */
	public static void main(String[] args) {
		
		BaseConverter bCFrame = new BaseConverter();
		bCFrame.pack();
		bCFrame.setVisible(true);
		bCFrame.setSize(600, 600);
		bCFrame.setTitle("Base-Converter App");
		bCFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
