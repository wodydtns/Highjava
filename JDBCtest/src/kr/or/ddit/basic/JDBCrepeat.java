package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCrepeat {
	public static void main(String[] args) {
		
		//DB 작업 필수 객체 요소
		Connection conn =null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String userId = "wodydtns";
			String password = "java";
			
			conn = DriverManager.getConnection(url,userId,password);
			
			String sql = "select emp.empno,emp.ename from emp join dept on (emp.deptno=dept.deptno)";
			stmt = conn.createStatement();
			
			System.out.println("실행할 쿼리문:" + sql);
			System.out.println("===실행 결과===");

			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				// 1. rs.get자료형 이름("컬럼명")
				// 2. rs.get자료형 이름(컬럼번호) => 1번부터 시작
				System.out.println(rs.getInt("empno")+ rs.getString("ename"));
				
			}
			System.out.println("끗");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(rs != null) try {stmt.close();} catch(SQLException e) {}
			if(rs != null) try {conn.close();} catch(SQLException e) {}
		}
	}
}
