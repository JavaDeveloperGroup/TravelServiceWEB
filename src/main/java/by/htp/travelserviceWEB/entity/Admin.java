package by.htp.travelserviceWEB.entity;

import java.io.Serializable;

public class Admin implements Serializable {
	
	private Integer adminId;
	private String login;
	private String password;
	private Role role;
	
	public Admin() {
		super();
	}

	public Admin(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public Admin(String login, String password, Role role) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public Admin(Integer adminId, String login, String password, Role role) {
		super();
		this.adminId = adminId;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
