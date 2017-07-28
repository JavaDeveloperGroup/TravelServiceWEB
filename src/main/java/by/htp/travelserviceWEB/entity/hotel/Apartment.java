package by.htp.travelserviceWEB.entity.hotel;

import java.io.Serializable;

import by.htp.travelserviceWEB.entity.Entity;

public class Apartment implements Entity, Serializable{

	private static final long serialVersionUID = -2937863274246918755L;
	
	private Integer apartmentId;
	private Integer hotelId;
	private Integer roomId;
	private Double price;
	private String status;
	private String image;
	
	public Apartment() {}

	public Apartment(Integer apartmentId, Integer hotelId, Integer roomId, Double price, String status, String image) {
		super();
		this.apartmentId = apartmentId;
		this.hotelId = hotelId;
		this.roomId = roomId;
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

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
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
