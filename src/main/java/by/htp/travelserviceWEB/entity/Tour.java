package by.htp.travelserviceWEB.entity;

import java.io.Serializable;

public class Tour implements Serializable {
	
	private Integer tourId;
	private String destination;
	private String name;
	private String type;
	private String description;
	private String image;
	
	public Tour() {}

	public Tour(Integer tourId, String destination, String name, String type, String description, String image) {
		this.tourId = tourId;
		this.destination = destination;
		this.name = name;
		this.type = type;
		this.description = description;
		this.image = image;
	}

	public Integer getTourId() {
		return tourId;
	}

	public void setTourId(Integer tourId) {
		this.tourId = tourId;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
