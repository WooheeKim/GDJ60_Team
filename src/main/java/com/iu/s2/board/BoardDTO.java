package com.iu.s2.board;

public class BoardDTO {
	private Long num;
	private String title;
	private String contents;
	private String writer;
	private String regDate;
	private Long hit;
	private BoardDTO boardDTO;
	
	public BoardDTO getBoardDTO() {
		return boardDTO;
	}
	public void setBoardDTO(BoardDTO boardDTO) {
		this.boardDTO = boardDTO;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Long getHit() {
		return hit;
	}
	public void setHit(Long hit) {
		this.hit = hit;
	}
	
	
}
