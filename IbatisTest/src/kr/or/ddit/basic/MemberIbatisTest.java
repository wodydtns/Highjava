package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.member.vo.MemberVO;

public class MemberIbatisTest {
	public static void main(String[] args) {
		//iBatis를 이용하여 DB자료를 처리하는 작업 순서
		// 1. ibatis의 환경 설정 파일을 읽어와 실행
			try {
				// 1.1 xml 문서 읽어오기
				Charset charset = Charset.forName("UTF-8"); // 설정 파일 인코딩
				Resources.setCharset(charset);
				
				Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
				
				//1.2 위에서 읽어온 Reader객체를 이용해 실제 작업을 진행할 객체 생성
				SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd); // reader를 통해서 정보 전달
				
				rd.close();
				
				// 2. 실행할 SQL문에 맞는 쿼리문을 호출해 원하는 작업 수행
				
				//2.1 insert작업 연습
				System.out.println("insert작업 시작");
				//2.1.1 저장할 데이터를 VO에 담는다
				MemberVO mv = new MemberVO();
				mv.setMem_id("d001");
				mv.setMem_name("강감찬");
				mv.setMem_tel("0000-2222");
				mv.setMem_addr("경남 김해시");
				
				//2.1.2 SqlMapClient 객체 변수를 이용해 해당 쿼리문 실행
				// 형식 : smc.insert("namespace값.id값", 파라미터클래스); "namespace값.id값" == 쿼리 아이디 
				// 		 반환값 : 성공 시 null 
				// namespace : package와 비슷 - 각각의 동일한 이름의 id값이 있을 경우 -> namespace로 구분  
				// 
				Object obj = smc.insert("memberTest.insertMember",mv);  
				if(obj == null) {
					System.out.println("insert작업 성공");
				}else {
					System.out.println("insert 작업 실패");
				}
				System.out.println("===================================");
				
				// 2.2 update 작업 연습
				
				MemberVO mv2 = new MemberVO();
				mv2.setMem_id("d001");
				mv2.setMem_name("박재욱");
				mv2.setMem_tel("010-2545-3455");
				mv2.setMem_addr("대덕인재개발원");
				
				//update() 메소드의 반환값은 성공한 레코드 수
				int cnt = smc.update("memberTest.updateMember",mv2);
				
				if(cnt >0) {
					System.out.println("업데이트 되었습니다.");
				}else {
					System.out.println("업데이트 실패");
				}
				System.out.println("===================================");
				
				//2.3 delete 작업 연습 - 성공 시 성공한 레코드 수 반환
				int cnt2 = smc.delete("memberTest.deleteMember","d001"); // id값만 넣으면 삭제 가능하므로 string만
				if(cnt2 > 0) {
					System.out.println("삭제 성공");
				}else {
					System.out.println("삭제 실패");
				}
				System.out.println("===================================");
				
				// 2.4 select 작업 연습
				//1) 응답 결과가 여러개인 경우
				
				System.out.println("select 연습 시작(결과가 여러개인 경우)");
				List<MemberVO> memList;
				
				//응답의 결과가 여러개인 경우 queryForList메소드 사용
				//이 메소드는 여러개의 레코드를 VO에 담은 후 이 VO데이터를 List에 추가해주는 작업을 자동으로 수행한다.
				memList = smc.queryForList("memberTest.getMemberAll");
				
				for(MemberVO memVO : memList) {
					System.out.println("ID: "+memVO.getMem_id());
					System.out.println("이름: "+memVO.getMem_name());
					System.out.println("전화번호: "+memVO.getMem_tel());
					System.out.println("주소: "+memVO.getMem_addr());
				}
				System.out.println("출력 끗");
				
				//2) 응답 결과가 한 개
				System.out.println("select 연습 시작(결과가 한개인 경우");
				System.out.println("===================================");
				System.out.println("===================================");
				//응답 결과가 1개인 것이 확실할 경우 queryForObject메소드 사용
				MemberVO mv3 = (MemberVO) smc.queryForObject("memberTest.getMember","wodydtns");
				
				System.out.println("ID: "+mv3.getMem_id());
				System.out.println("이름: "+mv3.getMem_name());
				System.out.println("전화번호: "+mv3.getMem_tel());
				System.out.println("주소: "+mv3.getMem_addr());
				System.out.println("출력 끗");
						
			}catch(IOException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				
				e.printStackTrace();
			}
	}
}
