package edu.web.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO : memberResult.jsp에서 이동
//		  로그인된 사용자 아이디를 가져와서 DB에 회원 정보 삭제
//		  삭제 성공 후에 login.jsp 페이지로 이동
@WebServlet("/delete.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MemberDAO dao;
    
    public DeleteServlet() {
    	System.out.println("삭제 서블릿 시작");
    	dao = MemberDAOImple.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("두겟 시작");
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		dao.delete(userId);
		session.invalidate();
		response.sendRedirect("/Homepage_PJM/login.jsp");
//		response.getWriter().print("<script>alert('회원 정보가 삭제되었습니다!');</script>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("두포스트 시작");
	}

}
