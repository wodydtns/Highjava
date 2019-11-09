package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


public class T11_BaseBallTest {

	/*
	 * 문제) Set을 이용해 숫자 야구 게임 프로그램 작성
	 * 컴퓨터의 숫자는 난수를 이용해 구하기
	 * (스트라이크는 'S', 볼은 'B'로)
	 * 컴퓨터의 난수가 9 5 7 일때 실행 예시
	 * 숫자 입력 => 3 5 6 => 1S 0B
	 * 숫자입력 => 7 8 9 => 0S 2B
	 * 숫자입력 => 9 5 7 => 3번째만에 맞췄군요.
	 */
	public static void main(String[] args) {

		HashSet<Integer> intRnd = new HashSet<>(); //3개 난수 생성
		while(intRnd.size()< 3) {
			int num = (int)(Math.random()*9)+1;
			intRnd.add(num);
		}
		List<Integer> intRndList = new ArrayList<Integer>(intRnd);
		Collections.shuffle(intRndList);
		int a1 = intRndList.get(0);
		int a2 = intRndList.get(1);
		int a3 = intRndList.get(2);

		Scanner s = new Scanner(System.in);
		System.out.println("3자리 숫자를 입력해주세요.");

		int count =0; //카운트
		while(true) {
			int input = Integer.parseInt(s.nextLine());
			int i3 = input % 10; // 3자리 수 나누기 10 => 나머지는 1의 자리
			input /= 10;
			int i2 = input % 10; // 2자리 / 10 => 나머지
			int i1 = input / 10;
			
			int strike =0;
			int ball =0;
			if(a1 == i1) strike++;
			if(a2 == i2) strike++;
			if(a3 == i3) strike++;

			if(a1 == i2 || a1 == i3) ball++;
			if(a2 == i1 || a2 == i3) ball++;
			if(a3 == i1 || a3 == i2) ball++;
			System.out.println(++count + "차 시도(" + i1 + i2 + i3 + ") : " // ++count -> 호출되면 올라가는
					+ strike + "S" + ball + "B" );
			if(strike == 3){
				System.out.println("correct");
				System.out.println(count +"만에 성공하셨습니다.");
				break;
			}
		}
	}
}
