package Metier;

import java.util.ArrayList;

import Dao.AbstractDAOFactory;
import Dao.PreteurDao;
import Pojo.Preteur;

public class PreteurMetier {
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
	private PreteurDao preteurDao = (PreteurDao) adf.getPreteurDAO();
	private ArrayList<Preteur> listePreteur = preteurDao.getList();
	public int create(String nom, String prenom, String email, String password) {
		int res=0;
		if(connexion(email, password)==null) {
			if(nom.equals("") || email.equals("") || password.equals(""))
				res=-2;
			else {
				Preteur p = new Preteur();
				p.setNom(nom);
				p.setPrenom(prenom);
				p.setEmail(email);
				p.setPassword(password);
				res = preteurDao.create(p);
			}
		}
		else
			res = -3;
		return res;
	}
	public Preteur connexion(String email, String password) {
		Preteur p = null;
		for(Preteur pr : listePreteur) {
			if(pr.getEmail().equals(email) && pr.getPassword().equals(password))
				p=pr;
		}
		return p;
			
	}
}
