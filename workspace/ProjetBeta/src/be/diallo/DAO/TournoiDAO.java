package be.diallo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.diallo.POJO.Court;
import be.diallo.POJO.Tournoi;

public class TournoiDAO extends DAO<Tournoi>{

	public TournoiDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Tournoi obj) {
		PreparedStatement statement;
		try {
			statement = connect.prepareStatement("INSERT INTO Tournoi(nom,prix) VALUES(?,?)");
			statement.setString(1, obj.getNom());
			statement.setInt(2, obj.getPrix());
			statement.executeUpdate();
			
			int idTournoi = this.findAll().get(0).getIdTournoi();
			obj.setIdTournoi(idTournoi);
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Tournoi obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Tournoi obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Tournoi find(int id) {
		PreparedStatement statement;
		try {
			statement = connect.prepareStatement("SELECT * FROM Tournoi WHERE idTournoi = ?");
			statement.setInt(1, id);
			ResultSet res = statement.executeQuery();
			Tournoi tournoi = null;
			while(res.next()) //verif pri
			{
				tournoi = new Tournoi(res.getInt("IdTournoi"),res.getString("nom"),res.getInt("prix"));
				
			}
			return tournoi;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Tournoi> findAll(){
		PreparedStatement statement;
		try {
			statement = connect.prepareStatement("SELECT * FROM Tournoi ORDER BY idTournoi");
			ResultSet res = statement.executeQuery();
			ArrayList<Tournoi> list = new ArrayList<Tournoi>();
			while(res.next()) //verif pri
			{
				Tournoi tournoi = new Tournoi(res.getInt("IdTournoi"),res.getString("nom"),res.getInt("prix"));
				list.add(tournoi);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
