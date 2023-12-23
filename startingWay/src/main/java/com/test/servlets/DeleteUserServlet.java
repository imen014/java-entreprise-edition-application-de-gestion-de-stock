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

import management.data.bdd.DeleteUserFromBdd;

@WebServlet("/DeleteUserServlet")
@RolesAllowed("ADMIN")
public class DeleteUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteUserServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	ConnectionClass connect = new ConnectionClass();
	Connection connection = connect.open_connection();

	String UserId = request.getParameter("UserId");

	if (UserId != null && !UserId.isEmpty()) {

	    int UserIdSupp = Integer.parseInt(UserId);
	    DeleteUserFromBdd deleter1 = new DeleteUserFromBdd();
	    deleter1.supprimer_user(connection, UserIdSupp);

	} else {
	    response.getWriter().write("ID User invalide");

	}

	this.getServletContext().getRequestDispatcher("/WEB-INF/user_deleted.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
    }

}
