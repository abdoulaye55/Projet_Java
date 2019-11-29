package be.diallo.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.diallo.POJO.Administrateur;
import be.diallo.POJO.Court;
import be.diallo.POJO.Equipe;
import be.diallo.POJO.Joueur;
import be.diallo.POJO.Tournoi;

import java.awt.List;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;

public class Equipe_Joueur_create extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(Administrateur A) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Equipe_Joueur_create frame = new Equipe_Joueur_create(A);
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
	public Equipe_Joueur_create(Administrateur A) {
		setTitle("Ajout de joueur \u00E0 une equipe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		List list = new List();
		list.setBounds(123, 10, 251, 69);
		
		Equipe equipe = new Equipe("Coucou");
		ArrayList<Equipe> equipes = equipe.FindAll();
		for(Equipe e : equipes) {
			list.add(e.getNom());
		}  
		contentPane.add(list);
		
		JLabel lblEquipe = new JLabel("Equipe");
		lblEquipe.setBounds(10, 10, 46, 14);
		contentPane.add(lblEquipe);
		
		List list_1 = new List();
		list_1.setBounds(123, 105, 251, 69);
		list_1.setMultipleSelections(true);
		
		Joueur joueur = new Joueur();
		ArrayList<Joueur> joueurs = joueur.FindAll();
		for(Joueur j : joueurs) {
			list_1.add(j.GetNom()+" "+j.GetPrenom());
		}  
		contentPane.add(list_1);
		
		JLabel lblJoueur = new JLabel("Joueur");
		lblJoueur.setBounds(10, 105, 46, 14);
		contentPane.add(lblJoueur);
		
		JButton button = new JButton("Pr\u00E9c\u00E9dent");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Utilisateur_Gestion p = new Utilisateur_Gestion(A);
				p.setVisible(true);
				dispose();
				
			}
		});
		button.setBounds(10, 204, 107, 46);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Enregistrer");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = list.getSelectedIndex();
				Equipe e=equipes.get(index);
				
				//ArrayList<Joueur> joueursSelect = new ArrayList<Joueur>();
				int indexJoueur[] = list_1.getSelectedIndexes();
				for(int intJoueur : indexJoueur) {
					Joueur j = joueurs.get(intJoueur);
					e.addJoueurInEquipe(e, j);
				}
				
				dispose();
				HomeAdmin p = new HomeAdmin(A);
				p.setVisible(true);
				dispose();
				
				
				
			}
		});
		button_1.setBounds(314, 204, 112, 46);
		contentPane.add(button_1);
	}
}
