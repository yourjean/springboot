package com.study.springboot; //test실행->run as->Junit->초록불나오면 성공->콘솔창확인
import static org.assertj.core.api.Assertions.assertThat;

//test 해보는 파일
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class MyBatis0208ApplicationTests {
	
//	우리가 생성을 안하고 프레임워크가 생성하게끔 하는게 Autowired의 역할
	EmpDao empDao;
	
	@Autowired
	public MyBatis0208ApplicationTests(EmpDao empDao) {
		this.empDao = empDao;
	}
	
	@Test
	void contextLoads() {
	}
	
	@Test
	@DisplayName("emp_temp 리스트 테스트") //JUnit에서 이름이 내가 설정한 이름으로 뜸
	public void testList() {
		List<Emp> list=empDao.list();
		log.info(list);
	 }
	
	@Test //계속 테스트되어 입력이 계속됨-주석처리 / @Disabled
	@Disabled
	@DisplayName("emp_temp 쓰기 테스트")
	public void testWrite() {
//		Emp emp=new Emp();
//		emp.setEmpno(1234);
//		emp.setEname("김기사");
//		emp.setJob("사원");
//		emp.setSal(3500);
		Emp emp=Emp.builder().empno(5454).ename("홍길준").job("부장")
				.sal(8000).build(); //객체생성=위의 주석처리한 5줄과 같음
		log.info(emp);
		int res=empDao.write(emp); //DB갓다옴=>성공했으면 1
		assertThat(res).isEqualTo(1);
	}
	
	@Test
	@DisplayName("emp_temp 보기 테스트")
	public void testViewOne() { //아무 이름
		Emp emp= empDao.viewOne(5454); //있는번호로 확인
		log.info(emp);
		assertThat(emp.getEmpno()).isEqualTo(5454); //true라면 JUnit에서 초록불 
	}
	
	@Test
	@DisplayName("emp_temp 수정 테스트")
	public void testUpdate() {
		Emp emp=Emp.builder().empno(2234).ename("홍길철").job("사장딸").sal(1000).build();
		log.info(emp);
		int res=empDao.update(emp);
		Assertions.assertEquals(res,1);
	}
}
