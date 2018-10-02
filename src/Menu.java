
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu implements ActionListener {
	JFrame frame;
	JComboBox<String> combo;
	JComboBox<String> combo2;
	JButton button;
	JLabel label;
	JTextField textBox;
	public Menu(Binary bin, Hexadecimal hex, Decimal dec) {
		frame = new JFrame();
		JPanel panel = new JPanel();
		combo = new JComboBox<>();
		combo.addItem("Decimal");
		combo.addItem("Hexadecimal");
		combo.addItem("Binary");
		combo2 = new JComboBox<>();
		combo2.addItem("Decimal");
		combo2.addItem("Hexadecimal");
		combo2.addItem("Binary");
		button = new JButton("    convert    ");
		label = new JLabel();
		textBox = new JTextField(9);
		frame.add(panel);
		panel.add(textBox);
		panel.add(combo);
		panel.add(combo2);
		panel.add(button);
		panel.add(label);
		frame.pack();
		frame.setVisible(true);
		button.addActionListener(this);
	}

	public void display() {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(combo.getSelectedItem().equals("Decimal") && combo2.getSelectedItem().equals("Decimal")) {
			label.setText(textBox.getText());
			frame.pack();
		}
		if(combo.getSelectedItem().equals("Hexadecimal") && combo2.getSelectedItem().equals("Hexadecimal")) {
			label.setText(textBox.getText());
			frame.pack();
		}
		if(combo.getSelectedItem().equals("Binary") && combo2.getSelectedItem().equals("Binary")) {
			label.setText(textBox.getText());
			frame.pack();
		}
		if(combo.getSelectedItem().equals("Decimal") && combo2.getSelectedItem().equals("Binary")) {
			label.setText(decToBin(textBox.getText()));
			frame.pack();
		}
		if(combo.getSelectedItem().equals("Decimal") && combo2.getSelectedItem().equals("Hexadecimal")) {		
			label.setText(decToHex(textBox.getText()));
			frame.pack();
		}
		if(combo.getSelectedItem().equals("Binary") && combo2.getSelectedItem().equals("Decimal")) {
			label.setText(binToDec(textBox.getText()));
			frame.pack();
		}
		if(combo.getSelectedItem().equals("Binary") && combo2.getSelectedItem().equals("Hexadecimal")) { 
			// Binary to hexadecimal
			/* DO THIS: Bin -> Dec -> Hex */
			try {
				int binaryNumber = Integer.parseInt(textBox.getText());
				// This is now in an integer which should be changed into a set of numbers, each with a length of four
				// Split the binary like this 110110010 (1) (1011) (0010)
				// Then, convert the numbers into normal, which is (1) (11) (2)
				// Then, convert those numbers into hex, which becomes (1) (B) (2) = 1B2
				int length = textBox.getText().length();
				System.out.println("Received number " + binaryNumber + " with amount of digits " + length);
				// Find the modulo and add 4 - modulo zeros to the number
				// Make sure that if it begins with "0000" we don't multiply it by 0
				
			}
			catch (Exception exception) {
				label.setText("There was an error when trying to convert your number. Are you sure that it was in binary?");
			}
			finally {
				frame.pack();
			}
			label.setText(decToHex(binToDec(textBox.getText())));
			frame.pack();
		}
		if(combo.getSelectedItem().equals("Hexadecimal") && combo2.getSelectedItem().equals("Binary")) {
		    label.setText(hexToBin(textBox.getText()));
			frame.pack();
		}
		if(combo.getSelectedItem().equals("Hexadecimal") && combo2.getSelectedItem().equals("Decimal")) {
			label.setText(""+hexToDec(textBox.getText()));
			frame.pack();
		}
	}

	public String decToBin(String str) {
		int[] binaryNum = new int[1000];
        	int n = Integer.parseInt(str);
        int i = 0;
        while (n > 0) 
        {
            binaryNum[i] = n % 2;
            n = n / 2;
            i++;
        }
        String[] output = new String[1000];
        for(int m = 0; m < binaryNum.length; m++) {
        		output[m] = binaryNum[m]+"";
        }
        String p = "";
        for (int j = i - 1; j >= 0; j--) {
        		p += output[j];
        }
		return p;
	}
	public String decToHex(String str) {
		int decimal = Integer.parseInt(str);
		int rem;  
		String hex="";   
		char hexNums[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
		while(decimal>0) {  
			rem=decimal%16;   
			hex=hexNums[rem]+hex;   
			decimal=decimal/16;
		} 
		return hex;
	}
	public String binToDec(String str) {
		str = str.trim();
		int output = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '1') {
				output += Math.pow(2, str.length()-1-i);
			}
			
		}
		return output + "";
	}
	public String hexToBin(String str) {
		String bin = "";
	    String binFragment = "";
	    int iHex;
	    str = str.trim();
	    str = str.replaceFirst("0x", "");

	    for(int i = 0; i < str.length(); i++){
	        iHex = Integer.parseInt(""+str.charAt(i),16);
	        binFragment = Integer.toBinaryString(iHex);

	        while(binFragment.length() < 4){
	            binFragment = "0" + binFragment;
	        }
	        bin += binFragment;
	    }
	    return bin;
	}
	public int hexToDec(String str) {
		String s = textBox.getText();
		String digits = "0123456789ABCDEF";
        s = s.toUpperCase();
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;

	}
	
}