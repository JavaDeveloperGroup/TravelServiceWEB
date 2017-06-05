package by.htp.travelserviceWEB.entity;

import java.io.Serializable;
import java.sql.Date;

public class AutoOrder implements Serializable {
	
	private Integer autoOrderId;
	private Auto autoRent;
	private Salon salonEnd;
	private Date dateStart;
	private Date dateEnd;
	private Double orderPrice;
	
	public AutoOrder() {
		super();
	}

	public AutoOrder(Auto autoRent, Salon salonEnd, Date dateStart, Date dateEnd, Double orderPrice) {
		super();
		this.autoRent = autoRent;
		this.salonEnd = salonEnd;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.orderPrice = orderPrice;
	}

	public AutoOrder(Integer autoOrderId, Auto autoRent, Salon salonEnd, Date dateStart, Date dateEnd,
			Double orderPrice) {
		super();
		this.autoOrderId = autoOrderId;
		this.autoRent = autoRent;
		this.salonEnd = salonEnd;
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

	public Auto getAutoRent() {
		return autoRent;
	}

	public void setAutoRent(Auto autoRent) {
		this.autoRent = autoRent;
	}

	public Salon getSalonEnd() {
		return salonEnd;
	}

	public void setSalonEnd(Salon salonEnd) {
		this.salonEnd = salonEnd;
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
