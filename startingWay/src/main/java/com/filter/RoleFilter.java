package com.filter;

import java.io.IOException;

import javax.annotation.security.DeclareRoles;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/restricted/*")
@DeclareRoles({ "ADMIN", "Consultant", "Dirigeant" })
public class RoleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
	HttpServletRequest httpRequest = (HttpServletRequest) request;
	HttpServletResponse httpResponse = (HttpServletResponse) response;

	HttpSession session = httpRequest.getSession(false);

	if (session != null && session.getAttribute("email") != null) {

	    String userRole = (String) session.getAttribute("role");

	    if ("ADMIN".equals(userRole) || "Consultant".equals(userRole) || "Dirigeant".equals(userRole)) {

		chain.doFilter(request, response);
	    } else {

		httpResponse.sendRedirect(httpRequest.getContextPath() + "/access-denied.jsp");
	    }
	} else {

	    httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
	}
    }

    @Override
    public void destroy() {
	// Destruction du filtre
    }
}
