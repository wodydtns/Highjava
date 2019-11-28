package crudMain;

import java.sql.Date;
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
		service = IcrudServiceImpl.getInstance();
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
			System.out.println(cv.getBoard_content());
		}
	}
	
		//검색하는 메소드
		private void search() {
			s.nextLine();
			System.out.println();
			System.out.println("검색할 글 번호를 입력하세요.");
			int board_no = s.nextInt();
			
			System.out.println("글 제목>>");
			String board_title = s.nextLine();
			System.out.println("글 작성자>>");
			String board_writer = s.nextLine();
			System.out.println("글 작성 날짜>>");
			String board_date = s.nextLine();
			System.out.println("글 내용>>");
			String board_content = s.nextLine();
			
			CrudVO cv = new CrudVO();
			cv.setBoard_no(board_no);
			cv.setBoard_title(board_title);
			cv.setBoard_writer(board_writer);
			cv.setBoard_date(board_date);
			cv.setBoard_content(board_content);
			
			List<CrudVO> crudList = service.search(cv);
			System.out.println();
			System.out.println("글 번호\t제목\t작성자\t날짜");
			System.out.println("내용");
			
			if(crudList == null || crudList.size() ==0) {
				System.out.println("자료가 없습니다.");
			}else {
				for(CrudVO cv1 : crudList) {
					System.out.println(cv1.getBoard_no() +"\t"+cv1.getBoard_title()+"\t"+
					cv1.getBoard_writer()+"\t"+cv1.getBoard_date()+"\t"+cv1.getBoard_content());
				}
			}
			
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
		System.out.println();
		boolean flag = true;
		int board_no;
		do {
			System.out.println("수정할 글 번호를 입력하세요.");
			board_no = s.nextInt();
			flag = service.getNum(board_no);
			if(flag == false) {
				System.out.println(board_no + "은 없는 글입니다.");
				System.out.println("다시 입력하세요.");
			}
		}while(flag == false);
		System.out.println("수정할 내용을 입력하세요.");
		System.out.println("제목>>");
		String board_title = s.next();
		System.out.println("작성자");
		String board_writer = s.next();
		s.nextLine();
		System.out.println("내용");
		String board_content = s.nextLine();

		CrudVO cv = new CrudVO();
		cv.setBoard_no(board_no);
		cv.setBoard_title(board_title);
		cv.setBoard_writer(board_writer);
		cv.setBoard_content(board_content);
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
		String board_content = s.nextLine();

		CrudVO cv = new CrudVO();

		cv.setBoard_title(title);
		cv.setBoard_writer(writer);
		cv.setBoard_content(board_content);


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
