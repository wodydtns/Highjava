package crudVO;



public class CrudVO {
	private int board_no;
	private String board_title;
	private String board_writer;
	private String board_date;
	private String board_content;
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date2) {
		this.board_date = board_date2;
	}
	
	@Override
	public String toString() {
		return "CRUDVO [board_no=" + board_no + ", board_title ="
				+ ", " + board_title+ ", board_writer = " 
				+ board_writer + ", board_date = " + board_date 
				+ ", board_content= "+  board_content + "]";
	}
}
