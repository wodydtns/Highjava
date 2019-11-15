package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import util.DBUtil;

public class T04_jdbcTest {
	/*
	 * lprod 테이블에 새로운 데이터 추가하기
	 * 
	 * lprod_gu, lprod_nm은 직접 입력 받아 처리
	 * lprod_id는 현재 lprod_id들 중 제일 큰 값보다 1 증가된 값으로
	 * (lprod_gu 중복 검사)
	 */
	public static void main(String[] args) {
		System.out.println("id값을 입력하시오");
		Scanner s1 = new Scanner(System.in);
		int lprod_id = Integer.parseInt(s1.nextLine());
		System.out.println("gu값을 입력하시오");
		Scanner s2 = new Scanner(System.in);
		String lprod_gu = s2.nextLine();
		System.out.println("제품명을 입력하시오");
		Scanner s3 = new Scanner(System.in);
		String lprod_nm = s3.nextLine();
		s1.close();
		s2.close();
		s3.close();
		Connection conn = null;
		PreparedStatement pstmt = null; // INSERT 절 쿼리
		Statement stmt = null; // SELECT 절 쿼리
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			// id 중복 검사
			stmt = conn.createStatement();
			String id_cnt = "select count(lprod_id) cnt from lprod where lprod_id = "+ lprod_id;
			rs = stmt.executeQuery(id_cnt);
			boolean flag = false;
			int cnt =0;
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			
			}
			if(cnt > 0) {
				flag = true;	
			}
			//lprod_id들 중 제일 큰 값보다 1 증가된 값
			String id_max = "select max(lprod_id) as max from lprod ";
			rs = stmt.executeQuery(id_max);
			// 값 넣기
			String sql = "insert into lprod "+" values(?,?,?)";
			while(rs.next()) {

				if(rs.getInt("max") >= lprod_id) {
					lprod_id++;
				}
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lprod_id);
			pstmt.setString(2, lprod_gu);
			pstmt.setString(3, lprod_nm);
//			int cnt =pstmt.executeUpdate();
			System.out.println("반환값 :" + cnt);
			System.out.println("완료");

		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//6.종료(사용했던 자원을 모두 반납한다)
			if(pstmt!=null) try {pstmt.close();}catch(SQLException e) {}
			if(stmt!=null) try {stmt.close();}catch(SQLException e) {}
			if(conn!=null) try {conn.close();}catch(SQLException e) {}
		}
	}
}
