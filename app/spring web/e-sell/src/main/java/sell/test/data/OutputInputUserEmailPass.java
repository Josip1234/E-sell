package sell.test.data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OutputInputUserEmailPass extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	JTextArea loadedData = new JTextArea();
	JButton btnBackupButton = new JButton("Make file backup");
	String fileName="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OutputInputUserEmailPass frame = new OutputInputUserEmailPass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OutputInputUserEmailPass() {
		
		setResizable(false);
		setTitle("E-sell desktop application for saving usernames and password as test data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 811);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Welcome to the application. To load data press load button.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBackground(SystemColor.menu);
		
		JButton dload = new JButton("Load data");
		dload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 btnBackupButton.setEnabled(true);
				UserPassImpl impl = new UserPassImpl();
			
				loadedData.setText("Current data of test file:"+"\n");
				String list;
				try {
					list = impl.readData("");
					loadedData.setText("email                    |       password"+"\n");
					loadedData.setText(list.replaceAll("null", ""));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
				
				
			
			}
		});
		dload.setBackground(SystemColor.info);
		
	
		loadedData.setBackground(SystemColor.info);
		
		username = new JTextField();
		username.setBackground(SystemColor.info);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBackground(SystemColor.info);
		password.setColumns(10);
		
		JButton saveData = new JButton("Save data");
		saveData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=username.getText();
				String pwd=password.getText();
				
			    FileWriter fw;
				try {
					fw = new FileWriter("C:/Users/Korisnik/Desktop/xampp/htdocs/E-sell/files/testuserusernamesandpasswords.txt", true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    //bw.write("\n");
				    bw.write(user+"          "+pwd);
				    bw.newLine();
				    bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
				
				
			}
		});
		saveData.setBackground(SystemColor.info);
		
		JLabel lblNewLabel_1 = new JLabel("Add new username:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBackground(SystemColor.info);
		
		JLabel lblNewLabel_2 = new JLabel("Add new password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBackground(SystemColor.info);
		

		btnBackupButton.setEnabled(false);
		btnBackupButton.setBackground(SystemColor.info);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(273)
					.addComponent(saveData, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(306, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(78)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(loadedData, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(username, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
										.addComponent(password, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))))
							.addGap(57))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(dload, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBackupButton, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnBackupButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(dload, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
					.addGap(48)
					.addComponent(loadedData, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(username, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(saveData, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
