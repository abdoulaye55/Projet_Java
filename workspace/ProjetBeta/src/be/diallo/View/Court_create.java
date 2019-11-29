package be.diallo.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.diallo.POJO.Administrateur;
import be.diallo.POJO.Court;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Court_create extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private ButtonGroup group;
	private Court court;
	/**
	 * Launch the application.
	 */
	public static void main(Administrateur A) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Court_create frame = new Court_create(A);
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
	public Court_create(Administrateur A) {
		setTitle("Cr\u00E9ation Court");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Spectateurs");
		lblNewLabel.setBounds(23, 11, 109, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Assurance");
		lblNewLabel_1.setBounds(23, 80, 109, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Type de surface");
		lblNewLabel_2.setBounds(23, 121, 109, 27);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(168, 11, 193, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Couvert");
		rdbtnNewRadioButton.setBounds(129, 80, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Non-couvert");
		rdbtnNewRadioButton_1.setBounds(301, 80, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		//Group the radio buttons.
	    group = new ButtonGroup();
	    group.add(rdbtnNewRadioButton);
	    group.add(rdbtnNewRadioButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 119, 193, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Pr\u00E9c\u00E9dent");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				HomeAdmin p = new HomeAdmin(A);
				p.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 210, 109, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Enregistrer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean d = rdbtnNewRadioButton.isSelected();
				String Nom = textField.getText();
				String Descriptif= textField_1.getText();
				court=new Court(Integer.parseInt(Nom),d,Descriptif);
				if(court.create()==true) {
					dispose();
					HomeAdmin p = new HomeAdmin(A);
					p.setVisible(true);
					dispose();
				}
				
				
			}
		});
		btnNewButton_1.setBounds(320, 210, 104, 40);
		contentPane.add(btnNewButton_1);
	}
}
