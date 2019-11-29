package be.diallo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.diallo.POJO.Court;
import be.diallo.POJO.Equipe;
import be.diallo.POJO.Joueur;
import be.diallo.POJO.Match;

public class EquipeDAO extends DAO<Equipe>{

	public EquipeDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Equipe obj) {
		PreparedStatement statement;
		try {
			statement = connect.prepareStatement("INSERT INTO Equipe(nom) VALUES(?)");
			statement.setString(1, obj.getNom());
			statement.executeUpdate();
			
			int idEquipe = this.findAll().get(0).getId();
			obj.setId(idEquipe);
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Equipe obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Equipe obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Equipe find(int id) {
		PreparedStatement statement;
		try {
			statement = connect.prepareStatement("SELECT * FROM Equipe WHERE IdEquipe = ?");
			statement.setInt(1, id);
			ResultSet res = statement.executeQuery();
			Equipe equipe = null;
			while(res.next()) //verif pri
			{
				equipe = new Equipe(res.getInt("idEquipe"),res.getString("nom"));
				
			}
			if(equipe==null) {
				return equipe;
			}
			statement = connect.prepareStatement("SELECT * FROM Joueur_Equipe WHERE IdEquipe = ?");
			statement.setInt(1, id);
			res = statement.executeQuery();
			Joueur joueur = null;
			JoueurDAO joueurDAO = new JoueurDAO(connect);
			while(res.next()) //verif pri
			{
				joueur = joueurDAO.find(res.getInt("num_joueur_FK"));
				equipe.getJoueurs().add(joueur);
				
			}
			return equipe;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Equipe> findAll(){
		PreparedStatement statement;
		try {
			statement = connect.prepareStatement("SELECT * FROM Equipe ORDER BY idEquipe");
			ResultSet res = statement.executeQuery();
			ArrayList<Equipe> list = new ArrayList<Equipe>();
			while(res.next()) //verif pri
			{
				Equipe equipe = new Equipe(res.getInt("idEquipe"),res.getString("nom"));
				list.add(equipe);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Equipe>();
		}
		
	}
	
	public ArrayList<Equipe> findAllByMatch(Match match){
		PreparedStatement statement;
		try {
			statement = connect.prepareStatement("SELECT IdEquipe FROM Equipe_Match WHERE IdMatch=?");
			statement.setInt(1, match.getIdMatch());
			ResultSet res = statement.executeQuery();
			ArrayList<Equipe> list = new ArrayList<Equipe>();
			while(res.next()) //verif pri
			{
				Equipe equipe = this.find(res.getInt("IdEquipe"));
				list.add(equipe);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Equipe>();
		}
	}
	
	public boolean addJoueurInEquipe(Equipe e, Joueur j) {
		PreparedStatement statement;
		try {
			System.out.println("j.GetId() : "+j.GetId());
			System.out.println("e.getId() : "+e.getId());
			statement = connect.prepareStatement("INSERT INTO Joueur_Equipe(num_joueur_FK,IdEquipe) VALUES(?,?)");
			statement.setInt(1, j.GetId());
			statement.setInt(2, e.getId());
			statement.executeUpdate();
	
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

		
	}

}
