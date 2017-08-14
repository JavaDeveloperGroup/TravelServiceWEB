package by.htp.travelserviceWEB.entity.hotel;

import java.io.Serializable;

import by.htp.travelserviceWEB.entity.Entity;

public class Apartment implements Entity, Serializable{
	
	private static final long serialVersionUID = -9172516631779393125L;
	
	private Integer apartmentId;
	private Integer hotelId;
	private Integer roomId;
	private Integer roomCapacity;
	private Double price;
	private String status;
	private String image;
	
	public Apartment() {}

	public Apartment(Integer apartmentId, Integer id_hotel, Integer id_room, Integer roomCapacity, Double price, String status, String image) {
		this.apartmentId = apartmentId;
		this.hotelId = id_hotel;
		this.roomId = id_room;
		this.roomCapacity = roomCapacity;
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

	public void setHotelId(Integer id_hotel) {
		this.hotelId = id_hotel;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer id_room) {
		this.roomId = id_room;
	}

	public Integer getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(Integer roomCapacity) {
		this.roomCapacity = roomCapacity;
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
