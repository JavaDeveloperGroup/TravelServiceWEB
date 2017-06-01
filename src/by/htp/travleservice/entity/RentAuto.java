package by.htp.travleservice.entity;

public class RentAuto {
	
	private Integer rentAutoId;
	private Auto auto;
	private Salon salon;
	private String status;
	private Double price;
	
	public RentAuto() {
		super();
	}

	public RentAuto(Integer rentAutoId, Auto auto, Salon salon, String status, Double price) {
		super();
		this.rentAutoId = rentAutoId;
		this.auto = auto;
		this.salon = salon;
		this.status = status;
		this.price = price;
	}

	public Integer getRentAutoId() {
		return rentAutoId;
	}

	public void setRentAutoId(Integer rentAutoId) {
		this.rentAutoId = rentAutoId;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
