package by.htp.travleservice.entity;

public class TourOrder {

	private Integer tourOrderId;
	private Integer personNumber;
	private Double orderPrice;
	public TourOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TourOrder(Integer personNumber, Double orderPrice) {
		super();
		this.personNumber = personNumber;
		this.orderPrice = orderPrice;
	}
	public TourOrder(Integer tourOrderId, Integer personNumber, Double orderPrice) {
		super();
		this.tourOrderId = tourOrderId;
		this.personNumber = personNumber;
		this.orderPrice = orderPrice;
	}
}
