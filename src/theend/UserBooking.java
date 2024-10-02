package theend;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserBooking implements Serializable {

    private String userName;
    private String movieName;
    private int ticketCount;

    // Constructor
    public UserBooking(String userName, String movieName, int ticketCount) {
        this.userName = userName;
        this.movieName = movieName;
        this.ticketCount = ticketCount;

    }

    public UserBooking() {
    }

    // Getters
    public String getUserName() {
        return userName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    @Override
    public String toString() {
        return "User: " + userName + ", Movie: " + movieName + ", Tickets: " + ticketCount;
    }

    public static void saveToFile(UserBooking obj) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("userbooking.txt", true))) {
            oos.writeObject(obj);
            System.out.println("save");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<UserBooking> readUserBookingFromFile() {
        ArrayList<UserBooking> newuser = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("userbooking.txt"))) {
            while (true) {
                try {
                    UserBooking user = (UserBooking) objectInputStream.readObject();
                    newuser.add(user);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return newuser;
    }

    public static void addBooking(String userName, String movieName, int ticketCount) {
        ArrayList<UserBooking> currentBookings = readUserBookingFromFile();

        UserBooking newBooking = new UserBooking(userName, movieName, ticketCount);

        currentBookings.add(newBooking);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("userbooking.txt"))) {
            for (UserBooking booking : currentBookings) {
                oos.writeObject(booking);
            }
            System.out.println("done we add the resever");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
