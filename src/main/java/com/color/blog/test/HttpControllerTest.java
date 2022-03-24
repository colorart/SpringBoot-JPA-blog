package com.color.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {
	
	private static final String TAG = "httpContorllerTest: ";
	
	@GetMapping("http/loombok")
	public String loombokTest() {
		//Member m = new Member(1, "color", "234", "color@nate.com");
		Member m = Member.builder().username("color").password("1234").email("color@nat.eocm").build();
		
		System.out.println(TAG + "getter: " + m.getId());
		m.setId(234300);
		m.setId(567000);
		System.out.println(TAG + "getter: " + m.getId());
		return "loombok test 완료";
	}
	
	@GetMapping("http/get")
	public String getTest(Member m) {
		return "get 요청: "+m.getId()+",  "+m.getUsername() + ", " + m.getPassword()+", "+m.getEmail();
	}
	
	@PostMapping("http/post")
	public String postTest(@RequestBody Member m) {
		return "post 요청: "+m.getId()+",  "+m.getUsername() + ", " + m.getPassword()+", "+m.getEmail();
	}

	@PutMapping("http/put")
	public String putTest() {
		return "put 요청";
	}
	
	@DeleteMapping("http/delete")
	public String deleteTest() {
		return "delete 요청";
	}

}
