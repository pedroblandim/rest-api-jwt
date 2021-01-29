package com.rest.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.model.User;
import com.rest.api.payload.UserDTO;
import com.rest.api.services.api.UserService;
import com.rest.api.utils.UserUtils;

@RestController
@RequestMapping("/public/users")
public class UserPublicController {

	@Autowired
	private UserService userRepository;
	
//	@Autowired
//	private UserAuthenticationService authentication;
	
//	@Autowired
//	private PasswordEncoder encoder;
//	
	@GetMapping
	public ResponseEntity<List<UserDTO>> list() {
		List<User> users = userRepository.findAll();
		List<UserDTO> usersDTO = users.stream()
				.map(u -> UserUtils.toDTO(u)).collect(Collectors.toList());
		return ResponseEntity.of(Optional.of(usersDTO));
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody UserDTO userDTO) {
		User user = UserUtils.fromDTO(userDTO);
//		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.insert(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

//	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Map<String, String> login(@Valid @RequestBody LoginRequest loginRequest) {
//		Optional<String> auth = Optional.of(authentication
//					.login(loginRequest.getUsername(), loginRequest.getPassword())
//					.orElseThrow(() -> new RuntimeException("Invalid login or password")));
//		
//		return Collections.singletonMap("token", auth.get());
//	}
//	
	
}
