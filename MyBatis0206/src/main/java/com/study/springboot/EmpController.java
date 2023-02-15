package com.study.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpController {
	@Autowired
	EmpMapper empMapper;
	
	@GetMapping("/list") //controller역할-요청이들어오면 list.html로 이동
	public String list(Model model) {
		List<Emp> lst = empMapper.findAll();
		for (Emp emp : lst) {
			System.out.println(emp);
		}
		model.addAttribute("list", lst); //"list"가 아래 list로 자료가 들어감(?)
		return "list"; //(=list.html)
	}
	
	@GetMapping("/update") //<a>tag=Get(post x)
	public String update(int empno, Model model) {
		Emp emp = empMapper.selectOne(empno);
		model.addAttribute("emp", emp);
		return "update"; //emp가 update로 들어가야함
	}
	
	@PostMapping("/update")
	public String update(Emp emp) {
		empMapper.update(emp);
		return "redirect:/list";
	}
	
}




