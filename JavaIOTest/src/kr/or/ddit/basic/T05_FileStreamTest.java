package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class T05_FileStreamTest {
	public static void main(String[] args) {
		//FileInputStream 객체를 이용한 파일 내용 읽기
		FileInputStream fin = null; // 변수 선언
		try {
			//방법 1. 파일정보를 문자열로 지정하기
			fin = new FileInputStream("d:/D_Other/test2.txt"); // 생성자 선언
			
			//방법2( 파일정보를 File객체로 이용해 지정하기)
			//File file = new File("d/D_Other/test2.txt"); 
			//fin = new FileInputStream(file);
			
			int c; // 읽어올 데이터를 저장할 변수
			//읽어온 값이 -1이면 파일을 끝까지 읽었다는 의미
			while((c=fin.read()) !=-1) {
				//읽어온 자료 출력하기
				System.out.println((char)c);
				fin.close();
			}
		}catch(FileNotFoundException e) {
			System.out.println("지정한 파일이 없습니다.");
		}catch(IOException e) {
			System.out.println("알 수 없는 입출력 오류입니다.");
		}
	}
		
}
