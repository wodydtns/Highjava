package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;


/*
 * 프린터 기능 제공 보조 스트림 예제
 */
public class T14_PrintStreamTest {
	public static void main(String[] args) throws IOException {
		FileOutputStream fout = new FileOutputStream("d:/D_Other/print.txt");
		FileOutputStream fout2 = new FileOutputStream("d:/D_Other/print2.txt");
		
		PrintStream out = new PrintStream(System.out);
		PrintStream out1 = new PrintStream(fout2);
		
		out.print("안녕하세요. PrintStream입니다.\n");
		out.println("안녕하세요. PrintStream2입니다.");
		out.println("안녕하세요. PrintStream3입니다.");
		out1.print("안녕하세요. PrintStream입니다.\n");
		out1.println("안녕하세요. PrintStream2입니다.");
		out1.println("안녕하세요. PrintStream3입니다.");
		
		
		out.close();
		out1.close();
		PrintWriter writer = new PrintWriter(fout);
		PrintWriter writer1 = new PrintWriter(new OutputStreamWriter(fout,"utf-8"));
		
		
		writer.print("하이요. PrintWriter입니다.\r\n");
		writer.println("하이요. PrintWriter2입니다.");
		writer.println("하이요. PrintWriter3입니다.");
		
		writer1.print("하이요. PrintWriter입니다.\r\n");
		writer1.println("하이요. PrintWriter2입니다.");
		writer1.println("하이요. PrintWriter3입니다.");
		writer.close();
		writer1.close();
		
	}
}
