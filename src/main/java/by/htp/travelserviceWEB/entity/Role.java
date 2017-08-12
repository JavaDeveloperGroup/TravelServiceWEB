package by.htp.travelserviceWEB.entity;

import java.io.Serializable;

public class Role implements Entity, Serializable {
	
	private static final long serialVersionUID = -8433033484775232825L;
	
	private Integer roleId;
	private String name;
	
	public Role() {}
	
	public Role(Integer roleId, String name) {
		this.roleId = roleId;
		this.name = name;
	}

	public Integer getId() {
		return roleId;
	}

	public void setId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
