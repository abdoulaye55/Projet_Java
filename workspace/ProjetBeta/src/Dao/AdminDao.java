package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Pojo.Admin;

public class AdminDao extends DAO<Admin> {

	public AdminDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(Admin obj) {
		// TODO Auto-generated method stub
		return 0;
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
	public Admin find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Admin> getList() {
		ArrayList<Admin> list = new ArrayList<Admin>();
		try {
			String s ="SELECT * FROM Personne;"; 
	    	ResultSet result = this.connect.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY).executeQuery(s);
	    	 while(result.next()){
		    	Admin a = new Admin();
		    	a.setId(result.getInt("Id"));
		    	a.setNom(result.getString("nom"));
		    	a.setPrenom(result.getString("prenom"));
		    	a.setEmail(result.getString("email"));
		    	a.setPassword(result.getString("password"));
		    	a.setType(result.getString("type"));
		    	list.add(a);
	    	 }
			
		}catch(Exception ex) {
			list = null;
		}
		
		return list;
	}

	@Override
	public Admin get(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
