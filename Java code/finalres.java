import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JTextField;

import org.apache.commons.lang3.RandomStringUtils;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class finalres {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					finalres window = new finalres();
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
	public finalres() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
			public int stringSearch(String T, String P) {
				 int i, j, m, n,C;
				 C=0;
			      n = T.length();
			      m = P.length();
			      i = 0;
			      j = 0;

			      for ( i = 0; i < n-m; i++ )
			      {
			         if ( P.equals( T.substring(i, i+m) )  )
			         {
			          C++;     
			         }
			      }

			      return C;
			   }
			public void actionPerformed(ActionEvent e) {   
				int i=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter size of the text"));
				String pat=textField.getText();
				String text;
				text = RandomStringUtils.randomAlphanumeric(i);
				textArea.append(text);
				long st=System.nanoTime();
				stringSearch(text, pat);
				long end =System.nanoTime()-st;
				String m=String.valueOf(end); 
				String s=String.valueOf(stringSearch(text, pat)); 
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
