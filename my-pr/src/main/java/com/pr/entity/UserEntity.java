package com.pr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.pr.entity.enums.Roles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
	
	@Column(nullable = false, unique = true)
	private String userId;

	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;

		
	@Enumerated(EnumType.ORDINAL)
	private Roles role;

}
