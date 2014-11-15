package by.bsuir.psp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;

public class Authorization {

	private JFrame frame;
	private ConnectionSQL ConSQL= null;
	private JPanel contentPane;
	
	private JTextField textFieldLogin;
	private JTextField textFieldHost;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authorization window = new Authorization();
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
	public Authorization() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 328, 235);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u041B\u043E\u0433\u0438\u043D");
		lblNewLabel.setBounds(32, 40, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u041F\u0430\u0440\u043E\u043B\u044C");
		lblNewLabel_1.setBounds(32, 78, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("LocalHost");
		lblNewLabel_2.setBounds(32, 122, 60, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(133, 37, 149, 20);
		frame.getContentPane().add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		textFieldHost = new JTextField();
		textFieldHost.setBounds(133, 119, 149, 20);
		frame.getContentPane().add(textFieldHost);
		textFieldHost.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 75, 149, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//String query = "select * from tbl where "
					ConSQL = new ConnectionSQL();
					Connection con = ConSQL.dbConnector(textFieldLogin.getText(), passwordField.getText(), textFieldHost.getText());
					if(con!=null) {
						frame.dispose();
						MainWindow mw = new MainWindow(con);
						mw.createMainWindow(mw);
					}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,  e);
					
				}
			}
		});
		btnNewButton.setBounds(176, 162, 106, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
