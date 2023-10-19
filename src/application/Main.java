package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();

            System.out.print("Check-in date (dd/mm/yyyy): ");
            LocalDate checkIn = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.print("Check-out date (dd/mm/yyyy):");
            LocalDate checkOut = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");

            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkIn = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.print("Check-out date (dd/mm/yyyy):");
            checkOut = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            reservation.updateDates(checkIn, checkOut);
            System.out.print("New reservation: " + reservation);
        }
        catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error...");
        }

        sc.close();
    }
}