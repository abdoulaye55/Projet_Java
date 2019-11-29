package be.diallo.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.diallo.POJO.Administrateur;
import be.diallo.POJO.Tournoi;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tournoi_create extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Tournoi tournoi;

	/**
	 * Launch the application.
	 */
	public static void main(Administrateur A) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tournoi_create frame = new Tournoi_create(A);
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
	public Tournoi_create(Administrateur A) {
		setTitle("Cr\u00E9ation Tournoi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(25, 29, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prix");
		lblNewLabel_1.setBounds(25, 108, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(165, 19, 237, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(165, 98, 237, 35);
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
		btnNewButton.setBounds(10, 204, 129, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Enregistrer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Je récupère les infos des textfields
				 */
				String Nom = textField.getText();
				String Descriptif= textField_1.getText();
				tournoi =new Tournoi(Nom,Integer.parseInt(Descriptif));
				//J'appelle la méthode inscription recevant en paramètre tous les éléments nécessaires à l'inscription d'un utilisateur
				if(tournoi.create()==true) {
					dispose();
					HomeAdmin p = new HomeAdmin(A);
					p.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_1.setBounds(295, 204, 129, 46);
		contentPane.add(btnNewButton_1);
	}

}
