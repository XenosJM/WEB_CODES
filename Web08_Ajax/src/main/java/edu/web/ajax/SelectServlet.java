package edu.web.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@WebServlet("/select.do")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SearchDAO dao;
   
    public SelectServlet() {
    dao = SearchDAOImple.getInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String txt = request.getParameter("txt");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("doPost txt : " + txt);
		List<SearchVO> vo = dao.select(txt);
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		PrintWriter out = response.getWriter();
		for(int i = 0; i < vo.size(); i++) {
			// JSON 객체 생성
			jsonObject = new JSONObject();
			jsonObject.put("title", vo.get(i).getTitle());
			jsonArray.add(jsonObject);
		}
		out.append(jsonArray.toString());
		
		System.out.println(jsonArray.toString());
		
		
	}

}
