package be.diallo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import be.diallo.POJO.Court;
import be.diallo.POJO.Equipe;
import be.diallo.POJO.Joueur;
import be.diallo.POJO.Match;
import be.diallo.POJO.Ordonnancement;
import be.diallo.POJO.Tournoi;
import exception.OrdonnoncementException;

public class OrdonnancementDAO extends DAO<Ordonnancement> {

	public OrdonnancementDAO(Connection conn) {
		super(conn);
	}


	@Override
	public boolean create(Ordonnancement obj) {
		try {
			PreparedStatement statement = connect.prepareStatement("INSERT INTO Ordonnancement(type,nbreset,idTournoi) VALUES(?,?,?)");
			statement.setString(1, obj.getType());
			statement.setInt(2, obj.getNbreSet());
			statement.setInt(3, obj.getTournois().getIdTournoi());
			statement.executeUpdate();
			
			int idOrdonnancement = this.findAll().get(0).getIdOrdonnancement();
			obj.setIdOrdonnancement(idOrdonnancement);
			
			int nombreEquipe = obj.getNombreEquipe();
			int puissance = 0;
			int nombre = nombreEquipe;
			//calcul de la puissance de 2. exemple 8 = 2^3 = 3
			while((nombre/2)!=0) {
				puissance = puissance + 1 ;
				nombre = nombre/2;
			}
			MatchDAO matchDAO = new MatchDAO(connect);
			int sousBoucle = nombreEquipe/2;
			int j = 0;
			for(int i=0;i<puissance;i++) {
				for(j=0;j<sousBoucle;j++) {
					Match temp = obj.getMatiale()[i][j];
					temp.setOrdonnancement(obj);
					matchDAO.create(temp);
				}
				sousBoucle = sousBoucle/2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Ordonnancement obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Ordonnancement obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Ordonnancement find(int id) {
		PreparedStatement statement;
		try {
			statement = connect.prepareStatement("SELECT * FROM Ordonnancement WHERE IdOrdonnancement = ?");
			statement.setInt(1, id);
			ResultSet res = statement.executeQuery();
			Ordonnancement ordo = null;
			while(res.next()) //verif pri
			{
				TournoiDAO tournoiDAO = new TournoiDAO(connect);
				Tournoi tournoi = tournoiDAO.find(res.getInt("IdTournoi"));
				ordo = new Ordonnancement(res.getInt("idOrdonnancement"), res.getString("type"), res.getInt("nbreSet"), null, tournoi);
				
			}
			return ordo;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Ordonnancement> findAll(){
		PreparedStatement statement;
		try {
			statement = connect.prepareStatement("SELECT * FROM Ordonnancement ORDER BY idOrdonnancement");
			ResultSet res = statement.executeQuery();
			ArrayList<Ordonnancement> list = new ArrayList<Ordonnancement>();
			while(res.next()) //verif pri
			{
				TournoiDAO tournoiDAO = new TournoiDAO(connect);
				Tournoi tournoi = tournoiDAO.find(res.getInt("IdTournoi"));
				Ordonnancement ordo = new Ordonnancement(res.getInt("idOrdonnancement"), res.getString("type"), res.getInt("nbreSet"), null, tournoi);
				list.add(ordo);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * 
	 * @param type
	 * @param nbreSetGagnant
	 * @param nombreEquipe
	 * @param equipes : set == arraylist sans ordre et sans doublons 
	 * @param courts
	 * @param tournoi
	 * @return
	 */
	public Ordonnancement generateOrdonnancement(String type, int nbreSetGagnant, int nombreEquipe, Set<Equipe> equipes, Set<Court> courts, Tournoi tournoi) throws OrdonnoncementException {
		Random rand = new Random();
		if(nbreSetGagnant!=3 && nbreSetGagnant!=5) {
			throw new OrdonnoncementException("Le nombre de set gagnant doit être 3 ou 5");
		}
		
		//tester puissance de 2
		int puissance = 0;
		int nombre = nombreEquipe;
		//calcul de la puissance de 2. exemple 8 = 2^3 = 3
		while((nombre/2)!=0) {
			puissance = puissance + 1 ;
			nombre = nombre/2;
		}
		//verifier que le nombre d'équipe == taille de set
		if(nombreEquipe != equipes.size()) {
			throw new OrdonnoncementException("Le nombre d'équipe n'est pas égale à la taille du set équipe");
		}
		
		Ordonnancement ordo = new Ordonnancement();
		ordo.setNombreEquipe(nombreEquipe);
		//creation de notre matial
		Match[][] matiale = new Match[puissance][nombreEquipe/2];
		int sousBoucle = nombreEquipe/2;
		int j = 0;
		for(int i=0;i<puissance;i++) {
			for(j=0;j<sousBoucle;j++) {
				Match temp = new Match(null, -1, 0, -1);
				if(i==0) {
					temp.setEquipe((Equipe)equipes.toArray()[2*j]);
					temp.setEquipe2((Equipe)equipes.toArray()[2*j+1]);
				}
				temp.setCourt((Court)courts.toArray()[rand.nextInt(courts.size())]);
				temp.setOrdonnancement(ordo);
				temp.setTour(i);
				matiale[i][j] = temp;
			}
			sousBoucle = sousBoucle/2;
		}
		ordo.setMatiale(matiale);
		ordo.setTournois(tournoi);
		ordo.setType(type);
		ordo.setNbreSet(nbreSetGagnant);
		ordo.setIdOrdonnancement(-1);
		return ordo;
	}

}
