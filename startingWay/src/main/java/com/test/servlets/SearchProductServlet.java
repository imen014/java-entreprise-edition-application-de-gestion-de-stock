package com.test.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bd.connections.ConnectionClass;

import management.data.bdd.ReadProducts;

public class SearchProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SearchProductServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	this.getServletContext().getRequestDispatcher("/WEB-INF/recherche_product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	ConnectionClass connect = new ConnectionClass();
	connect.open_connection();
	ReadProducts reader1 = new ReadProducts();
	String nom_produit = request.getParameter("nom_produit");

	List<Map<String, Object>> productListRecherche = reader1.recherche_product_from_db(nom_produit);

	request.setAttribute("productListRecherche", productListRecherche);

	this.getServletContext().getRequestDispatcher("/WEB-INF/resultat_rechercheProduits.jsp").forward(request,
		response);
    }

}
