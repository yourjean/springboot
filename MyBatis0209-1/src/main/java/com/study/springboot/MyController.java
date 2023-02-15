package com.study.springboot;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class MyController {
	@Autowired
	private EmpMapper empMapper;
	
	@GetMapping("/now")
	public String root() {
		return "root";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Emp> elst=empMapper.list();
		model.addAttribute("list",elst);
		
		return "list"; 
	}
	
	@PostMapping("/insert")
	public String insert(Emp emp, Model model) {
		int res=empMapper.insert(emp);
		
		return "redirect:/list";
	}
	
	@GetMapping("/delete") 
	public String delete(int empno) {
		empMapper.delete(empno);
		return "redirect:/list";
	}
}
