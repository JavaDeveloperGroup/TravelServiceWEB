package by.htp.travelserviceWEB.entity.auto;

import java.io.Serializable;

import by.htp.travelserviceWEB.entity.Entity;

public class BodyType implements Entity, Serializable {
	
	private static final long serialVersionUID = -3257032929240728054L;
	
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
