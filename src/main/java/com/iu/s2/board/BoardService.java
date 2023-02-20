package com.iu.s2.board;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s2.util.FileManager;
import com.iu.s2.util.Pager;

@Service
public class BoardService {
	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;
	
	public List<BoardDTO> getBoardList(Pager pager) throws Exception {
		
		Long totalCount = boardDAO.getBoardCount(pager);
		
		pager.makeNum(totalCount);
		pager.makeRow();
		
		return boardDAO.getBoardList(pager);
	}
	
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		return boardDAO.getBoardDetail(boardDTO);
	}
	
	public int setBoardAdd(BoardDTO boardDTO, MultipartFile pic) throws Exception {
		int result = boardDAO.setBoardAdd(boardDTO);
		
		
	}
	
}
