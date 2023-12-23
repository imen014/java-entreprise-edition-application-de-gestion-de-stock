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

import management.data.bdd.DeleteProductFromBdd;

@WebServlet("/DeleteProductServlet")
@RolesAllowed("ADMIN")
public class DeleteProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteProductServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	ConnectionClass connect = new ConnectionClass();
	Connection connection = connect.open_connection();

	String productId = request.getParameter("productId");

	if (productId != null && !productId.isEmpty()) {

	    int productIdSupp = Integer.parseInt(productId);

	    DeleteProductFromBdd deleter1 = new DeleteProductFromBdd();
	    boolean deleted = deleter1.supprimer_produit(connection, productIdSupp);
	    if (deleted) {
		request.setAttribute("productIdSupp", productIdSupp);
	    } else {

		String message = "suppression non aboutie !";
		request.setAttribute("message", message);

	    }

	} else {
	    String message = "ID de produit invalide";
	    request.setAttribute("message", message);
	}

	this.getServletContext().getRequestDispatcher("/WEB-INF/confirmation_deleted.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
    }

}
