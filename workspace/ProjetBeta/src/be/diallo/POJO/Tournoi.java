package be.diallo.POJO;

import java.util.ArrayList;

import be.diallo.DAO.MatchDAO;
import be.diallo.DAO.TournoiDAO;
import be.diallo.DB.JVConnection;

public class Tournoi {
	private int idTournoi;
	private String nom;
	private Integer prix;
	
	
	public Tournoi(int idTournoi, String nom, int prix) {
		super();
		this.idTournoi = idTournoi;
		this.nom = nom;
		this.prix = prix;
	}
	public Tournoi( String nom, int prix) {
		super();
		this.nom = nom;
		this.prix = prix;
	}

	public int getIdTournoi() {
		return idTournoi;
	}

	public void setIdTournoi(int idTournoi) {
		this.idTournoi = idTournoi;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	public boolean create() {
		TournoiDAO t=new TournoiDAO(JVConnection.getInstance());
		return t.create(this);
	}
	//Creer
	public ArrayList<Tournoi> Find() {
		TournoiDAO persDao = new TournoiDAO(JVConnection.getInstance());
		return persDao.findAll();
	}
	public Tournoi() {
		super();
		// TODO Auto-generated constructor stub
	}
}
