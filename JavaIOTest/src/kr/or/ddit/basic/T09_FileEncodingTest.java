package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * InputStreamReader 객체는 파일의 인코딩 방식을 지정할 수 있다
 * 형식) new InputStreamReader(바이트 기반 스트림 객체, 인코딩방식)
 *  	인코딩 방식
 *  	한글 인코딩 방식은 크게 두 가지 : UTF-8 / EUC-kR
 *  	+ mssoft 의 MS949
 *  	- MS949 : 윈도우 기본 한글 인코딩 방식
 *  	- UTF-8 : 유니코드 UTF-8 방식
 *  	- US-ASCII : 영문 전용 인코딩 방식
 */
public class T09_FileEncodingTest {
	FileInputStream fin = null;
	public static void main(String[] args) {
		// 파일 인코딩을 이용해 읽어오기
		InputStreamReader isr = null; // InputStreamReader 보조 스트림이므로 기반 스트림이 필요
		FileInputStream fin = null;
		try {
			//FileInputStream 객체를 생성한 후 이 객체를 매개변수로 받는 InputStreamReader 객체를 생성
//			fin = new FileInputStream("d:/D_Other/test_utf8.txt");
			fin = new FileInputStream("d:/D_Other/test_ansi.txt");
			
//			isr = new InputStreamReader(fin); // FileInputStream 기반 스트림 
			isr = new InputStreamReader(fin, "MS949");
			
			int c;
			while((c= isr.read()) !=-1) {
				System.out.print((char)c);
			}
			System.out.println();
			System.out.println("출력 끝");
			
			isr.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
