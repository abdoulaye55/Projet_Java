package be.diallo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import be.diallo.DB.JVConnection;
import be.diallo.POJO.Joueur;
import be.diallo.POJO.Tournoi;

public class JoueurDAO extends DAO<Joueur>{
	
	
	Statement stmt = null;
	ResultSet res = null;
	
	public JoueurDAO(Connection connec){
		super(connec);
	}
	
	//Creer
	public boolean create(Joueur joueur){		
		try
		{
			PersonneDAO pers = new PersonneDAO();
			int id = pers.findId(joueur.GetPseudo());
			
			stmt = connect.createStatement();
			String insertion = "Insert into Joueur(num_joueur_PK) values (" + id + ");";
			//String insertion = "Insert into Joueur(num_joueur_PK, solde) values ((\"SELECT num_pers_PK from personne WHERE pseudo='" + joueur.GetPseudo() + "'\")" + ", '" + joueur.GetSolde() + "');";
			
			int res = stmt.executeUpdate(insertion);
				return true;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}	
	
	//Delete
	public boolean delete(Joueur joueur){
		try
		{			
			stmt = connect.createStatement();
			
			String del = "delete from Joueur where num_joueur_PK = '" + joueur.GetId() + "';";
			
			int res = stmt.executeUpdate(del);
			
			if(res == 1) //del ok
			{
				return true;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	//Update
	public boolean update(Joueur joueur){		
		return false;
	}
	
	//Update solde
	public boolean updatesolde(Joueur joueur){
		try
		{	
			System.out.println(joueur);
			stmt = connect.createStatement();
			
			String upd = "update Joueur set solde = " + joueur.GetAge() + " where num_joueur_PK = " + joueur.GetId() + ";";
			System.out.println(upd);
			int res = stmt.executeUpdate(upd);
			
			if(res == 1) //update ok
			{
				return true;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	//Verif
	public Joueur verif(String pseudo, String mp){
		Joueur joueur = new Joueur();
		try
		{
			stmt = connect.createStatement();
			
			String verif = "SELECT Personne.*, Joueur.* FROM Personne INNER JOIN Joueur ON Personne.num_pers_PK = Joueur.num_joueur_PK where Personne.pseudo = '" + pseudo + "' and Personne.mp = '" + mp +"';";
			res = stmt.executeQuery(verif);			
			
			if(res.next()) //verif ok
			{
				joueur.SetId(res.getInt("Personne.num_pers_PK"));
				joueur.SetPseudo(res.getString("Personne.pseudo"));
				joueur.SetNom(res.getString("Personne.nom"));
				joueur.SetPrenom(res.getString("Personne.prenom"));
				joueur.SetAge(res.getInt("Personne.age"));
				joueur.SetAdresse(res.getString("Personne.adresse"));
				
			}			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return joueur;
	}
	
	//List
	public List<Joueur> list(){
		List<Joueur> list = new ArrayList<Joueur>();
		try
		{
			stmt = connect.createStatement();
			
			String result = "SELECT Joueur.num_joueur_PK, Personne.* FROM Personne INNER JOIN Joueur ON Personne.num_pers_PK = Joueur.num_joueur_PK;";
			res = stmt.executeQuery(result);
			
			while(res.next()) //verif pri
			{
				list.add(new Joueur(res.getInt("Personne.num_pers_PK"), res.getString("Personne.pseudo"), res.getString("Personne.mp"), res.getString("Personne.nom"), res.getString("Personne.prenom"), res.getInt("Personne.age"), res.getString("Personne.adresse")));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Joueur find(int id) {
		PreparedStatement statement;
		try {
			statement = connect.prepareStatement("SELECT * FROM Joueur WHERE num_joueur_PK = ?");
			statement.setInt(1, id);
			ResultSet res = statement.executeQuery();
			Joueur joueur = null;
			while(res.next()) //verif pri
			{
				//joueur = new Joueur(res.getString("personne.pseudo"), res.getString("personne.mp"), res.getString("personne.nom"),  res.getString("personne.prenom"),  res.getInt("personne.age"),  res.getString("personne.adresse"));
				joueur = new Joueur();
				joueur.SetId(id);
			}
			return joueur;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}