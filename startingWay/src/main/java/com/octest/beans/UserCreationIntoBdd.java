package com.octest.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bd.connections.ConnectionClass;

public class UserCreationIntoBdd {

    public void insert_user_intoDB(User user) {
	String message = "";
	ConnectionClass connect = new ConnectionClass();
	Connection connection = connect.open_connection();

	String monrequete = "Insert into users(username,status,password,email,poste,Role)VALUES(?,?,?,?,?,?)";

	try (PreparedStatement preparedStatement = connection.prepareStatement(monrequete)) {

	    if (!isEmailTaken(connection, user.getEmail())) {

		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getStatus());
		preparedStatement.setString(3, user.getPassword());
		preparedStatement.setString(4, user.getEmail());
		preparedStatement.setString(5, user.getPoste());
		preparedStatement.setString(6, user.getRole());

		int rowsAffected = preparedStatement.executeUpdate();
	    } else {
		message = "email deja prix par un autre utilisateur";
		System.out.println(message);
	    }

	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public boolean isEmailTaken(Connection connection, String email) {
	String query = "SELECT COUNT(*) FROM users WHERE email = ?";
	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	    preparedStatement.setString(1, email);
	    try (ResultSet resultSet = preparedStatement.executeQuery()) {
		if (resultSet.next()) {
		    return resultSet.getInt(1) > 0; // True si l'e-mail est déjà pris
		}
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return false;
    }

}
