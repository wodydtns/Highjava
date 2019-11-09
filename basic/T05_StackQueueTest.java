package kr.or.ddit.basic;

import java.util.LinkedList;

public class T05_StackQueueTest {
	public static void main(String[] args) {
		/*
		 * Stack : 후입선출(LIFO)의 자료 구조
		 * Queue : 선입선출(FIFO)의 자료 구조
		 * Stack과 Queue는 LinkedList를 이용해 사용할 수 있다
		 */
		LinkedList<String> stack = new LinkedList<>();
		
		/*
		 * stack의 명령
		 * 1) 자료 입력 : push(저장할 값)
		 * 2) 자료 출력 : pop() -> 자료를 꺼내온 후 꺼내온 자료를 stack에서 삭제
		 */
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("성춘향");
		stack.push("이순신");
		System.out.println("현재 stack값 : " + stack);
		
		String data = stack.pop();
		System.out.println("꺼내온 자료 : "+ data); // 선출
		System.out.println("꺼내온 자료 : "+ stack.pop()); // 선출
		System.out.println("현재 stack값들 :" + stack);
		System.out.println("=========================================");
		
		stack.push("춘향이");
		System.out.println("현재 stack값들 :" + stack);
		System.out.println("꺼내온 자료 : "+ stack.pop());
		
		System.out.println("=========================================");
		System.out.println();
		
		LinkedList<String> queue = new LinkedList<>();
		/*
		 * Queue의 명령
		 * 1) 자료 입력 : offer(저장할 값)
		 * 2) 자료 출력 : poll() -> 자료를 Queue에서 꺼내온 후 꺼내온 자료를 Queue에서 삭제
		 * 
		 */
		queue.offer("멘소레담");
		queue.offer("물티슈");
		queue.offer("섬유유연제");
		queue.offer("키보드");
		System.out.println("현재 queue의 값: " + queue);
		
		System.out.println("=========================================");
		String temp = queue.poll();
		System.out.println("꺼내온 자료 "+temp);
		System.out.println("꺼내온 자료 "+queue.poll());
		System.out.println("현재 queue의 값: " + queue);

		System.out.println("=========================================");
		if(queue.offer("성춘향")) {
			System.out.println("신규 등록 자료: 성춘향");
		}
		System.out.println("현재 queue의 값: " + queue);
		System.out.println("꺼내온 자료 "+queue.poll());
	}
}
