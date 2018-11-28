package vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Metier.JeuMetier;
import Metier.ReservationMetier;
import Pojo.Emprunteur;
import Pojo.Jeu;
import java.awt.List;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreReservation extends JFrame {

	private JPanel contentPane;

	private JeuMetier jeuMetier= new JeuMetier();
	private ArrayList<Jeu> listJeu = jeuMetier.getList();
	

	/**
	 * Launch the application.
	 */
	public static void main(Emprunteur emp) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreReservation frame = new FenetreReservation(emp);
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
	public FenetreReservation(Emprunteur emp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		List list = new List();
		list.setBounds(10, 10, 414, 143);
		contentPane.add(list);
		for(Jeu j : listJeu)
			list.add(j.getNom()+" "+j.getTarif()+"€");
		
		Button button = new Button("Reserver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = list.getSelectedIndex();
				if(index >= 0) {
					Jeu jeu = listJeu.get(index);
					ReservationMetier reservationMetier = new ReservationMetier();
					int res = reservationMetier.create(emp, jeu);
					if(res==1) {
						JOptionPane.showMessageDialog(null, "reservation envoyée");
						dispose();
						FenetreMenuEmprunteur.menuEmprunteur(emp);
					}
					else
						JOptionPane.showMessageDialog(null, "erreur survenu, reéssayer plutard");
				
				}else
					JOptionPane.showMessageDialog(null, "selectionnez un jeu");
			}
		});
		button.setBounds(181, 187, 113, 39);
		contentPane.add(button);
	}
}
