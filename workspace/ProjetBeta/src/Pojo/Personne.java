package Pojo;

public abstract class Personne {
	protected int 		id;
	protected String 	nom;
	protected String 	prenom;
	protected String 	email;
	protected String 	password;
	protected String    type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 *  GETTERS ET SETTERS
	 */

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Constructeur vide
	 */
	public Personne() { }
	
	/**
	 * Constructeur de la classe PersonnePOJO
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param type
	 */
	

}
