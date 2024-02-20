package it.bstefano79.dto;

import java.util.List;

import it.bstefano79.entity.User;

public class UserDto {
	private Long id;
	
	private String username;
	
	private String email;
	
	private String password;
	
	private List<String> roles;

	public UserDto(Long id, String username, String email, List<String> roles) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.setRoles(roles);
	}
	
	public UserDto(User user){
		if(user!=null){
			this.id=user.getId();
			this.username=user.getUsername();
			this.email=user.getEmail();
			this.password=user.getPassword();
			this.roles=user.getRoles().stream().map(x->x.getName().name()).toList();
		}
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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}
