package by.htp.travelserviceWEB.entity;

import java.io.Serializable;

public class City implements Entity, Serializable {

	private static final long serialVersionUID = -14970254887978505L;
	
	private Integer cityId;
	private String name;
	
	public City() {}

	public City(Integer cityId, String name) {
		this.cityId = cityId;
		this.name = name;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
