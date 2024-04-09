package edu.web.jsonServlet;

import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@WebServlet("/json.do")
public class createJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public createJsonServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String filePath = "C:/Users/sdedu/Desktop/testJson.json"; // 파일 저장 위치
		JsonObject myCharacter = new JsonObject();
		JsonArray interest = new JsonArray();

		myCharacter.addProperty("userId", request.getParameter("userId"));
		myCharacter.addProperty("password", request.getParameter("password"));
		myCharacter.addProperty("email", request.getParameter("email"));
		myCharacter.addProperty("emailAgree", request.getParameter("emailAgree"));
		String[] interests = request.getParameterValues("interest");
		for (String item : interests) {
			interest.add(item);
		}
		myCharacter.add("interest", interest);
		myCharacter.addProperty("phone", request.getParameter("phone"));
		myCharacter.addProperty("introduce", request.getParameter("introduce"));

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(myCharacter);
		try (FileWriter writer = new FileWriter(filePath)) {
			writer.write(json);
			System.out.println("JSON 데이터 저장 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
		response.sendRedirect(filePath);
	}
}
