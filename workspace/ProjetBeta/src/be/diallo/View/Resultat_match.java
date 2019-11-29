package be.diallo.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.diallo.POJO.Administrateur;
import be.diallo.POJO.Equipe;
import be.diallo.POJO.Match;

import java.awt.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Resultat_match extends JFrame {

	private JPanel contentPane;
	private ArrayList<Equipe> equipes = new ArrayList<Equipe>();
	/**
	 * Launch the application.
	 */
	public static void main(Administrateur A) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resultat_match frame = new Resultat_match(A);
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
	public Resultat_match(Administrateur A) {
		setTitle("Resultat Match");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 361);
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
		list_1.setBounds(131, 106, 251, 69);
		contentPane.add(list_1);
		
		JButton button = new JButton("Enregistrer");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = list.getSelectedIndex();
				Match m=matchs.get(index);
				
				String index2 = list_1.getSelectedItem();
				System.out.println("Index 2 "+index2+" tableau "+equipes.size());
				int split = Integer.parseInt(index2.split("-")[0]);
				Equipe e = new Equipe("coucou");
				e = e.find(split);
				
				m.setResultat(e.getId());
				m.update(m);
				
				dispose();
				HomeAdmin p = new HomeAdmin(A);
				p.setVisible(true);
				dispose();
				
				
			}
		});
		button.setBounds(434, 265, 112, 46);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Pr\u00E9c\u00E9dent");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				HomeAdmin p = new HomeAdmin(A);
				p.setVisible(true);
				dispose();
			}
		});
		button_1.setBounds(18, 265, 107, 46);
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
					list_1.add(m.getEquipe().getId()+"-"+m.getEquipe().getNom());
				}
				if(m.getEquipe2()!=null) {
					list_1.add(m.getEquipe2().getId()+"-"+m.getEquipe2().getNom());
				}
				list_1.repaint();
			}
		});
		btnSelectionnerLeMatch.setBounds(388, 26, 158, 33);
		contentPane.add(btnSelectionnerLeMatch);
	}

}
