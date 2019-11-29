package be.diallo.POJO;

import java.util.ArrayList;
import java.util.List;

import be.diallo.DAO.CourtDAO;
import be.diallo.DAO.EquipeDAO;
import be.diallo.DB.JVConnection;
import be.diallo.POJO.Joueur;

public class Equipe {
	public Equipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	private List<Joueur> joueurs;
	private int id;
	private String nom;
	
	public Equipe(int id,String nom) {
		this.id = id;
		this.nom = nom;
		this.joueurs = new ArrayList<Joueur>();
	}
	public Equipe(String nom) {
		this.nom = nom;
		this.joueurs = new ArrayList<Joueur>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	public boolean create() {
		EquipeDAO c=new EquipeDAO(JVConnection.getInstance());
		return c.create(this);
	}
	
	public ArrayList<Equipe> FindAll() {
		EquipeDAO persDao = new EquipeDAO(JVConnection.getInstance());
		return persDao.findAll();
	}
	
	public boolean addJoueurInEquipe(Equipe e, Joueur j) {
		EquipeDAO persDao = new EquipeDAO(JVConnection.getInstance());
		return persDao.addJoueurInEquipe(e, j);
	}
	
	public Equipe find(int id) {
		EquipeDAO persDao = new EquipeDAO(JVConnection.getInstance());
		return persDao.find(id);
	}
}
