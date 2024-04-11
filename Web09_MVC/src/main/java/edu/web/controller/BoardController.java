package edu.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do") // *.do : ~.do로 선언된 HTTP 호출에 대해 반응
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BoardController() {
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	String reqURI = req.getRequestURI();
    	
    	String reqMethod = req.getMethod();
    	
    	System.out.println("호출 경로 : " + reqURI); //: 요청이 발생됬을때 요청을 한 경로
    	
    	System.out.println("호출 방식 : " + reqMethod); // : 요청이 발생됬을때 요청방식
    	
    	if (reqURI.contains("test.do")) {
    		System.out.println("test 호출 확인");
    		if(reqMethod.equals("GET")) {
    			System.out.println("GET 요청 확인");
    			res.sendRedirect("test_get.html");
    		} else {
    			System.out.println("POST 요청 확인");
    			res.sendRedirect("test_post.html");
    		}
    	} else {
    		res.sendRedirect("test_404.html");
    	}
    	
    }


}
