package edu.web.dbcp.connmgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/*
 DBCP(Data Base Connection Pool)
 - 브라우저에서 서버에 호출 시 매번 DB 연결 객체를 생성하면 과부하가 발생할 수 있음
 - 이를 해결하기 위해 다수의 견결을 컨트롤하는 기법을 DBCP라고 함
 - DBCP 원리
 1) 웹 컨테이너가 실행되면서 커넥션(Connection) 객체를 미리 풀(Pool)에 생성
 2) 풀에 저장된 커넥션 객체를 필요할 때 쓰고 반환
 3) 미리 생성하기 때문에 데이터베이스에 부하를 줄이고 유동적으로 연결을 관리
 - 단점 
 서버의 시작과 끝이 느리다.(미리 준비하기 하기 때문)
 
 DBCP 설정
 1. ojdbc6.jar 파일을 \webapp\WEB-INF\lib에 저장
 2. 톰캣 설치 경로\lib 폴더에 있는 tomcat-dbcp.jar 파일을
 	웹 프로젝트 경로\webapp\WEB-INF\lib에 저장
 3. \webapp\WEB-INF\context.xml 파일에 Resource 태그 추가
 
 */
public class ConnMgr {
	
	public static Connection getConnection() throws Exception {
		// throws는 이 함수를 호출할때 호출 하는 곳에서 try-catch를 실행해야함
		// throws를 안쓰고 함수내에서 try-catch 수행시 함수내에서 처리를 해버리고 끝남
		// throws 절을 사용하면 예외 처리의 책임이 호출하는 쪽에 있고, try-catch 블록을 사용하면 예외 처리의 책임이 메서드 내에 있습니다.
		Connection conn = null;
		
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource ds = (DataSource) envContext.lookup("dbcp/orcl");
		conn = ds.getConnection();
		System.out.println("DBCP 연결 성공!");
		return conn;
	}

	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			conn.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
}
