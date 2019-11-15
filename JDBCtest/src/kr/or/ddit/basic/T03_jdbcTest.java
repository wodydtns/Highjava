package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBUtil;

public class T03_jdbcTest {
	/*
	 * 
	 */
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			/*
			//드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// DB 접속
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String userId = "wodydtns";
			String password = "java";
			
			conn = DriverManager.getConnection(url,userId,password);
			*/
			conn = DBUtil.getConnection();
			//PreparedStatement 객체를 이용한 자료 추가 방법 - 미리 SQL문을 작성해두어야한다.
			 
			//sql문 작성 - 데이터가 들어갈 자리에 question mark(?)를 넣는다.
			String sql = "insert into lprod (lprod_id,lprod_gu,lprod_nm)" 
					    + " values(?,?,?)";
			// PreparedStatement 객체 생성 시 SQL문을 넣어서 생성
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리문의 물음표(?) 자리에 들어갈 데이터를 세팅
			// 형식 : pstmt.set자료형이름(물음표순번, 데이터);
			pstmt.setInt(1, 101);
			pstmt.setString(2, "N101");
			pstmt.setString(3, "농산물");
			
			//데이터를 세팅한 쿼리문 실행
			int cnt = pstmt.executeUpdate();
			System.out.println("첫번째 반환값 : " + cnt);
			//-----------------------------------------------------------------------
			pstmt.setInt(1, 201);
			pstmt.setString(2, "N102");
			pstmt.setString(3, "수산물");
			cnt = pstmt.executeUpdate();
			System.out.println("두번째 반환값 : " + cnt);
			//-----------------------------------------------------------------------
			pstmt.setInt(1, 301);
			pstmt.setString(2, "N103");
			pstmt.setString(3, "축산물");
			cnt = pstmt.executeUpdate();
			System.out.println("세번째 반환값 : " + cnt);
									
			/*
			//Statement 객체를 이용한 자료 추가 방법
			stmt = conn.createStatement();
			String sql = "insert into lprod " + "(lprod_id,lprod_gu,lprod_nm)" + "values (101,'N101','농산물')";
			
			//executeUpdate() 메소드 : 실행 성공한 레코드 수를 반환 - select 문이 아니면 이 메소드를 사용
			int cnt = stmt.executeUpdate(sql);
			System.out.println("첫번째 반환값 : " + cnt);
			
			//-----------------------------------------------------------------------
			sql = "INSERT INTO lprod " + "(lprod_id,lprod_gu,lprod_nm)" + "values (102,'N102','수산물')";
			cnt = stmt.executeUpdate(sql);
			System.out.println("두번째 반환값 : " + cnt);
			//----------------------------------------------------------------------------------------------
			sql = "INSERT INTO lprod " + "(lprod_id,lprod_gu,lprod_nm)" + "values (103,'N103','축산물')";
			cnt = stmt.executeUpdate(sql);
			System.out.println("세번째 반환값 : " + cnt);
		*/
			System.out.println("완료");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {} 
			if(stmt != null) try {stmt.close();} catch(SQLException e) {} 
			if(conn != null) try {conn.close();} catch(SQLException e) {} 
		}
	
	}
}
