package kr.or.ddit.basic;
/*
 * 성능향상을 위한 보조스트림 예제
 */

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class T11_BufferedIOTest {
	public static void main(String[] args) {
		
		//입출력의 성능 향상을 위해 버퍼를 이용하는 보조 스트림
		
		FileOutputStream fout = null;
		BufferedOutputStream bout = null;
		
		try {
			fout = new FileOutputStream("d:/D_Other/bufferTest.txt");
			
			//버퍼의 크기를 지정하지 않으면 default 버퍼의 크기는 8192byte(8kb)로 설정된다
			
			//버퍼의 크기가 5인 스트림 생성
			bout = new BufferedOutputStream(fout,5); //5개를 담기 때문에 
			for(int i='1';i<='9';i++) {
				bout.write(i); // for문은 9번 돌지만 버퍼는 2번 호출 - 5개가 찰 때까지 모았다가 write함 -> 속도가 빠르다
			}
			bout.flush(); // 작업 종료 전 버퍼에 남아있는 데이터를 모두 출력한다.(close시 자동 호출된다.)
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
