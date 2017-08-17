package by.htp.travelserviceWEB.entity.auto;

import java.io.Serializable;

import by.htp.travelserviceWEB.entity.Entity;

public class RentAuto implements Entity, Serializable {
	
	private static final long serialVersionUID = 8541399466349920329L;
	
	private Integer rentAutoId;
	private Integer autoId;
	private Integer salonStartId;
	private String status;
	private Double price;
	
	public RentAuto() {}
	
	public RentAuto(Integer rentAutoId, Integer autoId, Integer salonStartId, String status, Double price) {
		super();
		this.rentAutoId = rentAutoId;
		this.autoId = autoId;
		this.salonStartId = salonStartId;
		this.status = status;
		this.price = price;
	}

	public Integer getRentAutoId() {
		return rentAutoId;
	}

	public void setRentAutoId(Integer rentAutoId) {
		this.rentAutoId = rentAutoId;
	}

	public Integer getAutoId() {
		return autoId;
	}

	public void setAutoId(Integer autoId) {
		this.autoId = autoId;
	}

	public Integer getSalonStartId() {
		return salonStartId;
	}

	public void setSalonStartId(Integer salonStartId) {
		this.salonStartId = salonStartId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
