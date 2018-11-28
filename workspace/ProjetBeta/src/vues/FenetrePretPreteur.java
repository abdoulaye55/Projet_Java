package vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Metier.EmprunteurMetier;
import Metier.JeuMetier;
import Metier.PretMetier;
import Metier.PreteurMetier;
import Metier.ReservationMetier;
import Pojo.Console;
import Pojo.Emprunteur;
import Pojo.Jeu;
import Pojo.Pret;
import Pojo.Preteur;
import Pojo.Reservation;

import java.awt.List;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FenetrePretPreteur extends JFrame {

	private ReservationMetier reserMetier = new ReservationMetier();
	private ArrayList<Reservation> listReservation = reserMetier.getList();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFielddate_deb;
	private JTextField textField_1date_fin;

	/**
	 * Launch the application.
	 */
	public static void main(Preteur p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetrePretPreteur frame = new FenetrePretPreteur(p);
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
	public FenetrePretPreteur(Preteur p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);			
		List list = new List();
		list.setBounds(49, 10, 349, 65);
		for(Reservation r : listReservation)
			list.add(r.getJeu().getNom() +" "+r.getEmp().getNom());
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Confirmer");
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();
				if(index >= 0) {
					String date_deb=textFielddate_deb.getText();
					String date_fin=textField_1date_fin.getText();
					Reservation reservation = listReservation.get(index);
					PretMetier reservationMetier = new PretMetier();
					int res = reservationMetier.create(date_deb, date_fin, reservation);
					if(res==1) {
						JOptionPane.showMessageDialog(null, "Confirmation de pret du"+date_deb+" à " +date_fin);
						dispose();
						FenetreMenuPreteur.menuPreteur(p);
					}
					else
						JOptionPane.showMessageDialog(null, "erreur survenu, reéssayer plutard");
				
				}else
					JOptionPane.showMessageDialog(null, "selectionnez un jeu");
			}
		});
		
		btnNewButton.setBounds(345, 223, 89, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Precedent");
		btnNewButton_1.setBounds(0, 223, 89, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Date Debut");
		lblNewLabel.setBounds(49, 103, 82, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date Fin");
		lblNewLabel_1.setBounds(49, 150, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textFielddate_deb = new JTextField();
		textFielddate_deb.setBounds(155, 91, 243, 29);
		contentPane.add(textFielddate_deb);
		textFielddate_deb.setColumns(10);
		
		textField_1date_fin = new JTextField();
		textField_1date_fin.setBounds(155, 138, 243, 29);
		contentPane.add(textField_1date_fin);
		textField_1date_fin.setColumns(10);
	}

}
