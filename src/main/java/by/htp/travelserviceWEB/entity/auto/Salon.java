package by.htp.travelserviceWEB.entity.auto;

import java.io.Serializable;

import by.htp.travelserviceWEB.entity.Entity;

public class Salon implements Entity, Serializable {

	private static final long serialVersionUID = 5541491372792262379L;
	
	private Integer salonId;
	private Integer cityId;
	private String address;
	
	public Salon() {}

	public Salon(Integer salonId, Integer cityId, String address) {
		this.salonId = salonId;
		this.cityId = cityId;
		this.address = address;
	}

	public Integer getSalonId() {
		return salonId;
	}

	public void setSalonId(Integer salonId) {
		this.salonId = salonId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
