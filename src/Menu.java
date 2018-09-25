
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			int[] binaryNum = new int[1000];
			String s = textBox.getText();
	        	int n = Integer.parseInt(s);
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
	        label.setText(p);
			frame.pack();
		}
		if(combo.getSelectedItem().equals("Decimal") && combo2.getSelectedItem().equals("Hexadecimal")) {
			String s = textBox.getText();
        		int decimal = Integer.parseInt(s);
			int rem;  
		     String hex="";   
		     char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
		    while(decimal>0)  
		     {  
		       rem=decimal%16;   
		       hex=hexchars[rem]+hex;   
		       decimal=decimal/16;  
		     }  
			label.setText(hex);
			frame.pack();
		}
		if(combo.getSelectedItem().equals("Binary") && combo2.getSelectedItem().equals("Decimal")) {
			String bin = textBox.getText();
			bin = bin.trim();
			int output = 0;
			for (int i = 0; i < bin.length(); i++) {
				if(bin.charAt(i) == '1') {
					output += Math.pow(2, bin.length()-1-i);
				}
				
			}
			label.setText(output+"");
			frame.pack();
		}
		if(combo.getSelectedItem().equals("Binary") && combo2.getSelectedItem().equals("Hexadecimal")) {
			label.setText("ERROR ERROR");
			frame.pack();
		}
		if(combo.getSelectedItem().equals("Hexadecimal") && combo2.getSelectedItem().equals("Binary")) {
			String hex = textBox.getText();
			String bin = "";
		    String binFragment = "";
		    int iHex;
		    hex = hex.trim();
		    hex = hex.replaceFirst("0x", "");

		    for(int i = 0; i < hex.length(); i++){
		        iHex = Integer.parseInt(""+hex.charAt(i),16);
		        binFragment = Integer.toBinaryString(iHex);

		        while(binFragment.length() < 4){
		            binFragment = "0" + binFragment;
		        }
		        bin += binFragment;
		    }
		    label.setText(bin);
			frame.pack();
		}
		if(combo.getSelectedItem().equals("Hexadecimal") && combo2.getSelectedItem().equals("Decimal")) {
			label.setText("ERROR ERROR");
			frame.pack();
		}
	}
	public void decToBin() {
		
	}
}