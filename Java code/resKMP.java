import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.lang3.RandomStringUtils;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import javax.swing.JTextArea;

public class resKMP {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					resKMP window = new resKMP();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public resKMP() {
		initialize();
	}
	  public int  KMPSearch(String p, String S) {
		  		int c=0;
				int m = p.length(); 
				int n = S.length(); 

				// creating lps array
				int lps[] = new int[m]; 
				int j = 0; 

				// finding prefix table
				computeLPSArray(p, m, lps); 

				int i = 0;  
				while (i < n) { 
					if (p.charAt(j) == S.charAt(i)) { 
						j++; 
						i++; 
					} 
					if (j == m) { 
						System.out.println("Pattern found at location: "+ (i - j)); 
						j = lps[j - 1]; c++;
					} 

					// mismatch case 
					else if (i < n && p.charAt(j) != S.charAt(i)) { 
						// Skip matching lps[0..lps[j-1]] characters 
						
						if (j != 0) 
							j = lps[j - 1]; 
						else
							i = i + 1; 
					} 
				} 
	
		    	return c;
		    }
		 
		     void computeLPSArray(String pat, int M, int lps[])
		    {
		        // length of the previous longest prefix suffix
		        int len = 0;
		        int i = 1;
		        lps[0] = 0; // lps[0] is always 0
		 
		        // the loop calculates lps[i] for i = 1 to M-1
		        while (i < M) {
		            if (pat.charAt(i) == pat.charAt(len)) {
		                len++;
		                lps[i] = len;
		                i++;
		            }
		            else // (pat[i] != pat[len])
		            {
		                // This is tricky. Consider the example.
		                // AAACAAAA and i = 7. The idea is similar
		                // to search step.
		                if (len != 0) {
		                    len = lps[len - 1];
		 
		                    // Also, note that we do not increment
		                    // i here
		                }
		                else // if (len == 0)
		                {
		                    lps[i] = len;
		                    i++;
		                }
		            }
		        }
		    }
	
	private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 646, 574);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(10, 10, 612, 517);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Enter a pattern");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(10, 70, 140, 34);
			panel_1.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(160, 73, 273, 34);
			panel_1.add(textField);
			textField.setColumns(10);
			
			JButton btnNewButton = new JButton("Size of the text");
			JLabel lblNumberOfOccerce = new JLabel("Number of occurrences");
			lblNumberOfOccerce.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNumberOfOccerce.setBounds(10, 407, 172, 34);
			panel_1.add(lblNumberOfOccerce);
			
			JLabel lblTheRandomText = new JLabel("The random text");
			lblTheRandomText.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblTheRandomText.setBounds(10, 223, 140, 34);
			panel_1.add(lblTheRandomText);
			
			JLabel lblTimeRequire = new JLabel("Time require");
			lblTimeRequire.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblTimeRequire.setBounds(10, 329, 172, 34);
			panel_1.add(lblTimeRequire);
			
			JTextArea textArea = new JTextArea();
			textArea.setBounds(160, 230, 415, 34);
			panel_1.add(textArea);
			JTextArea textArea_1 = new JTextArea();
			textArea_1.setBounds(160, 336, 197, 34);
			panel_1.add(textArea_1);
			
			JTextArea textArea_1_1 = new JTextArea();
			textArea_1_1.setBounds(213, 414, 197, 34);
			panel_1.add(textArea_1_1);
			btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {   
					int i=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter size of the text"));
					String pat=textField.getText();
					String text;
					text = RandomStringUtils.randomAlphanumeric(i);
					textArea.append(text);
					long st=System.nanoTime();
					KMPSearch(pat,text);
					long end =System.nanoTime()-st;
					String m=String.valueOf(end); 
					String s=String.valueOf(KMPSearch(pat,text));
					System.out.println(KMPSearch(pat,text));
					textArea_1.append(m);
					textArea_1_1.append(s);
	 		
		
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton.setBounds(200, 135, 140, 21);
			panel_1.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Close");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnNewButton_1.setBounds(497, 479, 105, 28);
			panel_1.add(btnNewButton_1);
			
			JButton btnNewButton_1_1 = new JButton("Back to menu");
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI2.main(null);
				}
			});
			btnNewButton_1_1.setBounds(382, 479, 105, 28);
			panel_1.add(btnNewButton_1_1);
			
		
			
			JButton btnNewButton_2 = new JButton("Back to menu");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI2 gff= new GUI2();
					
					
				}
			});
	}
}
