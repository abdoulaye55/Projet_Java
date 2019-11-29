package be.diallo.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.diallo.POJO.Equipe;
import be.diallo.POJO.Joueur;
import be.diallo.POJO.Match;

public class Resultat_match2 extends JFrame {

	private JPanel contentPane;
	private ArrayList<Equipe> equipes = new ArrayList<Equipe>();
	private ArrayList<Joueur> joueurs= new ArrayList<Joueur>();
	

	/**
	 * Launch the application.
	 */
	public static void main(Joueur j) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resultat_match2 frame = new Resultat_match2(j);
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
	public Resultat_match2(Joueur j) {
		setTitle("Resultat des matchs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		List list = new List();
		list.setBounds(131, 11, 251, 69);
		
		Match match = new Match();
		ArrayList<Match> matchs = match.Find();
		for(Match m : matchs) {
			list.add("Match "+m.getIdMatch());
		}  
		contentPane.add(list);
		
		List list_1 = new List();
		list_1.setBounds(131, 92, 251, 69);
		contentPane.add(list_1);
		
		JButton button_1 = new JButton("Pr\u00E9c\u00E9dent");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					HomeJoueur p = new HomeJoueur(j);
					p.setVisible(true);
					dispose();
				}
		});
		button_1.setBounds(207, 239, 107, 46);
		contentPane.add(button_1);
		
		JLabel lblEquipe = new JLabel("Equipe");
		lblEquipe.setBounds(18, 106, 46, 14);
		contentPane.add(lblEquipe);
		
		JLabel lblMatch = new JLabel("Match");
		lblMatch.setBounds(18, 11, 46, 14);
		contentPane.add(lblMatch);
		
		JButton btnSelectionnerLeMatch = new JButton("Selectionner le Match");
		btnSelectionnerLeMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = list.getSelectedIndex();
				Match m=matchs.get(index);
				list_1.removeAll();
				equipes = new ArrayList<Equipe>();
				if(m.getEquipe()!=null) {
					list_1.add("Equipe Vainqueur"+" "+m.getEquipe().getId()+"-"+m.getEquipe().getNom());
				}
				list_1.repaint();
			}
		});
		btnSelectionnerLeMatch.setBounds(388, 26, 158, 33);
		contentPane.add(btnSelectionnerLeMatch);
	}

}
