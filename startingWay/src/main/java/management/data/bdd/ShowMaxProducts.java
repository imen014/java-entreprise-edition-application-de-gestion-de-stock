package management.data.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.octest.beans.Product;

public class ShowMaxProducts {

    public ArrayList<Product> show_products_en_max_mode(Connection connection, int quantite_max_seuil) {

	ArrayList<Product> liste_produits_en_max_mode = new ArrayList<>();

	String monrequete = "select * from products where quantite_stock > ?";
	try {
	    PreparedStatement preparedStatement = connection.prepareStatement(monrequete);
	    preparedStatement.setInt(1, quantite_max_seuil);
	    ResultSet resultSet = preparedStatement.executeQuery();

	    while (resultSet.next()) {
		String product_name = resultSet.getString("nom_produit");
		int quantity = resultSet.getInt("quantite_stock");
		float prix = resultSet.getFloat("prix");

		Product product = new Product(product_name, quantity, prix);
		liste_produits_en_max_mode.add(product);

	    }

	} catch (SQLException e) {

	    e.printStackTrace();
	}

	return liste_produits_en_max_mode;

    }

}
