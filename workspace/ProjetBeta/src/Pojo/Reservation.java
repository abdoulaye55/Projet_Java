package Pojo;

public class Reservation {
	private int id;
	private String date;
	private Jeu jeu;
	private Emprunteur emp;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Jeu getJeu() {
		return jeu;
	}
	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}
	public Emprunteur getEmp() {
		return emp;
	}
	public void setEmp(Emprunteur emp) {
		this.emp = emp;
	}
	

}
