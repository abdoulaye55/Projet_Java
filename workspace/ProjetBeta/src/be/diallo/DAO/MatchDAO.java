package be.diallo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.diallo.POJO.Court;
import be.diallo.POJO.Equipe;
import be.diallo.POJO.Match;
import be.diallo.POJO.Ordonnancement;
import be.diallo.POJO.Tournoi;

public class MatchDAO extends DAO<Match>{

	public MatchDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Match obj) {
		PreparedStatement statement;
		try {
			statement = connect.prepareStatement("INSERT INTO Match(tour,IdCourt,IdOrdonnancement) VALUES(?,?,?)");
			statement.setInt(1, obj.getTour());
			statement.setInt(2, obj.getCourt().getIdCourt());
			statement.setInt(3, obj.getOrdonnancement().getIdOrdonnancement());
			statement.executeUpdate();
			
			int idMatch = this.findAll().get(0).getIdMatch();
			obj.setIdMatch(idMatch);
			
			statement = connect.prepareStatement("INSERT INTO Equipe_Match(IdEquipe,IdMatch) VALUES(?,?)");
			//insérer les équipes dans le match si elle existe
			if(obj.getEquipe()!= null) {
				statement.setInt(1, obj.getEquipe().getId());
				statement.setInt(2, idMatch);
				statement.executeUpdate();
			}
			if(obj.getEquipe2()!= null) {
				statement.setInt(1, obj.getEquipe2().getId());
				statement.setInt(2, idMatch);
				statement.executeUpdate();
			}
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Match obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Match obj) {
		PreparedStatement statement;
		try
		{
			statement = connect.prepareStatement("Update Match Set resultat = ? WHERE IdMatch=?");
			statement.setInt(1, obj.getResultat());
			statement.setInt(2, obj.getIdMatch());
			statement.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	public ArrayList<Match> findAll(){
		PreparedStatement statement;
		try {
			statement = connect.prepareStatement("SELECT * FROM Match ORDER BY IdMatch DESC");
			ResultSet res = statement.executeQuery();
			ArrayList<Match> list = new ArrayList<Match>();
			while(res.next()) //verif pri
			{
				Match match = new Match(res.getDate("datedumatch"),res.getInt("duree"),res.getInt("tour"),res.getInt("resultat"));
				match.setIdMatch(res.getInt("IdMatch"));
				CourtDAO courtDAO = new CourtDAO(connect);
				Court court = courtDAO.find(res.getInt("IdCourt"));
				match.setCourt(court);
				OrdonnancementDAO ordonnancementDAO = new OrdonnancementDAO(connect);
				Ordonnancement ordonnancement = ordonnancementDAO.find(res.getInt("IdOrdonnancement"));
				match.setOrdonnancement(ordonnancement);
				
				//ajouter les equipe 1 et 2 si elles existent
				EquipeDAO equipeDAO = new EquipeDAO(connect);
				List<Equipe> equipes = equipeDAO.findAllByMatch(match);
				if(equipes.size()==1) {
					match.setEquipe(equipes.get(0));
				}
				else if(equipes.size()==2) {
					match.setEquipe(equipes.get(0));
					match.setEquipe2(equipes.get(1));
				}
				list.add(match);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
