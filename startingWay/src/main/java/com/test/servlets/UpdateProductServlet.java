package com.test.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bd.connections.ConnectionClass;

import management.data.bdd.UpdateProduct;

@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateProductServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	this.getServletContext().getRequestDispatcher("/WEB-INF/update_product.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	ConnectionClass connect = new ConnectionClass();
	Connection connection = connect.open_connection();

	String ancien_nom_produit = request.getParameter("ancien_nom_produit");
	String nouveau_nom_produit = request.getParameter("nouveau_nom_produit");
	int nouveau_quantite_stock = Integer.parseInt(request.getParameter("NouvelleQuantite_stock"));

	UpdateProduct updater1 = new UpdateProduct();
	boolean updated = updater1.updateProduct(connection, ancien_nom_produit, nouveau_nom_produit,
		nouveau_quantite_stock);

	if (updated) {

	    request.setAttribute("nouveau_nom_produit", nouveau_nom_produit);
	    request.setAttribute("nouveau_quantite_stock", nouveau_quantite_stock);
	    request.setAttribute("ancien_nom_produit", ancien_nom_produit);

	    String message = "product updated succefully !";
	    request.setAttribute("message", message);

	} else {

	    String message = "Mise à jour non aboutie !";
	    request.setAttribute("message", message);

	}

	this.getServletContext().getRequestDispatcher("/WEB-INF/confirmation_update_product.jsp").forward(request,
		response);

    }

}
