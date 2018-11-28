package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Pojo.Emprunteur;

public class EmprunteurDao extends DAO<Emprunteur>{

	public EmprunteurDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(Emprunteur p) {
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
			pst.setInt(5,10);
			pst.setString(6,  (new Date(22/11/2018)).toString());
			pst.setString(7, "emprunteur");
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
	public Emprunteur find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Emprunteur> getList() {
		ArrayList<Emprunteur> list = new ArrayList<Emprunteur>();
		try {
			String s ="SELECT * FROM Personne;"; 
	    	ResultSet result = this.connect.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY).executeQuery(s);
	    	 while(result.next()){
	    		Emprunteur a = new Emprunteur();
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
	public Emprunteur get(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
