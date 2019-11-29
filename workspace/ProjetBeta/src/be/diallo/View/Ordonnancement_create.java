package be.diallo.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.diallo.DAO.MatchDAO;
import be.diallo.DB.JVConnection;
import be.diallo.POJO.Administrateur;
import be.diallo.POJO.Court;
import be.diallo.POJO.Equipe;
import be.diallo.POJO.Ordonnancement;
import be.diallo.POJO.Tournoi;
import exception.OrdonnoncementException;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ordonnancement_create extends JFrame {

	private JPanel contentPane;
	private ArrayList<Tournoi> listeConsole;
	private JTextField textField;
	private JTextField textField_1;
	private Ordonnancement o;

	/**
	 * Launch the application.
	 */
	public static void main(Administrateur A) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ordonnancement_create frame = new Ordonnancement_create(A);
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
	public Ordonnancement_create(Administrateur A) {
		setTitle("Creation Ordonnancement");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Tournoi cMetier=new Tournoi();
		listeConsole=cMetier.Find();
		JLabel lblNom = new JLabel("Liste des Tournois");
		lblNom.setBounds(6, 111, 107, 32);
		contentPane.add(lblNom);
		List list_1 = new List();
		list_1.setBounds(123, 111, 251, 69);
		for(Tournoi c : listeConsole)
			list_1.add(c.getNom());   
		contentPane.add(list_1);
		
		List list = new List();
		list.setMultipleSelections(true);
		
		list.setBounds(123, 186, 251, 69);
		Court court = new Court(0, false, "");
		ArrayList<Court> courts = court.FindAll();
		for(Court c : courts) {
			String message = c.getIdCourt()+" | "+c.getNbresepct()+" | "+c.getTypesurface();
			list.add(message);
		}  
		contentPane.add(list);
		
		List list_2 = new List();
		list_2.setMultipleSelections(true);
		list_2.setBounds(123, 283, 251, 69);
		Equipe equipe = new Equipe("Coucou");
		ArrayList<Equipe> equipes = equipe.FindAll();
		for(Equipe e : equipes) {
			list_2.add(e.getNom());
		}  
		contentPane.add(list_2);
		
		JLabel lblNewLabel = new JLabel("Type");
		lblNewLabel.setBounds(10, 24, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de Set");
		lblNewLabel_1.setBounds(10, 69, 103, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setBounds(71, 24, 46, 14);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("Pr\u00E9c\u00E9dent");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeAdmin p = new HomeAdmin(A);
				p.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(6, 431, 107, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Enregistrer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * Je récupère les infos des textfields
				 */
				String Nom = textField.getText();
				String Descriptif= textField_1.getText();
				int index = list_1.getSelectedIndex();
				Tournoi t=listeConsole.get(index);
				
				Set<Court> setCourts = new HashSet<Court>();
				int indexCourt[] = list.getSelectedIndexes();
				for(int intCourt : indexCourt) {
					setCourts.add(courts.get(intCourt));
				}
	System.out.println("Taille de setCourts : "+setCourts.size());
	
				Set<Equipe> setEquipes = new HashSet<Equipe>();
				int indexEquipe[] = list_2.getSelectedIndexes();
				for(int intEquipe : indexEquipe) {
					setEquipes.add(equipes.get(intEquipe));
				}
			System.out.println("Taille de setEquipes : "+setEquipes.size());
				
				try {
					o = new Ordonnancement();
					o = o.generateOrdonnancement(Nom, Integer.parseInt(Descriptif), setEquipes.size(), setEquipes, setCourts, t);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (OrdonnoncementException e) {
					e.printStackTrace();
				}
						
				//J'appelle la méthode inscription recevant en paramètre tous les éléments nécessaires à l'inscription d'un utilisateur
				if(o.create()==true) {
					dispose();
					HomeAdmin p = new HomeAdmin(A);
					p.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_1.setBounds(604, 431, 112, 46);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(123, 11, 151, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(123, 56, 151, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		
		JLabel lblListeDesCourts = new JLabel("Liste des Courts");
		lblListeDesCourts.setBounds(10, 183, 107, 32);
		contentPane.add(lblListeDesCourts);
		
		JLabel lblListeDesEquipes = new JLabel("Liste des Equipes");
		lblListeDesEquipes.setBounds(6, 288, 107, 32);
		contentPane.add(lblListeDesEquipes);
		
	
	}
}
