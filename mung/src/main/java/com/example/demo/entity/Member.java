package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@SequenceGenerator(
			name = "MEMBER_SEQ_GEN",
			sequenceName = "member_seq",
			initialValue = 1,
			allocationSize = 1
		)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "member")
public class Member extends BaseEntity{
		
	private Long member_id;
	
	private String login_id;
	
	private String member_pw;
	
	private String member_name;
	
	private String member_email;
	
	private char email_verified;
	
	
	
}
