package edu.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.web.domain.MemberVO;
import edu.web.persistence.MemberDAO;
import edu.web.persistence.MemberDAOImple;

@WebServlet("*.login")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String BOARD_URL = "WEB-INF/board/";
	private static final String CHECK = "userCheck";
	private static final String LOGIN = "login";
	private static final String LOGOUT = "logout";
	private static final String REGISTER = "register";
	private static final String MAIN = "index";
	private static final String UPDATE = "update";
	private static final String DETAIL = "detail";
	private static final String EXTENSION = ".jsp";
	private static final String SERVER_EXTENSION = ".do";
	private static final String MEMBER_SERVER_EXTENSION = ".login";
	private MemberDAO dao;

	public MemberController() {
		dao = MemberDAOImple.getInstance();
		System.out.println("제발 호출되어줘");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String reqURI = req.getRequestURI();
		String reqMethod = req.getMethod();
		HttpSession session = req.getSession();
		System.out.println("호출 경로 : " + reqURI); // : 요청이 발생됬을때 요청을 한 경로
		System.out.println("호출 방식 : " + reqMethod); // : 요청이 발생됬을때 요청방식
		System.out.println("session.userId = " + session.getAttribute("userId"));
		 if(reqURI.contains(LOGIN + MEMBER_SERVER_EXTENSION)) {
			if(reqMethod.contains("GET")) {
				loginGet(req, res);				
			} else if(reqMethod.contains("POST")) {
				loginPost(req, res);
			}
		} else if(reqURI.contains(LOGOUT + MEMBER_SERVER_EXTENSION)) {
			logout(req, res);
		}
//		

	}

	private void logout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("logout()");
		HttpSession session = req.getSession();
		session.removeAttribute("userId");
		String msg = "로그아웃하셨습니다.";
		req.setAttribute("msg", msg);
		String path = MAIN + EXTENSION;
		res.sendRedirect(path);
	}

	private void loginGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		String targetURL = req.getParameter("targetURL");
		System.out.println("login()");
//		req.setAttribute("targetURL", targetURL);
//		req.getRequestDispatcher("/WEB-INF/login/login.jsp");
		res.sendRedirect(LOGIN + EXTENSION);
		
	}
	// 게시글 클릭시 로그인창으로 이동후 로그인 성공시 다시 클릭했던 게시글로 이동(뭔짓을 한거지 네이버는)
	// 비회원으로 게시판 둘러보기 가능(세션이 있던 없던 가능하단 소리), 게시글 클릭시 세션체크후 세션이 있다면, 게시글로 이동
	// 세션이 없다면, 로그인으로 이동후(이동했을때 경로에 따라, 상세보기에서이동시 게시글 번호값 전송, 그냥 로그인 버튼 눌렀을때는 또 따로)
	// 로그인 진행(로그인 겟으로 이동해서 창을 띄워야함), 로그인 성공시 클릭했던 게시글로 이동(세션을 생성후 이동하는데 이동하는 경로는
	// 상세검색으로 가되 전송받았던 게시글 아이디와 함께 이동해서 게시글 상세보기화면으로 이동)
	private void loginPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("loginPost()");
		String id = req.getParameter("userId");
		String pw = req.getParameter("password");
//		String targetURL = req.getParameter("targetURL");
		
		MemberVO vo = dao.select(id);
		if (vo != null) {
			HttpSession session = req.getSession();
			System.out.println("세션 생성 완료");
			if (pw.equals(vo.getUserPassword())) {
				session.setMaxInactiveInterval(60);
				session.setAttribute("userId", vo.getUserId());
				System.out.println("세션에 " + session.getAttribute("userId")+ " 사용자 추가 성공!");
				String msg = "로그인 되셧습니다!";
				req.setAttribute("msg", msg);
				String path = (String) session.getAttribute("reqURI");
//				String targetURL = "index.jsp";
//				if(targetURL !+ null){
//					res.sendRedirect(targetURL);
//				} else {
//					res.sendRedirect("index.jsp");
//				}
//				targetURL 존재 유부에 따른경로 설정
//				
//				if(cookies != null) {
//					for(Cookie cookie : cookies) {
//						if(cookie.getName().equals("targetURL")) {
//							 // targetURL 정보를 가져와서
//							 // index.jsp => targetURL(register.do)로 변경
//							 // targetURL 정보는 삭제
//							targetURL = cookie.getValue();
//							cookie.setMaxAge(0);
//							response.addCookie(targetURL);
//						}
//					}
//				}
				if (path != null && (path.contains(REGISTER) || path.contains(DETAIL) || path.contains(UPDATE))) {
					res.sendRedirect(path);
					return;
				} else {
					res.sendRedirect(MAIN + EXTENSION);
//					res.sendRedirect(targetURL);
					return;
				}
				
			} else {
				// 로그인 실패 시
				session.removeAttribute("userId");
				String msg = "아이디 또는 비밀번호가 틀렸습니다.";
				req.setAttribute("msg", msg);
				String path = (String) session.getAttribute("reqURI");
				if (path != null) {
					res.sendRedirect(path);
				} else {
					res.sendRedirect(BOARD_URL + MAIN + SERVER_EXTENSION);
				}
			}
		}

	} // end login()
}
