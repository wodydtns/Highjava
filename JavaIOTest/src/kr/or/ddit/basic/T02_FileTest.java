package kr.or.ddit.basic;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class T02_FileTest {

	public static void main(String[] args) {
		File f1 = new File("d:/D_Other/sample.txt");
		File f2 = new File("d:/D_Other/test.txt");
		
		if(f1.exists()){ // exists() -> 파일이 있는가?
			System.out.println(f1.getAbsolutePath() + "은 존재합니다.");
		}else{
			System.out.println(f1.getAbsolutePath() + "은 없는 파일입니다.");
			try {
				if(f1.createNewFile()){ // 파일을 생성하는 메소드
					System.out.println(f1.getAbsolutePath() + 
											"파일을 새로 만들었습니다.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(f2.exists()){
			System.out.println(f2.getAbsolutePath() + "은 존재합니다.");
		}else{
			System.out.println(f2.getAbsolutePath() + "은 없는 파일입니다.");
		}
		System.out.println("-----------------------------");
		
		File f3 = new File("d:/D_Other");
		File[] files = f3.listFiles(); //파일 목록 가져오기 - 파일 객체를 담은 배열
		for(int i=0; i<files.length; i++){
			System.out.print(files[i].getName() + " => " );
			if(files[i].isFile()){
				System.out.println("파일");
			}else if(files[i].isDirectory()){
				System.out.println("디렉토리");
			}
		}
		
		System.out.println("=========================");
		String[] strFiles = f3.list(); // 파일 이름만 가져오려고 할 때는 list만해도 가능
		for(int i=0; i<strFiles.length; i++){
			System.out.println(strFiles[i]);
		}
		System.out.println("---------------------------------------");
		System.out.println();
		
		// 출력할 디렉토리 정보를 갖는 File객체 생성
		File f4 = new File("D:/D_Other");   
		
		displayFileList(f4);  // 메서드 호출
		
		
	}  // main메서드 끝.
	
	// 지정된 디렉토리(폴더)에 포함된 파일과 디렉토리 목록을 보여주는 메서드
	// 파일 객체는 폴더와 파일을 모두 담을 수 있다.
	public static void displayFileList(File dir){ //static메소드
		System.out.println("[" + dir.getAbsolutePath() + "] 디렉토리의 내용");
		
		// 디렉토리 안의 모든 파일 목록을 가져온다.
		File[] files = dir.listFiles();
		
		// 하위 디렉토리 정보를 저장할 ArrayList 생성(File배열의 첨자 저장)
		ArrayList<Integer> subDirList = new ArrayList<Integer>();
		
		// 날짜를 출력하기 위한 형식 설정
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		
		for(int i=0; i<files.length; i++){
			String attr = ""; // 파일의 속성(읽기, 쓰기, 히든, 디렉토리 구분)
			String size = ""; // 파일 용량
			
			if(files[i].isDirectory()){
				attr = "<DIR>";
				subDirList.add(i);  // 첨자를 List에 추가 subDirList 디렉토리의 인덱스값이 있음
			}else{
				size = files[i].length() + "";
				attr = files[i].canRead() ? "R" : " "; // 읽기 가능한가
				attr += files[i].canWrite() ? "W" : " "; // 쓸 수 있는가
				attr += files[i].isHidden() ? "H" : " "; //파일 숨기기
			}
			
			System.out.printf("%s %5s %12s %s\n", //%s string , %5 - 5자리 string, %12 -12자리 string
					sdf.format(new Date(files[i].lastModified())), attr, // lastModified() 최근 수정일을 가져오는 메소드
					size, files[i].getName() );
		} // for문 끝..
		
		int dirCount = subDirList.size(); // 폴더안의 하위폴더 개수구하기 
		int fileCount = files.length - dirCount; // 폴더안의 파일 개수 구하기
		
		System.out.println(fileCount + "개의 파일, " + 
									dirCount + "개의 디렉토리");
		System.out.println();
		
		for(int i=0; i<subDirList.size(); i++){ //subDirList.size() -디렉토리의 개수
			// 하위 폴더의 내용들도 출력하기 위해 
			// 현재 메서드를 재귀호출하여 처리한다.
			displayFileList(files[subDirList.get(i)]); // 재귀호출
		}
		
	}
	

}








