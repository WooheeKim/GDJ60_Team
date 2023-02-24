package com.iu.s2.qna;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s2.util.FileManager;
import com.iu.s2.util.Pager;

@Service
public class QNAService {
	
	@Autowired
	private QNADAO qnaDAO;
	
	//testcase 테스트시 Null이 들어옴
	//API 추가
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private FileManager fileManager;
	
	public List<QNADTO> getQNAList(Pager pager) throws Exception {
		
		Long totalCount = qnaDAO.getQNACount(pager);//30
		
		pager.makeNum(totalCount);
		pager.makeRow();
		
		return qnaDAO.getQNAList(pager);
	}
	
	public QNADTO getQNADetail(QNADTO qnaDTO) throws Exception{
		return qnaDAO.getQNADetail(qnaDTO);
	}
	
	public int setQNAAdd(QNADTO qnaDTO, MultipartFile pic) throws Exception{
		int result= qnaDAO.setQNAAdd(qnaDTO);
		
		//1. File을 HDD에 저장 경로
		// Project 경로가 아닌 OS가 이용하는 경로
		String realPath = servletContext.getRealPath("resources/upload/qna");
		System.out.println(realPath);
		String fileName = fileManager.fileSave(pic, realPath);
		
		//2. DB에 저장
		QNAImgDTO qnaImgDTO = new QNAImgDTO();
		qnaImgDTO.setFileName(fileName);
		qnaImgDTO.setOriName(pic.getOriginalFilename());
		qnaImgDTO.setNum(qnaDTO.getNum());
		
		result = qnaDAO.setQNAImgAdd(qnaImgDTO);
				
		
		return result;//qnaDAO.setQNAAdd(qnaDTO);
	}
	
	public int setQNAUpdate(QNADTO qnaDTO) throws Exception{
		return qnaDAO.setQNAUpdate(qnaDTO);
	}
	
	public int setQNADelete(QNADTO qnaDTO) throws Exception{
		return qnaDAO.setQNADelete(qnaDTO);
	}

}
