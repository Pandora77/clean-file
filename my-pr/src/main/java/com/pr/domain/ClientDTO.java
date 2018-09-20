package com.pr.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientDTO {
	
	@JsonIgnore
	private Long id;
	
	private String clientId;
	
	private String firstName;
	
	private String lastName;

	private String phoneNumber;
	
	private String email;

}
