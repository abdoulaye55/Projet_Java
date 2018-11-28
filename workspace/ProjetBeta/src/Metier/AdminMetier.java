package Metier;

import java.util.ArrayList;

import Dao.AbstractDAOFactory;
import Dao.AdminDao;
import Pojo.Admin;

public class AdminMetier {
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
	private AdminDao adminDao = (AdminDao) adf.getAdminDAO();
	
	private ArrayList<Admin> getList(){ return adminDao.getList();}
	public Admin connexion(String email, String password) {
		Admin a = null;
		ArrayList<Admin> list = this.getList();
		for(Admin admin : list) {
			if(admin.getEmail().equals(email) && admin.getPassword().equals(password))
				a=admin;
		}
			
		return a;
	}

}
