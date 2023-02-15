package com.study.springboot;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmpMapper {
	@Select("select empno, ename, job, sal from emp_temp")
	List<Emp> list();
	
	@Insert("INSERT INTO emp_temp(empno,ename,job,sal)"
			+ " values (#{empno},#{ename},#{job},#{sal})")
	int insert(Emp emp);
	
	@Delete("delete from emp_temp where empno=#{empno}")
	int delete(int empno);
}
