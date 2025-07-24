import java.util.ArrayList;
import java.util.Scanner;

class Booking {
    String patientName;
    String doctorName;
    String date;
    String time;

    Booking(String patientName, String doctorName, String date, String time) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Patient: " + patientName + ", Doctor: " + doctorName +
               ", Date: " + date + ", Time: " + time;
    }
}

public class MedicalBookingSystem {

    static ArrayList<Booking> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        System.out.println("🏥 Welcome to Medical Booking System");
        System.out.println("My project for devops");

        do {
            System.out.println("\n1. Book Appointment");
            System.out.println("2. View Bookings");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt(); sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> bookAppointment();
                case 2 -> viewBookings();
                case 3 -> System.out.println("Thank you for using the system.");
                default -> System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 3);
    }

    static void bookAppointment() {
        System.out.print("Enter patient name: ");
        String patient = sc.nextLine();

        System.out.print("Enter doctor name: ");
        String doctor = sc.nextLine();

        System.out.print("Enter date (e.g., 2025-08-01): ");
        String date = sc.nextLine();

        System.out.print("Enter time (e.g., 10:30 AM): ");
        String time = sc.nextLine();

        bookings.add(new Booking(patient, doctor, date, time));
        System.out.println("✅ Appointment booked successfully.");
    }

    static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("❌ No bookings available.");
        } else {
            System.out.println("\n📋 Appointment List:");
            for (int i = 0; i < bookings.size(); i++) {
                System.out.println((i + 1) + ". " + bookings.get(i));
            }
        }
    }
}
