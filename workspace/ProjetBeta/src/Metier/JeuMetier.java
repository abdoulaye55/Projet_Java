package Metier;

import java.util.ArrayList;

import Dao.AbstractDAOFactory;

import Dao.jeuDao;
import Pojo.Console;
import Pojo.Jeu;
import Pojo.Preteur;

public class JeuMetier {

	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
	private jeuDao JeuDAO = (jeuDao) adf.getJeuDAO();

	public int create(String nom, int dispo, double tarif, String date_tarif,Console c, Preteur p) {
		int res = 0;
		if (nom.equals(""))
			res = -2;
		else {
			Jeu j = new Jeu();
			j.setNom(nom);
			j.setDispo(dispo);
			j.setTarif(tarif);
			j.setDate_tarif(date_tarif);
			j.setConsole(c);
			j.setPreteur(p);
			
			res = JeuDAO.create(j);
		}
		return res;
	}
	public ArrayList<Jeu> getList(){ return JeuDAO.getList();}
}
