package be.diallo.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.diallo.POJO.Administrateur;
import be.diallo.POJO.Equipe;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Equipe_create extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private ButtonGroup group;
	private Equipe equipe;
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
	public Equipe_create(Administrateur A) {
		setTitle("Cr\u00E9ation Equipe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Spectateurs");
		lblNewLabel.setBounds(23, 11, 109, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Type de surface");
		lblNewLabel_2.setBounds(23, 121, 109, 27);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(168, 11, 193, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
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
		btnNewButton.setBounds(23, 210, 109, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Enregistrer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Nom = textField.getText();
				
				equipe=new Equipe(Nom);
				if(equipe.create()==true) {
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
