package Dao;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class DAO<T> {
	protected Connection connect = null;

	public DAO(Connection conn) {
		this.connect = conn;
	}

	public abstract int create(T obj);
	public abstract void delete(int id);
	public abstract void update(int id);
	public abstract T find(int id);
	public abstract ArrayList<T> getList();
	public abstract T get(String string);
}
