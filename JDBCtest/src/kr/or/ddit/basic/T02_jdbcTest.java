package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class T02_jdbcTest {
	/*
	 * 문제1) 사용자로부터 lprod_id값을 입력받아 입력한 값보다 lprod_id가 큰 자료를 출력
	 * 문제2) lprod_id 값을 2개 입력받아서 두 값 중 작은값부터 큰 값 사이의 자료를 출력
	 */
	public static void main(String[] args) {
		System.out.println("값 1 입력");
		Scanner s1 = new Scanner(System.in);
		int user_input1 = Integer.parseInt(s1.nextLine());
		System.out.println("값 2 입력");
		Scanner s2 = new Scanner(System.in);
		int user_input2 = Integer.parseInt(s2.nextLine());
		int max, min;
		max = Math.max(user_input1, user_input2);
		min = Math.min(user_input1, user_input2);
		s1.close();
		s2.close();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// DB 접속
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String userID = "wodydtns";
			String password = "java";
			
			conn = DriverManager.getConnection(url,userID,password);
			
			// statement 객체 생성
			
			// 쿼리문 작성
			String sql = "select * from lprod "+ " where lprod_id "+ " between "+ min + " and " + max;
			stmt = conn.createStatement();
			//result로 넣기
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("lprod_id : " + rs.getInt("lprod_id"));
				System.out.println("lprod_gu : " + rs.getString("lprod_gu"));
				System.out.println("lprod_nm : " + rs.getString("lprod_nm"));
			}
			
			System.out.println("끗");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			//종료
			if(rs!=null) try {rs.close();}catch(SQLException e) {}
			if(stmt!=null) try {stmt.close();}catch(SQLException e) {}
			if(conn!=null) try {conn.close();}catch(SQLException e) {}
		}
	
	}
}
