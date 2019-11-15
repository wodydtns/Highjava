package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * 문자 기반의 Buffered 스트림 사용 예제
 */
public class T12_BufferedIOTest {
	public static void main(String[] args) {
		try {
			//이클립스에서 만든 자바프로그램이 실행되는 기본 위치는 해당 '프로젝트 폴더'
			FileReader fr = new FileReader("./src/kr/or/ddit/basic/T11_BufferedIOTest.java");
			
//			int c;
//			while((c=fr.read()) != -1) {
//				System.out.print((char)c);
//				
//			}
			//한줄씩 읽을 수 있도록 해주는 readLine메소드를 이용하기 위해 BufferedReader 사용
			BufferedReader br = new BufferedReader(fr);
			String temp = "";
			int i =1;
			while((temp=br.readLine()) !=null) {
				System.out.printf("%4d: %s\n",i,temp); //printf - print format 형식을 지정
				// 4d -> 4자리 숫자 / s = 스트링 / d는 i를 받고, s는 temp를 받는다.
				// % 를 기준으로 맞춤 -> 
				i++;
			}
			
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
