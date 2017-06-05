package by.htp.travelserviceWEB.entity;

import java.io.Serializable;
import java.sql.Date;

public class HotelOrder implements Serializable {
	
	private Integer hotelOrderId;
	private Apartment apartment;
	private Date dateStart;
	private Date dateEnd;
	private Double orderPrice;
	
	public HotelOrder() {
		super();
	}

	
	public HotelOrder(Apartment apartment, Date dateStart, Date dateEnd, Double orderPrice) {
		super();
		this.apartment = apartment;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.orderPrice = orderPrice;
	}


	public HotelOrder(Integer hotelOrderId, Apartment apartment, Date dateStart, Date dateEnd, Double orderPrice) {
		super();
		this.hotelOrderId = hotelOrderId;
		this.apartment = apartment;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.orderPrice = orderPrice;
	}

	public Integer getHotelOrderId() {
		return hotelOrderId;
	}

	public void setHotelOrderId(Integer hotelOrderId) {
		this.hotelOrderId = hotelOrderId;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
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

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}
	
	
}
