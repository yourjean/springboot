package com.study.springboot;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.jdbc.Board;
import com.study.springboot.jdbc.BoardMapper;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class MyBatis0213ApplicationTests {

	/*
	BoardMapper boardMapper=new BoardMapper(){
		//의존성 주입 미사용시 };
	 */
	
	/* 의존성 주입-매번 객체셍성하던것을 프레임워크가 해줌 */
	@Autowired
	BoardMapper boardMapper;
	
	@Test
	void contextLoads() {
		log.info("----------테스트 시작");
	}
	
	@Test
	@DisplayName("findAll test")
	void testFindAll() {
		List<Board> list=boardMapper.findAll();
		log.info(list);
	}
}
