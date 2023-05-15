import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.commons.lang3.RandomStringUtils;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.AbstractDocument.Content;

public class resBM {

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
					resBM window = new resBM();
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
	static int NO_OF_CHARS = 256;

	// A utility function to get maximum of two integers
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// The preprocessing function for Boyer Moore's
	// bad character heuristic
	static void badCharHeuristic(String string, int size, int badchar[]) {

		// Initialize all occurrences as -1
		for (int i = 0; i < NO_OF_CHARS; i++)
			badchar[i] = -1;

		// Fill the actual value of last occurrence
		// of a character (indices of table are ascii and values are index of
		// occurrence)
		for (int i = 0; i < size; i++)
			badchar[(int) string.charAt(i)] = i;
	}

	/*
	 * A pattern searching function that uses Bad Character Heuristic of Boyer Moore
	 * Algorithm
	 */
	static int Boyer_Moores(String text, String string) {
		int c = 0;
		int m = string.length();
		int n = text.length();

		int badchar[] = new int[NO_OF_CHARS];

		/*
		 * Fill the bad character array by calling the preprocessing function
		 * badCharHeuristic() for given pattern
		 */
		badCharHeuristic(string, m, badchar);

		int s = 0; // s is shift of the pattern with
					// respect to text
		// there are n-m+1 potential alignments
		while (s <= (n - m)) {
			int j = m - 1;

			/*
			 * Keep reducing index j of pattern while characters of pattern and text are
			 * matching at this shift s
			 */
			while (j >= 0 && string.charAt(j) == text.charAt(s + j))
				j--;

			/*
			 * If the pattern is present at current shift, then index j will become -1 after
			 * the above loop
			 */
			if (j < 0) {
				c++;
				s += (s + m < n) ? m - badchar[text.charAt(s + m)] : 1;

			}

			else

				s += max(1, j - badchar[text.charAt(s + j)]);
		}
		return c;
	}

	public resBM() {
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

			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter size of the text"));
				String pat = textField.getText();
				String text;
				text = RandomStringUtils.randomAlphanumeric(i);
				textArea.append(text);
				long st = System.nanoTime();
				Boyer_Moores(text, pat);
				long end = System.nanoTime() - st;
				String m = String.valueOf(end);
				String s = String.valueOf(Boyer_Moores(text, pat));
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
				GUI2 window = new GUI2();
				window.frame.setVisible(true);
				
			}
		});
		btnNewButton_1_1.setBounds(382, 479, 105, 28);
		panel_1.add(btnNewButton_1_1);

		
		
	}
}
