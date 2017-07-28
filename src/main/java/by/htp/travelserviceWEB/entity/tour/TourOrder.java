package by.htp.travelserviceWEB.entity.tour;

import java.io.Serializable;

import by.htp.travelserviceWEB.entity.Entity;

public class TourOrder implements Entity, Serializable {
	
	private static final long serialVersionUID = -5081473045420067064L;
	
	private Integer tourOrderId;
	private Integer tourOfferId;
	private Integer personNumber;
	private Double orderPrice;
	
	public TourOrder() {}

	public TourOrder(Integer tourOrderId, Integer tourOfferId, Integer personNumber, Double orderPrice) {
		super();
		this.tourOrderId = tourOrderId;
		this.tourOfferId = tourOfferId;
		this.personNumber = personNumber;
		this.orderPrice = orderPrice;
	}

	public Integer getTourOrderId() {
		return tourOrderId;
	}

	public void setTourOrderId(Integer tourOrderId) {
		this.tourOrderId = tourOrderId;
	}

	public Integer getTourOfferId() {
		return tourOfferId;
	}

	public void setTourOfferId(Integer tourOfferId) {
		this.tourOfferId = tourOfferId;
	}

	public Integer getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(Integer personNumber) {
		this.personNumber = personNumber;
	}

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}
}
