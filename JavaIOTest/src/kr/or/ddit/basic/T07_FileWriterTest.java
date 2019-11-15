package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.InputStreamReader;

public class T07_FileWriterTest {
	public static void main(String[] args) {
		
		//사용자가 입력한 내용을 그대로 파일로 저장
		
		// 콘솔과 연결된 입력용 문자 스트림 생성
		// InputStreamReader 스트림 : 바이트 기반 스트림을 문자기반 스트림으로 변환해주는 보조스트림
		InputStreamReader isr = new InputStreamReader(System.in); //System.in 데이터를 읽는 기능은 파라미터로
		
		FileWriter fw = null; // 파일 출력용 문자기반 스트림
		
		try {
			// 파일 출력용 문자 스트림 객체 생성
			fw = new FileWriter("d:/D_Other/testChar.txt");
			int c;
			System.out.println("아무거나 입력하세요/");
			
			//콘솔에서 입력 시 입력 끝 표시는 Ctrl+z키 누르면 됨
			while((c=isr.read()) !=-1){ // c에 char이 담긴다.
				fw.write(c);
			}
			System.out.println("작업 끝");
			
			isr.close();
			fw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
