package web.ch21.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;
	
    public RegisterServlet() {
    	dao = MemberDAOImple.getInstance();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 리퀘스트가 존재하지 않음, url 이동용으로만 사용
		// sendRedirect() : 특정 경로로 이동
		// request는 소멸되기 때문에 데이터를 전송할 수 없음
		
		response.sendRedirect("/Web06_JSP_Servlet/ch21/register.jsp");
	}

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // 한글 인코딩 설정
	        request.setCharacterEncoding("UTF-8");
	        
	        // 폼에서 전송된 데이터 가져오기
	        String userId = request.getParameter("userId");
	        String password = request.getParameter("password");
	        String email = request.getParameter("email");
	        String emailAgree = request.getParameter("emailAgree");
	        String[] interest = request.getParameterValues("interest");
	        String phone = request.getParameter("phone");
	        String introduce = request.getParameter("introduce");
	        
	        // MemberVO 객체 생성 및 데이터 설정
	        MemberVO member = new MemberVO(userId, password, email, emailAgree, interest, phone, introduce);
	        
	        // 받은 데이터 확인 (테스트용)
	        System.out.println(member.toString());
	        
	        // 여기서부터는 데이터 처리 로직을 구현   
	        // 예시: 데이터를 데이터베이스에 저장하거나 다른 서비스에 전달하는 등의 작업을 수행할 수 있습니다.
	        int result = dao.insert(member);
	        System.out.println(result);
	        // 처리 결과에 따른 응답
	        response.getWriter().print("<script>alert('회원 가입을 축하 드립니다!!');</script>");
	        response.sendRedirect("/Web06_JSP_Servlet/ch21/register.jsp");
	    }
	}
