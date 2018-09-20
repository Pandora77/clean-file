package com.example.mypr;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pr.entity.UserEntity;
import com.pr.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.pr.repository")
public class MyPrApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MyPrApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		if(userRepository.count() == 0) {
			UserEntity user = new UserEntity();
			user.setUsername("admin");
			user.setFirstName("Admin");
			user.setLastName("Admin");
			user.setRole(Roles.ROLE_GLOBAL_ADMIN);
			user.setPassword(passwordEncoder.encode("admin"));
			
			userRepository.save(user);
		}
		
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
