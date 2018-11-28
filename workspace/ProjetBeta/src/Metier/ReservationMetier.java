package Metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import Dao.AbstractDAOFactory;
import Dao.ReservationDao;
import Pojo.Emprunteur;
import Pojo.Jeu;
import Pojo.Reservation;

public class ReservationMetier {
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
	private ReservationDao reservationDao = (ReservationDao) adf.getReservationDao();
	
	public int create(Emprunteur emp, Jeu jeu) {
		int res=0;
		Reservation r = new Reservation();
		Calendar cal = new GregorianCalendar();
		r.setDate(cal.get(Calendar.DAY_OF_MONTH)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR));
		r.setJeu(jeu);
		r.setEmp(emp);
		res = reservationDao.create(r);
		return res;
	}
	public ArrayList<Reservation> getList(){return reservationDao.getList();}
}
