package web.ch14.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 문자열로 url 정보 입력
@WebServlet("/main") // annotation 방식
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CLASSNAME
		= MainServlet.class.getName(); // 클래스 위치와 이름 참조
	
    public MainServlet() {
        System.out.println(CLASSNAME + " MainServlet()");
    }
    
    // init() : 해당 SErvlet이 실행될 때 한번만 호출.
    @Override
    public void init() throws ServletException {
    	System.out.println(CLASSNAME + " init()");
    }
    
    // service() : HTTP 요청이 발생될 때마다 호출. 만약 service()가 없어도 doGet()과 doPOST()로 대체 가능하다.
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    	System.out.println(CLASSNAME + " service()");
//    }

    // doGet() : HTTP GET 요청이 발생될 때마다 호출 . 조회, 클라이언트에서 요청한 데이터를 '서버에서' 전송할때 사용 (정보가 다 보임)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME + " doGet()");
//		response.getWriter()
//		.append("Hello Servlet"); // 클라이언트로 text 전송
	}

	// doPost() : HTTP POST 요청이 발생될 때마다 호출 . 등록 클라이언트에서 등록한 데이터를 '서버로' 전송할때 사용 ( 숨겨져있음(암호화))
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME + " doPost()");
	}
	
	// destroy() : 서버가 종료될 때 호출.
	@Override
	public void destroy() {
		System.out.println(CLASSNAME + " destroy()");
	}

}
