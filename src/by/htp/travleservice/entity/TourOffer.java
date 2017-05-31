package by.htp.travleservice.entity;

import java.sql.Date;

public class TourOffer {
	
	private Integer offerId;
	private Date dateStart;
	private Date dateEnd;
	private Integer capacity;
	private Double price;
	private String hot;
	public TourOffer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TourOffer(Date dateStart, Date dateEnd, Integer capacity, Double price, String hot) {
		super();
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.capacity = capacity;
		this.price = price;
		this.hot = hot;
	}
	public TourOffer(Integer offerId, Date dateStart, Date dateEnd, Integer capacity, Double price, String hot) {
		super();
		this.offerId = offerId;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.capacity = capacity;
		this.price = price;
		this.hot = hot;
	}
}
