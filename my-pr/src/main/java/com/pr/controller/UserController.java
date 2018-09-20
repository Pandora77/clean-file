package com.pr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pr.domain.UserDTO;
import com.pr.domain.request.SigninRequest;
import com.pr.domain.response.SigninResponse;
import com.pr.entity.UserEntity;
import com.pr.service.UserService;


@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userEntityService;
	
	@GetMapping("check-login")
	public ResponseEntity<Boolean> checkUserLogin(@RequestParam("login") String login){
		return new ResponseEntity<Boolean>(userEntityService.existsByLogin(login), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> addUser(@RequestBody UserEntity dto){
		userEntityService.save(dto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PostMapping("signin")
	public ResponseEntity<SigninResponse> signin(@RequestBody SigninRequest request){
		String token = userEntityService.signin(request.getUsername(), request.getPassword());
		String role = "";
		System.out.println(token + "/n" + request.getUsername() + "\n" + request.getPassword());
		
		if(token != null) {
			role = userEntityService.findByUsername(request.getUsername()).getRole().toString();
			System.out.println("Role:" + role);
		}
		
		return new ResponseEntity<SigninResponse>(new SigninResponse(token, role), HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getUsers(){
		return new ResponseEntity<List<UserDTO>>(userEntityService.findAll(), HttpStatus.OK);		
	}
	
}
