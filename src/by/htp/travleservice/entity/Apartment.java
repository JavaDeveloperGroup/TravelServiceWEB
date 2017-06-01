package by.htp.travleservice.entity;

public class Apartment {
	
	private Integer apartmentId;
	private Hotel hotel;
	private Room room;
	private Double price;
	private String status;
	private String image;
	
	public Apartment() {
		super();
	}

	public Apartment(Integer apartmentId, Hotel hotel, Room room, Double price, String status, String image) {
		super();
		this.apartmentId = apartmentId;
		this.hotel = hotel;
		this.room = room;
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

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
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
