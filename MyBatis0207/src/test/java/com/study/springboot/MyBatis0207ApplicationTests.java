package com.study.springboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.dao.Emp;
import com.study.springboot.dao.EmpMapper;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class MyBatis0207ApplicationTests {

	// @Autowired //자동. 의존성객체
	EmpMapper empMapper; // 변수선언

	@Autowired //생성자 주입방식
	public MyBatis0207ApplicationTests(EmpMapper empMapper) {// 생성자
		super();
		this.empMapper = empMapper;
	}

//	@Autowired
//	public void setEmpMapper(EmpMapper empMapper) {//Setter만
//		this.empMapper = empMapper;
//	}

	@Test
	void contextLOoads() {
	}

	@Test
	void test() {
		log.info("****로그 테스트****");
		assertThat("aaa").isEqualTo("aaa");
		Emp emp = empMapper.selectOne(8888); // db에있는 사원번호로 확인
		log.info(emp); // =>run as->JUnit으로 실행 참이면 초록색,아니면 빨강
	}
}
