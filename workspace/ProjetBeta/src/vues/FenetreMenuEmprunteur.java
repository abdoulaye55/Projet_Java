package vues;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import Pojo.Emprunteur;
import Pojo.Preteur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreMenuEmprunteur extends JFrame {
	private static final long serialVersionUID = -4163074205881297312L;

	// Pseudo en paramètre pour récupérer celui de la connexion
	public static void menuEmprunteur(Emprunteur p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreMenuEmprunteur frame = new FenetreMenuEmprunteur(p);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FenetreMenuEmprunteur(Emprunteur p) {
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

		JButton btnCreerReservation = new JButton("Créer une réservation");
		btnCreerReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				FenetreReservation.main(p);
			}
		});
		btnCreerReservation.setBackground(Color.WHITE);
		btnCreerReservation.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnCreerReservation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton btnVoirReservation = new JButton("Voir mes réservations");
		btnVoirReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnVoirReservation.setBackground(Color.WHITE);
		btnVoirReservation.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnVoirReservation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toolBar.add(btnVoirReservation);
		toolBar.add(btnCreerReservation);

		JButton btnVoirProfil = new JButton("Voir profil");
			btnVoirProfil.addActionListener(e -> {
				fenetreProfil.fenetreProfil(p);
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
		
		btnSeDeco.addActionListener(e -> {
			FenetreConnexion.main(null);
			dispose();
		});
		
		btnQuitter.setBackground(Color.WHITE);
		btnQuitter.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnQuitter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toolBar.add(btnQuitter);
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
