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

import management.data.bdd.ShowMaxProducts;

@WebServlet("/ProductsShoudBeBayed")
public class ProductsShoudBeBayed extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProductsShoudBeBayed() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	this.getServletContext().getRequestDispatcher("/WEB-INF/products_gt_seuil.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	ArrayList<Product> maliste_produits_gt = new ArrayList<>();

	ConnectionClass connect = new ConnectionClass();
	Connection connection = connect.open_connection();

	int quantite_max_else_products_shouldbe_bayed = Integer
		.parseInt(request.getParameter("seuilNumberForBayedEmergency"));

	ShowMaxProducts show_product_gt = new ShowMaxProducts();
	maliste_produits_gt = show_product_gt.show_products_en_max_mode(connection,
		quantite_max_else_products_shouldbe_bayed);

	request.setAttribute("maliste_produits_gt", maliste_produits_gt);

	this.getServletContext().getRequestDispatcher("/WEB-INF/products_should_be_bayed.jsp").forward(request,
		response);

    }

}
