package management.data.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserFromBdd {

    public boolean supprimer_user(Connection connection, int UserId) {

	String requeteSuppressionUser = "DELETE FROM users WHERE id = ?";
	try (PreparedStatement preparedStatement = connection.prepareStatement(requeteSuppressionUser)) {
	    preparedStatement.setInt(1, UserId);
	    int rowsAffected = preparedStatement.executeUpdate();
	    return rowsAffected > 0;

	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}

    }

}
