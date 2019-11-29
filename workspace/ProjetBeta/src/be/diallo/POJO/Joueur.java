package be.diallo.POJO;

import java.util.ArrayList;
import java.util.List;

import be.diallo.DAO.EquipeDAO;
import be.diallo.DAO.JoueurDAO;
import be.diallo.DAO.PersonneDAO;
import be.diallo.DB.JVConnection;

public class Joueur extends Personne {

		
		//Constructeur
		public Joueur()
		{
			
		}

		public Joueur(String pseudo, String mp, String nom, String prenom, Integer age, String adresse)
		{
			super(pseudo, mp, nom, prenom, age, adresse);
			
			
		}
		
		public Joueur(int id, String pseudo, String mp, String nom, String prenom, Integer age, String adresse)
		{
			super(id, pseudo, mp, nom, prenom, age, adresse);
			
			
		}
		
		
		//Verification Connexion
		public static Joueur Verif(String pseudo, String mp)
		{
			JoueurDAO joueurDao = new JoueurDAO(JVConnection.getInstance());
			return joueurDao.verif(pseudo, mp);
		}
		
		//Creer
		public boolean Creer() {
			//Creer la personne
			PersonneDAO persDao = new PersonneDAO();		
			if(persDao.create(this) == true)
			{		
				JoueurDAO joueurDao = new JoueurDAO(JVConnection.getInstance());
				if(joueurDao.create(this)== true)
					return true;
			}
			
			return false;
		}
		
		//Delete
		public boolean Delete() {
			JoueurDAO joueurDao = new JoueurDAO(JVConnection.getInstance());
			return joueurDao.delete(this);
		}
		
		//Update Solde
		public boolean UpdateSolde() {
			JoueurDAO joueurDao = new JoueurDAO(JVConnection.getInstance());
			return joueurDao.updatesolde(this);
		}
		
		//Creation de la liste
		public static List<Joueur> List()
		{
			JoueurDAO joueurDao = new JoueurDAO(JVConnection.getInstance());
			return joueurDao.list();
		}
		
		public ArrayList<Joueur> FindAll() {
			JoueurDAO joueurDao = new JoueurDAO(JVConnection.getInstance());
			return (ArrayList<Joueur>)joueurDao.list();
		}
		
		// Tostring
		@Override
		public String toString() {
			return "Pseudo : " + super.GetPseudo() + ", Nom : " + super.GetNom() + ", Prenom : " + super.GetPrenom();
		}
		
		//Message
		public String message() {
			return super.toString() + ", Solde : " + super.GetAge();
		}
}