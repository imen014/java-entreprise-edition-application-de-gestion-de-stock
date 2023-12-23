package com.test.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bd.connections.ConnectionClass;

import management.data.bdd.LoginUser;
import management.data.bdd.ReadData;

@WebServlet("/LoginUserServlet")
public class LoginUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginUserServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	ConnectionClass connect = new ConnectionClass();
	Connection connection = connect.open_connection();
	LoginUser login_user1 = new LoginUser();

	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String username = request.getParameter("username");

	if (login_user1.isValidLogin(connection, email, password)) {

	    ReadData role_reader = new ReadData();
	    String role = role_reader.getRoleFromDB(connection, email);

	    HttpSession session = request.getSession();
	    session.setAttribute("email", email);
	    session.setAttribute("role", role);

	    String message = ("welcome to home ! u are a " + role);
	    request.setAttribute("message", message);

	} else {
	    String message = "non valid input !";
	    request.setAttribute("message", message);
	}
	this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);

    }

}
