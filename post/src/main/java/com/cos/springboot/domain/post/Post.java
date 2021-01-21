package com.cos.springboot.domain.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //mysql에서의 autoIncresment같은 번호증가 전략을 따라가는것
	private int id;
	private String title;
	private String content;
	private int readCount; //방언을 설정해줘야함 Dialect
}
