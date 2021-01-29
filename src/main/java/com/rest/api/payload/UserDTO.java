package com.rest.api.payload;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {

	@JsonInclude(Include.NON_NULL)
	private long id;
	
	@NotEmpty
	private String username;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // don't send on response
	private String password;
	
	private String email;
	
	UserDTO() {	
	}
	
	public UserDTO(long id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
