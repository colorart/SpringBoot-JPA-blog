package com.color.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.color.blog.model.User;

// DAO
// 자동으로 bean으로 등록된다.
//@Repository		//생략가능
public interface UserRepository extends JpaRepository<User, Integer>{

}
