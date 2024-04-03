package edu.web.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO : loginResult.jsp에서 이동
// 로그인된 사용자의 정보를 DB에서 select
// select된 MemberVO 데이터를 memberResult.jsp로 전송
@WebServlet("/select.do")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO dao;
       
    public SelectServlet() {
    	System.out.println("셀렉트 서블릿 실행");
    	dao = MemberDAOImple.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("두겟이 실행");
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		System.out.println(userId);
		MemberVO vo = new MemberVO();
		vo = dao.select(userId);
		session.setAttribute("회원정보", vo.toString());
		response.sendRedirect("/Homepage_PJM/memberResult.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("둥포스트가 실행");
	}

}
