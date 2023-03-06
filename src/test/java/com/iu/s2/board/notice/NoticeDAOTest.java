package com.iu.s2.board.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s2.MyTestCase;

public class NoticeDAOTest extends MyTestCase {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void setBoardAddTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("Title1");
		noticeDTO.setWriter("writer1");
		noticeDTO.setContents("Contents1");
		int result = noticeDAO.setBoardAdd(noticeDTO);
		assertEquals(1, result);
	}

}
