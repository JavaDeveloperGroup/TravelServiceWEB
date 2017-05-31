package by.htp.travleservice.entity;

import java.sql.Date;

public class HotelOrder {
	
	private Integer hotelOrderId;
	private Date dateStart;
	private Date dateEnd;
	private Double orderPrice;
	public HotelOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HotelOrder(Date dateStart, Date dateEnd, Double orderPrice) {
		super();
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.orderPrice = orderPrice;
	}
	public HotelOrder(Integer hotelOrderId, Date dateStart, Date dateEnd, Double orderPrice) {
		super();
		this.hotelOrderId = hotelOrderId;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.orderPrice = orderPrice;
	}
}
