package com.pr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
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
@Table(indexes = @Index(columnList = "clientgId"))
	
	public class ClientEntity extends BaseEntity {
	
	@Column(nullable = false, unique = true)
	private String clientId;
	
	@Column(length = 100, nullable = false)
	private String firstName;
	
	@Column(length = 100, nullable = false)
	private String lastName;
	
	@Column(length = 13, nullable = false)
	private String phoneNumber;

	private String email;
	
	@Enumerated(EnumType.ORDINAL)
	private Roles role;

}
