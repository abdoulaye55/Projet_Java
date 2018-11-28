package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Pojo.Jeu;
import Pojo.Pret;

public class PretDao extends DAO<Pret> {

	public PretDao(Connection conn) {
		super(conn);
	}

	@Override
	public int create(Pret p) {
		int res=0;
		PreparedStatement pst = null;
		try {
			// On ajoute les données nécessaires dans la table Personne
			pst = connect
					.prepareStatement("INSERT INTO Pret (dateDebut, dateFin, idReservation) "
										+ "VALUES (?,?,?)");

			pst.setString(1, p.getDateDebut());
			pst.setString(2, p.getDateFin());
			pst.setInt(3, p.getRes().getEmp().getId());
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
	public Pret find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Pret> getList() {
		ArrayList<Pret> list = new ArrayList<Pret>();
		try {
			String s ="SELECT * FROM Pret;"; 
	    	ResultSet result = this.connect.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY).executeQuery(s);
	    	 while(result.next()){
		    	Pret p = new Pret();
		    	p.setIdPret(result.getInt("idPret"));
		    	p.setDateDebut(result.getString("dateDebut"));
		    	p.setDateFin(result.getString("dateFin"));
		    	
		    	list.add(p);
	    	 }
			
		}catch(Exception ex) {
			list = null;
		  	System.out.println(ex.getMessage());
			
		}
		
		return list;
	}

	@Override
	public Pret get(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
