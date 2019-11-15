package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class T15_ObjectStreamTest {
	public static void main(String[] args) {
		// Member 인스턴스 생성
		Member mem1 = new Member("홍길동", 20, "대전");
		Member mem2 = new Member("일지매", 23, "경기");
		Member mem3 = new Member("이순신", 25, "부산");
		Member mem4 = new Member("장길산", 19, "청주");
		
		try {
			//객체를 파일에 저장하기
			
			// 출력용 스트림 객체 생성 / 보조스트림을 여러개 붙일 수 있다.
			ObjectOutputStream oos = new ObjectOutputStream( // 객체를 가져오기 위한 보조 스트
									new BufferedOutputStream( // 성능향상을 위한 보조 스트림
									new FileOutputStream("d:/D_Other/memObj.bin")));
			
			//쓰기 작업
			oos.writeObject(mem1); //직렬화 처리 - 직렬화 가능한 객체만 올 수 있다.
			oos.writeObject(mem2); //직렬화 처리
			oos.writeObject(mem3); //직렬화 처리
			oos.writeObject(mem4); //직렬화 처리
			
			System.out.println("쓰기 작업 완료");
			oos.close();
			//================================================
			
			//저장된 객체를 읽어와 출력하기
			
			//입력용 스트림 객체 생성
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/D_Other/memObj.txt")));
			
			Object obj = null;
			try {
				while((obj=ois.readObject()) !=null) {
					// 읽어온 데이터를 원래의 객체형으로 변환 후 사용
					Member mem = (Member) obj;
					System.out.println("이름: " + mem.getName());
					System.out.println("나이: " + mem.getAge());
					System.out.println("주소: " + mem.getAddr());
					System.out.println("================================");
				}
				ois.close();
			}catch(ClassNotFoundException e) {
				
			}
					
		}catch(IOException e) {
//			e.printStackTrace();
//			더 이상 읽어올 객체가 없으면 예외 발생
			System.out.println("출력 작업 끝");
		}
	}
}
/*
 * 회원정보 VO
 */
class Member implements Serializable{ 
	// 직렬화 : 객체를 데이터 스트림으로 만드는 것 - 객체에 저장된 데이터를 스트림에 쓰기위해 연속적인 데이터로 변환하는 것
	
	// 자바는 Serializable 인터페이스를 구현한 클래스만 직렬화 할 수 있도록 제한하고 있다
	// 구현하지 않으면 java.io.NotSerialiazalbeException 예외 발생
	private static final long serialVersionUID = 562285606573703211L;
	
	//tranient => 직렬화가 되지 않을 멤버변수에 지정 (static 필드도 직렬화되지 않는다)
	// 직렬화가 되지 않는 멤버변수는 기본값으로 저장된다 (참조형 변수 null, 숫자형 변수 0) -> 출력 시 기본값으로 인출
	private String name;
	private transient int age; // 직렬화 대상에서 제외
	private String addr;
	
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
