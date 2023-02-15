package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/")
	public String aaa(Model model) {
		model.addAttribute("msg","Test");
		return "index";
	}
	
	
	@RequestMapping("/{num}")
	public ModelAndView index(@PathVariable int num, ModelAndView mav) {
		int res=0;
		for(int i = 1;i<=num;i++)
			res +=i;
		mav.addObject("msg","total: " + res);
		mav.setViewName("test"); 
		return mav;
	}
//	@GetMapping("/now")
//	public String now() {
//		return "test";
//	}
	
}
