package edu.web.persistence;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SessionFilter extends HttpFilter implements Filter {
   String userId;
   BoardDAO dao = BoardDAOImple.getInstance();
	
    public SessionFilter() {
    	System.out.println("SessionFilter 생성자");
    }

	public void destroy() {
	}

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String reqURI = req.getRequestURI();
    	String reqMethod = req.getMethod();
    	System.out.println("reqURI = " + reqURI);
    	System.out.println("reqMethod = " + reqMethod);
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		if(userId == null) {
			res.sendRedirect("login.do");
			return;
		}
			
		// place your code here

		// pass the request along the filter chain
		chain.doFilter(req, res);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
