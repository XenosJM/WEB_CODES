package edu.web.persistence;

import java.io.IOException;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharFilter extends HttpFilter implements Filter {

	public CharFilter() {
		System.out.println("CharFilter 생성자");
	}
	
	// init() : 필터가 시작할 때 호출
	@Override
	public void init(FilterConfig config) throws ServletException{
	}
	
	// doFilter() : 필터를 사용할 때 마다 호출
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// 클라이언트로부터 IP 얻기
		String ipAddress = req.getRemoteAddr();
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");	
		res.setContentType("text/html; charset=UTF-8");
		// 현재 시간과 IP주소 출력
		System.out.println("IP : " + ipAddress + ", Time : " + new Date().toString());
		chain.doFilter(req, res);
	}
	
	// destroy() : 필터가 종료될 때 호출
	@Override
	public void destroy() {
	}
	
} // end TestFilter

