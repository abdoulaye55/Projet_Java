package be.diallo.View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import be.diallo.POJO.Administrateur;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class test extends JFrame {

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
	private JButton btnRetour;
	private JButton btnModifier;
	
	//Creation de la frame
	public test(Administrateur admin) {
		setTitle("Profil Administrateur");
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
		txtPseudo = new JTextField(admin.GetPseudo());
		txtPseudo.setEnabled(false);
		txtPseudo.setBounds(99, 25, 166, 31);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
		
		//lbl nom
		lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNom.setBounds(22, 62, 46, 14);
		contentPane.add(lblNom);
		
		//txt nom
		txtNom = new JTextField(admin.GetNom());
		txtNom.setBounds(99, 56, 166, 35);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		//lbl prenom
		lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrenom.setBounds(15, 98, 58, 24);
		contentPane.add(lblPrenom);
		
		//txt prenom
		txtPrenom = new JTextField(admin.GetPrenom());
		txtPrenom.setBounds(99, 88, 166, 34);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		//lbl age
		lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAge.setBounds(22, 136, 46, 14);
		contentPane.add(lblAge);
		
		//txt age
		txtAge = new JTextField(admin.GetAge().toString());
		txtAge.setBounds(99, 128, 166, 31);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		//lbl adresse
		lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdresse.setBounds(22, 167, 67, 14);
		contentPane.add(lblAdresse);
		
		//txt adresse
		txtadresse = new JTextField(admin.GetAdresse());
		txtadresse.setBounds(99, 159, 166, 31);
		contentPane.add(txtadresse);
		txtadresse.setColumns(10);
		
		//btn retour
		btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeAdmin p = new HomeAdmin(admin);
				p.setVisible(true);
				dispose();
			}
		});
		btnRetour.setBounds(15, 198, 89, 35);
		contentPane.add(btnRetour);
		
		//btn modifier
		btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nom = txtNom.getText().toString();
				String prenom = txtPrenom.getText().toString();
				String age = txtAge.getText().toString();
				String adresse = txtadresse.getText().toString();
				
				if(!nom.isEmpty() && !prenom.isEmpty() && !age.isEmpty() && Integer.parseInt(age) > 0 && !adresse.isEmpty())
				{
					try {
						admin.SetNom(nom);
						admin.SetPrenom(prenom);
						admin.SetAge(Integer.parseInt(age));
						admin.SetAdresse(adresse);
						
						if(admin.Update() == true)
						{				
							JOptionPane.showMessageDialog(rootPane, "Profil mis a jour", "Information : ", JOptionPane.INFORMATION_MESSAGE);
							Profil_Admin p = new Profil_Admin(admin);
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
					JOptionPane.showMessageDialog(rootPane, "Erreur d'encodage dans le formulaire", "Erreur : ", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnModifier.setBounds(324, 195, 89, 40);
		contentPane.add(btnModifier);
	}
}
