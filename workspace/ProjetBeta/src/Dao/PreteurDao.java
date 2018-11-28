package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Pojo.Preteur;

public class PreteurDao extends DAO<Preteur> {

	public PreteurDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(Preteur p) {
		int res=0;
		PreparedStatement pst = null;
		try {
			// On ajoute les données nécessaires dans la table Personne
			pst = connect
					.prepareStatement("INSERT INTO Personne (nom, prenom, email, password, solde, dateEn, type) "
										+ "VALUES (?,?,?,?,?,?,?)");

			pst.setString(1, p.getNom());
			pst.setString(2, p.getPrenom());
			pst.setString(3, p.getEmail());
			pst.setString(4, p.getPassword());
			pst.setInt(5, p.getSolde());
			pst.setString(6,  (new Date(22/11/2018)).toString());
			pst.setString(7, "preteur");
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
	public Preteur find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Preteur> getList() {
		ArrayList<Preteur> list = new ArrayList<Preteur>();
		try {
			String s ="SELECT * FROM Personne;"; 
	    	ResultSet result = this.connect.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY).executeQuery(s);
	    	 while(result.next()){
		    	Preteur a = new Preteur();
		    	a.setId(result.getInt("Id"));
		    	a.setNom(result.getString("nom"));
		    	a.setPrenom(result.getString("prenom"));
		    	a.setEmail(result.getString("email"));
		    	a.setPassword(result.getString("password"));
		    	a.setSolde(result.getInt("solde"));
		    	a.setType(result.getString("type"));
		  
		    	list.add(a);
	    	 }
			
		}catch(Exception ex) {
			list = null;
		  	System.out.println(ex.getMessage());
			
		}
		
		return list;
	}

	@Override
	public Preteur get(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
