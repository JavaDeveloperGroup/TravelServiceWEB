package by.htp.travelserviceWEB.entity.auto;

import java.io.Serializable;

public class BodyType implements Serializable {
	
	private Integer bodyTypeId;
	private String name;
	
	public BodyType() {}

	public BodyType(Integer bodyTypeId, String name) {
		this.bodyTypeId = bodyTypeId;
		this.name = name;
	}

	public Integer getBodyTypeId() {
		return bodyTypeId;
	}

	public void setBodyTypeId(Integer bodyTypeId) {
		this.bodyTypeId = bodyTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
