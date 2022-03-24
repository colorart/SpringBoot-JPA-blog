package com.color.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@DynamicInsert	// insert시에 null인 필드를 제외
public class User {
	
	@Id	//Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//프로젝트에서 연결된 DB의 넘버링 전략
	private int id;
	
	@Column(nullable = false, length = 30)
	private String username;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	//@ColumnDefault("user")
	//DB는 RoleType이라는 것이 없음
	@Enumerated(EnumType.STRING)
	private RoleType role;		// Enum을 사용하는게 좋다. 	//ADMIN, USER
		
	@CreationTimestamp	//시간 자동 입력
	private Timestamp createDate;
	
}
