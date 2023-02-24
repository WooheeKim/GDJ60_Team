package com.iu.s2.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s2.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QNAController {
	@Autowired
	private QNAService qnaService;
	
	// list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getQNAList(Pager pager) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		List<QNADTO> ar = qnaService.getQNAList(pager);
		
		modelAndView.setViewName("qna/list");
		modelAndView.addObject("list", ar);
		
		return modelAndView;
	}
	
}
