package management.data.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUser {

    public boolean isValidLogin(Connection connection, String email, String password) {

	String monrequete = "select * from users where email=? and password=?;";
	try {
	    PreparedStatement preparedStatement = connection.prepareStatement(monrequete);
	    preparedStatement.setString(1, email);
	    preparedStatement.setString(2, password);

	    try (ResultSet resultSet = preparedStatement.executeQuery()) {

		return resultSet.next();
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return false;
	}

    }

}
