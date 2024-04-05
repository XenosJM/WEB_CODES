package edu.web.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO : 로그인된 사용자만 접근 가능.
// userid 세션을 제거하고, login.jsp로 이동
@WebServlet("/logout.do")
public class LogoutSetvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LogoutSetvlet() {
    	System.out.println("로그아웃 서블릿 시작");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("두겟이 시작");
		HttpSession session = request.getSession();
		if(session.getAttribute("userId") != null) {
			session.removeAttribute("userId");
			response.sendRedirect("/Homepage_PJM/login.jsp");		
		} else {
			response.sendRedirect("/Homepage_PJM/login.jsp");
//			response.getWriter().print("<script>alert('로그인을 안하셨네요!');</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("두포스트가 시작");
	}

}
