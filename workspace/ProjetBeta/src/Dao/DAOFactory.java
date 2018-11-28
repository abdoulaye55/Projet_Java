package Dao;

import java.sql.Connection;

import Db.SingletonConnection;
import Pojo.Admin;
import Pojo.Console;
import Pojo.Emprunteur;
import Pojo.Jeu;
import Pojo.Pret;
import Pojo.Preteur;
import Pojo.Reservation;


public class DAOFactory extends AbstractDAOFactory {

	protected static final Connection conn = SingletonConnection.getInstance();
	
	public DAO<Admin> getAdminDAO() { return new AdminDao(conn); }
	public DAO<Preteur> getPreteurDAO() { return new PreteurDao(conn); }
	public DAO<Emprunteur>  getEmprunteurDAO() { return new EmprunteurDao(conn); }
	public DAO<Console>  getConsoleDAO() {return new ConsoleDao(conn);};
	public DAO<Jeu>  getJeuDAO() {return new jeuDao(conn);}
	public DAO<Reservation> getReservationDao() {return new ReservationDao(conn);}
	@Override
	public DAO<Pret> getPretDao() {return new PretDao(conn);	};

}

