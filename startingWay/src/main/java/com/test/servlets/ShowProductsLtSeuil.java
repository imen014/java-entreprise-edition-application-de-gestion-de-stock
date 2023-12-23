package com.test.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bd.connections.ConnectionClass;
import com.octest.beans.Product;

import management.data.bdd.ShowLeastProducts;

@WebServlet("/ShowProductsLtSeuil")
public class ShowProductsLtSeuil extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ShowProductsLtSeuil() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	this.getServletContext().getRequestDispatcher("/WEB-INF/show_products_lt_seuil_form.jsp").forward(request,
		response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	ArrayList<Product> maliste_produits_lt = new ArrayList<>();

	ConnectionClass connect = new ConnectionClass();
	Connection connection = connect.open_connection();

	int quantite_reserve = Integer.parseInt(request.getParameter("seuilNumberForReserve"));

	ShowLeastProducts show_product_lt = new ShowLeastProducts();
	maliste_produits_lt = show_product_lt.show_products_en_reserve_mode(connection, quantite_reserve);

	request.setAttribute("maliste_produits_lt", maliste_produits_lt);

	request.getServletContext().getRequestDispatcher("/WEB-INF/get_products_least_seuil.jsp").forward(request,
		response);
    }

}
