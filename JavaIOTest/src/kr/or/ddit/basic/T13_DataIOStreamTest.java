package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 기본 타입 입출력 보조 스트림 예제 
 */
public class T13_DataIOStreamTest {
	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("d:/D_Other/test.dat"); // 기반스트림
			
			//DataOutputStream 은 출력용 데이터를 자료형에 맞게 출력해준다.
			DataOutputStream dout = new DataOutputStream(fout); // 보조스트림
			//저장할 시 바이트가 작은 것부터 큰 순서로 적어야함
			dout.writeUTF("홍길동"); // 문자열 데이터 출력(utf-8)
			dout.writeInt(17); // 정수형 데이터 출력
			dout.writeFloat(3.14f); // 플롯형 데이터 출력
			dout.writeDouble(3.14); // 더블형 데이터 출력
			dout.writeBoolean(true); // 불리언형 데이터 출력
			dout.writeChar('c'); // 캐릭터형 데이터 출력
			System.out.println("출력 완료");
			dout.close();
			//===============================================================
			// 출력한 자료 읽어오기
			FileInputStream fin = new FileInputStream("d:/D_Other/test.dat");
			//읽어들일 때도 위의 순서에 맞춰서 해야 저장된 값 그대로 값을 읽을 수 있다.
			DataInputStream din = new DataInputStream(fin);
			System.out.println("문자열 자료:" + din.readUTF());
			System.out.println("정수형 자료:" + din.readInt());
			System.out.println("실수형 자료: " + din.readFloat());
			System.out.println("더블형 자료 :" + din.readDouble());
			System.out.println("불리언형 자료 : " + din.readBoolean());
			System.out.println("캐릭터형 자료:" + din.readChar());
			din.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
		
}
