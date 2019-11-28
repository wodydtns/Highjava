package kr.or.ddit.member.dao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.member.vo.MemberVO;


public class MemberDaoImpl implements IMemberDao {
	
	private static IMemberDao Dao;
	private SqlMapClient smc;
	
	private MemberDaoImpl() {
		try {
			// 1.1 xml 문서 읽어오기
			Charset charset = Charset.forName("UTF-8"); // 설정 파일 인코딩
			Resources.setCharset(charset);
			
			Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			//1.2 위에서 읽어온 Reader객체를 이용해 실제 작업을 진행할 객체 생성
			smc = SqlMapClientBuilder.buildSqlMapClient(rd); // reader를 통해서 정보 전달
			
			rd.close();
		}catch(IOException e) {
			System.out.println("SQL map 객체 생성 실패");
			e.printStackTrace();
		}
	}
	public static IMemberDao getInstance() {
		if(Dao == null) {
			Dao = new MemberDaoImpl();
		}
		return Dao;
	}
	
	@Override
	public int insertMember(MemberVO mv) {
		int cnt =0;
		try {
			Object obj = smc.insert("member.insertMember",mv);
			if(obj == null) {
				cnt = 1;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public boolean getMember(String memId) {
		boolean chk = false;
		int cnt = 0;
		try {
			cnt = (int) smc.queryForObject("member.getMember",memId);
			if(cnt >0) {
				chk = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {
			memList = smc.queryForList("member.getMemberAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memList;
	}
	
	@Override
	public int updateMember(MemberVO mv) {
		int cnt =0;
		try {
			cnt = smc.update("member.updateMember",mv);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt =0;
		try {
			cnt = smc.delete("member.deleteMember",memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getSearchMember(MemberVO mv) {
		List<MemberVO> memList = new ArrayList<>();
		try {
			memList = smc.queryForList("member.getSearchMember",mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memList;
	}

}
