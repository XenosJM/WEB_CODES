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
	private static final String LIST = "list";
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

		HttpSession session = req.getSession();
//		int boardId = (int) session.getAttribute("boardId"); 
		String boardId = req.getParameter("boardId");
		String reqURI = req.getRequestURI();
//		if(boardId != null) {
//			session.removeAttribute(boardId);
//		}

		if (session.getAttribute("msg") != null) {
			session.removeAttribute("msg");
		}
		System.out.println("sessionFilter reqURI = " + reqURI);

		if (!reqURI.contains(MEMBER_SERVER_EXTENSION)) {
			session.setAttribute("reqURI", reqURI);
			System.out.println("session reqURI = " + session.getAttribute("reqURI"));
		}
		if (reqURI.contains(DETAIL) && boardId != null) {
			session.setAttribute("boardId", req.getParameter("boardId"));
			System.out.println("req boardId = " + req.getParameter("boardId") + ", session boardId = "
					+ session.getAttribute("boardId"));
		}
		if (!reqURI.contains(LIST) && session.getAttribute("userId") == null) {
			String msg = "로그인이 필요한 페이지입니다.";
			session.setAttribute("msg", msg);
			String path = LOGIN + EXTENSION;
			res.sendRedirect(path);
			return;
		}
		// 로그아웃 누를시 세션체크를 통해 로그아웃 메시지를 함께 전송 가능.

		// place your code here

		// pass the request along the filter chain
		chain.doFilter(req, res);
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
