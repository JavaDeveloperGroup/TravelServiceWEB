package by.htp.travelserviceWEB.entity.hotel;

import java.io.Serializable;

import by.htp.travelserviceWEB.entity.Entity;

public class Hotel implements Entity, Serializable {
    
	private static final long serialVersionUID = 5090134385701563726L;
	
	private Integer hotelId;
	private Integer cityId;
	private String title;
	private String stars;
	private String address;
	
	public Hotel() {}

	public Hotel(Integer hotelId, Integer cityId, String title, String stars, String address) {
		this.hotelId = hotelId;
		this.cityId = cityId;
		this.title = title;
		this.stars = stars;
		this.address = address;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return " " + title + " " + stars + " stars " + address + " ";
	}
	
	
}
