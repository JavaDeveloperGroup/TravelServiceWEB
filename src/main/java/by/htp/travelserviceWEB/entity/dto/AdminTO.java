package by.htp.travelserviceWEB.entity.dto;

import java.io.Serializable;

import by.htp.travelserviceWEB.entity.Entity;

public class AdminTO implements EntityTO, Serializable {
	
	private static final long serialVersionUID = -6191394259691941922L;
	
	private Integer adminId;
	private String login;
	private Integer roleId;
	
	public AdminTO() {}
	
	public AdminTO(Integer adminId, String login, Integer roleId) {
		this.adminId = adminId;
		this.login = login;
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

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
