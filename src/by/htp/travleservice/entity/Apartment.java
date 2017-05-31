package by.htp.travleservice.entity;

public class Apartment {
	
	private Integer apartmentId;
	private Double price;
	private String status;
	private String image;
	
	public Apartment() {
		super();
	}

	public Apartment(Double price, String status, String image) {
		super();
		this.price = price;
		this.status = status;
		this.image = image;
	}

	public Apartment(Integer apartmentId, Double price, String status, String image) {
		super();
		this.apartmentId = apartmentId;
		this.price = price;
		this.status = status;
		this.image = image;
	}

	public Integer getApartmentId() {
		return apartmentId;
	}

	public void setApartmentId(Integer apartmentId) {
		this.apartmentId = apartmentId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
