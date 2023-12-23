package com.test.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.annotation.security.RolesAllowed;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bd.connections.ConnectionClass;

import management.data.bdd.UpdateUser;

@WebServlet("/UpdateUserServlet")
@RolesAllowed("ADMIN")
public class UpdateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateUserServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	this.getServletContext().getRequestDispatcher("/WEB-INF/user_update_form.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ConnectionClass connect = new ConnectionClass();
	Connection connection = connect.open_connection();

	String userId = request.getParameter("id");
	String password = request.getParameter("password");
	String email = request.getParameter("email");

	if (userId != null && !userId.isEmpty()) {
	    int UserIdUpdate = Integer.parseInt(userId);
	    UpdateUser updater1 = new UpdateUser();
	    updater1.update_password_and_email_user(connection, password, email, UserIdUpdate);

	    PrintWriter out = response.getWriter();
	    out.write("modification avec succées !");
	    out.close();
	} else {

	    response.getWriter().write("ID User invalide");
	}

	this.getServletContext().getRequestDispatcher("/WEB-INF/user_updated.jsp").forward(request, response);
    }

}
