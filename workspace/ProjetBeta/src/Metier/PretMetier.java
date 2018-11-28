package Metier;

import java.util.ArrayList;

import Dao.AbstractDAOFactory;
import Dao.PretDao;
import Dao.jeuDao;
import Pojo.Console;
import Pojo.Emprunteur;
import Pojo.Jeu;
import Pojo.Pret;
import Pojo.Preteur;
import Pojo.Reservation;

public class PretMetier {
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
	private PretDao PretDAO = (PretDao) adf.getPretDao();
	public int create(String date_deb, String date_fin , Reservation reservation) {
		int res = 0;
		
			Pret pret = new Pret();
			pret.setDateDebut(date_deb);
			pret.setDateFin(date_fin);
			pret.setRes(reservation);
			res = PretDAO.create(pret);
		return res;
	}
	public ArrayList<Pret> getList(){ return PretDAO.getList();}
	

}
