package by.htp.travleservice.entity;

public class Hotel {
	
	private Integer hotelId;
	private String title;
	private String stars;
	private String address;
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hotel(String title, String stars, String address) {
		super();
		this.title = title;
		this.stars = stars;
		this.address = address;
	}
	public Hotel(Integer hotelId, String title, String stars, String address) {
		super();
		this.hotelId = hotelId;
		this.title = title;
		this.stars = stars;
		this.address = address;
	}
}
