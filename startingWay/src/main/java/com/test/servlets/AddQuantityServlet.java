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

import management.data.bdd.UpdateProduct;

@WebServlet("/AddQuantityServlet")
@RolesAllowed("ADMIN")
public class AddQuantityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddQuantityServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	this.getServletContext().getRequestDispatcher("/WEB-INF/add_quantity.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	try {

	    ConnectionClass connect = new ConnectionClass();
	    Connection connection = connect.open_connection();

	    int quantity_to_add = Integer.parseInt(request.getParameter("quantity_to_add"));
	    String name_product = request.getParameter("product_name");

	    UpdateProduct updater = new UpdateProduct();
	    updater.updateProductAddQuantity(connection, name_product, quantity_to_add);

	    String message = "Quantity added succefully  !";
	    request.setAttribute("message", message);
	} catch (Exception e) {
	    String message = ("there's something to handle  !" + e.getMessage());
	    request.setAttribute("message", message);
	}

	this.getServletContext().getRequestDispatcher("/WEB-INF/quatity_product_added.jsp").forward(request, response);

    }

}
