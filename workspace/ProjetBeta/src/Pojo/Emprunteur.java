package Pojo;

public class Emprunteur extends Joueur{
	public Emprunteur() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int cote;
	private int unite;
	
	public int getCote() {
		return cote;
	}
	public void setCote(int cote) {
		this.cote = cote;
	}
	public int getUnite() {
		return unite;
	}
	public void setUnite(int unite) {
		this.unite = unite;
	}
}
