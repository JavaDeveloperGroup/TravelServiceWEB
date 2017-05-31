package by.htp.travleservice.entity;

public class TotalOrder {
	
	private Integer orderId;
	private Double totalPrice;
	public TotalOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TotalOrder(Double totalPrice) {
		super();
		this.totalPrice = totalPrice;
	}
	public TotalOrder(Integer orderId, Double totalPrice) {
		super();
		this.orderId = orderId;
		this.totalPrice = totalPrice;
	}
}
