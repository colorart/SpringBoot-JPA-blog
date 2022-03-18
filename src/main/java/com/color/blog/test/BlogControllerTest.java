package com.color.blog.test;

import javax.swing.Spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogControllerTest {

		@GetMapping("test/hello")
		public String Hello() {
			return "<h1>hellow spring boot  color</h1>";
		}
}
