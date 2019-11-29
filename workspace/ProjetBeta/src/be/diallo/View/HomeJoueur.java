package be.diallo.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import be.diallo.POJO.Joueur;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class HomeJoueur extends JFrame {

	//Creation de la frame
	public HomeJoueur(Joueur joueur) {
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

		JButton btnResGestion = new JButton("Voir Résultat des matchs");
		btnResGestion.addActionListener(e -> {
			//FenetreProfil.fenetreProfil(pseudo);
			Resultat_match2 p = new Resultat_match2(joueur);
			p.setVisible(true);
			dispose();
		});
		
		btnResGestion.setBackground(Color.WHITE);
		btnResGestion.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnResGestion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toolBar.add(btnResGestion);
		toolBar.add(btnResGestion);
		
		

		JButton btnVoirProfil = new JButton("Voir profil");
			btnVoirProfil.addActionListener(e -> {
				//FenetreProfil.fenetreProfil(pseudo);
				Profil_Joueur p = new Profil_Joueur(joueur);
				p.setVisible(true);
				dispose();
			});
		btnVoirProfil.setBackground(Color.WHITE);
		btnVoirProfil.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnVoirProfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toolBar.add(btnVoirProfil);
		
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