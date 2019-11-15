package kr.or.ddit.basic;

import java.io.File;

public class T01_FileTest {
	public static void main(String[] args) {
		// File객체 만들기 연습
		
		//1. new File(String 파일 또는 경로명)
		// =>디렉토리와 디렉토리 사이 또는 디렉토리와 파일명 사이의 구분문자는 '\', '/'를 사용
		File file = new File("d:\\D_Other\\test.txt"); // test.txt를 컨트롤 하기 위한 객체 생성 , 실제 파일 생성과는 다름
		System.out.println("파일명: "+file.getName());
		System.out.println("파일 여부: "+file.isFile());
		System.out.println("폴더 여부: " + file.isDirectory());
		System.out.println("===================================");
		
		File file2 = new File("d:/D_Other");
		// File file2 = new File("d:/D_Other/test.txt");
		System.out.println(file2.getName()+"은");
		if(file2.isFile()) {
			System.out.println("파일");
		}else if(file2.isDirectory()) {
			System.out.println("폴더");
		}
		System.out.println("=====================================");
		//2.new File(File Parent, String Child)
		// => 'parent' 디렉토리 안에 있는 'Child'파일 또는 디렉토리를 갖는다.
		File file3 = new File(file2,"test.txt");  // 파일객체, "파일이름"
		System.out.println(file3.getName()+"의 용량의 크기"+file3.length()+"bytes"); // 파일 크기 가져오는 방법 해당파일 객체.length()
		
		//3.new File(String parent, String child)
		File file4 = new File("\\D_Other\\test\\..","test.txt"); // "경로", "파일명" 
		System.out.println("절대 경로: " + file4.getAbsolutePath()); // ../ 상위폴더를 의미  - ./ -> 현재 폴더를 의미
		// 생성자에 설정해준 경로
		System.out.println("경로: " + file4.getPath()); // "\\D_Other\\test\\.." 이거 리턴
		System.out.println("=====================================");
		/*
		 * 폴더 만들기 
		 * 1. mkdir() : File 객체의 경로 중 마지막 위치의 디렉토리를 만든다 / 중간의 경로가 모두 미리 만들어져 있어야한다.
		 * 2. mkdirs() : 중간의 경로가 없으면 중간 경로도 새롭게 만든 후 마지막 위치의 디렉토리를 만들어 준다.
		 * 
		 * => 위 두 메소드 모두 만들기를 성공하면 true, 실패하면 false를 반환
		 * 
		 */
		File file5 = new File("d:/D_Other/연습용");
		if(file5.mkdir()) {
			System.out.println(file5.getName()+"만들기 성공!");
			
		}else {
			System.out.println(file5.getName()+"만들기 실패!");
		}
		System.out.println();
		File file6 = new File("d:/D_Other/test/java/src"); 
//		if(file6.mkdir()) { // 중간 경로(test폴더)가 없다.
		if(file6.mkdirs()) { // 중간 경로(test폴더)도 생성하면서 폴더 생성
			System.out.println(file6.getName()+"만들기 성공!");
		}else {
			System.out.println(file6.getName()+"만들기 실패!");
		}
		System.out.println();
		
	}
}
