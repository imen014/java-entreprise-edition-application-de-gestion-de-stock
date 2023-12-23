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

public class ReadProducts {

    public List<Map<String, Object>> read_data_products_from_db() {
	ConnectionClass connect = new ConnectionClass();
	Connection connection = connect.open_connection();

	String monrequete = "SELECT * FROM products";
	List<Map<String, Object>> dataList = new ArrayList<>();

	try {
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery(monrequete);

	    while (resultSet.next()) {
		Map<String, Object> row = new HashMap<>();
		row.put("id", resultSet.getInt("id"));
		row.put("nom_produit", resultSet.getString("nom_produit"));
		row.put("quantite_stock", resultSet.getString("quantite_stock"));
		row.put("price", resultSet.getString("prix"));
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

    public List<Map<String, Object>> recherche_product_from_db(String nom_produit) {
	ConnectionClass connect = new ConnectionClass();
	Connection connection = connect.open_connection();

	String monrequete = "SELECT * FROM products WHERE nom_produit=?";
	List<Map<String, Object>> productList = new ArrayList<>();

	try {
	    PreparedStatement preparedStatement = connection.prepareStatement(monrequete);
	    preparedStatement.setString(1, nom_produit);
	    ResultSet resultSet = preparedStatement.executeQuery();

	    while (resultSet.next()) {
		Map<String, Object> row = new HashMap<>();
		row.put("id", resultSet.getInt("id"));
		row.put("nom_produit", resultSet.getString("nom_produit"));
		row.put("quantite_stock", resultSet.getInt("quantite_stock"));
		productList.add(row);
	    }

	    resultSet.close();
	    preparedStatement.close();
	    connect.closeConnection();

	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return productList;
    }

}
