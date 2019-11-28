package crudMain;

import java.util.List;
import java.util.Scanner;

import crudService.IcrudService;
import crudService.IcrudServiceImpl;
import crudVO.CrudVO;


public class CRUD {
	//service 객체 변수 선언
	private IcrudService service;
	private Scanner s = new Scanner(System.in);

	public CRUD() {
		service = new IcrudServiceImpl();
	}

	//메뉴
	public void displayMenu() {
		System.out.println();
		System.out.println("==========================");
		System.out.println("=========메뉴 선택 =========");
		System.out.println("1.전체 목록 출력");
		System.out.println("2.새 글 작성");
		System.out.println("3.글 수정");
		System.out.println("4.글 삭제");
		System.out.println("5.게시판 검색");
		System.out.println("==========================");
	}
	public void start() {
		int choice;
		do {
			displayMenu();
			choice = s.nextInt();
			switch(choice) {
			case 1: // 전체 목록 출력
				displayList();
				break;
			case 2: // 새 글 작성
				write();
				break;
			case 3: // 글 수정
				modify();
				break;
			case 4 : // 글 삭제
				delete();
				break;
			case 5 : // 검색
				search();
				break;
			default :
				System.out.println("번호를 잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}while(choice !=6);
	}
	
	private void displayList() {

		List<CrudVO> crudList = service.displayList();
		for(CrudVO cv : crudList) {
			System.out.println(cv.getBoard_no()+"\t"+cv.getBoard_title() + "\t"
					+ cv.getBoard_writer()+ "\t"+cv.getBoard_date());
			System.out.println(cv.getContent());
		}
	}
	
		//검색하는 메소드
		private void search() {
			System.out.println();
			System.out.println("읽을 글 번호를 입력해주세요.");
			int num = s.nextInt();
			
			List<CrudVO> curdList =service.search(num);
			
			for(CrudVO cv : curdList) {
				System.out.println(cv.getBoard_no()+"\t"+ cv.getBoard_title()
				+ "\t"+cv.getBoard_writer()+"\t"+cv.getBoard_date());
				System.out.println(cv.getContent());
			}
			System.out.println("----------------------");
			System.out.println("출력 끗");
		
			
			
		}

	//삭제하는 메소드
	private void delete() {

		System.out.println("삭제할 게시글 번호를 입력하세요.");
		int num = s.nextInt();
		int cnt = service.delete(num);
		if(cnt > 0) {
			System.out.println(" 글 삭제");
		}else {
			System.out.println("삭제 실패");
		}

	}
	private void modify() {

		boolean flag = true;
		int num = s.nextInt();
		do {
			flag = service.getNum(num);
			if(flag == false) {
				System.out.println(num + "은 없는 글입니다.");
				System.out.println("다시 입력하세요.");
			}
		}while(flag == false);
		System.out.println("수정할 내용을 입력하세요.");
		System.out.println("제목>>");
		String title = s.next();
		System.out.println("작성자");
		String writer = s.next();
		s.nextLine();
		System.out.println("내용");
		String content = s.nextLine();

		CrudVO cv = new CrudVO();
		cv.setBoard_no(num);
		cv.setBoard_title(title);
		cv.setBoard_writer(writer);
		cv.setContent(content);
		int cnt = service.modify(cv);
		if(cnt >0) {
			System.out.println("업데이트에 성공했습니다.");
		}else {
			System.out.println("수정 실패");
		}

	}

	private void write() {

		System.out.println();
		System.out.println("제목을 입력하세요.");
		String title = s.next();
		System.out.println("작성자를 입력하세요.");
		String writer = s.next();
		s.nextLine();
		System.out.println("내용을 입력하세요.");
		String content = s.nextLine();

		//테이블에 데이터 넣기
		String sql = "insert into jdbc_board values (board_seq.nextval,?,?,sysdate,?) ";
		// 글 작성 날짜로 세팅
		// 데이터 넣기

		//로깅 프로그램을 이용해 로그 찍기
		//쿼리문 로그 찍기

		CrudVO cv = new CrudVO();

		cv.setBoard_title(title);
		cv.setBoard_writer(writer);
		// 오늘 날짜 가지고 오기.
		cv.setContent(content);


		int cnt = service.write(cv);

		if(cnt >0) {
			System.out.println("success");
		}else {
			System.out.println("fail");
		}

	}

	public static void main(String[] args) {
		CRUD crud = new CRUD();
		crud.start();
	}
}
