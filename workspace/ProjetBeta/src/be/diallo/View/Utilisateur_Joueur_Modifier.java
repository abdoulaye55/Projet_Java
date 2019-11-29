package be.diallo.View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import be.diallo.POJO.Administrateur;
import be.diallo.POJO.Joueur;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Utilisateur_Joueur_Modifier extends JFrame {

	//Variables des elements graphique
	private JPanel contentPane;
	private JLabel lblPseudo;
	private JTextField txtPseudo;
	private JLabel lblNom;
	private JTextField txtNom;
	private JLabel lblPrenom;
	private JTextField txtPrenom;
	private JLabel lblAge;
	private JTextField txtAge;
	private JLabel lblAdresse;
	private JTextField txtadresse;
	private JLabel lblSolde;
	private JTextField txtSolde;
	private JButton btnRetour;
	private JButton btnModifier;
	
	//Creation de la frame
	public Utilisateur_Joueur_Modifier(Administrateur admin, Joueur joueur) {
		setTitle("Profil Joueur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//lbl pseudo
		lblPseudo = new JLabel("Pseudo");
		lblPseudo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPseudo.setBounds(22, 28, 51, 14);
		contentPane.add(lblPseudo);
		
		//txt pseudo
		txtPseudo = new JTextField(joueur.GetPseudo());
		txtPseudo.setBounds(99, 25, 107, 31);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
		
		//lbl nom
		lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNom.setBounds(22, 56, 46, 14);
		contentPane.add(lblNom);
		
		//txt nom
		txtNom = new JTextField(joueur.GetNom());
		txtNom.setBounds(99, 56, 107, 31);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		//lbl prenom
		lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrenom.setBounds(22, 81, 58, 23);
		contentPane.add(lblPrenom);
		
		//txt prenom
		txtPrenom = new JTextField(joueur.GetPrenom());
		txtPrenom.setBounds(99, 87, 107, 30);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		//lbl age
		lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAge.setBounds(22, 121, 46, 14);
		contentPane.add(lblAge);
		
		//txt age
		txtAge = new JTextField(joueur.GetAge().toString());
		txtAge.setBounds(99, 117, 107, 31);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		//lbl adresse
		lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdresse.setBounds(22, 152, 67, 14);
		contentPane.add(lblAdresse);
		
		//txt adresse
		txtadresse = new JTextField(joueur.GetAdresse());
		txtadresse.setBounds(99, 148, 107, 31);
		contentPane.add(txtadresse);
		txtadresse.setColumns(10);
		
		
		
		//btn retour
		btnRetour = new JButton("Retour");
		btnRetour.setBackground(Color.CYAN);
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Utilisateur_Gestion p = new Utilisateur_Gestion(admin);
				p.setVisible(true);
				dispose();
			}
		});
		btnRetour.setBounds(10, 195, 89, 38);
		contentPane.add(btnRetour);
		
		//btn modifier
		btnModifier = new JButton("Modifier");
		btnModifier.setBackground(Color.CYAN);
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nom = txtNom.getText().toString();
				String prenom = txtPrenom.getText().toString();
				String age = txtAge.getText().toString();
				String adresse = txtadresse.getText().toString();
				int solde = Integer.parseInt(txtSolde.getText());
				
				if(!nom.isEmpty() && !prenom.isEmpty() && !age.isEmpty() && Integer.parseInt(age) > 0 && !adresse.isEmpty() && solde>=0)
				{
					try {
						joueur.SetNom(nom);
						joueur.SetPrenom(prenom);
						joueur.SetAge(Integer.parseInt(age));
						joueur.SetAdresse(adresse);
						
						if(joueur.Update() == true)
						{
							if(joueur.UpdateSolde())
							{
								JOptionPane.showMessageDialog(rootPane, "Joueur mis a jour", "Information : ", JOptionPane.INFORMATION_MESSAGE);
								Utilisateur_Gestion p = new Utilisateur_Gestion(admin);
								p.setVisible(true);
								dispose();
							}
							else
								JOptionPane.showMessageDialog(rootPane, "Erreur system : echec de l'update Solde", "Erreur : ", JOptionPane.ERROR_MESSAGE);
						}
						else
							JOptionPane.showMessageDialog(rootPane, "Erreur system : echec de l'update Joueur", "Erreur : ", JOptionPane.ERROR_MESSAGE);
					}
					catch(Exception err)
					{
						System.out.println(err);
					}
				}
				else
					JOptionPane.showMessageDialog(rootPane, "Erreur d'encodage dans le formulaire", "Erreur : ", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnModifier.setBounds(267, 195, 89, 38);
		contentPane.add(btnModifier);
	}
}
