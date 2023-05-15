import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class GUI2 {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI2 window = new GUI2();
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
	public GUI2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBackground(UIManager.getColor("Button.light"));
		frame.setBounds(100, 100, 439, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHOOSE ALGORITHM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(83, 10, 242, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Brute force"); 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				finalres.main(null);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(140, 108, 136, 42);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnKmp = new JButton("KMP");
		btnKmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resKMP.main(null);
			}
		});
		btnKmp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKmp.setBounds(140, 224, 136, 42);
		frame.getContentPane().add(btnKmp);
		
		JButton btnBoyerMoores = new JButton("Boyer moore");
		btnBoyerMoores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resBM.main(null);
			}
		});
		btnBoyerMoores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBoyerMoores.setBounds(140, 329, 136, 42);
		frame.getContentPane().add(btnBoyerMoores);
	}
}


