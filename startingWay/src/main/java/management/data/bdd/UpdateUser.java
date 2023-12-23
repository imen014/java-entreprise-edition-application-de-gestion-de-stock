package management.data.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUser {

    public boolean update_password_and_email_user(Connection connection, String password, String email, int id) {

	String requeteUpdateUser = "update users set password=?,email=? where id = ?;";
	try (PreparedStatement preparedStatement = connection.prepareStatement(requeteUpdateUser)) {
	    preparedStatement.setString(1, password);
	    preparedStatement.setString(2, email);
	    preparedStatement.setInt(3, id);
	    int rowsAffected = preparedStatement.executeUpdate();
	    return rowsAffected > 0;

	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}

    }
}
