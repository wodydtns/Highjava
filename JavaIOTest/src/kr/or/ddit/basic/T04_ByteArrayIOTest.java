package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T04_ByteArrayIOTest {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		byte[] tmp = new byte[4]; // 자료를 읽을 때 사용할 배열
		
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			
			while(input.available()>0) { //input.read 와 동일한 기능
				/*
				input.read(tmp); // 4바이트씩 읽어라 -> tmp에 집어넣기
				output.write(tmp); // 4바이트씩 읽기 때문에 
				*/
				//실제 읽어온 byte수를 반환
				int len = input.read(tmp);
				// tmp 배열의 내용 중 0번째부터 len까지의 개수만큼 출력
				output.write(tmp,0,len); // (배열이름, 시작 인덱스, 끝 인덱스)
				System.out.println("tmp: " + Arrays.toString(tmp));
			}
			System.out.println();
			
			outSrc = output.toByteArray();
			
			System.out.println("inSrc=> " + Arrays.toString(inSrc));
			System.out.println("outSrc=> " + Arrays.toString(outSrc));
			
			input.close();
			output.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
