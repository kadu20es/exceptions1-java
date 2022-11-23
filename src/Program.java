import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException { 
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("--------- HOTEL BUENAVENTURA -----------\n"
				+ "----------------------------------------\n");
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/mm/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.println("Checkout date (dd/mm/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		
		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after checkin-in date.");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation.toString());
			
			System.out.println("\n\nEnter data to update the reservation: ");
			System.out.print("Check-in date: ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date: ");
			checkout = sdf.parse(sc.next());
			
			String error = reservation.updateDates(checkin, checkout);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println("Reservation: " + reservation);
			}
		}
		
		sc.close();

	}

}
