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

public class ListerProductsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ListerProductsServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	ConnectionClass connect = new ConnectionClass();
	connect.open_connection();
	ReadProducts reader1 = new ReadProducts();
	List<Map<String, Object>> productList = reader1.read_data_products_from_db();

	request.setAttribute("productList", productList);

	this.getServletContext().getRequestDispatcher("/WEB-INF/liste_products.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

    }

}
