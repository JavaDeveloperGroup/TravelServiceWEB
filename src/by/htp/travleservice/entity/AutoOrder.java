package by.htp.travleservice.entity;

import java.sql.Date;

public class AutoOrder {
	
	private Integer autoOrderId;
	private Auto auto;
	private Salon salon;
	private Date dateStart;
	private Date dateEnd;
	private Double orderPrice;
	
	public AutoOrder() {
		super();
	}

	public AutoOrder(Integer autoOrderId, Auto auto, Salon salon, Date dateStart, Date dateEnd, Double orderPrice) {
		super();
		this.autoOrderId = autoOrderId;
		this.auto = auto;
		this.salon = salon;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.orderPrice = orderPrice;
	}

	public Integer getAutoOrderId() {
		return autoOrderId;
	}

	public void setAutoOrderId(Integer autoOrderId) {
		this.autoOrderId = autoOrderId;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}
	
	
}
