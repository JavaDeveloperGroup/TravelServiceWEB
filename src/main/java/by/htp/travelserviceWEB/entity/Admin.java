package by.htp.travelserviceWEB.entity;

import java.io.Serializable;

public class Admin implements Serializable {
	
	private Integer adminId;
	private String login;
	private transient String password;
	private Integer idRole;
	
	public Admin() {}
	
	public Admin(Integer adminId, String login, Integer idRole) {
		this.adminId = adminId;
		this.login = login;
		this.idRole = idRole;
	}

	public Admin(Integer adminId, String login, String password, Integer idRole) {
		this.adminId = adminId;
		this.login = login;
		this.password = password;
		this.idRole = idRole;
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

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}
}
