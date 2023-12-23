package com.test.servlets;

import java.io.IOException;

import javax.annotation.security.RolesAllowed;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.beans.User;
import com.octest.beans.UserCreationIntoBdd;

@WebServlet("/CreateAccountUserServlet")
@RolesAllowed("ADMIN")
public class CreateAccountUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CreateAccountUserServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	this.getServletContext().getRequestDispatcher("/WEB-INF/inscription_user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String message;

	try {

	    String selectedRole = request.getParameter("role");
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    String email = request.getParameter("email");
	    String poste = request.getParameter("poste");
	    String status = request.getParameter("status");

	    User userCreation = new User(username, password, email, poste, status, selectedRole);

	    UserCreationIntoBdd user_creation1 = new UserCreationIntoBdd();
	    user_creation1.insert_user_intoDB(userCreation);

	    message = "succeffully created !";
	    request.setAttribute("message", message);

	} catch (Exception e) {
	    message = ("création compte n'a pas aboutie ! vérifier console" + e.getMessage());
	    request.setAttribute("message", message);
	}

	this.getServletContext().getRequestDispatcher("/WEB-INF/user_created.jsp").forward(request, response);

    }

}
