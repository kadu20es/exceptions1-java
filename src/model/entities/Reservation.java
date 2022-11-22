package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reservation(Integer rooNumber, Date checkin, Date checkout) {
		this.roomNumber = rooNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}


	public Integer getRooNumber() {
		return roomNumber;
	}


	public void setRooNumber(Integer rooNumber) {
		this.roomNumber = rooNumber;
	}


	public Date getCheckin() {
		return checkin;
	}


	public Date getCheckout() {
		return checkout;
	}

	
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return "Reservation"
				+ " Room: "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(this.checkin)
				+ ", check-out: "
				+ sdf.format(this.checkout)
				+ ", duration: "
				+ duration()
				+ " nights";
	}

}
