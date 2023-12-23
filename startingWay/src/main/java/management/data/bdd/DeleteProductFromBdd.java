package management.data.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteProductFromBdd {

    public boolean supprimer_produit(Connection connection, int productId) {

	String requeteSuppression = "DELETE FROM PRODUCTS WHERE id = ?";
	try (PreparedStatement preparedStatement = connection.prepareStatement(requeteSuppression)) {
	    preparedStatement.setInt(1, productId);
	    int rowsAffected = preparedStatement.executeUpdate();
	    return rowsAffected > 0;

	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}

    }

}
