package edu.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    	} 
    }
    
    // ajax 통신으로 댓글 json 데이터를 전송받아, db에 저장하고, 저장에 성공하면 success 메시지를 다시 돌려줌
	private void replyAdd(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String obj = req.getParameter("obj");
		System.out.println(obj);
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(obj);
			
			int boardId = Integer.parseInt((String) jsonObject.get("boardId"));
			String userId = (String) jsonObject.get("userId");
			String replyContent = (String) jsonObject.get("replyContent");
			
			ReplyVO vo = new ReplyVO(0, boardId, 0, userId, replyContent, null);
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





