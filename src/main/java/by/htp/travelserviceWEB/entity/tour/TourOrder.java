package by.htp.travelserviceWEB.entity.tour;

import java.io.Serializable;

public class TourOrder implements Serializable {

	private Integer tourOrderId;
	private TourOffer tourOffer;
	private Integer personNumber;
	private Double orderPrice;
	
	public TourOrder() {}

	public TourOrder(Integer tourOrderId, TourOffer tourOffer, Integer personNumber, Double orderPrice) {
		this.tourOrderId = tourOrderId;
		this.tourOffer = tourOffer;
		this.personNumber = personNumber;
		this.orderPrice = orderPrice;
	}

	public Integer getTourOrderId() {
		return tourOrderId;
	}

	public void setTourOrderId(Integer tourOrderId) {
		this.tourOrderId = tourOrderId;
	}

	public TourOffer getTourOffer() {
		return tourOffer;
	}

	public void setTourOffer(TourOffer tourOffer) {
		this.tourOffer = tourOffer;
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
