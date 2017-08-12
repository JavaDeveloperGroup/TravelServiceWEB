package by.htp.travelserviceWEB.entity.tour;

import java.io.Serializable;
import java.sql.Date;

import by.htp.travelserviceWEB.entity.Entity;

public class TourOffer implements Entity, Serializable {

	private static final long serialVersionUID = 940704752182144652L;
	
	private Integer offerId;
	private Integer tourId;
	private Integer busId;
	private Date dateStart;
	private Date dateEnd;
	private Integer pessengersPerOrder;
	private Double price;
	private String hot;
	
	public TourOffer() {}

	public TourOffer(Integer offerId, Integer tourId, Integer busId, Date dateStart, Date dateEnd,
			Integer pessengersPerOrder, Double price, String hot) {
		super();
		this.offerId = offerId;
		this.tourId = tourId;
		this.busId = busId;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.pessengersPerOrder = pessengersPerOrder;
		this.price = price;
		this.hot = hot;
	}
	
	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	public Integer getTourId() {
		return tourId;
	}

	public void setTourId(Integer tourId) {
		this.tourId = tourId;
	}

	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Integer getPessengersPerOrder() {
		return pessengersPerOrder;
	}

	public void setPessengersPerOrder(Integer pessengersPerOrder) {
		this.pessengersPerOrder = pessengersPerOrder;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getHot() {
		return hot;
	}

	public void setHot(String hot) {
		this.hot = hot;
	}
}
