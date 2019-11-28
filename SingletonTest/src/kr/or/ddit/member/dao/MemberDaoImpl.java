package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import util.DBUtil3;

public class MemberDaoImpl implements IMemberDao {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static IMemberDao Dao;
	
	private MemberDaoImpl() {
		
	}
	public static IMemberDao getInstance() {
		if(Dao == null) {
			Dao = new MemberDaoImpl();
		}
		return Dao;
	}
	/**
	 * 자원 반납
	 */
	private void disConnect() {
		if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		if(conn!=null) try {conn.close();} catch(SQLException e) {}
		if(rs!=null) try {rs.close();} catch(SQLException e) {}
		if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
	}
	
	@Override
	public int insertMember(MemberVO mv) {
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "insert into mymember (mem_id,mem_name,mem_tel,mem_addr)" + 
						 " values (?,?,?,?)";
					
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,mv.getMem_id());
			pstmt.setString(2,mv.getMem_name());
			pstmt.setString(3,mv.getMem_tel());
			pstmt.setString(4,mv.getMem_addr());
			cnt = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return cnt; // 데이터 성공 여부를 숫자로만 보여줌. 1 이상은 성공, 0은 실패
	}

	@Override
	public boolean getMember(String memId) {
		boolean chk = false;
		try {
			conn = DBUtil3.getConnection();
			String sql = "select count(*) cnt from mymember " + " where mem_id =? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			
			int cnt = 0;
			if(rs.next()) {
				cnt = rs.getInt("cnt"); // select의 값을 받는 부분
			}
			if(cnt >0) {
				chk = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return chk;
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		List<MemberVO> memList = new ArrayList<MemberVO>();
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from mymember";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) { 
				MemberVO mv = new MemberVO();
				mv.setMem_id(rs.getString("mem_id"));
				mv.setMem_name(rs.getString("mem_name"));
				mv.setMem_tel(rs.getString("mem_tel"));
				mv.setMem_addr(rs.getString("mem_addr"));
				
				memList.add(mv);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return memList;
	}

	@Override
	public int updateMember(MemberVO mv) {
		int cnt =0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "update mymember "+ " set mem_name = ? ,"+ " mem_tel = ? , "+ " mem_addr = ? ," + " mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMem_name());
			pstmt.setString(2, mv.getMem_tel());
			pstmt.setString(3, mv.getMem_addr());
			pstmt.setString(4, mv.getMem_id());
			cnt = pstmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt =0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "delete mymember where mem_id= ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memId);
			cnt = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getSearchMember(MemberVO mv) {
		List<MemberVO> memList = new ArrayList<>();
		//쿼리문 실행
		try {
			conn =DBUtil3.getConnection();
			String sql = "select * from mymember where 1=1 "; //1=1 where절에 어떤 것이 들어갈 지 알 수 없기 때문에 and를 써야하므로 -> 아무 의미 없는 구문을 작성
			if(mv.getMem_id() != null && !mv.getMem_id().equals("")) {
				sql += " and mem_id = ? ";
			}
			if(mv.getMem_name() != null && !mv.getMem_name().equals("")) { // name이 null이 아니고, ""이 아닌경우
				sql += " and mem_name = ? ";
			}
			if(mv.getMem_tel() != null && !mv.getMem_tel().equals("")) {
				sql += " and mem_tel = ? ";
			}
			if(mv.getMem_addr() != null && !mv.getMem_addr().equals("")) {
				sql += " and mem_addr like '%' || ? || '%' ";
			}
			pstmt = conn.prepareStatement(sql);
			//인덱스를 동적으로 처리 
			int index = 1;
			if(mv.getMem_id() != null && !mv.getMem_id().equals("")) { // 아이디 값이 있는 경우
				pstmt.setString(index++, mv.getMem_id());
			}
			if(mv.getMem_name() != null && !mv.getMem_name().equals("")) {
				pstmt.setString(index++, mv.getMem_name());
			}
			if(mv.getMem_tel() != null && !mv.getMem_tel().equals("")) {
				pstmt.setString(index++, mv.getMem_tel());
			}
			if(mv.getMem_addr() != null && !mv.getMem_addr().equals("")) {
				pstmt.setString(index++, mv.getMem_addr());
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO mv2 = new MemberVO();
				mv2.setMem_id(rs.getString("mem_id"));
				mv2.setMem_name(rs.getString("mem_name"));
				mv2.setMem_tel(rs.getString("mem_tel"));
				mv2.setMem_addr(rs.getString("mem_addr"));
				
				memList.add(mv2);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return memList;
	}

}
