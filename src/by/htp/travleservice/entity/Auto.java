package by.htp.travleservice.entity;

import java.sql.Date;

public class Auto {
	
	private Integer autoId;
	private String title;
	private String model;
	private Date year;
	private String transmition;
	private String wheelDdrive;
	private String fuilType;
	private String color;
	private String bodyType;
	private String image;
	
	public Auto() {
		super();
	}

	public Auto(Integer autoId, String title, String model, Date year, String transmition, String wheelDdrive,
			String fuilType, String color, String bodyType, String image) {
		super();
		this.autoId = autoId;
		this.title = title;
		this.model = model;
		this.year = year;
		this.transmition = transmition;
		this.wheelDdrive = wheelDdrive;
		this.fuilType = fuilType;
		this.color = color;
		this.bodyType = bodyType;
		this.image = image;
	}

	public Integer getAutoId() {
		return autoId;
	}

	public void setAutoId(Integer autoId) {
		this.autoId = autoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public String getTransmition() {
		return transmition;
	}

	public void setTransmition(String transmition) {
		this.transmition = transmition;
	}

	public String getWheelDdrive() {
		return wheelDdrive;
	}

	public void setWheelDdrive(String wheelDdrive) {
		this.wheelDdrive = wheelDdrive;
	}

	public String getFuilType() {
		return fuilType;
	}

	public void setFuilType(String fuilType) {
		this.fuilType = fuilType;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
