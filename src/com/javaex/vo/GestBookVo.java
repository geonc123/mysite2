package com.javaex.vo;


public class GestBookVo {
	private int no;
	private String id;
	private String password;
	private String noticBoard;
	private String nowdate;

	
	
	public String getNoticBoard() {
		return noticBoard;
	}
	public void setNoticBoard(String noticBoard) {
		this.noticBoard = noticBoard;
	}
	public GestBookVo(int no, String id, String password, String noticBoard, String nowdate) {
		
		this.no = no;
		this.id = id;
		this.password = password;
		this.noticBoard = noticBoard;
		this.nowdate = nowdate;
	}
	
	
	public GestBookVo() {
		
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNowdate() {
		return nowdate;
	}
	public void setNowdate(String nowdate) {
		this.nowdate = nowdate;
	}
	@Override
	public String toString() {
		return "GestBookVo [no=" + no + ", id=" + id + ", password=" + password + ", noticBoard=" + noticBoard
				+ ", nowdate=" + nowdate + "]";
	}

	
	
}