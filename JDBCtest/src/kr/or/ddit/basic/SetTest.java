package kr.or.ddit.basic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
	public static void main(String[] args) {
		Set<String> hashSet = new HashSet<String>();
		Set<String> treeSet = new TreeSet<String>();
		
		hashSet.add("A");
		treeSet.add("A");

		treeSet.add("B");
		hashSet.add("B");
		
		hashSet.add("F");
		treeSet.add("F");
		
		hashSet.add("C");
		treeSet.add("C");
		System.out.println("hashset: " + hashSet);
		System.out.println("treeset: "+ treeSet);
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss");
		Date currentTime = new Date ( );
		String dTime = formatter.format ( currentTime );
		System.out.println(dTime);

	}
}
