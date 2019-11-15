package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 *	 
 */
public class PhoneBookUpgrade {
	public static void main(String[] args) {

		PhoneBookUpgrade pb = new PhoneBookUpgrade();
		pb.start();
	}

	private Scanner scan;
	private Map<String, Phone> phoneBookMap;


	public PhoneBookUpgrade() {
		scan = new Scanner(System.in);
		phoneBookMap = new HashMap<>();
	}

	//메뉴 출력
	public void displayMenu() {
		System.out.println();
		System.out.println("메뉴를 선택하세요.");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체 출력");
		System.out.println("0.프로그램 종료 및 저장");
		System.out.println("번호 선택");

	}
	public void start() {
		System.out.println("===============================");
		System.out.println("전화번호 저장 프로그램");
		System.out.println("===============================");

		while(true) {
			displayMenu();
			int menuNum = scan.nextInt();
			switch(menuNum) {
			case 1 : 
				insert();
				break;
			case 2 :
				update();
				break;
			case 3 :
				delete();
				break;
			case 4 :
				search();
				break;
			case 5 :
				displayAll();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				save();
				System.exit(0);
			}

		}
	}


	private void displayAll() {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(
					"d:/D_Other/phonebook.txt")));
			try {
				Object obj =ois.readObject();
				while(obj !=null) {
					Phone phone = (Phone) obj;
					System.out.println("이름:" + phone.getName());
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void search() {
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요");
		System.out.println("이름");
		String name = scan.next();

		Phone p = phoneBookMap.get(name);
		if(p == null) {
			System.out.println(name + "씨의 정보가 없습니다.");
		}else {
			System.out.println(name + "의 전화번호 정보");
			System.out.println("이름:" + p.getName());
			System.out.println("전화번호:" + p.getTel());
			System.out.println("이름:" + p.getAddr());
		}
	}
	private void delete() {
		System.out.println();
		System.out.println("삭제할 사람 이름을 입력하세요.");
		System.out.println("이름");
		String name = scan.next();
		if(phoneBookMap.remove(name) == null) {
			System.out.println(name + "은 등록된 사람이 아닙니다.");
		}else {
			System.out.println(name + "의 정보를 삭제했습니다.");
		}
	}
	// 전화번호부 
	private void save() {
		
	}


	private void update() {
		System.out.println();
		System.out.println("수정할 사람의 이름을 입력하세요.");
		System.out.println("이름");
		String name = scan.nextLine();

		// 수정할 자료가 있는 지 조사
		if(phoneBookMap.get(name)==null) {
			System.out.println("수정할 전화번호가 없습니다.");
			return;
		}
		System.out.println("전화번호");
		String tel = scan.nextLine();
		System.out.println("주소");
		String addr = scan.nextLine();

		phoneBookMap.put(name, new Phone(name, tel, addr));
		// 전화번호 수정
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream("d:/D_Other/phonebook.txt")));
			oos.writeObject(phoneBookMap);
			System.out.println("등록 완료");
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//전화번호를 삽입하는 메소드
	private void insert() {
		//파일을 생성해야함 

		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("d:/D_Other/phonebook.txt")));
			System.out.println("");
			System.out.println("정보를 입력하세요.");
			System.out.println("이름");
			//이름이 중복인지 확인해야함 - 아직 생각이 떠오르지 않음 
			String name = scan.next();
			System.out.println("전화번호");
			String tel = scan.next();
			System.out.println("주소");
			System.out.println();
			String addr = scan.next();
			Phone p = new Phone(name, tel, addr);
			oos.writeObject(p);
			System.out.println("저장완료");
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
// 전화번호를 저장하는 vo 클래스
class Phone implements Serializable{

	private static final long serialVersionUID = 5212671553148841438L;
	private String name;
	private String tel;
	private String addr;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Phone(String name, String tel, String addr) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}
	@Override
	public String toString() { // console에서 찍을 때 toString을 불러옴
		return "Phone[name=" + name + ",tel= " + tel + ",addr= " + addr + "]";
	}
}
