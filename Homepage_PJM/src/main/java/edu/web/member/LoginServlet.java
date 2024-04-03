package edu.web.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * TODO : login.jsp에서 입력받은 아이디, 패스워드를 DB의 데이터와 비교해서
 * 데이터가 일치하면 - 로그인 세션 생성 및 로그인 성공(loginResult.jsp)로 이동
 * (아이디 값에 대한 세션 생성. 세션 만료 시간 60초)
 * 데이터가 일치하지 않으면 - login.jsp로 이동(심심하면 실패 alert 띄우기)
*/
@WebServlet("/loginAuth.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO dao;
	
    public LoginServlet() {
    	dao = MemberDAOImple.getInstance();
    	System.out.println("로그인 서블렛 시작");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// 리퀘스트가 존재하지 않음, url 이동용으로만 사용
		// sendRedirect() : 특정 경로로 이동
		// request는 소멸되기 때문에 데이터를 전송할 수 없음
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ServletContext : 애플리케이션 정보 제공
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		MemberVO vo = new MemberVO();
		vo =  dao.select(userId);
		
		
		if(vo.getUserId() != null) {
			if(vo.getUserId().equals(userId) && vo.getPassword().equals(password)) {
				session.setMaxInactiveInterval(60); // 10초
				session.setAttribute("userId", vo.getUserId());
				session.setAttribute("password", vo.getPassword());
				session.setAttribute("email", vo.getEmail());
				session.setAttribute("emailAgree", vo.getEmailAgree());
				session.setAttribute("interest", vo.getInterestJoin());
				session.setAttribute("phone", vo.getPhone());
				session.setAttribute("introduce", vo.getIntroduce());
				
				response.sendRedirect("/Homepage_PJM/loginResult.jsp");
//				response.getWriter().print("<script>alert('로그인에 성공했습니다!!');</script>");
			} else {
				System.out.println("뭔가가 틀렸네?");
				session.invalidate();
				response.sendRedirect("/Homepage_PJM/login.jsp");
//				response.getWriter().print("<script>alert('아이디 또는 비밀번호가 다릅니다!!');</script>");
			}
	   } else { 
		   session.invalidate();
		   System.out.println("회원이 아니네?");
		   response.sendRedirect("/Homepage_PJM/login.jsp");
//		   response.getWriter().print("<script>alert('아직 우리 회원이 아니시네요!, 회원가입부터 해주세요.!');</script>");
		   
	   }
	}

}




