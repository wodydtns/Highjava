package kr.or.ddit.basic;

import java.lang.reflect.Array;
import java.util.ArrayList;
/*
 *  문제1) 5명의 별명을 입력하고 ArrayList에 저장 -> 별명의 길이가 제일 긴 별명을 출력하시오
 *  	(단, 각 별명의 길이는 모두 다르게 입력)
 *  
 *  문제2) 문제1에서 별명의 길이가 같은 것을 여러 개 입력했을 때도 
 *  	   출력되도록 처리하시오.
 */
public class T04_ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> alias = new ArrayList<String>();
		ArrayList<String> b = new ArrayList<>();
		alias.add("kakao");
		alias.add("card");
		alias.add("book");
		alias.add("cup");
		alias.add("earphone");
		alias.add("virtualbox");
		alias.add("asddwewrrr");
		alias.add("asdfasf");
		String temp = alias.get(0);
		for(int i=0;i <alias.size();i++) {
			if(temp.length() < alias.get(i).length()) {
				temp = alias.get(i);
			}
		}
		for(int i=0;i < alias.size();i++) {
			if(temp.length() ==  alias.get(i).length()) {
				System.out.println(alias.get(i));
			}
		}
	}
}

