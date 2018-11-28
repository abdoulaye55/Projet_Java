package Pojo;


public class Jeu {
	private int idJeu;
	private String nom;
	private int dispo;
	private double tarif;
	private String date_tarif;
	private Console console;
	private Preteur preteur;
	
	public Preteur getPreteur() {
		return preteur;
	}
	public void setPreteur(Preteur preteur) {
		this.preteur = preteur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getDispo() {
		return dispo;
	}
	public void setDispo(int dispo) {
		this.dispo = dispo;
	}
	public double getTarif() {
		return tarif;
	}
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	
	public String getDate_tarif() {
		return date_tarif;
	}
	public void setDate_tarif(String date_tarif) {
		this.date_tarif = date_tarif;
	}
	public int getIdJeu() {
		return idJeu;
	}
	public void setIdJeu(int idJeu) {
		this.idJeu = idJeu;
	}
	public Console getConsole() {
		return console;
	}
	public void setConsole(Console console) {
		this.console = console;
	}

}
