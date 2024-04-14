package edu.web.persistence;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SessionFilter extends HttpFilter implements Filter {
   String userId;
   private static final String MAIN = "index";
   private static final String LOGIN = "login";
   private static final String EXTENSION = ".jsp";
   private static final String SERVER_EXTENSION = ".do";
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
    	String reqBoardId = req.getParameter("boardId");
//    	System.out.println("reqURI = " + reqURI);
//    	System.out.println("reqMethod = " + reqMethod);
//    	System.out.println("reqBoardId = " + reqBoardId);
    	
		HttpSession session = req.getSession();
		
		String userId = (String) session.getAttribute("userId");
		if(reqURI.contains(MAIN)) {
			res.sendRedirect(MAIN + EXTENSION);
		} else if(userId == null) {
//			RequestDispatcher dispatcher = req.getRequestDispatcher(LOGIN + SERVER_EXTENSION);
			session.setAttribute("reqURIF", reqURI);
			System.out.println(""+ reqURI);
			session.setAttribute("reqBoardId", reqBoardId);
//			dispatcher.forward(req, res);
			res.sendRedirect(LOGIN + SERVER_EXTENSION);
			return;
		}
			
		// place your code here

		// pass the request along the filter chain
		chain.doFilter(req, res);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
