package vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Metier.ConsoleMetier;
import Metier.JeuMetier;
import Pojo.Console;
import Pojo.Preteur;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.List;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FenetreAjoutJeu extends JFrame {
	private ArrayList<Console> listeConsole;

	private JPanel contentPane;
	private JTextField textFieldNom;
	private JTextField textFieldTarif;
	private JTextField textFieldDate;
	private JeuMetier jeuMetier = new JeuMetier();

	/**
	 * Launch the application.
	 */
	public static void main(Preteur p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAjoutJeu frame = new FenetreAjoutJeu(p);
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
	public FenetreAjoutJeu(Preteur p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//inirialisation de la liste des consoles
		ConsoleMetier cMetier=new ConsoleMetier();
		listeConsole=cMetier.getList();
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(39, 14, 46, 14);
		contentPane.add(lblNom);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(146, 11, 110, 30);
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Dispo");
		lblNewLabel.setBounds(39, 53, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tarif");
		lblNewLabel_1.setBounds(39, 96, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBoxDispo = new JCheckBox("Dispo");
		chckbxNewCheckBoxDispo.setSelected(true);
		chckbxNewCheckBoxDispo.setBounds(114, 49, 97, 23);
		contentPane.add(chckbxNewCheckBoxDispo);
		
		JCheckBox chckbxNewChecnokBoxDnondispo = new JCheckBox("Non dispo");
		chckbxNewChecnokBoxDnondispo.setBounds(213, 49, 97, 23);
		contentPane.add(chckbxNewChecnokBoxDnondispo);
		ButtonGroup btnGroupType			= new ButtonGroup();
		btnGroupType.add(chckbxNewCheckBoxDispo);
		btnGroupType.add(chckbxNewChecnokBoxDnondispo);
		
		textFieldTarif = new JTextField();
		textFieldTarif.setBounds(146, 88, 110, 30);
		contentPane.add(textFieldTarif);
		textFieldTarif.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Date_tarif");
		lblNewLabel_2.setBounds(39, 131, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		textFieldDate = new JTextField();
		textFieldDate.setBounds(146, 122, 110, 30);
		contentPane.add(textFieldDate);
		textFieldDate.setColumns(10);
		
		//initialisation de jlist de console
		List list_1 = new List();
		list_1.setBounds(146, 158, 110, 60);
		for(Console c : listeConsole)
			list_1.add(c.getNom());
		contentPane.add(list_1);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int index = list_1.getSelectedIndex();
					if(index >=0 ) {
						String nom = textFieldNom.getText();
						Double tarif = Double.parseDouble(textFieldTarif.getText());
						String dateTarif = textFieldDate.getText();
						Console c = listeConsole.get(index);
						int dispo=1;
						if(chckbxNewChecnokBoxDnondispo.isSelected()==true) 
							dispo=0;
						int res = jeuMetier.create(nom, dispo, tarif, dateTarif,c,p);
						if(res==1) {
							JOptionPane.showMessageDialog(null, "jeu ajouté");
							dispose();
							FenetreMenuPreteur.menuPreteur(p);
						}
					}else
						JOptionPane.showMessageDialog(null, "veillez selectionner une console");
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null , "les information entréees ne sont pas valides");
				}
			}
		});
		btnNewButton.setBounds(345, 221, 89, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Precedent");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FenetreMenuPreteur.menuPreteur(p);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 221, 89, 40);
		contentPane.add(btnNewButton_1);
		
		
		JLabel lblNewLabel_3 = new JLabel("Console");
		lblNewLabel_3.setBounds(39, 179, 46, 14);
		contentPane.add(lblNewLabel_3);

	}
}
