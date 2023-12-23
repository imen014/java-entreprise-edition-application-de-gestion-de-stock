package com.bd.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    Connection connection;

    String username = "imen2023";
    String password = "Password2023";
    String db_name = "respecdimen2023";
    String server_address = "respecdimen2023.mysql.db";

    public Connection open_connection() {
	try {
	    // charger le pilote JDBC pour mysql
	    Class.forName("com.mysql.cj.jdbc.Driver");

	    // etablir la connexion à la base de données
	    connection = DriverManager.getConnection("jdbc:mysql://" + server_address + "/"+ db_name, username, password);

	    if (connection != null) {
		System.out.println("connexion établie avec succés !");
	    }

	} catch (ClassNotFoundException e) {
	    System.out.println("Driver JDBC introuvable !" + e.getMessage());

	} catch (SQLException e) {
	    System.out.println("erreur de connection à la base de données " + e.getMessage());

	}

	return connection;

    }

    public void closeConnection() {
	try {
	    if (connection != null && !connection.isClosed()) {
		connection.close();
		System.out.println("connexion fermée avec succées !");

	    }

	} catch (SQLException e) {
	    System.out.println("erreur lors de dermeture de connection  " + e.getMessage());

	}
    }
}
