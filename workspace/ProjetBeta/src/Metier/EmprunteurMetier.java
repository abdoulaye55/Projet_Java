package Metier;

import java.util.ArrayList;

import Dao.AbstractDAOFactory;
import Dao.EmprunteurDao;
import Pojo.Emprunteur;

public class EmprunteurMetier {
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
	private EmprunteurDao emprunteurDao = (EmprunteurDao) adf.getEmprunteurDAO();
	private ArrayList<Emprunteur> listEmp = emprunteurDao.getList();

	
	public int create(String nom, String prenom, String email, String password) {
		int res=0;
		if(connexion(email, password)==null) {
			if(nom.equals("") || email.equals("") || password.equals(""))
				res=-2;
			else {
				Emprunteur emp = new Emprunteur();
				emp.setNom(nom);
				emp.setPrenom(prenom);
				emp.setEmail(email);
				emp.setPassword(password);
				res = emprunteurDao.create(emp);
			}
		}
		else
			res = -3;
		return res;
	}
	public Emprunteur connexion(String email, String password) {
		Emprunteur p = null;
		for(Emprunteur pr : listEmp) {
			if(pr.getEmail().equals(email) && pr.getPassword().equals(password))
				p=pr;
		}
		return p;
			
	}

}
