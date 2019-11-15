package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CRUD {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Scanner s = new Scanner(System.in);

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
//				displayAll();
				break;
			case 2: // 새 글 작성
//				write();
				break;
			case 3: // 글 수정
//				modify();
				break;
			case 4 : // 글 삭제
//				delete();
				break;
			case 5 : // 검색
//				search();
				break;
			default :
				System.out.println("번호를 잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}while(choice !=5);
	}
	
}
