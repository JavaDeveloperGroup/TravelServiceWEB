package by.htp.travelserviceWEB.entity.hotel;

import java.io.Serializable;

import by.htp.travelserviceWEB.entity.Entity;

public class Room implements Entity, Serializable {
	
	private static final long serialVersionUID = -1767898336508143177L;
	
	private Integer roomId;
	private String tv;
	private String balcony;
	private String conditioner;
	
	public Room() {}

	public Room(Integer roomId, String tv, String balcony, String conditioner) {
		this.roomId = roomId;
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

	@Override
	public String toString() {
		return " TV " + tv + ", balcony " + balcony + ", conditioner " + conditioner + " ";
	}
	
	
	
}
