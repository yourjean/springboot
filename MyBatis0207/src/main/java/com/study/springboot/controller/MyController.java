package com.study.springboot.controller;



import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.study.springboot.dao.EmpMapper;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class MyController {
	
	//@Autowired
	EmpMapper empMapper;
	
	
	@GetMapping("/")
	public String root(HttpServletRequest req) {
		log.info("----------------test");
		ServletContext sc= req.getServletContext();
		log.info("=====>"+sc.getAttribute("appName"));
		return "index";
	}
	
	@GetMapping("/hello")
	public String hello(Model model) { //자료를 보내주려면 model 사용
		List<String> list=Arrays.asList("AAA","BBB","CCC","DDD");
		model.addAttribute("msg", "안녕");
		model.addAttribute("list", list);
		return "hello";
	}
}
//templates:view.단독으로 못보여줌.단독요청 안됨, jsp에서의 view역할 보여주는것. 불러줘야 나옴
//static:단독요청 가능. 안불러줘도 나옴
