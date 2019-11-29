package be.diallo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.diallo.POJO.Court;
import be.diallo.POJO.Ordonnancement;
import be.diallo.POJO.Tournoi;

public class CourtDAO extends DAO<Court>{

	public CourtDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Court obj) {
		PreparedStatement statement;
		try {
			statement = connect.prepareStatement("INSERT INTO Court(nbrespectateur,couvert,typesurface) VALUES(?,?,?)");
			statement.setInt(1, obj.getNbresepct());
			statement.setBoolean(2, obj.isCouvert());
			statement.setString(3, obj.getTypesurface());
			statement.executeUpdate();
			
			int idCourt = this.findAll().get(0).getIdCourt();
			obj.setIdCourt(idCourt);
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(Court obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Court obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Court find(int id) {
		PreparedStatement statement;
		try {
			statement = connect.prepareStatement("SELECT * FROM Court WHERE IdCourt = ?");
			statement.setInt(1, id);
			ResultSet res = statement.executeQuery();
			Court court = null;
			while(res.next()) //verif pri
			{
				court = new Court(res.getInt("nbrespectateur"),res.getBoolean("couvert"),res.getString("typesurface"));
				court.setIdCourt(res.getInt("idCourt"));
				
			}
			return court;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Court> findAll(){
		PreparedStatement statement;
		try {
			statement = connect.prepareStatement("SELECT * FROM Court ORDER BY idCourt");
			ResultSet res = statement.executeQuery();
			ArrayList<Court> list = new ArrayList<Court>();
			while(res.next()) //verif pri
			{
				Court court = new Court(res.getInt("nbrespectateur"),res.getBoolean("couvert"),res.getString("typesurface"));
				court.setIdCourt(res.getInt("idCourt"));
				list.add(court);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
