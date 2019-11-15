package kr.or.ddit.basic;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * JDBC 를 이용한 데이터베이스 처리 순서
 * 순서 : JDBC드라이버 로딩 -> 해당 DB에 접속 -> 질의 (SQL 명령을 수행)-> 질의 결과를 받아서 처리 -> 종료(자원반납)
 * 1.JDBC드라이버 로딩(오라클 기준)
 *  - JDBC드라이버는 DB를 만든 회사에서 제공
 *  Class.forName("oracle.jdbc.driver.OracleDriver");
 *  2. 접속하기 : 접속 성공 시 Connection 객체 생성
 *  DriverManager.getConnection() 메소드 이용
 *  3. 질의 : Statement 객체 또는 PreparedStatement 객체 이용해 SQL 문장 실행
 *  4. 결과 
 *   1) SQL 문이 select -> ResultSet 객체 생성 -> ResultSet 객체에는 select한 결과 저장
 *   2) SQL문이 insert, update, delete 일 경우 -> 정수값 반환 => 정수값은 보통 실행에 성공한 레코드 수를 의미
 *    				
 */
public class T01_jdbcTest {
	public static void main(String[] args) {
		// DB작업에 필요한 객체변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; // 쿼리문이 select일 경우 필요함
		
		try {
			// 1. 드라이버 로딩(옵션)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. DB에 접속(Connection객체 생성)
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String userId = "wodydtns";
			String password = "java";
			
			//실제적으로 OracleDriver가 사용되는 부분
			conn = DriverManager.getConnection(url, userId, password);
			
			//3.Statement 객체 생성 => Connection객체 이용
			stmt = conn.createStatement();
			
			//4. SQL문을 Statement객체를 이용해 실행하고 실행결과를  ResultSet 객체에 저장
			String sql= "select * from lprod"; //실행할 sql문
			rs = stmt.executeQuery(sql); 
			//sql문이 select일 경우 -> executeQuery()메소드 사용 -> ResultSet에 담긴다
			// insert,update,delete일 경우 executeUpdate()메소드 사용 
			
			//5. ResultSet 객체에 저장되어 있는 자료를 반복문과 next()메소드를 이용해 차례로 읽어와 처리
			System.out.println("실행할 쿼리문 : " + sql);
			System.out.println("===쿼리문 실행 결과 ===");
			
			// rs.next() : ResultSet 객체의 데이터를 가르키는 포인터를 
			// 다음 레코드로 이동시키고 그곳에 자료가 있으면 true, 없으면 false
			while(rs.next()) {
				// 컬럼의 자료를 가져오는 방법
				// 1. rs.get자료형 이름("컬럼명")
				// 2. rs.get자료형 이름(컬럼번호) => 1번부터 시작
				System.out.println("lprod_id: "+ rs.getInt("lprod_id"));
				System.out.println("lprod_gu: "+ rs.getString("lprod_gu"));
				System.out.println("lprod_nm: "+ rs.getString("lprod_nm"));
				System.out.println("==================================");
			}
			System.out.println("출력 끝");
				
		
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			//6.종료(사용했던 자원을 모두 반납한다)
			if(rs!=null) try {rs.close();}catch(SQLException e) {}
			if(stmt!=null) try {stmt.close();}catch(SQLException e) {}
			if(conn!=null) try {conn.close();}catch(SQLException e) {}
		}
		
	}
}
