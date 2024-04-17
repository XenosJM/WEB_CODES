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
   private static final String LOGIN = "login";    
   private static final String DETAIL = "detail";
   private static final String EXTENSION = ".jsp";
   private static final String MEMBER_SERVER_EXTENSION = ".login";
   BoardDAO dao = BoardDAOImple.getInstance();
	
    public SessionFilter() {
    	System.out.println("SessionFilter 생성자");
    }

	public void destroy() {
	}

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
    	
		HttpSession session = req.getSession(false);
		if(session.getAttribute("msg")!=null) {
			session.removeAttribute("msg");
		}
		String reqURI = req.getRequestURI();
		System.out.println("sessionFilter reqURI = " + reqURI);
		
		if(!reqURI.contains(MEMBER_SERVER_EXTENSION)) {
			session.setAttribute("reqURI", reqURI);
			System.out.println("session reqURI = " + session.getAttribute("reqURI"));
		}
		if(reqURI.contains(DETAIL) && session.getAttribute("boardId")==null){
			session.setAttribute("boardId", req.getParameter("boardId"));
			System.out.println("req boardId = " + req.getParameter("boardId") + ", session boardId = " + session.getAttribute("boardId"));
		}
		if(session.getAttribute("userId") == null) { 
			String msg = "로그인이 필요한 페이지입니다.";
			session.setAttribute("msg", msg);
			String path = LOGIN + EXTENSION;
			res.sendRedirect(path);
			return;
		}
			
		// place your code here

		// pass the request along the filter chain
		chain.doFilter(req, res);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
