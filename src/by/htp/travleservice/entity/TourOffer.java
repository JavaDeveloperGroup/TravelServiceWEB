package by.htp.travleservice.entity;

import java.sql.Date;

public class TourOffer {
	
	private Integer offerId;
	private Tour tour;
	private Bus bus;
	private Date dateStart;
	private Date dateEnd;
	private Integer capacity;
	private Double price;
	private String hot;
	
	public TourOffer() {
		super();
	}

	public TourOffer(Integer offerId, Tour tour, Bus bus, Date dateStart, Date dateEnd, Integer capacity, Double price,
			String hot) {
		super();
		this.offerId = offerId;
		this.tour = tour;
		this.bus = bus;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.capacity = capacity;
		this.price = price;
		this.hot = hot;
	}

	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
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

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
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
