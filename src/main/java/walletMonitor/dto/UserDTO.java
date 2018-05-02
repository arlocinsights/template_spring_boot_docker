package walletMonitor.dto;

import walletMonitor.models.User;

public class UserDTO {

	private long id;

	private String email;

	private String name;
	
	public UserDTO() {
		
	}
	
	public UserDTO(User u){
		this.id = u.getId();
		this.email = u.getEmail();
		this.name = u.getName();
		this.password = u.getPassword();
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;
}
