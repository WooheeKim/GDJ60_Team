package com.iu.s2.bankBook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s2.MyTestCase;
import com.iu.s2.board.BbsDTO;
import com.iu.s2.util.Pager;

public class BankBookCommentDAOTest extends MyTestCase{

	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	//list
	@Test
	public void getBoardListTest()throws Exception{
		Pager pager = new Pager();
		
		pager.setBookNum(309L);
		//pager.setKind("writer");
		//pager.setSearch("ch");
		pager.makeRow();
		//long count = bankBookCommentDAO.getTotalCount(pager);
		List<BbsDTO> ar = bankBookCommentDAO.getBoardList(pager);
		assertNotEquals(0, ar.size());
		
	}

}
