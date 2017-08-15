package by.htp.travelserviceWEB.entity.auto;

import java.io.Serializable;

import by.htp.travelserviceWEB.entity.Entity;

public class Auto implements Entity, Serializable {

	private static final long serialVersionUID = -4441682023481983611L;
	
	private Integer autoId;
	private Integer brandId;
	private String model;
	private String year;
	private String transmition;
	private String wheelDrive;
	private String fuilType;
	private Integer colorId;
	private Integer bodyTypeId;
	private String image;
	
	public Auto() {}
	
	public Auto(Integer autoId, Integer brandId, String model, String year, String transmition, String wheelDrive,
			String fuilType, Integer colorId, Integer bodyTypeId, String image) {
		super();
		this.autoId = autoId;
		this.brandId = brandId;
		this.model = model;
		this.year = year;
		this.transmition = transmition;
		this.wheelDrive = wheelDrive;
		this.fuilType = fuilType;
		this.colorId = colorId;
		this.bodyTypeId = bodyTypeId;
		this.image = image;
	}

	public Integer getAutoId() {
		return autoId;
	}

	public void setAutoId(Integer autoId) {
		this.autoId = autoId;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
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

	public Integer getColorId() {
		return colorId;
	}

	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

	public Integer getBodyTypeId() {
		return bodyTypeId;
	}

	public void setBodyTypeId(Integer bodyTypeId) {
		this.bodyTypeId = bodyTypeId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
