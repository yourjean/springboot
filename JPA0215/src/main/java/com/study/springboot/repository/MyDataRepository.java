package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.entity.MyData;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long>{
	//<entity(=class name), 데이터 타입>
}
