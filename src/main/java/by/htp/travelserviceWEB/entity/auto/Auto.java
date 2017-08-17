package by.htp.travelserviceWEB.entity.auto;

import java.io.Serializable;

import by.htp.travelserviceWEB.entity.Entity;

public class Auto implements Entity, Serializable {

	private static final long serialVersionUID = -4441682023481983611L;
	
	private Integer autoId;
	private String brand;
	private String model;
	private String year;
	private String transmition;
	private String wheelDrive;
	private String fuilType;
	private String color;
	private String bodyType;
	private String image;
	
	public Auto() {}

	public Auto(Integer autoId, String brand, String model, String year, String transmition, String wheelDrive,
			String fuilType, String color, String bodyType, String image) {
		super();
		this.autoId = autoId;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.transmition = transmition;
		this.wheelDrive = wheelDrive;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTransmition() {
		return transmition;
	}

	public void setTransmition(String transmition) {
		this.transmition = transmition;
	}

	public String getWheelDrive() {
		return wheelDrive;
	}

	public void setWheelDrive(String wheelDrive) {
		this.wheelDrive = wheelDrive;
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
