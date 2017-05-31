package by.htp.travleservice.entity;

public class Bus {
	
	private Integer busId;
	private String name;
	private Integer capacity;
	private String registrationNumber;
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bus(String name, Integer capacity, String registrationNumber) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.registrationNumber = registrationNumber;
	}
	public Bus(Integer busId, String name, Integer capacity, String registrationNumber) {
		super();
		this.busId = busId;
		this.name = name;
		this.capacity = capacity;
		this.registrationNumber = registrationNumber;
	}
}
