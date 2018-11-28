package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Pojo.Admin;
import Pojo.Console;

public class ConsoleDao extends DAO<Console> {

	public ConsoleDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(Console c) {
		int res=0;
		PreparedStatement pst = null;
		try {
			// On ajoute les données nécessaires dans la table Personne
			pst = connect
					.prepareStatement("INSERT INTO Console (nom, descriptif) "
										+ "VALUES (?,?)");

			pst.setString(1, c.getNom());
			pst.setString(2, c.getDescriptif());
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
	public Console find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  ArrayList<Console> getList() {
		ArrayList<Console> list = new ArrayList<Console>();
		try {
			String s ="SELECT * FROM Console;"; 
	    	ResultSet result = this.connect.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY).executeQuery(s);
	    	 while(result.next()){
	    		 Console c = new Console();
		    	c.setId(result.getInt("idConsole"));
		    	c.setNom(result.getString("nom"));
		    	c.setDescriptif(result.getString("descriptif"));
		    	list.add(c);
	    	 }
			
		}catch(Exception ex) {
			list = null;
		}
		
		return list;
	}

	@Override
	public Console get(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
