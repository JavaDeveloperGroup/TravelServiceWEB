package by.htp.travelserviceWEB.entity;

import java.io.Serializable;

public class RentAuto implements Serializable {
	
	private Integer rentAutoId;
	private Auto auto;
	private Salon salonStart;
	private String status;
	private Double price;
	
	public RentAuto() {}

	public RentAuto(Integer rentAutoId, Auto auto, Salon salonStart, String status, Double price) {
		this.rentAutoId = rentAutoId;
		this.auto = auto;
		this.salonStart = salonStart;
		this.status = status;
		this.price = price;
	}

	public Integer getRentAutoId() {
		return rentAutoId;
	}

	public void setRentAutoId(Integer rentAutoId) {
		this.rentAutoId = rentAutoId;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public Salon getSalonStart() {
		return salonStart;
	}

	public void setSalonStart(Salon salonStart) {
		this.salonStart = salonStart;
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
