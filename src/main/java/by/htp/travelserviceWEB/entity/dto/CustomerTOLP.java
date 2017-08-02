package by.htp.travelserviceWEB.entity.dto;

import java.io.Serializable;

import by.htp.travelserviceWEB.entity.Entity;

public class CustomerTOLP implements Entity, Serializable {

	private static final long serialVersionUID = 8767626149082718938L;
	
	private String login;
	private transient String password;
	
	public CustomerTOLP() {}
	
	public CustomerTOLP(String login, String password) {
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

	@Override
	public String toString() {
		return "CustomerTOLP [login=" + login + ", password=" + password + "]";
	}
	
	
}
