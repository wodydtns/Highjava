package crudService;

import java.util.List;

import crudVO.CrudVO;

public interface IcrudService {
	/**
	 * 실제 db와 연결해 sql문 수행, 결과 작성해
	 * service에 전달하는 DAO의 interface
	 */
	
	public int write(CrudVO cv);
	
	/**
	 * 글이 있는 지 번호로 알아내는 메소드
	 * @param num - 글 번호
	 * @return 글이 있으면 true, 없으면 false
	 */
	public boolean getNum(int num);

	/**
	 * 하나의 jdbc_board테이블의 전체 레코드를 가져와 list에 담아서 반환
	 * @return CrudVO 객체를 담고 있는 List 객체
	 */
	public List<CrudVO> displayList();
	
	/**
	 * 하나의 CrudVO 자료를 이용해 DB를 수정하는 메소드
	 * @param cv update할 글 정보가 들어있는 CrudVO 객체
	 * @return 작업 성공시 1, 실패시 0
	 */
	public int modify(CrudVO cv);
	/**
	 * 글 번호를 매개변수로 받아 게시글을 삭제하는 메소드
	 * @param num 삭제할 글 번호
	 * @return 작업성공:1 , 작업 실패 0
	 */
	public int delete(int num);
	
	/**
	 * 하나의 CrudVO 자료를 이용해 DB에서 게시글을 찾는 메소드
	 * @param cv search할 글 정보가 들어있는 CrudVO 객체
	 * @return 작업 성공 시 1, 실패 시 0
	 */
	public List<CrudVO> search(CrudVO cv);
	
}
