package com.study.springboot;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpDao {
	public List<Emp> list(); //3.Emp 가 아직 없음-> Emp.java 추가
	public int write(Emp emp);
//	dao.xml의 <insert id="write">의 id이름과 같아야함
	public Emp viewOne(int empno);
}
