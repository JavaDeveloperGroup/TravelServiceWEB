package by.htp.travelserviceWEB.entity;

import java.io.Serializable;

public class TotalOrder implements Entity, Serializable {

	private static final long serialVersionUID = -3473581271208949383L;
	
	private Integer orderId;
	private Integer customerId;
	private Integer tourOrderId;
	private Integer hotelOrderId;
	private Integer autoOrderId;
	private Double totalPrice;
	
	public TotalOrder() {}
	
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getTourOrderId() {
		return tourOrderId;
	}

	public void setTourOrderId(Integer tourOrderId) {
		this.tourOrderId = tourOrderId;
	}

	public Integer getHotelOrderId() {
		return hotelOrderId;
	}

	public void setHotelOrderId(Integer hotelOrderId) {
		this.hotelOrderId = hotelOrderId;
	}

	public Integer getAutoOrderId() {
		return autoOrderId;
	}

	public void setAutoOrderId(Integer autoOrderId) {
		this.autoOrderId = autoOrderId;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}	
}
