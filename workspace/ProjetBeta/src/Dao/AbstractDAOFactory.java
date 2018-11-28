package Dao;

import Pojo.Admin;
import Pojo.Console;
import Pojo.Emprunteur;
import Pojo.Jeu;
import Pojo.Pret;
import Pojo.Preteur;
import Pojo.Reservation;

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;

	public abstract DAO<Admin> getAdminDAO();
	public abstract DAO<Preteur> getPreteurDAO();
	public abstract DAO<Emprunteur> getEmprunteurDAO();
	public abstract DAO<Console> getConsoleDAO();
	public abstract DAO<Jeu> getJeuDAO();
	public abstract DAO<Reservation> getReservationDao();
	public abstract DAO<Pret> getPretDao();
	
	
	public static AbstractDAOFactory getFactory() {
		return new DAOFactory();
	}
}
