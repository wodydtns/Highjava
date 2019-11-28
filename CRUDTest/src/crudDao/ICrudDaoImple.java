package crudDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import crudVO.CrudVO;
import util.DBUtil3;

public class ICrudDaoImple implements ICrudDao{
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//연결을 끊는 메소드
	private void disConnect() {
		if(rs!=null) try {rs.close();} catch(SQLException e) {};
		if(stmt!=null) try {stmt.close();} catch(SQLException e) {};
		if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {};
		if(conn!=null) try {conn.close();} catch(SQLException e) {};
	}
	@Override
	public int write(CrudVO cv) {
		int cnt =0;
		try {
		
			conn=DBUtil3.getConnection();
			//테이블에 데이터 넣기
			String sql = "insert into jdbc_board values "
					+ "(board_seq.nextval,?,?,sysdate,?) ";
			// 글 작성 날짜로 세팅
			// 데이터 넣기
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,cv.getBoard_title());
			pstmt.setString(2, cv.getBoard_writer());
			pstmt.setString(3, cv.getContent());
			
			cnt = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
					
		}finally {
			disConnect();
		}
		return cnt;
	}

	@Override
	public boolean getNum(int num) {
		boolean flag = false;
		try {
			conn = DBUtil3.getConnection();
			String sql = "select count(*) cnt from jdbc_board where board_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			int cnt = 0;
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			if(cnt >0) {
				flag = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return flag;
	}

	@Override
	public List<CrudVO> displayList() {
		List<CrudVO> crudList = new ArrayList<CrudVO>();
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				CrudVO cv = new CrudVO();
				cv.setBoard_no(rs.getInt("board_no"));
				cv.setBoard_title(rs.getString("board_title"));
				cv.setBoard_writer(rs.getString("board_writer"));
				cv.setBoard_date(rs.getDate("board_date"));
				cv.setContent(rs.getString("board_content"));
				
				crudList.add(cv);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return crudList;
	}

	@Override
	public int modify(CrudVO cv) {
		int cnt =0;
		try {
			
			conn=DBUtil3.getConnection();
			String sql = "update jdbc_board" + " set board_title = ? , board_writer = ? ," 
					+ " board_date = sysdate , board_content = ? where board_no = "+ cv.getBoard_no();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cv.getBoard_title());
			pstmt.setString(2, cv.getBoard_writer());
			pstmt.setString(3, cv.getContent());
			cnt = pstmt.executeUpdate();
						
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return cnt;
	}

	@Override
	public int delete(int num) {
		int cnt =0;
		try {
			conn= DBUtil3.getConnection();
			String sql = "delete jdbc_board where board_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			cnt = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return cnt;
		
	}

	@Override
	public List<CrudVO> search(int num) {
		List<CrudVO> crudList = new ArrayList<CrudVO>();
		CrudVO cv = new CrudVO();
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cv.setBoard_no(rs.getInt("board_no"));
				cv.setBoard_title(rs.getString("board_title"));
				cv.setBoard_writer(rs.getString("board_writer"));
				cv.setBoard_date(rs.getDate("board_date"));
				cv.setContent(rs.getString("board_content"));
				crudList.add(cv);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return crudList;
	}

}
