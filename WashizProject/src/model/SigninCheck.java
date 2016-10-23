package model;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SigninCheck implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		if (((HttpServletRequest) request).getSession().getAttribute("user") != null) {
		    chain.doFilter(request, response); // User is logged in, just continue request.
		} else {
			//System.out.println("Not logged in");
			request.setAttribute("errmsg", "Login To Continue");
		    ((HttpServletResponse) response).sendRedirect("signin.jsp"); // Not logged in, show login page. You can eventually show the error page instead.
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}