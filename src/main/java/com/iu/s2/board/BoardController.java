package com.iu.s2.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	// list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBoardList() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		List<BoardDTO> ar = boardService.getBoardList();
		
		modelAndView.setViewName("board/list");
		modelAndView.addObject("list", ar);
		
		return modelAndView;
	}
	
}
