package by.htp.travelserviceWEB.entity;

import java.io.Serializable;

public class Role implements Serializable {
	
	private Integer apartmentId;
	private String name;
	
	public Role() {
		super();
	}

	public Role(String name) {
		super();
		this.name = name;
	}

	public Role(Integer apartmentId, String name) {
		super();
		this.apartmentId = apartmentId;
		this.name = name;
	}

	public Integer getApartmentId() {
		return apartmentId;
	}

	public void setApartmentId(Integer apartmentId) {
		this.apartmentId = apartmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
