package com.test.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bd.connections.ConnectionClass;

import management.data.bdd.ReadData;

public class RechercheUserNameServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RechercheUserNameServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	this.getServletContext().getRequestDispatcher("/WEB-INF/recherche_user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ConnectionClass connect = new ConnectionClass();
	connect.open_connection();
	ReadData reader1 = new ReadData();
	String username = request.getParameter("username");

	List<Map<String, Object>> dataListRecherche = reader1.recherche_data_from_db(username);

	request.setAttribute("dataListRecherche", dataListRecherche);

	this.getServletContext().getRequestDispatcher("/WEB-INF/resultat_recherche.jsp").forward(request, response);

    }

}
