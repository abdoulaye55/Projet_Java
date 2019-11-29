package be.diallo.POJO;

import java.util.ArrayList;
import java.util.Date;

import be.diallo.DAO.MatchDAO;
import be.diallo.DAO.PersonneDAO;
import be.diallo.DB.JVConnection;

public class Match {
	private int idMatch;
	private Date date_match;
	private int duree;
	private int tour;
	private int resultat;
	private Equipe equipe;
	private Equipe equipe2;
	private Court court;
	private Ordonnancement ordonnancement;
	
	
	public int getIdMatch() {
		return idMatch;
	}
	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}
	public Ordonnancement getOrdonnancement() {
		return ordonnancement;
	}
	public void setOrdonnancement(Ordonnancement ordonnancement) {
		this.ordonnancement = ordonnancement;
	}
	public Court getCourt() {
		return court;
	}
	public void setCourt(Court court) {
		this.court = court;
	}
	public Date getDate_match() {
		return date_match;
	}
	public void setDate_match(Date date_match) {
		this.date_match = date_match;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public int getTour() {
		return tour;
	}
	public void setTour(int tour) {
		this.tour = tour;
	}
	public int getResultat() {
		return resultat;
	}
	public void setResultat(int resultat) {
		this.resultat = resultat;
	}
	
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	public Equipe getEquipe2() {
		return equipe2;
	}
	public void setEquipe2(Equipe equipe2) {
		this.equipe2 = equipe2;
	}
	public Match(Date date_match, int duree, int tour, int resultat) {
		super();
		this.date_match = date_match;
		this.duree = duree;
		this.tour = tour;
		this.resultat = resultat;
	}
	
			public Match() {
		super();
		// TODO Auto-generated constructor stub
	}
			//Creer
			public ArrayList<Match> Find() {
				MatchDAO persDao = new MatchDAO(JVConnection.getInstance());
				return persDao.findAll();
			}
			
			public boolean update(Match obj) {
				MatchDAO persDao = new MatchDAO(JVConnection.getInstance());
				return persDao.update(obj);
			}
}
