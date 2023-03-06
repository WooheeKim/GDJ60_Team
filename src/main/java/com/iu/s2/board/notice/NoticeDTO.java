package com.iu.s2.board.notice;

import java.util.List;

import com.iu.s2.board.BoardDTO;
import com.iu.s2.board.BoardFileDTO;

public class NoticeDTO extends BoardDTO {
private List<BoardFileDTO> boardFileDTOs;
	
	
	
	public List<BoardFileDTO> getBoardFileDTOs() {
		return boardFileDTOs;
	}
	public void setBoardFileDTOs(List<BoardFileDTO> boardFileDTOs) {
		this.boardFileDTOs = boardFileDTOs;
	}

}
