package edu.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import edu.web.domain.BoardVO;
import edu.web.domain.MemberVO;
import edu.web.persistence.BoardDAO;
import edu.web.persistence.BoardDAOImple;
import edu.web.persistence.MemberDAO;
import edu.web.persistence.MemberDAOImple;
import edu.web.persistence.ReplyDAO;
import edu.web.persistence.ReplyDAOImple;
import edu.web.util.PageCriteria;
import edu.web.util.PageMaker;

@WebServlet("*.do") // *.do : ~.do로 선언된 HTTP 호출에 대해 반응
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String BOARD_URL = "WEB-INF/board/";
	private static final String MAIN = "index";
	private static final String LIST = "list";
	private static final String REGISTER = "register";
	private static final String DETAIL = "detail";
	private static final String UPDATE = "update";
	private static final String DELETE = "delete";
	private static final String LOGIN = "login";
	private static final String EXTENSION = ".jsp";
	private static final String SERVER_EXTENSION = ".do";
	private BoardDAO boardDao;
	private MemberDAO memberDao;
	
	public BoardController() {
		boardDao = BoardDAOImple.getInstance();
		memberDao = MemberDAOImple.getInstance();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String reqURI = req.getRequestURI();
		String reqMethod = req.getMethod();
		System.out.println("호출 경로 : " + reqURI); // : 요청이 발생됬을때 요청을 한 경로
		System.out.println("호출 방식 : " + reqMethod); // : 요청이 발생됬을때 요청방식
		// get = 페이지 로드, post = 데이터 전송
		// 로그인 성공시 세션 생성후, 메인 페이지 로드(list)

		if (reqURI.contains(LIST + SERVER_EXTENSION)) {
			System.out.println("list 호출 확인");
			list(req, res);
		} else if (reqURI.contains(REGISTER + SERVER_EXTENSION)) {
			System.out.println("register 호출 확인");
			if (reqMethod.equals("GET")) {
				registerGET(req, res);
			} else if (reqMethod.equals("POST")) {
				registerPOST(req, res);
			} // end register
		} else if (reqURI.contains(DETAIL + SERVER_EXTENSION)) {
			System.out.println("detail 호출 확인");
			detail(req, res);
		} else if (reqURI.contains(UPDATE + SERVER_EXTENSION)) {
			System.out.println("update 호출 확인");
			if (reqMethod.equals("GET")) {
				updateGET(req, res);
			} else if (reqMethod.equals("POST")) {
				updatePOST(req, res);
			} // end update
		} else if (reqURI.contains(DELETE + SERVER_EXTENSION)) {
			System.out.println("delete 호출 확인");
			if (reqMethod.equals("POST")) {
				deletePOST(req, res);
			} // end delete
		} else if (reqURI.contains(LOGIN + SERVER_EXTENSION)) {
			System.out.println("login 호출 확인");
//	    		if(reqMethod.equals("GET")) {
//			login(req, res);
//	    		} // POST는 나눠야 하면 나눌것
		}
	} // end service()

	// 게시글 클릭시 로그인창으로 이동후 로그인 성공시 다시 클릭했던 게시글로 이동(뭔짓을 한거지 네이버는)
	// 비회원으로 게시판 둘러보기 가능(세션이 있던 없던 가능하단 소리), 게시글 클릭시 세션체크후 세션이 있다면, 게시글로 이동
	// 세션이 없다면, 로그인으로 이동후(이동했을때 경로에 따라 상세보기에서이동시 게시글 번호값 전송, 그냥 로그인 버튼 눌렀을때는 또 따로)
	// 로그인 진행(로그인 겟으로 이동해서 창을 띄워야함), 로그인 성공시 클릭했던 게시글로 이동(세션을 생성후 이동하는데 이동하는 경로는
	// 상세검색으로 가되 전송받았던 게시글 아이디와 함께 이동해서 게시글 상세보기화면으로 이동)
//	private void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		System.out.println("login()");
//		String path = LOGIN + EXTENSION;
//		String reqMethod = req.getMethod();
//		String userIdPara = req.getParameter("userId");
//		String password = req.getParameter("password");
////    	System.out.println("reqURIori = " + reqURIori);
//		// false : session을 새로 생성안하고 기존 세션(세션필터)를 불러오겠다는 뜻
//		HttpSession session = req.getSession(false);
////		if (reqMethod.equals("GET")) {
////			res.sendRedirect(path + "?msg=" + URLEncoder.encode("로그인 해주세욧!", "UTF-8"));
//		 if (session.getAttribute("userId") == null) { 
//			MemberVO vo = memberDao.select(userIdPara);
//			if (vo != null) {
//				String id = vo.getUserId();
//				String pw = vo.getUserPassword();
//				if (userIdPara.equals(id) && password.equals(pw)) {
//					session.setMaxInactiveInterval(600);
//					session.setAttribute("userId", vo.getUserId());
//					String msg = "로그인 되셧습니다!";
//					req.setAttribute("msg", msg);
//					String reqURI = (String) session.getAttribute("reqURI");
//					System.out.println("login() reqURI = " + reqURI);
//					if(reqURI.contains(LIST)) {
//						path = LIST + EXTENSION;
//						RequestDispatcher dispatcher = req.getRequestDispatcher(path);
//						dispatcher.forward(req, res);	
//					} else if(reqURI.contains(DETAIL)) {
//						path = DETAIL + SERVER_EXTENSION;
//						RequestDispatcher dispatcher = req.getRequestDispatcher(path);
//						dispatcher.forward(req, res);
//					}
//				} else {
//					String msg = "아이디 또는 비밀번호가 틀렸습니다.";
//					req.setAttribute("msg", msg);
//					path = DETAIL + EXTENSION;
//					res.sendRedirect(path);
//				} // end id & password 체크
//			} else {
//				String msg = "회원이 아니시네요.";
//				req.setAttribute("msg", msg);
//				path = DETAIL + EXTENSION;
//				res.sendRedirect(path);
//			} // end null체크
//		} 
//		 else {
//			path = DETAIL + EXTENSION;
//			res.sendRedirect(path);
//		}
//	} // end loginDO()

