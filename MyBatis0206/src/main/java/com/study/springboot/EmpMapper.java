package com.study.springboot;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmpMapper {
	
	@Select("select * from emp_temp")
	List<Emp> findAll();
	
	@Update("update emp_temp "
			+ "set ename=#{ename}, job=#{job}, "
			+ "sal=#{sal}, empno=#{newEmpno} "
			+ "where empno=#{empno}")
    int update(Emp emp);
	
    @Select("select * from emp_temp where empno = #{empno}")
    Emp selectOne(int empno); //select한건 하는 이유=>update에 자료 넘기려고

}
