package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
	// Objet de connexion
	private static Connection connect = getInstance();
	// URL de la connexion
	private String url = "jdbc:ucanaccess://./dbPartageJeu.accdb";

	// Constructeur privé
	private SingletonConnection() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			connect = DriverManager.getConnection(url);
		} catch (SQLException ex) {
			System.out.println("Erreur JDBC: " + ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println("Classe de driver introuvable : " + ex.getMessage());
			System.exit(0);
		}
	}

	// Méthode qui va nous retourner notre instance et la créer si elle n'existe
	// pas
	public static Connection getInstance() {
		if (connect == null)
			new SingletonConnection();
		return connect;
	}
}

