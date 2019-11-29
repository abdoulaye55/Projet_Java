package be.diallo.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import be.diallo.POJO.Administrateur;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class HomeAdmin extends JFrame {

	//Variables des elements graphique
	private JPanel contentPane;
	private JButton btnGestionUtilisateur;
	private JButton btnProfil;
	private JButton btnGestionJeux;
	private JButton btnDeconnexion;

	//Creation de la frame
	public HomeAdmin(Administrateur admin) {
		setTitle("Votre menu");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 323);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 466, 274);
		contentPane.add(panel);
		panel.setLayout(null);
		JButton btnQuitter 			= new JButton("Quitter");
		 

		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setOrientation(SwingConstants.VERTICAL);
		toolBar.setForeground(Color.BLACK);
		toolBar.setBorder(null);
		toolBar.setBounds(0, 6, 472, 262);
		toolBar.setBackground(Color.WHITE);
		panel.add(toolBar);
		toolBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		toolBar.setFont(new Font("Century Gothic", Font.PLAIN, 25));

		JButton btnGestionUtilisateur = new JButton("Gestion des Utilisateurs");
		btnGestionUtilisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Utilisateur_Gestion p = new Utilisateur_Gestion(admin);
				p.setVisible(true);
				dispose();
			}
		});
		btnGestionUtilisateur.setBackground(Color.WHITE);
		btnGestionUtilisateur.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnGestionUtilisateur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toolBar.add(btnGestionUtilisateur);
		toolBar.add(btnGestionUtilisateur);
		
		JButton btnProfil = new JButton("Voir Profil");
		btnProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Profil_Admin p = new Profil_Admin(admin);
				p.setVisible(true);
				dispose();
			}
		});
		btnProfil.setBackground(Color.WHITE);
		btnProfil.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnProfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toolBar.add(btnProfil);
		toolBar.add(btnProfil);
		
		JButton btnGestionJeux = new JButton("Gestion des Tournois");
		btnGestionJeux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tournoi_create p = new Tournoi_create(admin);
				p.setVisible(true);
				dispose();
				
			}
		});
		
		btnGestionJeux.setBackground(Color.WHITE);
		btnGestionJeux.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnGestionJeux.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toolBar.add(btnGestionJeux);
		toolBar.add(btnGestionJeux);
		
		JButton btnGestionOrdo = new JButton("Gestion des Ordonnancement");
		btnGestionOrdo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ordonnancement_create p = new Ordonnancement_create(admin);
				p.setVisible(true);
				dispose();
				
			}
		});
		
		btnGestionOrdo.setBackground(Color.WHITE);
		btnGestionOrdo.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnGestionOrdo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toolBar.add(btnGestionOrdo);
		toolBar.add(btnGestionOrdo);
		JButton btnGestionEquipe = new JButton("Gestion des Equipes");
		btnGestionEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Equipe_create p = new Equipe_create(admin);
				p.setVisible(true);
				dispose();
				
			}
		});
		btnGestionEquipe.setBackground(Color.WHITE);
		btnGestionEquipe.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnGestionEquipe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toolBar.add(btnGestionEquipe);
		toolBar.add(btnGestionEquipe);
		
		JButton btnResultat = new JButton("Ajouter Résultat du match");
		btnResultat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Resultat_match p = new Resultat_match(admin);
				p.setVisible(true);
				dispose();
			}
		});
		btnResultat.setBackground(Color.WHITE);
		btnResultat.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnResultat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toolBar.add(btnResultat);
		toolBar.add(btnResultat);
		
		JButton Ajoutconsole = new JButton("Ajouter une Court");
		Ajoutconsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Court_create p = new Court_create(admin);
				p.setVisible(true);
				dispose();
				
			}
		});
		
		
		Ajoutconsole.setBackground(Color.WHITE);
		Ajoutconsole.setFont(new Font("Century Gothic", Font.BOLD, 15));
		Ajoutconsole.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toolBar.add(Ajoutconsole);
		toolBar.add(Ajoutconsole);
		
		JButton btnSeDeco = new JButton("Se d\u00E9connecter");
		btnSeDeco.setBackground(Color.WHITE);
		btnSeDeco.setFont(new Font("Century Gothic", Font.BOLD, 15));
		toolBar.add(btnSeDeco);
		
		btnQuitter.setBackground(Color.WHITE);
		btnQuitter.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnQuitter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toolBar.add(btnQuitter);
		
		btnSeDeco.addActionListener(e -> {
			Connexion p = new Connexion();
			p.setVisible(true);
			dispose();
		});
		btnQuitter.addActionListener(e -> System.exit(0));
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
