package com.cos.springboot.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cos.springboot.domain.post.Post;
import com.cos.springboot.service.PostService;

// http요청시 @Controller, @RestController가 붙은 클래스가 메모리(IoC Container)에 로딩

@Controller //viewResolver
public class PostController {
	
	// DI (Dependency Injection) 
	PostService postService;
	
	public PostController(PostService postService) {
		System.out.println("PostController 실행됨");
		this.postService = postService;
	}
	
	// Model 객체 제공!! Model model
	// model.addAttribute("posts", post)로도 받을 수 있다
	@GetMapping("/post") //produce =>응답을 뭐로할지 데이터 타입을 결정 이거는 RestController일때만 가능
	//name은 주소 : 생략 가능 (default)
	public String findAll(HttpServletRequest request) { //컨트롤러의 함수의 파라메터는 톰켓이 가지고 있는 객체 + Ioc컨테이너가 가지고있는 객체
		//HttpServletRequest request하면 request에 접근 또는 HttpSession seesion에도 접근!
		// ex:request.setAttribute("posts", post); 이런식으로!!
		
		// 원래 라면
		// 1.DB에 데이터 가져오기
		// 2.request 값 담기
		// 3.RequestDispatcher사용 스프링부트는 알아서 처리해줌
		
		List<Post> posts = postService.글목록();
		System.out.println(posts);
		
		return "post/list"; //여기서 Dispatcher로 처리 
	}
	
	@GetMapping("/post/{id}")
	public String findById(@PathVariable int id) {
		
		Post post = postService.글상세(id);
		System.out.println("찾고있는 post : " + post);
		return "post/detail";
	}
	
	@PostMapping("/post")
	public String save(/*@RequestBody*/ Post post) { // x-www-form-urlencoded  @RequestBody는 json으로 파싱함
		System.out.println("Post : " + post);
		postService.글저장(post);
		return "redirect:/post"; //response.sendRedirect 발동
	}
	
	
	
	
}