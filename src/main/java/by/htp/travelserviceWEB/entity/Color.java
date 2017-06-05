package by.htp.travelserviceWEB.entity;

import java.io.Serializable;

public class Color implements Serializable {
	
	private Integer colorId;
	private String name;
	
	public Color() {
		super();
	}

	public Color(String name) {
		super();
		this.name = name;
	}

	public Color(Integer colorId, String name) {
		super();
		this.colorId = colorId;
		this.name = name;
	}

	public Integer getColorId() {
		return colorId;
	}

	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
