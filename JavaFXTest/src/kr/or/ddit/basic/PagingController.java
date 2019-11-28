package kr.or.ddit.basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class PagingController implements Initializable{

	@FXML TableColumn<MemberVO, String> id;
	@FXML TableColumn<MemberVO, String> name;
	@FXML TableColumn<MemberVO, String> address;
	@FXML Pagination pagination;
	@FXML TableView<MemberVO> tableView;
	
	private int from, to, itemsForPage;
	
	private ObservableList<MemberVO> allTableData, currentPageData;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		address.setCellValueFactory(new PropertyValueFactory<>("address"));
		
		//전체 테이블 데이터 설정
		allTableData = FXCollections.observableArrayList();
		
		allTableData.add(new MemberVO("1", "홍길동1", "대전시 중구 대흥동"));
		allTableData.add(new MemberVO("2", "홍길동2", "대전시 중구 대흥동"));
		allTableData.add(new MemberVO("3", "홍길동3", "대전시 중구 대흥동"));
		allTableData.add(new MemberVO("4", "홍길동4", "대전시 중구 대흥동"));
		allTableData.add(new MemberVO("5", "홍길동5", "대전시 중구 대흥동"));
		allTableData.add(new MemberVO("6", "홍길동6", "대전시 중구 대흥동"));
		allTableData.add(new MemberVO("7", "홍길동7", "대전시 중구 대흥동"));
		allTableData.add(new MemberVO("8", "홍길동8", "대전시 중구 대흥동"));
		allTableData.add(new MemberVO("9", "홍길동9", "대전시 중구 대흥동"));
		allTableData.add(new MemberVO("10", "홍길동10", "대전시 중구 대흥동"));
		allTableData.add(new MemberVO("11", "홍길동11", "대전시 중구 대흥동"));
		allTableData.add(new MemberVO("12", "홍길동12", "대전시 중구 대흥동"));
		allTableData.add(new MemberVO("13", "홍길동13", "대전시 중구 대흥동"));
		allTableData.add(new MemberVO("14", "홍길동14", "대전시 중구 대흥동"));
		allTableData.add(new MemberVO("15", "홍길동15", "대전시 중구 대흥동"));
		allTableData.add(new MemberVO("16", "홍길동16", "대전시 중구 대흥동"));
		allTableData.add(new MemberVO("17", "홍길동17", "대전시 중구 대흥동"));
		
		//tableView.setItems(allTableData);
		
		itemsForPage = 5; //한 페이지에 보여줄 항목수 설정
		
		int totPageCount = allTableData.size()%itemsForPage == 0 ?
						   allTableData.size()/itemsForPage
						 : allTableData.size()/itemsForPage +1;	
						   
		pagination.setPageCount(totPageCount);
		//방법1(Callback타입의 익명객체 생성)
		pagination.setPageFactory(new Callback<Integer, Node>() {
			
			@Override
			public Node call(Integer pageIndex) {
				from = pageIndex + itemsForPage;
				to = from + itemsForPage -1;
				tableView.setItems(getTableData(from, to));
				return tableView;
			}
		});
						   
		
	}
	/**
	 * TableView에 채워줄 데이터를 가져오는 메서드
	 * @param from
	 * @param to
	 * @return
	 */
	private ObservableList<MemberVO> getTableData(int from, int to){
		currentPageData = FXCollections.observableArrayList();
		
		int totSize = allTableData.size();
		for(int i=from; i<= to && i < totSize; i++) {
			currentPageData.add(allTableData.get(i));
		}
		return currentPageData;
		
	}
	/*
	 	implements하지 않고 아래의 방법으로도 가능함
	 	@FXML
	 	public void initialize(){}
	 	
	 */

}
