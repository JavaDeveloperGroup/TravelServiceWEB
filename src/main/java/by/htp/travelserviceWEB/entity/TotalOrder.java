package by.htp.travelserviceWEB.entity;

import java.io.Serializable;

public class TotalOrder implements Serializable {
	
	private Integer orderId;
	private CustomerImpl customer;
	private TourOrder tourOrder;
	private HotelOrder hotelOrder;
	private AutoOrder autoOrder;
	private Double totalPrice;
	
	public TotalOrder() {
		super();
	}

	public TotalOrder(CustomerImpl customer, TourOrder tourOrder, HotelOrder hotelOrder, AutoOrder autoOrder,
			Double totalPrice) {
		super();
		this.customer = customer;
		this.tourOrder = tourOrder;
		this.hotelOrder = hotelOrder;
		this.autoOrder = autoOrder;
		this.totalPrice = totalPrice;
	}

	public TotalOrder(Integer orderId, CustomerImpl customer, TourOrder tourOrder, HotelOrder hotelOrder,
			AutoOrder autoOrder, Double totalPrice) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.tourOrder = tourOrder;
		this.hotelOrder = hotelOrder;
		this.autoOrder = autoOrder;
		this.totalPrice = totalPrice;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public CustomerImpl getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerImpl customer) {
		this.customer = customer;
	}

	public TourOrder getTourOrder() {
		return tourOrder;
	}

	public void setTourOrder(TourOrder tourOrder) {
		this.tourOrder = tourOrder;
	}

	public HotelOrder getHotelOrder() {
		return hotelOrder;
	}

	public void setHotelOrder(HotelOrder hotelOrder) {
		this.hotelOrder = hotelOrder;
	}

	public AutoOrder getAutoOrder() {
		return autoOrder;
	}

	public void setAutoOrder(AutoOrder autoOrder) {
		this.autoOrder = autoOrder;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
