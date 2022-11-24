package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	// construtor
	public Reservation(Integer rooNumber, Date checkin, Date checkout) throws DomainException {
		if (!checkout.after(checkin)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
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
	
	public void updateDates(Date checkin, Date checkout) throws DomainException {
		
		Date now = new Date();
		if (checkin.before(now) || checkout.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
			//throw new IllegalArgumentException("Reservation dates for update must be future dates");
		}
		
		if (!checkout.after(checkin)){
			throw new DomainException("Check-out date must be after checkin-in date");
			// throw new IllegalArgumentException("Reservation dates for update must be future dates");
		}
		
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
