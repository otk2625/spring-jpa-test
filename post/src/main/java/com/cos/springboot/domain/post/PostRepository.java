package com.cos.springboot.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository가먼저 메모리에 뜨고 service - controller순으로 뜸
// @Repository 생략가능!!
public interface PostRepository extends JpaRepository<Post, Integer> { //DAO만들 클래스와 primary key!!
	
}
