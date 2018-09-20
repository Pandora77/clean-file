package com.pr.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pr.domain.UserDTO;
import com.pr.entity.UserEntity;
import com.pr.exeptions.UserServiceException;
import com.pr.repository.UserRepository;
import com.pr.service.UserService;
import com.pr.service.utils.ObjectMapperUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ObjectMapperUtils objectMapper;
	
	@Autowired
	private JWTTokenProvider jwtTokenProvider;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void save(UserDTO dto) {

		if (userRepository.existsByUsername(dto.getUsername())) {
			throw new UserServiceException(RECORD_ALREADY_EXISTS);
		} else {
			dto.setRole(UserRole.ROLE_USER);
			System.out.println("Password:" + dto.getPassword());
			dto.setPassword(passwordEncoder.encode(dto.getPassword()));
			System.out.println("Password2:" + dto.getPassword());
			
			UserEntity userEntity = objectMapper.map(dto, UserEntity.class);
			userRepository.save(userEntity);
		}
	}

	@Override
	public String signin(String username, String password) {
		System.out.println(">>> " + username);
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		System.out.println(">>> " + username);
		return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRole());
	}
	
	@Override
	public UserDTO findById(Long id) {
		return null;
	}

	@Override
	public List<UserDTO> findAll() {
		return null;
	}

	@Override
	public boolean existsByUsername(String username) {
		return false;
	}

	@Override
	public UserDTO findByUsername(String username) {
		return null;
	}

	@Override
	public Boolean existsByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

}