//    private void loginPOST(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//    	
//    } // end loginPOST()

	// 전체 게시판 내용(list)을 DB에서 가져오고, 그 데이터를 list.jsp 페이지에 전송
	private void list(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("list()");
//		List<BoardVO> vo = boardDao.select(); // list로 변경해야함
		// 현재 페이지를 저장하기 위한 변수 이 시점의 page값은 null
		String page = req.getParameter("page"); 
		// page와 한 페이지에 최대로 나타낼 기본값이 세팅되어있는 기본 생성자로 객체 생성 
		PageCriteria criteria = new PageCriteria();
		if(page != null) { 
			// 변수 page값이 null이 아니라면 criteria객체에 현재 페이지값을 저장 
			criteria.setPage(Integer.parseInt(page));		
		}
		
		List<BoardVO> vo = boardDao.select(criteria);
		String path = BOARD_URL + LIST + EXTENSION;
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		req.setAttribute("vo", vo);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria); // 기본값 
		pageMaker.setTotalCount(boardDao.getTotalCount());
		pageMaker.setPageData();
		System.out.println("전체 게시글 수  = " + pageMaker.getTotalCount());
		System.out.println("현재 선택된 페이지 = " + criteria.getPage());
		System.out.println("한 페이지 당 게시글 수 = " + pageMaker.getNumsOfPageLinks());
		System.out.println("시작 페이지 링크 번호 = " + pageMaker.getStartPageNo());
		System.out.println("끝 페이지 링크 번호 = " + pageMaker.getEndPageNo());
		req.setAttribute("pageMaker", pageMaker);
		dispatcher.forward(req, res);
	} // end list()

	private void registerGET(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("registerGET()");
		String path = REGISTER + EXTENSION;
		res.sendRedirect(path);
	} // end registerGET()

	private void registerPOST(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO : register.jsp에서 form으로 전송된 데이터를 DB테이블에 등록후 index.jsp로 이동
		System.out.println("registerPOST()");
		String path = MAIN + EXTENSION;
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String userId = req.getParameter("userId");
		System.out.println("title : " + title + ", content : " + content + ", userId : " + userId);
		BoardVO vo = new BoardVO(0, title, content, userId, null);
		vo.setBoardTitle(title);
		int result = boardDao.insert(vo);
		if (result == 1) {
			res.sendRedirect(path);
		}
//		else {
//			String msg = "게시글 등록에 실패했습니다.";
//			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
//			req.setAttribute("msg", msg);
//			dispatcher.forward(req, res);
//		}

	}// end registerPOST()

	private void detail(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO : DB테이블에서 상세 조회 데이터를 가져와서, detail.jsp 페이지로 전송, 클라이언트에서 온 req에서 게시글ID 또는
		// userID를 이용해 조회 데이터 전송
		System.out.println("detail()");
		String path = BOARD_URL + DETAIL + EXTENSION; // BOARD_URL 제거
//		HttpSession session = req.getSession(false);
//		session.removeAttribute("reqURIF");
		int boardId = Integer.parseInt(req.getParameter("boardId"));
		BoardVO vo = boardDao.select(boardId);
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		req.setAttribute("vo", vo);
		dispatcher.forward(req, res);
	} // end detail()

	private void updateGET(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO : 전송받은 req에서온 파라미터를 사용한 detail() 조회 데이터를 전송하고, update.jsp 페이지를 호출.
		System.out.println("updateGET()");
		String path = BOARD_URL + UPDATE + EXTENSION;
		int boardId = Integer.parseInt(req.getParameter("boardId"));
		BoardVO vo = boardDao.select(boardId);
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		req.setAttribute("vo", vo);
		dispatcher.forward(req, res);
	} // end updateGET()

	private void updatePOST(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO : update.jsp에서 전송된 수정한 데이터를 DB로 전송하여 테이블 수정 수행, 수정이 완료되면, detail.jsp로
		// 이동(이동시 어떤 값 전송필요)
		System.out.println("updatePOST()");
		int boardId = Integer.parseInt(req.getParameter("boardId"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String userId = req.getParameter("userId");
		BoardVO vo = new BoardVO(boardId, title, content, userId, null);
		int result = boardDao.update(vo);
		if (result == 1) {
			String path = DETAIL + SERVER_EXTENSION;
			res.sendRedirect(path + "?boardId=" + boardId);
		} else {
			PrintWriter out = res.getWriter();
			out.println("<script>alert('게시글 수정에 실패했습니다. 빠졌네요. 데이터가');</script>");
		}

	}// end updatePOST()

	private void deletePOST(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO : 전송받은 게시글 번호를 이용해 DB에서 데이터 삭제, 성공시 index.jsp로 이동
		System.out.println("deletePOST()");
		String path = MAIN + EXTENSION;
		int boardId = Integer.parseInt(req.getParameter("boardId"));
		int result = boardDao.delete(boardId);
		if (result == 1) {
			res.sendRedirect(path);
		} else {
			PrintWriter out = res.getWriter();
			out.println("<script>alert('게시글 삭제에 실패했습니다.');</script>");
		}

	} // end deletePOST()

} // end BoardController
