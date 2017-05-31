package by.htp.travleservice.entity;

public class Salon {

	private Integer salonId;
	private String city;
	private String address;
	public Salon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Salon(String city, String address) {
		super();
		this.city = city;
		this.address = address;
	}
	public Salon(Integer salonId, String city, String address) {
		super();
		this.salonId = salonId;
		this.city = city;
		this.address = address;
	}
}
