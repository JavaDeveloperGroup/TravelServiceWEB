package by.htp.travelserviceWEB.entity.auto;

import java.io.Serializable;
import java.sql.Date;

import by.htp.travelserviceWEB.entity.Entity;

public class AutoOrder implements Entity, Serializable {

	private static final long serialVersionUID = 3555269189198727873L;
	
	private Integer autoOrderId;
	private Integer rentAutoId;
	private Integer salonEndId;
	private Date dateStart;
	private Date dateEnd;
	private Double orderPrice;
	
	public AutoOrder() {}

	public AutoOrder(Integer autoOrderId, Integer rentAutoId, Integer salonEndId, Date dateStart, Date dateEnd,
			Double orderPrice) {
		super();
		this.autoOrderId = autoOrderId;
		this.rentAutoId = rentAutoId;
		this.salonEndId = salonEndId;
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

	public Integer getRentAutoId() {
		return rentAutoId;
	}

	public void setRentAutoId(Integer rentAutoId) {
		this.rentAutoId = rentAutoId;
	}

	public Integer getSalonEndId() {
		return salonEndId;
	}

	public void setSalonEndId(Integer salonEndId) {
		this.salonEndId = salonEndId;
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
