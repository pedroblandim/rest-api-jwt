package com.rest.api.utils;

import com.rest.api.model.User;
import com.rest.api.payload.UserDTO;

public class UserUtils {

	public static UserDTO toDTO(User user) {
		return new UserDTO(
				user.getId(), user.getUsername(),
				user.getPassword(), user.getEmail());
	}
	
	public static User fromDTO(UserDTO userDTO) {
		return new User(
				userDTO.getId(), userDTO.getUsername(), 
				userDTO.getPassword(), userDTO.getEmail(), null);
	}
	
}
