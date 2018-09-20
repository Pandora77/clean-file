package com.pr.service;

import java.util.List;

import com.pr.domain.UserDTO;

public interface UserService {
	
void save(UserDTO dto);
	
	UserDTO findById(Long id);
	
	List<UserDTO> findAll();
	
	boolean existsByUsername(String username);
	
	UserDTO findByUsername(String username);
	
	String signin(String username, String password);

	Boolean existsByLogin(String login);


}
