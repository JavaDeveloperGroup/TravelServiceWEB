package by.htp.travelserviceWEB.entity.hotel;

import java.io.Serializable;
import java.sql.Date;

import by.htp.travelserviceWEB.entity.Entity;

public class HotelOrder implements Entity, Serializable {

	private static final long serialVersionUID = -7482817679472393605L;
	
	private Integer hotelOrderId;
	private Integer apartmentId;
	private Date dateStart;
	private Date dateEnd;
	private Double orderPrice;
	
	public HotelOrder() {}

	public HotelOrder(Integer hotelOrderId, Integer apartmentId, Date dateStart, Date dateEnd, Double orderPrice) {
		super();
		this.hotelOrderId = hotelOrderId;
		this.apartmentId = apartmentId;
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

	public Integer getApartmentId() {
		return apartmentId;
	}

	public void setApartmentId(Integer apartmentId) {
		this.apartmentId = apartmentId;
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
