package by.bsuir.psp;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

public class MainWindow {

	Connection connector = null;
	private JFrame frame;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JScrollPane scrollPane;
	private ButtonGroup btngroup = new ButtonGroup();
	
	private JRadioButton rdbtnReader = new JRadioButton("Table Reader");
	private JRadioButton rdbtnReadingBook = new JRadioButton("Table Reading book");
	
	private JLabel lblNewLabel_1 = new JLabel("");
	private JLabel lblNewLabel_2 = new JLabel("");	
	private JLabel lblNewLabel_3 = new JLabel("");	
	private JLabel lblNewLabel_4 = new JLabel("");
	
	public void refresh(String qur){
		try{
			String query = qur;
			PreparedStatement pst = connector.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 */
	public void createMainWindow(final MainWindow window) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//MainWindow window = new MainWindow();
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
	public MainWindow(Connection connector) {
		this.connector = connector;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 627, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		btngroup.add(rdbtnReader);
		btngroup.add(rdbtnReadingBook);
		rdbtnReader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnReader.isSelected()){
					lblNewLabel_1.setText("Number reader ticket");
					lblNewLabel_2.setText("Surname reader");
					lblNewLabel_3.setText("Name reader");
					lblNewLabel_4.setText("Lastname reader");
					try {
						String query = "select * from reader";
						PreparedStatement pst = connector.prepareStatement(query);
						ResultSet rs= pst.executeQuery(query);
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			}
		});
		
		rdbtnReader.setBounds(6, 346, 109, 23);
		frame.getContentPane().add(rdbtnReader);
		rdbtnReadingBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnReadingBook.isSelected()){
					lblNewLabel_1.setText("Number book");
					lblNewLabel_2.setText("Number reader ticket");
					lblNewLabel_3.setText("Name book");
					lblNewLabel_4.setText("Name author");
					try{
						String query="select * from reading_book";
						PreparedStatement pst=connector.prepareStatement(query);
						ResultSet rs= pst.executeQuery(query);
						table.setModel(DbUtils.resultSetToTableModel(rs));
				    } catch (Exception e) {
				    	e.printStackTrace();
				  }
				}
			}
		});
		
		rdbtnReadingBook.setBounds(6, 372, 139, 23);
		frame.getContentPane().add(rdbtnReadingBook);
		
		lblNewLabel_1.setBounds(10, 23, 93, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2.setBounds(10, 68, 93, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3.setBounds(10, 112, 93, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4.setBounds(10, 158, 93, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(187, 22, 414, 400);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 37, 139, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 81, 139, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 127, 139, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 171, 139, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Add record");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nameTable = null;
				String refreshTable = null;
				if(rdbtnReader.isSelected()){
					nameTable = new String("insert into reader (number_reader_ticket, sur_name, name, last_name) values (?, ?, ?, ?)");
					refreshTable = new String("select * from reader");
				}
				if(rdbtnReadingBook.isSelected()){
					nameTable = new String("insert into reading_book (number_book, number_reader_ticket, name_book, name_author) values (?, ?, ?, ?)");
					refreshTable = new String("select * from reading_book");
				}
				try {
					PreparedStatement pst = connector.prepareStatement(nameTable);
					pst.setString(1, textField_1.getText());
					pst.setString(2, textField_2.getText());
					pst.setString(3, textField_3.getText());
					pst.setString(4, textField_4.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Saved");
					pst.close();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Неверный ввод.");
						ex.printStackTrace();
					}
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				refresh(refreshTable);
			}
		});
		btnNewButton_2.setBounds(10, 211, 139, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete record");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nameTable = null;
				String refreshTable = null;
				if(rdbtnReader.isSelected()){
					refreshTable = new String("select * from reader");
					try {
						PreparedStatement pst = connector.prepareStatement("delete from reading_book where number_reader_ticket = '"+textField_1.getText()+"'");
						pst.execute();
						pst = connector.prepareStatement("delete from reader where number_reader_ticket = '"+textField_1.getText()+"'");
						pst.execute();
						JOptionPane.showMessageDialog(null, "Data Delete");
						pst.close();
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "Неверный ввод.");
							ex.printStackTrace();
						}
				}
				if(rdbtnReadingBook.isSelected()){
					refreshTable = new String("select * from reading_book");
					try {
						PreparedStatement pst = connector.prepareStatement("delete from reading_book where number_book = '"+textField_1.getText()+"'");
						pst.execute();
						JOptionPane.showMessageDialog(null, "Data Delete");
						pst.close();
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "Неверный ввод.");
							ex.printStackTrace();
					}
			    }
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				refresh(refreshTable);
			}
		});
		btnNewButton_3.setBounds(10, 245, 139, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Change record");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nameTable = null;
				String refreshTable = null;
				if(rdbtnReader.isSelected()){
					nameTable = new String("Update reader set number_reader_ticket = '"+textField_1.getText()+"', sur_name = '"+textField_2.getText()+"',"
							+ " name = '"+textField_3.getText()+"', last_name = '"+textField_4.getText()+"' where number_reader_ticket='"+textField_1.getText()+"'");
					refreshTable = new String("select * from reader");
				}
				if(rdbtnReadingBook.isSelected()){
					nameTable = new String("Update reading_book set number_book= '"+textField_1.getText()+"', number_reader_ticket = '"+textField_2.getText()+"',"
							+ " name_book = '"+textField_3.getText()+"', name_author = '"+textField_4.getText()+"' where number_book='"+textField_1.getText()+"'");
					refreshTable = new String("select * from reading_book");
				}
				try {
					PreparedStatement pst = connector.prepareStatement(nameTable);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Неверный ввод.");
					ex.printStackTrace();
				}
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				refresh(refreshTable);
			}
		});
		btnNewButton_4.setBounds(10, 279, 139, 23);
		frame.getContentPane().add(btnNewButton_4);		
	}
}

