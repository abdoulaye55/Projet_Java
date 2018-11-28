package vues;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Metier.AdminMetier;
import Metier.EmprunteurMetier;
import Metier.PreteurMetier;
import Pojo.Admin;
import Pojo.Emprunteur;
import Pojo.Preteur;

import java.awt.SystemColor;

public class FenetreConnexion extends JFrame 
{
	private static final long serialVersionUID = 1081142014078380475L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreConnexion frame = new FenetreConnexion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FenetreConnexion() {
		setBackground(Color.WHITE);
		setTitle(" Connexion");
		setTitle("Partage de jeu");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 503);
		
		JPanel contentPane 				= new JPanel();
		JPanel panel 					= new JPanel();
		JTextField textFieldPseudo 		= new JTextField();
		JPasswordField passwordField 	= new JPasswordField();
		JLabel lblConnexion 			= new JLabel("IDENTIFIEZ-VOUS");
		lblConnexion.setBackground(Color.WHITE);
		JLabel lblPseudo 				= new JLabel("Pseudo");
		lblPseudo.setBackground(SystemColor.text);
		lblPseudo.setForeground(Color.CYAN);
		JLabel lblMdp 					= new JLabel("Mot de passe");
		lblMdp.setBackground(SystemColor.text);
		lblMdp.setForeground(Color.CYAN);
		JButton btnConnexion 			= new JButton("Connexion");
		btnConnexion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JButton btnInscription 			= new JButton("Créer un compte");
		btnInscription.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JLabel lblNouveau 				= new JLabel("NOUVEAU ?");
		
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add	(panel);
		panel.add		(textFieldPseudo);
		panel.add		(passwordField);
		panel.add		(lblConnexion);
		panel.add		(lblPseudo);
		panel.add		(lblMdp);
		panel.add		(btnConnexion);
		panel.add		(btnInscription);
		
		JLabel labelBarre2 = new JLabel("");
		labelBarre2.setOpaque(true);
		labelBarre2.setBackground(Color.WHITE);
		labelBarre2.setBounds(47, 131, 9, 44);
		panel.add(labelBarre2);
		
		JLabel labelBarre1 = new JLabel("");
		labelBarre1.setOpaque(true);
		labelBarre1.setBackground(new Color(255, 255, 255));
		labelBarre1.setBounds(59, 131, 9, 44);
		panel.add(labelBarre1);
		
		JLabel labelBarre4 = new JLabel("");
		labelBarre4.setOpaque(true);
		labelBarre4.setBackground(Color.WHITE);
		labelBarre4.setBounds(286, 131, 9, 44);
		panel.add(labelBarre4);
		
		JLabel labelBarre3 = new JLabel("");
		labelBarre3.setOpaque(true);
		labelBarre3.setBackground(Color.WHITE);
		labelBarre3.setBounds(298, 131, 9, 44);
		panel.add(labelBarre3);
		
		JLabel labelBarre5 = new JLabel("");
		labelBarre5.setOpaque(true);
		labelBarre5.setBackground(Color.WHITE);
		labelBarre5.setBounds(34, 131, 9, 44);
		panel.add(labelBarre5);
		
		JLabel labelBarre6 = new JLabel("");
		labelBarre6.setOpaque(true);
		labelBarre6.setBackground(Color.WHITE);
		labelBarre6.setBounds(311, 131, 9, 44);
		panel.add(labelBarre6);
		
		JLabel labelBarre7 = new JLabel("");
		labelBarre7.setOpaque(true);
		labelBarre7.setBackground(Color.WHITE);
		labelBarre7.setBounds(324, 135, 9, 37);
		panel.add(labelBarre7);
		
		JLabel labelBarre8 = new JLabel("");
		labelBarre8.setOpaque(true);
		labelBarre8.setBackground(Color.WHITE);
		labelBarre8.setBounds(22, 135, 9, 37);
		panel.add(labelBarre8);
		
		JLabel labelBarre9 = new JLabel("");
		labelBarre9.setOpaque(true);
		labelBarre9.setBackground(Color.WHITE);
		labelBarre9.setBounds(338, 138, 9, 29);
		panel.add(labelBarre9);
		
		JLabel labelBarre10 = new JLabel("");
		labelBarre10.setOpaque(true);
		labelBarre10.setBackground(Color.WHITE);
		labelBarre10.setBounds(8, 138, 9, 29);
		panel.add(labelBarre10);
		
