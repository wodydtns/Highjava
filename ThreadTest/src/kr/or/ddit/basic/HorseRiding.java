package kr.or.ddit.basic;

import java.util.List;

/*
 * 10마리의 말들이 경주하는 경마 프로그램 작성하기

		말은 Horse라는 이름의 클래스로 구성하고,
		이 클래스는 말이름(String), 등수(int)를 멤버변수로 갖는다.
		그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는
		기능이 있다.( Comparable 인터페이스 구현)
		
		경기 구간은 1~50구간으로 되어 있다.
		
		경기 중 중간중간에 각 말들의 위치를 나타내시오.
		예)
		1번말 --->------------------------------------
		2번말 ----->----------------------------------
		...
		
		경기가 끝나면 등수 순으로 출력한다.
 */

public class HorseRiding {
	static String strRank = "";

	public static void main(String[] args) {
		DisplayHorse[] disHorse = new DisplayHorse[] {
				new DisplayHorse("A"),
				new DisplayHorse("B"),
				new DisplayHorse("C"),
		};
		for(int i=0;i < disHorse.length;i++) {
			disHorse[i].start();
		}
		for(DisplayHorse dh : disHorse) {
			try {
				dh.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("경기 끗");
		System.out.println("----------------------------");
		System.out.println();
		System.out.println("경기 결과");
		System.out.println("순위: " + strRank);
	}
}
class DisplayHorse extends Thread{
	private String Hname;
	
	public DisplayHorse(String Hname) {
		this.Hname =Hname;
	}
	@Override
	public void run() {
		for(int i=1;i<=50;i++) {
			
			System.out.print(">");
		}
		try {
			Thread.sleep((int)(Math.random()*1000)+1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Hname + "골인");
		HorseRiding.strRank += Hname + " ";
	}
}
//순위로 정렬
//class Horse implements Comparable<Horse>{
//
//	private int score;
//	
//	public Horse(int score) {
//		super();
//		this.score = score;
//	}
//
//	public int getScore() {
//		return score;
//	}
//
//	public void setScore(int score) {
//		this.score = score;
//	}
//	
//	@Override
//	public int compareTo(Horse num) { // 등수 비교
//		return Integer.compare(getScore(), num.getScore());
//	}
//	
//}