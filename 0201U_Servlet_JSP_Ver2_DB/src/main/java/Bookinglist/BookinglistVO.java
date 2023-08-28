package Bookinglist;

import java.io.Serializable;
import java.sql.Date;

public class BookinglistVO implements java.io.Serializable {

	private Integer BOOKING_NO;
	private Integer TABLE_NO;
	private Date TABLE_DATE;
	private Integer BOOKING_CHECK_STATE;
	private Integer BOOKING_STATE;
	private Integer PERIOD_TIME;

	public Integer getBOOKING_STATE() {
		return BOOKING_STATE;
	}

	public void setBOOKING_STATE(Integer bOOKING_STATE) {
		BOOKING_STATE = bOOKING_STATE;
	}

	public Integer getBOOKING_NO() {
		return BOOKING_NO;
	}

	public void setBOOKING_NO(Integer bOOKING_NO) {
		BOOKING_NO = bOOKING_NO;
	}

	public Integer getTABLE_NO() {
		return TABLE_NO;
	}

	public void setTABLE_NO(Integer tABLE_NO) {
		TABLE_NO = tABLE_NO;
	}

	public Date getTABLE_DATE() {
		return TABLE_DATE;
	}

	public void setTABLE_DATE(Date tABLE_DATE) {
		TABLE_DATE = tABLE_DATE;
	}

	public Integer getBOOKING_CHECK_STATE() {
		return BOOKING_CHECK_STATE;
	}

	public void setBOOKING_CHECK_STATE(Integer bOOKING_CHECK_STATE) {
		BOOKING_CHECK_STATE = bOOKING_CHECK_STATE;
	}

	public Integer getPERIOD_TIME() {
		return PERIOD_TIME;
	}

	public void setPERIOD_TIME(Integer pERIOD_TIME) {
		PERIOD_TIME = pERIOD_TIME;
	}

}
