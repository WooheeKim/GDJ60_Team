package com.iu.s2.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s2.util.Pager;


@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	// list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		List<BoardDTO> ar = boardService.getBoardList(pager);
		
		modelAndView.setViewName("board/list");
		modelAndView.addObject("list", ar);
		modelAndView.addObject("pager", pager);		
		return modelAndView;
	}
	// detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getBoardDetail(BoardDTO boardDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		boardDTO = boardService.getBoardDetail(boardDTO);
		
		modelAndView.setViewName("board/detail");
		modelAndView.addObject("dto", boardDTO);
		
		return modelAndView;
	}
	// add form 이동
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView setBoardAdd(ModelAndView modelAndView) throws Exception {
		modelAndView.setViewName("board/add");
		
		return modelAndView;
		
	}
	// add DB Insert
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView setBoardAdd(BoardDTO boardDTO, MultipartFile pic, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println("Name : "+pic.getName());
		System.out.println("OriName : "+pic.getOriginalFilename());
		System.out.println("Size : "+pic.getSize());
		System.out.println(session.getServletContext());
		
		int result = boardService.setBoardAdd(boardDTO, pic);
		
		modelAndView.setViewName("redirect:./list");
		
		return modelAndView;
	}
	// delete
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView setBoardDelete(BoardDTO boardDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		int result = boardService.setBoardDelete(boardDTO);
		
		modelAndView.setViewName("redirect:./list");
		
		return modelAndView;
	}
	// 수정 폼 이동
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView setBoardUpdate(BoardDTO boardDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		boardDTO = boardService.getBoardDetail(boardDTO);
		modelAndView.setViewName("board/update");
		modelAndView.addObject("dto", boardDTO);
		return modelAndView;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView setBoardUpdate(BoardDTO boardDTO, ModelAndView modelAndView) throws Exception {
		int result = boardService.setBoardUpdate(boardDTO);
		
		modelAndView.setViewName("redirect:./list");
		
		return modelAndView;
	}

	
}
