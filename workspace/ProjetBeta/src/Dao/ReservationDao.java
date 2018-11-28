package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import Pojo.Emprunteur;
import Pojo.Jeu;
import Pojo.Preteur;
import Pojo.Reservation;

public class ReservationDao extends DAO<Reservation> {

	public ReservationDao(Connection conn) {
		super(conn);
	}

	@Override
	public int create(Reservation r) {
		int res=0;
		PreparedStatement pst = null;
		try {
			// On ajoute les données nécessaires dans la table Personne
			pst = connect
					.prepareStatement("INSERT INTO Reservation (date, idJeu_re, idEmprunteur_re) "
										+ "VALUES (?,?,?)");

			pst.setString(1,r.getDate());
			pst.setInt(2, r.getJeu().getIdJeu());
			pst.setInt(3, r.getEmp().getId());
		
			pst.executeUpdate();
			res=1;
		} catch (SQLException ex){
			res=-1;
			System.out.println(ex.toString());
		}
		return res;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reservation find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reservation> getList() {
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		try {
			String s ="SELECT * FROM Reservation inner join Personne on id=idEmprunteur_re inner join Jeu on idjeu=idJeu_re;"; 
	    	ResultSet result = this.connect.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY).executeQuery(s);
	    	 while(result.next())
	    	  {
	    		Reservation r = new Reservation();
	    		r.setId(result.getInt("idRes"));
	    		r.setDate(result.getString("date"));
	    		// recuperation info sur le jeu reservé
	    		Jeu j = new Jeu();
	    		j.setNom(result.getString("nomjeu"));
	    		
	    		r.setJeu(j);
	    		Preteur p = new Preteur();
	    		p.setId(result.getInt("idPreteur_re"));
	    		j.setPreteur(p);
	    		
	    		// recuperation info sur l'emprunteur
	    		Emprunteur emp = new Emprunteur();
	    		emp.setId(result.getInt("id"));
	    		emp.setNom(result.getString("nom"));
	    		r.setEmp(emp);
		    	list.add(r);
	    	 }
			
		}catch(Exception ex) {
			list = null;
		  	System.out.println(ex.getMessage());
			
		}
		
		return list;
	}

	@Override
	public Reservation get(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
