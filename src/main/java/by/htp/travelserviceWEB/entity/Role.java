package by.htp.travelserviceWEB.entity;

import java.io.Serializable;

public class Role implements Serializable {
	
	private Integer roletId;
	private String name;
	
	public Role() {
		super();
	}

	public Role(String name) {
		super();
		this.name = name;
	}

	public Role(Integer roleId, String name) {
		super();
		this.roletId = roletId;
		this.name = name;
	}

	public Integer getApartmentId() {
		return roletId;
	}

	public void setApartmentId(Integer roleId) {
		this.roletId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
