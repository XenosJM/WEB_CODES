package edu.web.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO : memberRegister.jsp에서 전송된 데이터를 DB에 저장
// DB 저장 후에 login.jsp로 이동(심심하면 alert도 띄우기)

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO dao;
       

    public RegisterServlet() {
    	dao = MemberDAOImple.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/Homepage_PJM/memberRegister.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼에서 전송된 데이터 가져오기
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String emailAgree = request.getParameter("emailAgree");
        String[] interest = request.getParameterValues("interest");
        String phone = request.getParameter("phone");
        String introduce = request.getParameter("introduce");
     // MemberVO 객체 생성 및 데이터 설정
        MemberVO vo = new MemberVO(userId, password, email, emailAgree, interest, phone, introduce);
        int result = dao.insert(vo);
       
       // 처리 결과에 따른 응답
        PrintWriter out = response.getWriter();
        if(result == 1) {
        	out.append("<script>alert('회원 가입을 축하 드립니다!!');</script>");
        	out.append("<script>location.href='login.jsp';</script>");
        } else {
        	out.append("<script>alert('회원 가입에 실패했습니다.');</script>");
        	out.append("<script>location.href='memberRegister.jsp';</script>");
        }
//        response.getWriter().print("<script>alert('회원 가입을 축하 드립니다!!');</script>");
	}

}
