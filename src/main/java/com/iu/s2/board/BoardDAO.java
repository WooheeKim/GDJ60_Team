package com.iu.s2.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s2.util.Pager;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s2.board.BoardDAO.";
	
	public Long getBoardCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getBoardCount", pager);
	}
	
	public List<BoardDTO> getBoardList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getBoardList", pager);
	}
	
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getBoardDetail", boardDTO);
	}
	
	public int setBoardAdd(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setBoardAdd", boardDTO);
	}
	
	public int setBoardUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setBoardUpdate", boardDTO);
	}
	
	public int setBoardDelete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setBoardDelete", boardDTO);
	}
	
	public int setBoardImgAdd(BoardImgDTO boardImgDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setBoardImgAdd", boardImgDTO);
	}
}
