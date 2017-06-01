package by.htp.travleservice.entity;

public class TotalOrder {
	
	private Integer orderId;
	private User user;
	private TourOrder tourOrder;
	private HotelOrder hotelOrder;
	private AutoOrder autoOrder;
	private Double totalPrice;
	
	public TotalOrder() {
		super();
	}

	public TotalOrder(Integer orderId, User user, TourOrder tourOrder, HotelOrder hotelOrder, AutoOrder autoOrder,
			Double totalPrice) {
		super();
		this.orderId = orderId;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
