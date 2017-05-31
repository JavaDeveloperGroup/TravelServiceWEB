package by.htp.travleservice.entity;

public class Room {
	
	private Integer roomId;
	private Integer capacity;
	private String tv;
	private String balcony;
	private String conditioner;
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Room(Integer capacity, String tv, String balcony, String conditioner) {
		super();
		this.capacity = capacity;
		this.tv = tv;
		this.balcony = balcony;
		this.conditioner = conditioner;
	}
	public Room(Integer roomId, Integer capacity, String tv, String balcony, String conditioner) {
		super();
		this.roomId = roomId;
		this.capacity = capacity;
		this.tv = tv;
		this.balcony = balcony;
		this.conditioner = conditioner;
	}
}
