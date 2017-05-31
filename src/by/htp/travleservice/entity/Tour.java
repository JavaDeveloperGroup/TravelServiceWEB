package by.htp.travleservice.entity;

public class Tour {
	
	private Integer tourId;
	private String destination;
	private String name;
	private String type;
	private String image;
	private String description;
	public Tour() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tour(String destination, String name, String type, String image, String description) {
		super();
		this.destination = destination;
		this.name = name;
		this.type = type;
		this.image = image;
		this.description = description;
	}
	public Tour(Integer tourId, String destination, String name, String type, String image, String description) {
		super();
		this.tourId = tourId;
		this.destination = destination;
		this.name = name;
		this.type = type;
		this.image = image;
		this.description = description;
	}
}
