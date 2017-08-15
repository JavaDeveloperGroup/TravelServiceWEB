package by.htp.travelserviceWEB.entity.auto;

import java.io.Serializable;

import by.htp.travelserviceWEB.entity.Entity;

public class Brand implements Entity, Serializable {

	private static final long serialVersionUID = 386245534420143167L;
	
	private Integer brandId;
	private String name;
	
	public Brand() {}

	public Brand(Integer brandId, String name) {
		super();
		this.brandId = brandId;
		this.name = name;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
