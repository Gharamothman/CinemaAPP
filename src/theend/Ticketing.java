package theend;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import static theend.UserBooking.readUserBookingFromFile;

public class Ticketing {

    private static Map<String, Integer> movieSchedule;

    public Ticketing() throws IOException {
        movieSchedule = loadMapFromFile();
        if (movieSchedule == null) {
            movieSchedule = new HashMap<>();
        }
    }

    public void print() {
        for (Map.Entry<String, Integer> entry : movieSchedule.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    private static void saveMapToFile(Map<String, Integer> map) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("bookingnew.txt"))) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                writer.write(entry.getKey() + ", " + entry.getValue());
                writer.newLine();
            }
            System.out.println("DONE , THE MAP SAVED");

        } catch (IOException e) {
            System.out.println("SOMETHING WEONG, THE MAP DOSENT OPEN.");
            e.printStackTrace();
        }
    }

    private static Map<String, Integer> loadMapFromFile() throws FileNotFoundException, IOException {
        Map<String, Integer> temp = new HashMap<>();
        File file = new File("bookingnew.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(", ");
                    if (parts.length == 2) {
                        String seatKey = parts[0];
                        int availableSeats = Integer.parseInt(parts[1]);
                        temp.put(seatKey, availableSeats);
                    }
                }
                System.out.println("DONE, THE MAP IS READ");
            }
        } else {
            System.out.println("THE FILE DOSENT EXIST  ");
        }
        return temp;
    }

    public void bookSeat(String username, String seatKey, int seatsToBook) {
        if (movieSchedule.containsKey(seatKey)) {
            int availableSeats = movieSchedule.get(seatKey);
            if (availableSeats >= seatsToBook) {
                movieSchedule.put(seatKey, availableSeats - seatsToBook);
                saveMapToFile(movieSchedule);
                showMessageBox(seatsToBook + " seats have been booked successfully.", "Reservation Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                showMessageBox("Sorry, not enough available seats in seat " + seatKey, "Reservation Failed", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            showMessageBox("Seat " + seatKey + " is not found in the map", "Reservation Failed", JOptionPane.ERROR_MESSAGE);
        }
        UserBooking.addBooking(LogeInManger.name, seatKey, seatsToBook);
    }

    public int getAvailableSeats(String seatKey) {
        return movieSchedule.getOrDefault(seatKey, 0);
    }

    public void cancelBooking(String username, String seatKey, int seatsToCancel) {
        if (movieSchedule.containsKey(seatKey)) {
            int bookedSeats = movieSchedule.get(seatKey);
            int newAvailableSeats = bookedSeats + seatsToCancel;

            if (newAvailableSeats > 10) {
                showMessageBox("you dont have this number of ticket with  " + seatKey, "Cancellation Failed", JOptionPane.ERROR_MESSAGE);
            } else {
                movieSchedule.put(seatKey, newAvailableSeats);
                saveMapToFile(movieSchedule);
                showMessageBox(seatsToCancel + " seats have been canceled successfully.", "Cancellation Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            showMessageBox("Seat " + seatKey + " is not found in the map", "Cancellation Failed", JOptionPane.ERROR_MESSAGE);
        }

        ArrayList<UserBooking> currentBookings = readUserBookingFromFile();

        for (UserBooking booking : currentBookings) {
            if (booking.getUserName().equals(username) && booking.getMovieName().equals(seatKey)) {
                if (booking.getTicketCount() >= seatsToCancel) {
                    booking.setTicketCount(booking.getTicketCount() - seatsToCancel);
                    System.out.println("Reservation canceled successfully");
                } else {
                    showMessageBox("Seat " + seatKey + "You don't have enough tickets to cancel this reservation", "Cancellation Failed", JOptionPane.ERROR_MESSAGE);
                    System.out.println("You don't have enough tickets to cancel this reservation");
                }
                break;
            }
        }

        // Save the updated list to file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("userbooking.txt"))) {
            for (UserBooking booking : currentBookings) {
                oos.writeObject(booking);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showMessageBox(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }
}
