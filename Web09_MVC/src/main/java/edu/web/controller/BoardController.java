package edu.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import edu.web.domain.BoardVO;
import edu.web.persistence.BoardDAO;
import edu.web.persistence.BoardDAOImple;
import edu.web.util.PageCriteria;
import edu.web.util.PageMaker;

@WebServlet("*.do") // *.do : ~.do로 선언된 HTTP 호출에 대해 반응
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String BOARD_URL = "WEB-INF/board/";
	private static final String LOGIN = "login";
	private static final String MAIN = "index";
	private static final String LIST = "list";
	private static final String REGISTER = "register";
	private static final String DETAIL = "detail";
	private static final String UPDATE = "update";
	private static final String DELETE = "delete";
	private static final String EXTENSION = ".jsp";
	private static final String SERVER_EXTENSION = ".do";
	private static final String MEMBER_SERVER_EXTENSION = ".login";
	private BoardDAO dao;
	
	
	public BoardController() {
		dao = BoardDAOImple.getInstance();
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("보드 컨트롤러 실행");
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
			if (reqMethod.equals("GET")) {
				res.sendRedirect(LOGIN + EXTENSION);
			}
		}
	} // end service()

	

	

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
		
		List<BoardVO> vo = dao.select(criteria);
		String path = BOARD_URL + LIST + EXTENSION;
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		req.setAttribute("vo", vo);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria); // 기본값 
		pageMaker.setTotalCount(dao.getTotalCount());
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
//		String path = BOARD_URL + REGISTER + EXTENSION;
		System.out.println("여기?");
		HttpSession session = req.getSession(false);
		System.out.println("요깅?");
		if (session.getAttribute("userId") != null) {
			System.out.println(session.getAttribute("userId"));
			System.out.println("체크통과?");
			String path = REGISTER + SERVER_EXTENSION;
	        res.sendRedirect(path); 
	        return;
	    } else {
	    	String path = LOGIN + EXTENSION;
	        res.sendRedirect(path);
	    }
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
		HttpSession session = req.getSession(false);
		vo.setBoardTitle(title);
		vo.setBoardContent(content);
		vo.setUserId((String) session.getAttribute(userId));
		if(vo.getUserId()==null) {
			String msg = "게시글 등록에 실패했습니다.";
			req.setAttribute("msg", msg);
			res.sendRedirect(MAIN + EXTENSION);
		} else {
			int result = dao.insert(vo);
			if (result == 1) {
				res.sendRedirect(path);
			}
		}

	}// end registerPOST()

	private void detail(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO : DB테이블에서 상세 조회 데이터를 가져와서, detail.jsp 페이지로 전송, 클라이언트에서 온 req에서 게시글ID 또는
		// userID를 이용해 조회 데이터 전송
		System.out.println("detail()");
		String path = BOARD_URL + DETAIL + EXTENSION; // BOARD_URL 제거
		HttpSession session = req.getSession(false);
//		session.removeAttribute("reqURIF");
		int boardId = Integer.parseInt((String) session.getAttribute("boardId"));
		BoardVO vo = dao.select(boardId);
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		req.setAttribute("vo", vo);
		dispatcher.forward(req, res);
	} // end detail()

	private void updateGET(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO : 전송받은 req에서온 파라미터를 사용한 detail() 조회 데이터를 전송하고, update.jsp 페이지를 호출.
		System.out.println("updateGET()");
		String path = BOARD_URL + UPDATE + EXTENSION;
		int boardId = Integer.parseInt(req.getParameter("boardId"));
		BoardVO vo = dao.select(boardId);
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
		int result = dao.update(vo);
		if (result == 1) {
			String path = BOARD_URL + DETAIL + SERVER_EXTENSION;
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
		int result = dao.delete(boardId);
		if (result == 1) {
			res.sendRedirect(path);
		} else {
			PrintWriter out = res.getWriter();
			out.println("<script>alert('게시글 삭제에 실패했습니다.');</script>");
		}

	} // end deletePOST()

} // end BoardController
