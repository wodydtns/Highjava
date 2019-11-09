package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제) 5명의 사람 이름을 입력해 ArrayList에 저장
 * 		이 중에 '김'씨 성의 이름을 출력
 * 		(단, 입력은 Scanner를 이용해 입력받기)
 */

public class T03_ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> people1 = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		
		for(int i=0;i<5;i++) {
			System.out.println("입력하세요");
			String input = s.nextLine();
			people1.add(input);
		}
		System.out.println("찾을 성을 입력하세요");
		String first = s.nextLine();
		for(int i=0;i<people1.size();i++) {
			String a = people1.get(i);
			if(a.charAt(0)==first.charAt(0)) {
				System.out.println(people1.get(i));
			}
		}
		
		
	}
}
