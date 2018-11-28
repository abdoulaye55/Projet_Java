package vues;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Metier.ConsoleMetier;
import Pojo.Admin;



public class fenetreAjoutConsole extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ConsoleMetier c 	= new ConsoleMetier();
	

	/**
	 * Launch the application.
	 */
	public static void fenetreAjoutConsole(Admin A) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fenetreAjoutConsole frame = new fenetreAjoutConsole(A);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public fenetreAjoutConsole(Admin A) {
		setTitle("Ajouter un jeu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 481);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/**
		 * Pour l'utilisation d'un datepicker (date de naissance de l'élève)
		 */
		
		
		JPanel panel 				= new JPanel();
		JLabel labelAjouterEleve 	= new JLabel("AJOUTER UN JEU");
		JLabel lblNom 				= new JLabel("Nom");
		JLabel lblAdresse 			= new JLabel("Descriptif");
		JTextField textFieldAdresse = new JTextField();
		JTextField textFieldNom 	= new JTextField();
		@SuppressWarnings("unused")
		ButtonGroup btnGroup		= new ButtonGroup();
		JButton btnPrecedent 		= new JButton("Précédent");
		JButton btnValider 			= new JButton("Valider");
		
		
		
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel.setBounds				(10, 11, 414, 420);
		labelAjouterEleve.setBounds	(66, 5, 281, 56);
		lblNom.setBounds			(23, 70, 137, 14);
		lblAdresse.setBounds		(23, 127, 137, 14);
		textFieldNom.setBounds		(23, 86, 175, 30);
		textFieldAdresse.setBounds	(23, 144, 253, 76);
		btnValider.setBounds		(293, 374, 115, 46);
		btnPrecedent.setBounds		(6, 374, 115, 46);
		
		
		
		panel.add(labelAjouterEleve);
		panel.add(lblNom);
		panel.add(lblAdresse);
		panel.add(textFieldNom);
		panel.add(textFieldAdresse);
		panel.add(btnValider);
		panel.add(btnPrecedent);
		btnPrecedent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					
					FenetreMenuAdmin.menuAdmin(A);
				dispose();	
			}
		});
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Je récupère les infos des textfields
				 */
				String Nom = textFieldNom.getText();
				String Descriptif= textFieldAdresse.getText();
				//J'appelle la méthode inscription recevant en paramètre tous les éléments nécessaires à l'inscription d'un utilisateur
				if(c.create(Nom,Descriptif)==1) {
					dispose();
					FenetreMenuAdmin.menuAdmin(null);
				}
			}
		});
	}
}
		
		
		