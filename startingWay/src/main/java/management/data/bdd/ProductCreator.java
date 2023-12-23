package management.data.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductCreator {

    public boolean create_product(Connection connection, String name_product, int quantite_stock) {

	String monrequete = "insert into products(nom_produit,quantite_stock)VALUES(?,?);";
	boolean created;

	try {
	    if (!isProductExist(connection, name_product)) {

		PreparedStatement preparedStatement = connection.prepareStatement(monrequete);
		preparedStatement.setString(1, name_product);
		preparedStatement.setInt(2, quantite_stock);

		preparedStatement.executeUpdate();

		created = true;

	    } else {
		created = false;
		System.out.println("product exist in bd");
	    }

	} catch (SQLException e) {

	    created = false;
	    e.printStackTrace();
	}

	return created;

    }

    public boolean isProductExist(Connection connection, String productName) {
	String query = "SELECT COUNT(*) FROM products WHERE name = ?";
	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	    preparedStatement.setString(1, productName);
	    try (ResultSet resultSet = preparedStatement.executeQuery()) {
		if (resultSet.next()) {
		    return resultSet.getInt(1) > 0; // True if the product exists
		}
	    }
	} catch (SQLException e) {
	    e.printStackTrace(); // Handle the exception appropriately
	}
	return false;
    }

    public boolean isProductCreated(Connection connection, String code_produit) {
	String query = "SELECT COUNT(*) FROM products WHERE code_produit = ?";
	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	    preparedStatement.setString(1, code_produit);
	    try (ResultSet resultSet = preparedStatement.executeQuery()) {
		if (resultSet.next()) {
		    return resultSet.getInt(1) > 0; // True if the product exists
		}
	    }
	} catch (SQLException e) {
	    e.printStackTrace(); // Handle the exception appropriately
	}
	return false;
    }

}
