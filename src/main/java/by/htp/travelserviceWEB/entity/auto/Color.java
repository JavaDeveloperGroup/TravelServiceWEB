package by.htp.travelserviceWEB.entity.auto;

import java.io.Serializable;

public class Color implements Serializable {
	
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
