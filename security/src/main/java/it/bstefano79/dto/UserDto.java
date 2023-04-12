package it.bstefano79.dto;

import java.util.List;

public class UserDto {
	private Long id;
	
	private String username;
	
	private String email;
	
	private String password;
	
	private List<String> role;

	public UserDto(Long id, String username, String email, List<String> role) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.setRole(role);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRole() {
		return role;
	}

	public void setRole(List<String> role) {
		this.role = role;
	}
}
