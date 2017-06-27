package by.htp.travelserviceWEB.entity.auto;

import java.io.Serializable;

public class Salon implements Serializable {

	private Integer salonId;
	private String city;
	private String address;
	
	public Salon() {}

	public Salon(Integer salonId, String city, String address) {
		this.salonId = salonId;
		this.city = city;
		this.address = address;
	}

	public Integer getSalonId() {
		return salonId;
	}

	public void setSalonId(Integer salonId) {
		this.salonId = salonId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
