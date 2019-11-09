package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * vector, HashTable등 예전부터 존재하던 Collection들은 내부에 동기화 처리가 되어있다
 * 최근에 구성된 Collection들은 동기화 처리 x 
 * => 동기화가 필요한 프로그램에서 이런 Collection들을 사용하려면 동기화 처리 한 후 사용해야함
 */
public class T18_SyncCollectionTest {
	//동기화 하지 않을 경우
	private static List<Integer> list1 = new ArrayList<Integer>();
	
	//동기화 하는 경우
	// Collections의 정적 메소드 중 synchronized로 시작하는 메소드 이름
	private static List<Integer> list2 = 
			Collections.synchronizedList(new ArrayList<Integer>());
			
	public static void main(String[] args) {
		//익명클래스로 쓰레드 구현
		Runnable r = new Runnable() {

			@Override
			public void run() {
				for(int i=1;i<=10000;i++) {
					list1.add(i); // 동기화 처리하지 않은 리스트 사용
					list2.add(i); // 동기화 처리한 리스트 사용
				}
			}
		};
		Thread[] ths = new Thread[] {
				new Thread(r), new Thread(r),
				new Thread(r), new Thread(r), new Thread(r)
		};
		for(Thread th : ths) {
			th.start();
		}
		for(Thread th : ths) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("list1의 개수: " + list1.size());
		System.out.println("list2의 개수: " + list2.size());
	}
}
