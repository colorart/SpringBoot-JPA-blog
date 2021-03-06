package com.color.blog.test;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.color.blog.model.RoleType;
import com.color.blog.model.User;
import com.color.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	
	@Autowired	// 의존성 주입
	private UserRepository userRepository;
	
	@GetMapping("dummy/users")
	public List<User> list() {
		return userRepository.findAll();
	}
	
	@GetMapping("/dummy/user")
	public Page<User> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<User> users =  userRepository.findAll(pageable);
		return users;
	}
	
	// {id} 주소로 파라미터를 전달 받을 수 있음
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		
				
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당 유저는 없습니다. id : " + id);
			}
		});
		
		// 요청 : 웹브라우저
		// user 객체 = 자바 오브젝트
		// 변화 ( 웹브라우저가 이해할 수 있는 데이터) -> json (Gson 라이브러리)
		// 스프링부트 = MessageConverter 가 응답시에 자동 작동
		// 만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서
		// user 오브제트를 json으로 변환해서 브라우저에게 던져준다.
		return user;
	}
	
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("username: "+user.getUsername());
		System.out.println("password: "+user.getPassword());
		System.out.println("email: "+user.getEmail());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다";
	}
}
