package com.pr.domain;


import com.pr.entity.enums.Roles;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

	private Long id;
	
	private String username;

	private String password;

	private String firstName;

	private String lastName;

	private Roles role;

}