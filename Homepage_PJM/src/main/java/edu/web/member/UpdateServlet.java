package edu.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO : memberUpdate.jsp에서 전송된 데이터로 DB 회원 정보 수정
//		  회원 정보 수정에 성공하면 memberResult.jsp에 MemberVO 데이터 전송하여 출력
@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO dao;

	public UpdateServlet() {
		dao = MemberDAOImple.getInstance();
		System.out.println("업데이트 서블릿 시작");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("두겟 시작");
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") == null) {
			response.sendRedirect("/Homepage_PJM/login.jsp");
//		response.getWriter().print("<script>alert('잘못된 접근경로입니다.');</script>");	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("두포스트 시작");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest = request.getParameterValues("interest");
		String phone = request.getParameter("phone");
		String introduce = request.getParameter("introduce");
		MemberVO vo = new MemberVO(userId, password, email, emailAgree, interest, phone, introduce);
		dao.update(userId, vo);

		request.setAttribute("vo", vo.toString());
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/memberResult.jsp");
		dispatcher.forward(request, response);

		response.sendRedirect("/Homepage_PJM/memberResult.jsp");

	}

}
