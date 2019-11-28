package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;

public class MemberServiceImple implements IMemberService {

	// 사용할 DAO의 객체변수 선언
	private static MemberServiceImple service;
	
	private IMemberDao memDao;
	
	private MemberServiceImple() {
		memDao = MemberDaoImpl.getInstance();
	}
	public static MemberServiceImple getInstance() {
		if(service == null) {
			service = new MemberServiceImple();
		}
		return service;
	}
	
	
	@Override
	public int insertMember(MemberVO mv) {
		return memDao.insertMember(mv);
	}

	@Override
	public boolean getMember(String memId) {
		return memDao.getMember(memId);
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		return memDao.getAllMemberList();
	}

	@Override
	public int updateMember(MemberVO mv) {
		return memDao.updateMember(mv);
	}

	@Override
	public int deleteMember(String memId) {
		return memDao.deleteMember(memId)
				;
	}

	@Override
	public List<MemberVO> getSearchMember(MemberVO mv) {
		return memDao.getSearchMember(mv);
	}

}
