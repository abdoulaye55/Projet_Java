package be.diallo.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import be.diallo.POJO.Administrateur;

import be.diallo.POJO.Joueur;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

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


public class Connexion extends JFrame {

	//Variables des elements graphique
	private JPanel contentPane;
	private JLabel lblPseudo;
	private JTextField txtPseudo;
	private JLabel lblMp;
	private JPasswordField txtMp;
	private JRadioButton rdbtnJoueur;
	private JRadioButton rdbtnAdmin;
	private JButton btnRetour;
	private JButton btnValider;
	private ButtonGroup group;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Connexion frame = new Connexion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Creation de la frame
		public Connexion() {
			setBackground(Color.WHITE);
			setTitle(" Connexion");
			setTitle("Partage de jeu");
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 381, 503);
			
			JPanel contentPane 				= new JPanel();
			JPanel panel 					= new JPanel();
			JTextField txtPseudo		= new JTextField();
			JPasswordField txtMp	= new JPasswordField();
			JLabel lblConnexion 			= new JLabel("IDENTIFIEZ-VOUS");
			lblConnexion.setBackground(Color.WHITE);
			JLabel lblPseudo 				= new JLabel("Pseudo");
			lblPseudo.setBackground(SystemColor.text);
			
			JLabel lblMdp 					= new JLabel("Mot de passe");
			lblMdp.setBackground(SystemColor.text);
			
			rdbtnJoueur = new JRadioButton("Joueur");
			rdbtnJoueur.setSelected(true);
			rdbtnJoueur.setBounds(29, 95, 109, 23);
			rdbtnJoueur.setBackground(SystemColor.text);
			
			contentPane.add(rdbtnJoueur);
			
			//radio admin
			rdbtnAdmin = new JRadioButton("Administrateur");
			rdbtnAdmin.setBounds(173, 95, 126, 23);
			rdbtnAdmin.setBackground(SystemColor.text);
			
			contentPane.add(rdbtnAdmin);
			
		//Group the radio buttons.
	        group = new ButtonGroup();
	        group.add(rdbtnJoueur);
	        group.add(rdbtnAdmin);
	    
			
			
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
			panel.add		(txtPseudo);
			panel.add		(txtMp);
			panel.add		(lblConnexion);
			panel.add		(lblPseudo);
			panel.add		(lblMdp);
			panel.add		(btnConnexion);
			panel.add		(btnInscription);
			panel.add(rdbtnAdmin);
			panel.add(rdbtnJoueur);
			
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
			
			lblDff.setOpaque(true);
			lblDff.setBackground(Color.WHITE);
			lblDff.setBounds(70, 131, 214, 44);
			panel.add(lblDff);
			panel.add		(lblNouveau);
			
			panel.setBorder(new LineBorder(Color.WHITE, 8, true));
			panel.setBackground(Color.WHITE);
			panel.setBounds(6, -19, 363, 487);
			
			panel.setLayout(null);

			txtPseudo.setFont	(new Font("Tahoma", Font.PLAIN, 13));
			lblConnexion.setFont	(new Font("Agency FB", Font.BOLD, 35));
			lblPseudo.setFont		(new Font("Century Gothic", Font.BOLD, 13));
			lblMdp.setFont			(new Font("Century Gothic", Font.BOLD, 13));
			btnConnexion.setFont	(new Font("Century Gothic", Font.BOLD, 13));
			btnInscription.setFont	(new Font("Century Gothic", Font.BOLD, 13));
			lblNouveau.setFont		(new Font("Agency FB", Font.BOLD, 26));
			
			txtPseudo.setBounds	(22, 200, 311, 29);
			txtMp.setBounds		(22, 256, 311, 29);
			lblConnexion.setBounds		(70, 131, 214, 44);
			lblPseudo.setBounds			(22, 180, 71, 18);
			lblMdp.setBounds			(22, 231, 115, 29);
			btnInscription.setBounds	(95, 393, 161, 44);
			btnConnexion.setBounds		(95, 297, 161, 44);
			lblNouveau.setBounds		(12, 353, 335, 28);
			
			txtPseudo.setColumns(10);
			
			btnConnexion.setBackground	(Color.GRAY);
			btnInscription.setBackground(Color.GRAY);
			
			btnConnexion.setForeground	(new Color(255, 255, 255));
			
			btnInscription.setForeground(new Color(255, 255, 255));
			
			
			lblConnexion.setHorizontalAlignment	(SwingConstants.CENTER);
			lblNouveau.setHorizontalAlignment	(SwingConstants.CENTER);
			

			JLabel labelImage = new JLabel("");
			labelImage.setBounds(-14, -5, 391, 500);
			panel.add(labelImage);
			
			
			// Partie onclick
			// On gère la connexion d'un utilisateur
			btnValider = new JButton("Valider");
			btnConnexion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					String pseudo = txtPseudo.getText();
					String mp = txtMp.getText().toString();
					
					if(!pseudo.isEmpty() && !mp.isEmpty())
					{
						if(rdbtnJoueur.isSelected())
						{
							try
							{
								Joueur joueur = Joueur.Verif(pseudo, mp);
								if(joueur.GetPseudo() != null) 
								{
									
									
									HomeJoueur p = new HomeJoueur(joueur);
									p.setVisible(true);
									dispose();
								}
								else
									JOptionPane.showMessageDialog(rootPane, "Pseudo/MP invalide", "Erreur : ", JOptionPane.ERROR_MESSAGE);
							}
							catch(Exception err)
							{
								System.out.println(err);
							}
						}
						else if(rdbtnAdmin.isSelected())
						{
							try
							{
								Administrateur admin = Administrateur.Verif(pseudo, mp);
								if(admin.GetPseudo() != null) 
								{
									HomeAdmin p = new HomeAdmin(admin);
									p.setVisible(true);
									dispose();
								}
								else
									JOptionPane.showMessageDialog(rootPane, "Pseudo/MP invalide", "Erreur : ", JOptionPane.ERROR_MESSAGE);
							}
							catch(Exception err)
							{
								System.out.println(err);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(rootPane, "Veuillez choisir un type de personne", "Erreur : ", JOptionPane.ERROR_MESSAGE);
						}
					}
					else
						JOptionPane.showMessageDialog(rootPane, "Erreur d'encodage dans le formulaire", "Erreur : ", JOptionPane.ERROR_MESSAGE);
				}
				
			});
			
			//On ouvre une fenêtre inscription lors d'un click button
			btnInscription.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// Ouvre la fenêtre d'inscription
					Inscription inscritption=new Inscription();
					inscritption.setVisible(true);
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
