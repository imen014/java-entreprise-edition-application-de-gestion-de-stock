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

public class StartingWayServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public StartingWayServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	ConnectionClass connect = new ConnectionClass();
	connect.open_connection();
	ReadData read_data1 = new ReadData();

	List<Map<String, Object>> dataList = read_data1.read_data_from_db();

	request.setAttribute("dataList", dataList);

	this.getServletContext().getRequestDispatcher("/WEB-INF/displayData.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	this.getServletContext().getRequestDispatcher("/WEB-INF/recherche_user.jsp").forward(request, response);

    }

}
