package Metier;

import java.util.ArrayList;

import Dao.AbstractDAOFactory;
import Dao.ConsoleDao;
import Pojo.Admin;
import Pojo.Console;

public class ConsoleMetier {
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
	private ConsoleDao consoleDao = (ConsoleDao) adf.getConsoleDAO();
	@SuppressWarnings("unused")
	public ArrayList<Console> getList(){ return consoleDao.getList();}
	public int create(String nom, String descriptif) {
		int res =0;
		if(nom.equals("") || descriptif.equals(""))
			res=-2;
		else {
			Console c = new Console();
			c.setNom(nom);
			c.setDescriptif(descriptif);
			res = consoleDao.create(c);
		}
		return res;
	}
}

