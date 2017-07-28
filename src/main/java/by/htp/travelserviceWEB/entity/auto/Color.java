package by.htp.travelserviceWEB.entity.auto;

import java.io.Serializable;

import by.htp.travelserviceWEB.entity.Entity;

public class Color implements Entity, Serializable {

	private static final long serialVersionUID = 386245534420143167L;
	
	private Integer colorId;
	private String name;
	
	public Color() {}

	public Color(Integer colorId, String name) {
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