		JLabel lblDff = new JLabel("");
		lblDff.setForeground(Color.CYAN);
		lblDff.setOpaque(true);
		lblDff.setBackground(Color.WHITE);
		lblDff.setBounds(70, 131, 214, 44);
		panel.add(lblDff);
		panel.add		(lblNouveau);
		
		panel.setBorder(new LineBorder(Color.WHITE, 8, true));
		panel.setBackground(Color.WHITE);
		panel.setBounds(6, -19, 363, 487);
		
		panel.setLayout(null);

		textFieldPseudo.setFont	(new Font("Tahoma", Font.PLAIN, 13));
		lblConnexion.setFont	(new Font("Agency FB", Font.BOLD, 35));
		lblPseudo.setFont		(new Font("Century Gothic", Font.BOLD, 13));
		lblMdp.setFont			(new Font("Century Gothic", Font.BOLD, 13));
		btnConnexion.setFont	(new Font("Century Gothic", Font.BOLD, 13));
		btnInscription.setFont	(new Font("Century Gothic", Font.BOLD, 13));
		lblNouveau.setFont		(new Font("Agency FB", Font.BOLD, 26));
		
		textFieldPseudo.setBounds	(22, 200, 311, 29);
		passwordField.setBounds		(22, 256, 311, 29);
		lblConnexion.setBounds		(70, 131, 214, 44);
		lblPseudo.setBounds			(22, 180, 71, 18);
		lblMdp.setBounds			(22, 231, 115, 29);
		btnInscription.setBounds	(95, 393, 161, 44);
		btnConnexion.setBounds		(95, 297, 161, 44);
		lblNouveau.setBounds		(12, 353, 335, 28);
		
		textFieldPseudo.setColumns(10);
		
		btnConnexion.setBackground	(Color.CYAN);
		btnInscription.setBackground(Color.CYAN);
		
		btnConnexion.setForeground	(new Color(255, 255, 255));
		lblConnexion.setForeground	(Color.CYAN);
		btnInscription.setForeground(new Color(255, 255, 255));
		lblNouveau.setForeground	(Color.CYAN);
		
		lblConnexion.setHorizontalAlignment	(SwingConstants.CENTER);
		lblNouveau.setHorizontalAlignment	(SwingConstants.CENTER);
		
		

		JLabel labelImage = new JLabel("");
		labelImage.setBounds(-14, 24, 391, 514);
		panel.add(labelImage);
		labelImage.setIcon(new ImageIcon("..\\ProjetTest\\img\\A.jpg"));
		
		// Partie onclick
		// On gère la connexion d'un utilisateur
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Je récupère les valeurs des textfields and passwordfields
				String email = textFieldPseudo.getText();
				String password = String.valueOf(passwordField.getPassword());

				// On appelle la méthode pour se connecter à l'application
				// recevant en le pseudo et mdp en paramètre
				// Si cela a réussi, on ferme la fenêtre connexion
				if(email.equals("") || password.equals("") )
					JOptionPane.showMessageDialog(null, "email ou mot de passe vide");
				else {
					AdminMetier adminM = new AdminMetier();
					Admin admin = adminM.connexion(email, password);
					if(admin!=null && admin.getType().equals("Admin")) {
						dispose();
						FenetreMenuAdmin.menuAdmin(admin);
					}else {
						PreteurMetier preteurM = new PreteurMetier();
						Preteur p = preteurM.connexion(email, password);
						if(p!=null && p.getType().equals("preteur")) {
							dispose();
							FenetreMenuPreteur.menuPreteur(p);
						}
						else
						{
							EmprunteurMetier EmprunteurM = new EmprunteurMetier();
							Emprunteur emp = EmprunteurM.connexion(email, password);
							if(emp!=null && emp.getType().equals("emprunteur")) {
								dispose();
								FenetreMenuEmprunteur.menuEmprunteur(emp);
							}
							else
								JOptionPane.showMessageDialog(null, "login ou mdp incorrects");
						}
						
					
							
					}
				}
				
			}
		});
		
		//On ouvre une fenêtre inscription lors d'un click button
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Ouvre la fenêtre d'inscription
				FenetreInscription.fenetreInscription();
				// dispose ferme la fenêtre
				dispose();
			}
		});	
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
