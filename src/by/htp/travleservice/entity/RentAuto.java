package by.htp.travleservice.entity;

public class RentAuto {
	
	private Integer rentAutoId;
	private String status;
	private String price;
	public RentAuto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RentAuto(String status, String price) {
		super();
		this.status = status;
		this.price = price;
	}
	public RentAuto(Integer rentAutoId, String status, String price) {
		super();
		this.rentAutoId = rentAutoId;
		this.status = status;
		this.price = price;
	}
}
