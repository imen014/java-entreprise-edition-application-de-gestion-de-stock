package com.test.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.annotation.security.RolesAllowed;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bd.connections.ConnectionClass;

import management.data.bdd.ProductCreator;

@WebServlet("/CreateProductServlet")
@RolesAllowed("ADMIN")
public class CreateProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CreateProductServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	this.getServletContext().getRequestDispatcher("/WEB-INF/create_product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	ConnectionClass connect = new ConnectionClass();
	Connection connection = connect.open_connection();

	String nom_produit = request.getParameter("nom_produit");
	int quantite_stock = Integer.parseInt(request.getParameter("quantite_stock"));

	ProductCreator creator1 = new ProductCreator();
	boolean created = creator1.create_product(connection, nom_produit, quantite_stock);

	if (created) {

	    String message = "product created succefully";
	    request.setAttribute("message", message);

	} else {

	    String message = "insertion non aboutie! produit existe deja dans bdd";
	    request.setAttribute("message", message);
	}

	this.getServletContext().getRequestDispatcher("/WEB-INF/product_created.jsp").forward(request, response);

    }

}
