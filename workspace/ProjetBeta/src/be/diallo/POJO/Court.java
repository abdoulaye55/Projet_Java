package be.diallo.POJO;

import java.util.ArrayList;

import be.diallo.DAO.CourtDAO;
import be.diallo.DAO.TournoiDAO;
import be.diallo.DB.JVConnection;

public class Court {
	private int idCourt;
	private Integer nbresepct;
	private boolean couvert;
	private String typesurface;
	public Court(int nbresepct, boolean couvert, String typesurface) {
		super();
		this.nbresepct = nbresepct;
		this.couvert = couvert;
		this.typesurface = typesurface;
	}
	
	public int getIdCourt() {
		return idCourt;
	}

	public void setIdCourt(int idCourt) {
		this.idCourt = idCourt;
	}

	public int getNbresepct() {
		return nbresepct;
	}
	public void setNbresepct(int nbresepct) {
		this.nbresepct = nbresepct;
	}
	public boolean isCouvert() {
		return couvert;
	}
	public void setCouvert(boolean couvert) {
		this.couvert = couvert;
	}
	public String getTypesurface() {
		return typesurface;
	}
	public void setTypesurface(String typesurface) {
		this.typesurface = typesurface;
	}
	
	public boolean create() {
		CourtDAO c=new CourtDAO(JVConnection.getInstance());
		return c.create(this);
	}
	
	public ArrayList<Court> FindAll() {
		CourtDAO persDao = new CourtDAO(JVConnection.getInstance());
		return persDao.findAll();
	}
}
