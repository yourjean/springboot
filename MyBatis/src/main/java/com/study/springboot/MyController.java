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
	private EmpMapper empMapper; //인터페이스에서 만든 empMapper
	
	@GetMapping("/now")
	public String root() {
		return "root";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Emp> elst=empMapper.findAll();
		model.addAttribute("list",elst); //이 2줄은 db에 갓다오게 하는 것
		
		return "list"; //여기서 소문자 list 3개는 각각-요청명,html파일명,그냥 이름. 서로 아무 관련이 없음
	}
	
	@PostMapping("/insert")
	public String insert(Emp emp, Model model) {
		int res=empMapper.save(emp);
		
		return "redirect:/list";
	}
	
	@GetMapping("/delete") //요청명 (list.html)에서 잘보고 적을것
	public String delete(int empno) { //delete할때 empno필요함
		empMapper.delete(empno);
		return "redirect:/list";
	}
	
	@PostMapping("/upload3")
	@ResponseBody
	public void FileUpload3(MultipartHttpServletRequest request) {
		try {
			System.out.println("/upload3");
			String test=request.getParameter("test");
			System.out.println(test);
			MultipartFile file=request.getFile("file");
			
			//File경로 임의 지정
			String uploadPath="C:\\upload/test/abc";
			
			File fileUpload=new File(uploadPath, file.getOriginalFilename());
			
			//생성될 경로가 없을 경우, 파일을 생성
			if(!fileUpload.exists()) {
				System.out.println(uploadPath + " : 파일 경로 생성완료");
				fileUpload.mkdirs();
			}
			file.transferTo(fileUpload);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
