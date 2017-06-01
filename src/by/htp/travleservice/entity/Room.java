package by.htp.travleservice.entity;

public class Room {
	
	private Integer roomId;
	private Integer capacity;
	private String tv;
	private String balcony;
	private String conditioner;
	
	public Room() {
		super();
	}

	public Room(Integer roomId, Integer capacity, String tv, String balcony, String conditioner) {
		super();
		this.roomId = roomId;
		this.capacity = capacity;
		this.tv = tv;
		this.balcony = balcony;
		this.conditioner = conditioner;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getTv() {
		return tv;
	}

	public void setTv(String tv) {
		this.tv = tv;
	}

	public String getBalcony() {
		return balcony;
	}

	public void setBalcony(String balcony) {
		this.balcony = balcony;
	}

	public String getConditioner() {
		return conditioner;
	}

	public void setConditioner(String conditioner) {
		this.conditioner = conditioner;
	}
	
}
