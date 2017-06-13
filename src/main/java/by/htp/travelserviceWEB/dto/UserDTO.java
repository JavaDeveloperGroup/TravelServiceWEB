package by.htp.travelserviceWEB.dto;

import java.io.Serializable;
import java.sql.Date;

import by.htp.travelserviceWEB.entity.Role;

public class UserDTO implements Serializable {

	private String login;
	private String password;
	
	public UserDTO() {
		super();
	}

	public UserDTO(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
