package by.htp.travelserviceWEB.entity;

import java.io.Serializable;

public class Admin implements Serializable {
	
	private Integer adminId;
	private String login;
	private transient String password;
	private Integer idRole;
	
	public Admin() {}
	
	public Admin(Integer adminId, String login, Integer role) {
		this.adminId = adminId;
		this.login = login;
		this.idRole = role;
	}

	public Admin(Integer adminId, String login, String password, Integer role) {
		this.adminId = adminId;
		this.login = login;
		this.password = password;
		this.idRole = role;
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

	public Integer getRole() {
		return idRole;
	}

	public void setRole(Integer role) {
		this.idRole = role;
	}
}
