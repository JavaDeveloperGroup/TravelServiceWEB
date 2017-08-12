package by.htp.travelserviceWEB.entity;

import java.io.Serializable;

public class Admin implements Entity, Serializable {
	
	private static final long serialVersionUID = -6191394259691941922L;
	
	private Integer adminId;
	private String login;
	private transient String password;
	private Integer roleId;
	
	public Admin() {}

	public Admin(Integer adminId, String login, String password, Integer roleId) {
		this.adminId = adminId;
		this.login = login;
		this.password = password;
		this.roleId = roleId;
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

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
