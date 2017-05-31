package by.htp.travleservice.entity;

import java.sql.Date;

public class Auto {
	
	private Integer autoId;
	private String title;
	private String model;
	private Date year;
	private String transmition;
	private String wheelDdrive;
	private String fuilType;
	
	public Auto() {
		super();
	}
	
	public Auto(String title, String model, Date year, String transmition, String wheelDdrive, String fuilType) {
		super();
		this.title = title;
		this.model = model;
		this.year = year;
		this.transmition = transmition;
		this.wheelDdrive = wheelDdrive;
		this.fuilType = fuilType;
	}
	
	public Auto(Integer autoId, String title, String model, Date year, String transmition, String wheelDdrive,
			String fuilType) {
		super();
		this.autoId = autoId;
		this.title = title;
		this.model = model;
		this.year = year;
		this.transmition = transmition;
		this.wheelDdrive = wheelDdrive;
		this.fuilType = fuilType;
	}
}
