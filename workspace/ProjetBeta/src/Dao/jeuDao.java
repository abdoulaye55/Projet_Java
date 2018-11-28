package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Pojo.Jeu;
import Pojo.Preteur;

public class jeuDao extends DAO<Jeu>{

	public jeuDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(Jeu j) {
		int res=0;
		PreparedStatement pst = null;
		try {
			// On ajoute les données nécessaires dans la table Personne
			pst = connect
					.prepareStatement("INSERT INTO Jeu (nomjeu, dispo, tarif, date_tarif, idConsole_re,idPreteur_re) "
										+ "VALUES (?,?,?,?,?,?)");

			pst.setString(1, j.getNom());
			pst.setInt(2, j.getDispo());
			pst.setDouble(3,j.getTarif());
			pst.setString(4,j.getDate_tarif());
			pst.setInt(5,j.getConsole().getId());
			pst.setInt(6 , j.getPreteur().getId());
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
	public Jeu find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Jeu> getList() {
		ArrayList<Jeu> list = new ArrayList<Jeu>();
		try {
			String s ="SELECT * FROM Jeu;"; 
	    	ResultSet result = this.connect.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY).executeQuery(s);
	    	 while(result.next()){
		    	Jeu j = new Jeu();
		    	j.setIdJeu(result.getInt("idJeu"));
		    	j.setNom(result.getString("nomjeu"));
		    	j.setDispo(result.getInt("dispo"));
		    	j.setTarif(result.getDouble("tarif"));
		    	j.setDate_tarif(result.getString("date_tarif"));
		    	list.add(j);
	    	 }
			
		}catch(Exception ex) {
			list = null;
		  	System.out.println(ex.getMessage());
			
		}
		
		return list;
	}

	@Override
	public Jeu get(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
