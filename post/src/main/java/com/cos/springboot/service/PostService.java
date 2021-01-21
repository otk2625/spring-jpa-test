package com.cos.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cos.springboot.domain.post.Post;
import com.cos.springboot.domain.post.PostRepository;

// @Controller, @RestController, @Service, @Configure, @Component

@Service // 서버 실행시에 IoC에 등록
public class PostService {

	private PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
		System.out.println("PostService : 실행됨");
	}

	public List<Post> 글목록(){
		return postRepository.findAll();
	}
	
	public Post 글저장(Post post) {
		return postRepository.save(post);
	}
	
	public Post 글상세(int id) {
		return postRepository.findById(id).get(); //그냥 가져요기
		//return postRepository.findById(id).orElse(new Post()); //없으묜 new해서 가져오기
	}
}
