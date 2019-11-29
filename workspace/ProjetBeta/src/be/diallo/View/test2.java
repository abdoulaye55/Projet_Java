package be.diallo.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import be.diallo.POJO.Administrateur;
import be.diallo.POJO.Joueur;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class test2 extends JFrame {

	//Variables des elements graphique
	private JPanel contentPane;	
	private JList<Joueur> listJoueur;
	private JScrollPane scrollPaneJoueur;
	private JButton btnModifierJoueur;
	private JButton btnSupprimerJoueur;
	private JList<Administrateur> listAdmin;
	private JButton btnAjouterUtilisateur;
	private JButton btnRetour;
	private DefaultListModel<Joueur> listModelJoueur;
	private DefaultListModel<Administrateur> listModelAdmin;
	private JButton btnAjouterUnJoueur;
	
	//Creation de la frame
	public test2(Administrateur admin) {
		
		//create the model and add elements
		listModelJoueur = new DefaultListModel<>();
		for (Joueur num : Joueur.List())  
        { 
			listModelJoueur.addElement(num);
        }
		
		listModelAdmin = new DefaultListModel<>();
		for (Administrateur num : Administrateur.List())  
        { 
			listModelAdmin.addElement(num);
        }
		
		setTitle("Gestion des utilisateurs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//list joueurs
		listJoueur = new JList<>(listModelJoueur);
		listJoueur.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listJoueur.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent event) {
	            	if (event.getClickCount() == 2) {
	            		Joueur joueur = listJoueur.getSelectedValue();
	            		JOptionPane.showMessageDialog(rootPane, joueur.message(), "Information Joueur : ", JOptionPane.INFORMATION_MESSAGE);
	            	  }
	            }
	        });
		
		//Scroll
		scrollPaneJoueur = new JScrollPane(listJoueur);
		scrollPaneJoueur.setBounds(21, 11, 388, 67);
		contentPane.add(scrollPaneJoueur);
		
		//btn modifier
		btnModifierJoueur = new JButton("Modifier Joueur");
		btnModifierJoueur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Joueur joueur = listJoueur.getSelectedValue();
				if(joueur != null)
				{				
					Utilisateur_Joueur_Modifier p = new Utilisateur_Joueur_Modifier(admin, joueur);
					p.setVisible(true);
					dispose();
				}
				else
					JOptionPane.showMessageDialog(rootPane, "Aucun joueur selectionné", "Erreur : ", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnModifierJoueur.setBounds(21, 89, 174, 23);
		contentPane.add(btnModifierJoueur);
		
		//btn supprimer
		btnSupprimerJoueur = new JButton("Supprimer Joueur");
		btnSupprimerJoueur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Joueur joueur = listJoueur.getSelectedValue();
				
				if(joueur != null)
				{
					try
					{
						if(joueur.Delete())
						{
							JOptionPane.showMessageDialog(rootPane, "Joueur supprimé", "Information : ", JOptionPane.INFORMATION_MESSAGE);
							Utilisateur_Gestion p = new Utilisateur_Gestion(admin);
							p.setVisible(true);
							dispose();
						}
						else
							JOptionPane.showMessageDialog(rootPane, "Erreur system : echec de l'update", "Erreur : ", JOptionPane.ERROR_MESSAGE);
					}
					catch(Exception err)
					{
						System.out.println(err);
					}
				}
				else
					JOptionPane.showMessageDialog(rootPane, "Aucun joueur selectionné", "Erreur : ", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnSupprimerJoueur.setBounds(235, 89, 174, 23);
		contentPane.add(btnSupprimerJoueur);
		
		//list admin
		listAdmin = new JList<>(listModelAdmin);
		listAdmin.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent event) {
            	if (event.getClickCount() == 2) {
            		Administrateur admini = listAdmin.getSelectedValue();
            		JOptionPane.showMessageDialog(rootPane, admini.message(), "Information Administrateur : ", JOptionPane.INFORMATION_MESSAGE);
            	  }
            }
        });
		
		//btn ajouter
		
		//btn retour
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeAdmin p = new HomeAdmin(admin);
				p.setVisible(true);
				dispose();
			}
		});
		btnRetour.setBounds(320, 227, 89, 23);
		contentPane.add(btnRetour);
		
		btnAjouterUnJoueur = new JButton("Ajouter un joueur \u00E0 une \u00E9quipe");
		btnAjouterUnJoueur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Equipe_Joueur_create p = new Equipe_Joueur_create(admin);
				p.setVisible(true);
				dispose();
			}
		});
		btnAjouterUnJoueur.setBounds(85, 146, 283, 23);
		contentPane.add(btnAjouterUnJoueur);
	}
}
