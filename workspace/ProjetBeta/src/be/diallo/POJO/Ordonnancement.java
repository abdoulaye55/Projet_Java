package be.diallo.POJO;

import java.util.Set;

import be.diallo.DAO.OrdonnancementDAO;
import be.diallo.DAO.TournoiDAO;
import be.diallo.DB.JVConnection;
import exception.OrdonnoncementException;

public class Ordonnancement {

	//Variables
	private int idOrdonnancement;
	private String type;
	private int nbreSet;
	private Match [][] matiale;
	private Tournoi tournois;
	private int nombreEquipe;
	
	//Constructeurs
	public Ordonnancement(int idOrdonnancement, String type, int nbreSet, Match[][] matiale, Tournoi tournois) {
		super();
		this.idOrdonnancement = idOrdonnancement;
		this.type = type;
		this.nbreSet = nbreSet;
		this.matiale = matiale;
		this.tournois = tournois;
	}
	public Ordonnancement( String type, int nbreSet, Tournoi tournois) {
		super();

		this.type = type;
		this.nbreSet = nbreSet;
		this.tournois = tournois;
	}
	public Ordonnancement() 
	{
		
	}
	
	// Getters & Setters 
	public int getIdOrdonnancement() {
		return idOrdonnancement;
	}
	public int getNombreEquipe() {
		return nombreEquipe;
	}
	public void setNombreEquipe(int nombreEquipe) {
		this.nombreEquipe = nombreEquipe;
	}
	public void setIdOrdonnancement(int idOrdonnancement) {
		this.idOrdonnancement = idOrdonnancement;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNbreSet() {
		return nbreSet;
	}
	public void setNbreSet(int nbreSet) {
		this.nbreSet = nbreSet;
	}
	public Match[][] getMatiale() {
		return matiale;
	}
	public void setMatiale(Match[][] matiale) {
		this.matiale = matiale;
	}
	public Tournoi getTournois() {
		return tournois;
	}
	public void setTournois(Tournoi tournois) {
		this.tournois = tournois;
	}
	
	//Méthodes
	public boolean create() {
		OrdonnancementDAO t=new OrdonnancementDAO(JVConnection.getInstance());
		return t.create(this);
	}
	
	public Ordonnancement generateOrdonnancement(String type, int nbreSetGagnant, int nombreEquipe, Set<Equipe> equipes, Set<Court> courts, Tournoi tournoi) throws OrdonnoncementException {
		OrdonnancementDAO t=new OrdonnancementDAO(JVConnection.getInstance());
		return t.generateOrdonnancement(type, nbreSetGagnant, nombreEquipe, equipes, courts, tournoi);
	}
}