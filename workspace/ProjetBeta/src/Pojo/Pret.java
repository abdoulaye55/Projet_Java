package Pojo;

public class Pret {
	private int idPret;
	private Reservation res;
	public Reservation getRes() {
		return res;
	}
	public void setRes(Reservation res) {
		this.res = res;
	}
	public int getIdPret() {
		return idPret;
	}
	public void setIdPret(int idPret) {
		this.idPret = idPret;
	}
	private String dateDebut; 
	private String dateFin;
	
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

}
