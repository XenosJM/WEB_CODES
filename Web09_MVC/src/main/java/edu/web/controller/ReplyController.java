package edu.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import edu.web.domain.ReplyVO;
import edu.web.persistence.ReplyDAO;
import edu.web.persistence.ReplyDAOImple;

/**
 * Servlet implementation class ReplyController
 */
@WebServlet("/replies/*")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReplyDAO dao;
   
    public ReplyController() {
    	dao = ReplyDAOImple.getInstance();
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	String reqURI = req.getRequestURI();
    	System.out.println("service 호출 reqURI = " + reqURI);
    	
    	if(reqURI.contains("add")) {
    		System.out.println("add 호출 확인");
    		replyAdd(req, res);
    	} else if(reqURI.contains("all")) {
    		System.out.println("all 호출 확인");
    		replyList(req, res);
    	} else if(reqURI.contains("update")) {
    		System.out.println("update 호출 확인");
    		update(req, res);
    	} else if(reqURI.contains("delete")) {
    		System.out.println("delete 호출 확인");
    		delete(req,res);
    	}
    }
    
    private void delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	System.out.println("replyDelete()");
    	int replyId = Integer.parseInt(req.getParameter("replyId"));
    	int result = dao.delete(replyId);
    	if(result == 1) {
    		res.getWriter().append("success");
    	}
		
	}

	// 전송될 데이터를 DB에 전달하여 댓글 수정
    // 수정후 성공 메시지를 클라이언트로 전송
    private void update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	int replyId = Integer.parseInt(req.getParameter("replyId"));
    	String replyContent = req.getParameter("replyContent");
    	ReplyVO vo = new ReplyVO(replyId, 0, "", replyContent, null, 0);
    	int result = dao.update(vo);
    	if(result == 1) {
    		res.getWriter().append("success");
    	}
	}

	// 게시글번호를 바탕으로 db에서 댓글 리스트 조회
    // 조회된 댓글 리스트를 json 형태로 변경하여 클라이언트에 전송
    private void replyList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("replyList()");
		System.out.println(req.getParameter("boardId"));
		int boardId = Integer.parseInt((String) req.getParameter("boardId"));
		List<ReplyVO> list = dao.select(boardId);
		JSONArray jsonArray = new JSONArray();
		for(int i = 0; i < list.size(); i++) {
			JSONObject jsonObject = new JSONObject();
			ReplyVO vo = list.get(i);
			jsonObject.put("replyId", vo.getReplyId());
			jsonObject.put("boardId", vo.getBoardId());
			jsonObject.put("userId", vo.getUserId());
			jsonObject.put("replyContent", vo.getReplyContent());
			jsonObject.put("replyDateCreated", vo.getReplyDateCreated().toString());
			jsonObject.put("nestedId", vo.getNestedReplyId());
			jsonArray.add(jsonObject);			
		}
		// 확인
		System.out.println(jsonArray.toString());
		res.getWriter().append(jsonArray.toJSONString());
	}

	// ajax 통신으로 댓글 json 데이터를 전송받아, db에 저장하고, 저장에 성공하면 success 메시지를 다시 돌려줌
	private void replyAdd(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("replyAdd()");
		String obj = req.getParameter("obj");
		System.out.println(obj);
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(obj);
			
			int boardId = Integer.parseInt((String) jsonObject.get("boardId"));
			String userId = (String) jsonObject.get("userId");
			String replyContent = (String) jsonObject.get("replyContent");
			int nestedId = Integer.parseInt((String) jsonObject.get("nestedId"));
			
			ReplyVO vo = new ReplyVO(0, boardId, userId, replyContent, null, nestedId);
			int result = dao.insert(vo);
			if(result == 1) {
				res.getWriter().append("success");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}





