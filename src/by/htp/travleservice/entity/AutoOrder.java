package by.htp.travleservice.entity;

import java.sql.Date;

public class AutoOrder {
	
	private Integer autoOrderId;
	private Date dateStart;
	private Date dateEnd;
	private Double orderPrice;
	
	public AutoOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AutoOrder(Date dateStart, Date dateEnd, Double orderPrice) {
		super();
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.orderPrice = orderPrice;
	}

	public AutoOrder(Integer autoOrderId, Date dateStart, Date dateEnd, Double orderPrice) {
		super();
		this.autoOrderId = autoOrderId;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.orderPrice = orderPrice;
	}
}
