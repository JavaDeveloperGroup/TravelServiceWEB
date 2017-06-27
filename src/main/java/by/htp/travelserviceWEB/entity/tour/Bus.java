package by.htp.travelserviceWEB.entity.tour;

import java.io.Serializable;

public class Bus implements Serializable {
	
	private Integer busId;
	private String name;
	private Integer capacity;
	private String registrationNumber;
	
	public Bus() {}

	public Bus(Integer busId, String name, Integer capacity, String registrationNumber) {
		this.busId = busId;
		this.name = name;
		this.capacity = capacity;
		this.registrationNumber = registrationNumber;
	}

	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
}
