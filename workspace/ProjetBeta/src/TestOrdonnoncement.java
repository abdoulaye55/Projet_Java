import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import be.diallo.DAO.CourtDAO;
import be.diallo.DAO.EquipeDAO;
import be.diallo.DAO.JoueurDAO;
import be.diallo.DAO.OrdonnancementDAO;
import be.diallo.DAO.TournoiDAO;
import be.diallo.DB.JVConnection;
import be.diallo.POJO.Court;
import be.diallo.POJO.Equipe;
import be.diallo.POJO.Joueur;
import be.diallo.POJO.Match;
import be.diallo.POJO.Ordonnancement;
import be.diallo.POJO.Tournoi;
import exception.OrdonnoncementException;

public class TestOrdonnoncement {

	public static void main(String[] args) {
		
		/*Tournoi tournoi = new Tournoi(-1, "Roland Garros", 2000000);
		TournoiDAO tournoiDAO = new TournoiDAO(JVConnection.getInstance());
		tournoiDAO.create(tournoi);
		
		CourtDAO courtDAO = new CourtDAO(JVConnection.getInstance());
		Court court1 = new Court(5000, true, "Terre battue");
		Court court2 = new Court(10000, false, "Terre battue le retour");
		courtDAO.create(court1);
		courtDAO.create(court2);
		
		EquipeDAO equipeDAO = new EquipeDAO(JVConnection.getInstance());
		Equipe equipe1 = new Equipe(-1, "Equipe 1");
		Equipe equipe2 = new Equipe(-1, "Equipe 2");
		Equipe equipe3 = new Equipe(-1, "Equipe 3");
		Equipe equipe4 = new Equipe(-1, "Equipe 4");
		Equipe equipe5 = new Equipe(-1, "Equipe 5");
		Equipe equipe6 = new Equipe(-1, "Equipe 6");
		Equipe equipe7 = new Equipe(-1, "Equipe 7");
		Equipe equipe8 = new Equipe(-1, "Equipe 8");
		equipeDAO.create(equipe1);
		equipeDAO.create(equipe2);
		equipeDAO.create(equipe3);
		equipeDAO.create(equipe4);
		equipeDAO.create(equipe5);
		equipeDAO.create(equipe6);
		equipeDAO.create(equipe7);
		equipeDAO.create(equipe8);
		
		
		
		*/
		
		
		
		OrdonnancementDAO ordoDAO = new OrdonnancementDAO(JVConnection.getInstance());
		EquipeDAO equipeDAO = new EquipeDAO(JVConnection.getInstance());
		ArrayList<Equipe> liste_equipe = equipeDAO.findAll();
		Set<Equipe> equipes = new HashSet<Equipe>(liste_equipe);
		
		JoueurDAO joueurDAO = new JoueurDAO(JVConnection.getInstance());
		Joueur j1 = joueurDAO.find(49);
		Joueur j2 = joueurDAO.find(50);
		ArrayList<Joueur> array = new ArrayList<Joueur>();
		array.add(j1);
		array.add(j2);
		
		Equipe equipe1 = ((Equipe)equipes.toArray()[0]);
		equipeDAO.addJoueurInEquipe(equipe1, j1);
		equipeDAO.addJoueurInEquipe(equipe1, j2);
		equipe1.setJoueurs(array);
		
		CourtDAO courtDAO = new CourtDAO(JVConnection.getInstance());
		ArrayList<Court> liste_court = courtDAO.findAll();
		Set<Court> courts = new HashSet<Court>(liste_court);
		
		TournoiDAO tournoiDAO = new TournoiDAO(JVConnection.getInstance());
		Tournoi tournoi = tournoiDAO.find(1);
		System.out.println("Tournoi : "+tournoi);
		System.out.println("Tournoi ID : "+tournoi.getIdTournoi());
		
		Ordonnancement ordo = null;
		try {
			ordo = ordoDAO.generateOrdonnancement("HH", 3, 8, equipes, courts, tournoi);
			Match[][] matiale = ordo.getMatiale();
			int sousBoucle = 4;
			for(int i=0;i<3;i++) {
				for(int j=0;j<sousBoucle;j++) {
					//System.out.println("Match "+j);
					Match temp = matiale[i][j];
					if(i==0) {
						//System.out.println("Equipe 1 : "+temp.getEquipe().getId());
						//System.out.println("Equipe 2 : "+temp.getEquipe2().getId());
					}
					//System.out.println("Court "+temp.getCourt().getTypesurface());
				}
				sousBoucle = sousBoucle/2;
			}
		} catch (OrdonnoncementException e) {
			e.printStackTrace();
		}
		
		System.out.println("Ordonnancement créé : "+ordoDAO.create(ordo));
		
	}

}
