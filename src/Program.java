import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("--------- HOTEL BUENAVENTURA -----------\n" 
			+ "----------------------------------------\n");
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/mm/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.println("Checkout date (dd/mm/yyyy): ");
			Date checkout = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation.toString());
	
			System.out.println("\n\nEnter data to update the reservation: ");
			System.out.print("Check-in date: ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date: ");
			checkout = sdf.parse(sc.next());
	
			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
		} 
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		//catch (IllegalArgumentException e) {
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid characters for date. Please, enter date with numbers and slashes (dd/MM/yyyy)");
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();

	}

}
