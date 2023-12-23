package management.data.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateProduct {

    public boolean updateProduct(Connection connection, String ancien_nom_produit, String newProductName,
	    int newStockQuantity) {
	String updateQuery = "UPDATE products SET nom_produit=?, quantite_stock=? WHERE nom_produit=?";
	try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
	    preparedStatement.setString(1, newProductName);
	    preparedStatement.setInt(2, newStockQuantity);
	    preparedStatement.setString(3, ancien_nom_produit);

	    int rowsUpdated = preparedStatement.executeUpdate();
	    return rowsUpdated > 0;
	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}
    }

    public void updateProductAddQuantity(Connection connection, String productName, int quantityToAdd) {
	String selectQuery = "SELECT quantite_stock FROM products WHERE nom_produit = ?";

	try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
	    selectStatement.setString(1, productName);

	    try (ResultSet resultSet = selectStatement.executeQuery()) {
		if (resultSet.next()) {
		    int currentQuantity = resultSet.getInt("quantite_stock");

		    // Determine the new quantity based on the operation (addition or decrease)
		    int newQuantity = (quantityToAdd > 0) ? (currentQuantity + quantityToAdd)
			    : Math.max(0, currentQuantity + quantityToAdd);

		    // Update the quantity in the database
		    String updateQuery = "UPDATE products SET quantite_stock = ? WHERE nom_produit = ?";
		    try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
			updateStatement.setInt(1, newQuantity);
			updateStatement.setString(2, productName);
			updateStatement.executeUpdate();
		    }
		}
	    }
	} catch (SQLException e) {
	    e.printStackTrace(); // Handle the exception appropriately
	}

    }

    public void updateProductSubstractQuantity(Connection connection, String productName, int quantityToReduce) {
	String selectQuery = "SELECT quantite_stock FROM products WHERE nom_produit = ?";

	try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
	    selectStatement.setString(1, productName);

	    try (ResultSet resultSet = selectStatement.executeQuery()) {
		if (resultSet.next()) {
		    int currentQuantity = resultSet.getInt("quantite_stock");

		    // Determine the new quantity based on the operation (addition or decrease)
		    int newQuantity = (quantityToReduce > 0) ? (currentQuantity - quantityToReduce)
			    : Math.max(0, currentQuantity + quantityToReduce);

		    // Update the quantity in the database
		    String updateQuery = "UPDATE products SET quantite_stock = ? WHERE nom_produit = ?";
		    try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
			updateStatement.setInt(1, newQuantity);
			updateStatement.setString(2, productName);
			updateStatement.executeUpdate();
		    }
		}
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

    }

}
