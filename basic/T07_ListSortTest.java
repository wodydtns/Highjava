package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Comparable and Comparator 예제
 * 
 */

public class T07_ListSortTest {
		public static void main(String[] args) {
			List<Member> memList = new ArrayList<>();
			
			memList.add(new Member(1, "홍길동", "010-1111-1111"));
			memList.add(new Member(5, "변학도", "010-2222-2222"));
			memList.add(new Member(9, "성춘향", "010-3333-3333"));
			memList.add(new Member(3, "이순신", "010-4444-4444"));
			memList.add(new Member(6, "강감찬", "010-5555-5555"));
			memList.add(new Member(2, "일지매", "010-6666-6666"));
			
			System.out.println("정렬 전");
			for(Member mem: memList) {
				System.out.println(mem);
			}
			System.out.println("================================");
			
			Collections.sort(memList); // 정렬하기
			
			System.out.println("이름의 오름차순으로 정렬 후");
			System.out.println("================================");
			for(Member mem:memList) {
				System.out.println(mem);
			}
			System.out.println("================================");
			
//			외부 정렬 기준을 이용해 정렬하기
			Collections.sort(memList, new SortNumDesc());
			
			System.out.println("번호의 내림차순으로 정렬 후");
			for(Member mem:memList) {
				System.out.println(mem);
				
			}
		}
}
/*
 * 
 * 정렬 기준의 외부 선언을 위해서는 Comparator 인터페이스를 구현하면 된다
 * Member의 번호(num)로 내림차순으로 정렬하기
 *
 */
class SortNumDesc implements Comparator<Member>{
	
	
	@Override
	public int compare(Member mem1, Member mem2) {
		/*if(mem1.getNum() > mem2.getNum()) {
			return -1; //앞자리가 크면 -1 => 내림차순 기준
		}else if(mem1.getNum() == mem2.getNum()){
			return 0;
		}else {
			return 1; // 뒷자리가 크면 1 => 내림차순 기준
		}*/
		
		//Wrapper 클래스에서 제공하는 메소드를 이용하는 방법
//		return Integer.compare(mem1.getNum(), mem2.getNum())*-1; //integer값을 비교
		
		// Wrapper클래스에서 제공하는 메소드를 이용하는 방법2
		return new Integer(mem1.getNum()).compareTo(mem2.getNum())*-1;
		
	}
	
}
/*
 * 회원의 정보를 저장할 클래스
 * 회원접오는 회원번호, 회원이름, 전화번호로 되어있다
 * 회원이름을 기준으로 오름차순 정렬이 될 수 있게 하는 클래스 만들기
 */
class Member implements Comparable<Member>{

	private int num; //번호
	private String name; //이름
	private String tel; //전화번호
	
	public Member(int num, String name, String tel) { //생성자 -> Source -> Generate Construtor using 
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

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
	
	@Override
	public String toString() {
		return "Member[num=" + num + ",name=" + name + ", tel=" + tel + "]";
	}
	/*
	 	이름을 기준으로 오름차순 정렬
	 */
	@Override
	public int compareTo(Member mem) {
		return getName().compareTo(mem.getName()); // 
	}
	
}
