package by.htp.travelserviceWEB.entity.dto;

import java.io.Serializable;
import java.sql.Date;

public class UserTO implements Serializable {

	private String login;
	private String password;
	
	public UserTO() {
		super();
	}

	public UserTO(String login, String password) {
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
