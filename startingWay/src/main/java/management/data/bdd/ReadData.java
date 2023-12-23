package management.data.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bd.connections.ConnectionClass;

public class ReadData {

    public List<Map<String, Object>> read_data_from_db() {
	ConnectionClass connect = new ConnectionClass();
	Connection connection = connect.open_connection();

	String monrequete = "SELECT * FROM users";
	List<Map<String, Object>> dataList = new ArrayList<>();

	try {
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery(monrequete);

	    while (resultSet.next()) {
		Map<String, Object> row = new HashMap<>();
		row.put("id", resultSet.getInt("id"));
		row.put("username", resultSet.getString("username"));
		row.put("status", resultSet.getString("status"));
		row.put("email", resultSet.getString("email"));
		row.put("poste", resultSet.getString("poste"));
		row.put("Role", resultSet.getString("Role"));
		dataList.add(row);
	    }

	    resultSet.close();
	    statement.close();
	    connect.closeConnection();

	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return dataList;
    }

    public List<Map<String, Object>> recherche_data_from_db(String username) {
	ConnectionClass connect = new ConnectionClass();
	Connection connection = connect.open_connection();

	String monrequete = "SELECT * FROM users WHERE username=?";
	List<Map<String, Object>> dataList = new ArrayList<>();

	try {
	    PreparedStatement preparedStatement = connection.prepareStatement(monrequete);
	    preparedStatement.setString(1, username);
	    ResultSet resultSet = preparedStatement.executeQuery();

	    while (resultSet.next()) {
		Map<String, Object> row = new HashMap<>();
		row.put("id", resultSet.getInt("id"));
		row.put("username", resultSet.getString("username"));
		row.put("status", resultSet.getString("status"));
		dataList.add(row);
	    }

	    resultSet.close();
	    preparedStatement.close();
	    connect.closeConnection();

	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return dataList;
    }

    public String getRoleFromDB(Connection connection, String email) {
	String query = "select Role from users where email = ?";
	try {
	    PreparedStatement preparedStatement = connection.prepareStatement(query);
	    preparedStatement.setString(1, email);
	    ResultSet resultSet = preparedStatement.executeQuery();
	    if (resultSet.next()) {
		String Role = resultSet.getString("Role");
		return Role;
	    } else {
		System.out.println("utilisateur n'a pas été trouvé");
		return null;
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    return null;

	}
    }
}
