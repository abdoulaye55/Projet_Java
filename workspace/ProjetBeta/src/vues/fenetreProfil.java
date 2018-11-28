package vues;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Pojo.Admin;
import Pojo.Emprunteur;
import Pojo.Joueur;
import Pojo.Personne;
import Pojo.Preteur;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;



public class fenetreProfil extends JFrame {
	private static final long serialVersionUID = -7156833297257740915L;
	private Joueur j;
	private Personne P;
	

	private JPanel contentPane;

	public static void fenetreProfil(Joueur P) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fenetreProfil frame = new fenetreProfil(P);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public fenetreProfil(Joueur P) {
		setTitle("Votre profil");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Création des widgets nécessaires
		 */
		
		JPanel panel 				= new JPanel();
		JLabel lblNom 				= new JLabel("Nom");
		JLabel lblDBNom 			= new JLabel();
		JLabel lblPrenom 			= new JLabel("Prénom");
		JLabel lblDBPrenom 			= new JLabel();
		JLabel lblAdresse 			= new JLabel("Email");
		JLabel lblDBAdresse 		= new JLabel();
		JLabel lblPseudo 			= new JLabel("Type");
		JLabel lblDBPseudo 			= new JLabel();
		JLabel lblTypeUtilisateur 	= new JLabel("Solde");
		JLabel lblDBTypeUtilisateur = new JLabel();
		JLabel lblProfil 			= new JLabel("PROFIL");
		JButton btnPrcdent 			= new JButton("PRECEDENT");
		JButton btnDeconnexion 		= new JButton("DECONNEXION");
		JLabel lblDBDispoParticulier= new JLabel();
		
		
		lblNom.setFont				(new Font("Century Gothic", Font.BOLD, 13));
		lblDBNom.setFont			(new Font("Century Gothic", Font.PLAIN, 13));
		lblPrenom.setFont			(new Font("Century Gothic", Font.BOLD, 13));
		lblDBPrenom.setFont			(new Font("Century Gothic", Font.PLAIN, 13));
		lblAdresse.setFont			(new Font("Century Gothic", Font.BOLD, 13));
		lblDBAdresse.setFont		(new Font("Century Gothic", Font.PLAIN, 13));
		lblTypeUtilisateur.setFont	(new Font("Century Gothic", Font.BOLD, 13));
		lblDBTypeUtilisateur.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblPseudo.setFont			(new Font("Century Gothic", Font.BOLD, 13));
		lblPseudo.setFont			(new Font("Century Gothic", Font.BOLD, 13));
		lblDBPseudo.setFont			(new Font("Century Gothic", Font.PLAIN, 13));
		lblProfil.setFont			(new Font("Agency FB", Font.BOLD, 61));
		btnPrcdent.setFont			(new Font("Agency FB", Font.PLAIN, 21));
		btnDeconnexion.setFont		(new Font("Agency FB", Font.PLAIN, 21));
		lblDBDispoParticulier.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		
		panel.setBackground			(Color.WHITE);
		btnPrcdent.setBackground	(Color.WHITE);
		lblProfil.setForeground		(Color.CYAN);
		btnDeconnexion.setBackground(Color.WHITE);
		
		panel.setLayout			(null);
		
		panel.add(btnDeconnexion);
		panel.add(lblNom);
		panel.add(lblDBNom);
		panel.add(lblPrenom);
		panel.add(lblDBPrenom);
		panel.add(lblAdresse);
		panel.add(lblDBAdresse);
		panel.add(lblPseudo);
		panel.add(lblDBPseudo);
		panel.add(lblTypeUtilisateur);
		panel.add(lblDBTypeUtilisateur);
		panel.add(lblProfil);
		panel.add(btnPrcdent);
		panel.add(lblDBDispoParticulier);
		contentPane.add(panel);
		lblDBDispoParticulier.setBounds	(20, 281, 139, 14);
		lblNom.setBounds				(20, 62, 46, 14);
		lblDBNom.setBounds				(20, 78, 139, 14);
		lblPrenom.setBounds				(20, 100, 74, 14);	
		lblDBPrenom.setBounds			(20, 117, 139, 14);		
		lblAdresse.setBounds			(20, 142, 74, 14);
		lblDBAdresse.setBounds			(20, 157, 295, 17);
		lblPseudo.setBounds				(20, 179, 74, 14);
		lblDBPseudo.setBounds			(20, 196, 139, 14);
		lblTypeUtilisateur.setBounds	(20, 221, 139, 14);
		lblDBTypeUtilisateur.setBounds	(20, 237, 139, 14);
		panel.setBounds					(10, 11, 414, 405);
		lblProfil.setBounds				(10, 0, 394, 67);
		btnPrcdent.setBounds			(0, 369, 113, 36);
		btnDeconnexion.setBounds		(279, 369, 133, 36);
		
		lblProfil.setHorizontalAlignment(SwingConstants.CENTER);

		/**
		 * En premier lieu, je vérifie si le type d'utilisateur est "Client" ou "Moniteur"
		 * En second lieu, j'affiche les informations dans les labels adéquats en fonction du type.
		 */
		btnDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FenetreConnexion.main(null);
				dispose();
			}
		});
		
		btnPrcdent.addActionListener(new ActionListener() {
			private Admin admin;
			private Preteur preteur;
			private Emprunteur p;

			public void actionPerformed(ActionEvent arg0) {
				if (P.getType().equals("Admin")) {
					FenetreMenuAdmin.menuAdmin(admin);
					dispose();
				}
				else if(P.getType().equals("preteur"))
						{
					FenetreMenuPreteur.menuPreteur(preteur);
					dispose();
				}
				else
					FenetreMenuEmprunteur.menuEmprunteur(p);
				dispose();
			}
		});
				
		lblDBNom.setText(P.getNom());
		lblDBPrenom.setText(P.getPrenom());
		lblDBAdresse.setText(P.getEmail());
		lblDBPseudo.setText(P.getType());
		lblDBTypeUtilisateur.setText(Integer.toString(P.getSolde()));
		
		
		
	
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
